package example.application.food;


import java.util.ArrayList;

public abstract class FoodItem {
    private String foodName;
    private NutritionalInformation nutritionalInformation;

    public FoodItem(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void AddNutritionalInformation(int servingSize, int servingsPerPack, int energyPer100g,
                                          int fatTotalPer100g, int satFatPer100g, int carbsPer100g,
                                          int sugarsPer100g, int sodiumPer100g, ArrayList<String> allergens) {
        nutritionalInformation = new NutritionalInformation(servingSize, servingsPerPack, energyPer100g,
                fatTotalPer100g, satFatPer100g, carbsPer100g, sugarsPer100g, sodiumPer100g, allergens);
    }

    @Override
    public String toString() {
        return foodName;
    }
}
