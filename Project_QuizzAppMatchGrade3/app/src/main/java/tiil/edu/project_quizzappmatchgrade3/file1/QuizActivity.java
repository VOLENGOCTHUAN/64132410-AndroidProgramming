package tiil.edu.project_quizzappmatchgrade3.file1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import tiil.edu.project_quizzappmatchgrade3.R;

public class QuizActivity extends AppCompatActivity {

    MaterialCardView card1, card2, card3, cardNangCao,cardChia;
    ImageView btnQuayLai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Kết nối CardView
        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        cardChia = findViewById(R.id.cardChia);
        cardNangCao = findViewById(R.id.cardNangCao);


        // Sự kiện click cho mỗi card
        card1.setOnClickListener(v -> openChapter(1));
        card2.setOnClickListener(v -> openChapter(2));
        card3.setOnClickListener(v -> openChapter(3));
        cardChia.setOnClickListener(v -> openChapter(4));
        cardNangCao.setOnClickListener(v -> openChapter(5));
        btnQuayLai = findViewById(R.id.imgQuayLai5);
        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Quay lại activity trước đó
            }
        });
    }

    private void openChapter(int chapterNumber) {
        Intent intent = new Intent(QuizActivity.this, GiaoDienQuiz.class);
        intent.putExtra("CHAPTER", chapterNumber);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        new MaterialAlertDialogBuilder(this)
                .setTitle("Quiz App")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                    super.onBackPressed();
                    finish();
                })
                .show();
    }



}
