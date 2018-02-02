package com.tencent.mm.plugin.favorite.b;

import android.os.SystemClock;
import com.tencent.mm.plugin.fav.a.e;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class d$1 implements Runnable {
    final /* synthetic */ d mrm;

    d$1(d dVar) {
        this.mrm = dVar;
    }

    public final void run() {
        List<e> aHX = h.aIt().aHX();
        if (aHX != null) {
            x.i("MicroMsg.Fav.FavEditService", "infos size %d", Integer.valueOf(aHX.size()));
            for (e eVar : aHX) {
                String s = d.s(eVar.field_localId, eVar.field_type);
                d$a com_tencent_mm_plugin_favorite_b_d_a = (d$a) this.mrm.mrl.get(s);
                if (com_tencent_mm_plugin_favorite_b_d_a == null) {
                    x.i("MicroMsg.Fav.FavEditService", "not match key %s", s);
                    com_tencent_mm_plugin_favorite_b_d_a = new d$a();
                    com_tencent_mm_plugin_favorite_b_d_a.mqO = eVar;
                    com_tencent_mm_plugin_favorite_b_d_a.retryCount = 3;
                    com_tencent_mm_plugin_favorite_b_d_a.time = SystemClock.elapsedRealtime();
                    this.mrm.mrl.put(s, com_tencent_mm_plugin_favorite_b_d_a);
                    d.a(com_tencent_mm_plugin_favorite_b_d_a, true);
                } else {
                    x.i("MicroMsg.Fav.FavEditService", "match key %s, check start", s);
                    d.a(com_tencent_mm_plugin_favorite_b_d_a, false);
                }
            }
        }
    }

    public final String toString() {
        return super.toString() + "|run";
    }
}
