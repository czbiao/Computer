package com.biao.computer.user.userCustomer;


import java.lang.reflect.Field;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.biao.computer.R;


public class FeedBackActivity extends Activity {
	EditText feedback_content_edit, feedback_contact_edit;
	TextView feedback_send, reback;


	@SuppressLint("SdCardPath")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feedback);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			setTranslucentStatus(true);
		}
		//透明状态栏
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);


		try {
			ViewConfiguration mconfig = ViewConfiguration.get(this);
			Field menuKeyField = ViewConfiguration.class
					.getDeclaredField("sHasPermanentMenuKey");
			if (menuKeyField != null) {
				menuKeyField.setAccessible(true);

				menuKeyField.setBoolean(mconfig, false);
			}
		} catch (Exception ex) {
		}
		feedback_content_edit = (EditText) findViewById(R.id.feedback_content_edit);
		feedback_contact_edit = (EditText) findViewById(R.id.feedback_contact_edit);
		feedback_send = (TextView) findViewById(R.id.feedback_send);
		reback = (TextView) findViewById(R.id.reback);
		reback.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

		feedback_send.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String content = feedback_content_edit.getText().toString()
						.trim();
				String contact = feedback_contact_edit.getText().toString()
						.trim();
				if (!content.equals("")) {

					if (NetWorkUtil.networkCanUse(FeedBackActivity.this)) {
						initData(contact, content);

						finish();
						Toast.makeText(FeedBackActivity.this,
								"感谢您的宝贵意见..", Toast.LENGTH_SHORT).show();
					} else {
						if (!NetWorkUtil.networkCanUse(FeedBackActivity.this)) {
							new AlertDialog.Builder(FeedBackActivity.this).setTitle("温馨提示").setMessage("网络连接失败...\n请检查您的网络连接是否正常！")
									.setPositiveButton("确定", null).show();

						}
					}

				} else {
					new AlertDialog.Builder(FeedBackActivity.this).setTitle("温馨提示").setMessage("说点什么吧...")
							.setPositiveButton("确定", null).show();
				}
			}
		});


	}

	public void initData(final String contact, final String content) {
		new Thread() {
			@Override
			public void run() {
				EmailSender sender = new EmailSender();
				// 设置服务器地址和端口，网上搜的到
				sender.setProperties("smtp.163.com", "25");// smtp.163.com
				// 分别设置发件人，邮件标题和文本内容
				try {
					try {
						//注释掉附件试试
						//sender.addAttachment(filepath);
					} catch (Exception e) {
						Log.e("e:", e + "");
					}
					sender.setMessage("13413423055@163.com", contact, content);//发件人邮箱&标题&内容
					sender.setReceiver(new String[] { "848221732@qq.com" });// 收件人邮箱
					sender.sendEmail("smtp.163.com", "13413423055@163.com",
							"biao0309");//发件人邮箱以及密码
				} catch (AddressException e) {
					e.printStackTrace();
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	@SuppressWarnings("unused")
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			finish();
			return true;
		} else {

			// TODO Auto-generated method stub
			String content = feedback_content_edit.getText().toString()
					.trim();
			String contact = feedback_contact_edit.getText().toString()
					.trim();
			if (!content.equals("")) {

				if (NetWorkUtil.networkCanUse(getApplicationContext())) {
					initData(contact, content);

					finish();
					Toast.makeText(getApplicationContext(),
							"感谢您的宝贵意见..", Toast.LENGTH_SHORT).show();
				} else {
					if (!NetWorkUtil.networkCanUse(FeedBackActivity.this)) {
						new AlertDialog.Builder(this).setTitle("温馨提示").setMessage("网络连接失败...\n请检查您的网络连接是否正常！")
								.setPositiveButton("确定", null).show();

					}
				}

			} else {
				new AlertDialog.Builder(this).setTitle("温馨提示").setMessage("说点什么吧...")
						.setPositiveButton("确定", null).show();
			}


		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//getMenuInflater().inflate(R.menu.fb, menu);


		return super.onCreateOptionsMenu(menu);
	}

	@TargetApi(19)
	private void setTranslucentStatus(boolean on) {
		Window win = getWindow();
		WindowManager.LayoutParams winParams = win.getAttributes();
		final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
		if (on) {
			winParams.flags |= bits;
		} else {
			winParams.flags &= ~bits;
		}
		win.setAttributes(winParams);
	}

	public String getDeviceId() {
		String imei = "";
		Context ctx = getApplicationContext();
		if (ctx != null) {

			TelephonyManager telephonyManager = (TelephonyManager) ctx
					.getSystemService(Context.TELEPHONY_SERVICE);
			if (telephonyManager != null)
				imei = telephonyManager.getDeviceId();

			if (TextUtils.isEmpty(imei))
				imei = "0";
		}
		return imei;

	}
}
