package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class SnsTimeLineUI$4 extends c<f> {
    final /* synthetic */ SnsTimeLineUI rIN;

    SnsTimeLineUI$4(SnsTimeLineUI snsTimeLineUI) {
        this.rIN = snsTimeLineUI;
        this.xen = f.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = true;
        f fVar = (f) bVar;
        if (!(SnsTimeLineUI.g(this.rIN) == null || SnsTimeLineUI.g(this.rIN).rrt == null)) {
            com.tencent.mm.plugin.sns.h.b bVar2 = SnsTimeLineUI.g(this.rIN).rrt.qWT;
            boolean z2 = fVar.fmS.ahf;
            String str = fVar.fmS.className;
            if (str.toLowerCase().indexOf("sns") < 0 && str.toLowerCase().indexOf("sightuploadui") < 0 && !str.contains("WebViewUI")) {
                z = false;
            }
            if (!z) {
                x.d("MicroMsg.SnsBrowseInfoHelper", "handleActivityStatusChanged, not sns scene, className" + str + ",_active=" + z2);
            } else if (!z2) {
                bVar2.rce = System.currentTimeMillis();
            } else if (bVar2.rce > 0) {
                bVar2.rcd += System.currentTimeMillis() - bVar2.rce;
                bVar2.rce = 0;
            }
        }
        return false;
    }
}
