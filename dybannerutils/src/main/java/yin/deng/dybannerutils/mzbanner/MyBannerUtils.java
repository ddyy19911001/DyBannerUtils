package yin.deng.dybannerutils.mzbanner;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import yin.deng.dybannerutils.R;
import yin.deng.dybannerutils.mzbanner.holder.MZHolderCreator;
import yin.deng.dybannerutils.mzbanner.holder.MZViewHolder;


public class MyBannerUtils  {
    private static  int DElAY_TIME = 4000;
    private static  int SPEED_TIME_OF_ANIMATE = 1000;
    private static MyBannerUtils utils;
    private int paddingBottom=15;

    private MyBannerUtils() {
    }

    public void setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
    }

    public static MyBannerUtils getInstance(){
        if(utils==null){
            utils=new MyBannerUtils();
        }
        return utils;
    }

    /**
     * 在Activity的OnResume中调用
     * @param bannerView
     */
    public void startBannerPlay(MZBannerView bannerView){
        if(bannerView!=null){
            bannerView.start();
        }
    }

    /**
     * 在Activity中的OnPause中调用
     * @param bannerView
     */
    public void pauseBannerPlay(MZBannerView bannerView){
        if(bannerView!=null){
            bannerView.pause();
        }
    }

    public void setDElAY_TIME(int dElAY_time){
        DElAY_TIME=dElAY_time;
    }

    public void setSPEED_TIME_OF_ANIMATE(int speed_time_of_animate){
        SPEED_TIME_OF_ANIMATE=speed_time_of_animate;
    }

    public  MyBannerUtils initBannerUtils(MZBannerView mMZBanner, List<SuperBannerInfo> datas) {
            mMZBanner.setIndicatorAlign(MZBannerView.IndicatorAlign.CENTER);
            mMZBanner.setIndicatorPadding(0,0,0,paddingBottom);
            mMZBanner.setCanLoop(true);
            mMZBanner.setDelayedTime(DElAY_TIME);
            mMZBanner.setDuration(SPEED_TIME_OF_ANIMATE);
            mMZBanner.setIndicatorVisible(true);
            mMZBanner.setPages(datas, new MZHolderCreator<BannerViewHolder>() {
                @Override
                public BannerViewHolder createViewHolder() {
                    return new BannerViewHolder();
                }
            });
            mMZBanner.start();
        return utils;
    }

    public  MyBannerUtils initBannerUtils(MZBannerView mMZBanner, List<SuperBannerInfo> datas, MZBannerView.BannerPageClickListener listener) {
        mMZBanner.setIndicatorAlign(MZBannerView.IndicatorAlign.CENTER);
        mMZBanner.setIndicatorPadding(0,0,0,paddingBottom);
        mMZBanner.setCanLoop(true);
        mMZBanner.setDelayedTime(DElAY_TIME);
        mMZBanner.setDuration(SPEED_TIME_OF_ANIMATE);
        mMZBanner.setIndicatorVisible(true);
        mMZBanner.setBannerPageClickListener(listener);
        mMZBanner.setPages(datas, new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });
        mMZBanner.start();
        return utils;
    }

    public  <T>MyBannerUtils initBannerUtils(MZBannerView mMZBanner, List<T> datas, MZBannerView.BannerPageClickListener listener, MZHolderCreator creator) {
        mMZBanner.setIndicatorAlign(MZBannerView.IndicatorAlign.CENTER);
        mMZBanner.setIndicatorPadding(0,0,0,paddingBottom);
        mMZBanner.setCanLoop(true);
        mMZBanner.setDelayedTime(DElAY_TIME);
        mMZBanner.setDuration(SPEED_TIME_OF_ANIMATE);
        mMZBanner.setIndicatorVisible(true);
        mMZBanner.setBannerPageClickListener(listener);
        mMZBanner.setPages(datas, creator);
        mMZBanner.start();
        return utils;
    }


    public static class BannerViewHolder implements MZViewHolder<SuperBannerInfo> {
        private ImageView mImageView;
        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item,null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, SuperBannerInfo data) {
            if(data.getResPic()!=0) {
                // 数据绑定
                mImageView.setImageResource(data.getResPic());
            }else if(!TextUtils.isEmpty(data.getPicUrl())){
                PicassoUtils.getinstance().LoadImage(context,data.getPicUrl(),mImageView,R.drawable.image_replace,R.drawable.image_replace,PicassoUtils.PICASSO_BITMAP_SHOW_NORMAL_TYPE,0);

            }
        }
    }
}
