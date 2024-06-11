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
import fpoly.hai.assimentandroid.adapter.FileDocVaGhiUser;
import fpoly.hai.assimentandroid.models.User;

public class LogUpScreen extends AppCompatActivity {
    private TextInputEditText edtUserName;
    private TextInputEditText edtPassWord;
    private TextInputEditText edtPassWordConfirm;
    private Button btnLogUp;
    private Button btnBack;
    private ArrayList<User> userArrayList =  new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_up_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        anhXa();

        btnLogUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileDocVaGhiUser fileDocVaGhiUser = new FileDocVaGhiUser(LogUpScreen.this);
                userArrayList = fileDocVaGhiUser.fileDoc("user.txt");
                User user = new User(edtUserName.getText().toString(),edtPassWord.getText().toString()
                        ,edtPassWordConfirm.getText().toString());
                if(userArrayList != null){
                    userArrayList.add(user);
                }else{
                    userArrayList = new ArrayList<>();
                    userArrayList.add(user);
                }
                fileDocVaGhiUser.fileGhi(userArrayList,"user.txt");
                finish();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogUpScreen.this, LogInScreen.class);
                startActivity(intent);
            }
        });
    }

    public void anhXa(){
        edtUserName = findViewById(R.id.edtUserName);
        edtPassWord = findViewById(R.id.edtPassWord);
        edtPassWordConfirm = findViewById(R.id.edtPassWordConfirm);
        btnLogUp = findViewById(R.id.btnLogUp);
        btnBack = findViewById(R.id.btnBack);
    }
}