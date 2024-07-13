package example.application.user;

public class Address {
    private int unitNumber;
    private int streetNumber;
    private String streetName;
    private String suburb;
    private String state;
    private int postCode;

    public Address(int unitNumber, int streetNumber, String streetName,
                   String suburb, String state, int postCode) {
        this.unitNumber = unitNumber;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.suburb = suburb;
        this.state = state;
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        if (unitNumber == 0) {
            return String.format("%x %s %s, %s %s %i", streetNumber, streetName,
                    suburb, state, postCode);
        } else {
            return String.format("%x/%x %s %s, %s %s %i", unitNumber, streetNumber, streetName,
                    suburb, state, postCode);
        }
    }
}
