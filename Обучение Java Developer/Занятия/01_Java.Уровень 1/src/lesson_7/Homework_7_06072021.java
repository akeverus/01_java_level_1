package lesson_7;

public class Homework_7_06072021 {

    public static void main(String[] args) {

        Cat cat = new Cat("Barsik", 5, false);
        Plate plate = new Plate(10);

        plate.info();

        if (cat.eat(plate, cat.isSatiety())){
            cat.setSatiety(true);
        }

        plate.info();
        cat.eat(plate, cat.isSatiety());
        System.out.println("Cытость кота " + cat.getName() + " равна " + cat.isSatiety());

        //Массив котов и большая миска

        Plate bigPlate = new Plate(30);
        Cat[] cats = new Cat[4];

        for (int i = 0; i <= cats.length; i++) {

            bigPlate.info();

            cats[i] = new Cat("Кот_" + i, 5 + 2*i,false);
            System.out.println(cats[i].toString());

            if (cats[i].eat(bigPlate, cats[i].isSatiety())){
                cats[i].setSatiety(true);
            }

            bigPlate.info();
            System.out.println("Cытость кота " + cats[i].getName() + " равна " + cats[i].isSatiety());

        }
    }
}
