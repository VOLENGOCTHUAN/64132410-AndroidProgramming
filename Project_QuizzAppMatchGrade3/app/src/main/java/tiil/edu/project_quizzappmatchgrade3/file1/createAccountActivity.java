package tiil.edu.project_quizzappmatchgrade3.file1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import tiil.edu.project_quizzappmatchgrade3.R;

public class createAccountActivity extends AppCompatActivity {

    EditText edtNewUsername, edtNewPassword, edtNewEmail;
    Button btnRegister;
    ImageView btnQuayLai;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        edtNewUsername = findViewById(R.id.edtNewUsername);
        edtNewPassword = findViewById(R.id.edtNewPassword);
        edtNewEmail = findViewById(R.id.edtNewEmail);
        btnRegister = findViewById(R.id.btnRegister);
        btnQuayLai = findViewById(R.id.imgQuayLai7);
        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Quay lại activity trước đó
            }
        });
        btnRegister.setOnClickListener(v -> {
            String username = edtNewUsername.getText().toString().trim();
            String password = edtNewPassword.getText().toString().trim();
            String email = edtNewEmail.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
                Toast.makeText(createAccountActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            } else {
                getSharedPreferences("UserPrefs", MODE_PRIVATE).edit()
                        .putString("username", username)
                        .putString("password", password)
                        .putString("email", email)
                        .apply();

                Toast.makeText(createAccountActivity.this, "Tạo tài khoản thành công!", Toast.LENGTH_SHORT).show();
                finish(); // Quay lại màn hình đăng nhập
            }
        });
    }
}
