package tiil.edu.project_quizzappmatchgrade3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        //Gán adapter
        myAdapter = new MyAdapter(this, getListItem());
        recyclerView.setAdapter(myAdapter);

        //Gach ngang giua nhung thu muc
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
    }

    //Lay du lieu tu item
    private List<item> getListItem() {
        List<item> items = new ArrayList<>();
        items.add(new item("Thử thách", "Hãy vượt qua các thử thách", R.drawable.thuthach));
        items.add(new item("Đề kiểm tra", "Kiểm tra cấp độ", R.drawable.dekiemtra));
        items.add(new item("Bảng cửu chương", "Em đã thuộc?", R.drawable.img_1));
        items.add(new item("Đọc sách", "Nâng tầm kiến thức", R.drawable.docsach));
        items.add(new item("Trò chơi", "Nâng cao trí tuệ, giải trí", R.drawable.img));
        return items;
    }
}