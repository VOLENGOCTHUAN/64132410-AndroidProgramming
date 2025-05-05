package tiil.edu.project_quizzappmatchgrade3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {

    @Override
    @SuppressLint({"MissingInflatedId", "LocalSuppress"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
        item item = (item) bundle.get("object_item");
        if(item == null){
            return;
        }

        TextView tvNameItem = findViewById(R.id.tv_name_item);
        tvNameItem .setText(item.getName());
    }
}