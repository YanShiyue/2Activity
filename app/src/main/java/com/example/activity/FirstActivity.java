package com.example.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        //向SecondActivity传递数据
        Button bt=(Button)findViewById(R.id.bt_first);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data="Hello SecondActivity";
                Intent intent=new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("extra_data",data);
                startActivityForResult(intent,1);//传入请求码
            }
        });

    }

    //接收SecondActivity传递的数据
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){//返回数据时传入的处理结果
                    String returnData=data.getStringExtra("data_return");
                    Log.d("intent_First", returnData);
                }
                break;
                default:
        }
    }
}
