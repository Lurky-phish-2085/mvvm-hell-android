package com.example.pos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pos.Database.Item;
import com.example.pos.ViewModel.ItemViewModel;

public class ItemFormActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_Name = "a";
    public static final String EXTRA_Description = "b";
    ItemViewModel itemViewModel;
    EditText name, description;

    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_form);

        init();
    }

    private void init() {
        itemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);
        name = findViewById(R.id.et_name);
        description = findViewById(R.id.et_desc);

        add = findViewById(R.id.add_btn);
        add.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v == add){
            addData();
        }
    }


    private void addData() {
        String name = this.name.getText().toString();
        String description = this.description.getText().toString();
        Intent data = new Intent();
        data.putExtra(EXTRA_Name, name);
        data.putExtra(EXTRA_Description, description);

        setResult(RESULT_OK, data);
        finish();
    }
}