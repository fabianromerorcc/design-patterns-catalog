package dev.fabianromero.functionalprogramming.genericexamples;

public class ClothingPair<E extends Sizable & Coloured> extends Pair<E>{

    public ClothingPair(E left, E right) {
        super(left, right);
        if (left.getSize() != right.getSize()) {
            throw new IllegalStateException("Elements of a pair must have the same size. " +
                    "Left size: " + left.getSize() + " right size: " + right.getSize());
        }
        if (left.getColor() != right.getColor()) {
            throw new IllegalStateException("Elements of a pair musta have the same color. " +
                    "Left color: " + left.getColor() + " right color: " + right.getColor());
        }

    }

}
