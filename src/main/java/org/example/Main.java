package org.example;

import java.util.Scanner;

public class Main {

    static double task1(int N) {
        double y = 0;
        for (int n = 2; n <= N; n++) {   // n = 1 пропускаем сразу
            y += 1 / Math.log(n);
        }
        return y;
    }

    static double task2(double x, int N) {
        double sum = x;
        double term = x;
        for (int k = 1; k <= N; k++){
            term = term * -1 * x*x / (2*k)*(2*k+1);
            sum += term;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        System.out.println(task1(N));
    }
}