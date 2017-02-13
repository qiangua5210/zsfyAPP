package com.fyzs.activity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Window;

import com.czfy.zsfy.R;

public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_start);

        new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Intent intent = new Intent(StartActivity.this,
                        LoginActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right);

            };
        }.start();


    }

}
