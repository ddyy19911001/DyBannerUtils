package yin.deng.dybannerutils.mzbanner;


import java.io.Serializable;

public class SuperBannerInfo implements Serializable {
    private String linkHtml;
    private String picUrl;
    private String textTitle;
    private int resPic;

    public int getResPic() {
        return resPic;
    }

    public void setResPic(int resPic) {
        this.resPic = resPic;
    }

    public String getLinkHtml() {
        return linkHtml;
    }

    public void setLinkHtml(String linkHtml) {
        this.linkHtml = linkHtml;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }
}
