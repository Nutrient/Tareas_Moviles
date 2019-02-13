package com.example.carlo.tarea1;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity implements ClearDialog.DialogActions{
    EditText name;
    EditText phone;
    Spinner schoolarship;
    RadioButton btn_radio;
    AutoCompleteTextView books;
    CheckBox sports;

    public void updateRadio(View v){
        btn_radio = findViewById(v.getId());
    }

    @Override
    public void dialogResult(boolean tof){
        if (tof){
            name = findViewById(R.id.username);
            phone = findViewById(R.id.phone);
            schoolarship = findViewById(R.id.scholarship_selector);
            books = findViewById(R.id.auto_complete);
            sports = findViewById(R.id.sports_check_box);
            clear();
        }
    }

    public void showPrompt(View v){
        FragmentManager fragmentManager = getSupportFragmentManager();
        ClearDialog dialog = new ClearDialog();
        dialog.show(fragmentManager, "question");
    }

    public void clear(){
        name.setText("");
        phone.setText("");
        schoolarship.setSelection(0);
        btn_radio = findViewById(R.id.radio_male);
        btn_radio.setChecked(true);
        books.setText("");
        sports.setChecked(false);

    }

    public void save(){

        name = findViewById(R.id.username);
        phone = findViewById(R.id.phone);
        schoolarship = findViewById(R.id.scholarship_selector);
        books = findViewById(R.id.auto_complete);
        sports = findViewById(R.id.sports_check_box);
        Alumno a = new Alumno(name.getText().toString(), phone.getText().toString(), schoolarship.getSelectedItem().toString(), btn_radio.getText().toString(), books.getText().toString(), (sports.isChecked())? sports.getText().toString() : "No "+sports.getText().toString());
        clear();
        Toast.makeText(this, a.toString(), Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        btn_radio = findViewById(R.id.radio_male);
        books = findViewById(R.id.auto_complete);
        String[] arr = getResources().getStringArray(R.array.books);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arr);
        books.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.save:
                // User chose the "Settings" item, show the app settings UI...
                save();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
