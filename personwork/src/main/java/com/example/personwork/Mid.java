package com.example.personwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Mid extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mid);
        Button bt_week = findViewById(R.id.bt_week);
        Button bt_day = findViewById(R.id.bt_day);
        Button bt_check = findViewById(R.id.bt_check);
        TextView tv_week=findViewById(R.id.tv_week);
        TextView tv_day=findViewById(R.id.tv_day);
        TextView tv_analyze=findViewById(R.id.tv_analyze);
        bt_check.setOnClickListener(this);
        bt_day.setOnClickListener(this);
        bt_week.setOnClickListener(this);
        SharedPreferences sharedPreferences = getSharedPreferences("plan",MODE_PRIVATE);
        SharedPreferences sharedPreferences2 = getSharedPreferences("record",MODE_PRIVATE);
        SharedPreferences sharedPreferences3 = getSharedPreferences("analyze",MODE_PRIVATE);
        String page3_edit=sharedPreferences.getString("page3_edit"," ");
        String record=sharedPreferences2.getString("record"," ");
        String analyze=sharedPreferences3.getString("analyze"," ");
        tv_week.setText("    "+page3_edit+"\n");
        tv_day.setText("  "+record);
        tv_analyze.setText(" "+analyze);
    }

    @Override
    public void onClick(View v) {

        Bundle extras = getIntent().getExtras();
        String name = null;
        if (extras != null) {
            name = extras.getString("name");
        }
        if(v.getId()==R.id.bt_week){
            Intent intent=new Intent(this,MainActivity2.class);
            intent.putExtra("name", name);
            setResult(RESULT_OK, intent);
            finish();
            startActivity(intent);
        }
        if(v.getId()==R.id.bt_day){
            Intent intent=new Intent(this,RecordActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.bt_check){
            Intent intent=new Intent(this,analyzeActivity.class);
            startActivity(intent);
        }
    }
}