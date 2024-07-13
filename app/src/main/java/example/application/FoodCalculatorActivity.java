package example.application;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import example.application.adapter.FoodListAdapter;
import example.data.FoodCalculator;

import java.util.ArrayList;

public class FoodCalculatorActivity extends AppCompatActivity {
    private FoodListAdapter foodListAdapter;

    private ListView listView;
    private EditText foodNameEditText;
    private EditText foodCaloriesEditText;
    private EditText foodWeightEditText;
    private TextView totalCaloriesTextView;
    private Button addButton;
    private Button clearButton;
    private Button calculateButton;
    private ArrayList<FoodCalculator> foods;
    private SharedPreferences sharedPreferences;
    private int fontSize;

    // onCreate()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        // UI
        listView = findViewById(R.id.list_view);
        foodNameEditText = findViewById(R.id.food_name_edittext);
        foodCaloriesEditText = findViewById(R.id.food_calories_edittext);
        foodWeightEditText = findViewById(R.id.food_weight_edittext);
        totalCaloriesTextView = findViewById(R.id.total_calories_textview);
        addButton = findViewById(R.id.add_button);
        clearButton = findViewById(R.id.clear_button);
        calculateButton = findViewById(R.id.calculate_button);

        // Get font size from shared preferences
        sharedPreferences = getSharedPreferences("FontSizePref", MODE_PRIVATE);
        fontSize = sharedPreferences.getInt("fontSize", 16);

        // Apply font size to views
        foodNameEditText.setTextSize(fontSize);
        foodCaloriesEditText.setTextSize(fontSize);
        foodWeightEditText.setTextSize(fontSize);
        totalCaloriesTextView.setTextSize(fontSize);

        // If you want to apply font size to Button's text too
        addButton.setTextSize(fontSize);
        clearButton.setTextSize(fontSize);
        calculateButton.setTextSize(fontSize);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = foodNameEditText.getText().toString();
                double calories = Double.parseDouble(foodCaloriesEditText.getText().toString());
                double weight = Double.parseDouble(foodWeightEditText.getText().toString());
                FoodCalculator food = new FoodCalculator(name, calories, weight);
                foods.add(food);
                foodListAdapter.notifyDataSetChanged();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foods.clear();
                foodListAdapter.notifyDataSetChanged();
                totalCaloriesTextView.setText(R.string.total_calories);
            }
        });

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double totalCalories = 0;
                for (FoodCalculator food : foods) {
                    totalCalories += food.getCaloriesPerGram() * food.getWeight();
                }
                totalCaloriesTextView.setText(String.format("%.2f", totalCalories));
            }
        });

        foods = new ArrayList<>();
        foodListAdapter = new FoodListAdapter(this, foods);
        listView.setAdapter(foodListAdapter);
    }
}
