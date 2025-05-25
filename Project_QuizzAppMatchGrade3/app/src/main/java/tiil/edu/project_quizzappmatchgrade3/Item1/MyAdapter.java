package tiil.edu.project_quizzappmatchgrade3.Item1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tiil.edu.project_quizzappmatchgrade3.R;

import tiil.edu.project_quizzappmatchgrade3.ItemChinh.TuDoLuyenTapActivity;
import tiil.edu.project_quizzappmatchgrade3.ItemChinh.BangCuuChuongActivity;
import tiil.edu.project_quizzappmatchgrade3.ItemChinh.ThuThachActivity;
import tiil.edu.project_quizzappmatchgrade3.ItemChinh.QuizActivity; // Giả sử Q là QuizActivity

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

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        item item = items.get(position);
        if (item == null) return;

        holder.tvname.setText(item.getName());
        holder.tvchuthich.setText(item.getChuthich());
        holder.imageView.setImageResource(item.getImage());
        holder.layoutItem.setOnClickListener(v -> onClickGoToDetail(item));
    }

    private void onClickGoToDetail(item item) {
        String name = item.getName().trim();
        Intent intent;

        if (name.equals("Bài tập")) {
            intent = new Intent(context, QuizActivity.class);
        } else if (name.equals("Bảng cửu chương")) {
            intent = new Intent(context, BangCuuChuongActivity.class);
        } else if (name.equals("Thử thách")) {
            intent = new Intent(context, ThuThachActivity.class);
        }else if (name.equals("Tự do luyện tập")) {
            intent = new Intent(context, TuDoLuyenTapActivity.class);
        } else {
            intent = new Intent(context, DetailActivity.class); // fallback
        }

        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return (items != null) ? items.size() : 0;
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView tvname, tvchuthich;
        private final View layoutItem;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutItem = itemView.findViewById(R.id.layout_item);
            imageView = itemView.findViewById(R.id.imageView);
            tvname = itemView.findViewById(R.id.tvname);
            tvchuthich = itemView.findViewById(R.id.tvchuthich);
        }
    }
}
