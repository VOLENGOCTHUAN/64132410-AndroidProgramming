package tiil.edu.testbaithigk;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView tvname,tvemail;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageview);
        tvname = itemView.findViewById(R.id.tvname);
        tvemail = itemView.findViewById(R.id.tvemail);
    }

}
