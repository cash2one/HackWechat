package com.tencent.mm.plugin.favorite.b;

import android.os.SystemClock;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.r;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.HashMap;
import java.util.Map;

public final class d implements e {
    public Map<String, a> mrl = new HashMap();

    static /* synthetic */ void a(a aVar, boolean z) {
        aVar.retryCount--;
        if (aVar.retryCount < 0) {
            if (SystemClock.elapsedRealtime() - aVar.time < 7200000) {
                x.i("MicroMsg.Fav.FavEditService", "try mod item fail time limit, favid %d, localId %d, edit type %d", new Object[]{Integer.valueOf(aVar.mqN), Long.valueOf(aVar.mqO.field_localId), Integer.valueOf(aVar.mqO.field_type)});
                return;
            }
            aVar.time = SystemClock.elapsedRealtime();
            aVar.retryCount = 3;
        }
        if (aVar.mqN <= 0) {
            f db = h.getFavItemInfoStorage().db(aVar.mqO.field_localId);
            if (db == null || db.field_id <= 0) {
                x.w("MicroMsg.Fav.FavEditService", "want to start mod item, but favid is invalid, local id %d", new Object[]{Long.valueOf(aVar.mqO.field_localId)});
                return;
            }
            aVar.mqN = db.field_id;
            x.i("MicroMsg.Fav.FavEditService", "want mod item, find id %d by local id %d", new Object[]{Integer.valueOf(aVar.mqN), Long.valueOf(aVar.mqO.field_localId)});
        } else if (!z) {
            x.w("MicroMsg.Fav.FavEditService", "want to mod item, favid %d, it is running, but not enforce, return", new Object[]{Integer.valueOf(aVar.mqN)});
            return;
        }
        x.i("MicroMsg.Fav.FavEditService", "try mod item, enforce %B, favid %d, edit type %d", new Object[]{Boolean.valueOf(z), Integer.valueOf(aVar.mqN), Integer.valueOf(aVar.mqO.field_type)});
        ar.CG().a(new r(aVar.mqN, aVar.mqO), 0);
    }

    public d() {
        ar.CG().a(426, this);
        ar.CG().a(401, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar != null) {
            x.i("MicroMsg.Fav.FavEditService", "on edit service scene end, errType=%d errCode=%d, %s, scene type %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(kVar.getType())});
            if (kVar.getType() == 401) {
                x.i("MicroMsg.Fav.FavEditService", "on add fav item scene end, try mod item");
                run();
                return;
            }
            r rVar = (r) kVar;
            if (rVar.type == 0) {
                return;
            }
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.Fav.FavEditService", "clear job, key %s", new Object[]{s(rVar.aIV(), rVar.aIW())});
                this.mrl.remove(r0);
                h.aIt().n(rVar.aIV(), rVar.aIW());
                f db = h.getFavItemInfoStorage().db(rVar.aIV());
                if (db != null) {
                    g gVar = g.pQN;
                    Object[] objArr = new Object[4];
                    objArr[0] = Integer.valueOf(db.field_id);
                    objArr[1] = Integer.valueOf(db.field_tagProto.wfj.size());
                    objArr[2] = Integer.valueOf(h.aIq().aIx());
                    objArr[3] = Integer.valueOf(rVar.mqO == null ? 1 : rVar.mqO.field_scene);
                    gVar.h(11122, objArr);
                    return;
                }
                return;
            }
            x.i("MicroMsg.Fav.FavEditService", "retry job, key %s", new Object[]{s(rVar.aIV(), rVar.aIW())});
            a aVar = (a) this.mrl.get(r0);
            if (aVar == null) {
                x.w("MicroMsg.Fav.FavEditService", "want to retry mod item, localid %d, type %d", new Object[]{Long.valueOf(r2), Integer.valueOf(r4)});
            } else {
                ar.Dm().g(new 2(this, aVar), 3000);
            }
        }
    }

    public final void run() {
        ar.Dm().F(new 1(this));
    }

    public static String s(long j, int i) {
        return j + "&&" + i;
    }
}
