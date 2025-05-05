package tiil.edu.project_quizzappmatchgrade3;

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

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
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
        recyclerView = findViewById(R.id.recyclerview);

        List<item> items = new ArrayList<>();
        items.add(new item("Đề kiểm tra","Kiểm tra cấp độ","123",R.drawable.thuthach));
        items.add(new item("Đề kiểm tra","Kiểm tra cấp độ","123",R.drawable.dekiemtra));
        items.add(new item("Bảng cửu chương","Em đã thuộc?","123",R.drawable.img_1));
        items.add(new item("Đọc sách","Nâng tầm kiến thức","123",R.drawable.docsach));
        items.add(new item("Trò chơi","Nâng cao trí tuệ, giải trí","123",R.drawable.img));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));
    }
}