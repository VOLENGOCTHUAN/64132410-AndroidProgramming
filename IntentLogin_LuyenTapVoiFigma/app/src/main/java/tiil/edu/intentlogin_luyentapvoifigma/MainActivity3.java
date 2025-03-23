package tiil.edu.intentlogin_luyentapvoifigma;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {
Button anh1,anh2,anh3,anh4;
TextView tennguoidung;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        anh1=findViewById(R.id.btn1);
        anh2=findViewById(R.id.btn2);
        anh3=findViewById(R.id.btn3);
        anh4=findViewById(R.id.btn4);
        tennguoidung = findViewById(R.id.edtUserName);

        anh1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity3.this, "KẾT QUẢ ĐÚNG", Toast.LENGTH_SHORT).show();
            }
        });
        anh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity3.this, "KẾT QUẢ SAI, VUI LÒNG CHỌN LẠI", Toast.LENGTH_SHORT).show();
            }
        });
        anh3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity3.this, "KẾT QUẢ SAI, VUI LÒNG CHỌN LẠI", Toast.LENGTH_SHORT).show();
            }
        });
        anh4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity3.this, "KẾT QUẢ SAI, VUI LÒNG CHỌN LẠI", Toast.LENGTH_SHORT).show();
            }
        });

        Intent tam1 = getIntent();
        String ten = tam1.getStringExtra("UserName");

        tennguoidung.setText(ten);
    }
}