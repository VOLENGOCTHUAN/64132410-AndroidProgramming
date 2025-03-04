package tiil.edu.vd2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editTextSo1, editTextSo2, editTextKetQua;
    Button nutCong, nutTru, nutNhan, nutChia;

    void TimDieuKhien() {
        editTextSo1 = findViewById(R.id.edtSo1);
        editTextSo2 = findViewById(R.id.edtSo2);
        editTextKetQua = findViewById(R.id.edtKetQua);
        nutCong = findViewById(R.id.btnCong);
        nutTru = findViewById(R.id.btnTru);
        nutNhan = findViewById(R.id.btnNhan);
        nutChia = findViewById(R.id.btnChia);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
    }

    public void AnBanPhim(View v) {
        editTextSo1.clearFocus();
        editTextSo2.clearFocus();
    }

    float[] LayDuLieu() {
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();

        if (soThu1.isEmpty() || soThu2.isEmpty()) {
            editTextKetQua.setText("Vui lòng nhập đủ 2 số!");
            return null;
        }
        return new float[]{Float.parseFloat(soThu1), Float.parseFloat(soThu2)};
    }

    public void XuLyCong(View v) {
        float[] data = LayDuLieu();
        if (data == null) return;
        float kq = data[0] + data[1];
        editTextKetQua.setText(String.valueOf(kq));
        AnBanPhim(v);
    }

    public void XuLyTru(View v) {
        float[] data = LayDuLieu();
        if (data == null) return;
        float kq = data[0] - data[1];
        editTextKetQua.setText(String.valueOf(kq));
        AnBanPhim(v);
    }

    public void XuLyNhan(View v) {
        float[] data = LayDuLieu();
        if (data == null) return;
        float kq = data[0] * data[1];
        editTextKetQua.setText(String.valueOf(kq));
        AnBanPhim(v);
    }

    public void XuLyChia(View v) {
        float[] data = LayDuLieu();
        if (data == null) return;
        if (data[1] == 0) {
            editTextKetQua.setText("Không thể chia cho 0!");
            return;
        }
        float kq = data[0] / data[1];
        editTextKetQua.setText(String.valueOf(kq));
        AnBanPhim(v);
    }
}
