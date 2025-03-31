package tiil.edu.volengocthuan_64132410_thigk_ltdt;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView tvname,tvtime;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        tvname = itemView.findViewById(R.id.tvName);
        tvtime= itemView.findViewById(R.id.tvTime);
    }
}
