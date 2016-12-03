package com.example.administrator.drawlayout;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ResetpwdActivity extends AppCompatActivity {
    private Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resetpwd_layout);
        btn1=(Button)findViewById(R.id.resetpwd_btn_cancel);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ResetpwdActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}

