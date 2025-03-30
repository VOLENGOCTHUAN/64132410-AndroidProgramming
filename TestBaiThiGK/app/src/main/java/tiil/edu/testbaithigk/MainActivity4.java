package tiil.edu.testbaithigk;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);

recyclerView = findViewById(R.id.recyclerview);


        List<Item> items = new ArrayList<>();
        items.add(new Item("john wick","john.c.breckinridge@altostrat.com",R.drawable.mememeo2));
        items.add(new Item("sally","sally.com",R.drawable.mememeo1));
        items.add(new Item("alice","alice.com",R.drawable.mememeo4));
        items.add(new Item("bun bo","bunbo.com",R.drawable.mememeo2));
        items.add(new Item("Banh mi op la","banhmi.com",R.drawable.mememeo1));
        items.add(new Item("Thuan vo","Thuanvo.vln.64cntt@ntu.edu.vn",R.drawable.mememeo4));
        items.add(new Item("e","e.com",R.drawable.mememeo2));
        items.add(new Item("ong gia noel","onggia.com",R.drawable.mememeo1));
        items.add(new Item("puppy","pup.com",R.drawable.mememeo4));
        items.add(new Item("virrus","virrus.com",R.drawable.mememeo2));
        items.add(new Item("you tu beo","you.com",R.drawable.mememeo1));
        items.add(new Item("toi ten la","toi.com",R.drawable.mememeo4));
        items.add(new Item("ngoc kem","kem.com",R.drawable.mememeo2));
        items.add(new Item("bot iuuu","bot.com",R.drawable.mememeo1));
        items.add(new Item("cat","cat.com",R.drawable.mememeo4));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));
    }
}