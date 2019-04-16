package com.thecodingshef.dietforu;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class BMIActivity extends AppCompatActivity {
EditText tx2,tx4,tx5;
TextView result;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

 if(getSupportActionBar()!=null){
getSupportActionBar().setTitle("BMI Calculator");
 getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
}
        setContentView(R.layout.activity_bmi);
        tx2=findViewById(R.id.tx2);
        tx4=findViewById(R.id.tx4);
        tx5=findViewById(R.id.tx5);
        btn=findViewById(R.id.btn);
        result=(TextView) findViewById(R.id.result);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String w=tx2.getText().toString();
                String re="";
                String ft=tx4.getText().toString();
                String inch=tx5.getText().toString();

                if (ft != null && !"".equals(ft)
                        && w != null  &&  !"".equals(w)) {
                    float weight = Float.parseFloat(w);
                    float height1 = Float.parseFloat(ft);
                    float height2 = Float.parseFloat(inch);
                    float height= (float) ((height1*30.48)+(height2*2.54));
                    float res = (weight * 10000) / (height * height);
                    re = String.valueOf(res);
                    result.setText(re);
                    if(res < 18.5){
                        int greenColorValue = Color.parseColor("#05a0ae");
                        result.setBackgroundColor(greenColorValue);
                    }
                    else if(res>=18.5 && res<=24.9){
                        int greenColorValue = Color.parseColor("#059a03");
                        result.setBackgroundColor(greenColorValue);
                    }
                    else if(res>=25 && res<=29.9){
                        int greenColorValue = Color.parseColor("#fad118");
                        result.setBackgroundColor(greenColorValue);
                    }
                    else if(res >=30){
                        int greenColorValue = Color.parseColor("#b32e05");
                        result.setBackgroundColor(greenColorValue);
                    }
                    }
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
