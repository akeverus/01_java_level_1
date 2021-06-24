package lesson_2;

public class Homework_2_18062021 {

    public static void main(String[] args) {
        System.out.println(checkSum(7,8));
        checkNegativityMessage(0);
        System.out.println(checkNegativityBoolean(0));
        printMessage("Я пишу методы в 2 часа ночи", 20);
        System.out.println(checkYear(2100));
    }

    private static boolean checkSum (int a, int b) {
        int c = a + b;
        return 10 <= c && c <= 20;
    }

    private static void checkNegativityMessage (int a) {
        System.out.println(a < 0 ? "Число отрицательное" : "Число положительное");
    }

    private static boolean checkNegativityBoolean (int a) {
        return a < 0;
    }

    private static void printMessage (String message, int a) {
        if (a > 0) {
            for (int i = 1; i <= a; i++) {
                System.out.println(message);
            }
        } else {
            System.out.println("Задано неверное число. Число должно быть больше нуля.");
        }
    }

    private static boolean checkYear (int year) {
        return year % 400 == 0 || year % 4 == 0 && year % 100 > 0;
    }

}