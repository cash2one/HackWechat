package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.a.l;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class g implements e {
    private static Map<Long, a> flP = new HashMap();
    private static Map<Long, Integer> mro = new HashMap();
    private static Set<Long> mrq = new HashSet();
    private Queue<f> flN = new LinkedList();
    public boolean flR = false;
    private boolean flS = false;
    public int flT = 0;
    private long flU = 0;
    public ak flY = new ak(ar.Dm().oAt.getLooper(), new ak.a(this) {
        final /* synthetic */ g mrr;

        {
            this.mrr = r1;
        }

        public final boolean uF() {
            try {
                g.d(this.mrr);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Fav.FavSendService", e, "", new Object[0]);
            }
            return false;
        }

        public final String toString() {
            return super.toString() + "|scenePusher";
        }
    }, false);

    static /* synthetic */ boolean d(g gVar) {
        f fVar;
        x.i("MicroMsg.Fav.FavSendService", "tryStartNetscene");
        gVar.flU = System.currentTimeMillis();
        if (!gVar.flR && gVar.flN.size() == 0) {
            List<f> aIc = h.getFavItemInfoStorage().aIc();
            if (!(aIc == null || aIc.size() == 0)) {
                for (f fVar2 : aIc) {
                    if (mrq.contains(Long.valueOf(fVar2.field_localId))) {
                        x.i("MicroMsg.Fav.FavSendService", "info has existed, id %d, localId %d, sourceType %d, sourceId %s", new Object[]{Integer.valueOf(fVar2.field_id), Long.valueOf(fVar2.field_localId), Integer.valueOf(fVar2.field_sourceType), fVar2.field_sourceId});
                    } else if (flP.containsKey(Long.valueOf(fVar2.field_localId))) {
                        x.i("MicroMsg.Fav.FavSendService", "File is Already running:" + fVar2.field_localId);
                    } else {
                        if (!mro.containsKey(Long.valueOf(fVar2.field_localId))) {
                            mro.put(Long.valueOf(fVar2.field_localId), Integer.valueOf(3));
                        }
                        gVar.flN.add(fVar2);
                        flP.put(Long.valueOf(fVar2.field_localId), null);
                    }
                }
                x.i("MicroMsg.Fav.FavSendService", "klem GetNeedRun procing:" + flP.size() + ",send:" + gVar.flN.size() + "]");
                gVar.flN.size();
            }
        }
        if (gVar.flR || gVar.flN.size() > 0) {
            x.i("MicroMsg.Fav.FavSendService", "Has Data, start service %d", new Object[]{Integer.valueOf(gVar.flN.size())});
            if (!gVar.flR && gVar.flN.size() > 0) {
                fVar2 = (f) gVar.flN.poll();
                if (fVar2 != null && fVar2.field_localId > 0) {
                    gVar.flR = true;
                    ar.CG().a(new l(fVar2), 0);
                    return true;
                }
            }
        }
        gVar.vB();
        x.i("MicroMsg.Fav.FavSendService", "klem No Data Any More , Stop Service");
        return false;
    }

    public g() {
        ar.CG().a(401, this);
    }

    public final void a(final int i, final int i2, String str, final k kVar) {
        x.i("MicroMsg.Fav.FavSendService", "on scene end, errType %d, errCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        ar.Dm().F(new Runnable(this) {
            final /* synthetic */ g mrr;

            public final void run() {
                if (kVar.getType() == 401 && (kVar instanceof l)) {
                    this.mrr.flR = false;
                    f fVar = ((l) kVar).mqv;
                    long j = fVar.field_localId;
                    g.flP.remove(Long.valueOf(j));
                    if ((i == 0 && i2 == 0) || i2 == -400) {
                        g.mrq.add(Long.valueOf(j));
                    }
                    if (!(i == 0 || i2 == -400)) {
                        this.mrr.flT = this.mrr.flT - 1;
                    }
                    Integer valueOf = Integer.valueOf(bh.a((Integer) g.mro.get(Long.valueOf(j)), 0));
                    if (!(i == 1 || i == 0)) {
                        valueOf = Integer.valueOf(valueOf.intValue() - 1);
                        g.mro.put(Long.valueOf(fVar.field_localId), valueOf);
                    }
                    if (valueOf.intValue() <= 0) {
                        int cw = com.tencent.mm.plugin.fav.a.g.cw(i, i2);
                        com.tencent.mm.plugin.report.service.g.pQN.h(10659, new Object[]{Integer.valueOf(0), Integer.valueOf(fVar.field_type), Integer.valueOf(cw), Long.valueOf(j.b(fVar)), Long.valueOf(com.tencent.mm.plugin.fav.a.g.cU(fVar.field_localId))});
                        g.mro.remove(Long.valueOf(j));
                        x.e("MicroMsg.Fav.FavSendService", "achieved retry limit, set error, localId:%d", new Object[]{Long.valueOf(j)});
                        if (fVar.field_itemStatus == 12) {
                            h.getFavItemInfoStorage().t(14, fVar.field_localId);
                        }
                        if (fVar.field_itemStatus == 9) {
                            h.getFavItemInfoStorage().t(11, fVar.field_localId);
                        }
                    }
                    if (this.mrr.flT <= 0) {
                        x.i("MicroMsg.Fav.FavSendService", "klem stopFlag <= 0 , Stop Service");
                        this.mrr.vB();
                    } else if (!g.d(this.mrr)) {
                        j.startSync();
                    }
                }
            }

            public final String toString() {
                return super.toString() + "|onSceneEnd";
            }
        });
    }

    public final void run() {
        ar.Dm().F(new Runnable(this) {
            final /* synthetic */ g mrr;

            {
                this.mrr = r1;
            }

            public final void run() {
                long currentTimeMillis = System.currentTimeMillis() - this.mrr.flU;
                if (this.mrr.flS) {
                    if (currentTimeMillis >= 60000) {
                        x.e("MicroMsg.Fav.FavSendService", "klem ERR: Try Run service runningFlag:" + this.mrr.flS + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + this.mrr.flS);
                    } else {
                        return;
                    }
                }
                this.mrr.flR = false;
                this.mrr.flS = true;
                this.mrr.flT = 3;
                this.mrr.flY.J(10, 10);
            }

            public final String toString() {
                return super.toString() + "|run";
            }
        });
    }

    public final void vB() {
        x.i("MicroMsg.Fav.FavSendService", "on finish");
        this.flN.clear();
        flP.clear();
        this.flS = false;
        this.flR = false;
        mro.clear();
    }
}
