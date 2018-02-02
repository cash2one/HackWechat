package com.tencent.mm.z;

import com.tencent.mm.ae.d;
import com.tencent.mm.ae.d.a;
import com.tencent.mm.ae.d.b;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.t;
import java.util.Map;

public final class bt implements d {
    public final b b(a aVar) {
        bw bwVar = aVar.hmq;
        if (bwVar == null) {
            x.e("MicroMsg.SysNoticeMsgExtension", "onPreAddMessage cmdAM is null");
        } else {
            try {
                Map y = bi.y("<root>" + bwVar.vGZ + "</root>", "root");
                int intValue = Integer.valueOf((String) y.get(".root.newcount")).intValue();
                int intValue2 = Integer.valueOf((String) y.get(".root.version")).intValue();
                ar.Hg();
                t CU = c.CU();
                if (intValue2 == bh.e((Integer) CU.get(12305, null))) {
                    x.i("MicroMsg.SysNoticeMsgExtension", "ignore new sys notice count, same version");
                } else {
                    CU.set(12304, Integer.valueOf(intValue));
                    CU.set(12305, Integer.valueOf(intValue2));
                }
            } catch (Throwable e) {
                x.e("MicroMsg.SysNoticeMsgExtension", "exception:%s", new Object[]{bh.i(e)});
            }
        }
        return null;
    }

    public final void h(au auVar) {
    }
}
