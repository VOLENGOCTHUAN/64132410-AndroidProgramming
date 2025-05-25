package tiil.edu.project_quizzappmatchgrade3.DangNhap;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import tiil.edu.project_quizzappmatchgrade3.R;
import tiil.edu.project_quizzappmatchgrade3.Item2.Man_hinh_chinh;

public class LoginActivity extends AppCompatActivity {

    Button xacnhan;
    EditText password, username, email;
    TextView forgotPassword, createAccount;

    @SuppressLint({"MissingInflatedId", "MissingSuperCall"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login_activity);

        xacnhan = findViewById(R.id.btnLogin);
        password = findViewById(R.id.edtPassword);
        username = findViewById(R.id.edtUserName);
        email = findViewById(R.id.edtEmail);

        xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("admin")
                        && password.getText().toString().equals("123")
                        && email.getText().toString().equals("admin@gmail.com")) {
                    Intent in = new Intent(LoginActivity.this, Man_hinh_chinh.class);
                    in.putExtra("username", "admin");
                    in.putExtra("password", "123");
                    in.putExtra("email", "admin@gmail.com");
                    startActivity(in);
                } else {
                    username.setError("Sai tên đăng nhập");
                    password.setError("Sai mật khẩu");
                    email.setError("Sai email");
                    Toast.makeText(LoginActivity.this, "Sai tên đăng nhập," +
                            " mật khẩu hoac email", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
