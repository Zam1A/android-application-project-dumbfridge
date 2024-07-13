package example.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Allows the user to create a shopping list
 */
public class ShoppingList {

    /**
     * Makes the list under the param items
     */
    private List<String> items;
    private int count = 0;

    /**
     * initializes the list as an empty ArrayList
     */
    public ShoppingList() {
        items = new ArrayList<String>();
    }

    /**
     * Adds an item to the shopping list
     * @param item the item to be added to the ArrayList
     */
    public void addItem(String item) {
        items.add(item);
        count++;
    }

    /**
     * Removes an item from the shopping list
     * @param item the item to be removed from the ArrayList
     */
    public void removeItem(String item) {
        items.remove(item);
    }

    /**
     * returns the entire list
     * @return returns the shopping list
     */
    public List<String> getItems() {
        return items;
    }

    public String getRecent() { return items.get(count); }

    /**
     * Prints the entire list
     */
    public void printList() {
        System.out.println("Shopping List:");
        for (String item : items) {
            System.out.println("- " + item);
        }
    }

}
