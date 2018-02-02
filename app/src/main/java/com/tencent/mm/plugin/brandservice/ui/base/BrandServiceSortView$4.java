package com.tencent.mm.plugin.brandservice.ui.base;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class BrandServiceSortView$4 implements Runnable {
    final /* synthetic */ String gIT;
    final /* synthetic */ BrandServiceSortView kHq;
    final /* synthetic */ int kI;
    final /* synthetic */ Context val$context;

    BrandServiceSortView$4(BrandServiceSortView brandServiceSortView, String str, Context context, int i) {
        this.kHq = brandServiceSortView;
        this.gIT = str;
        this.val$context = context;
        this.kI = i;
    }

    public final void run() {
        d jK = y.Mf().jK(this.gIT);
        ar.Hg();
        ((h) g.h(h.class)).a(jK, (Activity) this.val$context, c.EY().WO(this.gIT), false, new 1(this));
    }
}
