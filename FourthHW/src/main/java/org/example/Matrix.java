package org.example;

import java.util.Random;

public class Matrix<T extends Number> {
    private T[][] data;
    private int rows;
    private int cols;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        data = (T[][]) new Number[rows][cols];
        fillRandom();
    }

    public void fillRandom() {
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = (T) (Double) random.nextDouble();
            }
        }
    }

    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(data[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public Matrix add(Matrix<T> other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Matrix dimensions must match for addition.");
        }

        Matrix<T> result = new Matrix<>(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = (T) (Number) (this.data[i][j].doubleValue() + other.data[i][j].doubleValue());
            }
        }

        return result;
    }

    public double calculateAverage() {
        double sum = 0.0;
        int count = rows * cols;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += data[i][j].doubleValue();
            }
        }

        return sum / count;
    }
}