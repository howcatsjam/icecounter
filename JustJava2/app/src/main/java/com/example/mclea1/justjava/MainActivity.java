package com.example.mclea1.justjava;


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

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCream.isChecked();
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolate.isChecked();
        int totalPrice = calculatePrice(hasWhippedCream, hasChocolate);
        EditText nameText = (EditText) findViewById(R.id.name_edit_text);
        String name = nameText.getText().toString();
        String orderSummary = createOrderSummary(totalPrice, hasWhippedCream, hasChocolate, name);
        Intent email = new Intent(Intent.ACTION_SENDTO);
        email.setData(Uri.parse("mailto:"));
        email.putExtra(Intent.EXTRA_TEXT, orderSummary);
        email.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.order_summary_email_subject, name));
        if (email.resolveActivity(getPackageManager()) != null) {
            startActivity(email);
        }
//        displayMessage(orderSummary);
    }


    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice(boolean whippedCream, boolean chocolate) {
        int basePrice = 5;
        if (whippedCream) {
            basePrice += 1;
        }
        if (chocolate) {
            basePrice += 2;
        }
        int price = quantity * basePrice;
        return price;
    }

    /**
     * This method is called when the + button is clicked.
     */

    public void increment(View view) {
        if (quantity < 100) {
            quantity = quantity + 1;
            displayQuantity(quantity);
        } else {
            Toast toast = Toast.makeText(this,"Too many coffees!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /**
     * This method is called when the - button is clicked.
     */

    public void decrement (View view) {
        if (quantity > 0) {
            quantity = quantity - 1;
            displayQuantity(quantity);
        } else {
            Toast toast = Toast.makeText(this, "Too few coffees!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    /**
     * This method returns the string that will be displayed as the order summary
     * @param price
     * @return
     */
    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate, String name) {
        String orderSummary = getString(R.string.order_summary_name, name);
        orderSummary += "\n" + getString(R.string.add_whipped_cream, addWhippedCream);
        orderSummary += "\n" + getString(R.string.add_chocolate, addChocolate);
        orderSummary = orderSummary + "\n" + getString(R.string.order_summary_quantity, quantity);
        orderSummary = orderSummary + "\n" + getString(R.string.order_summary_total) + NumberFormat.getCurrencyInstance().format(price);
        orderSummary = orderSummary + "\n" + getString(R.string.thank_you);
        return orderSummary;
    }

}