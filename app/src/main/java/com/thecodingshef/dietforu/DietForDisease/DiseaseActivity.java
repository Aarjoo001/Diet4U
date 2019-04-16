package com.thecodingshef.dietforu.DietForDisease;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

import com.thecodingshef.dietforu.ExerciseGainFragment;
import com.thecodingshef.dietforu.ExerciseLossFragment;
import com.thecodingshef.dietforu.R;
import com.thecodingshef.dietforu.YogaFragment;

public class DiseaseActivity extends AppCompatActivity {
Button btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);
        if(getSupportActionBar()!=null){
getSupportActionBar().setTitle("Exercise");
 getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
}
       btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm=getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.c1,new ExerciseGainFragment()).addToBackStack(null).commit();

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm=getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.c1,new ExerciseLossFragment()).addToBackStack(null).commit();

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm=getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.c1,new YogaFragment()).addToBackStack(null).commit();
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
