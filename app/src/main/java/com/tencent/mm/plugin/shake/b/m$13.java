package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.ae.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bs.a;
import java.util.Map;

class m$13 implements a {
    final /* synthetic */ m qoh;

    m$13(m mVar) {
        this.qoh = mVar;
    }

    public final void a(d.a aVar) {
        m.brJ();
        if (m.brG() != 0) {
            m.brJ();
            m.brG();
            String a = n.a(aVar.hmq.vGZ);
            x.v("MicroMsg.ShakeMsgMgr", "func[onResvMsg] content:" + a);
            if (bh.ov(a)) {
                x.d("MicroMsg.ShakeMsgMgr", "func[onResvMsg] Msg content empty");
                return;
            }
            Map y = bi.y(a, "sysmsg");
            int i = bh.getInt((String) y.get(".sysmsg.shake.$type"), 0);
            switch (i) {
                case 1:
                    f fVar = new f();
                    i = bh.getInt((String) y.get(".sysmsg.shake.shaketv.msgtype"), 0);
                    if (i == 0) {
                        fVar.field_type = 1;
                        fVar.field_subtype = i;
                        fVar.field_svrid = aVar.hmq.vHe;
                        fVar.field_createtime = bh.Wo();
                        fVar.field_tag = (String) y.get(".sysmsg.shake.shaketv.jumpurl");
                        fVar.field_status = 0;
                        fVar.field_title = (String) y.get(".sysmsg.shake.shaketv.title");
                        fVar.field_thumburl = (String) y.get(".sysmsg.shake.shaketv.iconurl");
                        fVar.field_desc = (String) y.get(".sysmsg.shake.shaketv.desc");
                        fVar.field_reserved1 = bh.ou((String) y.get(".sysmsg.shake.shaketv.pid"));
                        m.brD().a(fVar);
                        return;
                    }
                    x.w("MicroMsg.ShakeMsgMgr", "Unknown subType:" + i);
                    return;
                default:
                    x.d("MicroMsg.ShakeMsgMgr", "Unrecognized type :" + i);
                    return;
            }
        }
        x.w("MicroMsg.SubCoreShake", "func[onRecieveMsg] getShakeMsgMgr null");
    }
}
