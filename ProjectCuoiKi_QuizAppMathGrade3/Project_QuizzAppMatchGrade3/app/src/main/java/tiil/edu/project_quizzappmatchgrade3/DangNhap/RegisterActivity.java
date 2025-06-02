package tiil.edu.project_quizzappmatchgrade3.DangNhap;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

import tiil.edu.project_quizzappmatchgrade3.R;

public class RegisterActivity extends AppCompatActivity {
    private TextInputEditText edtEmail, edtPassword;
    private MaterialButton btnRegister;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnRegister = findViewById(R.id.btnRegister);

        mAuth = FirebaseAuth.getInstance();

        //lấy thông tin nhập vào, kiểm tra hợp lệ.
        btnRegister.setOnClickListener(view -> {
            String email = edtEmail.getText().toString().trim();
            String password = edtPassword.getText().toString().trim();
            if (!isValidEmail(email)) {
                edtEmail.setError("Email không hợp lệ");
                return;
            }
            if (TextUtils.isEmpty(password) || password.length() < 6) {
                edtPassword.setError("Mật khẩu phải ≥ 6 ký tự");
                return;
            }

            //Gửi yêu cầu tạo tài khoản đến Firebase
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(this, LoginActivity.class));
                            finish();
                        } else {
                            Toast.makeText(this, "Đăng ký thất bại: "
                                    + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
        });
    }

    private boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}