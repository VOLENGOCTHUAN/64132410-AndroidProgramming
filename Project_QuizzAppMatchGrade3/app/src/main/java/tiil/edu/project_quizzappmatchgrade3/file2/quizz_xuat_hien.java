package tiil.edu.project_quizzappmatchgrade3.file2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import tiil.edu.project_quizzappmatchgrade3.R;
import tiil.edu.project_quizzappmatchgrade3.file1.MainActivity;

public class quizz_xuat_hien extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizz_xuat_hien);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(quizz_xuat_hien.this, MainActivity.class));
            finish();
        }, 2000); // Delay 2 giây
    }
}
