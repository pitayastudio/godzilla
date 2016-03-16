package com.pitayastudio.godzilla.modelboard;

import com.pitayastudio.godzilla.model.Block;
import com.pitayastudio.godzilla.model.ColorBlock;
import com.pitayastudio.godzilla.model.Gang;
import com.pitayastudio.godzilla.model.GangType;
import com.pitayastudio.godzilla.model.Lot;
import com.pitayastudio.godzilla.model.LotWithProperty;
import com.pitayastudio.godzilla.model.PrisonerBlock;
import com.pitayastudio.godzilla.model.VacantBlock;

public interface DesignDoc {
  /**
   * {@link PrisonerBlockBoard}:
   *
   * <p>Defn: the {@link PrisonerBlock} and its neighbor {@link VacantBlock}'s are surrounded by the
   * same foe {@link ColorBlock}.
   *
   * <p>Determination approach I - by moves calculation (Examples 1, 2, and 3):
   * <ul>
   *   <li>2 black {@link ColorBlock}s: A, D
   *   <li>3 white {@link ColorBlock}s: B, C, E
   *   <li>A is a prisoner of B.
   *   <li>white {@link LotWithProperty}-B: B + A (prisoner)
   *   <li>{@link LotWithProperty}-C: C
   *   <li>{@link LotWithProperty}-B and {@link LotWithProperty}-C has ConnectLevel >= 4,
   *       thus form a white {@link Gang}-BC.
   *   <li>the white {@link Gang}-BC is within the outer Black D
   *   <li>the white {@link Gang}-BC has only one eye.
   *   <li>{@link Gang}-BC is of type {@link GangType#PRISONER}.
   *   <li>form the black {@link LotWithProperty}-D: D only.
   *   <li>{@link LotWithProperty}-D is live, and is not a {@link PrisonerBlock} of E
   * </ul>
   *
   * <pre>
   * Example 1:
   *   A B CD  E
   *   X O OX  O
   * +--------------
   * |OOOOXXX..O.O..
   * |.X.O.OX..OOO..
   * |OOOO.OX..O.O..
   * |XXXXXXX..OOO..
   * |.........O.O..
   * |OOOOOOOOOOOO..
   * |..............
   * |..............
   *
   * Example 2:
   *   A B CD  E
   *   X O OX  O
   * +--------------
   * |OOOOXXXX.O.O..
   * |.X.O.O.X.O.O..
   * |OOOO.O.X.OOO..
   * |......XX.O.O..
   * |XXXXXXXX.OOO..
   * |.........O.O..
   * |OOOOOOOOOOOO..
   * |..............
   * |..............
   *
   * Example 3:
   *   A B CD  E
   *   X O OX  O
   * +--------------
   * |OOOOXXXX.O.O..
   * |.X.O.O.X.O.O..
   * |OOOO.O.X.OOO..
   * |......XX.O.O..
   * |XXXXXXXX.OOO..
   * |OOOOOOOOOOOO..
   * |..............
   * |..............
   *
   * Example 4:
   * +----------------
   * |.O.X.O.X.O.X.X..
   * |OO.X.O.X.O.XXX..
   * |..XX.O.X.O.X....
   * |XXXX.O.X.O.X....
   * |....OO.X.O.X....
   * |OOOOOO.X.O.X....
   * |......XX.O.X....
   * |XXXXXXXX.O.X....
   * |........OO.X....
   * |OOOOOOOOOOXX....
   * |.........X.X....
   * |XXXXXXXXXXXX....
   * |................
   * |................
   *
   * Example 5:
   * +------------------
   * |.O.O.X.O.X.O.X.X..
   * |OOOO.X.O.X.O.XXX..
   * |....XX.O.X.O.X....
   * |XXXXXX.O.X.O.X....
   * |......OO.X.O.X....
   * |OOOOOOOO.X.O.X....
   * |........XX.O.X....
   * |XXXXXXXXXX.O.X....
   * |..........OO.X....
   * |OOOOOOOOOOOOXX....
   * |...........X.X....
   * |XXXXXXXXXXXXXX....
   * |..................
   * |..................
   * </pre>
   *
   * <p>Procedure for calculating LiveLevel:
   * <ul>
   *   <li>note, the LiveLevel of the {@link Block} is not determined before the procedure starts.
   *   <li>first of all, analyze what is inside what, and then analyze the most-inside first.
   *   <li>from inside out, determine ConnectLevels between {@link Block}s and then construct {@link Lot}s
   *   <li>Label 100: Recursively analyze {@link LotWithProperty}-s from inside out.
   *   <li>analyze the number of eyes of the {@link LotWithProperty}-
   *   <li>if # of eyes of the {@link LotWithProperty} >=2, the {@link LotWithProperty}- is not a prisoner.
   *   <li>go to the outer recursion level if any
   *   <li>else (0 or 1 eyes):
   *       analyze the size and freedom and calculate how many more of eyes it can get
   *   <li>if total # of eyes that the {@link LotWithProperty}- can get >=2,
   *       the {@link LotWithProperty}- is not a prisoner.
   *   <li>go to the outer recursion level if any
   *   <li>Else (total # of eyes that the {@link LotWithProperty}- can get = 0 or 1):
   *       the {@link LotWithProperty}- could be dead, MutualLive,
   *       or Live depending on the outer {@link Lot}:
   *       <ul>
   *         <li>if there is an outer recursion level: go to the outer recursion level and report
   *             total # of eyes that the potential-prisoner {@link LotWithProperty}- can get
   *         <li>else (this is the outer most recursion level), calculate to see who wins the Capturing Race:
   *             <br>Cf. ZhongPan
   *             <br>note that the potential-prisoner could recursively have potential-prisoners.
   *       </ul>
   * </ul>
   *
   * <p>Determination approach II - by influence
   *
   * <p>Determination approach III - by patterns
   */
  void prisonerBlockBoard();
}
