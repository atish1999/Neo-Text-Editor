package org.example.service;

import static org.example.constant.GlobalConstants.TTY_FILE_DESCRIPTOR;
import static org.example.constant.TermiosConstants.*;

import java.io.IOException;
import org.example.library.LibTerminalRawMode;
import org.example.model.cnative.Termios;
import sun.misc.Signal;
import sun.misc.SignalHandler;

public class TerminalRawModeService {

  private final LibTerminalRawMode libTerminalRawMode;
  private final Termios termios;
  private Termios initialTermios;

  public TerminalRawModeService(final LibTerminalRawMode libTerminalRawMode) {
    this.libTerminalRawMode = libTerminalRawMode;
    this.termios = new Termios();
  }

  private void handleCtrlC() {
    Signal.handle(
        new Signal("INT"),
        new SignalHandler() {
          public void handle(Signal sig) {
            disableRawMode();
            System.exit(0);
          }
        });
  }

  private void handleCtrlZ() {
    Signal.handle(
        new Signal("TSTP"),
        new SignalHandler() {
          public void handle(Signal sig) {
            disableRawMode();
            try {
              // Suspend the process
              Runtime.getRuntime()
                  .exec(new String[] {"sh", "-c", "kill -STOP " + ProcessHandle.current().pid()});
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
        });
  }

  public void enableRawMode() {

    /*----------------getting the terminal state in the termios object-----------------------------*/

    boolean isatty = libTerminalRawMode.isatty(TTY_FILE_DESCRIPTOR) == 1;

    if (!isatty) {
      System.out.println("StdIn is not a terminal device ....");
    }

    libTerminalRawMode.tcgetattr(TTY_FILE_DESCRIPTOR, termios);

    initialTermios = Termios.of(termios);

    int exitCode = setTerminalAttributes();

    if (exitCode != 0) {
      throw new RuntimeException("Unable to set terminal into RAW mode");
    }
  }

  private int setTerminalAttributes() {

    /*----------------setting the flags to enter into raw mode-----------------------------*/
    termios.c_iflag &= ~(BRKINT | ICRNL | INPCK | ISTRIP | IXON);
    termios.c_oflag &= ~(OPOST);
    termios.c_cflag |= (CS8);
    termios.c_lflag &= ~(ECHO | ICANON | IEXTEN | ISIG);

    termios.c_cc[VMIN] = 0;
    termios.c_cc[VTIME] = 1;

    /*----------------trying to set the terminal state-----------------------------*/
    return libTerminalRawMode.tcsetattr(TTY_FILE_DESCRIPTOR, TCSAFLUSH, termios);
  }

  public void disableRawMode() {
    int exitCode = libTerminalRawMode.tcsetattr(TTY_FILE_DESCRIPTOR, TCSANOW, initialTermios);

    if (exitCode != 0) {
      throw new RuntimeException("Unable to disable terminal RAW mode");
    }

    System.out.println("Disabled RAW Mode successfully");
  }
}
