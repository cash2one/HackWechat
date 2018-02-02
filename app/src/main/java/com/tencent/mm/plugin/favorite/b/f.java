package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.ae.e;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.a.k;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.protocal.c.aru;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.vh;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class f implements e {
    private static Map<Integer, a> flP = new HashMap();
    private static Map<Integer, Integer> mro = new HashMap();
    private Queue<com.tencent.mm.plugin.fav.a.f> flN = new LinkedList();
    private boolean flR = false;
    private boolean flS = false;
    public int flT = 0;
    private long flU = 0;
    public ak flY = new ak(ar.Dm().oAt.getLooper(), new ak.a(this) {
        final /* synthetic */ f mrp;

        {
            this.mrp = r1;
        }

        public final boolean uF() {
            try {
                f.d(this.mrp);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Fav.FavModService", e, "", new Object[0]);
            }
            return false;
        }

        public final String toString() {
            return super.toString() + "|scenePusher";
        }
    }, false);

    static /* synthetic */ void D(com.tencent.mm.plugin.fav.a.f fVar) {
        vh vhVar = new vh();
        StringBuffer stringBuffer = new StringBuffer();
        vhVar.vGM = fVar.field_id;
        stringBuffer.append("favid:" + fVar.field_id);
        vhVar.weX = new LinkedList();
        Iterator it = fVar.field_favProto.weU.iterator();
        while (it.hasNext()) {
            uq uqVar = (uq) it.next();
            if (uqVar.wdV != 0) {
                vx vxVar = new vx();
                if (uqVar.wdV > 0) {
                    vxVar.vVg = uqVar.mvG;
                    vxVar.vVm = 0;
                    vxVar.ktm = uqVar.wdV;
                } else {
                    vxVar.vVg = uqVar.mvG;
                    vxVar.vVm = 1;
                    vxVar.ktm = -uqVar.wdV;
                }
                stringBuffer.append(" fileId:" + vxVar.vVg + " IsThumb:" + vxVar.vVm + " status:" + vxVar.ktm);
                vhVar.weX.add(vxVar);
                uqVar.CM(0);
            }
        }
        x.i("MicroMsg.Fav.FavModService", "checkFavItem %s", new Object[]{stringBuffer.toString()});
        if (vhVar.weX.size() > 0) {
            ((r) g.k(r.class)).checkFavItem(vhVar);
        }
    }

    static /* synthetic */ boolean d(f fVar) {
        fVar.flU = System.currentTimeMillis();
        if (!fVar.flR && fVar.flN.size() == 0) {
            List<com.tencent.mm.plugin.fav.a.f> aId = h.getFavItemInfoStorage().aId();
            if (!(aId == null || aId.size() == 0)) {
                for (com.tencent.mm.plugin.fav.a.f fVar2 : aId) {
                    if (flP.containsKey(Integer.valueOf(fVar2.field_id))) {
                        x.i("MicroMsg.Fav.FavModService", "File is Already running:" + fVar2.field_id);
                    } else {
                        if (!mro.containsKey(Integer.valueOf(fVar2.field_id))) {
                            mro.put(Integer.valueOf(fVar2.field_id), Integer.valueOf(3));
                        }
                        fVar.flN.add(fVar2);
                        flP.put(Integer.valueOf(fVar2.field_id), null);
                    }
                }
                x.i("MicroMsg.Fav.FavModService", "klem GetNeedRun procing:" + flP.size() + ",send:" + fVar.flN.size() + "]");
                fVar.flN.size();
            }
        }
        if (!fVar.flR && fVar.flN.size() <= 0) {
            fVar.vB();
            x.i("MicroMsg.Fav.FavModService", "klem No Data Any More , Stop Service");
            return false;
        } else if (fVar.flR || fVar.flN.size() <= 0) {
            return false;
        } else {
            com.tencent.mm.plugin.fav.a.f fVar3 = (com.tencent.mm.plugin.fav.a.f) fVar.flN.poll();
            if (fVar3 == null || fVar3.field_id <= 0) {
                return false;
            }
            fVar.flR = true;
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            if (fVar3.aHR()) {
                x.i("MicroMsg.Fav.FavModService", "Resend Item %d", new Object[]{Long.valueOf(fVar3.field_localId)});
                ar.CG().a(new com.tencent.mm.plugin.favorite.a.r(fVar3.field_id, linkedList, linkedList2, com.tencent.mm.plugin.fav.a.f.c(fVar3), (byte) 0), 0);
            } else if (fVar3.field_type != 18) {
                k.a(fVar3.field_localId, linkedList, linkedList2);
                ar.CG().a(new com.tencent.mm.plugin.favorite.a.r(fVar3.field_id, linkedList, linkedList2), 0);
            } else {
                aru com_tencent_mm_protocal_c_aru = new aru();
                com_tencent_mm_protocal_c_aru.wzz = 1;
                com_tencent_mm_protocal_c_aru.wzA = (int) bh.Wo();
                linkedList.add(com_tencent_mm_protocal_c_aru);
                ar.CG().a(new com.tencent.mm.plugin.favorite.a.r(fVar3.field_id, linkedList, linkedList2, com.tencent.mm.plugin.fav.a.f.c(fVar3)), 0);
            }
            return true;
        }
    }

    public f() {
        ar.CG().a(426, this);
    }

    public final void a(final int i, final int i2, String str, final com.tencent.mm.ae.k kVar) {
        if (kVar.getType() == 426 && (kVar instanceof com.tencent.mm.plugin.favorite.a.r)) {
            ar.Dm().F(new Runnable(this) {
                final /* synthetic */ f mrp;

                public final void run() {
                    this.mrp.flR = false;
                    int i = ((com.tencent.mm.plugin.favorite.a.r) kVar).mqN;
                    f.flP.remove(Integer.valueOf(i));
                    if (!(i2 == 3 && i2 == 0)) {
                        this.mrp.flT = this.mrp.flT - 1;
                    }
                    com.tencent.mm.plugin.fav.a.f dc = h.getFavItemInfoStorage().dc((long) i);
                    if (dc != null && dc.field_itemStatus != 10) {
                        if (i != 0 || i2 != 0) {
                            Integer valueOf = Integer.valueOf(bh.a((Integer) f.mro.get(Integer.valueOf(i)), 0));
                            if (!(i == 1 || i == 0)) {
                                valueOf = Integer.valueOf(valueOf.intValue() - 1);
                            }
                            if (valueOf.intValue() <= 0) {
                                int cw = com.tencent.mm.plugin.fav.a.g.cw(i, i2);
                                com.tencent.mm.plugin.report.service.g.pQN.h(10659, new Object[]{Integer.valueOf(0), Integer.valueOf(dc.field_type), Integer.valueOf(cw), Long.valueOf(b.b(dc)), Long.valueOf(com.tencent.mm.plugin.fav.a.g.cU(dc.field_localId))});
                                f.mro.remove(Integer.valueOf(i));
                                x.e("MicroMsg.Fav.FavModService", "achieved retry limit, set error, favId:%d", new Object[]{Integer.valueOf(i)});
                                dc.field_itemStatus = 18;
                                h.getFavItemInfoStorage().a(dc, new String[]{"localId"});
                            }
                        } else if (dc.field_itemStatus == 17) {
                            com.tencent.mm.plugin.report.service.g.pQN.h(10659, new Object[]{Integer.valueOf(0), Integer.valueOf(dc.field_type), Integer.valueOf(0), Long.valueOf(b.b(dc)), Long.valueOf(com.tencent.mm.plugin.fav.a.g.cU(dc.field_localId))});
                            x.i("MicroMsg.Fav.FavModService", "mod end set status done. favId:%d", new Object[]{Integer.valueOf(dc.field_id)});
                            dc.field_itemStatus = 10;
                            f.D(dc);
                            h.getFavItemInfoStorage().a(dc, new String[]{"localId"});
                            h.aIs().cY(dc.field_localId);
                        }
                        if (this.mrp.flT <= 0) {
                            x.i("MicroMsg.Fav.FavModService", "klem stopFlag <= 0 , Stop Service");
                            this.mrp.vB();
                        } else if (!f.d(this.mrp)) {
                            j.startSync();
                        }
                    }
                }

                public final String toString() {
                    return super.toString() + "|onSceneEnd";
                }
            });
        }
    }

    public final void run() {
        ar.Dm().F(new Runnable(this) {
            final /* synthetic */ f mrp;

            {
                this.mrp = r1;
            }

            public final void run() {
                long currentTimeMillis = System.currentTimeMillis() - this.mrp.flU;
                if (this.mrp.flS) {
                    if (currentTimeMillis >= 60000) {
                        x.e("MicroMsg.Fav.FavModService", "klem ERR: Try Run service runningFlag:" + this.mrp.flS + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + this.mrp.flS);
                    } else {
                        return;
                    }
                }
                this.mrp.flR = false;
                this.mrp.flS = true;
                this.mrp.flT = 3;
                this.mrp.flY.J(10, 10);
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
        mro.clear();
    }
}
