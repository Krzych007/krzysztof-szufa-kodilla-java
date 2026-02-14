package com.kodilla.testing.shape;

public class Square implements Shape {

    private String name;
    private double side;

    public Square(String name, double side) {
       this.side = side;
       this.name = name;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return side*side;
    }
}
