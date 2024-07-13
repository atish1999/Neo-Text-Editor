package org.example.constant;

import com.sun.jna.Platform;

public class GlobalConstants {
  public static final String LIBRARY_NAME = Platform.isWindows() ? "msvcrt" : "c";
  public static final int TTY_FILE_DESCRIPTOR = 0;
}
