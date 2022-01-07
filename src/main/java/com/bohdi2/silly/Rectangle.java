package com.bohdi2.silly;

import java.util.Objects;

public class Rectangle {
    public final int topRow;
    public final int leftCol;
    public final int width;
    public final int height;

    public Rectangle(int topRow, int leftCol, int width, int height) {
        this.topRow = topRow;
        this.leftCol = leftCol;
        this.width = width;
        this.height = height;
    }

    public Rectangle(Point topLeft, Point bottomRight) {
        this.topRow = topLeft.row;
        this.leftCol = topLeft.col;
        this.width = bottomRight.col + 1 - topLeft.col;
        this.height = bottomRight.row + 1 - topLeft.row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return topRow == rectangle.topRow && leftCol == rectangle.leftCol && width == rectangle.width && height == rectangle.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(topRow, leftCol, width, height);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "topRow=" + topRow +
                ", leftCol=" + leftCol +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
