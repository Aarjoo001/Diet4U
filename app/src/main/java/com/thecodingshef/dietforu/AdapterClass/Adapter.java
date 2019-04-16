package com.thecodingshef.dietforu.AdapterClass;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.thecodingshef.dietforu.BMIActivity;
import com.thecodingshef.dietforu.ContactActivity;
import com.thecodingshef.dietforu.DietForDisease.DiseaseActivity;
import com.thecodingshef.dietforu.Model;
import com.thecodingshef.dietforu.R;
import com.thecodingshef.dietforu.balancedDiet.WeeklyActivity;
import com.thecodingshef.dietforu.bodyfact.Main2Activity;
import com.thecodingshef.dietforu.weightGain.WeightGainActivity;
import com.thecodingshef.dietforu.weightLoss.WeightLossActivity;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    Context c;
    private List<Model> nameList;
    public Adapter(Context c,List<Model> nameList){

        this.c=c;
        this.nameList=nameList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row,viewGroup,false);
        return new ViewHolder(view,c,nameList);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Model model= nameList.get(i);
        viewHolder.tx.setText(model.getDescription());

        viewHolder.image.setImageResource(model.getImage());
        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(model.getDescription().equalsIgnoreCase("Facts")){
                    Intent i=new Intent(c,Main2Activity.class);
                    i.putExtra("n",model.getDescription());
                    c.startActivity(i);


                }
                if(model.getDescription().equalsIgnoreCase("BMI calculator"))
                {
                    Intent i = new Intent(c, BMIActivity.class);
                    c.startActivity(i);
                }
                if(model.getDescription().equalsIgnoreCase("About us")) {
                    Intent i1=new Intent(c,ContactActivity.class);
                    c.startActivity(i1);
                }
                if(model.getDescription().equalsIgnoreCase("weight loss diet")) {
                    Intent i1=new Intent(c,WeightLossActivity.class);
                    c.startActivity(i1);
                }
                if(model.getDescription().equalsIgnoreCase("weight gain diet")) {
                    Intent i1=new Intent(c,WeightGainActivity.class);
                    c.startActivity(i1);
                }
                if(model.getDescription().equalsIgnoreCase("weekly diet")) {
                    Intent i1=new Intent(c,WeeklyActivity.class);
                    c.startActivity(i1);
                }
                if(model.getDescription().equalsIgnoreCase("Exercise")) {
                    Intent i1=new Intent(c,DiseaseActivity.class);
                    c.startActivity(i1);
                }



                if(model.getDescription().equalsIgnoreCase("Rate us")) {
                    try{
                        c.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+c.getPackageName())));
                    }catch (ActivityNotFoundException e){
                        c.startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://play.google.com/store/apps/details?id="+c.getPackageName())));
                    }
                }



            }
        });

    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tx;
        ImageView image;
        List<Model> nameList=new ArrayList<>();
        Context context;
        RelativeLayout layout;

        public ViewHolder(@NonNull View itemView,Context context,List<Model> nameList) {
            super(itemView);
            this.context=context;
           this.nameList=nameList;



            tx=itemView.findViewById(R.id.tx);

            image=itemView.findViewById(R.id.image);
            layout=(RelativeLayout)itemView.findViewById(R.id.layout);


        }
    }
}
