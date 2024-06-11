package fpoly.hai.assimentandroid.screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import fpoly.hai.assimentandroid.R;
import fpoly.hai.assimentandroid.models.AddPhongBan;

public class AddPhongBanScreen extends AppCompatActivity {
    private TextInputEditText edtNamePhongBan;
    private Button  btnAdd;
    private ArrayList<AddPhongBan> nameArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_phong_ban_sreen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        anhXa();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddPhongBanScreen.this,PhongBanScreen.class);
                Bundle bundle = new Bundle();
                bundle.putString("nameAddPhongBan",edtNamePhongBan.getText().toString());
                intent.putExtras(bundle);
                setResult(1,intent);
                finish();;
            }
        });

    }
    public void anhXa(){
        edtNamePhongBan = findViewById(R.id.edtNamePhongBan);
        btnAdd = findViewById(R.id.btnAddPhongBan);
    }
}