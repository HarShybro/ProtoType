package com.example.prototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.example.prototype.Calculator.CaclutorTwo;
import com.example.prototype.resultcalculator.MainActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class SFD_BMD_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<MyRecyclerData> myRecyclerDataArrayList;
    GridLayoutManager gridLayoutManager;
    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sfd_bmd);
        recyclerView=findViewById(R.id.recyclerParentView);

        myRecyclerDataArrayList=new ArrayList<>();
        myRecyclerDataArrayList.add(new MyRecyclerData("Simple bean-Uniformly Distributed Load",R.drawable.a_model));
        myRecyclerDataArrayList.add(new MyRecyclerData("Simple bean-Uniformly Distributed Load",R.drawable.pic));

        MyAdapter adapter=new MyAdapter(myRecyclerDataArrayList,this);
        gridLayoutManager=new GridLayoutManager(this,1);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);


        adView=findViewById(R.id.adView);

        MobileAds.initialize(this);
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.calculator){
            startActivity(  new Intent(SFD_BMD_Activity.this,CaclutorTwo.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No",null)
                .show();

    }



}