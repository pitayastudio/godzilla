package com.pitayastudio.godzilla.common;

/**
 * Position state chars for viewing purpose.
 *
 * <p>Note: using char (instead of enum) is better when switch-case is needed to process char input.
 *
 * <p>Useful unicodes:
 * <pre>
 * Markers with inconsistent widths:
 * (These markers are not defined/used yet.)
 *
 * ⚫⚫⚫⚫⚫ U+26AB MEDIUM BLACK CIRCLE
 * ⚪⚪⚪⚪⚪ U+26AA MEDIUM WHITE CIRCLE
 * ➀➀➀➀➀ ~ ➉ U+2780 ~ 2789
 * ➊➊➊➊➊ ~ ➓ U+278A ~ 2793
 * 劫劫劫劫劫
 * 死死死死死
 * ╋╋╋╋╋ U+254B
 * △△△△△ U+25B3
 * ▽▽▽▽▽ U+25BD
 *
 * Markers with consistent widths:
 * (These markers are defined below.)
 *
 * ◦◦◦◦◦  U+25E6
 * ▪▪▪▪▪  U+25AA
 * ▫▫▫▫▫  U+25AB
 * ▴▴▴▴▴  U+25B4
 * •••••  U+2022.
 * θθθθθ  U+03B8
 * κκκκκ  U+03BA
 *
 * ●●●●●  U+25CF
 * ◆◆◆◆◆  U+25C6
 * ▲▲▲▲▲  U+25B2
 * ▼▼▼▼▼  U+25BC. Not used.
 * ○○○○○  U+25CB
 * ◇◇◇◇◇  U+25C7
 * ◬◬◬◬◬  U+25EC
 *
 * δδδδδ  U+03B4. Delta. Not used.
 *
 * *****  ASCII
 * AAAAA  ASCII
 * aaaaa  ASCII
 * ∙∙∙∙∙  ASCII F9. Not used. Looks same as U+2022 on some environments.
 * </pre>
 */
public class PositionStateChars {
  // Unicode:
  public static final char VACANT = '◦';  // U+25E6
  public static final char VACANT_ASCII = '.';
  public static final char VACANT_EMPHASIZED_BLACK_SQUARE = '▪';  // U+25AA
  public static final char VACANT_EMPHASIZED_WHITE_SQUARE = '▫';  // U+25AB
  public static final char VACANT_EMPHASIZED_BLACK_TRIANGLE = '▴';  // U+25B4
  public static final char VACANT_EMPHASIZED_BLACK_CIRCLE = '•';  // U+2022
  public static final char VACANT_AS_QI = 'θ';  // U+03B8. Theta is equivalent to Q.
  public static final char VACANT_FOR_JIE_DEAD = 'κ';  // U+03BA. Kappa stands for KO - Jie.
  public static final char BLACK = '●';  // U+25CF
  public static final char BLACK_ASCII = 'X';
  public static final char BLACK_EMPHASIZED = '◆';  // U+25C6
  public static final char BLACK_CAPTURED = '▲';  // U+25B2
  public static final char WHITE = '○';  // U+25CB
  public static final char WHITE_ASCII = 'O';
  public static final char WHITE_EMPHASIZED = '◇';  // U+25C7
  public static final char WHITE_CAPTURED = '◬';  // U+25EC

  // ASCII:
  /** Star char. */
  public static final char STAR = '*';
  /** Char A. The first char in A-Z. */
  public static final char A = 'A';
  /** Char Z. The last char in A-Z. */
  public static final char Z = 'Z';
  /** Char a. The first char in a-z. */
  public static final char a = 'a';
  /** Char z. The last char in a-z. */
  public static final char z = 'z';

  public static boolean isAlphabet(char positionChar) {
    return (positionChar >= A && positionChar <= Z)
        || (positionChar >= a && positionChar <= z);
  }
}
