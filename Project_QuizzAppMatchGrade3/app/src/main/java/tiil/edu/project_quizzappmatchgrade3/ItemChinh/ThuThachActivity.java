package tiil.edu.project_quizzappmatchgrade3.ItemChinh;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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

        //Tạo một đối tượng Random để sinh số ngẫu nhiên.
        Random random = new Random();
        //Trả về một số nguyên ngẫu nhiên từ 0 đến dsCauHoi.size() - 1, tương ứng với chỉ số trong danh sách câu hỏi dsCauHoi
        int index = random.nextInt(dsCauHoi.size());
        //Lấy câu hỏi tại vị trí index và đồng thời xóa câu hỏi đó khỏi danh sách dsCauHoi
        cauHoiHienTai = dsCauHoi.remove(index);
        //Cập nhật câu hỏi lên giao diện
        tvCauHoi.setText("Câu hỏi: " + cauHoiHienTai.noiDung);
        //Xóa nội dung cũ trong EditText và đặt lại nó thành rỗng
        edtTraLoi.setText("");
        tvKetQua.setText("");
        edtTraLoi.setEnabled(true);
        btnKiemTra.setEnabled(true);
        tvThoiGian.setVisibility(View.VISIBLE);
        demNguocThoiGian();
    }


    private void demNguocThoiGian() {
        //Điều kiện nếu đang có bộ đếm thời gian chạy thì hủy nó để chuẩn bị cho bộ đếm mới
        if (countDownTimer != null) countDownTimer.cancel();
        //Tạo một bộ đếm mới với tổng thời gian là 15.000 ms (15 giây).
        countDownTimer = new CountDownTimer(15000, 1000) {
            //Mỗi giây, cập nhật TextView tvThoiGian hiển thị số giây còn lại.
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