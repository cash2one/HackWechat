package com.tencent.mm.plugin.sns;

import com.tencent.mm.g.a.ev;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class b extends c<ev> {
    public b() {
        this.xen = ev.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        ev evVar = (ev) bVar;
        if (!(evVar instanceof ev)) {
            x.f("MicroMsg.ExtGetSnsDataEventListener", "mismatched event");
            return false;
        } else if (evVar.ftx.ftz == null) {
            return false;
        } else {
            m mVar = new m();
            mVar.b(evVar.ftx.ftz);
            if (mVar.roJ <= 0) {
                x.e("MicroMsg.ExtGetSnsDataEventListener", "sns == null || sns.getLocalid()<=0");
                return false;
            }
            bnp bxV = mVar.bxV();
            evVar.fty.ftE = 0;
            evVar.fty.ftI = 0;
            evVar.fty.ftJ = 0;
            evVar.fty.ftG = new LinkedList();
            evVar.fty.ftH = new LinkedList();
            if (bxV.wQo != null) {
                evVar.fty.ftE = bxV.wQo.vYc;
                if (bxV.wQo.vYc != 1 && bxV.wQo.vYc != 7 && bxV.wQo.vYc != 8) {
                    evVar.fty.ftG.add(bxV.wQo.nfX);
                } else if (bxV.wQo.vYd != null) {
                    int i = 0;
                    while (i < bxV.wQo.vYd.size()) {
                        List list = evVar.fty.ftG;
                        ae.bvs();
                        list.add(g.r((aqr) bxV.wQo.vYd.get(i)));
                        list = evVar.fty.ftH;
                        ae.bvs();
                        list.add(g.s((aqr) bxV.wQo.vYd.get(i)));
                        if (i == 0 && bxV.wQo.vYd.get(i) != null) {
                            evVar.fty.ftI = (int) ((aqr) bxV.wQo.vYd.get(i)).wxH.wyu;
                            evVar.fty.ftJ = (int) ((aqr) bxV.wQo.vYd.get(i)).wxH.wyv;
                        }
                        i++;
                    }
                }
            }
            evVar.fty.ftF = evVar.fty.ftG.size();
            evVar.fty.ftB = mVar.roJ;
            evVar.fty.ftA = mVar.field_userName;
            evVar.fty.ftC = bxV.wQl;
            evVar.fty.ftD = (long) bxV.pbl;
            return true;
        }
    }
}
