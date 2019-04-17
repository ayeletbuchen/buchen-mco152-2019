package buchen.net;

public class Address {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geography geo;

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", suite='" + suite + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", geo=" + geo +
                '}';
    }
}
