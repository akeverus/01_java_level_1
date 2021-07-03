package lesson_6;

public class Dog extends Animal {

    int amountDog;

    public Dog() {
        super();
        amountDog++;
    }

    public Dog(String name, int age) {
        super(name, age);
        amountDog++;
    }

    @Override
    public void run (int lenght) {
        if (lenght >= 0) {
            if (lenght <= 500) {
                super.run(lenght);
            } else {
                System.out.println("Собака не может бегать больше 500 метров");
            }
        } else {
            System.out.println("Расстояние не может быть отрицательным");
        }
    }

    @Override
    public void swim(int lenght) {
        if (lenght >= 0) {
            if (lenght <= 10) {
                super.swim(lenght);
            } else {
                System.out.println("Собака не может плавать больше 10 метров");
            }
        } else {
            System.out.println("Расстояние не может быть отрицательным");
        }
    }

    public void howManyDog(){
        super.howManyAnimal();
        System.out.println("Количество Dog: " + amountDog);
    }
}
