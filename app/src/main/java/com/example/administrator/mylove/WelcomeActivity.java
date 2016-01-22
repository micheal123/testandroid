package com.example.administrator.mylove;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.way.pattern.UnlockGesturePasswordActivity;

/**
 * Created by Administrator on 2016/1/14 0014.
 */
public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        Handler han=new Handler();
        han.postDelayed(new loading(), 2000);
    }
    class loading implements Runnable {
        @Override
        public void run() {
            startActivity(new Intent(WelcomeActivity.this,UnlockGesturePasswordActivity.class));
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                   WelcomeActivity.this.finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }//最后调用
}
