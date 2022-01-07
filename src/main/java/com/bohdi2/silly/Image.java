package com.bohdi2.silly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Image {
    private final int height;
    private final int width;
    private final int [][] workingImage;

    public Image(int [][]image) {
        this.height = image.length;
        this.width = image[0].length;
        workingImage = deepCopy(image);
    }

    public int[][] getWorkingImage() {
        return deepCopy(workingImage);
    }

    public List<Rectangle> findRectangles() {
        List<Rectangle> result = new ArrayList<>();
        for (Point p = findTopLeft(); p != null; p = findTopLeft()) {
            result.add(fill(findBottomRight(p)));
        }
        return result;
    }

    private Point findTopLeft() {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (workingImage[row][ col] == 0) {
                    return new Point(row, col);
                }
            }
        }

        return null;
    }

    private Rectangle findBottomRight(Point topLeft) {
        int topRow = topLeft.row;
        int leftCol = topLeft.col;

        int bottomRow = topRow;
        while (bottomRow < height && workingImage[bottomRow][leftCol] == 0) {
            bottomRow++;
        }
        bottomRow--;

        int rightCol = leftCol;
        while (rightCol < width && workingImage[topRow][rightCol] == 0) {
            rightCol++;
        }
        rightCol--;

        return new Rectangle(topLeft, new Point(bottomRow, rightCol));
    }

    private Rectangle fill(Rectangle r) {
        for (int row = r.topRow; row < r.topRow + r.height; row++) {
            for (int col = r.leftCol; col < r.leftCol + r.width; col++) {
                workingImage[row][col] = 1;
            }
        }

        return r;
    }

    public String toString() {
        return Arrays.deepToString(workingImage);
    }

    private int[][] deepCopy(int[][] matrix) {
        return java.util.Arrays.stream(matrix).map(int[]::clone).toArray($ -> matrix.clone());
    }

}
