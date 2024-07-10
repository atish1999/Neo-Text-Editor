package org.example.library;

import static org.example.constant.GlobalConstants.LIBRARY_NAME;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface CMath extends Library {

  CMath cMathInstance = Native.load(LIBRARY_NAME, CMath.class);

  static CMath newInstance() {
    return cMathInstance;
  }

  double cosh(double input);
}
