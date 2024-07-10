package org.example.library;

import static org.example.constant.GlobalConstants.LIBRARY_NAME;

import com.sun.jna.LastErrorException;
import com.sun.jna.Library;
import com.sun.jna.Native;
import org.example.model.cnative.Termios;

public interface LibTerminalRawMode extends Library {

  int SYSTEM_OUT_FD = 0;
  int ISIG = 1,
      ICANON = 2,
      ECHO = 10,
      TCSAFLUSH = 2,
      IXON = 2000,
      ICRNL = 400,
      IEXTEN = 100000,
      OPOST = 1,
      VMIN = 6,
      VTIME = 5,
      TIOCGWINSZ = 0x5413;

  LibTerminalRawMode INSTANCE = Native.load(LIBRARY_NAME, LibTerminalRawMode.class);

  static LibTerminalRawMode newInstance() {
    return INSTANCE;
  }

  int tcgetattr(int fildes, Termios termios_p) throws LastErrorException;

  int tcsetattr(int fildes, int optional_actions, Termios termios_p) throws LastErrorException;
}
