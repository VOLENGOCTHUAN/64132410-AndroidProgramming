package tiil.edu.volengocthuan_64132410_thigk_ltdt;

import android.annotation.SuppressLint;
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
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerView = findViewById(R.id.recyclerview);
        List<Item> items = new ArrayList<>();
        items.add(new Item(R.drawable.mememeo1,"Ảnh mèo 1","12/12/2022"));
        items.add(new Item(R.drawable.mememeo2,"Ảnh mèo 2","12/2/2022"));
        items.add(new Item(R.drawable.mememeo3,"Ảnh mèo 3","12/3/2022"));
        items.add(new Item(R.drawable.mememeo4,"Ảnh mèo 4","12/4/2022"));
        items.add(new Item(R.drawable.mememeo5,"Ảnh mèo 5","12/5/2022"));
        items.add(new Item(R.drawable.mememeo6,"Ảnh mèo 6","12/6/2022"));




        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));
    }
}