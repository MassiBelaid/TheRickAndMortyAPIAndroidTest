package com.lilbro.rickyapitest;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


public class characterItem extends RecyclerView.ViewHolder {

    private TextView name,status,species,gender;
    private ImageView imageCharacter;
    private View view;

    public characterItem(@NonNull View itemView) {
        super(itemView);
        view = itemView;

        name = itemView.findViewById(R.id.textViewName);
        status = itemView.findViewById(R.id.textViewStatus);
        species = itemView.findViewById(R.id.textViewSpecies);
        gender = itemView.findViewById(R.id.textViewGender);
        imageCharacter = itemView.findViewById(R.id.imageCharacter);
    }


    public void updateItemWithCharacter(Character c){
        this.name.setText(c.getName());
        this.status.setText(c.getStatus());
        this.species.setText(c.getSpecies());
        this.gender.setText(c.getGender());

        Glide.with(view)
                .load(Uri.parse(c.getUrl())).override(400,400).centerCrop()
                .into(imageCharacter);

    }
}
