package com.example.personwork;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.personwork.pojo.User;
import com.example.personwork.utils.UserDB;

import java.sql.SQLException;
import java.util.List;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //创建数据库

        TextView register = findViewById(R.id.lg_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, regist.class);
                startActivity(intent);
            }
        });

        //登录
        Button loginButton = findViewById(R.id.lg_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText username = findViewById(R.id.lg_username);
                EditText password = findViewById(R.id.lg_password);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            List<String> strings = UserDB.queryAll();
                            String db_username = strings.get(0);
                            String db_password=strings.get(1);
                            if (db_username.equals(username.getText().toString()) && db_password.equals(password.getText().toString())) {
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);
//                        onDestroy();
                    } else {

                        Looper.prepare();
                        Toast.makeText(Login.this,"账号或密码错误！",Toast.LENGTH_SHORT).show();
                        Looper.loop();

                    }
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }).start();
                //账号密码匹配
//                for (UserData user : users) {
//                    if (user.getUsername().equals(username.getText().toString()) && user.getPassword().equals(password.getText().toString())) {
//                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
//                        startActivity(intent);
//                        onDestroy();
//                    } else {
//                        Toast.makeText(MainActivity.this,"账号或密码错误！",Toast.LENGTH_SHORT).show();
//                    }
//                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    //接受传回来的账号
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    final EditText loginUsername = findViewById(R.id.lg_username);
                    String returnUsername = data.getStringExtra("username");
                    loginUsername.setText(returnUsername);
                    loginUsername.setSelection(returnUsername.length());
                }
                break;
            default:
        }

    }
}