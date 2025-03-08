package tiil.edu.chuyendoinhietdo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edtF, edtC;
    Button btnCF, btnFC, btnclear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtC = findViewById(R.id.edtC);
        edtF = findViewById(R.id.edtF);
        btnCF = findViewById(R.id.btnCF);
        btnFC = findViewById(R.id.btnFC);
        btnclear = findViewById(R.id.btnclear);

        btnCF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (!edtC.getText().toString().isEmpty()) {
                        double C = Double.parseDouble(edtC.getText().toString());
                        double F = (C * 1.8) + 32;
                        edtF.setText(String.format("%.2f", F));
                    }
                } catch (NumberFormatException e) {
                    edtF.setText("Lỗi");
                }
            }
        });

        btnFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (!edtF.getText().toString().isEmpty()) {
                        double F = Double.parseDouble(edtF.getText().toString());
                        double C = (F - 32) / 1.8;
                        edtC.setText(String.format("%.2f", C));
                    }
                } catch (NumberFormatException e) {
                    edtC.setText("Lỗi");
                }
            }
        });

        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtC.setText("");
                edtF.setText("");
            }
        });
    }
}
