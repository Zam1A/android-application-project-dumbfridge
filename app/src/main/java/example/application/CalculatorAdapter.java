package example.application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import example.data.FoodCalculator;

import java.util.List;

public class CalculatorAdapter extends ArrayAdapter<FoodCalculator> {

    private LayoutInflater inflater;

    public CalculatorAdapter(@NonNull Context context, int resource, @NonNull List<FoodCalculator> objects) {
        super(context, resource, objects);
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(android.R.layout.simple_list_item_2, parent, false);
        }

        FoodCalculator food = getItem(position);

        TextView nameView = convertView.findViewById(android.R.id.text1);
        nameView.setText(food.getName());

        TextView caloriesView = convertView.findViewById(android.R.id.text2);
        String caloriesStr = String.format("%.2f", food.getCaloriesPerGram() * food.getWeight());
        String weightStr = String.format("%.2f g", food.getWeight());
        caloriesView.setText(caloriesStr + " calories" + " / " + weightStr);

        return convertView;
    }
}