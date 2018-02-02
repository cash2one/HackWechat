package com.tencent.mm.plugin.collect.a;

import com.tencent.mm.ae.d;
import com.tencent.mm.g.a.br;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.collect.b.t;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bs.a;
import java.util.Map;

class a$1 implements a {
    final /* synthetic */ a lic;

    a$1(a aVar) {
        this.lic = aVar;
    }

    public final void a(d.a aVar) {
        a.ayE();
        if (a.ayF() != null) {
            String a = n.a(aVar.hmq.vGZ);
            a.ayE();
            com.tencent.mm.plugin.collect.b.d ayF = a.ayF();
            long j = (long) aVar.hmq.pbl;
            x.v("MicroMsg.CollectPayerMsgMgr", "func[onResvMsg] content:" + a);
            if (bh.ov(a)) {
                x.d("MicroMsg.CollectPayerMsgMgr", "func[onResvMsg] Msg content empty");
                return;
            }
            Map y = bi.y(a, "sysmsg");
            int i = bh.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), 0);
            if (i == 9 || i == 26) {
                t tVar = new t();
                tVar.username = bh.ou((String) y.get(".sysmsg.paymsg.username"));
                tVar.ljg = bh.getDouble((String) y.get(".sysmsg.paymsg.fee"), 0.0d) / 100.0d;
                tVar.fpP = bh.ou((String) y.get(".sysmsg.paymsg.feetype"));
                tVar.cRJ = bh.getInt((String) y.get(".sysmsg.paymsgtimestamp"), (int) bh.Wo());
                tVar.fuI = bh.ou((String) y.get(".sysmsg.paymsg.transid"));
                tVar.gBL = bh.ou((String) y.get(".sysmsg.paymsg.displayname"));
                tVar.scene = bh.getInt((String) y.get(".sysmsg.paymsg.scene"), 1);
                tVar.status = bh.getInt((String) y.get(".sysmsg.paymsg.status"), 0);
                tVar.msgType = i;
                tVar.ljh = bh.ou((String) y.get(".sysmsg.paymsg.outtradeno"));
                tVar.type = bh.ou((String) y.get(".sysmsg.paymsg.type"));
                ayF.a(tVar);
                if (tVar.status == 1) {
                    b brVar = new br();
                    brVar.fpN.fpO = (int) Math.round(tVar.ljg * 100.0d);
                    brVar.fpN.fpP = tVar.fpP;
                    brVar.fpN.fpR = tVar.type;
                    brVar.fpN.fpQ = tVar.ljh;
                    brVar.fpN.fpS = System.currentTimeMillis() - (j * 1000);
                    brVar.fpN.cOY = 1;
                    com.tencent.mm.sdk.b.a.xef.m(brVar);
                    return;
                }
                return;
            }
            x.i("MicroMsg.CollectPayerMsgMgr", "Not ftf collect msg type, ignore; type=" + i);
            return;
        }
        x.w("MicroMsg.SubCoreCollect", "func[onRecieveMsg] payerMsgMgr null");
    }
}
