package com.company;

public class ProblemTwo {

    public static void main(String[] args) {

        int[][] matrix = {
                {1,2,3,4},
                {4,5,6,7},
                {9,8,9,10},
                {1,1,1,1} };
        System.out.println("Absolute difference between diagonals: "+diagonalDifference(matrix));
    }

    private static int diagonalDifference(int[][] matrix){

        int absdiff =0;
        int order = matrix.length;

        for (int i = 0; i <matrix.length ; i++) {
            absdiff += matrix[i][i];
            absdiff -= matrix[i][order-(i+1)];
        }

        return Math.abs(absdiff);
    }

}
