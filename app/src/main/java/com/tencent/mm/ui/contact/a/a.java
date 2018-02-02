package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.text.TextPaint;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.x;

public abstract class a {
    public static final int mOG = com.tencent.mm.bv.a.aa(ac.getContext(), c.bvK);
    public static final TextPaint mOH = new TextPaint();
    public static final int mOI = com.tencent.mm.bv.a.aa(ac.getContext(), c.bvs);
    public static final TextPaint mOJ = new TextPaint();
    public String fDj;
    public String fpF;
    public x jLe;
    public boolean kFO;
    public final int kTK;
    public e mMb;
    public int mPD;
    public int mPE;
    public int mPy;
    public final int position;
    public boolean rVq;
    public int scene;
    public boolean ySW;
    public boolean ySX;
    public boolean yVa;
    boolean yVb;
    public boolean yVc;

    public abstract b WQ();

    public abstract a WR();

    public abstract void bH(Context context);

    static {
        mOH.setTextSize((float) mOG);
        mOJ.setTextSize((float) mOI);
    }

    public a(int i, int i2) {
        this.kTK = i;
        this.position = i2;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BaseContactDataItem", "Create BaseContactDataItem viewType=%d | position=%d", Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final void cC(int i, int i2) {
        this.mPD = i;
        this.mPE = i2;
    }

    public boolean aNz() {
        return false;
    }
}
