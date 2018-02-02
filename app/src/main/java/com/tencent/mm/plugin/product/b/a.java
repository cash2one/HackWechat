package com.tencent.mm.plugin.product.b;

import com.tencent.mm.g.a.lw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends c<lw> {
    public a() {
        this.xen = lw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        String str = null;
        lw lwVar = (lw) bVar;
        switch (lwVar.fDn.opType) {
            case 1:
                com.tencent.mm.plugin.product.a.a.biM();
                c biN = com.tencent.mm.plugin.product.a.a.biN();
                if (biN != null) {
                    m b = m.b(null, lwVar.fDn.fDp);
                    biN.a(b, null);
                    lwVar.fDo.fDq = biN.bjf();
                    lw.b bVar2 = lwVar.fDo;
                    if (!bh.ov(b.bji())) {
                        str = com.tencent.mm.plugin.product.ui.c.Hu(b.bji());
                    }
                    bVar2.fvC = str;
                    lwVar.fDo.fpW = true;
                    break;
                }
                x.w("MicroMsg.MallProductListener", "error, xml[%s] can not parse", new Object[]{lwVar.fDn.fDp});
                lwVar.fDo.fpW = false;
                break;
        }
        return false;
    }
}
