package at.htlgkr.digitalestelefonbuch;

public class Contact {
    private String firstname;
    private String lastname;
    private String number;
    private boolean favourite;

    public Contact(String firstname, String lastname, String number) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.number = number;
        this.favourite = false;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNumber() {
        return number;
    }

    public boolean getFavourite(){
        return favourite;
    }

    public void setFirstname(boolean favourite){
        this.favourite = favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }
}
