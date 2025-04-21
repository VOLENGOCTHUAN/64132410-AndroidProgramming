package tiil.edu.bottom_navigation_view_fragment;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Default Fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentSpace, new HomeFragment()).commit();
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                int itemId = item.getItemId();
                if (itemId == R.id.nav_home) {
                    selectedFragment = new HomeFragment();
                }
                else if (itemId == R.id.nav_ListView) {
                    selectedFragment = new Fragment_ListView();
                }
                else if (itemId == R.id.nav_RecyclerView) {
                    selectedFragment = new Fragment_RecyclerView();
                }
                else if (itemId == R.id.nav_baitap) {
                    selectedFragment = new Fragment_Baitap();
            }
                else if (itemId == R.id.nav_profile) {
                    selectedFragment = new Fragment_profile();
                }

                if(selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentSpace, selectedFragment).commit();
                }
                return true;
                }
            });
    }

}