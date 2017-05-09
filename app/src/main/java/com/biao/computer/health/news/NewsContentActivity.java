package com.biao.computer.health.news;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.biao.computer.R;

public class NewsContentActivity extends AppCompatActivity {
    private TextView goback;

    public static void actionStart(Context context, String title, String content) {
        Intent intent = new Intent(context,NewsContentActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("content", content);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content_layout);
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        TextView title = (TextView) findViewById(R.id.tv_content_title);
        TextView content = (TextView) findViewById(R.id.tv_content_content);
        title.setText(intent.getStringExtra("title"));
        content.setText(intent.getStringExtra("content"));

        goback = (TextView) findViewById(R.id.goback);
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
