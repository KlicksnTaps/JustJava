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
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity
{
    int quantity = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view)
    {
        int price = quantity * 5;
        displayPrice( price);
        String pricemessage="The Total price of your service is:" + price+"/n Thankyou very much and /nplease come again soon!";
        displayMessage(pricemessage);
    }

    /**
     *
     * This method is passed to the submitOrder so as to increase the button press
     */
    public  void increment(View view)
    {
        quantity=quantity+1;
        display(quantity);



    }
    /**
     * this method is passed to the submitOrder to decrease when button is pressed
     */
    public void decrement(View view)
    {
        quantity=quantity+1;
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number)
    {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the value of the given price on the screen.
     */

    private void displayPrice(int number)

    {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays a given message on the screen.
     *
     */

    private void displayMessage(String message) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(message);
    }
}