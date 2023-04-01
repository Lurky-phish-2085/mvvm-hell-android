package com.example.pos.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pos.Database.Item;
import com.example.pos.R;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {

    private List<Item> items = new ArrayList<>();

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item, parent, false);

        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Item currentItem = items.get(position);
        holder.textViewName.setText(currentItem.getName());
        holder.textViewDescription.setText(currentItem.getDescription());
        holder.textViewID.setText(String.valueOf(currentItem.getID()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<Item> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    class ItemHolder extends RecyclerView.ViewHolder {

        private TextView textViewName;
        private TextView textViewDescription;
        private TextView textViewID;


        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewDescription = itemView.findViewById(R.id.text_view_description);
            textViewID = itemView.findViewById(R.id.text_view_id);
        }
    }
}
