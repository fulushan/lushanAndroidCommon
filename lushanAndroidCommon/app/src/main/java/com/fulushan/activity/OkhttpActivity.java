package com.fulushan.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.fulushan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OkhttpActivity extends AppCompatActivity {


    @BindView(R.id.send_btn)
    Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.send_btn)
    public void onViewClicked() {
    }
}
