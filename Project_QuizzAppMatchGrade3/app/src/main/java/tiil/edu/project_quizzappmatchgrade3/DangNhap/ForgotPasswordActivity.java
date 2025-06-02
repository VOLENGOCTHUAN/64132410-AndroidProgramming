package tiil.edu.project_quizzappmatchgrade3.DangNhap;

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

public class ForgotPasswordActivity extends AppCompatActivity {
    private TextInputEditText edtEmail;
    private MaterialButton btnResetPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forgot_password);
        edtEmail = findViewById(R.id.edtEmail);
        btnResetPassword = findViewById(R.id.btnResetPassword);

        mAuth = FirebaseAuth.getInstance();
        //Gửi yêu cầu khôi phục mật khẩu đến Firebase.
        btnResetPassword.setOnClickListener(view -> {
            String email = edtEmail.getText().toString().trim();
            if (!isValidEmail(email)) {
                edtEmail.setError("Email không hợp lệ");
                return;
            }
            mAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(this, "Email khôi phục đã được gửi!", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(this, "Lỗi: "
                                    + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }

    private boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
