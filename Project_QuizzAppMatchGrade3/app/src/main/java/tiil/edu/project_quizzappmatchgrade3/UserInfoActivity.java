package tiil.edu.project_quizzappmatchgrade3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UserInfoActivity extends AppCompatActivity {
    TextView  emailnguoidung;
    ImageView btnQuayLai;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_info);


        emailnguoidung = findViewById(R.id.tvEmail);
        btnQuayLai = findViewById(R.id.imgQuayLai6);
        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Quay lại activity trước đó
            }
        });

        Intent login = getIntent();
        String ten = login.getStringExtra("username");
        String email = login.getStringExtra("email");
        String pass = login.getStringExtra("password");

        emailnguoidung.setText(email);
    }
}