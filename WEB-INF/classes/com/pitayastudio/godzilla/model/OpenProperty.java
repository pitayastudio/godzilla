package com.pitayastudio.godzilla.model;

import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.PositionStateChars;
import com.pitayastudio.godzilla.modelboard.BlockBoard;

import javax.annotation.Nonnull;

/**
 * @see DesignDoc#openProperty()
 */
public class OpenProperty {
  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Reads an {@link OpenProperty} from board input with emphasized chars.
   */
  public static OpenProperty readFromString(
      @Nonnull String boardInput,
      @Nonnull Color color,
      char vacantChar,
      char prisonerChar,
      boolean isAlphabetAcceptedAsVacantChar) {
    BlockBoard blockBoard = BlockBoard.readFromString(boardInput);
    int boardSize = blockBoard.getBoardSize();
    OpenProperty.Builder builder = OpenProperty.newBuilder().setRequiredColor(color);
    for (int xPosition = 1; xPosition <= boardSize; xPosition++) {
      for (int yPosition = 1; yPosition <= boardSize; yPosition++) {
        int indexInString = boardSize * (boardSize - yPosition) + xPosition - 1;
        char positionChar = boardInput.charAt(indexInString);
        if (positionChar == prisonerChar) {
          ColorBlock prisonerBlock = blockBoard.getColorBlock(xPosition, yPosition);
          builder.addPrisonerBlock(prisonerBlock);
        } else if ((positionChar == vacantChar)
            || (isAlphabetAcceptedAsVacantChar && PositionStateChars.isAlphabet(positionChar))) {
          Realm realm = blockBoard.getRealm(xPosition, yPosition);
          builder.addPartialVacantBlock(realm);
        }
      }
    }
    return builder.build();
  }

  @SuppressWarnings("unused") private final Color color;
  @SuppressWarnings("unused") private final ImmutableSet<Realm> realms;
  @SuppressWarnings("unused") private final ImmutableSet<ColorBlock> prisonerBlocks;

  private OpenProperty(
      @Nonnull Color color,
      @Nonnull ImmutableSet<Realm> realms,
      @Nonnull ImmutableSet<ColorBlock> prisonerBlocks) {
    this.color = color;
    this.realms = realms;
    this.prisonerBlocks = prisonerBlocks;
  }

  public static class Builder {
    private Color color;
    private final ImmutableSet.Builder<Realm> partialVacantBlocksBuilder =
        ImmutableSet.builder();
    private final ImmutableSet.Builder<ColorBlock> prisonerBlocksBuilder = ImmutableSet.builder();

    private Builder() {}

    public Builder setRequiredColor(@Nonnull Color color) {
      this.color = color;
      return this;
    }

    public Builder addPartialVacantBlock(@Nonnull Realm realm) {
      partialVacantBlocksBuilder.add(realm);
      return this;
    }

    public Builder addPartialVacantBlocks(@Nonnull Iterable<Realm> blocks) {
      partialVacantBlocksBuilder.addAll(blocks);
      return this;
    }

    public Builder addPrisonerBlock(@Nonnull ColorBlock prisonerBlock) {
      prisonerBlocksBuilder.add(prisonerBlock);
      return this;
    }

    public Builder addPrisonerBlocks(@Nonnull Iterable<ColorBlock> blocks) {
      prisonerBlocksBuilder.addAll(blocks);
      return this;
    }

    public OpenProperty build() {
      assert (null != color);
      ImmutableSet<Realm> realms = partialVacantBlocksBuilder.build();
      assert(!realms.isEmpty());
      ImmutableSet<ColorBlock> prisonerBlocks = prisonerBlocksBuilder.build();
      return new OpenProperty(color, realms, prisonerBlocks);
    }
  }
}
