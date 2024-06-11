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

import java.io.LineNumberReader;

import fpoly.hai.assimentandroid.R;

public class AddNhanVienScreen extends AppCompatActivity {
    private TextInputEditText edtMaNhanVien;
    private TextInputEditText edtNameNhanVien;
    private TextInputEditText edtNamePhongBan;
    private Button btnThemNhanVien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_nhan_vien_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        anhXa();

        btnThemNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddNhanVienScreen.this,NhanVienScreen.class);
                Bundle bundle = new Bundle();
                bundle.putString("Ma",edtMaNhanVien.getText().toString());
                bundle.putString("Ten",edtNameNhanVien.getText().toString());
                bundle.putString("PB",edtNamePhongBan.getText().toString());
                intent.putExtras(bundle);
                setResult(2,intent);
                finish();
            }
        });

    }
    public void anhXa(){
        edtMaNhanVien = findViewById(R.id.edtMaNhanVien);
        edtNameNhanVien = findViewById(R.id.edtNameNhanVien);
        edtNamePhongBan = findViewById(R.id.edtNamePhongBan);
        btnThemNhanVien = findViewById(R.id.btnThemNhanVien);
    }
}