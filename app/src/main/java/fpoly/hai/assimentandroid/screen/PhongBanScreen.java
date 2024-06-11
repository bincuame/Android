package fpoly.hai.assimentandroid.screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;

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
import fpoly.hai.assimentandroid.adapter.FileDocVaGhiPhongBan;
import fpoly.hai.assimentandroid.adapter.PhongBanAdapter;
import fpoly.hai.assimentandroid.models.PhongBan;

public class PhongBanScreen extends AppCompatActivity {
    private ImageView imgReturn;
    private SearchView searchPhongBan;
    private ImageView imgAdd;
    private ListView lv_PhongBan;
    private ArrayList<PhongBan> phongBanArrayList = new ArrayList<>();
    private PhongBanAdapter phongBanAdapter;
    private String namePhongBan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_phong_ban_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        anhXa();

        ActivityResultLauncher<Intent> launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {
                        if(o.getResultCode() == 1){
                            FileDocVaGhiPhongBan fileDocVaGhiPhongBan = new FileDocVaGhiPhongBan(PhongBanScreen.this);
                            phongBanArrayList = fileDocVaGhiPhongBan.fileDoc("phongban.txt");
                            Intent intent = o.getData();
                            Bundle bundle = intent.getExtras();
                            namePhongBan = bundle.getString("nameAddPhongBan");
                            PhongBan phongBan = new PhongBan(namePhongBan);
                            if (phongBanArrayList != null){
                                phongBanArrayList.add(phongBan);
                            }else {
                                phongBanArrayList = new ArrayList<>();
                                phongBanArrayList.add(phongBan);
                            }
                            fileDocVaGhiPhongBan.fileGhi(phongBanArrayList,"phongban.txt");
                            phongBanAdapter = new PhongBanAdapter(PhongBanScreen.this,phongBanArrayList);
                            phongBanAdapter.notifyDataSetChanged();
                            lv_PhongBan.setAdapter(phongBanAdapter);
                        }
                    }
                }
        );


        imgReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PhongBanScreen.this,MainActivity.class));
                finish();
            }
        });

        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhongBanScreen.this,AddPhongBanScreen.class);
                launcher.launch(intent);
            }
        });

        loadData(phongBanArrayList);

        searchPhongBan.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<PhongBan> listSearch = new ArrayList<>();
                FileDocVaGhiPhongBan fileDocVaGhiPhongBan = new FileDocVaGhiPhongBan(PhongBanScreen.this);
                phongBanArrayList = fileDocVaGhiPhongBan.fileDoc("phongban.txt");
                for (PhongBan phongBanArrayList : listSearch ){
                    if (phongBanArrayList.getNamePhongBan().toLowerCase().contains(newText.toLowerCase())){
                        listSearch.add(phongBanArrayList);
                        break;
                    }
                }
                loadData(listSearch);
                return false;
            }
        });
    }
    public void anhXa(){
        imgReturn = findViewById(R.id.imgReturn);
        searchPhongBan = findViewById(R.id.searchPhongBan);
        lv_PhongBan = findViewById(R.id.lv_PhongBan);
        imgAdd = findViewById(R.id.imgAdd);
    }
    private void loadData(ArrayList<PhongBan> list){
        FileDocVaGhiPhongBan fileDocVaGhiPhongBan = new FileDocVaGhiPhongBan(PhongBanScreen.this);
        list = fileDocVaGhiPhongBan.fileDoc("phongban.txt");
        phongBanAdapter =  new PhongBanAdapter(PhongBanScreen.this,list);
        phongBanAdapter.notifyDataSetChanged();
        lv_PhongBan.setAdapter(phongBanAdapter);
    }
}