package example.application;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class AccountSystemTests {
    @Test
    public void createUserWithValidInput() {

        AccountSystem accountSystem = new AccountSystem();
        accountSystem.createUser("BillG", "bissonm123!");
        ArrayList<String> usernames = accountSystem.getUsernames();
        Assert.assertTrue(usernames.contains("BillG"));
    }

    @Test
    public void  changePasswordWithValidInput() {

        AccountSystem accountSystem = new AccountSystem();
        accountSystem.createUser("BillG", "bissonm123!");
        accountSystem.changePassword("BillG", "bissonm123!", "newpass");
        Assert.assertTrue(accountSystem.isValidUser("BillG", "newpass"));

    }

    @Test
    public void testCreateUserExisting() {
        AccountSystem accountSystem = new AccountSystem();

        // add a user with the same username as an existing user
        accountSystem.createUser("john", "password123");
        accountSystem.createUser("john", "password456");

        // assert that the file can contain multiple users with the same username
        ArrayList<String> usernames = accountSystem.getUsernames();
        Assert.assertEquals(2, Collections.frequency(usernames, "john"));
    }

    @Test
    public void   deleteUserWithExistingUser() {

        AccountSystem accountSystem = new AccountSystem();
        accountSystem.createUser("BillG", "bissonm123!");
        accountSystem.deleteUser("BillG");
        ArrayList<String> usernames = accountSystem.getUsernames();
        Assert.assertFalse(usernames.contains("BillG"));
    }

    @Test
    public void   isValidUserTrue() {

        AccountSystem accountSystem = new AccountSystem();
        accountSystem.createUser("BillG", "bissonm123!");
        Assert.assertTrue(accountSystem.isValidUser("BillG", "bissonm123!"));

    }

}