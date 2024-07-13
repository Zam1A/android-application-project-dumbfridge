package example.application;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import example.data.ShoppingList;
import example.data.StaticUserDAO;
import example.data.User;
import android.content.SharedPreferences;



import java.util.ArrayList;
import java.util.List;

/**
 * Represents the main view of the application.
 */
public class MainViewActivity extends AppCompatActivity {
    private StaticUserDAO staticUserDAO = new StaticUserDAO();
    // Declare class variables for the views
    private TextView currentUserTextView;
    private Button logoutButton;
    private Button userButton;
    private Button expiryCheckButton;
    private Button suggestionButton;
    private Button newListButton;
    private Button continueButton;
    private Button settingsButton;
    private ListView usersListView;
    private ArrayAdapter<User> usersAdapter;

    private User currentUser;


    /**
     * Creates the main view.
     *
     * @param savedInstanceState the saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);

        // Initialize the views
        currentUserTextView = findViewById(R.id.current_user_textview);
        logoutButton = findViewById(R.id.logout_button);
        newListButton = findViewById(R.id.new_list_button);
        expiryCheckButton = findViewById(R.id.expiry_check_btn);
        usersListView = findViewById(R.id.users_listview);
        userButton = findViewById(R.id.buttonUserPage);
        suggestionButton = findViewById(R.id.buttonMealSuggestion);
        settingsButton = findViewById(R.id.new_button);
        settingsButton.setOnClickListener(v -> settingsButtonClick());

        // Retrieve the current logged in user from the Intent extras
        Intent intent = getIntent();
        String currentUser = intent.getStringExtra("CURRENT_USER");
        currentUserTextView.setText("Welcome, " + currentUser);

        // Create the user list view
        createUsersAdapter();

        // Set up the log out button click listener
        logoutButton.setOnClickListener(v -> logOutButtonClick());

        Button calculatorButton = findViewById(R.id.calculator_button);

        //Food Calculator
        calculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainViewActivity.this, FoodCalculatorActivity.class);
                startActivity(intent);
            }
        });

        userButton.setOnClickListener(v -> preferencesButtonOnCLick());
        suggestionButton.setOnClickListener(v -> suggestionButtonOnCLick());
        newListButton.setOnClickListener(v -> onNewListButtonClick());
        expiryCheckButton.setOnClickListener(v -> expiryCheckButtonClick());

        // Initialize SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("FontSizePref", MODE_PRIVATE);

        int fontSize = sharedPreferences.getInt("fontSize", 16);

        currentUserTextView.setTextSize(fontSize);

    }

    /**
     * Event handler for the user settings button click event.
     */
    private void preferencesButtonOnCLick() {
        Intent intent = new Intent(MainViewActivity.this, PreferencesActivity.class);
        startActivity(intent);
        finish();
    }

    // creates new shopping list
    ShoppingList dfList = new ShoppingList();

    // I have the button showing up but no functionality yet
    private void onNewListButtonClick() {
        Intent intent = new Intent(MainViewActivity.this, NewListActivity.class);
/*
        intent.putExtra("CURRENT_USER", currentUser.getName());
*/
        startActivity(intent);
        finish();
    }

    /**
     * Event handler for the log out button click event.
     */
    private void logOutButtonClick() {
        // Transition back to the login view
        Intent intent = new Intent(MainViewActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void expiryCheckButtonClick() {
        // Transition to the next screen view
        Intent intent = new Intent(this, FoodEntry.class);
        //intent.putExtra("CURRENT_USER", currentUser.getName());
        startActivity(intent);
        finish();

    }


    /**
     * Event handler for the meal suggestion button click event.
     */
    private void suggestionButtonOnCLick() {
        //  Transition to Meal Suggestion View
        Intent intent = new Intent(MainViewActivity.this, ProvideRecipeActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * Creates the users adapter, which populates the ListView with the users.
     */
    private void createUsersAdapter() {
        // Add some sample users
        List<User> users = new ArrayList<>(staticUserDAO.listUsers());

        // Initialize the ListView and the ArrayAdapter
        usersListView = findViewById(R.id.users_listview);
        usersAdapter = new UserListAdapter(this, users);

        // Set the ArrayAdapter on the ListView
        usersListView.setAdapter(usersAdapter);
    }
    private void settingsButtonClick() {
        Intent intent = new Intent(MainViewActivity.this, SettingsActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * Represents the adapter for the user list view. This adapter is responsible for
     * populating the ListView with the users.
     */
    public class UserListAdapter extends ArrayAdapter<User> {

        /**
         * Creates a new UserListAdapter.
         *
         * @param context the context
         * @param users   the list of users to display
         */
        public UserListAdapter(Context context, List<User> users) {
            super(context, 0, users);
        }

        /**
         * Gets the view for the user at the specified position.
         *
         * @param position    the position
         * @param convertView the view to convert
         * @param parent      the parent view
         * @return the view
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            User user = getItem(position);

            // Check if an existing view is being reused, otherwise inflate the view
            // This view use the item_user layout as the template
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
            }

            // Lookup views within item layout
            TextView emailTextView = convertView.findViewById(R.id.email_textview);
            TextView nameTextView = convertView.findViewById(R.id.name_textview);

            // Populate the data into the template view using the data object
            emailTextView.setText(user.getEmail());
            nameTextView.setText(user.getName());

            // Return the completed view to render on screen
            return convertView;
        }
    }
//    private void launchMenuView() {
//
//    }
}
