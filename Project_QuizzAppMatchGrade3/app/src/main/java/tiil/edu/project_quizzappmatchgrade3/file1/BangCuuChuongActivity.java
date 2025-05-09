package tiil.edu.project_quizzappmatchgrade3.file1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import tiil.edu.project_quizzappmatchgrade3.R;

public class BangCuuChuongActivity extends AppCompatActivity {

    ImageView imgClick;
    EditText edtNhap;
    TextView tvKetQua;
    TextView tvTieuDe;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bang_cuu_chuong);

        imgClick = findViewById(R.id.imgClick);
        edtNhap = findViewById(R.id.edtNhap);
        tvKetQua = findViewById(R.id.tvkq);
        tvTieuDe = findViewById(R.id.tvTieuDe);


        imgClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvKetQua.setText(""); // Xóa kết quả cũ

                // Lấy số nhập vào
                String input = edtNhap.getText().toString().trim();
                if (input.isEmpty()) {
                    tvKetQua.setText("Vui lòng nhập số.");
                    tvTieuDe.setText("Bảng cửu chương nhân ");
                    return;
                }
                try {
                    int so = Integer.parseInt(input);
                    tvTieuDe.setText("Bảng cửu chương nhân " + so);

                    StringBuilder ketQua = new StringBuilder();
                    for (int i = 1; i <= 10; i++) {
                        ketQua.append(so).append(" x ").append(i).append(" = ").append(so * i);
                        if (i != 10) ketQua.append(" \n ");
                    }

                    // Hiển thị kết quả
                    tvKetQua.setText(ketQua.toString());
                } catch (NumberFormatException e) {
                    tvKetQua.setText("Giá trị nhập không hợp lệ.");
                    tvTieuDe.setText("Bảng cửu chương nhân");
                }
            }
        });
    }
}