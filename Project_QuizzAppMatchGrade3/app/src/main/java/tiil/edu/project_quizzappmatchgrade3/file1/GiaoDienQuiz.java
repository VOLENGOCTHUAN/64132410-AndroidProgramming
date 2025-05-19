package tiil.edu.project_quizzappmatchgrade3.file1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tiil.edu.project_quizzappmatchgrade3.file2.Question_Quiz;
import tiil.edu.project_quizzappmatchgrade3.R;

public class GiaoDienQuiz extends AppCompatActivity {

    TextView tvQuestion, answer1, answer2, answer3, answer4;
    TextView tvSoCauDung, tvSoCauSai, tvDiemSo,tvKetQua;
    MaterialCardView card1, card2, card3, card4;
    ImageView btnQuayLai;
    private int currentQuestionIndex = 0;
    private List<Question_Quiz> questionList;
    private int correctCount = 0;
    private int wrongCount = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giao_dien_quiz);

        tvQuestion = findViewById(R.id.questionText);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);

        tvSoCauDung = findViewById(R.id.tvSoCauDung);
        tvSoCauSai = findViewById(R.id.tvSoCauSai);
        tvDiemSo = findViewById(R.id.tvDiemSo);
        tvKetQua = findViewById(R.id.tvKetQua); // Ẩn kết quả ban đầu

        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);

        btnQuayLai = findViewById(R.id.imgQuayLai3);
        btnQuayLai.setOnClickListener(v -> finish());

        int chapter = getIntent().getIntExtra("CHAPTER", 1);

        loadQuestions(chapter);
        // Chỉ lấy 10 câu ngẫu nhiên
        Collections.shuffle(questionList);
        if (questionList.size() > 10) {
            questionList = questionList.subList(0, 10);
        }
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
                // Cộng 2 số
                questionList.add(new Question_Quiz("12 + 15 = ?", "26", "27", "28", "29", "27"));
                questionList.add(new Question_Quiz("23 + 19 = ?", "41", "42", "43", "44", "42"));
                questionList.add(new Question_Quiz("30 + 25 = ?", "55", "54", "56", "57", "55"));
                questionList.add(new Question_Quiz("45 + 33 = ?", "77", "78", "79", "76", "78"));
                questionList.add(new Question_Quiz("51 + 29 = ?", "79", "80", "81", "82", "80"));
                questionList.add(new Question_Quiz("60 + 18 = ?", "77", "78", "79", "75", "78"));
                questionList.add(new Question_Quiz("42 + 37 = ?", "78", "79", "80", "77", "79"));
                questionList.add(new Question_Quiz("28 + 44 = ?", "71", "72", "73", "74", "72"));
                questionList.add(new Question_Quiz("39 + 26 = ?", "64", "65", "66", "67", "65"));
                questionList.add(new Question_Quiz("50 + 20 = ?", "69", "70", "71", "72", "70"));
                questionList.add(new Question_Quiz("12 + 14 + 8 = ?", "33", "34", "35", "36", "34"));
                questionList.add(new Question_Quiz("25 + 18 + 12 = ?", "54", "55", "56", "57", "55"));
                questionList.add(new Question_Quiz("10 + 22 + 19 = ?", "50", "51", "52", "53", "51"));
                questionList.add(new Question_Quiz("33 + 17 + 10 = ?", "59", "60", "61", "62", "60"));
                questionList.add(new Question_Quiz("20 + 30 + 25 = ?", "74", "75", "76", "77", "75"));
                questionList.add(new Question_Quiz("40 + 15 + 12 = ?", "66", "67", "68", "69", "67"));
                questionList.add(new Question_Quiz("45 + 25 + 20 = ?", "89", "90", "91", "92", "90"));
                questionList.add(new Question_Quiz("50 + 18 + 15 = ?", "83", "84", "85", "86", "83"));
                questionList.add(new Question_Quiz("36 + 14 + 19 = ?", "68", "69", "70", "71", "69"));
                questionList.add(new Question_Quiz("27 + 33 + 22 = ?", "79", "80", "81", "82", "80"));
                questionList.add(new Question_Quiz("10 + 15 + 12 + 8 = ?", "45", "46", "47", "48", "45"));
                questionList.add(new Question_Quiz("20 + 25 + 18 + 10 = ?", "73", "74", "75", "76", "73"));
                questionList.add(new Question_Quiz("15 + 14 + 22 + 10 = ?", "59", "60", "61", "62", "61"));
                questionList.add(new Question_Quiz("18 + 30 + 15 + 22 = ?", "85", "86", "87", "88", "85"));
                questionList.add(new Question_Quiz("25 + 10 + 15 + 40 = ?", "90", "91", "92", "93", "90"));
                questionList.add(new Question_Quiz("12 + 18 + 25 + 30 = ?", "84", "85", "86", "87", "85"));
                questionList.add(new Question_Quiz("22 + 33 + 15 + 30 = ?", "100", "101", "102", "103", "100"));
                questionList.add(new Question_Quiz("27 + 14 + 18 + 22 = ?", "80", "81", "82", "83", "81"));
                questionList.add(new Question_Quiz("30 + 25 + 10 + 15 = ?", "80", "81", "82", "83", "80"));
                questionList.add(new Question_Quiz("18 + 15 + 22 + 24 = ?", "78", "79", "80", "81", "79"));
                questionList.add(new Question_Quiz("24 + 18 + 12 + 20 = ?", "72", "73", "74", "75", "74"));
                questionList.add(new Question_Quiz("33 + 10 + 25 + 22 = ?", "90", "91", "92", "93", "90"));
                questionList.add(new Question_Quiz("16 + 18 + 15 + 30 = ?", "80", "81", "82", "83", "79"));
                questionList.add(new Question_Quiz("20 + 25 + 30 + 22 = ?", "97", "98", "99", "100", "97"));
                questionList.add(new Question_Quiz("15 + 14 + 22 + 30 = ?", "81", "82", "83", "84", "81"));
                questionList.add(new Question_Quiz("10 + 20 + 15 + 30 = ?", "74", "75", "76", "77", "75"));
                questionList.add(new Question_Quiz("18 + 15 + 22 + 28 = ?", "81", "82", "83", "84", "83"));
                questionList.add(new Question_Quiz("25 + 18 + 10 + 15 = ?", "68", "69", "70", "71", "68"));
                questionList.add(new Question_Quiz("30 + 25 + 18 + 12 = ?", "85", "86", "87", "88", "85"));
                questionList.add(new Question_Quiz("20 + 15 + 30 + 24 = ?", "89", "90", "91", "92", "90"));
                questionList.add(new Question_Quiz("14 + 20 + 18 + 22 = ?", "72", "73", "74", "75", "74"));
                questionList.add(new Question_Quiz("16 + 25 + 15 + 22 = ?", "78", "79", "80", "81", "78"));
                questionList.add(new Question_Quiz("18 + 15 + 22 + 28 = ?", "81", "82", "83", "84", "82"));
                questionList.add(new Question_Quiz("25 + 18 + 10 + 15 = ?", "68", "69", "70", "71", "69"));
                questionList.add(new Question_Quiz("30 + 25 + 18 + 12 = ?", "85", "86", "87", "88", "86"));
                questionList.add(new Question_Quiz("20 + 15 + 30 + 24 = ?", "89", "90", "91", "92", "91"));
                questionList.add(new Question_Quiz("14 + 20 + 18 + 22 = ?", "72", "73", "74", "75", "73"));
                questionList.add(new Question_Quiz("16 + 25 + 15 + 22 = ?", "78", "79", "80", "81", "79"));
                questionList.add(new Question_Quiz("18 + 15 + 22 + 28 = ?", "81", "82", "83", "84", "81"));
                questionList.add(new Question_Quiz("25 + 18 + 10 + 15 = ?", "68", "69", "70", "71", "68"));
                questionList.add(new Question_Quiz("30 + 25 + 18 + 12 = ?", "85", "86", "87", "88", "85"));
                questionList.add(new Question_Quiz("20 + 15 + 30 + 24 = ?", "89", "90", "91", "92", "90"));
                questionList.add(new Question_Quiz("14 + 20 + 18 + 22 = ?", "72", "73", "74", "75", "72"));
                questionList.add(new Question_Quiz("16 + 25 + 15 + 22 = ?", "78", "79", "80", "81", "78"));
                questionList.add(new Question_Quiz("18 + 15 + 22 + 28 = ?", "81", "82", "83", "84", "82"));
                questionList.add(new Question_Quiz("25 + 18 + 10 + 15 = ?", "68", "69", "70", "71", "69"));
                questionList.add(new Question_Quiz("30 + 25 + 18 + 12 = ?", "85", "86", "87", "88", "86"));
                questionList.add(new Question_Quiz("20 + 15 + 30 + 24 = ?", "89", "90", "91", "92", "91"));
                questionList.add(new Question_Quiz("14 + 20 + 18 + 22 = ?", "72", "73", "74", "75", "73"));
                questionList.add(new Question_Quiz("16 + 25 + 15 + 22 = ?", "78", "79", "80", "81", "79"));
                questionList.add(new Question_Quiz("18 + 15 + 22 + 28 = ?", "81", "82", "83", "84", "83"));
                questionList.add(new Question_Quiz("25 + 18 + 10 + 15 = ?", "68", "69", "70", "71", "70"));
                questionList.add(new Question_Quiz("30 + 25 + 18 + 12 = ?", "85", "86", "87", "88", "87"));
                questionList.add(new Question_Quiz("15 + 17 = ?", "32", "33", "31", "34", "32"));
            questionList.add(new Question_Quiz("12 + 8 + 5 = ?", "25", "26", "24", "27", "25"));
            questionList.add(new Question_Quiz("10 + 7 + 6 = ?", "23", "22", "24", "25", "23"));
            questionList.add(new Question_Quiz("25 + 13 = ?", "38", "37", "39", "40", "38"));
            questionList.add(new Question_Quiz("34 + 26 = ?", "60", "61", "59", "62", "60"));
            questionList.add(new Question_Quiz("45 + 27 + 10 = ?", "82", "83", "81", "84", "82"));
            questionList.add(new Question_Quiz("50 + 40 = ?", "90", "80", "100", "70", "90"));
            questionList.add(new Question_Quiz("16 + 7 + 2 = ?", "25", "24", "23", "26", "25"));
            questionList.add(new Question_Quiz("18 + 5 = ?", "23", "24", "22", "25", "23"));
            questionList.add(new Question_Quiz("20 + 8 + 4 = ?", "32", "33", "31", "34", "32"));
            questionList.add(new Question_Quiz("22 + 4 = ?", "26", "27", "25", "28", "26"));
            questionList.add(new Question_Quiz("24 + 3 + 5 = ?", "32", "31", "33", "30", "32"));
            questionList.add(new Question_Quiz("26 + 6 = ?", "32", "33", "31", "34", "32"));
            questionList.add(new Question_Quiz("28 + 5 + 7 = ?", "40", "41", "39", "42", "40"));
            questionList.add(new Question_Quiz("30 + 7 = ?", "37", "36", "38", "39", "37"));
            questionList.add(new Question_Quiz("32 + 9 + 3 = ?", "44", "43", "45", "42", "44"));
            questionList.add(new Question_Quiz("34 + 5 = ?", "39", "40", "38", "37", "39"));
            questionList.add(new Question_Quiz("36 + 6 + 2 = ?", "44", "43", "45", "42", "44"));
            questionList.add(new Question_Quiz("38 + 4 = ?", "42", "41", "43", "44", "42"));
            questionList.add(new Question_Quiz("40 + 7 + 1 = ?", "48", "47", "49", "46", "48"));
            questionList.add(new Question_Quiz("42 + 8 = ?", "50", "51", "49", "52", "50"));
            questionList.add(new Question_Quiz("44 + 5 + 2 = ?", "51", "50", "52", "53", "51"));
            questionList.add(new Question_Quiz("46 + 9 = ?", "55", "54", "56", "53", "55"));
            questionList.add(new Question_Quiz("48 + 6 + 4 = ?", "58", "59", "57", "60", "58"));
            questionList.add(new Question_Quiz("50 + 8 = ?", "58", "57", "59", "60", "58"));
            questionList.add(new Question_Quiz("52 + 7 + 3 = ?", "62", "61", "63", "60", "62"));
            questionList.add(new Question_Quiz("54 + 5 = ?", "59", "60", "58", "61", "59"));
            questionList.add(new Question_Quiz("56 + 8 + 1 = ?", "65", "64", "66", "63", "65"));
            questionList.add(new Question_Quiz("58 + 6 = ?", "64", "63", "65", "66", "64"));
            questionList.add(new Question_Quiz("60 + 7 + 4 = ?", "71", "70", "72", "73", "71"));
            questionList.add(new Question_Quiz("62 + 9 = ?", "71", "70", "72", "73", "71"));
            questionList.add(new Question_Quiz("64 + 5 + 2 = ?", "71", "70", "69", "72", "71"));
            questionList.add(new Question_Quiz("66 + 8 = ?", "74", "73", "75", "72", "74"));
            questionList.add(new Question_Quiz("68 + 6 + 3 = ?", "77", "76", "78", "75", "77"));
            questionList.add(new Question_Quiz("70 + 7 = ?", "77", "76", "78", "79", "77"));
            questionList.add(new Question_Quiz("72 + 9 + 2 = ?", "83", "82", "84", "81", "83"));
            questionList.add(new Question_Quiz("74 + 5 = ?", "79", "78", "80", "81", "79"));
            questionList.add(new Question_Quiz("76 + 8 + 1 = ?", "85", "84", "83", "86", "85"));
            questionList.add(new Question_Quiz("78 + 6 = ?", "84", "83", "85", "82", "84"));
            questionList.add(new Question_Quiz("80 + 7 + 2 = ?", "89", "88", "90", "87", "89"));
            questionList.add(new Question_Quiz("82 + 9 = ?", "91", "90", "92", "93", "91"));
            questionList.add(new Question_Quiz("84 + 5 + 3 = ?", "92", "91", "90", "93", "92"));
            questionList.add(new Question_Quiz("86 + 8 = ?", "94", "93", "95", "96", "94"));
            questionList.add(new Question_Quiz("88 + 6 + 1 = ?", "95", "94", "96", "97", "95"));
            questionList.add(new Question_Quiz("90 + 7 = ?", "97", "96", "98", "99", "97"));
            questionList.add(new Question_Quiz("92 + 9 + 2 = ?", "103", "101", "102", "104", "103"));
            questionList.add(new Question_Quiz("94 + 5 = ?", "99", "98", "100", "101", "99"));
            questionList.add(new Question_Quiz("96 + 8 + 3 = ?", "107", "105", "106", "108", "107"));
            questionList.add(new Question_Quiz("98 + 6 = ?", "104", "103", "105", "106", "104"));
            questionList.add(new Question_Quiz("100 + 7 + 4 = ?", "111", "110", "112", "113", "111"));
            break;
            case 2:
                questionList.add(new Question_Quiz("50 - 17 = ?", "33", "34", "32", "35", "33"));
                questionList.add(new Question_Quiz("80 - 40 = ?", "39", "41", "40", "34", "40"));
                questionList.add(new Question_Quiz("65 - 28 = ?", "37", "38", "36", "39", "37"));
                questionList.add(new Question_Quiz("90 - 45 = ?", "44", "45", "43", "46", "45"));
                questionList.add(new Question_Quiz("72 - 24 = ?", "47", "48", "49", "50", "48"));
                questionList.add(new Question_Quiz("100 - 55 = ?", "44", "45", "55", "65", "45"));
                questionList.add(new Question_Quiz("60 - 33 = ?", "27", "28", "29", "30", "27"));
                questionList.add(new Question_Quiz("85 - 42 = ?", "42", "43", "44", "45", "43"));
                questionList.add(new Question_Quiz("110 - 65 = ?", "44", "45", "55", "46", "45"));
                questionList.add(new Question_Quiz("95 - 38 = ?", "57", "58", "59", "60", "57"));
                questionList.add(new Question_Quiz("100 - 30 - 25 = ?", "45", "46", "44", "43", "45"));
                questionList.add(new Question_Quiz("75 - 20 - 15 = ?", "40", "41", "39", "44", "40"));
                questionList.add(new Question_Quiz("60 - 10 - 25 = ?", "25", "26", "24", "23", "25"));
                questionList.add(new Question_Quiz("90 - 30 - 20 = ?", "40", "41", "42", "44", "40"));
                questionList.add(new Question_Quiz("85 - 40 - 15 = ?", "30", "31", "29", "35", "30"));
                questionList.add(new Question_Quiz("120 - 50 - 30 = ?", "40", "41", "42", "44", "40"));
                questionList.add(new Question_Quiz("130 - 45 - 35 = ?", "50", "51", "49", "55", "50"));
                questionList.add(new Question_Quiz("140 - 60 - 50 = ?", "30", "31", "29", "33", "30"));
                questionList.add(new Question_Quiz("150 - 70 - 40 = ?", "40", "41", "39", "42", "40"));
                questionList.add(new Question_Quiz("160 - 80 - 50 = ?", "30", "31", "29", "32", "30"));
                questionList.add(new Question_Quiz("100 - 20 - 15 - 10 = ?", "55", "56", "54", "57", "55"));
                questionList.add(new Question_Quiz("140 - 30 - 25 - 35 = ?", "50", "51", "49", "53", "50"));
                questionList.add(new Question_Quiz("150 - 40 - 35 - 25 = ?", "50", "51", "49", "53", "50"));
                questionList.add(new Question_Quiz("160 - 50 - 30 - 40 = ?", "40", "41", "39", "42", "40"));
                questionList.add(new Question_Quiz("180 - 60 - 50 - 30 = ?", "40", "41", "39", "42", "40"));
                questionList.add(new Question_Quiz("200 - 70 - 60 - 40 = ?", "30", "31", "29", "33", "30"));
                questionList.add(new Question_Quiz("210 - 80 - 70 - 50 = ?", "10", "11", "9", "12", "10"));
                questionList.add(new Question_Quiz("220 - 90 - 80 - 60 = ?", "-10", "-9", "-11", "-8", "-10"));
                questionList.add(new Question_Quiz("230 - 100 - 90 - 70 = ?", "-30", "-29", "-31", "-28", "-30"));
                questionList.add(new Question_Quiz("240 - 110 - 100 - 80 = ?", "-50", "-49", "-51", "-52", "-50"));
                questionList.add(new Question_Quiz("55 - 20 = ?", "35", "36", "34", "37", "35"));
                questionList.add(new Question_Quiz("75 - 30 = ?", "45", "46", "44", "47", "45"));
                questionList.add(new Question_Quiz("90 - 40 = ?", "50", "51", "49", "48", "50"));
                questionList.add(new Question_Quiz("100 - 50 = ?", "50", "51", "49", "52", "50"));
                questionList.add(new Question_Quiz("85 - 35 = ?", "50", "51", "49", "53", "50"));
                questionList.add(new Question_Quiz("120 - 60 = ?", "60", "61", "59", "58", "60"));
                questionList.add(new Question_Quiz("130 - 70 = ?", "60", "61", "59", "62", "60"));
                questionList.add(new Question_Quiz("150 - 90 = ?", "60", "61", "59", "63", "60"));
                questionList.add(new Question_Quiz("160 - 80 = ?", "80", "81", "79", "78", "80"));
                questionList.add(new Question_Quiz("170 - 90 = ?", "80", "81", "79", "77", "80"));
                questionList.add(new Question_Quiz("180 - 100 = ?", "80", "81", "79", "76", "80"));
                questionList.add(new Question_Quiz("200 - 110 = ?", "90", "91", "89", "88", "90"));
                questionList.add(new Question_Quiz("210 - 120 = ?", "90", "91", "89", "87", "90"));
                questionList.add(new Question_Quiz("220 - 130 = ?", "90", "91", "89", "86", "90"));
                questionList.add(new Question_Quiz("230 - 140 = ?", "90", "91", "89", "85", "90"));
                questionList.add(new Question_Quiz("240 - 150 = ?", "90", "91", "89", "84", "90"));
                questionList.add(new Question_Quiz("250 - 160 = ?", "90", "91", "89", "83", "90"));

                break;
            case 3:
                questionList.add(new Question_Quiz("5 × 6 = ?", "30", "35", "25", "32", "30"));
                questionList.add(new Question_Quiz("7 × 8 = ?", "56", "54", "58", "55", "56"));
                questionList.add(new Question_Quiz("9 × 4 = ?", "36", "38", "34", "37", "36"));
                questionList.add(new Question_Quiz("12 × 3 = ?", "36", "39", "33", "35", "36"));
                questionList.add(new Question_Quiz("10 × 5 = ?", "50", "55", "45", "52", "50"));
                questionList.add(new Question_Quiz("8 × 7 = ?", "56", "54", "58", "57", "56"));
                questionList.add(new Question_Quiz("6 × 9 = ?", "54", "52", "56", "53", "54"));
                questionList.add(new Question_Quiz("11 × 4 = ?", "44", "43", "45", "46", "44"));
                questionList.add(new Question_Quiz("13 × 2 = ?", "26", "28", "24", "25", "26"));
                questionList.add(new Question_Quiz("14 × 3 = ?", "42", "41", "43", "40", "42"));
                questionList.add(new Question_Quiz("2 × 3 × 4 = ?", "24", "25", "23", "26", "24"));
                questionList.add(new Question_Quiz("5 × 2 × 6 = ?", "60", "55", "65", "62", "60"));
                questionList.add(new Question_Quiz("3 × 7 × 2 = ?", "42", "41", "43", "40", "42"));
                questionList.add(new Question_Quiz("4 × 5 × 3 = ?", "60", "59", "61", "58", "60"));
                questionList.add(new Question_Quiz("6 × 2 × 7 = ?", "84", "83", "85", "80", "84"));
                questionList.add(new Question_Quiz("3 × 3 × 5 = ?", "45", "44", "46", "42", "45"));
                questionList.add(new Question_Quiz("7 × 4 × 2 = ?", "56", "55", "57", "58", "56"));
                questionList.add(new Question_Quiz("5 × 5 × 3 = ?", "75", "74", "76", "72", "75"));
                questionList.add(new Question_Quiz("2 × 6 × 7 = ?", "84", "85", "83", "81", "84"));
                questionList.add(new Question_Quiz("8 × 3 × 2 = ?", "48", "47", "49", "50", "48"));
                questionList.add(new Question_Quiz("2 × 2 × 3 × 4 = ?", "48", "47", "49", "50", "48"));
                questionList.add(new Question_Quiz("3 × 3 × 2 × 5 = ?", "90", "91", "89", "88", "90"));
                questionList.add(new Question_Quiz("4 × 2 × 2 × 6 = ?", "96", "95", "97", "93", "96"));
                questionList.add(new Question_Quiz("5 × 3 × 2 × 4 = ?", "120", "121", "119", "118", "120"));
                questionList.add(new Question_Quiz("6 × 2 × 3 × 3 = ?", "108", "107", "109", "105", "108"));
                questionList.add(new Question_Quiz("2 × 5 × 5 × 2 = ?", "100", "101", "99", "98", "100"));
                questionList.add(new Question_Quiz("3 × 4 × 2 × 5 = ?", "120", "119", "121", "122", "120"));
                questionList.add(new Question_Quiz("7 × 2 × 3 × 2 = ?", "84", "83", "85", "86", "84"));
                questionList.add(new Question_Quiz("4 × 4 × 3 × 2 = ?", "96", "95", "97", "94", "96"));
                questionList.add(new Question_Quiz("5 × 5 × 2 × 3 = ?", "150", "149", "151", "148", "150"));
                questionList.add(new Question_Quiz("6 × 7 = ?", "42", "43", "41", "40", "42"));
                questionList.add(new Question_Quiz("8 × 9 = ?", "72", "71", "73", "74", "72"));
                questionList.add(new Question_Quiz("12 × 5 = ?", "60", "62", "58", "64", "60"));
                questionList.add(new Question_Quiz("15 × 4 = ?", "60", "59", "61", "62", "60"));
                questionList.add(new Question_Quiz("9 × 6 = ?", "54", "55", "53", "52", "54"));
                questionList.add(new Question_Quiz("14 × 5 = ?", "70", "69", "71", "72", "70"));
                questionList.add(new Question_Quiz("7 × 8 = ?", "56", "55", "57", "58", "56"));
                questionList.add(new Question_Quiz("11 × 3 = ?", "33", "32", "34", "35", "33"));
                questionList.add(new Question_Quiz("13 × 4 = ?", "52", "51", "53", "54", "52"));
                questionList.add(new Question_Quiz("16 × 2 = ?", "32", "31", "33", "34", "32"));
                questionList.add(new Question_Quiz("18 × 5 = ?", "90", "89", "91", "92", "90"));
                questionList.add(new Question_Quiz("20 × 3 = ?", "60", "59", "61", "62", "60"));
                questionList.add(new Question_Quiz("10 × 7 = ?", "70", "69", "71", "72", "70"));
                questionList.add(new Question_Quiz("17 × 4 = ?", "68", "67", "69", "70", "68"));
                questionList.add(new Question_Quiz("19 × 2 = ?", "38", "37", "39", "40", "38"));
                questionList.add(new Question_Quiz("5 × 8 = ?", "40", "39", "41", "42", "40"));
                questionList.add(new Question_Quiz("6 × 9 = ?", "54", "53", "55", "56", "54"));
                questionList.add(new Question_Quiz("7 × 5 = ?", "35", "34", "36", "37", "35"));
                questionList.add(new Question_Quiz("9 × 7 = ?", "63", "62", "64", "65", "63"));
                questionList.add(new Question_Quiz("11 × 6 = ?", "66", "65", "67", "68", "66"));
                break;
            case 4:
                questionList.add(new Question_Quiz("24 ÷ 6 = ?", "4", "3", "5", "6", "4"));
                questionList.add(new Question_Quiz("36 ÷ 9 = ?", "4", "3", "5", "6", "4"));
                questionList.add(new Question_Quiz("48 ÷ 8 = ?", "6", "5", "7", "9", "6"));
                questionList.add(new Question_Quiz("56 ÷ 7 = ?", "8", "6", "7", "9", "8"));
                questionList.add(new Question_Quiz("81 ÷ 9 = ?", "9", "8", "7", "10", "9"));
                questionList.add(new Question_Quiz("42 ÷ 6 = ?", "7", "6", "8", "9", "7"));
                questionList.add(new Question_Quiz("30 ÷ 5 = ?", "6", "5", "7", "8", "6"));
                questionList.add(new Question_Quiz("27 ÷ 3 = ?", "9", "8", "10", "11", "9"));
                questionList.add(new Question_Quiz("64 ÷ 8 = ?", "8", "6", "7", "9", "8"));
                questionList.add(new Question_Quiz("90 ÷ 10 = ?", "9", "8", "10", "11", "9"));
                questionList.add(new Question_Quiz("72 ÷ 9 = ?", "8", "7", "9", "10", "8"));
                questionList.add(new Question_Quiz("54 ÷ 6 = ?", "9", "8", "7", "10", "9"));
                questionList.add(new Question_Quiz("63 ÷ 7 = ?", "9", "8", "10", "11", "9"));
                questionList.add(new Question_Quiz("60 ÷ 5 = ?", "12", "10", "11", "9", "12"));
                questionList.add(new Question_Quiz("40 ÷ 8 = ?", "5", "6", "4", "7", "5"));
                questionList.add(new Question_Quiz("35 ÷ 7 = ?", "5", "4", "6", "7", "5"));
                questionList.add(new Question_Quiz("48 ÷ 6 = ?", "8", "7", "9", "10", "8"));
                questionList.add(new Question_Quiz("20 ÷ 4 = ?", "5", "6", "4", "7", "5"));
                questionList.add(new Question_Quiz("18 ÷ 3 = ?", "6", "5", "7", "8", "6"));
                questionList.add(new Question_Quiz("96 ÷ 12 = ?", "8", "7", "9", "10", "8"));
                questionList.add(new Question_Quiz("50 ÷ 5 = ?", "10", "9", "11", "8", "10"));
                questionList.add(new Question_Quiz("64 ÷ 8 = ?", "8", "7", "9", "10", "8"));
                questionList.add(new Question_Quiz("81 ÷ 9 = ?", "9", "10", "8", "7", "9"));
                questionList.add(new Question_Quiz("72 ÷ 6 = ?", "12", "11", "13", "14", "12"));
                questionList.add(new Question_Quiz("90 ÷ 10 = ?", "9", "8", "10", "11", "9"));
                questionList.add(new Question_Quiz("36 ÷ 4 = ?", "9", "8", "10", "11", "9"));
                questionList.add(new Question_Quiz("48 ÷ 6 = ?", "8", "7", "9", "10", "8"));
                questionList.add(new Question_Quiz("54 ÷ 9 = ?", "6", "5", "7", "8", "6"));
                questionList.add(new Question_Quiz("30 ÷ 3 = ?", "10", "9", "11", "12", "10"));
                questionList.add(new Question_Quiz("28 ÷ 4 = ?", "7", "6", "8", "9", "7"));
                questionList.add(new Question_Quiz("63 ÷ 7 = ?", "9", "8", "10", "11", "9"));
                questionList.add(new Question_Quiz("40 ÷ 5 = ?", "8", "7", "9", "10", "8"));
                questionList.add(new Question_Quiz("56 ÷ 8 = ?", "7", "6", "8", "9", "7"));
                questionList.add(new Question_Quiz("35 ÷ 7 = ?", "5", "4", "6", "7", "5"));
                questionList.add(new Question_Quiz("45 ÷ 5 = ?", "9", "8", "10", "11", "9"));
                questionList.add(new Question_Quiz("27 ÷ 3 = ?", "9", "8", "10", "11", "9"));
                questionList.add(new Question_Quiz("100 ÷ 10 = ?", "10", "9", "11", "8", "10"));
                questionList.add(new Question_Quiz("20 ÷ 2 = ?", "10", "9", "11", "12", "10"));
                questionList.add(new Question_Quiz("12 ÷ 4 = ?", "3", "2", "4", "5", "3"));
                questionList.add(new Question_Quiz("18 ÷ 6 = ?", "3", "2", "4", "5", "3"));
                break;
            case 5:
                questionList.add(new Question_Quiz("Một cửa hàng có 230 cái bánh, nhập thêm 120 cái rồi lại nhập thêm 95 cái nữa. Hỏi cửa hàng có tất cả bao nhiêu cái bánh?", "445", "440", "450", "435", "445"));
                questionList.add(new Question_Quiz("Bạn Hoa đọc được 40 trang sách ngày đầu, 53 trang ngày thứ hai, và 62 trang ngày thứ ba. Hỏi bạn Hoa đã đọc bao nhiêu trang sách?", "155", "150", "160", "145", "155"));
                questionList.add(new Question_Quiz("Một vườn cây có 310 cây cam, 275 cây xoài và 200 cây bưởi. Hỏi tổng số cây trong vườn?", "785", "780", "790", "775", "785"));
                questionList.add(new Question_Quiz("Lớp 3A có 28 học sinh nữ, lớp 3B có 34 học sinh nữ và lớp 3C có 31 học sinh nữ. Hỏi tổng số học sinh nữ của 3 lớp?", "93", "90", "96", "88", "93"));
                questionList.add(new Question_Quiz("Một người có 350 quyển sách, mua thêm 127 quyển và được tặng thêm 44 quyển nữa. Hỏi người đó có bao nhiêu quyển sách?", "521", "510", "530", "500", "521"));
                questionList.add(new Question_Quiz("Một lớp học có 30 học sinh, hôm nay có 12 học sinh đến muộn, hôm qua có 8 học sinh đến muộn. Hỏi tổng số học sinh đến muộn trong 2 ngày?", "20", "18", "22", "25", "20"));
                questionList.add(new Question_Quiz("Một đội bóng đá ghi được 24 bàn thắng trong giải đầu tiên, 31 bàn trong giải thứ hai, và 28 bàn trong giải thứ ba. Hỏi tổng số bàn thắng?", "83", "80", "86", "77", "83"));
                questionList.add(new Question_Quiz("Một cửa hàng bán được 125 chiếc áo, 150 chiếc quần và 75 chiếc mũ. Hỏi tổng số mặt hàng đã bán?", "350", "340", "360", "330", "350"));
                questionList.add(new Question_Quiz("Một gia đình có 4 người, mỗi người uống 3 cốc nước mỗi ngày. Hỏi gia đình uống bao nhiêu cốc nước trong 4 ngày?", "48", "42", "54", "36", "48"));
                questionList.add(new Question_Quiz("Bạn Nam tiết kiệm 120.000 đồng trong tháng đầu, 135.000 đồng trong tháng hai và 110.000 đồng trong tháng ba. Hỏi bạn Nam tiết kiệm được bao nhiêu tiền?", "365000", "350000", "380000", "340000", "365000"));
                questionList.add(new Question_Quiz("Một kho có 600 kg gạo, bán đi 275 kg. Hỏi kho còn lại bao nhiêu kg gạo?", "325", "300", "350", "275", "325"));
                questionList.add(new Question_Quiz("Bạn Nam có 300 viên bi, cho bạn Bình 123 viên. Hỏi bạn Nam còn lại bao nhiêu viên bi?", "177", "170", "185", "160", "177"));
                questionList.add(new Question_Quiz("Một lớp học có 60 học sinh, có 22 học sinh nghỉ học. Hỏi lớp còn lại bao nhiêu học sinh?", "38", "35", "41", "32", "38"));
                questionList.add(new Question_Quiz("Bạn An có 150 viên kẹo, ăn hết 55 viên. Hỏi bạn còn lại bao nhiêu viên kẹo?", "95", "90", "100", "85", "95"));
                questionList.add(new Question_Quiz("Một vườn cây có 500 cây cam, bán đi 270 cây. Hỏi vườn còn lại bao nhiêu cây cam?", "230", "220", "240", "210", "230"));
                questionList.add(new Question_Quiz("Một cửa hàng có 420 chiếc áo, bán được 168 chiếc. Hỏi cửa hàng còn lại bao nhiêu chiếc áo?", "252", "250", "260", "240", "252"));
                questionList.add(new Question_Quiz("Một người có 350 quả bóng, cho bạn 125 quả. Hỏi người đó còn lại bao nhiêu quả bóng?", "225", "220", "230", "210", "225"));
                questionList.add(new Question_Quiz("Một lớp có 80 học sinh, có 30 học sinh nghỉ học hôm nay. Hỏi còn lại bao nhiêu học sinh?", "50", "45", "55", "40", "50"));
                questionList.add(new Question_Quiz("Một bạn có 500 viên bi, dùng 237 viên để chơi. Hỏi bạn còn lại bao nhiêu viên bi?", "263", "250", "275", "240", "263"));
                questionList.add(new Question_Quiz("Một kho có 1000 kg gạo, lấy đi 432 kg để bán. Hỏi còn lại bao nhiêu kg gạo?", "568", "550", "600", "520", "568"));
                questionList.add(new Question_Quiz("Một trường có 450 học sinh, mỗi lớp có 30 học sinh. Hỏi trường có bao nhiêu lớp?", "15", "14", "16", "13", "15"));
                questionList.add(new Question_Quiz("Một cửa hàng bán 120 quyển sách vào buổi sáng và 85 quyển vào buổi chiều. Hỏi cửa hàng bán được tổng cộng bao nhiêu quyển sách?", "205", "200", "210", "195", "205"));
                questionList.add(new Question_Quiz("Một kho hàng chứa 900 hộp sữa, mỗi ngày bán được 275 hộp. Hỏi sau 3 ngày còn lại bao nhiêu hộp sữa?", "75", "100", "50", "125", "75"));
                questionList.add(new Question_Quiz("Một vườn hoa có 320 bông hoa hồng, 240 bông hoa cúc, và 190 bông hoa mai. Hỏi tổng số bông hoa trong vườn?", "750", "740", "760", "730", "750"));
                questionList.add(new Question_Quiz("Một học sinh đọc 30 trang sách mỗi ngày, trong 15 ngày liên tiếp. Hỏi học sinh đó đọc bao nhiêu trang sách?", "450", "440", "460", "430", "450"));
                questionList.add(new Question_Quiz("Một siêu thị có 600 túi gạo, bán được 450 túi. Hỏi còn lại bao nhiêu túi gạo?", "150", "160", "140", "170", "150"));
                questionList.add(new Question_Quiz("Một thư viện có 1250 quyển sách, mua thêm 275 quyển. Hỏi thư viện có tổng cộng bao nhiêu quyển sách?", "1525", "1500", "1550", "1475", "1525"));
                questionList.add(new Question_Quiz("Một công ty sản xuất 3500 sản phẩm mỗi tháng. Hỏi trong một năm công ty đó sản xuất bao nhiêu sản phẩm?", "42000", "40000", "43000", "41000", "42000"));
                questionList.add(new Question_Quiz("Một lớp học có 18 học sinh, mỗi học sinh có 3 quyển sách giáo khoa. Hỏi lớp học có bao nhiêu quyển sách?", "54", "50", "60", "45", "54"));
                questionList.add(new Question_Quiz("Một cửa hàng bán được 270 hộp sữa trong 6 ngày. Hỏi trung bình mỗi ngày cửa hàng bán được bao nhiêu hộp sữa?", "45", "40", "50", "55", "45"));
                questionList.add(new Question_Quiz("Một khu rừng có 1200 cây, bị chặt đi 325 cây để làm gỗ. Hỏi khu rừng còn lại bao nhiêu cây?", "875", "850", "900", "825", "875"));
                questionList.add(new Question_Quiz("Một đội bóng đá đá 25 trận, mỗi trận ghi được 2 bàn thắng. Hỏi tổng số bàn thắng của đội bóng?", "50", "45", "55", "40", "50"));
                questionList.add(new Question_Quiz("Một trang trại có 250 con bò, mỗi con bò ăn 5 kg cỏ mỗi ngày. Hỏi toàn bộ trang trại tiêu thụ bao nhiêu kg cỏ mỗi ngày?", "1250", "1200", "1300", "1100", "1250"));
                questionList.add(new Question_Quiz("Một người tiết kiệm 500.000 đồng mỗi tháng. Hỏi sau một năm, người đó tiết kiệm được bao nhiêu?", "6000000", "5500000", "6500000", "5000000", "6000000"));
                questionList.add(new Question_Quiz("Một nhà máy sản xuất 800 sản phẩm mỗi tuần. Hỏi trong 10 tuần, nhà máy sản xuất bao nhiêu sản phẩm?", "8000", "7500", "8500", "9000", "8000"));
                questionList.add(new Question_Quiz("Một nhân viên làm việc 8 giờ mỗi ngày, trong 5 ngày một tuần. Hỏi nhân viên đó làm việc bao nhiêu giờ trong một tháng (4 tuần)?", "160", "150", "170", "180", "160"));
                questionList.add(new Question_Quiz("Một cửa hàng có 350 kg rau, bán 215 kg. Hỏi cửa hàng còn lại bao nhiêu kg rau?", "135", "125", "145", "115", "135"));
                questionList.add(new Question_Quiz("Một trường học có 24 lớp, mỗi lớp có 35 học sinh. Hỏi trường học có tổng cộng bao nhiêu học sinh?", "840", "800", "880", "820", "840"));
                questionList.add(new Question_Quiz("Một kho có 960 kg bột mì, chia đều vào 12 bao. Hỏi mỗi bao có bao nhiêu kg bột mì?", "80", "75", "85", "70", "80"));
                questionList.add(new Question_Quiz("Một gia đình sử dụng 25 lít nước mỗi ngày. Hỏi trong 30 ngày, gia đình đó sử dụng bao nhiêu lít nước?", "750", "700", "800", "850", "750"));
                break;
            default:
                Toast.makeText(this, "Chương không hợp lệ!", Toast.LENGTH_SHORT).show();
                finish();
        }
    }

    private void showQuestion() {
        if (currentQuestionIndex >= questionList.size()) {
            tvQuestion.setText("");
            String resultMessage = correctCount >= 5
                    ? "✅Xuất sắc! Bạn đã vượt qua thử thách! Hãy tiếp tục giữ vững phong độ và chinh phục những thử thách tiếp theo nhé! 🚀"
                    : "❌ Không sao cả! Thất bại là mẹ thành công. Hãy thử lại lần nữa, bạn chắc chắn sẽ làm tốt hơn! 💪";
            tvKetQua.setText(resultMessage);
            tvKetQua.setVisibility(View.VISIBLE);

            answer1.setVisibility(View.GONE);
            answer2.setVisibility(View.GONE);
            answer3.setVisibility(View.GONE);
            answer4.setVisibility(View.GONE);
            card1.setVisibility(View.GONE);
            card2.setVisibility(View.GONE);
            card3.setVisibility(View.GONE);
            card4.setVisibility(View.GONE);
            return;
        }

        Question_Quiz current = questionList.get(currentQuestionIndex);
        tvQuestion.setText(current.getQuestions());

        // Tạo danh sách chứa 4 đáp án và xáo trộn
        List<String> shuffledAnswers = new ArrayList<>();
        shuffledAnswers.add(current.getAnswer1());
        shuffledAnswers.add(current.getAnswer2());
        shuffledAnswers.add(current.getAnswer3());
        shuffledAnswers.add(current.getAnswer4());
        Collections.shuffle(shuffledAnswers);

        // Gán các đáp án sau khi xáo trộn vào các TextView
        answer1.setText(shuffledAnswers.get(0));
        answer2.setText(shuffledAnswers.get(1));
        answer3.setText(shuffledAnswers.get(2));
        answer4.setText(shuffledAnswers.get(3));

        // Update kết quả
        tvSoCauDung.setText("✅ Đúng: " + correctCount);
        tvSoCauSai.setText("❌ Sai: " + wrongCount);
        tvDiemSo.setText("🎯 Điểm: " + correctCount + "/" + questionList.size());
    }

    private void checkAnswer(String selectedAnswer) {
        Question_Quiz current = questionList.get(currentQuestionIndex);
        resetCardColors();

        MaterialCardView selectedCard = getCardByAnswerText(selectedAnswer);
        MaterialCardView correctCard = getCardByAnswerText(current.getCorrectAnswer());

        if (selectedAnswer.equals(current.getCorrectAnswer())) {
            correctCount++;
            selectedCard.setCardBackgroundColor(getResources().getColor(R.color.green));
            Toast.makeText(this, "Đúng rồi!", Toast.LENGTH_SHORT).show();
        } else {
            wrongCount++;
            selectedCard.setCardBackgroundColor(getResources().getColor(R.color.red));
            correctCard.setCardBackgroundColor(getResources().getColor(R.color.green));
            Toast.makeText(this, "Sai rồi! Đáp án đúng là: " + current.getCorrectAnswer(), Toast.LENGTH_SHORT).show();
        }

        tvSoCauDung.setText("✅ Đúng: " + correctCount);
        tvSoCauSai.setText("❌ Sai: " + wrongCount);
        tvDiemSo.setText("🎯 Điểm: " + correctCount + "/" + questionList.size());

        card1.postDelayed(() -> {
            currentQuestionIndex++;
            resetCardColors();
            showQuestion();
        }, 1000);
    }

    private void resetCardColors() {
        int defaultColor = getResources().getColor(R.color.white); // Màu mặc định
        card1.setCardBackgroundColor(defaultColor);
        card2.setCardBackgroundColor(defaultColor);
        card3.setCardBackgroundColor(defaultColor);
        card4.setCardBackgroundColor(defaultColor);
    }

    private MaterialCardView getCardByAnswerText(String answerText) {
        if (answer1.getText().toString().equals(answerText)) return card1;
        if (answer2.getText().toString().equals(answerText)) return card2;
        if (answer3.getText().toString().equals(answerText)) return card3;
        if (answer4.getText().toString().equals(answerText)) return card4;
        return null;
    }


    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        finish();
    }
}
