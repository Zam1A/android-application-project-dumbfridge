package example.application;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import example.application.user.Address;
import example.data.StaticUserDAO;
import example.data.User;

import static java.lang.Integer.*;



public class AddressActivity extends AppCompatActivity {
    // Initialize the views
    private StaticUserDAO staticUserDAO = new StaticUserDAO();
    // Declare class variables for the views
    private TextView textHeader;
    private EditText textUnitNum;
    private EditText textStreetNum;
    private EditText textStreetName;
    private EditText textSuburb;
    private EditText textState;
    private EditText textPostCode;
    private Button buttonUpdateAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        // Initialize the views
        textHeader = findViewById(R.id.textAddressHeader);
        textUnitNum = findViewById(R.id.editTextUnitNum);
        textStreetNum = findViewById(R.id.editTextStreetNum);
        textStreetName = findViewById(R.id.editTextStreetName);
        textSuburb = findViewById(R.id.editTextSuburb);
        textState = findViewById(R.id.editTextState);
        textPostCode = findViewById(R.id.editTextPostCode);
        buttonUpdateAddress = findViewById(R.id.buttonAcceptAddress);


        // Set up the button click listener
        buttonUpdateAddress.setOnClickListener(v -> updateAddressOnClick());
    }

    public void updateAddressOnClick(){
        Intent intent = new Intent(this, PreferencesActivity.class);
        Address address = new Address(Integer.parseInt(textUnitNum.getText().toString()),
                Integer.parseInt(textStreetNum.getText().toString()),
                textStreetName.getText().toString(), textSuburb.getText().toString(),
                textState.getText().toString(), Integer.parseInt(textPostCode.getText().toString()));
        startActivity(intent);
        finish();
    }

}
