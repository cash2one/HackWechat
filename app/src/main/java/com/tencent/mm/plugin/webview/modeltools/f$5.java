package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.g.a.ad;
import com.tencent.mm.g.a.ae;
import com.tencent.mm.plugin.webview.ui.tools.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class f$5 extends c<ad> {
    final /* synthetic */ f tuZ;

    f$5(f fVar) {
        this.tuZ = fVar;
        this.xen = ad.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicroMsg.SubCoreTools", "now prepare WebviewKeepBanner, hc:%d, sc:%d", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.tuZ.hashCode())});
        b aeVar = new ae();
        aeVar.fnV.fnX = new h(ac.getContext());
        a.xef.m(aeVar);
        return false;
    }
}
