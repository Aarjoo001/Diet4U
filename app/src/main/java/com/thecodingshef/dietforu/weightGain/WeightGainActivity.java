package com.thecodingshef.dietforu.weightGain;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.thecodingshef.dietforu.R;

public class WeightGainActivity extends AppCompatActivity {
Button btn1,btn2,btn3,btn4,btn5,btn6,btn7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_gain);
        if(getSupportActionBar()!=null){
getSupportActionBar().setTitle("Weight gain diet plan");
 getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
}
        btn1=findViewById(R.id.btn1);
        btn3=findViewById(R.id.btn3);
        btn2=findViewById(R.id.btn2);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm=getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.c,new SaturdayGainFragment()).addToBackStack(null).commit();

            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.c, new MondayGainActivity()).addToBackStack(null).commit();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.c, new TuesdayGainActivity()).addToBackStack(null).commit();
            }

        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.c, new WednesdayGainActivity()).addToBackStack(null).commit();

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.c, new ThursdayGainActivity()).addToBackStack(null).commit();

            }
        });
       btn5.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               FragmentManager fm=getSupportFragmentManager();
               fm.beginTransaction().replace(R.id.c,new FridayGainFragment()).addToBackStack(null).commit();
           }
       });
       btn7.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               FragmentManager fm=getSupportFragmentManager();
               fm.beginTransaction().replace(R.id.c,new SundayFragment()).addToBackStack(null).commit();

           }
       });

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