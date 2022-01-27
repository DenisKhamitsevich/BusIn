package model;

public class Person {
    private String email;
    private String password;
    private String name;
    private String surname;
    private int amount_of_com;
    private int amount_of_ppl;
    private int amount_of_deals;
    public Person(String email, String password, String name, String surname, int amount_of_com, int amount_of_ppl, int amount_of_deals){
        this.email=email;
        this.password=password;
        this.name=name;
        this.surname=surname;
        this.amount_of_com=amount_of_com;
        this.amount_of_ppl=amount_of_ppl;
        this.amount_of_deals=amount_of_deals;
    }
    public String getEmail()
    {
        return this.email;
    }
    public String getPassword()
    {
        return this.password;
    }
    public String getName()
    {
        return this.name;
    }
    public String getSurname()
    {
        return this.surname;
    }
    public int getAmount_of_com()
    {
        return this.amount_of_com;
    }
    public int getAmount_of_ppl()
    {
        return this.amount_of_ppl;
    }
    public int getAmount_of_deals()
    {
        return this.amount_of_deals;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAmount_of_com(int amount_of_com) {
        this.amount_of_com = amount_of_com;
    }

    public void setAmount_of_ppl(int amount_of_ppl) {
        this.amount_of_ppl = amount_of_ppl;
    }

    public void setAmount_of_deals(int amount_of_deals) {
        this.amount_of_deals = amount_of_deals;
    }
}
