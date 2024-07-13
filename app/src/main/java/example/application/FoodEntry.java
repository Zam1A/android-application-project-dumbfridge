package example.application;


import android.content.Context;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class FoodEntry extends AppCompatActivity {

//    public FileIO fileIO = new FileIO();
//    java.util.List<Food_ExpiryDTO> food;

    private EditText foodName;
    private EditText expiryDate;

    private Button addFoodButton;
    private Button backButton;
    private static final String TAG = "FoodEntry";
    private ListView foodsListView;
    private ArrayList<String> foods = new ArrayList<>();
    ArrayAdapter<String> adapter;

    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_entry);

        // Initialize the views
        foodName = findViewById(R.id.foodNameText);
        expiryDate = findViewById(R.id.expiryDateText);
        addFoodButton = findViewById(R.id.add_Food_Btn);
        backButton = findViewById(R.id.back_Btn);
        foodsListView = findViewById(R.id.foods_listview);

        addFoodButton.setOnClickListener(view -> addFoodButtonClick(view));
        backButton.setOnClickListener(v -> backButtonClick());

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, foods);
        foodsListView.setAdapter(adapter);

        // Read the CSV file and populate the adapter
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.expiry_dates);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(", ");
                if (values.length == 2) {
                    String foodName = values[0];
                    String expiryDateString = values[1];

                    // Parse the expiry date from the CSV file
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
                    Date expiryDate = dateFormat.parse(expiryDateString);

                    // Compare the expiry date with today's date
                    Calendar calendar = Calendar.getInstance();
                    Date today = calendar.getTime();
                    boolean hasExpired = expiryDate.before(today);

                    // Create the adapter item based on the expiry status
                    String adapterItem;
                    if (hasExpired) {
                        adapterItem = foodName + ", Passed expired date (" + expiryDateString + ")";
                    } else {
                        adapterItem = foodName + ", Expiry Date: " + expiryDateString;
                    }

                    // Add the item to the adapter
                    adapter.add(adapterItem);
                }
            }
            reader.close();
        } catch (IOException e) {
            Log.e(TAG, "Error reading CSV file: " + e.getMessage());
        } catch (ParseException e) {
            Log.e(TAG, "Error parsing expiry date: " + e.getMessage());
        }

    }

    public boolean checkExpiryDate(String expiryDateInput) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        dateFormat.setLenient(false);
        dateFormat.parse(expiryDateInput);
        return true;
    }

    private void addFoodButtonClick(View view) {
        // Get the input from the EditText views
        String foodNameInput = foodName.getText().toString();
        String expiryDateInput = expiryDate.getText().toString();

        expiryDateInput = expiryDate.getText().toString();
        // Check the expiry date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(expiryDateInput);
        } catch (ParseException e) {
            Toast.makeText(this, "Expiry date must be in the format dd/MM/yy", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create a new entry string using the input
        String foodEntry = foodNameInput + ", " + "Expiry Date: " + expiryDateInput;

        // Add the new entry to the adapter and update the ListView
        adapter.insert(foodEntry, 0);
        adapter.notifyDataSetChanged();

        // Clear the input fields
        foodName.setText("");
        expiryDate.setText("");
    }

    public void backButtonClick() {
        Intent intent = new Intent(this, MainViewActivity.class);
        startActivity(intent);
        finish();
    }
}


