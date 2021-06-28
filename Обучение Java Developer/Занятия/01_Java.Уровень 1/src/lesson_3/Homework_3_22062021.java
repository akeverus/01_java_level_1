package lesson_3;

public class Homework_3_22062021 {
    public static void main(String[] args) {
        replaceZeroOne();
        massiveOneHundred();
        replaceSmallerSix();
        diagonalMassive(15);
        int[] massive = getMassive(13,1);
        for  (int i = 0; i < massive.length; i++) {
            System.out.println(massive[i]);
        }
        massiveMinMax();
        int[] massive2 = new int[]{5,5,5,5,5,5};
        System.out.println(compareLeftRightMassive(massive2));
        int[] massive3 = new int[]{5,5,5,5,5,5,6,6,6,6,6,6};
        for (int element : offsetElement(massive2, 6)){
            System.out.println(element);
        }
    }

    public static void replaceZeroOne() {
        int[] massive = new int[] {0,1,1,0,1,1,0,1,0,0,1};
        for (int element : massive) {
            if (element == 1) {
                element = 0;
            } else element = 1;
            System.out.println(element);
        }
    }

    public static void massiveOneHundred() {
        int[] massive = new int [100];
        for(int i = 0; i < 100; i++) {
            massive[i] = i;
            System.out.println(massive[i]);
        }
    }

    public static void replaceSmallerSix() {
        int [] massive = new int [] {1,5,3,2,11,4,5,2,4,8,9,1};
        for (int element : massive) {
            if (element < 6) {
                element = element * 2;
            }
            System.out.println(element);
        }
    }

    public static void diagonalMassive (int razmer) {
        int [][] massive = new int[razmer][razmer];
        for (int row = 0; row < razmer; row++) {
            massive [row][razmer - row - 1] = 1;
            for (int column = 0; column < razmer; column++) {
                if (row == column) {
                    massive [row][column] = 1;
                }
                System.out.print(massive [row][column] + " ");
            }
            System.out.println();
        }
    }

    public static int[] getMassive(int length, int initialValue) {
        int[] massive = new int[length];
        for (int element : massive) {
            element = initialValue;
        }
        return massive;
    }

    public static void massiveMinMax() {
        int[] massive = new int[]{1,5,3,2,11,4,5,2,4,8,9,1};
        int minimum = massive[0];
        int maximum = massive[0];
        for (int element : massive) {
            if (element < minimum) {
                minimum = element;
            } else if (element > maximum) {
                maximum = element;
            }
        }
        System.out.println("Минимальный элемент массива равен " + minimum);
        System.out.println("Максимальный элемент массива равен " + maximum);
    }

    private static boolean compareLeftRightMassive(int[] massive) {
        int targetElement = 1;
        boolean compareLeftRight = false;
        while (targetElement != massive.length) {
            int sumLeft = 0;
            int sumRight = 0;
            for (int i = 0; i < massive.length; i++) {
                if (i < targetElement) {
                    sumLeft = sumLeft + massive[i];
                } else {
                    sumRight = sumRight + massive[i];
                }
            }
            if (sumLeft == sumRight) {
                compareLeftRight = true;
            }
            targetElement++;
        }
        return compareLeftRight;
    }

    private static int[] offsetElement(int[] massive, int offset) {
        offset = offset % massive.length;
        int oldElement;
        while (offset > 0) {
            for (int index = 0; index < massive.length; index++) {
                if (index != 0) {
                    oldElement = massive[index];
                    massive[index] = massive[index - 1];
                    massive[index - 1] = oldElement;
                } else {
                    oldElement = massive[index];
                    massive[index] = massive[massive.length - 1];
                    massive[massive.length - 1] = oldElement;
                }
            }
            offset--;
        }
        while (offset < 0) {
            for (int index = 0; index < massive.length; index++) {
                if (index != massive.length - 1) {
                    oldElement = massive[index];
                    massive[index] = massive[index + 1];
                    massive[index + 1] = oldElement;
                } else {
                    oldElement = massive[index];
                    massive[index] = massive[0];
                    massive[0] = oldElement;
                }
            }
            offset++;
        }
        return massive;
    }
}
