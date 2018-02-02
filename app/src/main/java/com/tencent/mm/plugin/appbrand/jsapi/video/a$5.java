package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.y;

class a$5 implements a {
    final /* synthetic */ p jdJ;
    final /* synthetic */ int jhi;
    final /* synthetic */ y jkZ;
    final /* synthetic */ a jtn;

    a$5(a aVar, p pVar, int i, y yVar) {
        this.jtn = aVar;
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
