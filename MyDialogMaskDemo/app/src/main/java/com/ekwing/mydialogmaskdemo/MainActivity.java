package com.ekwing.mydialogmaskdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ekwing.mydialogmaskdemo.customview.AnswerCountdownMaskDialog;

public class MainActivity extends AppCompatActivity {
    private TextView tvShow;
    private AnswerCountdownMaskDialog myDialogMask;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=this;
        tvShow=findViewById(R.id.tv_show);
        tvShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialogMask=new AnswerCountdownMaskDialog(mContext);
                myDialogMask.setTvRequireNumber("4");
                myDialogMask.show();
            }
        });
    }
}
