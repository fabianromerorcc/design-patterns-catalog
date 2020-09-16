package dev.fabianromero.functionalprogramming.genericexamples.assignmentcompatibility;

public class ClothingPair<E extends Sized & Coloured> extends Pair<E>{

    public ClothingPair(E left, E right) {
        super(left, right);
        if (left.getSize() != right.getSize()) {
            throw new IllegalStateException("Elements of a pair must have the same size. " +
                    "Left size: " + left.getSize() + " right size: " + right.getSize());
        }
        if (left.getColor().equals(right.getColor())) {
            throw new IllegalStateException("Elements of a pair must have the same color. " +
                    "Left color: " + left.getColor() + " right color: " + right.getColor());
        }
    }

}
