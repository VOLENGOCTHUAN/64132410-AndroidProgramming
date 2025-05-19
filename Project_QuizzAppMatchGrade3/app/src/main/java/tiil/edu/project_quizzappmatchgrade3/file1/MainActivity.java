package tiil.edu.project_quizzappmatchgrade3.file1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import tiil.edu.project_quizzappmatchgrade3.R;

public class MainActivity extends AppCompatActivity {
    Button xacnhan;
    EditText password, username, email;
    TextView forgotPassword, createAccount;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        xacnhan = findViewById(R.id.btnLogin);
        password = findViewById(R.id.edtPassword);
        username = findViewById(R.id.edtUserName);
        email = findViewById(R.id.edtEmail);

        forgotPassword = findViewById(R.id.tvForgotPassword);
        createAccount = findViewById(R.id.tvCreateAccount);

        forgotPassword.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ForgotPasswordActivity.class);
            startActivity(intent);
        });

        createAccount.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, createAccountActivity.class);
            startActivity(intent);
        });

        xacnhan.setOnClickListener(v -> {
            String inputUsername = username.getText().toString().trim();
            String inputPassword = password.getText().toString().trim();
            String inputEmail = email.getText().toString().trim();

            SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
            String savedUsername = prefs.getString("username", "");
            String savedPassword = prefs.getString("password", "");
            String savedEmail = prefs.getString("email", "");

            if (inputUsername.equals(savedUsername) &&
                    inputPassword.equals(savedPassword) &&
                    inputEmail.equals(savedEmail)) {

                Toast.makeText(MainActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();

                Intent in = new Intent(MainActivity.this, LoginActivity.class);
                in.putExtra("username", inputUsername);
                in.putExtra("password", inputPassword);
                in.putExtra("email", inputEmail);
                startActivity(in);
                finish();

            } else {
                Toast.makeText(MainActivity.this, "Sai tên đăng nhập, mật khẩu hoặc email", Toast.LENGTH_SHORT).show();
                if (!inputUsername.equals(savedUsername)) {
                    username.setError("Sai tên đăng nhập");
                }
                if (!inputPassword.equals(savedPassword)) {
                    password.setError("Sai mật khẩu");
                }
                if (!inputEmail.equals(savedEmail)) {
                    email.setError("Sai email");
                }
            }
        });
    }
}
