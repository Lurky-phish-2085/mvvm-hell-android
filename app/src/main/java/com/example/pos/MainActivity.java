package com.example.pos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pos.Database.Item;
import com.example.pos.ViewModel.ItemViewModel;
import com.example.pos.adapter.ItemAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int ADD_NOTE_REQUEST = 1;
    private ItemViewModel itemViewModel;
    Button createBtn;

    EditText name, description;
    Button add;
    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createBtn = findViewById(R.id.switch_to_create);
        createBtn.setOnClickListener(this);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        adapter = new ItemAdapter();
        recyclerView.setAdapter(adapter);


        itemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);
        itemViewModel.getAllItems().observe(this, new Observer<List<Item>>() {
            @Override
            public void onChanged(List<Item> items) {
//                System.out.println("Onchange DIE!!!!!!!!!!!!!!!!!!!!!!!!!");
//                System.out.println(itemViewModel.getAllItems().getValue());
//                adapter.setItems(items);
                
            }
        });
//        setTheAdapter();
    }

    private void setTheAdapter() {
        System.out.println("INITIALIZING SEQUENCE");
        System.out.println(itemViewModel.getAllItems().getValue());
        List<Item> items = itemViewModel.getAllItems().getValue();
        adapter.setItems(items);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ADD_NOTE_REQUEST && resultCode == RESULT_OK){
            String name = data.getStringExtra(ItemFormActivity.EXTRA_Name);
            String description = data.getStringExtra(ItemFormActivity.EXTRA_Description);

            Item item = new Item("S", "s");
            itemViewModel.insert(item);
            setTheAdapter();
            Toast.makeText(this, "notesaved", Toast.LENGTH_SHORT).show();
        }
    }

    public void displayBuilder(String title, String message) {
        AlertDialog.Builder build = new AlertDialog.Builder(this);
        build.setCancelable(true);
        build.setMessage(message);
        build.setTitle(title);
        build.show();
    }

    @Override
    public void onClick(View v) {
        if (v ==  createBtn) {
            Intent intent = new Intent(MainActivity.this,  ItemFormActivity.class);
            startActivityForResult(intent, ADD_NOTE_REQUEST);
        }
        if(v == add){
//            switchBackToMain();
        }
    }



    private void init() {
        itemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);
        name = findViewById(R.id.et_name);
        description = findViewById(R.id.et_desc);

        add = findViewById(R.id.add_btn);
        add.setOnClickListener(this);
    }

}


