package tiil.edu.project_quizzappmatchgrade3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import tiil.edu.project_quizzappmatchgrade3.ItemChinh.GiaoDienQuiz;
import tiil.edu.project_quizzappmatchgrade3.ItemChinh.QuizActivity;

public class KetQuaActivity extends AppCompatActivity {

    TextView tvDiemKetQua, tvThongDiep, btnRetry, btnThoat;
    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ket_qua);

        // Ánh xạ view
        tvDiemKetQua = findViewById(R.id.tvDiemKetQua);
        tvThongDiep = findViewById(R.id.tvThongDiep);
        btnRetry = findViewById(R.id.btnRetry);
        btnThoat = findViewById(R.id.btnThoat);

        // Nhận dữ liệu
        int score = getIntent().getIntExtra("CORRECT", 0);
        int total = getIntent().getIntExtra("TOTAL", 10);

        // Hiển thị kết quả
        String message = (score >= 5)
                ? "✅ Xuất sắc! Bạn đã vượt qua thử thách! 🚀"
                : "❌ Chưa đạt! Hãy thử lại và chinh phục nhé! 💪";

        tvDiemKetQua.setText("🎯 Điểm: " + score + "/" + total);
        tvThongDiep.setText(message);

        // Quay lại quiz
        btnRetry.setOnClickListener(v -> {
            Intent intent = new Intent(KetQuaActivity.this, GiaoDienQuiz.class);
            startActivity(intent);
            finish();
        });
        btnThoat.setOnClickListener(v -> {
            Intent intent = new Intent(KetQuaActivity.this, QuizActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
