package com.animport.udacityquiz;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        populateDataFromSharedPreferences();
    }

    private void populateDataFromSharedPreferences() {
        SharedPreferences sharedPreferences=getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String name=sharedPreferences.getString("nameKey","xyz");
        String email=sharedPreferences.getString("emailKey","xyz");
        String desc=sharedPreferences.getString("descKey","xyz");

        TextView et_name=findViewById(R.id.user_name);
        TextView et_email=findViewById(R.id.user_email);
        TextView et_desc=findViewById(R.id.user_desc);

        et_name.setText(name);
        et_email.setText(email);
        et_desc.setText(desc);
    }
}
