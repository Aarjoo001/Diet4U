package com.thecodingshef.dietforu.bodyfact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.thecodingshef.dietforu.AdapterClass.Adapter2;
import com.thecodingshef.dietforu.Item;
import com.thecodingshef.dietforu.R;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    RecyclerView recycler_view;
    ImageView im;
    TextView tx, tx2;
    LinearLayout text;
    List<Item> list = new ArrayList<>();
    Adapter2 adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

      if(getSupportActionBar()!=null){
getSupportActionBar().setTitle("Body facts");
 getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
}
        im = findViewById(R.id.im);
        tx = findViewById(R.id.tx);
        tx2 = findViewById(R.id.tx2);

        recycler_view = findViewById(R.id.recyler_view);
        adapter2 = new Adapter2(this, list);
        recycler_view.hasFixedSize();
        recycler_view.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recycler_view.setAdapter(adapter2);
        list.add(new Item("Fact 1", "The total weight of the bacteria in the human body is 2 kg.", R.drawable.icon));
        list.add(new Item("Fact 2", "Human skin is completely replaced about 1,000 times during a person’s lifetime.", R.drawable.icon));
        list.add(new Item("Fact 3", "The structure of the human body contains only four minerals: apatite, aragonite, calcite, and crystobalite.", R.drawable.icon));
        list.add(new Item("Fact 4", "People with blue eyes are more sensitive to pain than others.", R.drawable.icon));
        list.add(new Item("Fact 5", "The strongest muscle in the human body is the tongue.", R.drawable.icon));
        list.add(new Item("Fact 6", "The hands and feet contain almost half of the total bones in the human body.", R.drawable.icon));
        list.add(new Item("Fact 7", "Messages from the human brain travel along nerves at up to 200 miles an hour (322 km/h).", R.drawable.icon));
        list.add(new Item("Fact 8", "A human’s ears and nose never stop growing while human eyes get remain same during lifetime.", R.drawable.icon));
        list.add(new Item("Fact 9", "A human skeleton renews itself completely every 10 years", R.drawable.icon));
        list.add(new Item("Fact 10", "The body can detect taste in .0015 seconds, which is faster than the blink of an eye.", R.drawable.icon));
        list.add(new Item("Fact 11", "The brain contains 86 billion nerve cells joined by 100 trillion connections. This is more than the number of stars in the Milky Way.", R.drawable.icon));
        list.add(new Item("Fact 12", "Each human tongue has its own unique print like Fingerprint.", R.drawable.icon));
        list.add(new Item("Fact 13", "The human brain uses just as much power as a 10-watt light bulb.", R.drawable.icon));
        list.add(new Item("Fact 14", "An adult human body is made up of about 7 octillion(7,000,000,000,000,000,000,000,000,000) atoms.", R.drawable.icon));
         list.add(new Item("Fact 15", "The space between the eyebrows is called the 'glabella' which is derived from the Latin word glabellus, meaning smooth.", R.drawable.icon));
   list.add(new Item("Fact 16","You get a new top layer of skin (epidermis) every 30 days.",R.drawable.icon));
        list.add(new Item("Fact 17","'Onychophagia' is the medical name for nail biting.",R.drawable.icon));
        list.add(new Item("Fact 18","For every pound of fat gained, you add seven miles of new blood vessels.",R.drawable.icon));
        list.add(new Item("Fact 19","Your body produces enough heat in only thirty minutes to boil a half-gallon of water.",R.drawable.icon));
        list.add(new Item("Fact 20","A sneeze can travel with a speed of more than 161 kmph.",R.drawable.icon));
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
