package com.londonappbrewery.climapm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class ChangeCityController extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Linking controller to layout xml file
        setContentView(R.layout.change_city_layout);

        //linking views of particular ID to variables in java code
        final EditText editTextField = (EditText)findViewById(R.id.queryET);
        ImageButton backButton = (ImageButton) findViewById(R.id.backButton);

        //setting on click listener on back button to close activity by using finish()
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //set an OnEditorActionListener button on edit text so user can use keyboard to type in text
        editTextField.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String newCity = editTextField.getText().toString();
                //be sure to specify context which is this controller, and controller to pick up the intent
                Intent newCityIntent = new Intent(ChangeCityController.this,WeatherController.class);

                //pass information to weatherController class about newIntent = newCityIntent by using extra, note "City" is arbitrary key, and value is the content entered = newCity
                newCityIntent.putExtra("City", newCity);

                //launch the WeatherController activity by passing in newCityIntent as parameter
                startActivity(newCityIntent);

                //Proceed by retrieving this on WeatherController.java at onResume()
                return false;
            }
        });

    }

}
