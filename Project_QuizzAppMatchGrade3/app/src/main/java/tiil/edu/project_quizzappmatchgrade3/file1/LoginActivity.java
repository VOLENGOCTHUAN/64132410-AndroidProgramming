package tiil.edu.project_quizzappmatchgrade3.file1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import tiil.edu.project_quizzappmatchgrade3.R;
import tiil.edu.project_quizzappmatchgrade3.file2.MyAdapter;
import tiil.edu.project_quizzappmatchgrade3.file2.item;

public class LoginActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private MyAdapter myAdapter;
    ImageView btnSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Khởi tạo các phần tử
        recyclerView = findViewById(R.id.recyclerview);
        btnSetting = findViewById(R.id.btnSetting);

        // Thiết lập sự kiện click cho nút Setting
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("LoginActivity", "Setting button clicked");
                Toast.makeText(LoginActivity.this, "Setting clicked", Toast.LENGTH_SHORT).show();
                showPopupMenu(v);  // Hiển thị popup menu khi nhấn vào nút Setting
            }
        });

        // Thiết lập RecyclerView
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        myAdapter = new MyAdapter(this, getListItem());
        recyclerView.setAdapter(myAdapter);


        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
    }

    // Lấy dữ liệu cho RecyclerView
    private List<item> getListItem() {
        List<item> items = new ArrayList<>();
        items.add(new item("Bài tập theo chương", "Ôn tập các dạng bài tập theo từng chương", R.drawable.img_4));
        items.add(new item("Tự do luyện tập", "Luyện tập thỏa thích các dạng bài tập", R.drawable.img_24));
        items.add(new item("Bảng cửu chương", "Cộng, trừ, nhân, chia. Em đã thuộc?", R.drawable.img));
        items.add(new item("Thử thách", "Làm bài tập có thời gian và điểm số", R.drawable.img_6));
        return items;
    }

    // Hiển thị PopupMenu khi nhấn vào nút Setting
    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.setting_menu, popupMenu.getMenu());

        // Xử lý sự kiện click item trong PopupMenu
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                 if (id == R.id.menu_about) {
                    // Mở màn hình giới thiệu ứng dụng
                    Intent intent = new Intent(LoginActivity.this, AboutActivity.class);
                    startActivity(intent);
                    return true;
                 }else if (id == R.id.menu_back) {
                    // Quay lại màn hình đăng nhập
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    return true;
                 }
                return false;
            }
        });
        popupMenu.show();  // Hiển thị PopupMenu
    }
}
