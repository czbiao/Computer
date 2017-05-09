package com.biao.computer;

/**
 * Created by Biao on 2017/3/31.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.biao.computer.mould.MouldFragment;
import com.biao.computer.commun.CommunFragment;
import com.biao.computer.health.HealthFragment;
import com.biao.computer.talk.TalkFragment;
import com.biao.computer.user.UserFragment;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {


    private final int PAGER_COUNT = 3;

    private CommunFragment mMyCommunFragment = null;
    private HealthFragment mMyHealthFragment = null;
    private TalkFragment mMyTalkFragment = null;
    private MouldFragment mMyMouldFragment = null;
    private UserFragment mMyUserFragment = null;



    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        mMyCommunFragment = new CommunFragment();
        mMyHealthFragment = new HealthFragment();
        mMyTalkFragment = new TalkFragment();
        mMyMouldFragment = new MouldFragment();
        mMyUserFragment = new UserFragment();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case BottomNvgViewPageAct.PAGE_ONE:
                fragment = mMyCommunFragment;
                break;
            case BottomNvgViewPageAct.PAGE_TWO:
                fragment = mMyHealthFragment;
                break;
            case BottomNvgViewPageAct.PAGE_THREE:
                fragment = mMyUserFragment;
                break;
//            case BottomNvgViewPageAct.PAGE_FOUR:
//                fragment = mMyMouldFragment;
//                break;
//            case BottomNvgViewPageAct.PAGE_FIVE:
//                fragment = mMyUserFragment;
//                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGER_COUNT;
    }
}