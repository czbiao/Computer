package com.biao.computer.user;

/**
 * Created by Biao on 2017/3/31.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.biao.computer.MainActivity;
import com.biao.computer.R;
import com.biao.computer.user.login.activity.Login;
import com.biao.computer.user.signcalendar.SignCalendarActivity;


public class UserFragment extends Fragment implements View.OnClickListener {
    private Button  user_btn_2, user_btn_3,  user_btn_5;
    private View view;
    private ImageView loginbtn;
    public static TextView login_username;
    private Button user_friend, user_favor, user_history;
    private TextView user_sun, user_sign;

    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.user_activity, container, false);


        initMyBtn();


        return view;
    }

    private void initMyBtn() {
        loginbtn = (ImageView) view.findViewById(R.id.login);
        user_btn_2 = (Button) view.findViewById(R.id.user_btn_2);
        user_btn_3 = (Button) view.findViewById(R.id.user_btn_3);
        user_btn_5 = (Button) view.findViewById(R.id.user_btn_5);
        user_friend = (Button) view.findViewById(R.id.user_friend);
        user_favor = (Button) view.findViewById(R.id.user_favor);
        user_history = (Button) view.findViewById(R.id.user_history);
        login_username = (TextView) view.findViewById(R.id.login_username);
        user_sign = (TextView) view.findViewById(R.id.user_sign);
        user_sun = (TextView) view.findViewById(R.id.user_sun);
        user_btn_2.setOnClickListener(this);
        user_btn_3.setOnClickListener(this);
        user_btn_5.setOnClickListener(this);
        loginbtn.setOnClickListener(this);
        user_friend.setOnClickListener(this);
        user_favor.setOnClickListener(this);
        user_history.setOnClickListener(this);
        user_sign.setOnClickListener(this);
        user_sun.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.login:
                intent = new Intent(getActivity(), Login.class);
                Bundle bundle = new Bundle();
                bundle.putString("user","user2");
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
                break;
//            case R.id.user_btn_1:
//                Toast.makeText(getActivity(), "该功能正在开发中...", Toast.LENGTH_SHORT).show();
//                break;
            case R.id.user_btn_2:
                //Toast.makeText(getActivity(), "该功能正在开发中...", Toast.LENGTH_SHORT).show();
                intent = new Intent(getActivity(), User_manager.class);
                startActivity(intent);
                break;
            case R.id.user_btn_3:
                //Toast.makeText(getActivity(), "该功能正在开发中...", Toast.LENGTH_SHORT).show();
                intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "http://139.199.171.66:8080/download/secret.apk");
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent,"分享到"));
                break;
//            case R.id.user_btn_4:
//                Toast.makeText(getActivity(), "该功能正在开发中...", Toast.LENGTH_SHORT).show();
//                break;
            case R.id.user_btn_5:
                //Toast.makeText(getActivity(), "该功能正在开发中...", Toast.LENGTH_SHORT).show();
                intent = new Intent(getActivity(), UserCustomer.class);
                startActivity(intent);
                break;
            case R.id.user_friend:
                intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                break;
            case R.id.user_favor:
                intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                break;
            case R.id.user_history:
                intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                break;
            case R.id.user_sign:
                intent = new Intent(getActivity(), SignCalendarActivity.class);
                startActivity(intent);
                break;
            case R.id.user_sun:
                intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
            String str = data.getStringExtra("user");
            Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
            //loginbtn.setText("已登录");
            login_username.setText(str);
            loginbtn.setBackgroundResource(R.drawable.aa1);
        }
    }


}