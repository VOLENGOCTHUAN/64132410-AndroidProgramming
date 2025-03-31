package tiil.edu.volengocthuan_64132410_thigk_ltdt;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
Button kiemtra;
EditText day, month,year;
TextView kq;
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
        kiemtra = findViewById(R.id.btcheck);
        day = findViewById(R.id.edtNgay);
        month = findViewById(R.id.edtThang);
        year = findViewById(R.id.edtNam);
        kq = findViewById(R.id.edtKq);

        kiemtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(day.getText().toString().equals("30") && month.getText().toString().equals("4") && year.getText().toString().equals("1975")){
                    kq.setText("Đúng");
                }
                else{
                    kq.setText("Sai");
                }
            }
        });
    }
}