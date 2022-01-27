package model;

public class Deals {
    private String name;
    private String company;
    private String contact;
    private String budget;
    private String status;
    private int id;
    public Deals(String name,String company,String contact,String budget,String status,int id)
    {
        this.name=name;
        this.company=company;
        this.contact=contact;
        this.budget=budget;
        this.status=status;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getContact() {
        return contact;
    }

    public String getBudget() {
        return budget;
    }

    public String getStatus() {
        return status;
    }
    public int getId() {
        return id;
    }
}
