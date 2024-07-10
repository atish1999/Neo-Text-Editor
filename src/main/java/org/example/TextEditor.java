package org.example;

import java.io.IOException;
import org.example.library.LibTerminalRawMode;
import org.example.service.TerminalRawModeService;

public class TextEditor {

  public static void main(String[] args) throws IOException {

    TerminalRawModeService terminalRawModeService =
        new TerminalRawModeService(LibTerminalRawMode.newInstance());

    terminalRawModeService.enableRawMode();

    while (true) {

      int read = System.in.read();
      if (read == 'q') {
        System.exit(0);
      }
    }
  }
}
