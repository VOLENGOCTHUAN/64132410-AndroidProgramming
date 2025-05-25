package tiil.edu.project_quizzappmatchgrade3.ItemChinh;

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

import tiil.edu.project_quizzappmatchgrade3.Item1.Question_Quiz;
import tiil.edu.project_quizzappmatchgrade3.R;

public class TuDoLuyenTapActivity extends AppCompatActivity {

    TextView tvQuestion, answer1, answer2, answer3, answer4;
    TextView tvSoCauDung, tvSoCauSai;
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

        tvQuestion = findViewById(R.id.tvQuestion);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);

        tvSoCauDung = findViewById(R.id.tvSoCauDung);
        tvSoCauSai = findViewById(R.id.tvSoCauSai);

        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);

        btnQuayLai = findViewById(R.id.imgQuayLai3);
        btnQuayLai.setOnClickListener(v -> finish());

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
        if (chapter==1) {
            questionList.add(new Question_Quiz("15 + 17 = ?", "32", "33", "31", "30", "32"));
            questionList.add(new Question_Quiz("50 - 25 = ?", "25", "24", "26", "23", "25"));
            questionList.add(new Question_Quiz("8 x 3 = ?", "24", "23", "25", "22", "24"));
            questionList.add(new Question_Quiz("36 ÷ 6 = ?", "6", "5", "7", "8", "6"));
            questionList.add(new Question_Quiz("29 + 15 = ?", "44", "43", "45", "46", "44"));
            questionList.add(new Question_Quiz("48 - 19 = ?", "29", "28", "30", "27", "29"));
            questionList.add(new Question_Quiz("7 x 4 = ?", "28", "27", "29", "30", "28"));
            questionList.add(new Question_Quiz("56 ÷ 8 = ?", "7", "6", "8", "9", "7"));
            questionList.add(new Question_Quiz("21 + 18 = ?", "39", "38", "40", "41", "39"));
            questionList.add(new Question_Quiz("65 - 30 = ?", "35", "34", "36", "33", "35"));
            questionList.add(new Question_Quiz("9 x 5 = ?", "45", "44", "46", "43", "45"));
            questionList.add(new Question_Quiz("54 ÷ 9 = ?", "6", "5", "7", "8", "6"));
            questionList.add(new Question_Quiz("13 + 24 = ?", "37", "36", "38", "39", "37"));
            questionList.add(new Question_Quiz("42 - 17 = ?", "25", "26", "24", "23", "25"));
            questionList.add(new Question_Quiz("6 x 6 = ?", "36", "35", "37", "34", "36"));
            questionList.add(new Question_Quiz("45 ÷ 5 = ?", "9", "8", "10", "7", "9"));
            questionList.add(new Question_Quiz("28 + 19 = ?", "47", "46", "48", "45", "47"));
            questionList.add(new Question_Quiz("60 - 22 = ?", "38", "37", "39", "40", "38"));
            questionList.add(new Question_Quiz("8 x 2 = ?", "16", "15", "17", "14", "16"));
            questionList.add(new Question_Quiz("72 ÷ 9 = ?", "8", "7", "9", "10", "8"));
            questionList.add(new Question_Quiz("23 + 14 = ?", "37", "36", "38", "35", "37"));
            questionList.add(new Question_Quiz("40 - 13 = ?", "27", "28", "26", "29", "27"));
            questionList.add(new Question_Quiz("3 x 5 = ?", "15", "14", "16", "13", "15"));
            questionList.add(new Question_Quiz("36 ÷ 6 = ?", "6", "5", "7", "8", "6"));
            questionList.add(new Question_Quiz("19 + 21 = ?", "40", "41", "39", "42", "40"));
            questionList.add(new Question_Quiz("60 - 35 = ?", "25", "24", "26", "23", "25"));
            questionList.add(new Question_Quiz("4 x 4 = ?", "16", "15", "14", "17", "16"));
            questionList.add(new Question_Quiz("28 ÷ 4 = ?", "7", "6", "8", "9", "7"));
            questionList.add(new Question_Quiz("22 + 18 = ?", "40", "39", "41", "42", "40"));
            questionList.add(new Question_Quiz("55 - 22 = ?", "33", "34", "32", "31", "33"));
            questionList.add(new Question_Quiz("25 + 15 = ?", "40", "38", "39", "41", "40"));
            questionList.add(new Question_Quiz("10 x 2 = ?", "20", "22", "18", "21", "20"));
            questionList.add(new Question_Quiz("50 - 20 = ?", "30", "31", "28", "29", "30"));
            questionList.add(new Question_Quiz("16 ÷ 4 = ?", "4", "5", "6", "3", "4"));
            questionList.add(new Question_Quiz("7 + 8 = ?", "15", "16", "14", "13", "15"));
            questionList.add(new Question_Quiz("6 x 3 = ?", "18", "20", "19", "17", "18"));
            questionList.add(new Question_Quiz("13 + 18 = ?", "31", "32", "30", "33", "31"));
            questionList.add(new Question_Quiz("46 - 19 = ?", "27", "28", "29", "30", "27"));
            questionList.add(new Question_Quiz("9 x 2 = ?", "18", "17", "19", "16", "18"));
            questionList.add(new Question_Quiz("30 ÷ 5 = ?", "6", "7", "5", "4", "6"));
            questionList.add(new Question_Quiz("1 + 1 = ?", "2", "3", "4", "1", "2"));
            questionList.add(new Question_Quiz("2 + 3 = ?", "4", "5", "6", "7", "5"));
            questionList.add(new Question_Quiz("3 + 0 = ?", "2", "3", "4", "5", "3"));
            questionList.add(new Question_Quiz("0 + 4 = ?", "4", "3", "2", "1", "4"));
            questionList.add(new Question_Quiz("5 + 2 = ?", "6", "7", "8", "9", "7"));
            questionList.add(new Question_Quiz("86 - 6 = ?", "77", "78", "80", "83", "80"));
            questionList.add(new Question_Quiz("30 ÷ 3 = ?", "8", "11", "10", "13", "10"));
            questionList.add(new Question_Quiz("94 - 5 = ?", "89", "91", "86", "87", "89"));
            questionList.add(new Question_Quiz("40 ÷ 10 = ?", "6", "1", "7", "4", "4"));
            questionList.add(new Question_Quiz("47 - 23 = ?", "24", "25", "22", "26", "24"));
            questionList.add(new Question_Quiz("21 ÷ 7 = ?", "5", "6", "3", "1", "3"));
            questionList.add(new Question_Quiz("14 ÷ 7 = ?", "2", "1", "5", "4", "2"));
            questionList.add(new Question_Quiz("44 + 12 = ?", "58", "56", "55", "54", "56"));
            questionList.add(new Question_Quiz("6 ÷ 6 = ?", "4", "3", "-2", "1", "1"));
            questionList.add(new Question_Quiz("3 x 1 = ?", "3", "0", "4", "1", "3"));
            questionList.add(new Question_Quiz("33 + 25 = ?", "58", "57", "59", "56", "58"));
            questionList.add(new Question_Quiz("72 - 28 = ?", "44", "45", "43", "46", "44"));
            questionList.add(new Question_Quiz("7 x 8 = ?", "56", "55", "57", "54", "56"));
            questionList.add(new Question_Quiz("81 ÷ 9 = ?", "9", "8", "10", "7", "9"));
            questionList.add(new Question_Quiz("24 + 39 = ?", "63", "64", "62", "61", "63"));
            questionList.add(new Question_Quiz("90 - 45 = ?", "45", "44", "46", "43", "45"));
            questionList.add(new Question_Quiz("6 x 7 = ?", "42", "41", "43", "40", "42"));
            questionList.add(new Question_Quiz("48 ÷ 6 = ?", "8", "7", "9", "10", "8"));
            questionList.add(new Question_Quiz("27 + 36 = ?", "63", "64", "62", "61", "63"));
            questionList.add(new Question_Quiz("55 - 20 = ?", "35", "34", "36", "33", "35"));
            questionList.add(new Question_Quiz("8 x 5 = ?", "40", "39", "41", "38", "40"));
            questionList.add(new Question_Quiz("63 ÷ 7 = ?", "9", "8", "10", "7", "9"));
            questionList.add(new Question_Quiz("14 + 27 = ?", "41", "42", "40", "43", "41"));
            questionList.add(new Question_Quiz("80 - 33 = ?", "47", "46", "48", "45", "47"));
            questionList.add(new Question_Quiz("9 x 6 = ?", "54", "53", "55", "52", "54"));
            questionList.add(new Question_Quiz("36 ÷ 4 = ?", "9", "8", "10", "7", "9"));
            questionList.add(new Question_Quiz("19 + 29 = ?", "48", "47", "49", "46", "48"));
            questionList.add(new Question_Quiz("69 - 25 = ?", "44", "43", "45", "42", "44"));
            questionList.add(new Question_Quiz("5 x 9 = ?", "45", "44", "46", "43", "45"));
            questionList.add(new Question_Quiz("54 ÷ 6 = ?", "9", "8", "10", "7", "9"));
            questionList.add(new Question_Quiz("70 - 33 = ?", "37", "36", "38", "35", "37"));
            questionList.add(new Question_Quiz("5 x 5 = ?", "25", "24", "26", "27", "25"));
            questionList.add(new Question_Quiz("64 ÷ 8 = ?", "8", "9", "7", "6", "8"));
            questionList.add(new Question_Quiz("13 + 29 = ?", "42", "41", "43", "40", "42"));
            questionList.add(new Question_Quiz("85 - 54 = ?", "31", "32", "30", "29", "31"));
            questionList.add(new Question_Quiz("7 x 6 = ?", "42", "41", "43", "44", "42"));
            questionList.add(new Question_Quiz("56 ÷ 8 = ?", "7", "6", "8", "9", "7"));
            questionList.add(new Question_Quiz("18 + 26 = ?", "44", "43", "45", "42", "44"));
            questionList.add(new Question_Quiz("90 - 44 = ?", "46", "47", "45", "44", "46"));
            questionList.add(new Question_Quiz("66 - 22 = ?", "44", "43", "45", "46", "44"));
            questionList.add(new Question_Quiz("9 x 4 = ?", "36", "35", "34", "37", "36"));
            questionList.add(new Question_Quiz("32 ÷ 4 = ?", "8", "9", "7", "6", "8"));
            questionList.add(new Question_Quiz("20 + 14 = ?", "34", "35", "33", "36", "34"));
            questionList.add(new Question_Quiz("45 - 19 = ?", "26", "25", "27", "28", "26"));
            questionList.add(new Question_Quiz("24 + 13 = ?", "37", "36", "38", "39", "37"));
            questionList.add(new Question_Quiz("81 - 45 = ?", "36", "37", "35", "34", "36"));
            questionList.add(new Question_Quiz("7 x 3 = ?", "21", "20", "22", "23", "21"));
            questionList.add(new Question_Quiz("48 ÷ 8 = ?", "6", "5", "7", "4", "6"));
            questionList.add(new Question_Quiz("12 x 2 = ?", "24", "26", "27", "21", "24"));
            questionList.add(new Question_Quiz("70 - 35 = ?", "32", "35", "33", "37", "35"));
            questionList.add(new Question_Quiz("7 x 6 = ?", "44", "41", "42", "40", "42"));
            questionList.add(new Question_Quiz("71 - 47 = ?", "21", "23", "26", "24", "24"));
            questionList.add(new Question_Quiz("35 ÷ 5 = ?", "6", "8", "7", "4", "7"));
            questionList.add(new Question_Quiz("10 - 3 = ?", "6", "7", "8", "9", "7"));
            questionList.add(new Question_Quiz("8 - 4 = ?", "2", "3", "4", "5", "4"));
            questionList.add(new Question_Quiz("6 - 1 = ?", "4", "5", "6", "7", "5"));
            questionList.add(new Question_Quiz("7 - 7 = ?", "0", "1", "2", "3", "0"));
            questionList.add(new Question_Quiz("9 - 6 = ?", "1", "2", "3", "4", "3"));
            questionList.add(new Question_Quiz("45 + 36 = ?", "81", "82", "80", "83", "81"));
            questionList.add(new Question_Quiz("78 - 29 = ?", "49", "50", "48", "47", "49"));
            questionList.add(new Question_Quiz("9 x 4 = ?", "36", "35", "37", "38", "36"));
            questionList.add(new Question_Quiz("56 ÷ 7 = ?", "8", "7", "9", "10", "8"));
            questionList.add(new Question_Quiz("23 + 19 = ?", "42", "41", "43", "44", "42"));
            questionList.add(new Question_Quiz("84 - 37 = ?", "47", "48", "46", "45", "47"));
            questionList.add(new Question_Quiz("7 x 6 = ?", "42", "41", "43", "44", "42"));
            questionList.add(new Question_Quiz("64 ÷ 8 = ?", "8", "7", "9", "10", "8"));
            questionList.add(new Question_Quiz("32 + 28 = ?", "60", "59", "61", "62", "60"));
            questionList.add(new Question_Quiz("90 - 54 = ?", "36", "35", "37", "38", "36"));
            questionList.add(new Question_Quiz("8 x 5 = ?", "40", "39", "41", "42", "40"));
            questionList.add(new Question_Quiz("72 ÷ 9 = ?", "8", "7", "9", "10", "8"));
            questionList.add(new Question_Quiz("41 + 27 = ?", "68", "67", "69", "70", "68"));
            questionList.add(new Question_Quiz("77 - 29 = ?", "48", "47", "49", "46", "48"));
            questionList.add(new Question_Quiz("6 x 8 = ?", "48", "47", "49", "50", "48"));
            questionList.add(new Question_Quiz("54 ÷ 6 = ?", "9", "8", "10", "11", "9"));
            questionList.add(new Question_Quiz("29 + 38 = ?", "67", "66", "68", "69", "67"));
            questionList.add(new Question_Quiz("85 - 40 = ?", "45", "46", "44", "43", "45"));
            questionList.add(new Question_Quiz("5 x 7 = ?", "35", "34", "36", "33", "35"));
            questionList.add(new Question_Quiz("81 ÷ 9 = ?", "9", "8", "10", "7", "9"));
            questionList.add(new Question_Quiz("54 - 18 = ?", "36", "35", "37", "34", "36"));
            questionList.add(new Question_Quiz("9 x 3 = ?", "27", "26", "28", "29", "27"));
            questionList.add(new Question_Quiz("72 ÷ 8 = ?", "9", "8", "10", "7", "9"));
            questionList.add(new Question_Quiz("26 + 14 = ?", "40", "39", "41", "38", "40"));
            questionList.add(new Question_Quiz("91 - 56 = ?", "35", "36", "34", "33", "35"));
            questionList.add(new Question_Quiz("8 x 6 = ?", "48", "47", "49", "46", "48"));
            questionList.add(new Question_Quiz("81 ÷ 9 = ?", "9", "8", "7", "10", "9"));
            questionList.add(new Question_Quiz("38 + 12 = ?", "50", "49", "48", "51", "50"));
            questionList.add(new Question_Quiz("67 - 21 = ?", "46", "45", "47", "44", "46"));
            questionList.add(new Question_Quiz("21 + 11 = ?", "32", "33", "31", "30", "32"));
            questionList.add(new Question_Quiz("73 - 31 = ?", "42", "41", "43", "44", "42"));
            questionList.add(new Question_Quiz("8 x 3 = ?", "24", "23", "25", "22", "24"));
            questionList.add(new Question_Quiz("49 ÷ 7 = ?", "7", "8", "6", "5", "7"));
            questionList.add(new Question_Quiz("33 + 17 = ?", "50", "49", "48", "51", "50"));
            questionList.add(new Question_Quiz("65 - 25 = ?", "40", "41", "39", "42", "40"));
            questionList.add(new Question_Quiz("14 + 29 = ?", "43", "42", "44", "45", "43"));
            questionList.add(new Question_Quiz("92 - 48 = ?", "44", "43", "45", "46", "44"));
            questionList.add(new Question_Quiz("6 x 7 = ?", "42", "41", "43", "40", "42"));
            questionList.add(new Question_Quiz("56 ÷ 7 = ?", "8", "7", "6", "9", "8"));
            questionList.add(new Question_Quiz("12 ÷ 4 = ?", "2", "3", "4", "5", "3"));
            questionList.add(new Question_Quiz("15 ÷ 3 = ?", "4", "5", "6", "7", "5"));
            questionList.add(new Question_Quiz("9 ÷ 1 = ?", "7", "8", "9", "10", "9"));
            questionList.add(new Question_Quiz("6 ÷ 2 = ?", "2", "3", "4", "5", "3"));
            questionList.add(new Question_Quiz("20 ÷ 4 = ?", "3", "4", "5", "6", "5"));
            questionList.add(new Question_Quiz("9 x 7 = ?", "63", "64", "62", "65", "63"));
            questionList.add(new Question_Quiz("8 x 5 = ?", "40", "42", "41", "43", "40"));
            questionList.add(new Question_Quiz("100 - 28 = ?", "72", "70", "71", "73", "72"));
            questionList.add(new Question_Quiz("56 ÷ 7 = ?", "8", "9", "7", "6", "8"));
            questionList.add(new Question_Quiz("2 x 3 = ?", "5", "6", "7", "8", "6"));
            questionList.add(new Question_Quiz("4 x 2 = ?", "6", "7", "8", "9", "8"));
            questionList.add(new Question_Quiz("3 x 3 = ?", "6", "7", "8", "9", "9"));
            questionList.add(new Question_Quiz("5 x 1 = ?", "4", "5", "6", "7", "5"));
            questionList.add(new Question_Quiz("0 x 6 = ?", "0", "1", "2", "3", "0"));
            questionList.add(new Question_Quiz("Một cuốn vở giá 8.000đ, mua 7 cuốn thì hết bao nhiêu tiền?", "56.000", "54.000", "58.000", "60.000", "56.000"));
            questionList.add(new Question_Quiz("Một hình chữ nhật có chiều dài 10cm, chiều rộng 5cm. Diện tích là?", "50", "55", "45", "60", "50"));
            questionList.add(new Question_Quiz("Một con gà đẻ 1 quả trứng mỗi ngày. Trong 9 ngày, 4 con gà đẻ được bao nhiêu quả trứng?", "36", "35", "40", "38", "36"));
            questionList.add(new Question_Quiz("Nếu mỗi người cần 3 cái ghế, thì 6 người cần bao nhiêu cái ghế?", "18", "17", "20", "16", "18"));
            questionList.add(new Question_Quiz("Một bữa ăn hết 25.000đ. Ăn 4 bữa thì hết bao nhiêu?", "100.000", "95.000", "105.000", "90.000", "100.000"));
            questionList.add(new Question_Quiz("Một hình vuông có chu vi 32cm. Cạnh hình vuông dài bao nhiêu?", "8", "7", "6", "9", "8"));
            questionList.add(new Question_Quiz("Bạn có 3 tờ tiền 20.000đ và 2 tờ 10.000đ. Tổng tiền là?", "80.000", "70.000", "60.000", "90.000", "80.000"));
            questionList.add(new Question_Quiz("Một bao gạo nặng 25kg, 3 bao nặng bao nhiêu?", "75", "70", "80", "85", "75"));
            questionList.add(new Question_Quiz("Một cửa hàng bán 6 gói mì mỗi ngày. Trong 5 ngày bán được?", "30", "28", "32", "35", "30"));
            questionList.add(new Question_Quiz("Một người đi bộ 3km trong 1 giờ. Sau 6 giờ, người đó đi được bao xa?", "18", "16", "20", "15", "18"));
            questionList.add(new Question_Quiz("Một đoàn tàu dài 120m đi qua cây cầu dài 80m. Tổng chiều dài cần đi qua là?", "200", "190", "180", "210", "200"));
            questionList.add(new Question_Quiz("Một hình chữ nhật có chu vi 24cm, chiều dài 7cm. Chiều rộng là?", "5", "6", "4", "3", "5"));
            questionList.add(new Question_Quiz("Nếu mỗi tuần học 5 ngày, trong 4 tuần học bao nhiêu ngày?", "20", "21", "19", "18", "20"));
            questionList.add(new Question_Quiz("Một người có 120.000đ, mua 3 món giá 30.000đ mỗi món. Còn lại bao nhiêu tiền?", "30.000", "40.000", "20.000", "35.000", "30.000"));
            questionList.add(new Question_Quiz("Một chai nước rót đầy chứa 1.5 lít. Rót 3 chai thì có bao nhiêu lít?", "4.5", "4", "5", "3.5", "4.5"));
            questionList.add(new Question_Quiz("Một chiếc hộp đựng được 9 cái bánh. Cần 5 hộp để đựng bao nhiêu bánh?", "45", "40", "50", "48", "45"));
            questionList.add(new Question_Quiz("3 giờ chiều + 5 giờ = mấy giờ?", "8 giờ tối", "7 giờ tối", "6 giờ tối", "9 giờ tối", "8 giờ tối"));
            questionList.add(new Question_Quiz("Nếu 1 giờ có 60 phút, thì 3 giờ có bao nhiêu phút?", "180", "150", "160", "170", "180"));
            questionList.add(new Question_Quiz("Một lớp có 36 học sinh, 1/3 là học sinh nữ. Có bao nhiêu nữ?", "12", "14", "10", "15", "12"));
            questionList.add(new Question_Quiz("Một thùng chứa được 20 lít nước. Nếu rót 4 lần, mỗi lần 5 lít. Thùng có đầy không?", "Đúng", "Sai", "Không biết", "Thiếu dữ kiện", "Đúng"));
            questionList.add(new Question_Quiz("Tìm số còn thiếu: 6 x ? = 42", "7", "6", "8", "9", "7"));
            questionList.add(new Question_Quiz("Số lớn nhất có 2 chữ số chia hết cho 5 là?", "95", "90", "99", "85", "95"));
            questionList.add(new Question_Quiz("Nếu 1 quả bóng giá 12.000đ, bạn có 50.000đ thì mua được mấy quả?", "4", "5", "3", "6", "4"));
            questionList.add(new Question_Quiz("Số nào chia hết cho 2 và 3 trong các số sau: 12, 14, 15, 16?", "12", "14", "15", "16", "12"));
            questionList.add(new Question_Quiz("Một bó hoa có 6 cành, mỗi cành 7 bông. Tổng số bông là?", "42", "40", "44", "45", "42"));
            questionList.add(new Question_Quiz("Nếu hình vuông có diện tích 49cm² thì cạnh là?", "7", "6", "8", "9", "7"));
            questionList.add(new Question_Quiz("Tổng của 3 số lẻ liên tiếp bắt đầu từ 11 là?", "39", "33", "36", "37", "39"));
            questionList.add(new Question_Quiz("Một bánh xe quay 6 vòng, mỗi vòng 2m. Quãng đường di chuyển là?", "12", "10", "14", "11", "12"));
            questionList.add(new Question_Quiz("Tìm số chia hết cho cả 3 và 4: 12, 15, 18, 20?", "12", "15", "18", "20", "12"));
            questionList.add(new Question_Quiz("Một đồng hồ chỉ 2:15, sau 2 giờ nữa là mấy giờ?", "4:15", "5:15", "3:15", "6:15", "4:15"));
            questionList.add(new Question_Quiz("Lan có 5 quả táo, Hùng cho Lan 4 quả nữa. Hỏi Lan có tất cả bao nhiêu quả táo?", "10", "8", "9", "11", "9"));
            questionList.add(new Question_Quiz("36 + ? = 73", "36", "39", "37", "34", "37"));
            questionList.add(new Question_Quiz("42 + 4 x 3 = ?", "55", "54", "56", "53", "54"));
            questionList.add(new Question_Quiz("Nếu 5 hộp có tổng cộng 25 bút, hỏi mỗi hộp có bao nhiêu bút?", "5", "4", "6", "3", "5"));
            questionList.add(new Question_Quiz("Số nào lớn hơn: 4 x 5 hay 6 x 3?", "4 x 5", "6 x 3", "Cả hai bằng nhau", "Không xác định", "Cả hai bằng nhau"));
            questionList.add(new Question_Quiz("36 + ? = 73", "36", "39", "37", "34", "37"));
            questionList.add(new Question_Quiz("42 + 4 x 3 = ?", "55", "54", "56", "53", "54"));
            questionList.add(new Question_Quiz("Một cửa hàng bán 3 hộp sữa, mỗi hộp 12 hộp con. Tổng số hộp con là?", "36", "30", "24", "40", "36"));
            questionList.add(new Question_Quiz("Nếu 4 người chia đều 48 viên kẹo, mỗi người có bao nhiêu viên?", "12", "10", "14", "11", "12"));
            questionList.add(new Question_Quiz("Một đoạn đường dài 120m chia thành 4 phần bằng nhau. Mỗi phần dài?", "30", "40", "25", "35", "30"));
            questionList.add(new Question_Quiz("Một lớp có 28 học sinh chia làm 4 nhóm đều nhau. Mỗi nhóm có?", "7", "6", "8", "9", "7"));
            questionList.add(new Question_Quiz("Một người đi 5km mỗi ngày. Sau 7 ngày đi được bao nhiêu km?", "35", "30", "40", "45", "35"));
            questionList.add(new Question_Quiz("Nếu một cuốn sách có 120 trang và bạn đọc 15 trang mỗi ngày, bạn cần bao nhiêu ngày để đọc hết?", "8", "7", "9", "6", "8"));
            questionList.add(new Question_Quiz("Một người mua 3 cái bánh giá 12.000đ mỗi cái. Tổng cộng bao nhiêu tiền?", "36.000", "35.000", "37.000", "34.000", "36.000"));
            questionList.add(new Question_Quiz("Nếu 9 học sinh chia 45 viên kẹo đều nhau, mỗi học sinh có?", "5", "6", "4", "7", "5"));
            questionList.add(new Question_Quiz("Một cái kệ có 4 tầng, mỗi tầng 6 quyển sách. Tổng cộng bao nhiêu quyển?", "24", "25", "26", "23", "24"));
            questionList.add(new Question_Quiz("Một hình chữ nhật có chiều dài 12cm và chiều rộng 4cm. Chu vi là?", "32", "30", "28", "34", "32"));
            questionList.add(new Question_Quiz("Một hình vuông có cạnh 8cm. Diện tích là?", "64", "60", "62", "66", "64"));
            questionList.add(new Question_Quiz("Một ô tô chạy 60km/h, sau 2 giờ đi được bao nhiêu km?", "120", "110", "130", "100", "120"));
            questionList.add(new Question_Quiz("Nếu 1kg táo giá 25.000đ, mua 3kg tốn bao nhiêu tiền?", "75.000", "70.000", "80.000", "85.000", "75.000"));
            questionList.add(new Question_Quiz("Có 100 học sinh chia thành 5 lớp. Mỗi lớp có bao nhiêu học sinh?", "20", "18", "22", "25", "20"));
            questionList.add(new Question_Quiz("Một xe đạp đi được 15km/h. Trong 4 giờ đi được bao nhiêu km?", "60", "55", "65", "50", "60"));
        }
                else {
                Toast.makeText(this, "Không có câu hỏi!", Toast.LENGTH_SHORT).show();
                finish();
        }
    }

    private void showQuestion() {
        if (currentQuestionIndex >= questionList.size()) {
            tvQuestion.setText("🎉 Bạn đã luyện tập xong!\nĐúng: " + correctCount + " | Sai: " + wrongCount);
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

        // Tạo danh sách đáp án
        List<String> answers = new ArrayList<>();
        answers.add(current.getAnswer1());
        answers.add(current.getAnswer2());
        answers.add(current.getAnswer3());
        answers.add(current.getAnswer4());

        // Xáo trộn đáp án
        Collections.shuffle(answers);

        // Gán lại vào TextView
        answer1.setText(answers.get(0));
        answer2.setText(answers.get(1));
        answer3.setText(answers.get(2));
        answer4.setText(answers.get(3));
    }


    private void checkAnswer(String selectedAnswer) {
        Question_Quiz current = questionList.get(currentQuestionIndex);
        resetCardColors();

        MaterialCardView selectedCard = getCardByAnswerText(selectedAnswer);
        MaterialCardView correctCard = getCardByAnswerText(current.getCorrectAnswer());
        if (selectedAnswer.equals(current.getCorrectAnswer())) {
            correctCount++;
            selectedCard.setCardBackgroundColor(getResources().getColor(R.color.green));
            Toast.makeText(this, "✅ Đúng rồi!", Toast.LENGTH_SHORT).show();
        } else {
            wrongCount++;
            selectedCard.setCardBackgroundColor(getResources().getColor(R.color.red));
            if (correctCard != null) {
                correctCard.setCardBackgroundColor(getResources().getColor(R.color.green));
            }
            Toast.makeText(this, "❌ Sai rồi! Đáp án đúng là: " + current.getCorrectAnswer(), Toast.LENGTH_SHORT).show();
        }
        updateScoreViews();

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

    private void updateScoreViews() {
        tvSoCauDung.setText("✅ Đúng: " + correctCount);
        tvSoCauSai.setText("❌ Sai: " + wrongCount);
    }
    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        finish();
    }
}
