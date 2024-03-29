package model;

public class City {
    private Long id;
    private String name;
    private String code;
    private Country country;

    public City(Long id, String name, String code, Country country) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.country = country;
    }
    public City() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
