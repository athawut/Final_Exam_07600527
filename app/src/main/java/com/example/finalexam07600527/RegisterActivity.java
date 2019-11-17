package com.example.finalexam07600527;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class RegisterActivity extends AppCompatActivity {
    private String mfullname;
    private String musername;
    private String mpassword;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText fullnameregister = findViewById(R.id.full_name_edit_text);
        final EditText usernameregister = findViewById(R.id.username_edit_text);
        final EditText passwordregister = findViewById(R.id.password_edit_text);
        Button registerbt = findViewById(R.id.register_button);



        registerbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mfullname = String.valueOf(fullnameregister.getText());
                musername = String.valueOf(usernameregister.getText());
                mpassword = String.valueOf(passwordregister.getText());
                if(mfullname.equals("")||musername.equals("")||mpassword.equals("")){
                    Toast.makeText(RegisterActivity.this, "All fields are required", Toast.LENGTH_LONG).show();
                }else{
                    AccountDAO accountDAO = new AccountDAO(getApplicationContext());
                    accountDAO.open();
                    accountDAO.add(mfullname,musername,mpassword);
                    accountDAO.close();
                    Toast.makeText(RegisterActivity.this, "Register successfully", Toast.LENGTH_LONG).show();
                    Intent login = new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(login);
                    finish();
                }
            }
        });


    }
}
