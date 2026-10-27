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
        for (int k = 1; k <= N; k++) {
            term = term * -1 * x * x / ((2 * k) * (2 * k + 1));
            sum += term;
        }
        return sum;
    }

    static String task3(double e) {
        double a = 1;
        double b = 2;
        int k = 3;
        double c = (a + 2 * b) / 3;
        while (Math.abs(c - b) >= e) {
            a = b;
            b = c;
            c = (a + 2 * b) / 3;
            k++;
        }
        return (k + " " + b + " " + c);

    }

    static void task4(double a, double b){
        double min = Math.min(a, b);
        double max = Math.max(a,b);

        int c = (int) Math.ceil(max);
        int d = (int) Math.floor(min);

        System.out.println(min + " " + max);
        System.out.println(c + " " + d);
        System.out.println(c + " >= " + max + " > " + min + " >= " + d);

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int N = scanner.nextInt();
//        System.out.println(task1(N));
//        double x = scanner.nextDouble();
//        int N = scanner.nextInt();
//        double e = scanner.nextDouble();
//        System.out.println(task3(e));
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        task4(a, b);

    }
}