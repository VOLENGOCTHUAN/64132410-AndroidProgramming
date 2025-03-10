package tiil.edu.lvlistnhacjack;

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

public class MainActivity extends AppCompatActivity {
    ListView ListViewMusic;
    ArrayList<String> dsListNhac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ListViewMusic = findViewById(R.id.lvMusic);
        //B1. Chuan bi du lieu in ra man hinh
        dsListNhac = new ArrayList<String>();
        dsListNhac.add("Giai điệu miền tây");
        dsListNhac.add("Bến tre! Ta có em");
        dsListNhac.add("Sóng gió");
        dsListNhac.add("Em gì ơi (Remix)");
        dsListNhac.add("Sao em vô tình");
        dsListNhac.add("Thiên lý ơi");
        dsListNhac.add("Đom đóm");
        dsListNhac.add("Bạc phận");
        dsListNhac.add("Hồng nhan");
        dsListNhac.add("Màu mắt em");
        dsListNhac.add("Để đó anh lo");
        dsListNhac.add("Trả lại anh ");
        dsListNhac.add("Xuân không màu");

        //B2.
        ArrayAdapter<String> adapterMusic;
        adapterMusic = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                dsListNhac);

        //B3. Gan adapter cho listView
        ListViewMusic.setAdapter(adapterMusic);

        //B4. Gan bo lang nghe va xu ly su kien cho listView
        ListViewMusic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String giaTriDuocChon = dsListNhac.get(position);
                //Lam gi do voi gia tri duoc chon
                //Don gian, ta Toast len
                Toast.makeText(MainActivity.this, giaTriDuocChon, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
