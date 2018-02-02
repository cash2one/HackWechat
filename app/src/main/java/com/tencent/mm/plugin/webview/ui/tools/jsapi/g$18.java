package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class g$18 implements a {
    final /* synthetic */ d mWY;
    final /* synthetic */ g tIj;

    g$18(g gVar, d dVar) {
        this.tIj = gVar;
        this.mWY = dVar;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        x.d("MicroMsg.MsgHandler", "onGYNetEnd oreh errType:%d errCode:%d msg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (!(i == 0 && i2 == 0)) {
            x.i("MicroMsg.MsgHandler", "report oreh logbuffer(13927)");
            g.pQN.h(13927, new Object[]{this.mWY});
            g.pQN.a(457, 0, 1, false);
        }
        return 0;
    }
}
