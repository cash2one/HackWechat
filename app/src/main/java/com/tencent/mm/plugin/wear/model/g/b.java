package com.tencent.mm.plugin.wear.model.g;

import com.tencent.mm.ae.d;
import com.tencent.mm.ae.d.a;
import com.tencent.mm.g.a.tn;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class b implements d {
    public final com.tencent.mm.ae.d.b b(a aVar) {
        bw bwVar = aVar.hmq;
        ar.Hg();
        if (!bh.ov((String) c.CU().get(2, ""))) {
            String a = n.a(bwVar.vGX);
            String a2 = n.a(bwVar.vGY);
            if (bh.ov(a) || bh.ov(a2)) {
                x.e("MicroMsg.YoExtension", "neither from-user nor to-user can be empty");
            } else {
                String a3 = n.a(bwVar.vGZ);
                x.i("MicroMsg.YoExtension", "from  " + a + "content " + a3);
                a aVar2 = com.tencent.mm.plugin.wear.model.a.bOt().thO;
                synchronized (aVar2.tje) {
                    tn NO = a.NO(a);
                    if (aVar2.tje.containsKey(a) || NO.fMd.fMe == 1) {
                        x.i("MicroMsg.wear.WearYoLogic", "Can not add Yo Message %s", new Object[]{a});
                        com.tencent.mm.sdk.b.b tnVar = new tn();
                        tnVar.fMc.fpr = 2;
                        tnVar.fMc.username = a;
                        com.tencent.mm.sdk.b.a.xef.m(tnVar);
                    } else {
                        x.i("MicroMsg.wear.WearYoLogic", "Can add Yo Message %s", new Object[]{a});
                        aVar2.tje.put(a, new a.a(aVar2, a, a3));
                    }
                }
                com.tencent.mm.plugin.wear.model.a.bOt().thO.bOJ();
            }
        }
        return null;
    }

    public final void h(au auVar) {
    }
}
