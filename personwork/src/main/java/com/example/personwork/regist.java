package com.example.personwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.personwork.pojo.User;
import com.example.personwork.utils.UserDB;

import java.sql.SQLException;

public class regist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        Button re_register = findViewById(R.id.re_register);

        re_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username = findViewById(R.id.re_username);
                EditText password = findViewById(R.id.re_password);
                EditText passwordAffirm = findViewById(R.id.re_affirm);
                String inputUsername = username.getText().toString();
                String inputPassword = password.getText().toString();
                String inputAffirm = passwordAffirm.getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        User user = new User();
                        //存储账号密码
                        user.setUsername(inputUsername);
                        user.setPassword(inputPassword);
                        if (inputAffirm.equals(inputPassword)) {
                            try {
                                UserDB.insertData(user);
                                Log.v("dzh","ok");
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                            //传回账号（新）
                            Intent intent = new Intent(regist.this,Login.class);
                            intent.putExtra("username", inputUsername);
                            setResult(RESULT_OK, intent);
                            finish();
                            //新添加
                            startActivity(intent);
                        } else {
                            Toast.makeText(regist.this,"两次密码不一致", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).start();

            }
        });
    }
    }
