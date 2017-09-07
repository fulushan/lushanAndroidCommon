package com.fulushan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.fulushan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.okHttp_btn)
    Button okHttpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.okHttp_btn)
    public void onViewClicked() {
        Intent intent = new Intent(this,OkhttpActivity.class);
        startActivity(intent);
    }

    /**
     *              Intent intent = new Intent(this,OkhttpActivity.class);
     startActivity(intent);
     * @param v
     */
}
