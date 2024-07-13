package example.application;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import example.data.DietaryRequirements;

public class PreferencesActivity extends AppCompatActivity {

    private TextView header, shoppingSettings, dietarySettings, currentDietaryRequirements, collectionLocation, currentAddress;

    private RadioGroup radioSuper, radioOption;

    private EditText editSuperEntry, editDietEntry, entryUnitNum, entryStreetNum, entryStreetName, entrySuburb, entryState, entryPostCode;

    private Button buttonBack, buttonSetCollection, buttonSetDietary, buttonSetAddress;

    private RadioButton radioButtonSuper, radioButtonMethod;

    private String collectionLoc = "None Set";
    private String deliveryAddress = "None Set";
    private String dietaryNeed = "None Set";

    /**
     * Creates the main view.
     * @param savedInstanceState the saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        // Initialise the default views
        header = findViewById(R.id.textUserPreferences);
        shoppingSettings = findViewById(R.id.textShoppingOptionsHeader);
        radioOption = findViewById(R.id.radioGroupShoppingMethod);
        buttonBack = findViewById(R.id.btnGoBack);

        // Initialise the Dietary Preference Views
        dietarySettings = findViewById(R.id.textDietaryPreferences);
        editDietEntry = findViewById(R.id.editDietaryUserRequirement);
        buttonSetDietary = findViewById(R.id.btnAddDietRequirement);
        currentDietaryRequirements = findViewById(R.id.textCurrentRequirementSet);

        // Initialise the Collection Views
        collectionLocation = findViewById(R.id.textClickCollectPreferences);
        radioSuper = findViewById(R.id.radioSupermarketSelect);
        editSuperEntry = findViewById(R.id.editSupermarketSuburb);
        buttonSetCollection = findViewById(R.id.btnAddCollectionLocation);

        // Initialise the Delivery Views
        currentAddress = findViewById(R.id.textDeliveryOptionChosen);
        entryUnitNum = findViewById(R.id.entryUnitNum);
        entryStreetNum = findViewById(R.id.entryStreetNum);
        entryStreetName = findViewById(R.id.entryStreetName);
        entrySuburb = findViewById(R.id.entrySuburb);
        entryState = findViewById(R.id.entryState);
        entryPostCode = findViewById(R.id.entryPostCode);
        buttonSetAddress = findViewById(R.id.btnUpdateAddress);

        // Set Default text Values
        collectionLocation.setText("Collection Location: " + collectionLoc);
        currentDietaryRequirements.setText("Current Dietary Requirements: " + dietaryNeed);
        currentAddress.setText("Current Address: " + deliveryAddress);

        // Set on click listeners
        buttonBack.setOnClickListener(v -> backButtonOnClick());
        buttonSetDietary.setOnClickListener(v -> setDietaryOnClick());
        buttonSetAddress.setOnClickListener(v-> setAddressOnClick());
        buttonSetCollection.setOnClickListener(v -> setCollectionOnClick());
    }

    /**
     * Checks the selected option of the supermarket RadioGroup
     * @param v Supermarket RadioGroup view
     */
    public  void checkSupermarketOption(View v) {
        int selectedID = radioSuper.getCheckedRadioButtonId();
        radioButtonSuper = findViewById(selectedID);
    }

    /**
     * Checks the selected option of the shopping option RadioGroup
     * @param v Shopping Option RadioGroup view
     */
    public void checkShopOption(View v) {
        int selectedID = radioOption.getCheckedRadioButtonId();
        radioButtonMethod = findViewById(selectedID);
        if (selectedID == R.id.radioCollectMethod) {
            collectSelected();
        } else {
            deliverySelected();
        }
    }

    /**
     * Displays the delivery options
     */
    private void deliverySelected() {
        // Make collection options invisible
        collectionLocation.setVisibility(View.GONE);
        radioSuper.setVisibility(View.GONE);
        editSuperEntry.setVisibility(View.GONE);
        buttonSetCollection.setVisibility(View.GONE);

        // Make Delivery options visible
        currentAddress.setVisibility(View.VISIBLE);
        entryUnitNum.setVisibility(View.VISIBLE);
        entryStreetNum.setVisibility(View.VISIBLE);
        entryStreetName.setVisibility(View.VISIBLE);
        entrySuburb.setVisibility(View.VISIBLE);
        entryState.setVisibility(View.VISIBLE);
        entryPostCode.setVisibility(View.VISIBLE);
    }

    /**
     * Displays the Click and Collect Options
     */
    private void collectSelected() {
        // Make Delivery options invisible
        currentAddress.setVisibility(View.GONE);
        entryUnitNum.setVisibility(View.GONE);
        entryStreetNum.setVisibility(View.GONE);
        entryStreetName.setVisibility(View.GONE);
        entrySuburb.setVisibility(View.GONE);
        entryState.setVisibility(View.GONE);
        entryPostCode.setVisibility(View.GONE);

        // Make collection options visible
        collectionLocation.setVisibility(View.VISIBLE);
        radioSuper.setVisibility(View.VISIBLE);
        editSuperEntry.setVisibility(View.VISIBLE);
        buttonSetCollection.setVisibility(View.VISIBLE);
    }

    /**
     * Set's the collection method
     */
    private void setCollectionOnClick() {
        int selectedID = radioSuper.getCheckedRadioButtonId();
        radioButtonSuper = findViewById(selectedID);

        collectionLoc = radioButtonSuper.getText() + " " + editSuperEntry.getText().toString();
        collectionLocation.setText("Collection Location: " + collectionLoc);
        buttonSetDietary.setText("Update Location");
    }

    /**
     * Updates the user's delivery address
     */
    private void setAddressOnClick() {
        int unit = Integer.parseInt(entryUnitNum.getText().toString());
        int num = Integer.parseInt(entryStreetNum.getText().toString());
        String name = entryStreetName.getText().toString();
        String suburb = entrySuburb.getText().toString();
        String state = entryState.getText().toString();
        int code = Integer.parseInt(entryPostCode.getText().toString());
        if (unit == 0) {
            deliveryAddress = String.format("%d %s, %s %s %d", num, name, suburb, state, code);
        } else {
            deliveryAddress = String.format("%d/%d %s, %s %s %d", unit, num, name, suburb, state, code);
        }
        currentAddress.setText("Current Address: " + deliveryAddress);
        buttonSetAddress.setText("Update Delivery Address");

    }

    /**
     * Updates the users dietary requirements
     */
    private void setDietaryOnClick() {
        dietaryNeed = editDietEntry.getText().toString();
        currentDietaryRequirements.setText("Current Dietary Requirements: " + dietaryNeed);
        buttonSetDietary.setText("Update Dietary Requirements");
    }

    /**
     * Returns to the main menu
     */
    private void backButtonOnClick() {
        Intent intent = new Intent(PreferencesActivity.this, MainViewActivity.class);
        startActivity(intent);
        finish();
    }


}