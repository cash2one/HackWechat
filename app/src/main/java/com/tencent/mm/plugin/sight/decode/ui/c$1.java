package com.tencent.mm.plugin.sight.decode.ui;

import android.util.Base64;
import com.tencent.mm.aq.o;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    final /* synthetic */ c quU;

    c$1(c cVar) {
        this.quU = cVar;
    }

    public final void hX() {
        x.d("MicroMsg.VideoPopupHelper", g.zg() + " onPrepared");
        c.a(this.quU);
    }

    public final void onError(int i, int i2) {
        x.e("MicroMsg.VideoPopupHelper", "on play video error, what %d extra %d", Integer.valueOf(i), Integer.valueOf(i2));
        c.b(this.quU).stop();
        b.z(Base64.encodeToString((d.bsC() + "[SightPopupHelper] on play video error, what " + i + " extra " + i2 + ", path=" + bh.az(c.c(this.quU), "")).getBytes(), 2), "FullScreenPlaySight");
        String c = c.c(this.quU);
        ag.y(new 1(this, o.Pw().a(c, com.tencent.mm.bv.a.getDensity(this.quU.getContext()), this.quU.getContext(), -1), c));
    }

    public final void vh() {
        x.d("MicroMsg.VideoPopupHelper", "on completion");
        c.d(this.quU).post(new 2(this));
        c.b(this.quU).cP(true);
        c.a(this.quU);
    }

    public final int cf(int i, int i2) {
        return 0;
    }

    public final void cg(int i, int i2) {
    }
}
