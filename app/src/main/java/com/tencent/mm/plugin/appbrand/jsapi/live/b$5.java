package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.y;

class b$5 implements a {
    final /* synthetic */ p jdJ;
    final /* synthetic */ int jhi;
    final /* synthetic */ b jkW;
    final /* synthetic */ y jkZ;

    b$5(b bVar, p pVar, int i, y yVar) {
        this.jkW = bVar;
        this.jdJ = pVar;
        this.jhi = i;
        this.jkZ = yVar;
    }

    public final void kz(int i) {
        this.jdJ.aeF().a(this.jhi, this.jkZ, i);
    }

    public final void ags() {
        this.jdJ.aeF().lr(this.jhi);
    }

    public final boolean isFullScreen() {
        return this.jdJ.aeF().lq(this.jhi);
    }
}
