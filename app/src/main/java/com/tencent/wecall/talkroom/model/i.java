package com.tencent.wecall.talkroom.model;

import com.tencent.pb.common.c.c;

public final class i {
    public int Aph;
    public int Api;
    public int Apj;
    public int Apk;
    public int Apl;
    public int Apm;
    public int Apn;
    public int Apo;
    public int App;
    public int mHeight;
    public int mWidth;
    public int mYa;

    public i(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        this.Aph = i;
        this.mWidth = i2;
        this.mHeight = i3;
        this.Api = i4;
        this.Apj = i5;
        this.Apk = i6;
        this.Apl = i7;
        this.mYa = i8;
        this.Apm = i9;
        this.Apn = i10;
        this.Apo = i11;
        this.App = i12;
        c.d("VoiceEngineConf", new Object[]{"mDisableVideo: ", Integer.valueOf(i), " mWidth: ", Integer.valueOf(i2), " mHeight: ", Integer.valueOf(i3), " mInFPS: ", Integer.valueOf(i4), " mOutFmt: ", Integer.valueOf(i5), " mOSType: ", Integer.valueOf(i6), " mNetKbps: ", Integer.valueOf(i7), " mNetType: ", Integer.valueOf(i8), " mMTUSize: ", Integer.valueOf(i9), " mCPUFlag: ", Integer.valueOf(i10), " mDispRate: ", Integer.valueOf(i11), " mVCodecType: ", Integer.valueOf(i12)});
    }
}
