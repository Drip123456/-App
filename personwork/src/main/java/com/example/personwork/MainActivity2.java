package com.example.personwork;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle extras = getIntent().getExtras();
        String name = null;
        if (extras != null) {
            name = extras.getString("name");
        }
       TextView tv_name = findViewById(R.id.tv_named);
        String desc="欢迎你："+name;
        tv_name.setText(desc);
       ImageButton t_yes=findViewById(R.id.bt_yes);
        t_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText page3_edit = findViewById(R.id.page3_edit);

                String inputPage3_edit = page3_edit.getText().toString();
                SharedPreferences sharedPreferences = getSharedPreferences("plan",MODE_PRIVATE);
                //获取Editor对象的引用
                SharedPreferences.Editor editor = sharedPreferences.edit();
                //将获取过来的值放入文件

                editor.putString("page3_edit", inputPage3_edit);

                // 提交数据
                editor.apply();
                Intent intent = new Intent(MainActivity2.this,Mid.class);
                startActivity(intent);

            }
        });


    }
}