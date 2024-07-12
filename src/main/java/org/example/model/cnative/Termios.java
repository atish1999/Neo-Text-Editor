package org.example.model.cnative;

import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Termios extends Structure {
  public int c_iflag;
  public int c_oflag;
  public int c_cflag;
  public int c_lflag;
  public byte[] c_cc = new byte[20];

  @Override
  protected List<String> getFieldOrder() {
    return Arrays.asList("c_iflag", "c_oflag", "c_cflag", "c_lflag", "c_cc");
  }

  public static Termios of(final Termios termios) {

    return Termios.builder()
        .c_iflag(termios.getC_iflag())
        .c_oflag(termios.getC_oflag())
        .c_cflag(termios.getC_cflag())
        .c_lflag(termios.getC_lflag())
        .c_cc(termios.getC_cc().clone())
        .build();
  }
}
