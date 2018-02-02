package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.g.a.aj;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class b$3 extends c<aj> {
    final /* synthetic */ b pSJ;

    b$3(b bVar) {
        this.pSJ = bVar;
        this.xen = aj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        aj ajVar = (aj) bVar;
        if (ajVar == null || !(ajVar instanceof aj)) {
            x.e("MicroMsg.ExternRequestDealQBarStrHandler", "event is null or not a CancelDealQBarStrEvent instance");
        } else {
            x.i("MicroMsg.ExternRequestDealQBarStrHandler", "cancel deal qbar, activity:%s, str:%s", new Object[]{this.pSJ.mActivity, this.pSJ.pSD});
            if (ajVar.fou.activity == this.pSJ.mActivity && ajVar.fou.fov.equals(this.pSJ.pSD)) {
                this.pSJ.boC();
            } else {
                x.e("MicroMsg.ExternRequestDealQBarStrHandler", "not same as string that are dealing");
            }
        }
        return false;
    }
}
