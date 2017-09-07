package com.fulushan.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fulushan.R;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkhttpActivity extends AppCompatActivity {

    private final String api_key = "9702e300d6abdd456009318809605949";
    @BindView(R.id.url_Edit)
    EditText urlEdit;
    @BindView(R.id.get_btn)
    Button getBtn;
    @BindView(R.id.post_btn)
    Button postBtn;
    @BindView(R.id.result_tv)
    TextView resultTv;
    @BindView(R.id.post_url_Edit)
    EditText postUrlEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        ButterKnife.bind(this);

        urlEdit.setText("http://www.kuaidi100.com/query");

        postUrlEdit.setText("http://www.kuaidi100.com/query");
    }


    @OnClick({R.id.get_btn, R.id.post_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.get_btn:

                getMethod(urlEdit.getText().toString());
                break;
            case R.id.post_btn:
                postMethod(urlEdit.getText().toString());
                break;
        }
    }

    private String postMethod(String url) {
        String result = null;

        OkHttpClient client = new OkHttpClient();
        FormBody.Builder params=new FormBody.Builder();
        params.add("data", "0");//新增参数
        Request request = new Request.Builder()
                .url(url)
                .post(params.build())
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            resultTv.setText(response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        return result;
    }

    private String getMethod(String url) {
        String result = null;
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
        urlBuilder.addQueryParameter("type", "yuantong");
        urlBuilder.addQueryParameter("postid","11111111111");

        Request request = new Request.Builder()
                .url(urlBuilder.build())
                .build();

        Response response = null;
//        response = client.newCall(request).execute();//同步方法
        client.newCall(request).enqueue(new Callback() {//异步方法
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            resultTv.setText(response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        return result;
    }
}
