package com.tencent.pb.common.b;

import android.os.Handler;
import android.os.Looper;
import com.google.a.a.e;
import com.tencent.pb.common.c.c;

public abstract class d implements c {
    public final String TAG2 = getClass().getSimpleName();
    private final long hno = 60000;
    Runnable hnt = new 1(this);
    boolean kAd = false;
    private int mErrorCode = -999;
    Handler mHandler = new Handler(Looper.getMainLooper());
    public int mYa = 2;
    public boolean zMb = false;
    b zMc = null;
    public byte[] zMd = null;
    public Object zMe = null;
    public int zMf;
    public int zMg = 0;

    public abstract Object bC(byte[] bArr);

    public abstract String cCD();

    public abstract int getType();

    public final void p(int i, byte[] bArr) {
        int i2 = 2;
        c.d("MicroMsg.Voip", this.TAG2, "onResp errcode", Integer.valueOf(i));
        this.mHandler.removeCallbacks(this.hnt);
        c.d("MicroMsg.Voip", "NETTASK_RECV onResp:cmd= ", cCD(), Integer.valueOf(i), Boolean.valueOf(this.kAd));
        if (i != 0) {
            c.m("MicroMsg.Voip", this.TAG2, "getNetworkErrType errcode:" + i);
            if (i != -1) {
                i2 = i == 6801 ? 10 : 4;
            } else if (h.isNetworkConnected()) {
                i2 = 1;
            }
        } else {
            i2 = 0;
        }
        if (this.kAd) {
            c.d("MicroMsg.Voip", "onResp netscene already canceled, cmd:" + this.zMf);
            return;
        }
        if (this.zMb) {
            "".length();
        }
        this.mErrorCode = i;
        this.zMe = bC(bArr);
        this.mHandler.post(new 2(this, i2, i));
    }

    public final void c(int i, e eVar) {
        this.zMf = i;
        byte[] bArr = null;
        try {
            bArr = e.b(eVar);
        } catch (Exception e) {
        }
        this.zMd = bArr;
    }
}
