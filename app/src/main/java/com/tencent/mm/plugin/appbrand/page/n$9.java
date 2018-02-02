package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.sdk.platformtools.x;

class n$9 implements Runnable {
    final /* synthetic */ n jDp;

    n$9(n nVar) {
        this.jDp = nVar;
    }

    public final void run() {
        if (n.d(this.jDp) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            p pVar = new p();
            pVar.a(this.jDp.getContext(), n.e(this.jDp));
            pVar.hide();
            this.jDp.addView(pVar.getContentView(), 0);
            n.a(this.jDp, pVar);
            x.i("MicroMsg.AppBrandPageContainer", "preloadNextPageView: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        }
    }
}
