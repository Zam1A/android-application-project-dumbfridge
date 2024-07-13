package example.application;

import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.content.SharedPreferences;

public class FontSizeActivity extends AppCompatActivity {

    private SeekBar fontSizeSeekBar;
    private TextView sampleTextView;
    private SharedPreferences sharedPreferences;
    private int newFontSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_font_size);

        // Initialize the SeekBar and sample text view
        fontSizeSeekBar = findViewById(R.id.font_size_seek_bar);
        sampleTextView = findViewById(R.id.sample_text_view);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("FontSizePref", MODE_PRIVATE);
        int initialFontSize = sharedPreferences.getInt("fontSize", 16);
        fontSizeSeekBar.setProgress(initialFontSize); // set initial progress to the saved font size value
        sampleTextView.setTextSize(initialFontSize); // set the initial font size of the sample text view

        // Set up the OnSeekBarChangeListener for the font size SeekBar
        fontSizeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Update the font size of the sample text view
                sampleTextView.setTextSize(progress);
                // Save the new font size to a variable
                newFontSize = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        Button fontsizeButton = findViewById(R.id.font_size_button);
        fontsizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Save the new font size to SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("fontSize", newFontSize);
                editor.apply();

                // Return to the main view activity and pass the new font size back
                Intent intent = new Intent();
                intent.putExtra("newFontSize", newFontSize);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
