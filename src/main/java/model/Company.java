package model;

public class Company {
    private String name;
    private String site;
    private String phone;
    private String address;
    private String location;
    private int id;
    public Company(String name, String site, String phone, String address, String location,int id)
    {
        this.name=name;
        this.site=site;
        this.phone=phone;
        this.address=address;
        this.location=location;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public String getSite() {
        return site;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getLocation() {
        return location;
    }

    public int getId() {
        return id;
    }
}
