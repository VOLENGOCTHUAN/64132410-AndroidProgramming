package tiil.edu.testbaithigk;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
ListView list;
ArrayList<String> dsnhac;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        list = findViewById(R.id.listView);
        dsnhac = new ArrayList<String>();
        dsnhac.add("Nhạc 1");
        dsnhac.add("Nhạc 2");
        dsnhac.add("Nhạc 3");
        dsnhac.add("Nhạc 4");
        dsnhac.add("Nhạc 5");
        dsnhac.add("Nhạc 6");
        dsnhac.add("Nhạc 7");
        dsnhac.add("Nhạc 8");

        ArrayAdapter<String> adapterc;
        adapterc = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1,dsnhac);

        list.setAdapter(adapterc);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String tam = dsnhac.get(position);
                Toast.makeText(MainActivity3.this,tam,Toast.LENGTH_SHORT).show();
            }
        });
    }
}