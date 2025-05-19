package tiil.edu.project_quizzappmatchgrade3.file1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import tiil.edu.project_quizzappmatchgrade3.R;

public class ForgotPasswordActivity extends AppCompatActivity {

    EditText edtEmailCheck;
    Button btnGetPassword;
    TextView txtPasswordResult;
    ImageView btnQuayLai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        edtEmailCheck = findViewById(R.id.edtEmailCheck);
        btnGetPassword = findViewById(R.id.btnGetPassword);
        txtPasswordResult = findViewById(R.id.txtPasswordResult);
        btnQuayLai = findViewById(R.id.imgQuayLai6);
        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Quay lại activity trước đó
            }
        });
        btnGetPassword.setOnClickListener(v -> {
            String inputEmail = edtEmailCheck.getText().toString().trim();

            SharedPreferences preferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
            String savedEmail = preferences.getString("email", "");
            String savedPassword = preferences.getString("password", "");

            if (inputEmail.equals(savedEmail)) {
                txtPasswordResult.setText("Mật khẩu của bạn là: " + savedPassword);
            } else {
                Toast.makeText(ForgotPasswordActivity.this, "Email không đúng hoặc chưa đăng ký", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
