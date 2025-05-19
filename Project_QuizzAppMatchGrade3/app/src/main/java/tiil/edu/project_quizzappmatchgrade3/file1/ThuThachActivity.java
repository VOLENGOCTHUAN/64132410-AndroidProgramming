package tiil.edu.project_quizzappmatchgrade3.file1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import java.util.ArrayList;
import java.util.Random;

import tiil.edu.project_quizzappmatchgrade3.R;

public class ThuThachActivity extends AppCompatActivity {

    TextView tvCauHoi, tvKetQua, tvThoiGian;
    EditText edtTraLoi;
    Button btnKiemTra;
    ImageView btnQuayLai;

    ArrayList<CauHoi> dsCauHoi;
    CauHoi cauHoiHienTai;

    int soCauDaLam = 0, soCauDung = 0, soCauSai = 0;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thu_thach);

        tvCauHoi = findViewById(R.id.tvCauHoi);
        tvKetQua = findViewById(R.id.tvKetQua);
        tvThoiGian = findViewById(R.id.tvThoiGian);
        edtTraLoi = findViewById(R.id.edtTraLoi);
        btnKiemTra = findViewById(R.id.btnKiemTra);
        btnQuayLai = findViewById(R.id.imgQuayLai);
        khoiTaoCauHoi();
        hienThiCauHoiMoi();

        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (countDownTimer != null) countDownTimer.cancel();
                finish(); // Quay lại activity trước đó
            }
        });
        btnKiemTra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (countDownTimer != null) countDownTimer.cancel();

                String traLoi = edtTraLoi.getText().toString().trim();
                if (traLoi.isEmpty()) {
                    Toast.makeText(ThuThachActivity.this, "Vui lòng nhập câu trả lời", Toast.LENGTH_SHORT).show();
                    demNguocThoiGian();
                    return;
                }

                int dapAn = Integer.parseInt(traLoi);
                if (dapAn == cauHoiHienTai.dapAn) {
                    tvKetQua.setText("✅ Chính xác! Giỏi lắm!");
                    soCauDung++;
                } else {
                    tvKetQua.setText("❌ Sai rồi! Đáp án đúng là: " + cauHoiHienTai.dapAn);
                    soCauSai++;
                }

                soCauDaLam++;
                btnKiemTra.setEnabled(false);
                edtTraLoi.setEnabled(false);

                tvKetQua.postDelayed(() -> hienThiCauHoiMoi(), 3000);
            }
        });
    }


    private void khoiTaoCauHoi() {
        dsCauHoi = new ArrayList<>();
        dsCauHoi.add(new CauHoi("Một cửa hàng có 48 cái bánh. Bán đi 19 cái. Hỏi còn lại bao nhiêu cái bánh?", 29));
        dsCauHoi.add(new CauHoi("Lan có 35 viên bi. Minh cho Lan thêm 12 viên nữa. Hỏi Lan có tất cả bao nhiêu viên bi?", 47));
        dsCauHoi.add(new CauHoi("Một lớp có 28 học sinh. Trong đó có 15 bạn nam. Hỏi lớp có bao nhiêu bạn nữ?", 13));
        dsCauHoi.add(new CauHoi("Một xe buýt chở 54 người. 23 người xuống xe. Hỏi còn lại bao nhiêu người trên xe?", 31));
        dsCauHoi.add(new CauHoi("Bình có 20 quyển truyện. Bình cho bạn 7 quyển. Hỏi Bình còn lại bao nhiêu quyển?", 13));
        dsCauHoi.add(new CauHoi("Một tiệm bánh làm 60 cái bánh. Bán được 34 cái. Hỏi còn lại bao nhiêu cái bánh?", 26));
        dsCauHoi.add(new CauHoi("Tú có 45 nghìn đồng. Tú mua kẹo hết 17 nghìn. Hỏi Tú còn bao nhiêu tiền?", 28));
        dsCauHoi.add(new CauHoi("Một lớp học có 40 học sinh, nghỉ 8 bạn. Hỏi có bao nhiêu bạn đi học?", 32));
        dsCauHoi.add(new CauHoi("Nam có 36 viên kẹo, chia đều cho 4 bạn. Mỗi bạn được bao nhiêu viên?", 9));
        dsCauHoi.add(new CauHoi("Một giỏ có 42 quả cam, ăn mất 15 quả. Còn lại bao nhiêu quả?", 27));
        dsCauHoi.add(new CauHoi("Mẹ mua 60 quả táo, cho hàng xóm 25 quả. Hỏi mẹ còn bao nhiêu quả táo?", 35));
        dsCauHoi.add(new CauHoi("Có 50 chiếc ghế trong phòng học. 18 chiếc bị hỏng. Hỏi còn lại bao nhiêu chiếc tốt?", 32));
        dsCauHoi.add(new CauHoi("Một cửa hàng có 70 chai nước. Bán được 42 chai. Hỏi còn lại bao nhiêu chai?", 28));
        dsCauHoi.add(new CauHoi("Hùng có 90 ngàn đồng. Mua sách hết 55 ngàn. Hỏi Hùng còn lại bao nhiêu tiền?", 35));
        dsCauHoi.add(new CauHoi("Có 100 học sinh tham gia thi. 78 học sinh đạt giải. Hỏi có bao nhiêu học sinh không đạt?", 22));
        dsCauHoi.add(new CauHoi("An có 25 bút chì. Cho bạn 9 chiếc. Hỏi An còn lại bao nhiêu chiếc bút chì?", 16));
        dsCauHoi.add(new CauHoi("Một xe tải chở 80 bao gạo. Xuống hàng 50 bao. Còn lại bao nhiêu bao gạo?", 30));
        dsCauHoi.add(new CauHoi("Bé có 30 cái kẹo. Ăn mất 10 cái. Còn lại bao nhiêu cái kẹo?", 20));
        dsCauHoi.add(new CauHoi("Cửa hàng có 100 chai sữa. Bán 65 chai. Hỏi còn lại bao nhiêu chai sữa?", 35));
        dsCauHoi.add(new CauHoi("Trong kho có 200 thùng hàng. Xuất 130 thùng. Còn lại bao nhiêu thùng?", 70));
        dsCauHoi.add(new CauHoi("Thùng có 36 quả trứng. Làm bánh hết 18 quả. Còn lại bao nhiêu quả trứng?", 18));
        dsCauHoi.add(new CauHoi("Túi có 45 viên kẹo. Phát cho 3 bạn, mỗi bạn 10 viên. Còn lại bao nhiêu viên kẹo?", 15));
        dsCauHoi.add(new CauHoi("Có 48 quyển sách, chia đều cho 6 bạn. Mỗi bạn được bao nhiêu quyển?", 8));
        dsCauHoi.add(new CauHoi("Lớp có 24 bạn. Chia thành 4 tổ. Mỗi tổ có bao nhiêu bạn?", 6));
        dsCauHoi.add(new CauHoi("Một bể cá có 70 con cá. Bán đi 30 con. Hỏi còn lại bao nhiêu con cá?", 40));
        dsCauHoi.add(new CauHoi("Lan có 60 ngàn đồng. Mua vở hết 35 ngàn. Còn lại bao nhiêu tiền?", 25));
        dsCauHoi.add(new CauHoi("Trong vườn có 90 bông hoa. Hái 24 bông. Còn lại bao nhiêu bông hoa?", 66));
        dsCauHoi.add(new CauHoi("Hùng có 100 viên bi. Cho bạn 30 viên. Hỏi còn lại bao nhiêu viên?", 70));
        dsCauHoi.add(new CauHoi("Một trang trại có 120 con gà. Bán đi 45 con. Còn lại bao nhiêu con gà?", 75));
        dsCauHoi.add(new CauHoi("Có 30 học sinh. Chia vào 5 nhóm đều nhau. Mỗi nhóm có bao nhiêu học sinh?", 6));
        dsCauHoi.add(new CauHoi("Một lớp có 36 học sinh. Trong đó có 20 bạn gái. Hỏi có bao nhiêu bạn trai?", 16));
        dsCauHoi.add(new CauHoi("Bình có 27 viên bi, chia đều cho 3 người. Mỗi người được bao nhiêu viên?", 9));
        dsCauHoi.add(new CauHoi("Một cửa hàng có 95 chiếc áo. Bán 65 chiếc. Còn lại bao nhiêu chiếc áo?", 30));
        dsCauHoi.add(new CauHoi("Có 150 quả cam. Bán 78 quả. Hỏi còn lại bao nhiêu quả cam?", 72));
        dsCauHoi.add(new CauHoi("Trong kho có 80 thùng sữa. Lấy ra 60 thùng. Còn lại bao nhiêu thùng?", 20));
        dsCauHoi.add(new CauHoi("Nam có 40 nghìn đồng. Mua bánh hết 25 nghìn. Hỏi Nam còn lại bao nhiêu?", 15));
        dsCauHoi.add(new CauHoi("Một lớp có 45 học sinh. Chia làm 5 tổ. Mỗi tổ có bao nhiêu học sinh?", 9));
        dsCauHoi.add(new CauHoi("Trong vườn có 60 cây cam. Chặt 15 cây. Hỏi còn lại bao nhiêu cây cam?", 45));
        dsCauHoi.add(new CauHoi("Hộp có 36 cây bút. Mỗi hộp chia cho 6 bạn. Mỗi bạn được mấy cây bút?", 6));
        dsCauHoi.add(new CauHoi("Có 90 cuốn vở. Chia cho 9 bạn đều nhau. Mỗi bạn được bao nhiêu cuốn?", 10));
        dsCauHoi.add(new CauHoi("Một xe tải chở 120 thùng nước. Giao 70 thùng. Còn lại bao nhiêu thùng?", 50));
        dsCauHoi.add(new CauHoi("Bé có 18 cái bánh. Ăn hết 8 cái. Còn lại bao nhiêu cái bánh?", 10));
        dsCauHoi.add(new CauHoi("Một siêu thị nhập 200 thùng sữa. Bán được 150 thùng. Còn lại bao nhiêu thùng?", 50));
        dsCauHoi.add(new CauHoi("Có 60 học sinh xếp thành 6 hàng. Mỗi hàng có bao nhiêu học sinh?", 10));
        dsCauHoi.add(new CauHoi("Một sân bóng có 100 người. 40 người ra về. Hỏi còn lại bao nhiêu người?", 60));
        dsCauHoi.add(new CauHoi("Trong thư viện có 120 quyển sách. Mượn 85 quyển. Còn lại bao nhiêu?", 35));
        dsCauHoi.add(new CauHoi("Có 63 học sinh chia đều vào 7 nhóm. Mỗi nhóm có bao nhiêu học sinh?", 9));
        dsCauHoi.add(new CauHoi("Một đội có 45 cầu thủ. Chia làm 3 nhóm. Mỗi nhóm có bao nhiêu cầu thủ?", 15));
        dsCauHoi.add(new CauHoi("Bé có 90 viên bi. Chia đều cho 5 bạn. Mỗi bạn được bao nhiêu viên?", 18));

    }

    private void hienThiCauHoiMoi() {
        if (soCauDaLam >= 10) {
            String trangThai = soCauDung >= 5 ? "🎉 BẠN ĐÃ ĐẠT!" : "😢 BẠN CHƯA ĐẠT";
            String ketQuaTong = trangThai + "\n"
                    + "✅ Đúng: " + soCauDung + "\n"
                    + "❌ Sai: " + soCauSai + "\n"
                    + "🎯 Điểm: " + soCauDung + "/10";

            tvCauHoi.setText("🎯 KẾT QUẢ CUỐI CÙNG\n" + ketQuaTong);
            tvKetQua.setText("");
            edtTraLoi.setEnabled(false);
            btnKiemTra.setEnabled(false);
            tvThoiGian.setVisibility(View.INVISIBLE);
            return;
        }

        Random random = new Random();
        int index = random.nextInt(dsCauHoi.size());
        cauHoiHienTai = dsCauHoi.get(index);
        tvCauHoi.setText("Câu hỏi: " + cauHoiHienTai.noiDung);
        edtTraLoi.setText("");
        tvKetQua.setText("");
        edtTraLoi.setEnabled(true);
        btnKiemTra.setEnabled(true);
        tvThoiGian.setVisibility(View.VISIBLE);
        demNguocThoiGian();
    }


    private void demNguocThoiGian() {
        if (countDownTimer != null) countDownTimer.cancel();

        countDownTimer = new CountDownTimer(15000, 1000) {
            public void onTick(long millisUntilFinished) {
                tvThoiGian.setText("Thời gian: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                tvThoiGian.setText("⏰ Hết giờ!");
                tvKetQua.setText("❌ Hết giờ! Đáp án đúng là: " + cauHoiHienTai.dapAn);
                soCauDaLam++;
                soCauSai++;
                btnKiemTra.setEnabled(false);
                edtTraLoi.setEnabled(false);

                tvKetQua.postDelayed(() -> hienThiCauHoiMoi(), 3000);
            }
        }.start();
    }

    class CauHoi {
        String noiDung;
        int dapAn;

        CauHoi(String noiDung, int dapAn) {
            this.noiDung = noiDung;
            this.dapAn = dapAn;
        }
    }
}