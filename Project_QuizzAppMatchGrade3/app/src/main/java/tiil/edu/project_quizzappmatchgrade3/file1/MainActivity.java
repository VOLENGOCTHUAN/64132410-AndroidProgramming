package tiil.edu.project_quizzappmatchgrade3.file1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import tiil.edu.project_quizzappmatchgrade3.file2.MyAdapter;
import tiil.edu.project_quizzappmatchgrade3.R;
import tiil.edu.project_quizzappmatchgrade3.file2.item;

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
        items.add(new item("Bài kiểm tra", "Kiểm tra cấp độ", R.drawable.img_4));
        items.add(new item("Bảng cửu chương", "Cộng, trừ, nhân, chia. Em đã thuộc?", R.drawable.img));
        items.add(new item("Chế độ", "", R.drawable.docsach));
        items.add(new item("Cài đặt", "", R.drawable.img_3));
        return items;
    }
}