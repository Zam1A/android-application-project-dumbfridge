package example.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.SharedPreferences;

public class ThemeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnThemeDay;
    private Button btnThemeNight;
    private Button btnThemeAuto;
    private Button btnReturn;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_theme);

        btnThemeDay = findViewById(R.id.btn_theme_day);
        btnThemeNight = findViewById(R.id.btn_theme_night);
        btnThemeAuto = findViewById(R.id.btn_theme_auto);
        btnReturn = findViewById(R.id.btn_return);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("FontSizePref", MODE_PRIVATE);
        int buttonTextSize = sharedPreferences.getInt("fontSize", 16);

        btnThemeDay.setTextSize(buttonTextSize);
        btnThemeNight.setTextSize(buttonTextSize);
        btnThemeAuto.setTextSize(buttonTextSize);

        btnThemeDay.setOnClickListener(this);
        btnThemeNight.setOnClickListener(this);
        btnThemeAuto.setOnClickListener(this);
        btnReturn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_theme_day:
                setThemeMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
            case R.id.btn_theme_night:
                setThemeMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            case R.id.btn_theme_auto:
                setThemeMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                break;
            case R.id.btn_return:
                finish();
                break;
        }
    }

    private void setThemeMode(int mode) {
        AppCompatDelegate.setDefaultNightMode(mode);
    }
}
