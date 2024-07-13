package example.data;

import java.util.Set;

public interface FoodDAO {
    void addFood(Food food);

    /**
     * Extracts all the details of a User from the address book based on the
     * email passed in.
     *
     * @param foodName The foodName as a String to search for.
     * @return all details in a Food object for the foodName
     */
    Food getFood(String foodName);

    /**
     * Updates Food in the food list.
     *
     * @param food Food to update
     */
    void updateFoods(Food food);

    /**
     * Deletes Food from the food list.
     *
     * @param foodName The foodName of the Food to delete from the food list.
     */
    void deleteFood(String foodName);

    /**
     * Gets a list of all the foods in the food list.
     *
     * @return A Set of all the foods in the food list.
     */
    Set<Food> listFoods();

    /**
     * Finalizes any resources used by the data source and ensures data is
     * persisited.
     */
    void close();
}
