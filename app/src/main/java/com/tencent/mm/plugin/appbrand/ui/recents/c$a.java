package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.q.d;

class c$a {
    final int jPL;
    final int jPM;
    private final int jPN;
    final int jPO;
    final int jPP;
    final int jPQ;
    final /* synthetic */ c jPR;

    private c$a(c cVar, Context context) {
        this.jPR = cVar;
        this.jPL = c.c(context, 0.7f);
        this.jPM = (int) (((float) a.eA(context)) / 18.0f);
        this.jPN = 0;
        this.jPO = c.c(context, 3.85f);
        this.jPP = a.c(context, d.isz);
        this.jPQ = 2;
    }
}
