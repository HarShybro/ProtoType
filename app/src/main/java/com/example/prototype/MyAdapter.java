package com.example.prototype;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prototype.resultcalculator.MainActivity;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<MyRecyclerData> myRecyclerDataArrayList;
    private Context context;
    int last_position=-1;
    public MyAdapter(ArrayList<MyRecyclerData> myRecyclerDataArrayList,Context context){
        this.myRecyclerDataArrayList=myRecyclerDataArrayList;
        this.context=context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MyRecyclerData myRecyclerData=myRecyclerDataArrayList.get(position);
        holder.cardText.setText(myRecyclerData.getTitle());
        holder.cardImage.setImageResource(myRecyclerData.getImg());
        rvAnimation(holder.itemView,position);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity( new Intent(context, MainActivity.class) );

            }
        });
    }

    @Override
    public int getItemCount() {
        return myRecyclerDataArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView cardText;
        private ImageView cardImage;
        private LinearLayout linearLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardImage=itemView.findViewById(R.id.cardImage);
            cardText=itemView.findViewById(R.id.cardText);
            linearLayout=itemView.findViewById(R.id.cardLinearLayout);
        }
    }
    public void rvAnimation(View view,int position){
//        Animation animation=AnimationUtils.loadAnimation(context,android.R.anim.slide_in_left);
//        view.startAnimation(animation);

        if(position>last_position){
            Animation animation= AnimationUtils.loadAnimation(context,android.R.anim.slide_in_left);
            view.startAnimation(animation);
            last_position=position;
        }
    }

}

