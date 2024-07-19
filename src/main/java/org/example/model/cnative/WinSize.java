package org.example.model.cnative;

import com.sun.jna.Structure;
import java.util.List;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WinSize extends Structure {
  public short ws_row;
  public short ws_col;
  public short ws_xpixel;
  public short ws_ypixel;

  @Override
  protected List<String> getFieldOrder() {
    return List.of("ws_row", "ws_col", "ws_xpixel", "ws_ypixel");
  }

  public static WinSize of(final WinSize winSize) {
    return WinSize.builder()
        .ws_row(winSize.getWs_row())
        .ws_col(winSize.getWs_col())
        .ws_xpixel(winSize.getWs_xpixel())
        .ws_ypixel(winSize.getWs_ypixel())
        .build();
  }
}
