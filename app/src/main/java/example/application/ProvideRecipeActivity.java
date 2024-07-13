package example.application;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class ProvideRecipeActivity extends AppCompatActivity {

    // Ready the views
    private TextView header;
    private TextView subHeader;
    private EditText editUserItem;
    private Button buttonProvideRecipe;
    private TextView recipeHeader;
    private TextView recipeSuggested;
    private Button buttonBack;

    /**
     * Stores the Recipe
     */
    private String recipe = "Please enter a food item so I can suggest a recipe!";

    // Some pre-coded recipes
    private String recipe1 = "Ingredients\n2 Slices Bread (Any Kind)\nButter\n%s"
            + "\n\nRecipe\nStep 1: Place Bread into Toaster and cook for 2-3 minutes " +
            "or until slightly brown\nStep 2: Spread a small amount of butter onto the two " +
            "pieces of toast\nStep 3: Add %s to the toast\nStep 4: Enjoy your meal!";

    private String recipe2 = "Ingredients\n2 Slices Bread (Any Kind)\n1 Slice of Cheese\nButter\n%s"
            + "\n\nRecipe\nStep 1: Place Bread onto plate\nStep 2: Spread Butter onto one piece of bread" +
            "\nStep 3: Place %s onto buttered bread\nStep 4: Place the slice of cheese on top" +
            "\nStep 5: Place other piece of bread on top of cheese\nStep 6: Enjoy your meal!";

    private String recipe3 = "Ingredients\n1 Tub of Yoghurt\nAny Fruit\n%s"
            + "\n\nRecipe\nStep 1: Pour tub of yoghurt into bowl\nStep 2: Cut piece of fruit into" +
            " small pieces and add to bowl\nStep 4: Cut %s into small pieces and add to bowl" +
            "\nStep 5: Mix thoroughly\nStep 6: Enjoy your meal!";

    private String recipe4 = "Ingredients\n3/4 Melted Butter\n1 Teaspoon Salt\n%s"
            + "\n\nRecipe\nStep 1: Preheat oven to 180 degrees C\nStep 2: Mix melted butter " +
            "and salt in a bowl\nStep 3: Place %s onto a baking tray\nStep 3: Pour butter mix " +
            "on top\nStep 4: Cook in oven for 20-30 minutes\nStep 5: Enjoy your meal!";

    private String recipe5 = "Ingredients\nA dip of your choice\n%s"
            + "\n\nRecipe\nStep 1: Open dip of your choice\nStep 2: Cut %s into bite sized pieces" +
            "\nStep 3: Dip pieces into the dip\nStep 4: Enjoy your meal!";

    String[] recipeList = {recipe1, recipe2, recipe3, recipe4, recipe5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provide_recipe);

        // Initialise the views
        header = findViewById(R.id.menuHeader);
        subHeader = findViewById(R.id.subHeader);
        editUserItem = findViewById(R.id.editFoodItem);
        buttonProvideRecipe = findViewById(R.id.buttonProvideRecipe);
        recipeHeader = findViewById(R.id.textRecipeHeader);
        recipeSuggested = findViewById(R.id.textRecipeSuggested);
        buttonBack = findViewById(R.id.buttonGoBack);

        //Initialise Recipe Text
        recipeSuggested.setText(recipe);

        // Set up the button click listener
        buttonProvideRecipe.setOnClickListener(v -> provideRecipeOnClick());
        buttonBack.setOnClickListener(v -> onBackButtonClick());
    }

    /**
     * Returns to the previous screen
     */
    private void onBackButtonClick() {
        Intent intent = new Intent(this, MainViewActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * Provides a random recipe to the user given their choice of food item
     */
    private void provideRecipeOnClick() {
        String userFood = editUserItem.getText().toString();
        Random random = new Random();
        int recipeNum = random.nextInt(5);

        recipe = String.format(recipeList[recipeNum], userFood, userFood);
        recipeSuggested.setText(recipe);
        buttonProvideRecipe.setText("Provide New Recipe");
    }

}