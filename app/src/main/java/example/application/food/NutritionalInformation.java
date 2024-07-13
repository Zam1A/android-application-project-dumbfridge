package example.application.food;

import java.util.ArrayList;

public class NutritionalInformation {

    /** Serving size of food item*/
    private int servingSize;

    /** Number of servings per package */
    private int servingsPerPack;

    /** Energy in kJ per 100g */
    private int energyPer100g;

    /** Total amount of fats in foodItem per 100g */
    private int fatTotalPer100g;

    /** Amount of saturated fats in foodItem per 100g */
    private int satFatPer100g;

    /** Amount of carbohydrates in foodItem per 100g */
    private int carbsPer100g;

    /** Amount of sugars in foodItem per 100g */
    private int sugarsPer100g;

    /** Amount of sodium in foodItem per 100g */
    private int sodiumPer100g;

    /** Allergens contained in the foodItem. For Example:
     * nuts, fish, shellfish, milk products, soy, gluten etc. */
    private ArrayList<String> Allergens;

    /**
     * Creates an Instance of Nutritional Information
     * @param servingSize The size of a serving in grams
     * @param servingsPerPack Number of servings per package
     */
    public NutritionalInformation(int servingSize, int servingsPerPack) {
        this.servingSize = servingSize;
        this.servingsPerPack = servingsPerPack;
    }

    /**
     * Creates an Instance of Nutritional Information
     * @param servingSize The size of a serving in grams
     * @param servingsPerPack Number of servings per package
     * @param energyPer100g Energy in kJ per 100g
     * @param fatTotalPer100g Total amount of fats in foodItem per 100g
     * @param satFatPer100g Amount of saturated fats in foodItem per 100g
     * @param carbsPer100g Amount of carbohydrates in foodItem per 100g
     * @param sugarsPer100g Amount of sugars in foodItem per 100g
     * @param sodiumPer100g Amount of sodium in foodItem per 100g
     * @param allergens Allergens contained in the foodItem
     */
    public NutritionalInformation(int servingSize, int servingsPerPack, int energyPer100g,
                                  int fatTotalPer100g, int satFatPer100g, int carbsPer100g,
                                  int sugarsPer100g, int sodiumPer100g, ArrayList<String> allergens) {
        this.servingSize = servingSize;
        this.servingsPerPack = servingsPerPack;
        this.energyPer100g = energyPer100g;
        this.fatTotalPer100g = fatTotalPer100g;
        this.satFatPer100g = satFatPer100g;
        this.carbsPer100g = carbsPer100g;
        this.sugarsPer100g = sugarsPer100g;
        this.sodiumPer100g = sodiumPer100g;
        Allergens = allergens;
    }

    public int getServingSize() {
        return servingSize;
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public int getServingsPerPack() {
        return servingsPerPack;
    }

    public void setServingsPerPack(int servingsPerPack) {
        this.servingsPerPack = servingsPerPack;
    }

    public int getEnergyPer100g() {
        return energyPer100g;
    }

    public void setEnergyPer100g(int energyPer100g) {
        this.energyPer100g = energyPer100g;
    }

    public int getFatTotalPer100g() {
        return fatTotalPer100g;
    }

    public void setFatTotalPer100g(int fatTotalPer100g) {
        this.fatTotalPer100g = fatTotalPer100g;
    }

    public int getSatFatPer100g() {
        return satFatPer100g;
    }

    public void setSatFatPer100g(int satFatPer100g) {
        this.satFatPer100g = satFatPer100g;
    }

    public int getCarbsPer100g() {
        return carbsPer100g;
    }

    public void setCarbsPer100g(int carbsPer100g) {
        this.carbsPer100g = carbsPer100g;
    }

    public int getSugarsPer100g() {
        return sugarsPer100g;
    }

    public void setSugarsPer100g(int sugarsPer100g) {
        this.sugarsPer100g = sugarsPer100g;
    }

    public int getSodiumPer100g() {
        return sodiumPer100g;
    }

    public void setSodiumPer100g(int sodiumPer100g) {
        this.sodiumPer100g = sodiumPer100g;
    }

    public ArrayList<String> getAllergens() {
        return Allergens;
    }

    public void setAllergens(ArrayList<String> allergens) {
        Allergens = allergens;
    }

    public void AddAllergen(String allergen) {
        Allergens.add(allergen);
    }

}
