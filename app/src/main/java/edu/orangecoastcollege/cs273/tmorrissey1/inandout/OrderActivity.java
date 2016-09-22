package edu.orangecoastcollege.cs273.tmorrissey1.inandout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.NumberFormat;

/**
 * Controller for In and Out app. Manages inputs/outputs between model and view
 */
public class OrderActivity extends AppCompatActivity {

    private Order order;
    private EditText doubleDoubleEditText;
    private EditText cheeseburgerEditText;
    private EditText frenchFryEditText;
    private EditText shakesEditText;
    private EditText smallDrinkEditText;
    private EditText mediumDrinkEditText;
    private EditText largeDrinkEditText;
    private Button orderButton;
    private NumberFormat currency = NumberFormat.getCurrencyInstance();

    /**
     * Perform initialization of all fragments and loaders.
     * @param savedInstanceState previous saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        order = new Order();
        doubleDoubleEditText = (EditText) findViewById(R.id.doubleDoubleEditText);
        cheeseburgerEditText = (EditText) findViewById(R.id.cheeseburgerEditText);
        frenchFryEditText = (EditText) findViewById(R.id.frenchFryEditText);
        shakesEditText = (EditText) findViewById(R.id.shakesEditText);
        smallDrinkEditText = (EditText) findViewById(R.id.smallDrinkEditText);
        mediumDrinkEditText = (EditText) findViewById(R.id.mediumDrinkEditText);
        largeDrinkEditText = (EditText) findViewById(R.id.largeDrinkEditText);
        orderButton = (Button) findViewById(R.id.orderButton);

        orderButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when a view has been clicked
             * @param v the view that was clicked
             */
            @Override
            public void onClick(View v) {
                activateSummary(v);
            }
        });

    }

    /**
     * Collects input from user, updates the model, and activates SummaryActivity
     * @param v the view that was clicked
     */
    public void activateSummary(View v) {
        int numCheeseburgers, numDoubleDoubles, numFrenchFries, numShakes, numSmallDrinks,
                numMediumDrinks, numLargeDrinks;

        try {
            numCheeseburgers = (cheeseburgerEditText.getText().length() == 0) ? 0 :
                    Integer.parseInt(cheeseburgerEditText.getText().toString());

            numDoubleDoubles = (doubleDoubleEditText.getText().length() == 0) ? 0 :
                    Integer.parseInt(doubleDoubleEditText.getText().toString());

            numFrenchFries = (frenchFryEditText.getText().length() == 0) ? 0 :
                    Integer.parseInt(frenchFryEditText.getText().toString());

            numLargeDrinks = (largeDrinkEditText.getText().length() == 0) ? 0 :
                    Integer.parseInt(largeDrinkEditText.getText().toString());

            numShakes = (shakesEditText.getText().length() == 0) ? 0 :
                    Integer.parseInt(shakesEditText.getText().toString());

            numSmallDrinks = (smallDrinkEditText.getText().length() == 0) ? 0 :
                    Integer.parseInt(smallDrinkEditText.getText().toString());

            numMediumDrinks = (mediumDrinkEditText.getText().length() == 0) ? 0 :
                    Integer.parseInt(mediumDrinkEditText.getText().toString());

        }
        catch   (NumberFormatException e) {
            numCheeseburgers = numDoubleDoubles = numFrenchFries = numShakes = numSmallDrinks =
                    numMediumDrinks = numLargeDrinks = 0;
        }

        order.setCheeseburgers(numCheeseburgers);
        order.setDoubleDoubles(numDoubleDoubles);
        order.setFrenchFries(numFrenchFries);
        order.setLargeDrinks(numLargeDrinks);
        order.setMediumDrinks(numMediumDrinks);
        order.setSmallDrinks(numSmallDrinks);
        order.setShakes(numShakes);

        Intent orderSummaryIntent = new Intent(this, SummaryActivity.class);

        orderSummaryIntent.putExtra("orderTotal", currency.format(order.calculateTotal()));
        orderSummaryIntent.putExtra("itemsOrdered", Integer.toString(order.getNumberItemsOrdered()));
        orderSummaryIntent.putExtra("subtotal", currency.format(order.calculateSubtotal()));
        orderSummaryIntent.putExtra("amountTax", currency.format(order.calculateTax()));

        startActivity(orderSummaryIntent);
    }
}
