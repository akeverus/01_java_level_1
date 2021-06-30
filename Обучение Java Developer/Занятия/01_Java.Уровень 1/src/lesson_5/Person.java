package lesson_5;

public class Person {
    private String name;
    private String position;
    private String mail;
    private String numberTelephone;
    private int revenue;
    private int age;

    public Person () {
    }

    public Person(String name, String position, String mail, String numberTelephone, int revenue, int age) {
        this.name = name;
        this.position = position;
        this.mail = mail;
        this.numberTelephone = numberTelephone;
        this.revenue = revenue;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNumberTelephone() {
        return numberTelephone;
    }

    public void setNumberTelephone(String numberTelephone) {
        this.numberTelephone = numberTelephone;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", mail='" + mail + '\'' +
                ", numberTelephone='" + numberTelephone + '\'' +
                ", revenue=" + revenue +
                ", age=" + age +
                '}';
    }

}
