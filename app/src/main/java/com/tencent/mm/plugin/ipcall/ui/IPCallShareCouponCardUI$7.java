package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.R;
import com.tencent.mm.g.a.or;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.g;
import com.tencent.mm.z.s;

class IPCallShareCouponCardUI$7 implements a {
    final /* synthetic */ String hpU;
    final /* synthetic */ IPCallShareCouponCardUI nMs;

    IPCallShareCouponCardUI$7(IPCallShareCouponCardUI iPCallShareCouponCardUI, String str) {
        this.nMs = iPCallShareCouponCardUI;
        this.hpU = str;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            g.a aVar = new g.a();
            aVar.title = IPCallShareCouponCardUI.d(this.nMs);
            aVar.url = IPCallShareCouponCardUI.e(this.nMs);
            aVar.description = IPCallShareCouponCardUI.f(this.nMs);
            aVar.thumburl = IPCallShareCouponCardUI.g(this.nMs);
            aVar.type = 5;
            l.a(aVar, null, null, this.hpU, "", null, null);
            if (!bh.ov(str)) {
                b orVar = new or();
                orVar.fGI.fGJ = this.hpU;
                orVar.fGI.content = str;
                orVar.fGI.type = s.hp(this.hpU);
                orVar.fGI.flags = 0;
                com.tencent.mm.sdk.b.a.xef.m(orVar);
            }
            h.bu(this.nMs.mController.xIM, this.nMs.getResources().getString(R.l.dGG));
        }
    }
}
