package example.application;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputEditText;
import example.data.ShoppingList;
import example.data.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the login view of the application.
 */
public class NewListActivity extends AppCompatActivity {
    // Declare class variables for the views

    private ShoppingList userShoppingList = new ShoppingList();
    //private String inList;
    private ListView shoppingListView;
    private Button logoutButton;
    private Button newItemButton;
    private Button backButton;
    private TextInputEditText shoppingListInput;
    private ArrayList<String> shoppingList = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_list);

        shoppingListView = findViewById(R.id.shopping_list_view);
        logoutButton = findViewById(R.id.logout_button);
        newItemButton = findViewById(R.id.new_item_button);
        shoppingListInput = findViewById(R.id.shopping_list_input);
        backButton = findViewById(R.id.buttonBacktoMenu);

        logoutButton.setOnClickListener(v -> onLogoutButtonClick());
        newItemButton.setOnClickListener(v -> onNewItemButtonClick());
        backButton.setOnClickListener(v -> onBackButtonClick());

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, shoppingList);
        shoppingListView.setAdapter(adapter);

        adapter.add("Shopping List:");
       // adapter.notifyDataSetChanged();

    }
    /**
     * Event handler for the back button click event.
     */
    private void onBackButtonClick(){
        // Transitions back to main menu
        Intent intent = new Intent(NewListActivity.this, MainViewActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * Event handler for the New Item button click event.
     */
    private void onNewItemButtonClick() {
        String item = shoppingListInput.getText().toString();
        if (item.isEmpty()){}
        else {
            userShoppingList.addItem(item);
            adapter.add(item);
            shoppingListInput.setText("");
        }
    }

    /**
     * Event handler for the login button click event.
     */
    private void onLogoutButtonClick(){
        // Transition back to the login view
        Intent intent = new Intent(NewListActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    }