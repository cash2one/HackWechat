package com.tencent.rtmp;

public class TXLivePlayConfig {
    boolean mAutoAdjustCacheTime = true;
    String mCacheFolderPath;
    float mCacheTime = 5.0f;
    int mConnectRetryCount = 3;
    int mConnectRetryInterval = 3;
    boolean mEnableAec = false;
    boolean mEnableNearestIP = true;
    float mMaxAutoAdjustCacheTime = 5.0f;
    int mMaxCacheItems;
    float mMinAutoAdjustCacheTime = 1.0f;
    int mRtmpChannelType = 0;

    public void setCacheTime(float f) {
        this.mCacheTime = f;
    }

    public void setAutoAdjustCacheTime(boolean z) {
        this.mAutoAdjustCacheTime = z;
    }

    public void setMaxAutoAdjustCacheTime(float f) {
        this.mMaxAutoAdjustCacheTime = f;
    }

    public void setMinAutoAdjustCacheTime(float f) {
        this.mMinAutoAdjustCacheTime = f;
    }

    public void setConnectRetryCount(int i) {
        this.mConnectRetryCount = i;
    }

    public void setConnectRetryInterval(int i) {
        this.mConnectRetryInterval = i;
    }

    public void enableAEC(boolean z) {
        this.mEnableAec = z;
    }

    public void setEnableNearestIP(boolean z) {
        this.mEnableNearestIP = z;
    }

    public void setRtmpChannelType(int i) {
        this.mRtmpChannelType = i;
    }

    public void setCacheFolderPath(String str) {
        this.mCacheFolderPath = str;
    }

    public void setMaxCacheItems(int i) {
        this.mMaxCacheItems = i;
    }
}
