package com.example.pos.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@androidx.room.Dao
public interface Dao {
    @Insert
    void insert(Item item);

    @Update
    void update(Item item);

    @Delete
    void delete(Item item);

    @Query("SELECT * FROM itemTable")
    LiveData<List<Item>> getAllItems();

    @Query("SELECT * FROM itemTable WHERE Name is :itemName")
    LiveData<List<Item>> getSpecificItem(String itemName);

    @Query("DELETE FROM itemTable")
    void deleteAll();
}
