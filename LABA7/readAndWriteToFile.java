package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class readAndWriteToFile {

    static void writeTextIntoFile(String outputFile, Double[][] matrix) throws IOException {
        FileWriter outFile = new FileWriter(outputFile);
        Integer size = matrix.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                outFile.append(matrix[i][j] + "   ");
            }
            outFile.append("\n");
        }
        outFile.close();
    }

    static void readTextFromFile1(String inputFile, Double[][] matrix) throws IOException {
        FileReader inFile = new FileReader(inputFile);
        Scanner in2 = new Scanner(inFile);
        int size = matrix.length;
        FileWriter fout2 = new FileWriter("out2.txt");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Double.valueOf(in2.next());
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                fout2.append(matrix[i][j].toString()).append(String.valueOf(' '));
            }
            fout2.append("\n");
        }
        inFile.close();

    }

}

