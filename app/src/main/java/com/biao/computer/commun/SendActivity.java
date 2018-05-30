package com.biao.computer.commun;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.biao.computer.R;
import com.biao.computer.user.User_manager;
import com.biao.computer.user.login.activity.Login;
import com.biao.computer.user.login.activity.Register;

import static com.biao.computer.user.UserFragment.login_username;
import static com.biao.computer.user.login.global.GlobalConstants.IsLogin;

public class SendActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView goback, gosend;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.commun_new_circle);
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        init();
        checkIsLogin();

    }

    public void init(){
        goback = (TextView) findViewById(R.id.goback);
        gosend = (TextView) findViewById(R.id.gosend);
        mEditText = (EditText) findViewById(R.id.editText);
        //设置EditText的显示方式为多行文本输入
        mEditText.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        //文本显示的位置在EditText的最上方
        mEditText.setGravity(Gravity.TOP);
        //改变默认的单行模式
        mEditText.setSingleLine(false);
        //水平滚动设置为False
        mEditText.setHorizontallyScrolling(false);
        goback.setOnClickListener(this);
        gosend.setOnClickListener(this);
        //mEditText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.goback:
                finish();
                break;
            case R.id.gosend:
                if(mEditText.getText().toString().equals(""))
                    Toast.makeText(this, "内容不能为空！", Toast.LENGTH_SHORT).show();
                else {
                    Intent intent = getIntent();
                    Bundle bundle = intent.getExtras();
                    bundle.putString("text",mEditText.getText().toString());
                    intent.putExtras(bundle);
                    setResult(Activity.RESULT_OK, intent);
                    //startActivity(login_main);
                    finish();
                }
                break;
        }
    }

    private void checkIsLogin() {
        if(login_username.getText().toString().equals("登录")){
            new AlertDialog.Builder(this).setTitle("温馨提示").setMessage("您还没有登录，请先登录。")
                    .setPositiveButton("登录", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(SendActivity.this, Login.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("user","user2");
                            intent.putExtras(bundle);
                            startActivityForResult(intent,0);

                        }
                    })
                    .setNegativeButton("返回", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    }).setOnKeyListener(new DialogInterface.OnKeyListener() {
                @Override
                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {

                    if (keyCode == KeyEvent.KEYCODE_BACK
                            && event.getRepeatCount() == 0) {
                        finish();
                    }
                    return false;
                }
            })
                    .setCancelable(false).show();
        }


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
            String str = data.getStringExtra("user");
            login_username.setText(str);
            checkIsLogin();
        }
    }
}
