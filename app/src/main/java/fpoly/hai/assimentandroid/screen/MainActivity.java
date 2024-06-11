package fpoly.hai.assimentandroid.screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import fpoly.hai.assimentandroid.R;

public class MainActivity extends AppCompatActivity {
    private LinearLayout layoutPhongBan;
    private LinearLayout layoutNhanVien;
    private LinearLayout layoutBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        anhXa();
        layoutPhongBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,PhongBanScreen.class));
            }
        });
        layoutNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,NhanVienScreen.class));
            }
        });
        layoutBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LogInScreen.class));
            }
        });

    }
    public void anhXa(){
        layoutNhanVien = findViewById(R.id.layoutNhanVien);
        layoutPhongBan = findViewById((R.id.layoutPhongBan));
        layoutBack = findViewById(R.id.layoutBack);
    }
}