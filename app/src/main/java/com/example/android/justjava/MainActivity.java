/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/


package com.example.android.justjava;


import android.content.Intent;
import android.net.Uri;
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
    public final String DEBUG_PARAM = "Debug";


    String naira = "\u20A6";
    int quantity = 0;
    //  int price = 0;

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
        boolean addcream = creamCheckBox.isChecked();


        CheckBox chockBox = (CheckBox) findViewById(R.id.chocolate_text);
        boolean addsChoklate = chockBox.isChecked();


        Log.v(DEBUG_PARAM, "just before they go");
        int pricer = displayPrice(addcream, addsChoklate);
        String out = orderSummary(named, addcream, addsChoklate, pricer);


        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto"));
        intent.putExtra(intent.EXTRA_TITLE, "Hello" + named + "welcome to the Just Java Cafe");
        intent.putExtra(intent.EXTRA_TEXT, out);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
            Log.e(DEBUG_PARAM, "OKAU");
        }


        finalDisplay(out);
    }

//        String pricemessage = "The Total price of your service is:" + naira + price + "\n Thankyou very much and \nplease come again soon!";
//        displayMessage(pricemessage);
//    }

    /**
     * This method is passed to the submitOrder so as to increase the button press
     */
    public void increment(View view) {
        if (quantity >= 100) {
            Toast.makeText(this, "you cant order more than a 100 coffees", Toast.LENGTH_SHORT).show();
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

            Toast.makeText(this, "you cant have less than a coffee", Toast.LENGTH_SHORT).show();
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
     *
     * @param chk  is used to collect the value of whether the clients wants cream
     * @param chkr is used to indicate if the client ordered chocolate
     */


    private int displayPrice(boolean chk, boolean chkr) {
        int toppings = 0;
        int cost;
        if (chk) {
            toppings = toppings + 30;
            Log.v(DEBUG_PARAM, "creame added");
        }
        if (chkr) {
            toppings = toppings + 40;
            Log.v(DEBUG_PARAM, "chokolate added");

        }

//        this where the cost of topings are added to the cost of a N100 for a cafe cup
        cost = toppings + 100;
        cost = cost * quantity;

        Log.v(DEBUG_PARAM, "total calculated");
        return cost;

//        TextView quantityTextView = (TextView) findViewById(R.id.price_text_view);
//        quantityTextView.setText(String.valueOf(name));

    }


    /**
     * @return priceMessage returns the total price of the oredered coffee with/without toppings
     * @parampriceMessage variable holding nameThis method displays a given message on the screen.
     */

    private String orderSummary(String name, boolean chk, boolean chkr, int totalPrice) {

        String priceMessage = "Hello :" + name + "\n you ordered the following";
        priceMessage += "\nHighest blend of Ethiopian Coffee:" + "cost" + naira + "100";
        priceMessage += "\n GradeOne African Cream: " + chk + "  cost" + naira + "30";
        priceMessage += "\nOriginal Nigerian Chocolate : " + chkr + "  cost" + naira + "40";
        totalPrice = displayPrice(chk, chkr);
        priceMessage += "\nQuantity :" + quantity+" cups";
        priceMessage += "\nThe total cost is :" + naira + totalPrice;
        return priceMessage;


    }


    private void finalDisplay(String pMessage) {
        TextView quantityTextView = (TextView) findViewById(R.id.price_text_view);

        quantityTextView.setText(pMessage);

    }
}