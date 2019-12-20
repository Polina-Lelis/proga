package com.company;

class MultiplierThread extends Thread {
    private final Double[][] firstMatrix;
    private final Double[][] secondMatrix;
    private final Double[][] resultMatrix;
    private final int firstIndex;
    private final int lastIndex;
    private final int sumLength;

    public MultiplierThread(final Double[][] firstMatrix,
                            final Double[][] secondMatrix,
                            final Double[][] resultMatrix,
                            final int firstIndex,
                            final int lastIndex) {
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.resultMatrix = resultMatrix;
        this.firstIndex = firstIndex;
        this.lastIndex = lastIndex;
        sumLength = secondMatrix.length;
    }

    private void calcValue(final int row, final int col) {
        double sum = 0;
        for (int i = 0; i < sumLength; ++i)
            sum += firstMatrix[row][i] * secondMatrix[col][i];
        resultMatrix[row][col] = sum;
    }

    @Override
    public void run() {
        System.out.println(getName() + " started. Calculating cells from " + firstIndex + " to " + lastIndex + "...");

        final int colCount = secondMatrix[0].length;  // Число столбцов результирующей матрицы.
        for (int index = firstIndex; index < lastIndex; ++index)
            calcValue(index / colCount, index % colCount);

    }
}

