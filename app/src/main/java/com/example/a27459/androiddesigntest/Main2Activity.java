package com.example.a27459.androiddesigntest;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 一个中文版Demo App搞定所有Android的Support Library新增所有兼容控件
 * 支持最新2015 Google I/O大会Android Design Support Library
 */
public class Main2Activity extends ActionBarActivity {
    @BindView(R.id.toolbar_appbarLayout)
    Toolbar toolbar;
    @BindView(R.id.app_bar_layout)
    AppBarLayout appbarLayout;
    @BindView(R.id.navitionview_drawerLayout)
    NavigationView navigationView;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawlayout;
    @BindView(R.id.tabLayot)
    TabLayout tablayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //初始化控件及布局
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        //MainActivity的布局文件中的主要控件初始化


        //初始化ToolBar
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (null !=actionBar) {
            actionBar.setHomeAsUpIndicator(android.R.drawable.ic_dialog_alert);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        //对NavigationView添加item的监听事件
        navigationView.setNavigationItemSelectedListener(naviListener);
        //开启应用默认打开DrawerLayout
        drawlayout.openDrawer(navigationView);

        //初始化TabLayout的title数据集
        List<String> titles = new ArrayList<>();
        titles.add("details");
        titles.add("share");
        titles.add("agenda");
        //初始化TabLayout的title
        tablayout.addTab(tablayout.newTab().setText(titles.get(0)));
        tablayout.addTab(tablayout.newTab().setText(titles.get(1)));
        tablayout.addTab(tablayout.newTab().setText(titles.get(2)));
        //初始化ViewPager的数据集
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new InfoDetailsFragment());
        fragments.add(new ShareFragment());
        fragments.add(new AgendaFragment());
        //创建ViewPager的adapter
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(adapter);
        //千万别忘了，关联TabLayout与ViewPager
        //同时也要覆写PagerAdapter的getPageTitle方法，否则Tab没有title
        tablayout.setupWithViewPager(viewPager);
        tablayout.setTabsFromPagerAdapter(adapter);
    }

    private NavigationView.OnNavigationItemSelectedListener naviListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem menuItem) {
            //点击NavigationView中定义的menu item时触发反应

            return false;
        }
    };




}
