package com.animport.udacityquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.userName);
        email=findViewById(R.id.email);
        desc=findViewById(R.id.aboutText);

        if (savedInstanceState != null){
            name.setText(savedInstanceState.getString("nameKey"));
            email.setText(savedInstanceState.getString("emailKey"));
            desc.setText(savedInstanceState.getString("descKey"));
        }
    }

    public void nextClicked(View view) {
        saveSharedPreferences();
        openDetailsActivity();

        name.setText("");
        email.setText("");
        desc.setText("");
    }

    private void saveSharedPreferences() {
        SharedPreferences sharedPreferences=getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        editor.putString("nameKey",name.getText().toString());
        editor.putString("emailKey",email.getText().toString());
        editor.putString("descKey",desc.getText().toString());
        editor.commit();
    }

    public void openDetailsActivity(){
        Intent intent=new Intent(this,DetailsActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.user_details){
            saveSharedPreferences();
            openDetailsActivity();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("nameKey",name.getText().toString());
        outState.putString("emailKey",email.getText().toString());
        outState.putString("descKey",desc.getText().toString());
        super.onSaveInstanceState(outState);
    }
}
