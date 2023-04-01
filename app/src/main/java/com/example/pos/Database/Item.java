package com.example.pos.Database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "itemTable")
public class Item {
    @PrimaryKey(autoGenerate = true)
    private int ID;

    private String Name;

    private String Description;

    public Item(String name, String description) {
        Name = name;
        Description = description;
    }

    public Item() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
