package com.tencent.mm.plugin.appbrand.ui.autofill;

import com.tencent.mm.plugin.appbrand.ui.autofill.b.2;
import com.tencent.mm.protocal.c.ec;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import java.util.Iterator;

class b$2$1 implements c {
    final /* synthetic */ 2 jOa;

    b$2$1(2 2) {
        this.jOa = 2;
    }

    public final void a(n nVar) {
        x.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "phone_list.size %d", new Object[]{Integer.valueOf(this.jOa.jNZ.jNM.vJv.size())});
        Iterator it = this.jOa.jNZ.jNM.vJv.iterator();
        while (it.hasNext()) {
            ec ecVar = (ec) it.next();
            if (bh.ov(ecVar.vJt) || bh.ov(ecVar.vJu)) {
                x.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "phone_id or show_phone is empty, continue");
            } else {
                nVar.f(this.jOa.jNZ.jNM.vJv.indexOf(ecVar), ecVar.vJu);
            }
        }
    }
}
