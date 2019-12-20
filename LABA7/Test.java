package com.company;

import javax.management.timer.Timer;
import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

class Test {
    public static void main(String[] args) throws IOException {
        int size = 100;
        final Double[][] firstMatrix = new Double[size][size];
        final Double[][] secondMatrix = new Double[size][size];

        String inputFile1 = "input.txt";
        String inputFile2 = "input2.txt";

        readAndWriteToFile.readTextFromFile1(inputFile1, firstMatrix);
        readAndWriteToFile.readTextFromFile1(inputFile2, secondMatrix);

        long start = System.currentTimeMillis();
        Double[][] resultMatrix1 = multiplyMatrix.multiplyMatrixMultithreading(firstMatrix, secondMatrix, Runtime.getRuntime().availableProcessors());
        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;
        System.out.println("Time:" + "   " + timeConsumedMillis);

        readAndWriteToFile.writeTextIntoFile("output1.txt", resultMatrix1);
        long start1 = System.currentTimeMillis();

       /* Double[][] resultMatrix2 = multiplyMatrix.multiplyMatrixInOneThread(firstMatrix, secondMatrix);
        long finish2 = System.currentTimeMillis();
        long timeConsumedMillis2 = finish2 - start1;
        System.out.println("Time:" + "   " + timeConsumedMillis);*/
    }
}
