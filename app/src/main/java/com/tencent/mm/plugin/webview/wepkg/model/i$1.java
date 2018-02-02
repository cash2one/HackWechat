package com.tencent.mm.plugin.webview.wepkg.model;

class i$1 extends a {
    final /* synthetic */ String tMB;
    final /* synthetic */ boolean tNy;
    final /* synthetic */ i tNz;

    i$1(i iVar, boolean z, String str) {
        this.tNz = iVar;
        this.tNy = z;
        this.tMB = str;
    }

    public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
        if (this.object instanceof String) {
            i.a(this.tNz, (String) this.object, this.tNy);
        } else {
            i.l(this.tNy, this.tMB);
        }
    }
}
