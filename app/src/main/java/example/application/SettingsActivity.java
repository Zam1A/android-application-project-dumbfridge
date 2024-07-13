package example.application;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SettingsActivity extends AppCompatActivity {

    private ListView settingsListView;
    private String[] settingsOptions = {"Font Size", "Theme"};
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("FontSizePref", MODE_PRIVATE);

        settingsListView = findViewById(R.id.settings_list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, settingsOptions) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView item = (TextView) super.getView(position, convertView, parent);
                int fontSize = sharedPreferences.getInt("fontSize", 16);
                item.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize);
                return item;
            }
        };

        settingsListView.setAdapter(adapter);

        settingsListView.setOnItemClickListener((parent, view, position, id) -> {
            if (position == 0) {
                Intent intent = new Intent(SettingsActivity.this, FontSizeActivity.class);
                startActivity(intent);
            } else if (position == 1) {
                Intent intent = new Intent(SettingsActivity.this, ThemeActivity.class);
                startActivity(intent);
            }
        });

        Button returnButton = findViewById(R.id.return_button);
        returnButton.setOnClickListener(v -> {
            // Return to the main view activity
            Intent intent = new Intent(SettingsActivity.this, MainViewActivity.class);
            startActivity(intent);
        });
    }
}
