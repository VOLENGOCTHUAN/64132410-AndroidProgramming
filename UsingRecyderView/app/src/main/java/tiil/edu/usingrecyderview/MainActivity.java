package tiil.edu.usingrecyderview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LandSacpeAdapter landSacpeAdapter;
    ArrayList<LandScape> recyclerViewData;
    RecyclerView recyclerViewLandScape;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        recyclerViewLandScape = findViewById(R.id.recyclerland);
        recyclerViewData = getDataForRecyclerView();
        landSacpeAdapter = new LandSacpeAdapter(this, recyclerViewData);
        recyclerViewLandScape.setAdapter(landSacpeAdapter);
        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(this);
        recyclerViewLandScape.setLayoutManager(layoutLinear);
        landSacpeAdapter = new LandSacpeAdapter(this,recyclerViewData);
        recyclerViewLandScape.setAdapter(landSacpeAdapter);


    }
    ArrayList<LandScape> getDataForRecyclerView(){
        ArrayList<LandScape> dsDuLieu = new ArrayList<LandScape>();
        LandScape landScape1 = new LandScape("cn mel","song o nha toi");
        dsDuLieu.add(landScape1);
        LandScape landScape2 = new LandScape("cn mel","song o nha toi");
        dsDuLieu.add(landScape2);
        LandScape landScape3 = new LandScape("cn mel","song o nha toi");
        dsDuLieu.add(landScape3);
        return dsDuLieu;
    }
}