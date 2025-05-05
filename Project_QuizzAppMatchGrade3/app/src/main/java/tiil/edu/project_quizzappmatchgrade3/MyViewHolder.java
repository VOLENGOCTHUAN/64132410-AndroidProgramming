package tiil.edu.project_quizzappmatchgrade3;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView tvname, tvchuthich;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        tvname = itemView.findViewById(R.id.tvname);
        tvchuthich = itemView.findViewById(R.id.tvchuthich);
    }
}
