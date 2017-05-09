package com.biao.computer.user;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.biao.computer.R;
import com.biao.computer.user.login.activity.Login;

public class UserCustomer extends Activity implements View.OnClickListener {
    private Button user_people, user_wechat, user_customer, user_phone;
    private TextView goback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_customer);
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        init();
        initListen();
    }

    private void init() {
        user_people = (Button) findViewById(R.id.user_people);
        user_wechat = (Button) findViewById(R.id.user_wechat);
        user_customer = (Button) findViewById(R.id.user_customer);
        user_phone = (Button) findViewById(R.id.user_phone);
        goback = (TextView) findViewById(R.id.goback);
    }

    private void initListen() {
        user_people.setOnClickListener(this);
        user_wechat.setOnClickListener(this);
        user_customer.setOnClickListener(this);
        user_phone.setOnClickListener(this);
        goback.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_people:
                Toast.makeText(this, "该功能正在开发中...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.user_wechat:
                Toast.makeText(this, "该功能正在开发中...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.user_customer:
                Toast.makeText(this, "该功能正在开发中...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.user_phone:
                //Toast.makeText(this, "该功能正在开发中...", Toast.LENGTH_SHORT).show();
                new AlertDialog.Builder(this).setTitle("温馨提示").setMessage("将拨打客服电话10086\n确定吗？")
                        .setPositiveButton("是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:10086"));

                                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                    // TODO: Consider calling
                                    //    ActivityCompat#requestPermissions
                                    // here to request the missing permissions, and then overriding
                                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                    //                                          int[] grantResults)
                                    // to handle the case where the user grants the permission. See the documentation
                                    // for ActivityCompat#requestPermissions for more details.
                                    return;
                                }
                                startActivity(intent);

                            }
                        })
                        .setNegativeButton("否",null).show();
                break;
            case R.id.goback:
                finish();
                break;
        }
    }
}
