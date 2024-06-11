package fpoly.hai.assimentandroid.screen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

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

public class LogInScreen extends AppCompatActivity {
    private TextInputEditText edtUserName;
    private TextInputEditText edtPassWord;
    private Button btnLogIn;
    private Button btnLogUp;
    private CheckBox chkRemember;
    private String userLogIn = "", passLogIn = "";
    private ArrayList<User> userArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_in_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        anhXa();

        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        boolean isRemember = preferences.getBoolean("isChecked",false);
        if (isRemember){
            String user = preferences.getString("userLogIn","");
            String pass = preferences.getString("passLogIn","");
            edtUserName.setText(user);
            edtPassWord.setText(pass);
            chkRemember.setChecked(true);
        }


        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileDocVaGhiUser fileDocVaGhiUser = new FileDocVaGhiUser(LogInScreen.this);
                userArrayList = fileDocVaGhiUser.fileDoc("user.txt");
                if(userArrayList.size() > 0){
                    for (int i = 0; i < userArrayList.size(); i++){
                            userLogIn = userArrayList.get(i).getUserName();
                            passLogIn = userArrayList.get(i).getPassWord();
                            if (userLogIn.equals(edtUserName.getText().toString())
                                    && passLogIn.equals(edtPassWord.getText().toString())) {
                                if (chkRemember.isChecked()) {
                                    SharedPreferences preferences = getPreferences(MODE_PRIVATE);
                                    SharedPreferences.Editor editor = preferences.edit();
                                    editor.putString("userLogIn", userLogIn);
                                    editor.putString("passLogIn", passLogIn);
                                    editor.putBoolean("isChecked", chkRemember.isChecked());
                                    editor.apply();
                                }
                                Intent intent = new Intent(LogInScreen.this,MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                finish();
                                break;
                            } else {
                                Toast.makeText(LogInScreen.this, "Sai Tk hoac Mk", Toast.LENGTH_SHORT).show();
                                break;
                            }
                    }
                }
            }
        });

        btnLogUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogInScreen.this, LogUpScreen.class);
                startActivity(intent);
            }
        });

    }
    public void anhXa(){
        edtUserName = findViewById(R.id.edtUserName);
        edtPassWord = findViewById(R.id.edtPassWord);
        btnLogIn = findViewById(R.id.btnLogIn);
        btnLogUp = findViewById(R.id.btnDangKy);
        chkRemember = findViewById(R.id.chkRemember);
    }
}