package tiil.edu.project_quizzappmatchgrade3.DangNhap;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import tiil.edu.project_quizzappmatchgrade3.R;
import tiil.edu.project_quizzappmatchgrade3.Item2.Man_hinh_chinh;

public class LoginActivity extends AppCompatActivity {

    private EditText email, password;
    private MaterialButton btnLogin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        email = findViewById(R.id.edtEmail);
        password = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        TextView tvRegister = findViewById(R.id.tvRegister);
        TextView tvForgotPassword = findViewById(R.id.tvForgotPassword);

        mAuth = FirebaseAuth.getInstance();

        tvRegister.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });

        tvForgotPassword.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailStr = email.getText().toString().trim();
                String passwordStr = password.getText().toString().trim();

                //Kiểm tra người dùng có nhập đầy đủ hay chưa
                if (emailStr.isEmpty() || passwordStr.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Vui lòng điền đủ thông tin",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                // Kiểm tra hợp lệ
                if (!isValidEmail(emailStr)) {
                    email.setError("Email không hợp lệ");
                    email.requestFocus();
                    return;
                    }
                // Kiểm tra định dạng email và độ dài mật khẩu.
                if (TextUtils.isEmpty(passwordStr) || passwordStr.length() < 6) {
                    password.setError("Mật khẩu phải có ít nhất 6 ký tự");
                    password.requestFocus();
                    return;
                }

                // Gửi yêu cầu đăng nhập đến Firebase Authentication
                mAuth.signInWithEmailAndPassword(emailStr, passwordStr)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent intent = new Intent(LoginActivity.this, Man_hinh_chinh.class);
                                intent.putExtra("email", user.getEmail());
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(LoginActivity.this, "Đăng nhập thất bại: "
                                        + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            };
            // Hàm kiểm tra định dạng email
            private boolean isValidEmail(String email) {
                return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
            }
        });
    }
}
