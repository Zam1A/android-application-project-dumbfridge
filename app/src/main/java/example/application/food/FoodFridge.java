package example.application.food;

import java.util.Date;

public class FoodFridge extends FoodItem {

    /** Quantity of item in fridge */
    private int quantity;

    /** expiryDate of FoodItem in fridge */
    private Date expiryDate;

    /** Denotes if the product can be frozen. Thus extending its lifetime. */
    private boolean canFreeze;

    /**
     * Creates a food item located within the fridge
     * @param foodName The name of the FoodItem in the fridge
     */
    public FoodFridge(String foodName) {
        super(foodName);
    }

    /**
     * Creates an instance of Fridge FoodItem
     * @param foodName The name of the FoodItem in the fridge
     * @param quantity Quantity of item in fridge
     * @param expiryDate expiryDate of FoodItem in fridge
     * @param canFreeze Denotes if the product can be frozen
     */
    public FoodFridge(String foodName, int quantity, Date expiryDate, boolean canFreeze) {
        super(foodName);
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.canFreeze = canFreeze;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isCanFreeze() {
        return canFreeze;
    }

    public void setCanFreeze(boolean canFreeze) {
        this.canFreeze = canFreeze;
    }
}
