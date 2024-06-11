package fpoly.hai.assimentandroid.screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import fpoly.hai.assimentandroid.R;
import fpoly.hai.assimentandroid.adapter.FileDocVaGhiNhanVien;
import fpoly.hai.assimentandroid.adapter.NhanVienAdapter;
import fpoly.hai.assimentandroid.models.NhanVien;

public class NhanVienScreen extends AppCompatActivity {
    private ImageView imgReturnNhanVien;
    private ImageView imgSearchNhanVien;
    private Button btnAddNhanVien;
    private ListView lv_NhanVien;
    private ArrayList<NhanVien> nhanVienArrayList = new ArrayList<>();
    private NhanVienAdapter nhanVienAdapter;
    private String ma,ten,pb;
    private FileDocVaGhiNhanVien fileDocVaGhiNhanVien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nhan_vien_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        anhXa();
        loadData(nhanVienArrayList);

        ActivityResultLauncher<Intent> launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {
                        if (o.getResultCode() == 2){
                            fileDocVaGhiNhanVien = new FileDocVaGhiNhanVien(NhanVienScreen.this);
                            nhanVienArrayList = fileDocVaGhiNhanVien.fileDoc("nhanvien.txt");
                            Intent intent = o.getData();
                            Bundle bundle = intent.getExtras();
                            ma = bundle.getString("Ma");
                            ten = bundle.getString("Ten");
                            pb = bundle.getString("PB");
                            NhanVien nhanVien = new NhanVien(ma,ten,pb);
                            if (nhanVienArrayList != null){
                                nhanVienArrayList.add(nhanVien);
                            }else{
                                nhanVienArrayList =  new ArrayList<>();
                                nhanVienArrayList.add(nhanVien);
                            }
                            fileDocVaGhiNhanVien.fileGhi(nhanVienArrayList,"nhanvien.txt");
                            nhanVienAdapter = new NhanVienAdapter(NhanVienScreen.this,nhanVienArrayList);
                            nhanVienAdapter.notifyDataSetChanged();
                            lv_NhanVien.setAdapter(nhanVienAdapter);
                        }
                    }
                }
        );

        imgReturnNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NhanVienScreen.this,MainActivity.class));
                finish();
            }
        });
        btnAddNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NhanVienScreen.this,AddNhanVienScreen.class);
                launcher.launch(intent);
            }
        });
    }
    public void anhXa(){
        imgReturnNhanVien = findViewById(R.id.imgReturnNhanVien);
        imgSearchNhanVien = findViewById(R.id.imgSearchNhanVien);
        btnAddNhanVien = findViewById(R.id.btnAddNhanVien);
        lv_NhanVien = findViewById(R.id.lv_NhanVien);
    }
    private void loadData(ArrayList<NhanVien> list){
        fileDocVaGhiNhanVien = new FileDocVaGhiNhanVien(NhanVienScreen.this);
        list = fileDocVaGhiNhanVien.fileDoc("nhanvien.txt");
        nhanVienAdapter = new NhanVienAdapter(NhanVienScreen.this,list);
        nhanVienAdapter.notifyDataSetChanged();
        lv_NhanVien.setAdapter(nhanVienAdapter);
    }
}