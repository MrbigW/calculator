package com.cody.cody.datastructuredemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.cody.cody.datastructuredemo.stack.CalculatorActivity;
import com.cody.cody.datastructuredemo.stack.Stack;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView tv;
    private Button bt1;
    private Button bt2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv_1);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button)findViewById(R.id.bt2);
        final String text="Android Developer";
        tv.setText(text);
        bt1.setOnClickListener(v -> tv.setText(reverse(text)));
        bt2.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), CalculatorActivity.class)));
    }


    public static String reverse(String str) {
        Stack<String> stack = new Stack<>(str.length());
        for (int i = 0; i < stack.size(); i++) {
            stack.push(String.valueOf(str.charAt(i)));
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            builder.append(stack.pop());
        }
        return builder.toString();
    }


}
