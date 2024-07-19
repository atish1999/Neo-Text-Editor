package org.example.service;

import static org.example.constant.GlobalConstants.TIOCGWINSZ;
import static org.example.constant.GlobalConstants.TTY_FILE_DESCRIPTOR;
import static org.example.constant.TermiosConstants.*;

import com.sun.jna.NativeLong;
import java.util.Optional;
import org.example.library.LibCTerminal;
import org.example.model.cnative.Termios;
import org.example.model.cnative.WinSize;

public class TerminalService {

  private final LibCTerminal libCTerminal;
  private final Termios termios;
  private Termios initialTermios;
  private WinSize winSize;

  public TerminalService(final LibCTerminal libCTerminal) {
    this.libCTerminal = libCTerminal;
    this.termios = new Termios();
    getScreenDetails();
  }

  public void enableRawMode() {

    /*----------------getting the terminal state in the termios object-----------------------------*/

    boolean isatty = libCTerminal.isatty(TTY_FILE_DESCRIPTOR) == 1;

    if (!isatty) {
      System.out.println("StdIn is not a terminal device ....");
    }

    libCTerminal.tcgetattr(TTY_FILE_DESCRIPTOR, termios);

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
    termios.c_lflag &= ~(ECHO | ECHONL | ICANON | IEXTEN | ISIG);

    termios.c_cc[VMIN] = 0;
    termios.c_cc[VTIME] = 1;

    /*----------------trying to set the terminal state-----------------------------*/
    return libCTerminal.tcsetattr(TTY_FILE_DESCRIPTOR, TCSANOW, termios);
  }

  public void disableRawMode() {
    int exitCode = libCTerminal.tcsetattr(TTY_FILE_DESCRIPTOR, TCSANOW, initialTermios);

    if (exitCode != 0) {
      throw new RuntimeException("Unable to disable terminal RAW mode");
    }

    System.out.println("Disabled RAW Mode successfully");
  }

  public void getScreenDetails() {

    final WinSize winSize = WinSize.builder().build();
    final NativeLong request = new NativeLong(TIOCGWINSZ, true);
    int exitCode = libCTerminal.ioctl(TTY_FILE_DESCRIPTOR, request, winSize);

    if (exitCode != 0) {
      System.err.println("\033[31m Sorry Unable to get screen information \033[0m");
      System.exit(exitCode);
    }

    this.winSize = WinSize.of(winSize);
  }

  public void refreshScreen() {

    final Optional<WinSize> optionalWinSize =
        Optional.ofNullable(winSize)
            .filter(_winSize -> _winSize.getWs_row() != 0 && _winSize.getWs_col() != 0);

    if (optionalWinSize.isEmpty()) {
      System.err.println("\033[31m Please get the correct window size details \033[0m");
      System.exit(1);
    }

    clearScreen();
    System.out.println("Neo-Text-Editor-1.0");
    for (short row = 0; row < winSize.getWs_row() - 1; ++row) {
      System.out.println("~\r\n");
    }
  }

  private void clearScreen() {
    System.out.println("\033[2J");
    System.out.println("\033[5H");
  }
}
