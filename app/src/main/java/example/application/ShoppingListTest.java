package example.application;

import example.data.Food;
import example.data.ShoppingList;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingListTest {

    private ShoppingList shoppingList = new ShoppingList();

    @Test
    public void testShoppingListAddItem() {
        shoppingList.addItem("Bannana");
        Assert.assertEquals("Bannana", shoppingList.getRecent());
    }

    @Test
    public void testShoppingListGetItems() {
        shoppingList.addItem("Pizza");
        shoppingList.addItem("Ice Cream");
        Assert.assertEquals("[Bannana], [Pizza], [Ice Cream]", shoppingList.getItems());
    }

    @Test
    public void testShoppingListRemoveItem() {
        shoppingList.removeItem("Ice Cream");
        //if remove is successful recent should be 1 before what was removed
        Assert.assertEquals("Pizza", shoppingList.getRecent());
    }

    @Test
    public void testShoppingListAddEmpty() {
        shoppingList.addItem("");
        //expected to not add empty so recent should be same as before
        Assert.assertEquals("Pizza", shoppingList.getRecent());
    }

    @Test
    public void testShoppingListRemoveEmpty() {
        shoppingList.removeItem("");
        //expected to not remove empty so recent should be same as before
        Assert.assertEquals("Pizza", shoppingList.getRecent());
    }
}
