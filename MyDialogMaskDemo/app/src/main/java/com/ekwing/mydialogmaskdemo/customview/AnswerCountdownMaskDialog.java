package com.ekwing.mydialogmaskdemo.customview;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import androidx.annotation.NonNull;
import com.ekwing.mydialogmaskdemo.R;

/**
 *
 * 使用步骤：
 *  myDialogMask=new AnswerCountdownMaskDialog(mContext);//实例化
 *  myDialogMask.setTvRequireNumber("4");//设置读的遍数
 *  myDialogMask.show();//展示
 */

public class AnswerCountdownMaskDialog extends Dialog {

    private TextView tvShowNumber;//展示倒计时的view
    private int ContNumber=3;
    private TextView tvRequireNumber;//展示读的遍数的view

    public AnswerCountdownMaskDialog(@NonNull Context context) {
        super(context,R.style.Dialog_Theme);
        initView(context);
        startTimeChange();
    }

    public AnswerCountdownMaskDialog(@NonNull Context context, int themeResId) {
        super(context, R.style.Dialog_Theme);
        initView(context);
        startTimeChange();

    }

    private void initView(@NonNull Context context) {
        setContentView(R.layout.dialog_layout_show);
        tvShowNumber = findViewById(R.id.tv_show);
        tvRequireNumber = findViewById(R.id.tv_require_number);
    }

    /**
     * 计时的逻辑
     */
    public void startTimeChange(){

        CountDownTimer mCountDownTimer=new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long l) {

                int number=ContNumber--;
                tvShowNumber.setText(number+"");
            }

            @Override
            public void onFinish() {
                dismiss();

            }
        };
        mCountDownTimer.start();
    }

    /**
     * 设置老师要求读的遍数
     * @param number
     */
    public void setTvRequireNumber(String number){
        SpannableString mSpannableString=new SpannableString("老师要求读"+" "+number+" "+"遍哦~");
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#4ad26b"));
        mSpannableString.setSpan(colorSpan,6,7, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        tvRequireNumber.setText(mSpannableString);
    }
}
