package com.lilbro.rickyapitest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class characterAdapter extends RecyclerView.Adapter<characterItem> {
    private List<Character> listCharacter;

    public characterAdapter(List<Character> l){
        this.listCharacter = l;
    }

    @NonNull
    @Override
    public characterItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflator = LayoutInflater.from(context);
        View v1 =inflator.inflate(R.layout.character_item_layout,parent, false);

        return new characterItem(v1);
    }

    @Override
    public void onBindViewHolder(@NonNull characterItem holder, int position) {
        holder.updateItemWithCharacter(this.listCharacter.get(position));
    }


    @Override
    public int getItemCount() {
        return this.listCharacter.size();
    }
}
