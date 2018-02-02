package com.tencent.mm.au;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.g.a.jq;
import com.tencent.mm.pluginsdk.q$a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.base.i;

public final class a {
    public static boolean aU(Context context) {
        return com.tencent.mm.p.a.aU(context);
    }

    public static boolean Qj() {
        b jqVar = new jq();
        jqVar.fAq.action = 2;
        com.tencent.mm.sdk.b.a.xef.m(jqVar);
        return jqVar.fAr.fAs;
    }

    public static boolean Qk() {
        return q$a.vcw != null && q$a.vcw.aVK();
    }

    public static i a(Context context, int i, Runnable runnable) {
        com.tencent.mm.ui.base.i.a aVar = new com.tencent.mm.ui.base.i.a(context);
        aVar.Ez(R.l.dGO);
        aVar.EA(i);
        aVar.EC(R.l.ewp).a(new 1(runnable));
        aVar.mi(true);
        aVar.d(new 2(runnable));
        i akx = aVar.akx();
        akx.show();
        return akx;
    }
}
