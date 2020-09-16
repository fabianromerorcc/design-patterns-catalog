package dev.fabianromero.functionalprogramming.genericexamples.assignmentcompatibility;

public class Shoe implements Sized, Coloured {
    private Integer size;
    private String color;

    //Necessary for Spock reflection
    public Shoe() {}

    public Shoe(Integer size, String color) {
        this.size = size;
        this.color = color;
    }

    public Integer getSize() {
        return size;
    }

    @Override
    public String getColor() {
        return color;
    }
}
