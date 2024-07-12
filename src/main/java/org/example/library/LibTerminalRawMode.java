package org.example.library;

import static org.example.constant.GlobalConstants.LIBRARY_NAME;

import com.sun.jna.LastErrorException;
import com.sun.jna.Library;
import com.sun.jna.Native;
import org.example.model.cnative.Termios;

public interface LibTerminalRawMode extends Library {

  int SYSTEM_OUT_FD = 0;

  /*--------------------- LINE_CONTROL -----------------------*/
  int TCSANOW = 0; /* make change immediate */
  int TCSAFLUSH = 2; /* drain output, flush input */

  /*--------------------- CONTROL_CHARS -----------------------*/
  int VMIN = 16, /* !ICANON */ VTIME = 17; /* !ICANON */

  /*--------------------- INPUT_FLAGS -----------------------*/
  int IGNBRK = 0x00000001, /* ignore BREAK condition */
      BRKINT = 0x00000002, /* map BREAK to SIGINTR */
      PARMRK = 0x00000008, /* mark parity and framing errors */
      ISTRIP = 0x00000020, /* strip 8th bit off chars */
      INLCR = 0x00000040, /* map NL into CR */
      IGNCR = 0x00000080, /* ignore CR */
      ICRNL = 0x00000100, /* map CR to NL (ala CRMOD) */
      IXON = 0x00000200, /* enable output flow control */
      INPCK = 0x00000010, /* enable checking of parity errors */

      /*--------------------- OUTPUT_FLAGS -----------------------*/
      OPOST = 0x00000001, /* enable following output processing */

      /*--------------------- LOCAL_FLAGS -----------------------*/

      ECHO = 0x00000008, /* enable echoing */
      ECHONL = 0x00000010, /* echo NL even if ECHO is off */
      ICANON = 0x00000100, /* canonicalize input lines */
      ISIG = 0x00000080, /* enable signals INTR, QUIT, [D]SUSP */
      IEXTEN = 0x00000400, /* enable DISCARD and LNEXT */

      /*--------------------- CONTROL_FLAGS -----------------------*/

      CSIZE = 0x00000300, /* character size mask */
      PARENB = 0x00001000, /* parity enable */
      CS8 = 0x00000300 /* 8 bits */;

  LibTerminalRawMode INSTANCE = Native.load(LIBRARY_NAME, LibTerminalRawMode.class);

  static LibTerminalRawMode newInstance() {
    return INSTANCE;
  }

  int tcgetattr(int fildes, Termios termios_p) throws LastErrorException;

  int tcsetattr(int fildes, int optional_actions, Termios termios_p) throws LastErrorException;

  int isatty(int fd);
}
