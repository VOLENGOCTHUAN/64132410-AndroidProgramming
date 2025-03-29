package tiil.edu.testbaithigk;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
Button nut2,nut3,nut4;
ImageView img1;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
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

        img1 = findViewById(R.id.IMG1);
        nut2 = findViewById(R.id.btn2);
        nut3 = findViewById(R.id.btn3);
        nut4 = findViewById(R.id.btn4);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n1 = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(n1);
            }
        });
        nut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n2 = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(n2);
            }
        });
        nut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n3 = new Intent(MainActivity.this, MainActivity4.class);
                startActivity(n3);
            }
        });
        nut4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n4 = new Intent(MainActivity.this, MainActivity5.class);
                startActivity(n4);
            }
        });
    }
}