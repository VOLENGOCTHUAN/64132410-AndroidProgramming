package tiil.edu.ex5_addsubmuldiv_var;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // Khai báo các đối tượng giao diện
    EditText edtSoA, edtSoB;
    Button btnCong, btnTru, btnNhan, btnChia;
    TextView tvKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Gán View
        TimView();

        // Gán sự kiện Click cho các button
        btnCong.setOnClickListener(boLangNghe_XuLyCong);
        btnTru.setOnClickListener(boLangNghe_XuLyTru);
        btnNhan.setOnClickListener(boLangNghe_XuLyNhan);
        btnChia.setOnClickListener(boLangNghe_XuLyChia);
    }

    // Hàm tìm và liên kết các View với ID trong XML
    void TimView() {
        edtSoA = findViewById(R.id.edtSoA);
        edtSoB = findViewById(R.id.edtSoB);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        tvKetQua = findViewById(R.id.tvKetQua);
    }

    // Hàm lấy số từ EditText, kiểm tra nếu rỗng thì trả về 0
    double laySo(EditText edt) {
        try {
            String str = edt.getText().toString().trim();
            return str.isEmpty() ? 0 : Double.parseDouble(str);
        } catch (Exception e) {
            return 0;
        }
    }

    // Bộ lắng nghe và xử lý sự kiện
    View.OnClickListener boLangNghe_XuLyCong = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            double so1 = laySo(edtSoA);
            double so2 = laySo(edtSoB);
            double ketQua = so1 + so2;
            tvKetQua.setText(String.valueOf(ketQua));
        }
    };

    View.OnClickListener boLangNghe_XuLyTru = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            double so1 = laySo(edtSoA);
            double so2 = laySo(edtSoB);
            double ketQua = so1 - so2;
            tvKetQua.setText(String.valueOf(ketQua));
        }
    };

    View.OnClickListener boLangNghe_XuLyNhan = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            double so1 = laySo(edtSoA);
            double so2 = laySo(edtSoB);
            double ketQua = so1 * so2;
            tvKetQua.setText(String.valueOf(ketQua));
        }
    };

    View.OnClickListener boLangNghe_XuLyChia = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            double so1 = laySo(edtSoA);
            double so2 = laySo(edtSoB);
            if (so2 == 0) {
                tvKetQua.setText("Không thể chia cho 0");
            } else {
                double ketQua = so1 / so2;
                tvKetQua.setText(String.valueOf(ketQua));
            }
        }
    };
}
