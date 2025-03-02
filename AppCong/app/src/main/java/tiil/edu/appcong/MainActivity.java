package tiil.edu.appcong;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // Khai báo giao diện
    EditText MSA, MSB, MSKQ;
    Button MSBUTTON;

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

        // Ánh xạ ID (moved outside the listener)
        MSA = findViewById(R.id.MSA);
        MSB = findViewById(R.id.MSB);
        MSKQ = findViewById(R.id.MSKQ);
        MSBUTTON = findViewById(R.id.MSBUTTON);

        // Xử lý tương tác với người dùng (moved outside the listener)
        MSBUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(MSA.getText().toString());
                int b = Integer.parseInt(MSB.getText().toString());
                int kq = a + b;
                MSKQ.setText(String.valueOf(kq));
            }
        });
    }
}