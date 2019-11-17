package com.example.finalexam07600527;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    String musername ;
    String mpassword;

    private ArrayList<Account> allaccount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        AccountDAO accountDAO = new AccountDAO(getApplicationContext());
        accountDAO.open();
        final ArrayList<Account> allaccount = accountDAO.getAllAccount();
        ArrayList<String> allusername = accountDAO.getAllUsername();
        String showusername = "USERNAME : "+allusername;
        System.out.println(showusername);
        Log.e(null,showusername);

        final EditText userinput = findViewById(R.id.username_edit_text);
        final EditText passwordinput = findViewById(R.id.password_edit_text);
        Button loginbt = findViewById(R.id.login_button);
        Button registerbt = findViewById(R.id.register_button);

        registerbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(register);
                finish();
            }
        });








        loginbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musername = String.valueOf(userinput.getText());
                mpassword = String.valueOf(passwordinput.getText());

                if(musername.equals("")||mpassword.equals("")){
                    Toast.makeText(LoginActivity.this, "All fields are required", Toast.LENGTH_LONG).show();
                }else{
                    int usernameindex = allaccount.indexOf(musername);
                    if(usernameindex==-1) {
                        Toast.makeText(LoginActivity.this, "Invalid username ", Toast.LENGTH_LONG).show();
                    }else{
                        usernameindex+=1;

                        if(mpassword.equals(allaccount.get(usernameindex))){
                            int fullnameindex = allaccount.indexOf(musername)-1;
                            Toast.makeText(LoginActivity.this, "Welcome "+fullnameindex, Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(LoginActivity.this, "Invalid password ", Toast.LENGTH_LONG).show();
                        }
                    }

                }








            }
        });
    }
}
