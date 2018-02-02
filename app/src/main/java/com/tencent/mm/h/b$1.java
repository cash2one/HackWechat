package com.tencent.mm.h;

import com.tencent.mm.g.a.ah;
import com.tencent.mm.g.a.ah.a;
import com.tencent.mm.g.a.rs;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.Iterator;

class b$1 extends c<ah> {
    final /* synthetic */ b gBd;

    b$1(b bVar) {
        this.gBd = bVar;
        this.xen = ah.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ah ahVar = (ah) bVar;
        a aVar = ahVar.foi;
        b bVar2;
        long j;
        b$a com_tencent_mm_h_b_a;
        rs rsVar;
        switch (aVar.type) {
            case 1:
                bVar2 = this.gBd;
                String str = aVar.fok;
                j = bh.getLong(str, 0);
                int i = aVar.position;
                x.i("MicroMsg.BroadcastController", "summerdiz cancelUIEvent cancelNoticeIDStr[%s] cancelPosition[%d], oldNoticeInfo[%s] newDisasterNoticeInfoMap[%d] ", new Object[]{str, Integer.valueOf(i), bVar2.gAZ, Integer.valueOf(bVar2.gBb.size())});
                if (bVar2.gBb.size() > 0 && j > 0) {
                    com_tencent_mm_h_b_a = (b$a) bVar2.gBb.get(Long.valueOf(j));
                    if (com_tencent_mm_h_b_a != null) {
                        x.i("MicroMsg.BroadcastController", "summerdiz cancelUIEvent found info[%s]", new Object[]{com_tencent_mm_h_b_a});
                        if (i <= 0) {
                            Collection values = com_tencent_mm_h_b_a.gBj.values();
                            if (values != null) {
                                Iterator it = values.iterator();
                                if (it != null) {
                                    while (it.hasNext()) {
                                        rsVar = (rs) it.next();
                                        if (rsVar != null && rsVar.fJx.visible) {
                                            x.i("MicroMsg.BroadcastController", "summerdiz cancelPosition[%d] found event[%b]", new Object[]{Long.valueOf(j), Boolean.valueOf(rsVar.fJx.visible)});
                                            rsVar.fJx.visible = false;
                                            com.tencent.mm.sdk.b.a.xef.m(rsVar);
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                        rsVar = (rs) com_tencent_mm_h_b_a.gBj.get(Integer.valueOf(i));
                        if (rsVar != null) {
                            x.i("MicroMsg.BroadcastController", "summerdiz cancelPosition[%d] found event[%b]", new Object[]{Integer.valueOf(i), Boolean.valueOf(rsVar.fJx.visible)});
                            if (rsVar.fJx.visible) {
                                rsVar.fJx.visible = false;
                                com.tencent.mm.sdk.b.a.xef.m(rsVar);
                                g.pQN.h(13939, new Object[]{Integer.valueOf(2)});
                                break;
                            }
                        }
                        x.i("MicroMsg.BroadcastController", "summerdiz cancelPosition[%d] not found event", new Object[]{Integer.valueOf(i)});
                    } else {
                        x.i("MicroMsg.BroadcastController", "summerdiz cancelNoticeID not found info");
                    }
                }
                if (bVar2.gAZ != null) {
                    if (!bh.ov(str) && !str.equals(bVar2.gAZ.gBg)) {
                        x.i("MicroMsg.BroadcastController", "summerdiz cancelUIEvent old now:[%s], want to cancel:[%s], drop id", new Object[]{bVar2.gAZ.gBg, str});
                        break;
                    }
                    rsVar = (rs) bVar2.gAZ.gBj.get(Integer.valueOf(0));
                    if (rsVar != null && rsVar.fJx.visible) {
                        g.pQN.h(13939, new Object[]{Integer.valueOf(2)});
                        rsVar.fJx.visible = false;
                        com.tencent.mm.sdk.b.a.xef.m(rsVar);
                        break;
                    }
                }
                break;
            case 2:
                bVar2 = this.gBd;
                int i2 = ahVar.foi.position;
                x.i("MicroMsg.BroadcastController", "summerdiz handlePullNotify position[%d],oldNoticeInfo[%s], positionNoticeIdMap[%d]", new Object[]{Integer.valueOf(i2), bVar2.gAZ, Integer.valueOf(bVar2.gBa.size())});
                if (i2 <= 0 || bVar2.gBa.size() <= 0) {
                    if (bVar2.gAZ != null) {
                        rsVar = (rs) bVar2.gAZ.gBj.get(Integer.valueOf(0));
                        if (rsVar != null) {
                            ahVar.foj.desc = rsVar.fJx.desc;
                            ahVar.foj.fol = rsVar.fJx.fol;
                            ahVar.foj.showType = rsVar.fJx.showType;
                            ahVar.foj.url = rsVar.fJx.url;
                            ahVar.foj.visible = rsVar.fJx.visible;
                            ahVar.foj.foo = rsVar.fJx.foo;
                            ahVar.foj.fom = rsVar.fJx.fom;
                            ahVar.foj.fon = rsVar.fJx.fon;
                            ahVar.foj.fop = rsVar.fJx.fop;
                            ahVar.foj.position = rsVar.fJx.position;
                            if (rsVar.fJx.visible) {
                                g.pQN.h(13936, new Object[]{Integer.valueOf(i2)});
                            }
                            bVar2.xt();
                            break;
                        }
                    }
                }
                j = bh.a((Long) bVar2.gBa.get(Integer.valueOf(i2)), 0);
                x.i("MicroMsg.BroadcastController", "summerdiz handlePullNotify position[%d] found noticeId[%d]", new Object[]{Integer.valueOf(i2), Long.valueOf(j)});
                if (j > 0) {
                    com_tencent_mm_h_b_a = (b$a) bVar2.gBb.get(Long.valueOf(j));
                    if (com_tencent_mm_h_b_a != null) {
                        rsVar = (rs) com_tencent_mm_h_b_a.gBj.get(Integer.valueOf(i2));
                        if (rsVar != null) {
                            ahVar.foj.desc = rsVar.fJx.desc;
                            ahVar.foj.fol = rsVar.fJx.fol;
                            ahVar.foj.showType = rsVar.fJx.showType;
                            ahVar.foj.url = rsVar.fJx.url;
                            ahVar.foj.visible = rsVar.fJx.visible;
                            ahVar.foj.foo = rsVar.fJx.foo;
                            ahVar.foj.fom = rsVar.fJx.fom;
                            ahVar.foj.fon = rsVar.fJx.fon;
                            ahVar.foj.fop = rsVar.fJx.fop;
                            ahVar.foj.position = rsVar.fJx.position;
                            if (rsVar.fJx.visible) {
                                g.pQN.h(13936, new Object[]{Integer.valueOf(i2)});
                                break;
                            }
                        }
                    }
                    bVar2.gBa.remove(Integer.valueOf(i2));
                    break;
                }
                break;
            case 4:
                this.gBd.eB(aVar.fok);
                break;
            case 5:
                this.gBd.a(ahVar);
                break;
        }
        return false;
    }
}
