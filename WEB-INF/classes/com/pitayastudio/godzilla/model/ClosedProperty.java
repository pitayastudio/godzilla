package com.pitayastudio.godzilla.model;

import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.PositionStateChars;
import com.pitayastudio.godzilla.modelboard.BlockBoard;

import javax.annotation.Nonnull;

/**
 * @see DesignDoc#closedProperty()
 */
public class ClosedProperty {
  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Reads an {@link ClosedProperty} from board input with emphasized chars.
   */
  public static ClosedProperty readFromString(
      @Nonnull String boardInput,
      @Nonnull Color color,
      char vacantChar,
      char prisonerChar,
      boolean isAlphabetAcceptedAsVacantChar) {
    BlockBoard blockBoard = BlockBoard.readFromString(boardInput);
    int boardSize = blockBoard.getBoardSize();
    ClosedProperty.Builder builder = ClosedProperty.newBuilder().setRequiredColor(color);
    for (int xPosition = 1; xPosition <= boardSize; xPosition++) {
      for (int yPosition = 1; yPosition <= boardSize; yPosition++) {
        int indexInString = boardSize * (boardSize - yPosition) + xPosition - 1;
        char positionChar = boardInput.charAt(indexInString);
        if (positionChar == prisonerChar) {
          ColorBlock prisonerBlock = blockBoard.getColorBlock(xPosition, yPosition);
          builder.addPrisonerBlock(prisonerBlock);
        } else if ((positionChar == vacantChar)
            || (isAlphabetAcceptedAsVacantChar && PositionStateChars.isAlphabet(positionChar))) {
          VacantBlock enclosedVacantBlock = blockBoard.getVacantBlock(xPosition, yPosition);
          builder.addVacantBlock(enclosedVacantBlock);
        }
      }
    }
    return builder.build();
  }

  @SuppressWarnings("unused") private final Color color;
  @SuppressWarnings("unused") private final ImmutableSet<VacantBlock> vacantBlocks;
  @SuppressWarnings("unused") private final ImmutableSet<ColorBlock> prisonerBlocks;

  private ClosedProperty(
      @Nonnull Color color,
      @Nonnull ImmutableSet<VacantBlock> vacantBlocks,
      @Nonnull ImmutableSet<ColorBlock> prisonerBlocks) {
    this.color = color;
    this.vacantBlocks = vacantBlocks;
    this.prisonerBlocks = prisonerBlocks;
  }

  public static class Builder {
    private Color color;
    private final ImmutableSet.Builder<VacantBlock> vacantBlocksBuilder = ImmutableSet.builder();
    private final ImmutableSet.Builder<ColorBlock> prisonerBlocksBuilder = ImmutableSet.builder();

    private Builder() {}

    public Builder setRequiredColor(@Nonnull Color color) {
      this.color = color;
      return this;
    }

    public Builder addVacantBlock(@Nonnull VacantBlock vacantBlock) {
      vacantBlocksBuilder.add(vacantBlock);
      return this;
    }

    public Builder addVacantBlocks(@Nonnull Iterable<VacantBlock> vacantBlocks) {
      vacantBlocksBuilder.addAll(vacantBlocks);
      return this;
    }

    public Builder addPrisonerBlock(@Nonnull ColorBlock prisonerBlock) {
      prisonerBlocksBuilder.add(prisonerBlock);
      return this;
    }

    public Builder addPrisonerBlocks(@Nonnull Iterable<ColorBlock> prisonerBlocks) {
      prisonerBlocksBuilder.addAll(prisonerBlocks);
      return this;
    }

    public ClosedProperty build() {
      assert (null != color);
      ImmutableSet<VacantBlock> vacantBlocks = vacantBlocksBuilder.build();
      assert(!vacantBlocks.isEmpty());
      ImmutableSet<ColorBlock> prisonerBlocks = prisonerBlocksBuilder.build();
      return new ClosedProperty(color, vacantBlocks, prisonerBlocks);
    }
  }
}
