package com.tencent.mm.plugin.fts.d;

import android.text.TextPaint;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.fts.d.j.b;
import com.tencent.mm.sdk.platformtools.ac;

public final class d$b {
    public static final int mOE = a.aa(ac.getContext(), b.bus);
    public static final TextPaint mOF = new TextPaint();
    public static final int mOG = a.aa(ac.getContext(), b.bvK);
    public static final TextPaint mOH = new TextPaint();
    public static final int mOI = a.aa(ac.getContext(), b.bvs);
    public static final TextPaint mOJ = new TextPaint();
    public static final int mOK = a.aa(ac.getContext(), b.bvU);
    public static final TextPaint mOL = new TextPaint();

    static {
        mOF.setTextSize((float) mOE);
        mOH.setTextSize((float) mOG);
        mOJ.setTextSize((float) mOI);
        mOL.setTextSize((float) mOK);
    }
}
