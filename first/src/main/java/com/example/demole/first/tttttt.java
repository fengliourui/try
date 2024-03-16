package com.example.demole.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path ="/first/tttttt")
public class tttttt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tttt);
        Button button=findViewById(R.id.ttttt);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent();
                in.putExtra("msg", "从home模块返回的数据");
                setResult(999, in);
                finish();
            }
        });
        // 获取携带的参数
        String name = getIntent().getStringExtra("name");
        int age = getIntent().getIntExtra("age",0);
        TextView textView =findViewById(R.id.text1);
        TextView textView1 =findViewById(R.id.text2);

        textView.setText("名字是"+name);
        textView1.setText("年龄"+age);
    }
}