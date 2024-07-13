package example.data;

// This class will be for identifying the food for a csv entry
public class Food {
    private String foodNameID;
    private String expiryDateID;

    /**
     * Creates a new Food Entry.
     *
     * @param foodName   The name of the food.
     * @param expiryDate The expiry date of the food.
     */
    public Food(String foodName, String expiryDate) {
        this.foodNameID = foodName;
        this.expiryDateID = expiryDate;
    }

    /**
     * Gets the name of the food.
     *
     * @return The name of the food.
     */
    public String getFoodName() {
        return foodNameID;
    }

    /**
     * Gets the expiry date of the food.
     *
     * @return The expiry date of the food.
     */
    public String getexpiryDate() {
        return expiryDateID;
    }


    /**
     * Sets the name of the food.
     *
     * @param newName The new name of the food.
     */
    public void setName(String newName) {
        this.foodNameID = newName;
    }
}
