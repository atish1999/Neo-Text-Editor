package org.example.library;

import static org.example.constant.GlobalConstants.LIBRARY_NAME;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface CString extends Library {
  CString cStringInstance = Native.load(LIBRARY_NAME, CString.class);

  static CString newInstance() {
    return cStringInstance;
  }

  int strcmp(String s1, String s2);

  int strncmp(String s1, String s2, int n);
}
