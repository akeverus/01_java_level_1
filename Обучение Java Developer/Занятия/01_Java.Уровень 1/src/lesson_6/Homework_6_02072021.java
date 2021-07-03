package lesson_6;

public class Homework_6_02072021 {

    public static void main(String[] args) {
        Animal animal1 = new Animal("Джерри", 6);
        animal1.howManyAnimal();
        Cat cat1 = new Cat("Том", 7);
        cat1.howManyCat();
        Dog dog1 = new Dog("Спайк", 8);
        dog1.howManyDog();

        cat1.run(250);
        cat1.swim(250);

        dog1.run(250);
        dog1.swim(250);
    }

}
