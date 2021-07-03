package lesson_6;

public class Animal {

    String name;
    int age;
    static int amountAnimal = 0;

    public Animal() {
        amountAnimal++;
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        amountAnimal++;
    }

    public void run(int lenght) {
        System.out.printf("Животное по кличке %s возрастом %d пробежало %d метров \n", name, age, lenght);
    }

    public void swim(int lenght) {
        System.out.printf("Животное по кличке %s возрастом %d проплыло %d метров \n", name, age, lenght);
    }

    public void animalInfo() {
        System.out.printf("Имя = %s, Возраст = %d",name, age);
    }

    public void howManyAnimal(){
        System.out.println("Количество Animal: " + amountAnimal);
    }
}
