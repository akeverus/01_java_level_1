package lesson_5;

public class Homework_5_29062021 {

    public static void main(String[] args) {

        Person[] persons = new Person[4];
        for (int i = 0; i < persons.length; i++) {
            persons[i] = new Person("Sergey " + i,
                    "Developer " + i,
                    "sergey" + i + "gmail.com",
                    "8900800706" + i,
                    50000 + 10000 * i,
                    20 + 10 * i);

            if (persons[i].getAge() >= 40) {
                System.out.println(persons[i]);
            }
        }
    }
}
