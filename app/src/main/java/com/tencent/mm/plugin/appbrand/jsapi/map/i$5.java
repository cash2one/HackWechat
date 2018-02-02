package com.tencent.mm.plugin.appbrand.jsapi.map;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.b.b;
import com.tencent.mm.plugin.appbrand.q.b.b.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u;

class i$5 implements b {
    final /* synthetic */ u.b jeN;
    final /* synthetic */ p jfB;
    final /* synthetic */ int jhi;
    final /* synthetic */ com.tencent.mm.plugin.appbrand.compat.a.b jmc;
    final /* synthetic */ i jmd;

    i$5(i iVar, p pVar, u.b bVar, int i, com.tencent.mm.plugin.appbrand.compat.a.b bVar2) {
        this.jmd = iVar;
        this.jfB = pVar;
        this.jeN = bVar;
        this.jhi = i;
        this.jmc = bVar2;
    }

    public final void a(double d, double d2, a aVar, double d3, double d4, double d5) {
        if (this.jfB.mContext == null || com.tencent.mm.pluginsdk.g.a.aZ(this.jfB.mContext, "android.permission.ACCESS_COARSE_LOCATION")) {
            x.d("MicroMsg.JsApiInsertMap", "refresh location latitude = %f, longitude = %f", new Object[]{Double.valueOf(d), Double.valueOf(d2)});
            ag.y(new 1(this, d, d2));
            return;
        }
        x.e("MicroMsg.JsApiInsertMap", "need gps permission");
    }
}
