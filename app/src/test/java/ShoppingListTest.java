import example.data.ShoppingList;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingListTest {

    private ShoppingList shoppingList = new ShoppingList();

    @Test
    void testShoppingListAddItem() {
        shoppingList.addItem("Bannana");
        Assert.assertEquals("Bannana", shoppingList.getRecent());
    }

    @Test
    void testShoppingListGetItems() {
        shoppingList.addItem("Pizza");
        shoppingList.addItem("Ice Cream");
        Assert.assertEquals("[Bannana], [Pizza], [Ice Cream]", shoppingList.getItems());
    }

    @Test
    void testShoppingListRemoveItem() {
        shoppingList.removeItem("Ice Cream");
        //if remove is successful recent should be 1 before what was removed
        Assert.assertEquals("Pizza", shoppingList.getRecent());
    }

    @Test
    void testShoppingListAddEmpty() {
        shoppingList.addItem("");
        //expected to not add empty so recent should be same as before
        Assert.assertEquals("Pizza", shoppingList.getRecent());
    }

    @Test
    void testShoppingListRemoveEmpty() {
        shoppingList.removeItem("");
        //expected to not remove empty so recent should be same as before
        Assert.assertEquals("Pizza", shoppingList.getRecent());
    }
}
