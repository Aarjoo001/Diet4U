package com.thecodingshef.dietforu.AdapterClass;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thecodingshef.dietforu.Item;
import com.thecodingshef.dietforu.R;

import java.util.List;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.Adapter2ViewHolder> {

    Context c;
    List<Item> list;
    public Adapter2(Context c,List<Item> list){
      this.c=c;
      this.list=list;

  }

    @NonNull
    @Override
    public Adapter2.Adapter2ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);
        return new Adapter2ViewHolder(view,c,list);


    }

    @Override
    public void onBindViewHolder(@NonNull Adapter2.Adapter2ViewHolder adapter2ViewHolder, int i) {
Item item=list.get(i);
        adapter2ViewHolder.tx2.setText(item.getHeader());
        adapter2ViewHolder.tx.setText(item.getFact());
        adapter2ViewHolder.im.setImageResource(item.getImage());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Adapter2ViewHolder extends RecyclerView.ViewHolder {
        TextView tx,tx2;
        ImageView im;
        Context c;
        List<Item> list;

        public Adapter2ViewHolder(@NonNull View itemView,Context c,List<Item> list) {
            super(itemView);
             this.c=c;
             this.list=list;
            tx2=itemView.findViewById(R.id.tx2);
             tx=itemView.findViewById(R.id.tx);
             im=itemView.findViewById(R.id.im);

        }
    }
}



