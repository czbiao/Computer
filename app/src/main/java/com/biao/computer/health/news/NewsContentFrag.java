package com.biao.computer.health.news;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.biao.computer.R;

/**
 * Created by chenz on 2017/1/1.
 */

public class NewsContentFrag extends Fragment {
    private View view;
    TextView newsTitle;
    TextView newsContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_content_frag, container, false);
        newsTitle= (TextView) view.findViewById(R.id.tv_content_title);
        newsContent = (TextView) view.findViewById(R.id.tv_content_content);
        return view;
    }

    public void refreshContent(String title, String content) {
        newsTitle.setText(title);
        newsContent.setText(content);
    }
}
