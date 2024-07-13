package example.application.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import example.application.R;
import example.data.FoodCalculator;

public class FoodListAdapter extends ArrayAdapter<FoodCalculator> {

    private ArrayList<FoodCalculator> foods;
    private Context context;

    public FoodListAdapter(Context context, ArrayList<FoodCalculator> foods) {
        super(context, R.layout.food_list_item, foods);
        this.foods = foods;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            itemView = inflater.inflate(R.layout.food_list_item, parent, false);
        }

        FoodCalculator currentFood = foods.get(position);

        TextView nameTextView = itemView.findViewById(R.id.food_name_text_view);
        nameTextView.setText(currentFood.getName());

        TextView caloriesTextView = itemView.findViewById(R.id.food_calories_text_view);
        caloriesTextView.setText(String.format("%.2f", currentFood.getCaloriesPer100g() / 100));

        TextView weightTextView = itemView.findViewById(R.id.food_weight_text_view);
        weightTextView.setText(String.format("%.0f", currentFood.getWeight()));

        return itemView;
    }
}
