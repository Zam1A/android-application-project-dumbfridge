package example.application;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AccountSystem {

    public void createUser(String username, String password) {
        // create a string with the user's data
        String userData = username + ":" + password;

        // define the filename and path
        String filename = "users.txt";

        try {
            // open the file in append mode
            FileWriter writer = new FileWriter(filename, true);

            // write the user's data to the file
            writer.write(userData + "\n");

            // close the file
            writer.close();

            System.out.println("User created successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while creating the user.");
            e.printStackTrace();
        }
    }

    public void changePassword(String username, String oldPassword, String newPassword) {
        // define the filename and path
        String filename = "users.txt";

        try {
            // create a temporary file to write the updated data to
            File tempFile = new File(filename + ".tmp");
            PrintWriter writer = new PrintWriter(tempFile);

            // read the file line by line and update the user's password if found
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            boolean userFound = false;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(":");
                if (userData[0].equals(username) && userData[1].equals(oldPassword)) {
                    // replace the old password with the new password
                    line = username + ":" + newPassword;
                    userFound = true;
                }
                writer.println(line);
            }
            reader.close();
            writer.close();

            if (userFound) {
                // delete the original file and rename the temporary file
                File originalFile = new File(filename);
                originalFile.delete();
                tempFile.renameTo(originalFile);

                System.out.println("Password changed successfully!");
            } else {
                System.out.println("User not found or incorrect password.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while changing the password.");
            e.printStackTrace();
        }
    }
    public ArrayList<String> getUsernames() {
        // define the filename and path
        String filename = "users.txt";

        // create a list to store the usernames
        ArrayList<String> usernames = new ArrayList<>();

        try {
            // read the file line by line and extract the username from each line
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(":");
                String username = userData[0];
                usernames.add(username);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while getting the usernames.");
            e.printStackTrace();
        }

        // return the list of usernames
        return usernames;
    }

    public void deleteUser(String username) {
        // define the filename and path
        String filename = "users.txt";

        try {
            // create a temporary file to write the updated data to
            File tempFile = new File(filename + ".tmp");
            FileWriter writer = new FileWriter(tempFile);

            // read the file line by line and skip the user to delete
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            boolean userFound = false;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(":");
                if (userData[0].equals(username)) {
                    userFound = true;
                    continue; // skip this line (i.e., the user to delete)
                }
                writer.write(line + "\n"); // write the line to the temporary file
            }
            reader.close();
            writer.close();

            if (userFound) {
                // delete the original file and rename the temporary file
                File originalFile = new File(filename);
                originalFile.delete();
                tempFile.renameTo(originalFile);

                System.out.println("User deleted successfully!");
            } else {
                System.out.println("User not found.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while deleting the user.");
            e.printStackTrace();
        }
    }

    public boolean isValidUser(String username, String password) {
        // define the filename and path
        String filename = "users.txt";

        try {
            // read the file line by line and check if the user exists
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(":");
                String storedUsername = userData[0];
                String storedPassword = userData[1];
                if (storedUsername.equals(username) && storedPassword.equals(password)) {
                    reader.close();
                    return true; // the user exists and has the correct password
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while checking the user.");
            e.printStackTrace();
        }

        // the user does not exist or has an incorrect password
        return false;
    }

}
