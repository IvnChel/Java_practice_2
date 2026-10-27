package org.example;

import java.util.Locale;
import java.util.Scanner;

public class Task5 {

    static final Scanner scanner = new Scanner(System.in);

    static void printMenu() {
        System.out.println();
        System.out.println("=== ГЛАВНОЕ МЕНЮ ===");
        System.out.println("1 - Выполнить расчёт");
        System.out.println("2 - Информация о программе");
        System.out.println("3 - Информация о разработчике");
        System.out.println("0 - Выход");
        System.out.println("Ваш выбор:");
    }

    static void printProgramInfo() {
        System.out.println("Программа вычисляет кинетическую энергию тела: E = m * v^2 / 2.");
        System.out.println("Масса вводится в кг (> 0), скорость в м/с (>= 0).");
    }

    static void printDeveloperInfo() {
        System.out.println("Разработчик: Байнов Иван Алексеевич");   // подставь свои данные
    }

    // Возвращает число или null, если пользователь ввёл q
    static Double readNumber(String prompt) {
        while (true) {
            System.out.println(prompt + " (или q для отмены):");
            String line = scanner.nextLine().trim();

            if (line.equalsIgnoreCase("q")) {
                return null;
            }
            try {
                double value = Double.parseDouble(line.replace(',', '.'));
                if (Double.isFinite(value)) {
                    return value;
                }
                System.out.println("Ошибка: введите обычное число.");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число, например 12.5");
            }
        }
    }

    static Double readMass() {
        while (true) {
            Double m = readNumber("Введите массу тела m (кг)");
            if (m == null) {
                return null;
            }
            if (m > 0) {
                return m;
            }
            System.out.println("Ошибка: масса должна быть строго больше нуля.");
        }
    }

    static Double readSpeed() {
        while (true) {
            Double v = readNumber("Введите скорость тела v (м/с)");
            if (v == null) {
                return null;
            }
            if (v >= 0) {
                return v;
            }
            System.out.println("Ошибка: скорость не может быть отрицательной.");
        }
    }

    static double kineticEnergy(double m, double v) {
        return m * v * v / 2.0;
    }

    static void runCalculation() {
        Double m = readMass();
        if (m == null) {
            System.out.println("Ввод отменён, возврат в меню.");
            return;
        }
        Double v = readSpeed();
        if (v == null) {
            System.out.println("Ввод отменён, возврат в меню.");
            return;
        }

        double energy = kineticEnergy(m, v);
        System.out.println("Кинетическая энергия тела равна:");
        System.out.printf("%.2f Дж%n", energy);
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);   // вывод с точкой на любом компьютере
        System.out.println("Калькулятор кинетической энергии.");

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    runCalculation();
                    break;
                case "2":
                    printProgramInfo();
                    break;
                case "3":
                    printDeveloperInfo();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Неизвестный пункт меню, введите 0, 1, 2 или 3.");
            }
        }
        System.out.println("Программа завершена.");
    }
}