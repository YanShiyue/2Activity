package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //接收FirstActivity传递的数据
        final Intent intent=getIntent();
        String data=intent.getStringExtra("extra_data");
        Log.d("intent_Second", data);

        //向FirstActivity传递数据
        Button bt_second=(Button)findViewById(R.id.bt_second);
        bt_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent();
                intent1.putExtra("data_return","Hello FirstActivity");
                setResult(RESULT_OK,intent1);
                finish();
            }
        });
    }
}
