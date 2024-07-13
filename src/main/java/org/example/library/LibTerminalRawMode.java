package org.example.library;

import static org.example.constant.GlobalConstants.LIBRARY_NAME;

import com.sun.jna.LastErrorException;
import com.sun.jna.Library;
import com.sun.jna.Native;
import org.example.model.cnative.Termios;

public interface LibTerminalRawMode extends Library {

  LibTerminalRawMode INSTANCE = Native.load(LIBRARY_NAME, LibTerminalRawMode.class);

  static LibTerminalRawMode newInstance() {
    return INSTANCE;
  }

  int tcgetattr(int fildes, Termios termios_p) throws LastErrorException;

  int tcsetattr(int fildes, int optional_actions, Termios termios_p) throws LastErrorException;

  int isatty(int fd);
}
