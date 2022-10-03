package com.example.lesson5theme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    String[] countries = {"first", "second", "third"};
    static int theme = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView selection = findViewById(R.id.text);
        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countries);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        if (theme == 0) {
            this.setTheme(R.style.them1);

        } else {
            this.setTheme(R.style.them2);

        }

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                selection.setText(item);

                ImageView img = findViewById(R.id.imageView);
                if (position == 0) img.setImageResource(R.drawable.pivo);
                if (position == 1) img.setImageResource(R.drawable.vodka);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };

        spinner.setOnItemSelectedListener(itemSelectedListener);


    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.mymenu, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.s1:
                theme =0;
                this.recreate();
                return true;

            case R.id.s2:
                theme =1 ;
                this.recreate();
                return true;

            case R.id.vis:

                TextView selection = findViewById(R.id.text);
                if (selection.getVisibility() == View.VISIBLE) {
                    selection.setVisibility(View.INVISIBLE);
                } else {
                    selection.setVisibility(View.VISIBLE);
                }


                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setTitle("отображение изменено");
                dialog.setContentView(R.layout.dlg);
                dialog.show();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}