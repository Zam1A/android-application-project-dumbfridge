/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

package example.application;

import example.data.Food;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FoodExpiryTest {

    private FoodEntry foodEntry;

    @Test
    public void testGetFoodName() {
        Food food = new Food("apple", "2023-05-20");
        Assert.assertEquals("apple", food.getFoodName());
    }

    @Test
    public void testGetExpiryDate() {
        Food food = new Food("apple", "2023-05-20");
        Assert.assertEquals("2023-05-20", food.getexpiryDate());
    }

    @Test
    public void testSetName() {
        Food food = new Food("apple", "2023-05-20");
        food.setName("banana");
        Assert.assertEquals("banana", food.getFoodName());
    }

    @Test
    public void testConstructor() {
        Food food = new Food("apple", "2023-05-20");
        Assert.assertNotNull(food);
    }

    @Test
    public void testNullInput() {
        Food food = new Food(null, null);
        Assert.assertNull(food.getFoodName());
        Assert.assertNull(food.getexpiryDate());
    }
}