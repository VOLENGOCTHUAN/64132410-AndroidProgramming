package tiil.edu.project_quizzappmatchgrade3.ItemChinh;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import tiil.edu.project_quizzappmatchgrade3.R;

public class BangCuuChuongActivity extends AppCompatActivity {
        Spinner spinnerSo;
        Button imgClick;
        TextView tvCong, tvTru, tvNhan, tvChia;
        ImageView btnQuayLai;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_bang_cuu_chuong);

            spinnerSo = findViewById(R.id.spinnerSo);
            imgClick = findViewById(R.id.imgClick);
            tvCong = findViewById(R.id.tvCong);
            tvTru = findViewById(R.id.tvTru);
            tvNhan = findViewById(R.id.tvNhan);
            tvChia = findViewById(R.id.tvChia);
            btnQuayLai = findViewById(R.id.imgQuayLai2);

            //Khi người dùng nhấn nút, activity hiện tại sẽ kết thúc, trở về màn hình trước đó
            btnQuayLai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish(); // Quay lại activity trước đó
                }
            });

            //Thiết lập Spinner chứa số từ 1 đến 10
            List<Integer> listSo = new ArrayList<>();
            for (int i = 1; i <= 10; i++) listSo.add(i);
            //Thiết lập Adapter cho Spinner để đưa danh sách vào Spinner
            ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listSo);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerSo.setAdapter(adapter);

            imgClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int so = (int) spinnerSo.getSelectedItem();
                    StringBuilder cong = new StringBuilder("➕ Bảng cộng " + so + ":\n");
                    for (int i = 1; i <= 10; i++) {
                        cong.append(so).append(" + ").append(i).append(" = ").append(so + i).append("\n");
                    }
                    StringBuilder tru = new StringBuilder("➖ Bảng trừ " + so + ":\n");
                    for (int i = 1; i <= 10; i++) {
                        tru.append((so + i)).append(" - ").append(so).append(" = ").append(i).append("\n");
                    }
                    StringBuilder nhan = new StringBuilder("✖️ Bảng nhân " + so + ":\n");
                    for (int i = 1; i <= 10; i++) {
                        nhan.append(so).append(" x ").append(i).append(" = ").append(so * i).append("\n");
                    }
                    StringBuilder chia = new StringBuilder("➗ Bảng chia " + so + ":\n");
                    for (int i = 1; i <= 10; i++) {
                        int tich = so * i;
                        chia.append(tich).append(" ÷ ").append(so).append(" = ").append(i).append("\n");
                    }

                    tvCong.setText(cong.toString());
                    tvTru.setText(tru.toString());
                    tvNhan.setText(nhan.toString());
                    tvChia.setText(chia.toString());
                }
            });
        }
    }