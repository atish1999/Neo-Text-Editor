package org.example.service;

import static org.example.constant.GlobalConstants.TTY_FILE_DESCRIPTOR;
import static org.example.constant.TermiosConstants.*;

import org.example.library.LibTerminalRawMode;
import org.example.model.cnative.Termios;

public class TerminalRawModeService {

  private final LibTerminalRawMode libTerminalRawMode;
  private final Termios termios;
  private Termios initialTermios;

  public TerminalRawModeService(final LibTerminalRawMode libTerminalRawMode) {
    this.libTerminalRawMode = libTerminalRawMode;
    this.termios = new Termios();
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
