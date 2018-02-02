package com.tencent.mm.plugin.fts.d.a;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.sdk.platformtools.x;

public abstract class b {
    public String info;
    public final int kTK;
    public e mMb;
    public int mOz;
    public String mPA;
    public long mPB;
    public boolean mPC;
    public int mPD;
    public int mPE;
    public boolean mPF;
    public boolean mPv;
    public boolean mPw = true;
    public int mPx;
    public int mPy;
    public int mPz;
    public int pageType;
    public final int position;

    public abstract void a(Context context, a aVar, Object... objArr);

    public abstract b adp();

    public abstract a adq();

    public b(int i, int i2) {
        this.kTK = i;
        this.position = i2;
        x.v("MicroMsg.FTS.FTSDataItem", "create data item | viewType=%d | position=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final void cC(int i, int i2) {
        this.mPD = i;
        this.mPE = i2;
        this.mPF = true;
    }

    public int ads() {
        return 0;
    }

    public String adr() {
        return "";
    }

    public int aNy() {
        return 0;
    }

    public boolean aNz() {
        return false;
    }

    public int aNA() {
        return 0;
    }
}
