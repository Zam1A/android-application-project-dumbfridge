package example.data;

import example.application.user.Address;

import java.util.ArrayList;

/**
 * Represents a user of the application.
 */
public class User {
    private String name;
    private String password;
    private String email;

    private Address address;


    /**
     * Creates a new User.
     *
     * @param name     The name of the user.
     * @param password The password of the user.
     * @param email    The email of the user.
     */
    public User(String name, String password, String email) throws InvalidUserException {
        this.name = name;
        setPassword(password);
        setEmail(email);
    }

    /**
     * Gets the name of the user.
     *
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the password of the user.
     *
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the email of the user.
     *
     * @return The email of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the name of the user.
     *
     * @param newName The new name of the user.
     */
    public void setName(String newName) {
        this.name = newName;
    }

    public void setAddress(int unitNumber, int streetNumber, String streetName,
                           String suburb, String state, int postCode) {
        this.address = new Address(unitNumber, streetNumber, streetName, suburb, state, postCode);
    }
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

}
