package example.application.food;

public class FoodShopList extends FoodItem {
    private int quantity;

    public FoodShopList(String foodName) {
        super(foodName);
    }

    public FoodShopList(String foodName, int quantity) {
        super(foodName);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}


