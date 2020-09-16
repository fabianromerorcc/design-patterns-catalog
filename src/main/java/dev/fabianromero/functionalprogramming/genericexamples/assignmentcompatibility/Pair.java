package dev.fabianromero.functionalprogramming.genericexamples.assignmentcompatibility;

public class Pair<E> {

    private E left;
    private E right;

    public Pair(E left, E right) {
        this.left = left;
        this.right = right;
    }

    public E getLeft() {
        return left;
    }

    public E getRight() {
        return right;
    }
}
