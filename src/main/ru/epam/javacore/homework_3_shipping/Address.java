package main.ru.epam.javacore.homework_3_shipping;

public class Address {
    private String country;
    private String city;
    private String zipCode;
    private String street;
    private String streetNumber;
    private String apartment;

    public Address(String country, String city, String zipcode, String street, String streetNumber, String apartment) {
        this.country = country;
        this.city = city;
        this.zipCode = zipcode;
        this.street = street;
        this.streetNumber = streetNumber;
        this.apartment = apartment;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}
