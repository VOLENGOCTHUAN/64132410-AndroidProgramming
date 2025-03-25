package tiil.edu.usingrecyderview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.zip.Inflater;


public class LandSacpeAdapter extends RecyclerView.Adapter<LandSacpeAdapter.ItemLandHolder> {

    Context context;
    ArrayList<LandScape> danhsachData;

    public LandSacpeAdapter(Context context, ArrayList<LandScape> danhsachData) {
        this.context = context;
        this.danhsachData = danhsachData;
    }

    @NonNull
    @Override
    public ItemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater cai_bom = LayoutInflater.from(context);
        View vItem = cai_bom.inflate(R.layout.item_land, parent, false);
        ItemLandHolder viewholderCreated = new ItemLandHolder(vItem);
        return viewholderCreated;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHolder holder, int position) {
        //Lay doi tuong hien thi
        LandScape landScapeHienThi = danhsachData.get(position);
        //lay du lieu
        String caption = landScapeHienThi.getLandCation();
        String tenAnh = landScapeHienThi.getLandImageFileName();
        //gan du lieu vao view
        holder.tvCaption.setText(landScapeHienThi.getLandCation());
        //Dat anh
        String package_name = holder.itemView.getContext().getPackageName();
        int imageID = holder.itemView.getResources().getIdentifier(tenAnh, "minimap", package_name);
        holder.imageViewLandscape.setImageResource(imageID);
    }

    @Override
    public int getItemCount() {
        return danhsachData.size();
    }

    class ItemLandHolder extends RecyclerView.ViewHolder {
        TextView tvCaption;
        ImageView imageViewLandscape;

        public ItemLandHolder(@NonNull View itemView) {
            super(itemView);
            tvCaption = tvCaption.findViewById(R.id.textViewCation);
            imageViewLandscape = imageViewLandscape.findViewById(R.id.imageViewLand);
        }
    }
}
