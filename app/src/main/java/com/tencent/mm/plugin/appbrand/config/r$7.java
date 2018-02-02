package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.protocal.c.cbh;
import com.tencent.mm.protocal.c.gj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import java.util.Iterator;

class r$7 implements a<Void, com.tencent.mm.ae.a.a<gj>> {
    r$7() {
    }

    public final /* synthetic */ Object call(Object obj) {
        int i = 0;
        com.tencent.mm.ae.a.a aVar = (com.tencent.mm.ae.a.a) obj;
        if (aVar.errType != 0 || aVar.errCode != 0) {
            x.e("MicroMsg.WxaAttrSyncHelper", "BatchBizAttrSync, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.fnL});
        } else if (aVar.fJJ != null) {
            long dz = f.Zh().hhp.dz(Thread.currentThread().getId());
            Iterator it = ((gj) aVar.fJJ).vLE.iterator();
            while (it.hasNext()) {
                cbh com_tencent_mm_protocal_c_cbh = (cbh) it.next();
                i = f.Zh().a(com_tencent_mm_protocal_c_cbh.xaw, com_tencent_mm_protocal_c_cbh.vNh, com_tencent_mm_protocal_c_cbh.vNi) | i;
            }
            f.Zh().hhp.fS(dz);
            if (i != 0) {
                q.abY().b("batch", 3, null);
            }
        }
        return zBS;
    }
}
