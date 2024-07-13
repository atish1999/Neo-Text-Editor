package org.example.constant;

public class TermiosConstants {

  // Special Control Characters
  public static final int VEOF = 0; // ICANON
  public static final int VEOL = 1; // ICANON
  public static final int VEOL2 = 2; // ICANON together with IEXTEN
  public static final int VERASE = 3; // ICANON
  public static final int VWERASE = 4; // ICANON together with IEXTEN
  public static final int VKILL = 5; // ICANON
  public static final int VREPRINT = 6; // ICANON together with IEXTEN
  public static final int VINTR = 8; // ISIG
  public static final int VQUIT = 9; // ISIG
  public static final int VSUSP = 10; // ISIG
  public static final int VDSUSP = 11; // ISIG together with IEXTEN
  public static final int VSTART = 12; // IXON, IXOFF
  public static final int VSTOP = 13; // IXON, IXOFF
  public static final int VLNEXT = 14; // IEXTEN
  public static final int VDISCARD = 15; // IEXTEN
  public static final int VMIN = 16; // !ICANON
  public static final int VTIME = 17; // !ICANON
  public static final int VSTATUS = 18; // ICANON together with IEXTEN
  public static final int NCCS = 20;

  // Input flags - software input processing
  public static final int IGNBRK = 0x00000001; // ignore BREAK condition
  public static final int BRKINT = 0x00000002; // map BREAK to SIGINTR
  public static final int IGNPAR = 0x00000004; // ignore (discard) parity errors
  public static final int PARMRK = 0x00000008; // mark parity and framing errors
  public static final int INPCK = 0x00000010; // enable checking of parity errors
  public static final int ISTRIP = 0x00000020; // strip 8th bit off chars
  public static final int INLCR = 0x00000040; // map NL into CR
  public static final int IGNCR = 0x00000080; // ignore CR
  public static final int ICRNL = 0x00000100; // map CR to NL (ala CRMOD)
  public static final int IXON = 0x00000200; // enable output flow control
  public static final int IXOFF = 0x00000400; // enable input flow control
  public static final int IXANY = 0x00000800; // any char will restart after stop
  public static final int IMAXBEL = 0x00002000; // ring bell on input queue full
  public static final int IUTF8 = 0x00004000; // maintain state for UTF-8 VERASE

  // Output flags - software output processing
  public static final int OPOST = 0x00000001; // enable following output processing
  public static final int ONLCR = 0x00000002; // map NL to CR-NL (ala CRMOD)
  public static final int OXTABS = 0x00000004; // expand tabs to spaces
  public static final int ONOEOT = 0x00000008; // discard EOT's (^D) on output

  // Control flags - hardware control of terminal
  public static final int CIGNORE = 0x00000001; // ignore control flags
  public static final int CSIZE = 0x00000300; // character size mask
  public static final int CS5 = 0x00000000; // 5 bits (pseudo)
  public static final int CS6 = 0x00000100; // 6 bits
  public static final int CS7 = 0x00000200; // 7 bits
  public static final int CS8 = 0x00000300; // 8 bits
  public static final int CSTOPB = 0x00000400; // send 2 stop bits
  public static final int CREAD = 0x00000800; // enable receiver
  public static final int PARENB = 0x00001000; // parity enable
  public static final int PARODD = 0x00002000; // odd parity, else even
  public static final int HUPCL = 0x00004000; // hang up on last close
  public static final int CLOCAL = 0x00008000; // ignore modem status lines
  public static final int CCTS_OFLOW = 0x00010000; // CTS flow control of output

  public static final int CRTS_IFLOW = 0x00020000; // RTS flow control of input
  public static final int CRTSCTS = (CCTS_OFLOW | CRTS_IFLOW);

  public static final int CDTR_IFLOW = 0x00040000; // DTR flow control of input
  public static final int CDSR_OFLOW = 0x00080000; // DSR flow control of output
  public static final int CCAR_OFLOW = 0x00100000; // DCD flow control of output
  public static final int MDMBUF = 0x00100000; // old name for CCAR_OFLOW

  // "Local" flags - dumping ground for other state
  public static final int ECHOKE = 0x00000001; // visual erase for line kill
  public static final int ECHOE = 0x00000002; // visually erase chars
  public static final int ECHOK = 0x00000004; // echo NL after line kill
  public static final int ECHO = 0x00000008; // enable echoing
  public static final int ECHONL = 0x00000010; // echo NL even if ECHO is off
  public static final int ECHOPRT = 0x00000020; // visual erase mode for hardcopy
  public static final int ECHOCTL = 0x00000040; // echo control chars as ^(Char)
  public static final int ISIG = 0x00000080; // enable signals INTR, QUIT, [D]SUSP
  public static final int ICANON = 0x00000100; // canonicalize input lines
  public static final int ALTWERASE = 0x00000200; // use alternate WERASE algorithm
  public static final int IEXTEN = 0x00000400; // enable DISCARD and LNEXT
  public static final int EXTPROC = 0x00000800; // external processing
  public static final int TOSTOP = 0x00400000; // stop background jobs from output
  public static final int FLUSHO = 0x00800000; // output being flushed (state)
  public static final int NOKERNINFO = 0x02000000; // no kernel output from VSTATUS
  public static final int PENDIN = 0x20000000; // retype pending input (state)
  public static final int NOFLSH = 0x80000000; // don't flush after interrupt

  // Standard speeds
  public static final int B0 = 0;
  public static final int B50 = 50;
  public static final int B75 = 75;
  public static final int B110 = 110;
  public static final int B134 = 134;
  public static final int B150 = 150;
  public static final int B200 = 200;
  public static final int B300 = 300;
  public static final int B600 = 600;
  public static final int B1200 = 1200;
  public static final int B1800 = 1800;
  public static final int B2400 = 2400;
  public static final int B4800 = 4800;
  public static final int B9600 = 9600;
  public static final int B19200 = 19200;
  public static final int B38400 = 38400;
  public static final int B7200 = 7200;
  public static final int B14400 = 14400;
  public static final int B28800 = 28800;
  public static final int B57600 = 57600;
  public static final int B76800 = 76800;
  public static final int B115200 = 115200;
  public static final int B230400 = 230400;
  public static final int EXTA = 19200;
  public static final int EXTB = 38400;

  // Modem lines
  public static final int TIOCM_LE = 0x0001;
  public static final int TIOCM_DTR = 0x0002;
  public static final int TIOCM_RTS = 0x0004;
  public static final int TIOCM_ST = 0x0008;
  public static final int TIOCM_SR = 0x0010;
  public static final int TIOCM_CTS = 0x0020;
  public static final int TIOCM_CAR = 0x0040;
  public static final int TIOCM_CD = TIOCM_CAR;
  public static final int TIOCM_RNG = 0x0080;
  public static final int TIOCM_RI = TIOCM_RNG;
  public static final int TIOCM_DSR = 0x0100;
  public static final int TIOCM_DTR_X = 0x0200; // added for better consistency with other macros

  // Additional constants
  public static final int TCIFLUSH = 1;
  public static final int TCOFLUSH = 2;
  public static final int TCIOFLUSH = 3;
  public static final int TCOOFF = 1;
  public static final int TCOON = 2;
  public static final int TCIOFF = 3;
  public static final int TCION = 4;

  public static final int TCSANOW = 0; // make change immediate
  public static final int TCSADRAIN = 1; // drain output, then change
  public static final int TCSAFLUSH = 2; // drain output, flush input
  public static final int TCSASOFT =
      0x10; // flag - don't alter h.w. state (defined if _POSIX_C_SOURCE is not defined or if
  // _DARWIN_C_SOURCE is defined)
}
