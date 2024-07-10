package org.example.constant;

import com.sun.jna.Platform;

public class GlobalConstants {
  public static final String LIBRARY_NAME = Platform.isWindows() ? "msvcrt" : "c";
}
