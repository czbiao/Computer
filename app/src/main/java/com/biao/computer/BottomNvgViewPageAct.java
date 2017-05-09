package com.biao.computer;

/**
 * Created by Biao on 2017/3/31.
 */

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.biao.computer.R;

public class BottomNvgViewPageAct extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener {


    //UI Objects
    private RadioGroup rg_tab_bar;
    private RadioButton rb_commun;
    private RadioButton rb_health;
    //private RadioButton rb_better;
    //private RadioButton rb_setting;
    private RadioButton rb_user;
    private ViewPager vpager;

    private MyFragmentPagerAdapter mAdapter;


    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    //public static final int PAGE_FOUR = 3;
    //public static final int PAGE_FIVE = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nvg_view_page);
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        bindViews();
        rb_commun.setChecked(true);
    }


    private void bindViews() {
        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        rb_commun = (RadioButton) findViewById(R.id.rb_commun);
        rb_health = (RadioButton) findViewById(R.id.rb_health);
        //rb_better = (RadioButton) findViewById(R.id.rb_consult);
        //rb_setting = (RadioButton) findViewById(R.id.rb_mould);
        rb_user = (RadioButton) findViewById(R.id.rb_user);
        rg_tab_bar.setOnCheckedChangeListener(this);

        vpager = (ViewPager) findViewById(R.id.vpager);
        vpager.setAdapter(mAdapter);
        vpager.setCurrentItem(0);
        vpager.setOffscreenPageLimit(3);
        vpager.addOnPageChangeListener(this);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {
            case R.id.rb_commun:
                vpager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.rb_health:
                vpager.setCurrentItem(PAGE_TWO);
                break;
//            case R.id.rb_consult:
//                vpager.setCurrentItem(PAGE_THREE);
//                break;
//            case R.id.rb_mould:
//                vpager.setCurrentItem(PAGE_FOUR);
//                break;
            case R.id.rb_user:
                vpager.setCurrentItem(PAGE_THREE);
                break;
        }

    }

    //重写ViewPager页面切换的处理方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕

        if (state == 2) {
            switch (vpager.getCurrentItem()) {
                case PAGE_ONE:
                    rb_commun.setChecked(true);
                    break;
                case PAGE_TWO:
                    rb_health.setChecked(true);
                    break;
                case PAGE_THREE:
                    rb_user.setChecked(true);
                    break;
//                case PAGE_FOUR:
//                    rb_setting.setChecked(true);
//                    break;
//                case PAGE_FIVE:
//                    rb_user.setChecked(true);
//                    break;
            }
        }
    }
}