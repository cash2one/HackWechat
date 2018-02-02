package com.tencent.mm.plugin.shake.d.a;

import android.content.Context;
import com.tencent.mm.plugin.shake.b.d;

class k$1 implements Runnable {
    final /* synthetic */ d qpW;
    final /* synthetic */ Context val$context;

    public k$1(d dVar, Context context) {
        this.qpW = dVar;
        this.val$context = context;
    }

    public final void run() {
        k.a(this.qpW, this.val$context, false);
    }
}
