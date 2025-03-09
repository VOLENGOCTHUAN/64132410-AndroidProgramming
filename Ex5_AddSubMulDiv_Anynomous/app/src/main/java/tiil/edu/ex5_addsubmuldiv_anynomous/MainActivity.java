package tiil.edu.ex5_addsubmuldiv_anynomous;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editTextSo1, editTextSo2, editTextKetQua;
    Button nutCong, nutTru, nutNhan, nutChia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
        GanSuKien();
    }

    void TimDieuKhien() {
        editTextSo1 = findViewById(R.id.edtSo1);
        editTextSo2 = findViewById(R.id.edtSo2);
        editTextKetQua = findViewById(R.id.edtKetQua);
        nutCong = findViewById(R.id.btnCong);
        nutTru = findViewById(R.id.btnTru);
        nutNhan = findViewById(R.id.btnNhan);
        nutChia = findViewById(R.id.btnChia);
    }

    void GanSuKien() {
        nutCong.setOnClickListener(v -> XuLyPhepToan(v, "+"));
        nutTru.setOnClickListener(v -> XuLyPhepToan(v, "-"));
        nutNhan.setOnClickListener(v -> XuLyPhepToan(v, "*"));
        nutChia.setOnClickListener(v -> XuLyPhepToan(v, "/"));
    }

    public void AnBanPhim(View v) {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        if (imm != null && getCurrentFocus() != null) {
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        editTextSo1.clearFocus();
        editTextSo2.clearFocus();
    }

    float[] LayDuLieu() {
        String soThu1 = editTextSo1.getText().toString().trim();
        String soThu2 = editTextSo2.getText().toString().trim();

        if (soThu1.isEmpty() || soThu2.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đủ 2 số!", Toast.LENGTH_SHORT).show();
            return null;
        }

        try {
            float num1 = Float.parseFloat(soThu1);
            float num2 = Float.parseFloat(soThu2);
            return new float[]{num1, num2};
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Vui lòng nhập số hợp lệ!", Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    public void XuLyPhepToan(View v, String phepToan) {
        float[] data = LayDuLieu();
        if (data == null) return;

        float kq = 0;
        switch (phepToan) {
            case "+":
                kq = data[0] + data[1];
                break;
            case "-":
                kq = data[0] - data[1];
                break;
            case "*":
                kq = data[0] * data[1];
                break;
            case "/":
                if (data[1] == 0) {
                    Toast.makeText(this, "Không thể chia cho 0!", Toast.LENGTH_SHORT).show();
                    return;
                }
                kq = data[0] / data[1];
                break;
        }
        editTextKetQua.setText(String.format("%.2f", kq));
        AnBanPhim(v);
    }
}
