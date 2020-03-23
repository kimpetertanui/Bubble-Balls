package com.example.util;

import android.graphics.Canvas;
import android.graphics.Rect;

public class BubbleFont {
  private char[] characters = {
    '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*',
    '+', ',', '-', '.', '/', '0', '1', '2', '3', '4',
    '5', '6', '7', '8', '9', ':', ';', '<', '=', '>',
    '?', '@', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
    'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
    's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '|', '{',
    '}', '[', ']', ' ', '\\', ' ', ' '};

  private int[] position  = {
    0, 9, 16, 31, 39, 54, 69, 73, 80, 88, 96, 116, 121, 131,
    137, 154, 165, 175, 187, 198, 210, 223, 234, 246, 259,
    271, 276, 282, 293, 313, 324, 336, 351, 360, 370, 381,
    390, 402, 411, 421, 435, 446, 459, 472, 483, 495, 508,
    517, 527, 538, 552, 565, 578, 589, 602, 616, 631, 645,
    663, 684, 700, 716, 732, 748, 764, 780, 796, 812 };

  public int SEPARATOR_WIDTH = 1;
  public int SPACE_CHAR_WIDTH = 6;

  private BmpWrap fontMap;
  private Rect clipRect;

  public BubbleFont(BmpWrap fontMap)
  {
    this.fontMap = fontMap;
    clipRect = new Rect();
  }

  public final void print(String s, int x, int y, Canvas canvas,
                         double scale, int dx, int dy)
  {
    int len = s.length();
    for (int i = 0; i < len; i++) {
      char c = s.charAt(i);
      x += paintChar(c, x, y, canvas, scale, dx, dy);
    }
  }

  public final int paintChar(char c, int x, int y, Canvas canvas,
                             double scale, int dx, int dy)
  {
    if (c == ' ') {
      return SPACE_CHAR_WIDTH + SEPARATOR_WIDTH;
    }
    int index = getCharIndex(c);
    if (index == -1) {
      return 0;
    }
    int imageWidth = position[index+1]-position[index];

    clipRect.left = x;
    clipRect.right = x + imageWidth;
    clipRect.top = y;
    clipRect.bottom = y + 50;
    Sprite.drawImageClipped(fontMap, x - position[index], y, clipRect,
                            canvas, scale, dx+390, dy+22);

    return imageWidth + SEPARATOR_WIDTH;
  }

  private final int getCharIndex(char c)
  {
    for (int i=0 ; i<characters.length ; i++) {
      if (characters[i] == c) {
        return i;
      }
    }

    return -1;
  }
}

