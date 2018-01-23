/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/


package com.example.android.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    public final String DEBUG_PARAM = null;
    EditText nameText;
    CheckBox creamCheckBox;
    CheckBox chockBox;

    String naira = "\u20A6";
    int quantity = 0;
    int price = 0;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    /**
     * the pricemessage variable immediately under will dispaly the amount with a $ the second variable displays the
     * nairasymbol for the Nigerian Naira
     */

    public void submitOrder(View view) {
        // price = quantity * 5;

        EditText nameText = (EditText) findViewById(R.id.name_text);
        String named = nameText.getText().toString();

        CheckBox creamCheckBox = (CheckBox) findViewById(R.id.whpCream_chbox);
        boolean cchekker = creamCheckBox.isChecked();


        CheckBox chockBox = (CheckBox) findViewById(R.id.chocolate_text);
        boolean cheker = chockBox.isChecked();

        Log.v(DEBUG_PARAM, "just before they go");
        displayPrice(named, cchekker, cheker, quantity);
    }


//        String pricemessage = "The Total price of your service is:" + naira + price + "\n Thankyou very much and \nplease come again soon!";
//        displayMessage(pricemessage);
//    }

    /**
     * This method is passed to the submitOrder so as to increase the button press
     */
    public void increment(View view) {
        if (quantity >= 100) {
            Toast.makeText(this, "you cant have more than 100 coffes at a time", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        display(quantity);
        Log.v(DEBUG_PARAM, "you just hit me up");

    }

    /**
     * this method is passed to the submitOrder to decrease when button is pressed
     */


    public void decrement(View view) {
        if (quantity <= 1) {

            Toast.makeText(this, "you cant have less than one coffes at a time", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        display(quantity);
        Log.e(DEBUG_PARAM, "you just hit me down");
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the value of the given price on the screen.
     * This method is not used
     */


    private void displayPrice(String name, boolean chk, boolean chkr, int number) {
        name = "Hello :" + nameText.getText().toString() + "\n you ordered the following";
        chk = creamCheckBox.isChecked();
        if (creamCheckBox.isChecked() == true) {
            price = price + 30;
            name += "\n GradeOne African Cream" + naira + 30;

            Log.v(DEBUG_PARAM, "creame added");
        }
        chkr = chockBox.isChecked();
        if (chockBox.isChecked() == true) {
            price = price + 100;
            name += "\nOriginal Nigerian Chocolate : " + naira + 40;
            Log.v(DEBUG_PARAM, "chokolate added");


        }
        price = price + 100;
        name += "Highest blend of Ethiopian Coffee" + naira + 100;
        price = price + 5;
        price = price * number;

        Log.v(DEBUG_PARAM, "total calculated");
        name += "The total cost is :" + naira + price;

        TextView quantityTextView = (TextView) findViewById(R.id.price_text_view);
        quantityTextView.setText(name);

    }


    /**
     * This method displays a given message on the screen.
     */

    private void displayMessage(String message) {
        TextView quantityTextView = (TextView) findViewById(R.id.price_text_view);

        quantityTextView.setText(message);
    }
}