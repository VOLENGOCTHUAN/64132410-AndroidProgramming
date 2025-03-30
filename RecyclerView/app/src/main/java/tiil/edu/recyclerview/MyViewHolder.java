package tiil.edu.recyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView tvname, tvsdt, tvemail;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        tvname = itemView.findViewById(R.id.tvname);
        tvsdt = itemView.findViewById(R.id.tvsdt);
        tvemail = itemView.findViewById(R.id.tvemail);
    }
}
