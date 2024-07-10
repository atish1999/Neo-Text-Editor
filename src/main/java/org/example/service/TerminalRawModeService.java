package org.example.service;

import org.example.library.LibTerminalRawMode;
import org.example.model.cnative.Termios;

public class TerminalRawModeService {

  private final LibTerminalRawMode libTerminalRawMode;
  private final Termios termios;

  public TerminalRawModeService(final LibTerminalRawMode libTerminalRawMode) {
    this.libTerminalRawMode = libTerminalRawMode;
    this.termios = new Termios();
  }

  public void enableRawMode() {

    /*----------------getting the terminal state in the termios object-----------------------------*/
    libTerminalRawMode.tcgetattr(LibTerminalRawMode.SYSTEM_OUT_FD, termios);

    /*----------------setting the flags to enter into raw mode-----------------------------*/
    termios.c_lflag &=
        ~(LibTerminalRawMode.ECHO
            | LibTerminalRawMode.ICANON
            | LibTerminalRawMode.IEXTEN
            | LibTerminalRawMode.ISIG);
    termios.c_iflag &= ~(LibTerminalRawMode.IXON | LibTerminalRawMode.ICRNL);
    termios.c_oflag &= ~(LibTerminalRawMode.OPOST);

    termios.c_cc[LibTerminalRawMode.VMIN] = 0;
    termios.c_cc[LibTerminalRawMode.VTIME] = 1;

    /*----------------trying to set the terminal state-----------------------------*/
    libTerminalRawMode.tcsetattr(
        LibTerminalRawMode.SYSTEM_OUT_FD, LibTerminalRawMode.TCSANOW, termios);
  }

  public void disableRawMode() {}
}
