package com.pitayastudio.godzilla.level;

import com.pitayastudio.godzilla.moveanalyzer.DesignDoc;

import java.text.NumberFormat;

/**
 * @see DesignDoc#moveToExpandOrReduceInfluence
 * @see com.pitayastudio.godzilla.level.DesignDoc#controlLevelAndInfluence
 */
public class Influence {
  public static void main(String [] args) {
    NumberFormat nf = NumberFormat.getInstance();
    nf.setMaximumFractionDigits(1);
    nf.setMinimumFractionDigits(1);
    nf.setMinimumIntegerDigits(3);
    for (int i = 0; i <= 10; i++) {
      for (int j = 0; j <= 10; j++) {
        System.out.print(nf.format(calcRadiatedInfluence_10(i,j)) + "\t");
      }
      System.out.println();
    }
  }

  public static double calcRadiatedInfluence_6(int xDist, int yDist) {
    if (xDist == 0 && yDist == 0) {
      return 64.0;
    }
    if ((xDist == 1 && yDist == 0) || (xDist == 0 && yDist == 1)) {
      return 32.0;
    }
    if ((xDist == 2 && yDist == 0) || (xDist == 0 && yDist == 2)) {
      return 16.0;
    }
    if ((xDist == 3 && yDist == 0) || (xDist == 0 && yDist == 3)) {
      return 8.0;
    }
    if ((xDist == 4 && yDist == 0) || (xDist == 0 && yDist == 4)) {
      return 4.0;
    }
    if ((xDist == 5 && yDist == 0) || (xDist == 0 && yDist == 5)) {
      return 2.0;
    }
    if ((xDist == 6 && yDist == 0) || (xDist == 0 && yDist == 6)) {
      return 1.0;
    }
    double dbX_1 = calcRadiatedInfluence_6(xDist - 1, yDist);
    double dbY_1 = calcRadiatedInfluence_6(xDist, yDist - 1);
    return 1.5 * dbX_1 * dbY_1 / (dbX_1 + dbY_1);
  }

  public static double calcRadiatedInfluence_10(int inXDist, int inYDist) {
    if (inXDist == 0 && inYDist == 0) {
      return 1024.0;
    }
    if ((inXDist == 1 && inYDist == 0) || (inXDist == 0 && inYDist == 1)) {
      return 512.0;
    }
    if ((inXDist == 2 && inYDist == 0) || (inXDist == 0 && inYDist == 2)) {
      return 256.0;
    }
    if ((inXDist == 3 && inYDist == 0) || (inXDist == 0 && inYDist == 3)) {
      return 128.0;
    }
    if ((inXDist == 4 && inYDist == 0) || (inXDist == 0 && inYDist == 4)) {
      return 64.0;
    }
    if ((inXDist == 5 && inYDist == 0) || (inXDist == 0 && inYDist == 5)) {
      return 32.0;
    }
    if ((inXDist == 6 && inYDist == 0) || (inXDist == 0 && inYDist == 6)) {
      return 16.0;
    }
    if ((inXDist == 7 && inYDist == 0) || (inXDist == 0 && inYDist == 7)) {
      return 8.0;
    }
    if ((inXDist == 8 && inYDist == 0) || (inXDist == 0 && inYDist == 8)) {
      return 4.0;
    }
    if ((inXDist == 9 && inYDist == 0) || (inXDist == 0 && inYDist == 9)) {
      return 2.0;
    }
    if ((inXDist == 10 && inYDist == 0) || (inXDist == 0 && inYDist == 10)) {
      return 1.0;
    }
    double dbX_1 = calcRadiatedInfluence_10(inXDist - 1, inYDist);
    double dbY_1 = calcRadiatedInfluence_10(inXDist, inYDist - 1);
    return 1.5 * dbX_1 * dbY_1 / (dbX_1 + dbY_1);
  }
}
