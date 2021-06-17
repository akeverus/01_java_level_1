package lesson_1;

public class Homework_1_15062021 {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign(7,-7);
        printColor(0);
        compareNumbers(8,8);
    }

    private static void printThreeWords () {
        String[] words = new String [] {"Orange", "Banana", "Apple"};
        for (String i : words){
            System.out.println(i);
        }
    }

    private static void checkSumSign(int a, int b) {
        int c = a + b;
        if (c < 0){
            System.out.println("Сумма отрицательна");
        } else {
            System.out.println("Сумма положительна");
        }
    }

    private static void printColor(int value) {
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 100) {
            System.out.println("Зелёный");
        } else {
            System.out.println("Жёлтый");
        }
    }

    private static void compareNumbers (int a, int b) {
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
}
