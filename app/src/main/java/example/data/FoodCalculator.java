package example.data;

public class FoodCalculator {
    private String name;
    private double caloriesPer100g;
    private double weight;
    public double getCalories() {
        return caloriesPer100g;
    }


    public FoodCalculator(String name, double caloriesPer100g, double weight) {
        this.name = name;
        this.caloriesPer100g = caloriesPer100g;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getCaloriesPer100g() {
        return caloriesPer100g;
    }

    public double getWeight() {
        return weight;
    }

    public double getCaloriesPerGram() {
        return caloriesPer100g / 100;
    }
}