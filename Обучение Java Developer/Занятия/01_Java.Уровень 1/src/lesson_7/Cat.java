package lesson_7;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean satiety;

    public Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public String getName() {
        return name;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }


    public boolean eat(Plate p, boolean satiety) {
        if (!satiety) {
            if (p.getFood() >= appetite) {
                p.decreaseFood(appetite);
                satiety = true;
            }
        } else {
            System.out.println("Кот уже сыт и не будет есть из миски");
        }
        return satiety;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", satiety=" + satiety +
                '}';
    }
}


