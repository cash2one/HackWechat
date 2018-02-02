package com.tencent.mm.plugin.favorite.a;

import android.os.Message;
import com.tencent.mm.ae.k;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.br;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.protocal.c.vl;
import com.tencent.mm.protocal.c.vm;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.Collection;
import java.util.LinkedList;

class p$a {
    LinkedList<ol> mqJ;
    af mqK = new af(this, ar.Dm().oAt.getLooper()) {
        final /* synthetic */ p$a mqM;

        public final void handleMessage(Message message) {
            if (this.mqM.mqJ == null || this.mqM.mqJ.isEmpty()) {
                k kVar = this.mqM.mqL;
                vl vlVar = (vl) kVar.gJQ.hmg.hmo;
                vm vmVar = (vm) kVar.gJQ.hmh.hmo;
                byte[] g = ad.g(vlVar.vRA.wJD.toByteArray(), vmVar.vRA.wJD.toByteArray());
                if (g != null && g.length > 0) {
                    h.getFavConfigStorage().av(g);
                }
                vlVar.vRA = n.N(g);
                if ((vlVar.vRz & vmVar.vPq) == 0) {
                    x.i("MicroMsg.Fav.NetSceneFavSync", "processEnd, minUpdateTime:%d", new Object[]{Long.valueOf(kVar.mqH)});
                    ar.Hg();
                    c.CU().set(8217, Integer.valueOf(1));
                    if (kVar.mqH > 0) {
                        LinkedList q = h.getFavItemInfoStorage().q(kVar.mqH, -1);
                        if (q.size() > 0) {
                            if (q.size() > 40) {
                                Collection subList = q.subList(0, 40);
                                q = new LinkedList();
                                q.addAll(subList);
                            }
                            kVar.mqI = true;
                            x.i("MicroMsg.Fav.NetSceneFavSync", "processEnd, start batch get list size:%d", new Object[]{Integer.valueOf(q.size())});
                            if (!ar.CG().a(new n(q), 0)) {
                                x.w("MicroMsg.Fav.NetSceneFavSync", "do scene BatchGetFav fail");
                                n.aIT();
                            }
                        }
                    }
                    kVar.gJT.a(0, 0, "", kVar);
                    return;
                }
                x.i("MicroMsg.Fav.NetSceneFavSync", "continue flag:%d", new Object[]{Integer.valueOf(vmVar.vPq)});
                kVar.a(kVar.hmA, kVar.gJT);
                return;
            }
            ol olVar = (ol) this.mqM.mqJ.getFirst();
            x.d("MicroMsg.Fav.NetSceneFavSync", "cmdId = " + olVar.vXp);
            this.mqM.mqJ.removeFirst();
            switch (olVar.vXp) {
                case 200:
                    byte[] a = n.a(olVar.vXq);
                    if (a == null) {
                        x.e("MicroMsg.Fav.NetSceneFavSync", "docmd: no protobuf found.");
                        sendEmptyMessage(0);
                        return;
                    }
                    p pVar = this.mqM.mqL;
                    try {
                        String str = "MicroMsg.Fav.NetSceneFavSync";
                        String str2 = "processAddItem bufSize=%d";
                        Object[] objArr = new Object[1];
                        objArr[0] = Integer.valueOf(a != null ? a.length : 0);
                        x.i(str, str2, objArr);
                        br brVar = (br) new br().aF(a);
                        if (brVar == null) {
                            x.e("MicroMsg.Fav.NetSceneFavSync", "klem processAddItem favitem null");
                        } else {
                            x.i("MicroMsg.Fav.NetSceneFavSync", "klem processAddItem id:%d, flag:%d, updateSeq:%d, updateTime:%d", new Object[]{Integer.valueOf(brVar.vGM), Integer.valueOf(brVar.vGN), Integer.valueOf(brVar.vGP), Integer.valueOf(brVar.vGO)});
                            if ((brVar.vGN & 1) != 0) {
                                j.a(h.getFavItemInfoStorage().dc((long) brVar.vGM), false, null);
                            } else {
                                if (pVar.mqH < 0 || ((long) brVar.vGO) < pVar.mqH) {
                                    pVar.mqH = (long) brVar.vGO;
                                }
                                f dc = h.getFavItemInfoStorage().dc((long) brVar.vGM);
                                Object obj = null;
                                if (dc == null) {
                                    dc = new f();
                                    dc.field_updateTime = ((long) brVar.vGO) * 1000;
                                    obj = 1;
                                }
                                dc.field_id = brVar.vGM;
                                dc.field_updateSeq = brVar.vGP;
                                if (dc.field_localSeq == brVar.vGP) {
                                    dc.field_updateTime = ((long) brVar.vGO) * 1000;
                                }
                                dc.field_flag = brVar.vGN;
                                dc.field_type = brVar.ktN;
                                if (obj != null) {
                                    dc.field_localId = System.currentTimeMillis();
                                    h.getFavItemInfoStorage().f(dc);
                                } else {
                                    h.getFavItemInfoStorage().a(dc, new String[]{"localId"});
                                }
                            }
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.Fav.NetSceneFavSync", e, "", new Object[0]);
                    }
                    sendEmptyMessage(0);
                    return;
                default:
                    return;
            }
        }
    };
    final /* synthetic */ p mqL;

    p$a(p pVar) {
        this.mqL = pVar;
    }
}
