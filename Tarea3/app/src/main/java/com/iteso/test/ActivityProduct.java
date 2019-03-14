package com.iteso.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.iteso.test.beans.ItemProduct;

public class ActivityProduct extends Activity {
    EditText title, location, store, phone;
    ItemProduct itemProduct;
    ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        itemProduct = getIntent().getParcelableExtra("ITEM");
        title = findViewById(R.id.edit_name);
        store = findViewById(R.id.edit_store);
        location = findViewById(R.id.edit_location);
        phone = findViewById(R.id.edit_phone);
        imageView = findViewById(R.id.activity_detail_image);
        title.setText(itemProduct.getTitle());
        store.setText(itemProduct.getStore());
        location.setText(itemProduct.getLocation());
        phone.setText(itemProduct.getPhone());

        switch (itemProduct.getImage()) {
            case 0:
                imageView.setImageResource(R.drawable.alienware);
                break;
            case 1:
                imageView.setImageResource(R.drawable.mac);
                break;
        }
    }


    public void save(View v){
        itemProduct.setTitle(title.getText().toString());
        itemProduct.setLocation(location.getText().toString());
        itemProduct.setStore(store.getText().toString());
        itemProduct.setPhone(phone.getText().toString());
        Intent intent = new Intent();
        intent.putExtra("ITEM", itemProduct);
        setResult(ActivityMain.RESULT_OK, intent);
        finish();
    }

    public void cancel(View v){
        setResult(ActivityMain.RESULT_CANCELED);
        finish();
    }

}
