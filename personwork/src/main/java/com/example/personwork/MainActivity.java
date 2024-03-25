package com.example.personwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.personwork.pojo.Info;
import com.example.personwork.pojo.User;
import com.example.personwork.utils.InfoDB;
import com.example.personwork.utils.UserDB;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button re_registered = findViewById(R.id.re_registered);

        re_registered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText xuehao = findViewById(R.id.re_xuehao);
                EditText name = findViewById(R.id.re_name);
                EditText phone = findViewById(R.id.re_phone);
                EditText a_class = findViewById(R.id.re_class);
                String inputXuehao = xuehao.getText().toString();
                String inputName = name.getText().toString();
                String inputPhone = phone.getText().toString();
                String inputA_class = a_class.getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Info info = new Info();
                        //存储账号密码
                        info.setXuehao(inputXuehao);
                        info.setName(inputName);
                        info.setPhone(inputPhone);
                        info.setA_class(inputA_class);
                            try {
                                InfoDB.insertData(info);
                                Log.v("dzh","ok");
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                            //传回账号（新）
                            Intent intent = new Intent(MainActivity.this,Mid.class);
                            /*
                            *  Bundle bundle=new Bundle();
                               bundle.putString("request_time", DateUtil.getNowTime());
                               bundle.putString("request_content",tv_send.getText().toString());
                               intent.putExtras(bundle);*/
                            intent.putExtra("name", inputName);
                            setResult(RESULT_OK, intent);
                            finish();
                            //新添加
                            startActivity(intent);
                        }

                }).start();

            }
        });
    }
}