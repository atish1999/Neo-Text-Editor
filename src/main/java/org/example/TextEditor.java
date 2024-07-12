package org.example;

import java.io.IOException;
import org.example.library.LibTerminalRawMode;
import org.example.service.TerminalRawModeService;

public class TextEditor {

  public static void main(String[] args) throws IOException {
    init();
  }

  private static void init() throws IOException {
    TerminalRawModeService terminalRawModeService =
        new TerminalRawModeService(LibTerminalRawMode.newInstance());

    Runtime.getRuntime().addShutdownHook(new Thread(terminalRawModeService::disableRawMode));

    terminalRawModeService.enableRawMode();

    while (true) {

      int read = System.in.read();
      System.out.println("key : " + (char) read + " -> " + read);
      if (read == 113) {
        System.exit(0);
      }
    }
  }
}
