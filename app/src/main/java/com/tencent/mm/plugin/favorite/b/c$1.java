package com.tencent.mm.plugin.favorite.b;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.a.o;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements Runnable {
    final /* synthetic */ k flZ;
    final /* synthetic */ int fma;
    final /* synthetic */ c mrk;

    c$1(c cVar, k kVar, int i) {
        this.mrk = cVar;
        this.flZ = kVar;
        this.fma = i;
    }

    public final void run() {
        if (this.flZ.getType() == TencentLocation.ERROR_UNKNOWN && (this.flZ instanceof o)) {
            c.a(this.mrk);
            long j = ((o) this.flZ).mqC.field_localId;
            f fVar = ((o) this.flZ).mqC;
            c.RP().remove(Long.valueOf(j));
            if (this.fma != 0) {
                x.e("MicroMsg.Fav.FavCheckCdnService", "achieved retry limit, set error, localId:%d", Long.valueOf(j));
                g.pQN.h(10659, Integer.valueOf(0), Integer.valueOf(fVar.field_type), Integer.valueOf(-2), Long.valueOf(j.b(fVar)), Long.valueOf(com.tencent.mm.plugin.fav.a.g.cU(fVar.field_localId)));
                h.getFavItemInfoStorage().t(3, j);
            }
            c.b(this.mrk);
        }
    }

    public final String toString() {
        return super.toString() + "|onSceneEnd";
    }
}
