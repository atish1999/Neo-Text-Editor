package org.example;

import java.io.IOException;
import org.example.library.LibCTerminal;
import org.example.service.TerminalService;

public class TextEditor {

  public static void main(String[] args) throws IOException {
    init();
  }

  private static void init() throws IOException {
    TerminalService terminalService = new TerminalService(LibCTerminal.newInstance());

    Runtime.getRuntime().addShutdownHook(new Thread(terminalService::disableRawMode));

    terminalService.refreshScreen();
    terminalService.enableRawMode();

    while (true) {

      terminalService.refreshScreen();
      int read = System.in.read();
      System.out.println("key : " + (char) read + " -> " + read);
      if (read == 113) {
        System.exit(0);
      }
    }
  }
}
