package tiil.edu.bottom_navigation_view_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Fragment_Baitap extends Fragment {
    Button cong, tru, nhan, chia;
    EditText edtsoA, edtsoB,ketqua;
    float a,b,c;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;


    public Fragment_Baitap() {

    }
    public static Fragment_Baitap newInstance(String param1, String param2) {
        Fragment_Baitap fragment = new Fragment_Baitap();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view_baitap = inflater.inflate(R.layout.fragment__baitap, container, false);
        cong = view_baitap.findViewById(R.id.btncong);
        tru = view_baitap.findViewById(R.id.btntru);
        nhan = view_baitap.findViewById(R.id.btnnhan);
        chia = view_baitap.findViewById(R.id.btnchia);
        edtsoA = view_baitap.findViewById(R.id.edtsoA);
        edtsoB = view_baitap.findViewById(R.id.edtsoB);
        ketqua = view_baitap.findViewById(R.id.editTextText4);

        cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtsoA.getText().toString().equals("") || edtsoB.getText().toString().equals("")){
                    ketqua.setText("Vui lòng nhập số");
                }else{
                    a = Float.parseFloat(edtsoA.getText().toString());
                    b = Float.parseFloat(edtsoB.getText().toString());
                    c = a + b;
                    ketqua.setText(Float.toString(c));
                }
            }
        });
        tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtsoA.getText().toString().equals("") || edtsoB.getText().toString().equals("")){
                    ketqua.setText("Vui lòng nhập số");
                }else{
                    a = Float.parseFloat(edtsoA.getText().toString());
                    b = Float.parseFloat(edtsoB.getText().toString());
                    c = a - b;
                    ketqua.setText(Float.toString(c));
                }
            }
        });
        nhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtsoA.getText().toString().equals("") || edtsoB.getText().toString().equals("")){
                    ketqua.setText("Vui lòng nhập số");
                }else{
                    a = Float.parseFloat(edtsoA.getText().toString());
                    b = Float.parseFloat(edtsoB.getText().toString());
                    c = a * b;
                    ketqua.setText(Float.toString(c));
                }
            }
        });
        chia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtsoA.getText().toString().equals("") || edtsoB.getText().toString().equals("")){
                    ketqua.setText("Vui lòng nhập số");
                } else if (edtsoB.getText().toString().equals("0")) {
                    ketqua.setText("Không thể chia cho 0");
                } else{
                    a = Float.parseFloat(edtsoA.getText().toString());
                    b = Float.parseFloat(edtsoB.getText().toString());
                    c = a / b;
                    ketqua.setText(Float.toString(c));
                }
            }
        });
        return view_baitap;

    }

}