package com.bohdi2.silly;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class ImageTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        int[][] image1 = {
                {0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 1, 1},
                {1, 1, 1, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 0},
        };

        int[][] image2 = {
                {0},
        };

        int[][] image3 = {
                {1},
        };

        int[][] image4 = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1},
        };
    }

    @Test
    public void test_copy() {
        int[][] image = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1},
        };

        Image r = new Image(image);

        assertTrue(Arrays.deepEquals(image, r.getWorkingImage()));
    }



    @Test
    public void test_rectangles() {

        int[][] bitmap = {
                {0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 1, 1},
                {1, 1, 1, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 0},
        };

        Image image = new Image(bitmap);
        List<Rectangle> result = image.findRectangles();
        assertEquals(list(
                        new Rectangle(0, 0, 1, 1),
                        new Rectangle(2, 0, 1, 1),
                        new Rectangle(2, 3, 3, 2),
                        new Rectangle(3, 1, 1, 3),
                        new Rectangle(5, 3, 2, 2),
                        new Rectangle(7, 6, 1, 1)
                ),
                result
        );

        int[][] expected = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
        };

        assertTrue(Arrays.deepEquals(expected, image.getWorkingImage()));
    }

    @Test
    public void test_just_zero() {
        int[][] bitmap = {
                {0},
        };

        Image image = new Image(bitmap);
        List<Rectangle> result = image.findRectangles();
        assertEquals(list(new Rectangle(0, 0, 1, 1)), result);

        int[][] expected = {
                {1},
        };

        assertTrue(Arrays.deepEquals(expected, image.getWorkingImage()));
    }

    @Test
    public void test_just_one() {
        int[][] bitmap = {
                {1},
        };

        Image image = new Image(bitmap);
        List<Rectangle> result = image.findRectangles();
        assertEquals(list(), result);

        int[][] expected = {
                {1},
        };

        assertTrue(Arrays.deepEquals(expected, image.getWorkingImage()));
    }

    public static <T> List<T> list(T ... items) {
        return new ArrayList<>(Arrays.asList(items));
    }
}
