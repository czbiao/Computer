package com.biao.computer.user.userCustomer;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.biao.computer.R;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.HttpHandler;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;

import java.io.File;

public class weixinActivity extends AppCompatActivity {
    ImageView image;
    TextView reback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weixin);
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        reback = (TextView) findViewById(R.id.reback);
        reback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        image = (ImageView) findViewById(R.id.image);
        image.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                new AlertDialog.Builder(weixinActivity.this).setTitle("温馨提示").setMessage("是否保存图片？")
                        .setPositiveButton("是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                downImg();
                            }
                        })
                        .setNegativeButton("否",null).setCancelable(false).show();

                return false;
            }
        });
    }

    private void downImg() {
        HttpUtils http = new HttpUtils();
        HttpHandler handler = http.download("http://biaohstc.cn/Computer/weixin.jpg","/sdcard/Computer/weixin.jpg",
                true, // 如果目标文件存在，接着未完成的部分继续下载。服务器不支持RANGE时将从新下载。
                true, // 如果从请求返回信息中获取到文件名，下载完成后自动重命名。
                new RequestCallBack<File>() {

                    @Override
                    public void onStart() {
                        Log.e("onStart","........start......");
                    }

                    @Override
                    public void onLoading(long total, long current, boolean isUploading) {
                        Log.e("onLoading",total+"|"+current);
                    }

                    @Override
                    public void onSuccess(ResponseInfo<File> responseInfo) {
                        Log.e("onSuccess", responseInfo.toString());
                        Toast.makeText(weixinActivity.this, "图片已保存到 /sdcard/Computer/weixin.jpg", Toast.LENGTH_SHORT).show();

                    }


                    @Override
                    public void onFailure(HttpException error, String msg) {
                        Log.e("onFailure","........msg......"+msg);
                        if(msg == "maybe the file has downloaded completely")
                            Toast.makeText(weixinActivity.this, "图片已保存到 /sdcard/Computer/weixin.jpg", Toast.LENGTH_SHORT).show();
                    }
                });

    }

}
