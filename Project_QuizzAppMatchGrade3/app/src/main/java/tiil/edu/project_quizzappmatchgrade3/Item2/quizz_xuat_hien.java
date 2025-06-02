package tiil.edu.project_quizzappmatchgrade3.Item2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import tiil.edu.project_quizzappmatchgrade3.DangNhap.LoginActivity;
import tiil.edu.project_quizzappmatchgrade3.R;

public class quizz_xuat_hien extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizz_xuat_hien);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(quizz_xuat_hien.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Đóng màn hình hiện tại
            }
        }, 4000); // 4000 milliseconds = 4 giây
    }
}
