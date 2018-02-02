package com.tencent.mm.plugin.favorite.b;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.o;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class c implements e {
    private static Map<Long, a> flP = new HashMap();
    private Queue<f> flN = new LinkedList();
    private boolean flR = false;
    private boolean flS = false;
    private long flU = 0;
    public ak flY = new ak(ar.Dm().oAt.getLooper(), new 4(this), false);
    public n hsr = new n.a(this) {
        final /* synthetic */ c mrk;

        {
            this.mrk = r1;
        }

        public final void eq(int i) {
            try {
                boolean isWifi = an.isWifi(ac.getContext());
                if (i == 4 || i == 6) {
                    x.i("MicroMsg.Fav.FavCheckCdnService", "onNetworkChange st:%d isWifi:%B, lastIsWifi:%B", new Object[]{Integer.valueOf(i), Boolean.valueOf(isWifi), Boolean.valueOf(this.mrk.mrc)});
                    if (!this.mrk.mrc && isWifi) {
                        c cVar = this.mrk;
                        List<f> aIa = h.getFavItemInfoStorage().aIa();
                        if (aIa == null || aIa.size() <= 0) {
                            x.i("MicroMsg.Fav.FavCheckCdnService", "startAll list.size 0");
                        } else {
                            x.i("MicroMsg.Fav.FavCheckCdnService", "startAll list.size:%d", new Object[]{Integer.valueOf(aIa.size())});
                            for (f fVar : aIa) {
                                if (fVar.field_itemStatus == 3) {
                                    fVar.field_itemStatus = 1;
                                    h.getFavItemInfoStorage().a(fVar, new String[]{"localId"});
                                }
                            }
                            cVar.run();
                        }
                    }
                    this.mrk.mrc = isWifi;
                    return;
                }
                this.mrk.mrc = isWifi;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Fav.FavCheckCdnService", e, "", new Object[0]);
            }
        }
    };
    private boolean mrc = an.isWifi(ac.getContext());

    static /* synthetic */ void b(c cVar) {
        cVar.flU = System.currentTimeMillis();
        if (!cVar.flR && cVar.flN.size() == 0) {
            List<f> aIb = h.getFavItemInfoStorage().aIb();
            if (!(aIb == null || aIb.size() == 0)) {
                for (f fVar : aIb) {
                    f fVar2;
                    if (flP.containsKey(Long.valueOf(fVar2.field_localId))) {
                        x.d("MicroMsg.Fav.FavCheckCdnService", "File is Already running:" + fVar2.field_localId);
                    } else {
                        cVar.flN.add(fVar2);
                        flP.put(Long.valueOf(fVar2.field_localId), null);
                    }
                }
                x.i("MicroMsg.Fav.FavCheckCdnService", "klem GetNeedRun procing:" + flP.size() + ",send:" + cVar.flN.size() + "]");
                cVar.flN.size();
            }
        }
        if (!cVar.flR && cVar.flN.size() <= 0) {
            cVar.vB();
            x.i("MicroMsg.Fav.FavCheckCdnService", "klem No Data Any More , Stop Service");
        } else if (!cVar.flR && cVar.flN.size() > 0) {
            fVar2 = (f) cVar.flN.poll();
            if (fVar2 != null && fVar2.field_localId > 0) {
                cVar.flR = true;
                ar.CG().a(new o(fVar2), 0);
            }
        }
    }

    public c() {
        ar.a(this.hsr);
        ar.CG().a(TencentLocation.ERROR_UNKNOWN, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        ar.Dm().F(new 1(this, kVar, i));
    }

    public final void run() {
        ar.Dm().F(new Runnable(this) {
            final /* synthetic */ c mrk;

            {
                this.mrk = r1;
            }

            public final void run() {
                long currentTimeMillis = System.currentTimeMillis() - this.mrk.flU;
                if (this.mrk.flS) {
                    if (currentTimeMillis >= 60000) {
                        x.e("MicroMsg.Fav.FavCheckCdnService", "klem ERR: Try Run service runningFlag:" + this.mrk.flS + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + this.mrk.flS);
                    } else {
                        return;
                    }
                }
                this.mrk.flR = false;
                this.mrk.flS = true;
                this.mrk.flY.J(10, 10);
            }

            public final String toString() {
                return super.toString() + "|run";
            }
        });
    }

    public final void vB() {
        this.flN.clear();
        flP.clear();
        this.flS = false;
        this.flR = false;
    }
}
