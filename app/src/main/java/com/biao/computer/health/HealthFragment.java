package com.biao.computer.health;

/**
 * Created by Biao on 2017/3/31.
 */

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.biao.computer.R;
import com.biao.computer.health.Article.OtherFragment;
import com.biao.computer.health.news.NewsTitleFrag;
import com.biao.computer.health.videolist.VideoFragment;
import com.biao.computer.talk.TalkFragment;
import com.biao.computer.user.UserFragment;

import com.quinny898.library.persistentsearch.SearchBox;
import com.quinny898.library.persistentsearch.SearchBox.MenuListener;
import com.quinny898.library.persistentsearch.SearchBox.SearchListener;
import com.quinny898.library.persistentsearch.SearchResult;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;


public class HealthFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup mRadioGroup;
    Boolean isSearch;
    private SearchBox search;
    private View view;
    //private Button health_bar_btn1,health_bar_btn2,health_bar_btn3,health_bar_btn4,health_bar_btn5,health_bar_btn6,health_bar_btn7,health_bar_btn8;

    VideoFragment videoFragment1 = new VideoFragment();
    VideoFragment videoFragment2 = new VideoFragment();
    NewsTitleFrag newsTitleFrag1 = new NewsTitleFrag();
    NewsTitleFrag newsTitleFrag2 = new NewsTitleFrag();
    OtherFragment otherFragment1 = new OtherFragment("article_top.json");
    OtherFragment otherFragment2 = new OtherFragment("article_hot.json");

    public HealthFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.health_avtivity, container, false);

        initSearch();

        mRadioGroup = (RadioGroup) view.findViewById(R.id.health_rg_btn);
        mRadioGroup.setOnCheckedChangeListener(this);
        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frag, otherFragment1).commit();

        return view;
    }

    public void initSearch(){
        search = (SearchBox) view.findViewById(R.id.searchbox);
        search.enableVoiceRecognition(this);
//        for(int x = 0; x < 10; x++){
//            SearchResult option = new SearchResult("result" + Integer.toString(x), getResources().getDrawable(R.drawable.ic_history));
//            search.addSearchable(option);
//        }


        final ArrayList<SearchResult> options = new ArrayList<SearchResult>();
        SearchResult option1 = new SearchResult("C语言", getResources().getDrawable(R.drawable.ic_history));
        SearchResult option2 = new SearchResult("怎么学好计算机", getResources().getDrawable(R.drawable.ic_history));
        SearchResult option3 = new SearchResult("Java学习指南", getResources().getDrawable(R.drawable.ic_history));
        SearchResult option4 = new SearchResult("C++教学视频", getResources().getDrawable(R.drawable.ic_history));
        SearchResult option5 = new SearchResult("软件工程", getResources().getDrawable(R.drawable.ic_history));
        SearchResult option6 = new SearchResult("互联网时代", getResources().getDrawable(R.drawable.ic_history));
        SearchResult option7 = new SearchResult("科技发展", getResources().getDrawable(R.drawable.ic_history));
        SearchResult option8 = new SearchResult("软考资料", getResources().getDrawable(R.drawable.ic_history));
        options.add(option1);
        options.add(option2);
        options.add(option3);
        options.add(option4);
        options.add(option5);
        options.add(option6);
        options.add(option7);
        options.add(option8);
        search.setSearchables(options);
//        search.addSearchable(option2);
//        search.addSearchable(option3);
//        search.addSearchable(option4);
//        search.addSearchable(option5);
//        search.addSearchable(option6);
//        search.addSearchable(option7);
//        search.addSearchable(option8);

        search.setLogoText("搜索计算机知识");

        search.setMenuListener(new MenuListener(){

            @Override
            public void onMenuClick() {
                //Hamburger has been clicked
                //Toast.makeText(getActivity(), "Menu click", Toast.LENGTH_SHORT).show();
            }

        });
        search.setSearchListener(new SearchListener(){

            @Override
            public void onSearchOpened() {
                //Use this to tint the screen
                //Toast.makeText(getActivity(), " onSearchOpened", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSearchClosed() {
                //Use this to un-tint the screen
                //Toast.makeText(getActivity(), " onSearchClosed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSearchTermChanged() {
                //React to the search term changing
                //Called after it has updated results
                //搜索数据改变时候提示
            }

            @Override
            public void onSearch(String searchTerm) {
                //Toast.makeText(getActivity(), searchTerm +" Searched", Toast.LENGTH_SHORT).show();
                options.add(0, new SearchResult(searchTerm, getResources().getDrawable(R.drawable.ic_history)));
                Intent intent = new Intent(getActivity(),searchView.class);
                intent.putExtra("url",searchTerm);
                startActivity(intent);
            }

            @Override
            public void onSearchCleared() {
                //Called when the clear button is clicked
                //Toast.makeText(getActivity(), " onSearchCleared", Toast.LENGTH_SHORT).show();
            }

        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentManager fm=getChildFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();

        switch (checkedId) {
            case R.id.health_btn1:
                ft.replace(R.id.frag,otherFragment1).commit();
                break;
            case R.id.health_btn2:
                ft.replace(R.id.frag,videoFragment1).commit();
                break;
            case R.id.health_btn3:
                ft.replace(R.id.frag,otherFragment2).commit();
                break;
            case R.id.health_btn4:
                ft.replace(R.id.frag,videoFragment2).commit();
                break;

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1234 && resultCode == RESULT_OK) {
            ArrayList<String> matches = data
                    .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            search.populateEditText(matches);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}