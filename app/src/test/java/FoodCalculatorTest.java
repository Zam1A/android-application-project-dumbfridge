import example.data.FoodCalculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FoodCalculatorTest {

    @Test
    public void testGetCaloriesPerGram() {
        // Create a FoodCalculator object
        FoodCalculator food = new FoodCalculator("Apple", 52.0, 100.0);

        // Verify that the getCaloriesPerGram method returns the correct value
        double expectedCaloriesPerGram = 0.52;
        double actualCaloriesPerGram = food.getCaloriesPerGram();
        Assert.assertEquals(actualCaloriesPerGram, expectedCaloriesPerGram);
    }

    @Test
    public void testCalculateTotalCalories() {
        // Create multiple FoodCalculator objects
        FoodCalculator food1 = new FoodCalculator("Apple", 52.0, 100.0);
        FoodCalculator food2 = new FoodCalculator("Banana", 96.0, 150.0);
        FoodCalculator food3 = new FoodCalculator("Orange", 43.0, 80.0);

        // Create an array of FoodCalculator
        FoodCalculator[] foods = {food1, food2, food3};

        // Calculate the total calories
        double totalCalories = 0;
        for (FoodCalculator food : foods) {
            totalCalories += food.getCaloriesPerGram() * food.getWeight();
        }

        // Verify that the calculated total calories are correct
        double expectedTotalCalories = 6680.0;
        Assert.assertEquals(totalCalories, expectedTotalCalories);
    }

    @Test
    public void testFoodCalculatorConstructor() {
        // Create a FoodCalculator object
        FoodCalculator food = new FoodCalculator("Apple", 52.0, 100.0);

        // Verify that the object's properties are correctly set
        Assert.assertEquals(food.getName(), "Apple");
        Assert.assertEquals(food.getCalories(), 52.0);
        Assert.assertEquals(food.getWeight(), 100.0);
    }
}
