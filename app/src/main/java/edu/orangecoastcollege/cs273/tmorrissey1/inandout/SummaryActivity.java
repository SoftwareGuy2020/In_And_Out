package edu.orangecoastcollege.cs273.tmorrissey1.inandout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Controller for In and Out. Manages inputs/outputs between activity_summary.xml
 * and OrderActivity.java
 */
public class SummaryActivity extends AppCompatActivity {

    /**
     * Perform initialization of all fragments and loaders.
     * @param savedInstanceState previous saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        TextView amountTotalTextView = (TextView) findViewById(R.id.amountTotalTextView);
        TextView amountTaxTextView = (TextView) findViewById(R.id.amountTaxTextView);
        TextView itemsOrderedTextView = (TextView) findViewById(R.id.itemsOrderedTextView);
        TextView subtotalTextView = (TextView) findViewById(R.id.subtotalTextView);
        Button startNewOrderButton = (Button) findViewById(R.id.startNewOrderButton);

        String total, taxAmount, subtotalAmount, numItemsOrdered;

        Intent intentFromOrderActivity = getIntent();
        total = intentFromOrderActivity.getStringExtra("orderTotal");
        taxAmount = intentFromOrderActivity.getStringExtra("amountTax");
        numItemsOrdered = intentFromOrderActivity.getStringExtra("itemsOrdered");
        subtotalAmount = intentFromOrderActivity.getStringExtra("subtotal");


        amountTotalTextView.setText(total);
        amountTaxTextView.setText(taxAmount);
        itemsOrderedTextView.setText(numItemsOrdered);
        subtotalTextView.setText(subtotalAmount);

        startNewOrderButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when a view has been clicked.
             * @param v the view that was clicked
             */
            @Override
            public void onClick(View v) {
                returnToOrderActivity(v);
            }
        });

    }

    /**
     * Finishes SummaryActivity and returns to the previous activity
     * @param v the view that was clicked
     */
    public void returnToOrderActivity(View v) {
        this.finish();
    }
}
