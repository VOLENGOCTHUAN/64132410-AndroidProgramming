package tiil.edu.project_quizzappmatchgrade3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GiaoDienQuiz extends AppCompatActivity {

    TextView tvQuestion, answer1, answer2, answer3, answer4;
    MaterialCardView card1, card2, card3, card4;

    private int currentQuestionIndex = 0;
    private List<Question_Quiz> questionList;
    private int correctCount = 0;
    private int wrongCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giao_dien_quiz);

        tvQuestion = findViewById(R.id.questionText);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);

        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);

        int chapter = getIntent().getIntExtra("CHAPTER", 1);

        loadQuestions(chapter);
        Collections.shuffle(questionList);
        showQuestion();

        card1.setOnClickListener(v -> checkAnswer(answer1.getText().toString()));
        card2.setOnClickListener(v -> checkAnswer(answer2.getText().toString()));
        card3.setOnClickListener(v -> checkAnswer(answer3.getText().toString()));
        card4.setOnClickListener(v -> checkAnswer(answer4.getText().toString()));
    }

    private void loadQuestions(int chapter) {
        questionList = new ArrayList<>();
        switch (chapter) {
            case 1:
                questionList.add(new Question_Quiz("1 + 1 = ?", "2", "3", "4", "1", "2"));
                questionList.add(new Question_Quiz("2 + 3 = ?", "4", "5", "6", "7", "5"));
                questionList.add(new Question_Quiz("3 + 0 = ?", "2", "3", "4", "5", "3"));
                questionList.add(new Question_Quiz("0 + 4 = ?", "4", "3", "2", "1", "4"));
                questionList.add(new Question_Quiz("5 + 2 = ?", "6", "7", "8", "9", "7"));
                break;
            case 2:
                questionList.add(new Question_Quiz("10 - 3 = ?", "6", "7", "8", "9", "7"));
                questionList.add(new Question_Quiz("8 - 4 = ?", "2", "3", "4", "5", "4"));
                questionList.add(new Question_Quiz("6 - 1 = ?", "4", "5", "6", "7", "5"));
                questionList.add(new Question_Quiz("7 - 7 = ?", "0", "1", "2", "3", "0"));
                questionList.add(new Question_Quiz("9 - 6 = ?", "1", "2", "3", "4", "3"));
                break;
            case 3:
                questionList.add(new Question_Quiz("2 x 3 = ?", "5", "6", "7", "8", "6"));
                questionList.add(new Question_Quiz("4 x 2 = ?", "6", "7", "8", "9", "8"));
                questionList.add(new Question_Quiz("3 x 3 = ?", "6", "7", "8", "9", "9"));
                questionList.add(new Question_Quiz("5 x 1 = ?", "4", "5", "6", "7", "5"));
                questionList.add(new Question_Quiz("0 x 6 = ?", "0", "1", "2", "3", "0"));
                break;
            case 4:
                questionList.add(new Question_Quiz("12 ÷ 4 = ?", "2", "3", "4", "5", "3"));
                questionList.add(new Question_Quiz("15 ÷ 3 = ?", "4", "5", "6", "7", "5"));
                questionList.add(new Question_Quiz("9 ÷ 1 = ?", "7", "8", "9", "10", "9"));
                questionList.add(new Question_Quiz("6 ÷ 2 = ?", "2", "3", "4", "5", "3"));
                questionList.add(new Question_Quiz("20 ÷ 4 = ?", "3", "4", "5", "6", "5"));
                break;
            default:
                Toast.makeText(this, "Chương không hợp lệ!", Toast.LENGTH_SHORT).show();
                finish();
        }
    }

    private void showQuestion() {
        if (currentQuestionIndex >= questionList.size()) {
            showResultDialog();
            return;
        }

        Question_Quiz current = questionList.get(currentQuestionIndex);
        tvQuestion.setText(current.getQuestions());
        answer1.setText(current.getAnswer1());
        answer2.setText(current.getAnswer2());
        answer3.setText(current.getAnswer3());
        answer4.setText(current.getAnswer4());
    }

    private void checkAnswer(String selectedAnswer) {
        Question_Quiz current = questionList.get(currentQuestionIndex);
        if (selectedAnswer.equals(current.getCorrectAnswer())) {
            correctCount++;
            Toast.makeText(this, "Đúng rồi!", Toast.LENGTH_SHORT).show();
        } else {
            wrongCount++;
            Toast.makeText(this, "Sai rồi! Đáp án đúng là: " + current.getCorrectAnswer(), Toast.LENGTH_SHORT).show();
        }
        currentQuestionIndex++;
        showQuestion();
    }

    private void showResultDialog() {
        new MaterialAlertDialogBuilder(this)
                .setTitle("Kết quả của bạn")
                .setMessage("Số câu đúng: " + correctCount + "\nSố câu sai: " + wrongCount)
                .setPositiveButton("Thoát", (dialog, which) -> finish())
                .show();
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        new MaterialAlertDialogBuilder(this)
                .setTitle("Quiz App")
                .setMessage("Bạn có chắc muốn thoát không?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, (dialog, which) -> finish())
                .show();
    }
}
