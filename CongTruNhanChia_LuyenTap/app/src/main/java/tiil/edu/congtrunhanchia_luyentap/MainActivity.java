package tiil.edu.congtrunhanchia_luyentap;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button cong,tru,nhan,chia;
    EditText Soa,Sob;
    float a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        cong = findViewById(R.id.btnCong);
        tru = findViewById(R.id.btnTru);
        nhan = findViewById(R.id.btnNhan);
        chia = findViewById(R.id.btnChia);
        Soa = findViewById(R.id.edtSoA);
        Sob = findViewById(R.id.edtSoB);

        cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Soa.getText().toString().equals("") || Sob.getText().toString().equals("")){
                    Soa.setError("Không được để trống");
                    Sob.setError("Không được để trống");
                }else{
                    a = Float.parseFloat(Soa.getText().toString());
                    b = Float.parseFloat(Sob.getText().toString());
                    c = a + b;
                    Toast.makeText(MainActivity.this, "Kết quả: " + c , Toast.LENGTH_SHORT).show();
                }
            }
        });
        tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Soa.getText().toString().equals("") || Sob.getText().toString().equals("")){
                    Soa.setError("Không được để trống");
                    Sob.setError("Không được để trống");
                }else{
                    a = Float.parseFloat(Soa.getText().toString());
                    b = Float.parseFloat(Sob.getText().toString());
                    c = a - b;
                    Toast.makeText(MainActivity.this, "Kết quả: " + c , Toast.LENGTH_SHORT).show();
                }
            }
        });
        nhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Soa.getText().toString().equals("") || Sob.getText().toString().equals("")){
                    Soa.setError("Không được để trống");
                    Sob.setError("Không được để trống");
                }else{
                    a = Float.parseFloat(Soa.getText().toString());
                    b = Float.parseFloat(Sob.getText().toString());
                    c = a * b;
                    Toast.makeText(MainActivity.this, "Kết quả: " + c , Toast.LENGTH_SHORT).show();
                }
            }
        });
        chia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Soa.getText().toString().equals("") || Sob.getText().toString().equals("")) {
                    Soa.setError("Không được để trống");
                    Sob.setError("Không được để trống");
                }
                else if(Sob.getText().toString().equals("0")){
                    Sob.setError("Không được phép chia cho 0");
                }else{
                    a = Float.parseFloat(Soa.getText().toString());
                    b = Float.parseFloat(Sob.getText().toString());
                    c = a / b;
                    Toast.makeText(MainActivity.this, "Kết quả: " + c , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}