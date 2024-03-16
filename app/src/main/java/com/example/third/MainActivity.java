package com.example.third;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path ="/app/MainActivity")
public class MainActivity extends AppCompatActivity  {

    private NavigationCallback navigationCallback = new NavigationCallback() {
        @Override
        public void onFound(Postcard postcard) {
        }

        @Override
        public void onLost(Postcard postcard) {
        }

        @Override
        public void onArrival(Postcard postcard) {
        }

        @Override
        public void onInterrupt(Postcard postcard) {
            // 使用 Handler 在主线程中显示 Toast
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this, "你的年龄过小", Toast.LENGTH_SHORT).show();
                }
            });

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button =findViewById(R.id.teet);
        EditText editText = findViewById(R.id.qqq);
        EditText editText1 = findViewById(R.id.qqq1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ageStr = editText1.getText().toString();
                try {
                    int age = Integer.parseInt(ageStr);
                    String name = String.valueOf(editText.getText());
                    ARouter.getInstance().build("/first/tttttt")
                            .withInt("age", age)
                            .withString("name", name)
                            .navigation(null, navigationCallback);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "请输入有效的年龄", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}