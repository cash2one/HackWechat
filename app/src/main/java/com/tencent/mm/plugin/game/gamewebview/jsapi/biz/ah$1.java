package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class ah$1 implements a {
    final /* synthetic */ d mWY;
    final /* synthetic */ ah mWZ;

    ah$1(ah ahVar, d dVar) {
        this.mWZ = ahVar;
        this.mWY = dVar;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        x.d("MicroMsg.GameJsApiOpenWeAppPage", "onGYNetEnd oreh errType:%d errCode:%d msg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (!(i == 0 && i2 == 0)) {
            x.i("MicroMsg.GameJsApiOpenWeAppPage", "report oreh logbuffer(13927)");
            g.pQN.h(13927, this.mWY);
            g.pQN.a(457, 0, 1, false);
        }
        return 0;
    }
}
