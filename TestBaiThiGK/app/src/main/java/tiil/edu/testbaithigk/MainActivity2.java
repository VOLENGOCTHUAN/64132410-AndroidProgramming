package tiil.edu.testbaithigk;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    Button tinhtoan;
    EditText so_a,so_b,ketqua;
    float a,b,c;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tinhtoan = findViewById(R.id.btnTinhToan);
        so_a = findViewById(R.id.edtA);
        so_b = findViewById(R.id.edtB);
        ketqua = findViewById(R.id.edtKQ);

        tinhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(so_a.getText().toString().equals("") || so_b.getText().toString().equals("")){
                    so_a.setError("Không được để trống");
                    so_b.setError("Không được để trống");
                }else{
                    a = Float.parseFloat(so_a.getText().toString());
                    b = Float.parseFloat(so_b.getText().toString());
                    c = a + b;
                    ketqua.setText(String.valueOf(c));
                }
            }
        });
    }
}