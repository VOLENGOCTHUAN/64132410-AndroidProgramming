package tiil.edu.project_quizzappmatchgrade3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.UserViewHolder> {
    private Context context;
    private List<item> items;

    public MyAdapter(Context context, List<item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview, parent, false);
        return new UserViewHolder(view);
    }

    //Gán giá trị cho từng item
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        item item = items.get(position);
        if(item == null){
            return;
        }
        holder.tvname.setText(item.getName());
        holder.tvchuthich.setText(item.getChuthich());
        holder.imageView.setImageResource(item.getImage());
        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickGoToDetail(item);
            }
        });
    }

    //Chuyển sang trang chi tiết
    private void onClickGoToDetail(item item) {
        Intent intent;
        switch (item.getName()) {
            case "Đề kiểm tra":
                intent = new Intent(context, QuizActivity.class);
                break;
            case "Bảng cửu chương":
                intent = new Intent(context, BangCuuChuongActivity.class);
                break;
            case "Đọc sách":
                intent = new Intent(context, DocSachActivity.class);
                break;
            case "Trò chơi":
                intent = new Intent(context, TroChoiActivity.class);
                break;
            case "Thử thách":
                intent = new Intent(context, ThuThachActivity.class);
                break;
            default:
                intent = new Intent(context, DetailActivity.class); // fallback nếu chưa gán đúng
        }

        context.startActivity(intent);
    }


    @Override
    public int getItemCount() {
        if (items != null){
            return items.size();
        }
        return 0;
    }

    //Khai báo các thành phần trong item
    public class UserViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView tvname, tvchuthich;
        private View layoutItem;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutItem = itemView.findViewById(R.id.layout_item);
            imageView = itemView.findViewById(R.id.imageView);
            tvname = itemView.findViewById(R.id.tvname);
            tvchuthich = itemView.findViewById(R.id.tvchuthich);
        }
    }
}
