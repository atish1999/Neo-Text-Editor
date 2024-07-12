package org.example.library;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

public interface LibC extends Library {

  LibC INSTANCE = Native.load(Platform.C_LIBRARY_NAME, LibC.class);
}
