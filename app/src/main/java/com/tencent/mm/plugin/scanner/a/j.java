package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.g.a.lw;
import com.tencent.mm.plugin.scanner.util.n.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends c<lw> {
    public j() {
        this.xen = lw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        lw lwVar = (lw) bVar;
        switch (lwVar.fDn.opType) {
            case 0:
                a bW = i.bW(lwVar.fDn.fDp, 0);
                if (bW != null) {
                    lwVar.fDo.fDq = i.a(lwVar.fDn.context, bW);
                    lwVar.fDo.fvC = com.tencent.mm.plugin.scanner.c.boA().dS(bW.field_thumburl, "@S");
                    lwVar.fDo.fpW = true;
                    break;
                }
                x.w("MicroMsg.ProductOperationListener", "error, xml[%s] can not parse", new Object[]{lwVar.fDn.fDp});
                lwVar.fDo.fpW = false;
                break;
        }
        return false;
    }
}
