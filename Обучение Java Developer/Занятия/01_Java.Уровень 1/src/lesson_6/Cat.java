package lesson_6;

public class Cat extends Animal{

    int amountCat;

    public Cat() {
        super();
        amountCat++;
    }

    public Cat(String name, int age) {
        super(name, age);
        amountCat++;
    }

    @Override
    public void run (int lenght) {
        if (lenght >= 0) {
            if (lenght <= 200) {
                super.run(lenght);
            } else {
                System.out.println("Кот не может бегать больше 200 метров");
            }
        } else {
            System.out.println("Расстояние не может быть отрицательным");
        }
    }

    @Override
    public void swim(int lenght) {
        if (lenght >= 0) {
            System.out.println("Коты не могут плавать");
        } else {
            System.out.println("Расстояние не может быть отрицательным");
        }
    }

    public void howManyCat(){
        super.howManyAnimal();
        System.out.println("Количество Cat: " + amountCat);
    }
}
