package lk.ijse.intro.dto;

public class Customer {

    private String id;
    private String name;
    private String city;

    // No-arg constructor (VERY IMPORTANT for Spring)
    public Customer() {
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
