package lesson_4;

import java.util.Random;
import java.util.Scanner;

public class Homework_4_25062021 {

    public static char[][] map;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            if (!blockHumanTurn(DOT_X, DOT_O, DOT_EMPTY)) aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static Scanner sc = new Scanner(System.in);

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static boolean checkWin(char symb) {

        int counter;

        // Проверка по строкам

        for (int i = 0; i < SIZE; i++) {
            counter = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb) counter++;
            }
            if (counter == DOTS_TO_WIN) {
                return true;
            }
        }

        // Проверка по столбцам

        for (int j = 0; j < SIZE; j++) {
            counter = 0;
            for (int i = 0; i < SIZE; i++) {
                if (map[i][j] == symb) counter++;
            }
            if (counter == DOTS_TO_WIN) {
                return true;
            }
        }

        // Проверка по диагоналям слева-направо
        counter = 0;
        for (int k = DOTS_TO_WIN - SIZE; k <= SIZE - DOTS_TO_WIN; k++) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (i - j == k && map[i][j] == symb) counter++;
                }
            }
        }
        if (counter == DOTS_TO_WIN) {
            return true;
        }

        // Проверка по диагонали справо-налево

        counter = 0;
        for (int k = DOTS_TO_WIN - SIZE; k <= SIZE - DOTS_TO_WIN; k++)
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (i - (SIZE - 1 - j) == k && map [i][j] == symb) counter++;
                }
            }
        if (counter == DOTS_TO_WIN) {
            return true;
        }

        return false;
    }

    public static boolean blockHumanTurn(char symb_human, char symb_ai, char symb_empty) {

        int counter;

        // Проверка ходов человека по строкам, если человек в одном ходу от победы, то блокировать

        for (int i = 0; i < SIZE; i++) {
            counter = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb_human && map[i][j] != symb_ai) counter++;
            }
            if (counter == DOTS_TO_WIN - 1) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] == symb_empty) {
                        map[i][j] = symb_ai;
                        return true;
                    }
                }
            }
        }

        // Проверка ходов человека по столбцам, если человек в одном ходу от победы, то блокировать

        for (int j = 0; j < SIZE; j++) {
            counter = 0;
            for (int i = 0; i < SIZE; i++) {
                if (map[i][j] == symb_human && map[i][j] != symb_ai) counter++;
            }
            if (counter == DOTS_TO_WIN - 1) {
                for (int i = 0; i < SIZE; i++) {
                    if (map[i][j] == symb_empty) {
                        map[i][j] = symb_ai;
                        return true;
                    }
                }
            }
        }

        // Проверка ходов человека по диагоналям слева-направо, если человек в одном ходу от победы, то блокировать

        counter = 0;
        for (int k = DOTS_TO_WIN - SIZE; k <= SIZE - DOTS_TO_WIN; k++) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (i - j == k && map[i][j] == symb_human && map[i][j] != symb_ai) counter++;
                }
            }
        }
        if (counter == DOTS_TO_WIN - 1) {
            for (int k = DOTS_TO_WIN - SIZE; k <= SIZE - DOTS_TO_WIN; k++) {
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if (i - j == k && map[i][j] == symb_empty) {
                            map[i][j] = symb_ai;
                            return true;
                        }
                    }
                }
            }
        }

        // Проверка ходов человека по диагоналям справа-налево, если человек в одном ходу от победы, то блокировать

        counter = 0;
        for (int k = DOTS_TO_WIN - SIZE; k <= SIZE - DOTS_TO_WIN; k++) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (i - (SIZE - 1 - j) == k && map[i][j] == symb_human && map[i][j] != symb_ai) counter++;
                }
            }
        }
        if (counter == DOTS_TO_WIN - 1) {
            for (int k = DOTS_TO_WIN - SIZE; k <= SIZE - DOTS_TO_WIN; k++) {
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if (i - (SIZE - 1 - j) == k && map[i][j] == symb_empty) {
                            map[i][j] = symb_ai;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
