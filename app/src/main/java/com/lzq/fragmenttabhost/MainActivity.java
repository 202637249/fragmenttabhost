package com.lzq.fragmenttabhost;

import android.media.Image;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.lzq.fragmenttabhost.franment.FragmentPage1;
import com.lzq.fragmenttabhost.franment.FragmentPage2;
import com.lzq.fragmenttabhost.franment.FragmentPage3;
import com.lzq.fragmenttabhost.franment.FragmentPage4;
import com.lzq.fragmenttabhost.franment.FragmentPage5;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private LayoutInflater mInflater;
    private FragmentTabHost mTablehost;
    private List<Tab> mTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init(){
        mInflater = LayoutInflater.from(this);
        mTablehost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTablehost.setup(this, getSupportFragmentManager(), R.id.fragment_content);

        mTab = new ArrayList<>(5);
        Tab home = new Tab(R.string.tab_home, R.drawable.tab_home_btn, FragmentPage1.class);
        Tab message = new Tab(R.string.tab_message, R.drawable.tab_message_btn, FragmentPage2.class);
        Tab selfinfo = new Tab(R.string.tab_selfinfo, R.drawable.tab_selfinfo_btn, FragmentPage3.class);
        Tab square = new Tab(R.string.tab_square, R.drawable.tab_square_btn, FragmentPage4.class);
        Tab more = new Tab(R.string.tab_more, R.drawable.tab_more_btn, FragmentPage5.class);
        mTab.add(home);
        mTab.add(message);
        mTab.add(selfinfo);
        mTab.add(square);
        mTab.add(more);


        for (Tab tab : mTab){
            TabHost.TabSpec tabSpec = mTablehost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(buildIndicator(tab));

            mTablehost.addTab(tabSpec, tab.getFragment(),null);
        }
        mTablehost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        mTablehost.setCurrentTab(0);
    }

    private View buildIndicator(Tab tab){
        View view  = mInflater.inflate(R.layout.view_tabhost,null);
        ImageView ivTab = (ImageView) view.findViewById(R.id.iv_tab_main);
        TextView tvTab = (TextView) view. findViewById(R.id.tv_tab_main);

        ivTab.setBackgroundResource(tab.getIcon());
        tvTab.setText(tab.getTitle());

        return  view;
    }
}
