package at.htlgkr.naughtyornice;

public class Person {
    private String firstname;
    private String lastname;
    private String age;
    private String wish;
    private boolean behavior;

    public Person(String firstname, String lastname, String age, String wish, boolean behavior) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.wish = wish;
        this.behavior = behavior;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String  getAge() {
        return age;
    }

    public String getWish() {
        return wish;
    }

    public boolean isBehavior() {
        return behavior;
    }
}
