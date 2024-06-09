import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод размера массива с проверкой корректности
        int n = 0;
        while (true) {
            System.out.print("Введите размер массива (положительное целое число): ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) {
                    break;
                } else {
                    System.out.println("Размер массива должен быть положительным числом.");
                }
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите целое число.");
                scanner.next(); // Очистка некорректного ввода
            }
        }

        // Ввод диапазона генерации случайных чисел с проверкой корректности
        double x = 0, y = 0;
        while (true) {
            System.out.print("Введите нижнюю границу диапазона (вещественное число): ");
            if (scanner.hasNextDouble()) {
                x = scanner.nextDouble();
                break;
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите вещественное число.");
                scanner.next(); // Очистка некорректного ввода
            }
        }

        while (true) {
            System.out.print("Введите верхнюю границу диапазона (вещественное число): ");
            if (scanner.hasNextDouble()) {
                y = scanner.nextDouble();
                if (y > x) {
                    break;
                } else {
                    System.out.println("Верхняя граница должна быть больше нижней границы.");
                }
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите вещественное число.");
                scanner.next(); // Очистка некорректного ввода
            }
        }

        // Генерация массива случайных вещественных чисел
        double[] array = new double[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = x + (y - x) * random.nextDouble();
        }

        // Вычисление суммы элементов массива
        double sum = 0;
        for (double num : array) {
            sum += num;
        }

        // Вычисление среднего арифметического значения массива
        double average = sum / n;

        // Вывод результатов
        System.out.println("Сумма элементов массива: " + sum);
        System.out.println("Среднее арифметическое значение массива: " + average);
    }
}