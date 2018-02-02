package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.an;
import com.tencent.mm.plugin.downloader.e.a;

class f$1 implements Runnable {
    final /* synthetic */ a lrK;
    final /* synthetic */ long lrL;
    final /* synthetic */ boolean lrP;
    final /* synthetic */ int lsr;
    final /* synthetic */ f lss;
    final /* synthetic */ Context val$context;

    f$1(f fVar, a aVar, int i, Context context, long j, boolean z) {
        this.lss = fVar;
        this.lrK = aVar;
        this.lsr = i;
        this.val$context = context;
        this.lrL = j;
        this.lrP = z;
    }

    public final void run() {
        new an(this.lrK.field_packageName, this.lsr).a(g.Di().gPJ.hmV, new 1(this));
    }
}
