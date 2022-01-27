package model;

public class People {
    private String name;
    private String company;
    private String phone;
    private String role;
    private String custom_email;
    private int id;
    public People(String name,String company,String phone,String role,String custom_email,int id)
    {
        this.name=name;
        this.company=company;
        this.phone=phone;
        this.role=role;
        this.custom_email=custom_email;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getPhone() {
        return phone;
    }

    public String getRole() {
        return role;
    }

    public String getCustom_email() {
        return custom_email;
    }
    public int getId() {
        return id;
    }
}
