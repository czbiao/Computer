package com.biao.computer.health.news;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.biao.computer.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by chenz on 2016/12/30.
 */

public class NewsTitleFrag extends Fragment {

    private RecyclerView recyclerView;
    private boolean isTwoPane;

    //判断是否为平板
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.news_content_layout) != null) {
            isTwoPane = true;
        } else {
            isTwoPane = false;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_frag, container, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView = (RecyclerView) view.findViewById(R.id.news_recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        NewsAdapter adapter = new NewsAdapter(getNews());
        recyclerView.setAdapter(adapter);
        return view;
    }


    private List<News> getNews() {
        List<News> newsList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            News news = new News();
            news.setTitle("第" + (i + 1) + "个新闻");
            news.setContent(randomName("我是第" + (i+1)));
            newsList.add(news);
        }
        return newsList;
    }

    private String randomName(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(name);
        }
        return stringBuilder.toString();
    }

    /**
     * 以下为Adapter的代码
     */
    public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
        private List<News> mNewsList;

        public NewsAdapter(List<News> NewsList) {
            this.mNewsList = NewsList;
        }

        //得到子项布局组件
        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView title;

            public ViewHolder(View view) {
                super(view);
                title = (TextView) view.findViewById(R.id.tv_news_title);
            }
        }

        //获取子项布局
        @Override
        public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_title_item, parent, false);
            final ViewHolder viewHolder = new ViewHolder(view);
            //子项点击事件
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    News news = mNewsList.get(viewHolder.getAdapterPosition());
                    //如果为平板
                    if (isTwoPane) {
                        FragmentManager fragmentManager = getFragmentManager();
                        NewsContentFrag frag = (NewsContentFrag) fragmentManager.findFragmentById(R.id.news_content_layout);
                        frag.refreshContent(news.getTitle(),news.getContent());
                    } else {
                        //如果不为平板
                        NewsContentActivity.actionStart(getActivity(), news.getTitle(), news.getContent());
                    }
                }
            });
            return viewHolder;
        }

        //绑定数据
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            News news = mNewsList.get(position);
            holder.title.setText(news.getTitle());
        }

        @Override
        public int getItemCount() {
            return mNewsList.size();
        }
    }
}
