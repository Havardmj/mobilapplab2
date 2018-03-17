package com.example.havardmj.rssfeed.Model;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.havardmj.rssfeed.R;

/**
 * Created by Havardmj on 17-Mar-18.
 */


public class Preferences extends AppCompatActivity {

    Spinner limitation;
    Spinner rate;
    Button setChanges;
    TextView newRssAdr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        limitation = findViewById(R.id.limitSpinner);
        rate = findViewById(R.id.rateSpinner);
        setChanges = findViewById(R.id.saveBtn);

        String[] lim = new String[]{"5", "10", "15", "20"};
        String [] rates = new String[]{"10", "15", "30"};


        ArrayAdapter<String> limitA = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, lim);
        limitation.setAdapter(limitA);
        final ArrayAdapter<String>rateA = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, rates);
        rate.setAdapter(rateA);

        setChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = newRssAdr.getText().toString();
                int limr = Integer.parseInt(rate.getSelectedItem().toString());
                int liml = Integer.parseInt(limitation.getSelectedItem().toString());

            }
        });
    }
}
