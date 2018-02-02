package com.tencent.mm.plugin.appbrand;

import android.content.Context;

class t$1 implements Runnable {
    final /* synthetic */ String gIT;
    final /* synthetic */ int iCP;
    final /* synthetic */ t iCQ;
    final /* synthetic */ Context val$context;

    t$1(t tVar, Context context, String str, int i) {
        this.iCQ = tVar;
        this.val$context = context;
        this.gIT = str;
        this.iCP = i;
    }

    public final void run() {
        k.d(this.val$context, this.gIT, this.iCP);
    }
}
