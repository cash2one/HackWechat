package com.tencent.mm.plugin.multitalk.a;

import android.util.Base64;
import com.tencent.mm.ae.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bs.a;
import com.tencent.mm.z.q;
import java.util.Map;

class o$a implements a {
    final /* synthetic */ o oHD;

    o$a(o oVar) {
        this.oHD = oVar;
    }

    public final void a(d.a aVar) {
        f bcY = o.bcY();
        String a = n.a(aVar.hmq.vGZ);
        Map y = bi.y(a, "sysmsg");
        if (((String) y.get(".sysmsg.multivoip.notfriendnotifydata")) != null) {
            x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive notfriendnotifydata msg:" + a);
            return;
        }
        String str = (String) y.get(".sysmsg.multivoip.notifydata");
        if (str != null) {
            byte[] decode = Base64.decode(bh.az(str, "").getBytes(), 0);
            x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive " + n.a(aVar.hmq.vGZ) + " buffer len " + decode.length);
            o.bcU().oFQ.ba(bh.e((Integer) ar.He().get(1)), q.FS());
            o.bcU().oFQ.bF(decode);
            return;
        }
        str = (String) y.get(".sysmsg.multivoip.banner");
        if (str != null) {
            bcY.a(str, aVar);
        }
    }
}
