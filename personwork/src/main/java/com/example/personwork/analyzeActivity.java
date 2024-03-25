package com.example.personwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class analyzeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyze);
        EditText et_analyze= findViewById(R.id.et_analyze);
        Button bt_analyze=findViewById(R.id.bt_analyze);
        bt_analyze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String analyze = et_analyze.getText().toString();
                SharedPreferences sharedPreferences = getSharedPreferences("analyze",MODE_PRIVATE);
                //获取Editor对象的引用
                SharedPreferences.Editor editor = sharedPreferences.edit();
                //将获取过来的值放入文件

                editor.putString("analyze", analyze);

                // 提交数据
                editor.apply();
                Intent intent = new Intent(analyzeActivity.this,Mid.class);
                startActivity(intent);
            }
        });

    }
}