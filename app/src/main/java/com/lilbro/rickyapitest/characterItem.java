package com.lilbro.rickyapitest;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


public class characterItem extends RecyclerView.ViewHolder{

    private TextView name,status,species,gender;
    private ImageView imageCharacter,imageStatus;
    private View view;

    public characterItem(@NonNull View itemView) {
        super(itemView);
        view = itemView;

        name = itemView.findViewById(R.id.textViewName);
        status = itemView.findViewById(R.id.textViewStatus);
        species = itemView.findViewById(R.id.textViewSpecies);
        gender = itemView.findViewById(R.id.textViewGender);
        imageCharacter = itemView.findViewById(R.id.imageCharacter);
        imageStatus = itemView.findViewById(R.id.imageStatus);


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setTextSize(40);
                status.setTextSize(20);
                species.setTextSize(20);
                gender.setTextSize(20);
            }
        });
    }


    public void updateItemWithCharacter(Character c){
        this.name.setText(c.getName());
        this.status.setText(c.getStatus());
        this.species.setText(c.getSpecies());
        this.gender.setText(c.getGender());

        if(c.getStatus().equals("Dead")){
            this.imageStatus.setImageResource(R.drawable.red_circle);
        }else if(c.getStatus().equals("unknown")){
            this.imageStatus.setImageResource(R.drawable.grey_circle);
        }
        else if(c.getStatus().equals("Alive")){
            this.imageStatus.setImageResource(R.drawable.green_circle);
        }

        Glide.with(view)
                .load(Uri.parse(c.getUrl())).override(400,400).centerCrop()
                .into(imageCharacter);

    }


}
