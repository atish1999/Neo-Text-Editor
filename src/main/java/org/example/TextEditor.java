package org.example;

import org.example.library.LibTerminalRawMode;
import org.example.model.cnative.Termios;

public class TextEditor {

  public static void main(String[] args) {

    LibTerminalRawMode terminalRawMode = LibTerminalRawMode.newInstance();
    Termios termiosP = new Termios();
    terminalRawMode.tcgetattr(LibTerminalRawMode.SYSTEM_OUT_FD, termiosP);
  }
}
