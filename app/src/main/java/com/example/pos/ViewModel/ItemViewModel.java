package com.example.pos.ViewModel;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.pos.Database.Item;
import com.example.pos.Database.Repository;

import java.util.List;

public class ItemViewModel extends AndroidViewModel {
    private Repository repository;
    private LiveData<List<Item>> itemList;


    public ItemViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        itemList = repository.getItemList();
    }

    public void insert(Item item){
        repository.insert(item);
    }

    public void delete(Item item){
        repository.delete(item);
    }

    public void update(Item item){
        repository.update(item);
    }

    public LiveData<List<Item>> getAllItems() {
        return repository.getItemList();
    }
    public LiveData<List<Item>> getSpecificItems(String itemName){
        return repository.getSpecificItemList(itemName);
    }
}
