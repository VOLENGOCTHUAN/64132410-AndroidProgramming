package tiil.edu.project_quizzappmatchgrade3.file1;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import tiil.edu.project_quizzappmatchgrade3.R;

public class AboutActivity extends AppCompatActivity {

    ImageView btnQuayLai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about);

        TextView aboutInfo = findViewById(R.id.aboutInfo);
        btnQuayLai = findViewById(R.id.imgQuayLai4);

        // Nút quay lại
        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Quay lại màn hình trước
            }
        });

        // Nội dung giới thiệu chi tiết
        String gioiThieu = "Ứng dụng: Quiz Toán Lớp 3\n"
                + "Phiên bản: 1.0\n"
                + "Phát triển bởi: Nhóm Team T\n\n"
                + "Giới thiệu:\n"
                + "Quiz Toán Lớp 3 là ứng dụng học tập giúp học sinh ôn luyện kiến thức Toán lớp 3 một cách thú vị và hiệu quả. "
                + "Ứng dụng cung cấp nhiều câu hỏi dạng trắc nghiệm được phân theo từng chủ đề như: Cộng, Trừ, Nhân, Chia, và giải toán có lời văn.\n\n"
                + "Tính năng nổi bật:\n"
                + "• Giao diện thân thiện, dễ sử dụng.\n"
                + "• Câu hỏi đa dạng, phong phú, được cập nhật thường xuyên.\n"
                + "• Theo dõi tiến độ học tập và điểm số.\n"
                + "• Phù hợp với chương trình sách giáo khoa lớp 3.\n\n"
                + "SDT liên hệ & Hỗ trợ: 0935517173\n"
                + "Email: support@teamt.com\n"
                + "Website: www.teamt.com\n";

        // Hiển thị nội dung
        aboutInfo.setText(gioiThieu);
    }
}
