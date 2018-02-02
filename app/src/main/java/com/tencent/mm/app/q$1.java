package com.tencent.mm.app;

import com.tencent.mm.R;
import com.tencent.mm.g.a.or;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.s;

class q$1 implements a {
    final /* synthetic */ String fgO;
    final /* synthetic */ WXMediaMessage fgT;
    final /* synthetic */ String fgU;
    final /* synthetic */ String fgV;
    final /* synthetic */ MMActivity fgW;
    final /* synthetic */ q fgX;

    q$1(q qVar, WXMediaMessage wXMediaMessage, String str, String str2, String str3, MMActivity mMActivity) {
        this.fgX = qVar;
        this.fgT = wXMediaMessage;
        this.fgU = str;
        this.fgV = str2;
        this.fgO = str3;
        this.fgW = mMActivity;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            l.a(this.fgT, this.fgU, this.fgV, this.fgO, 3, null);
            if (!bh.ov(str)) {
                b orVar = new or();
                orVar.fGI.fGJ = this.fgO;
                orVar.fGI.content = str;
                orVar.fGI.type = s.hp(this.fgO);
                orVar.fGI.flags = 0;
                com.tencent.mm.sdk.b.a.xef.m(orVar);
            }
            h.bu(this.fgW, this.fgW.getResources().getString(R.l.dGG));
            g.pQN.k(10910, "2");
        }
    }
}
