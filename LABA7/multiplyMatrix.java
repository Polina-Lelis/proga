package com.company;

public class multiplyMatrix {

    public static Double[][] multiplyMatrixInOneThread(final Double[][] firstMatrix,
                                                       final Double[][] secondMatrix) {
        final int rowCount = firstMatrix.length;
        final int colCount = secondMatrix[0].length;
        final int sumLength = secondMatrix.length;
        final Double[][] result = new Double[rowCount][colCount];

        for (int row = 0; row < rowCount; ++row) {
            for (int col = 0; col < colCount; ++col) {
                double sum = 0;
                for (int i = 0; i < sumLength; ++i)
                    sum += firstMatrix[row][i] * secondMatrix[col][i];
                result[row][col] = sum;
            }
        }
        return result;
    }

    public static Double[][] multiplyMatrixMultithreading(final Double[][] firstMatrix, final Double[][] secondMatrix, int threadCount) {
        assert threadCount > 0;

        final int rowCount = firstMatrix.length;
        final int colCount = secondMatrix[0].length;
        final Double[][] result = new Double[rowCount][colCount];

        final int cellsForThread = (rowCount * colCount) / threadCount;
        int firstIndex = 0;
        final MultiplierThread[] Threads = new MultiplierThread[threadCount];

        for (int threadIndex = threadCount - 1; threadIndex >= 0; --threadIndex) {
            int lastIndex = firstIndex + cellsForThread;
            if (threadIndex == 0) {
                lastIndex = rowCount * colCount;
            }
            Threads[threadIndex] = new MultiplierThread(firstMatrix, secondMatrix, result, firstIndex, lastIndex);
            Threads[threadIndex].start();
            firstIndex = lastIndex;
        }

        try {
            for (final MultiplierThread multiplierThread : Threads)
                multiplierThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }
}



/* Один из потоков должен будет вычислить не только свой блок ячеек,
                   но и остаток, если число ячеек не делится нацело на число потоков. */
