package com.example.dell.autocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   //widget of the xml file
    AutoCompleteTextView autoCompleteTextView;
    TextView textView;
    ArrayList<String> productName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

       //adding data in array
        productName = new ArrayList<>();
        productName.add("Samsung");
        productName.add("Nokia");
        productName.add("Redmi");
        productName.add("Appple");
        productName.add("Soni");
        productName.add("HTC");
        productName.add("Micromax");
        productName.add("Blackberry");
        productName.add("LG");
        productName.add("Carbonn");
        productName.add("Panasonic");

        Dbhandler dbhandler = new Dbhandler(this);

        for (int i = 0 ; i < productName.size() ; i++){
            dbhandler.Addproducts(productName.get(i));
        }

        ArrayList arrayList = dbhandler.Databasetoarray();

        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.select_dialog_item,arrayList);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(arrayAdapter);

    }
}
