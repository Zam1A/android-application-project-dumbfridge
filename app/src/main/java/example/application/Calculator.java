package example.application;

import example.data.FoodCalculator;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<FoodCalculator> foods = new ArrayList<>();
        String foodName;
        double foodCalories;
        double foodWeight;
        char answer;

        do {
            System.out.print("Enter the name of the food: ");
            foodName = scanner.nextLine();

            System.out.print("Enter the calories per 100g of the food: ");
            foodCalories = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter the weight of the food in grams: ");
            foodWeight = Double.parseDouble(scanner.nextLine());

            foods.add(new FoodCalculator(foodName, foodCalories, foodWeight));

            System.out.print("Do you want to enter another food? (y/n): ");
            answer = scanner.nextLine().charAt(0);
        } while (answer == 'y' || answer == 'Y');

        double totalCalories = 0;
        for (FoodCalculator food : foods) {
            totalCalories += food.getCaloriesPerGram() * food.getWeight();
        }

        System.out.println("Total calories: " + totalCalories);
    }
}