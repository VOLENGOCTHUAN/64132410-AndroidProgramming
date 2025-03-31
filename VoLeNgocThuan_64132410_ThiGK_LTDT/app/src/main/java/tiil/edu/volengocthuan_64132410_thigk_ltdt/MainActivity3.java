package tiil.edu.volengocthuan_64132410_thigk_ltdt;

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
ArrayList<String> ds;
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
        list = findViewById(R.id.listview);
        ds = new ArrayList<>();
        ds.add("Tiến về Sài Gòn");
        ds.add("Giải phóng Miền nam");
        ds.add("Đất nước trọn niềm vui");
        ds.add("Bài ca thống nhất");
        ds.add("Mùa xuân trên thành phố HCM");
        ds.add("Như có Bác trong ngày đại thắng");
        ds.add("Sài Gòn Quật Khởi");
        ds.add("Bài ca không quên");
        ds.add("Nam Bộ kháng chiến");
        ds.add("Giải phóng quân ta đi");

        ArrayAdapter<String> adapterc;
        adapterc = new ArrayAdapter<>(this,R.layout.activity_main3,ds);

        list.setAdapter(adapterc);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String tam = ds.get(position);
                Toast.makeText(MainActivity3.this, tam, Toast.LENGTH_SHORT).show();
            }
        });
    }
}