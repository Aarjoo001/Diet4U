package com.thecodingshef.dietforu;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.thecodingshef.dietforu.AdapterClass.Adapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView scroll;
List<Model> nameList= new ArrayList<>();
Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
getSupportActionBar().setTitle("Diet4U");
        scroll = findViewById(R.id.scroll);
        adapter= new Adapter(this,nameList);
        scroll.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);

        scroll.setLayoutManager(gridLayoutManager);


        scroll.setAdapter(adapter);
nameList.add(new Model("Weight loss diet",R.drawable.lossplan));
        nameList.add(new Model("Weight gain diet",R.drawable.gainplan));
        nameList.add(new Model("Weekly diet",R.drawable.weekplan));
        nameList.add(new Model("Exercise",R.drawable.exerciseplan));
        nameList.add(new Model("BMI calculator",R.drawable.bmi));
        nameList.add(new Model("Facts",R.drawable.fact));
        nameList.add(new Model("About us",R.drawable.aboutus));
        nameList.add(new Model("Rate us",R.drawable.rate));
    }

    final Context context=this;
    @Override
    public void onBackPressed() {

        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStackImmediate();


        } else {
            final Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.custom);
            Button can = dialog.findViewById(R.id.can);
            can.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();

                }
            });
            ImageView imbtn=(ImageView) dialog.findViewById(R.id.imbtn);
            imbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.cancel();
                }
            });
            dialog.show();

        }
    }
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        android.view.MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {

        if(item.getItemId()==R.id.home){

            Intent shareIntent =   new Intent(android.content.Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT,"Insert Subject here");
            String app_url = " https://play.google.com/store/apps/details?id=com.thecodingshef.Diet4U";
            shareIntent.putExtra(android.content.Intent.EXTRA_TEXT,app_url);
            startActivity(Intent.createChooser(shareIntent, "Share via"));

        }
        else if(item.getItemId()==android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
