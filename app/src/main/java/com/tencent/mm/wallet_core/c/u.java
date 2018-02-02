package com.tencent.mm.wallet_core.c;

import android.content.Context;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.z.q;

public final class u {
    public static int cBC() {
        if (q.Gf()) {
            return i.uVo;
        }
        return i.uzT;
    }

    public static String cBD() {
        if (q.Gf()) {
            return "R";
        }
        if (q.Gg()) {
            return "HK$";
        }
        return "¥";
    }

    public static String gf(Context context) {
        if (q.Gf()) {
            return context.getString(i.uWQ);
        }
        return context.getString(i.uWP);
    }

    public static String gg(Context context) {
        if (q.Gf()) {
            return context.getString(i.uQY);
        }
        return context.getString(i.uQX);
    }

    public static int cBE() {
        if (q.Gf()) {
            return g.uFE;
        }
        return g.uER;
    }

    public static int cBF() {
        if (q.Gf()) {
            return i.uQi;
        }
        return i.uQh;
    }

    public static int cBG() {
        if (q.Gf()) {
            return g.uBF;
        }
        return g.uBE;
    }
}
