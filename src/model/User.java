package model;

public class User {
    private Long id;
    private String email;
    private String password;
    private String fullName;
    private City city;

    public User(Long id, String email, String password, String fullName, City city) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.city = city;
    }

    public User () {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
