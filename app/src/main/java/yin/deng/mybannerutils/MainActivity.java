package yin.deng.mybannerutils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import yin.deng.dybannerutils.mzbanner.MZBannerView;
import yin.deng.dybannerutils.mzbanner.MyBannerUtils;
import yin.deng.dybannerutils.mzbanner.SuperBannerInfo;

public class MainActivity extends AppCompatActivity {
    private MZBannerView banner;
    private List<SuperBannerInfo> superBannerInfos=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banner = (MZBannerView) findViewById(R.id.banner);
        SuperBannerInfo bannerInfo=new SuperBannerInfo();
        bannerInfo.setLinkHtml("");
        bannerInfo.setPicUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1564392187644&di=e89f4f103c06a76d1e71bc1483304501&imgtype=0&src=http%3A%2F%2Fimg2.soyoung.com%2Ftieba%2Fandroid%2Fdiary%2F20181029%2F9%2F377d7e8c5ed8e0027d87d2c060dacbea_570.jpg");
        bannerInfo.setTextTitle("美女啊");
        superBannerInfos.add(bannerInfo);
        superBannerInfos.add(bannerInfo);
        superBannerInfos.add(bannerInfo);
        superBannerInfos.add(bannerInfo);
        MyBannerUtils.getInstance().initBannerUtils(banner, superBannerInfos, new MZBannerView.BannerPageClickListener() {
            @Override
            public void onPageClick(View view, int position) {
                Toast.makeText(MainActivity.this,"点击了第"+position+"个图片",Toast.LENGTH_SHORT).show();
            }
        });
        MyBannerUtils.getInstance().setOnPageSelectedListener(banner, new MyBannerUtils.OnBannerPageSelectedListener() {
            @Override
            public void onBannerPageSelected(int position) {
                Log.i("DYlog","当前选中了第"+position+"个图片");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyBannerUtils.getInstance().startBannerPlay(banner);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MyBannerUtils.getInstance().pauseBannerPlay(banner);
    }
}
