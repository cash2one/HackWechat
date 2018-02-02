package com.tencent.mm.booter.notification.a;

import android.content.Context;
import com.tencent.mm.booter.notification.a.f.a;

public final class g {
    public b gAE;
    public c gAF;
    public d gAG;
    public h gAH;
    private f gAI;
    public a gAJ;
    public int gAK;
    public int gAL;
    public int gAM;
    public int gAN;
    public boolean gAO;
    private int gAP = -1;
    private int gAQ = -1;
    public boolean gAR;
    public boolean gAS;
    public Context mContext;

    public g(Context context) {
        this.mContext = context;
        this.gAE = new b();
        this.gAF = new c();
        this.gAG = new d();
        this.gAH = new h();
        this.gAJ = new a();
        this.gAI = a.xs();
    }

    public final void ew(String str) {
        this.gAI.ev(str);
    }

    public static String a(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        String str = "";
        int length = jArr.length;
        int i = 0;
        while (i < length) {
            i++;
            str = str + String.valueOf(jArr[i]) + ",";
        }
        return !str.isEmpty() ? str.substring(0, str.length() - 1) : str;
    }
}
