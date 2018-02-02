package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.g.a.rg;
import com.tencent.mm.plugin.shake.e.c.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends c<rg> {
    public n() {
        this.xen = rg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        rg rgVar = (rg) bVar;
        switch (rgVar.fIX.opType) {
            case 0:
                a Jo = com.tencent.mm.plugin.shake.e.c.Jo(rgVar.fIX.fIZ);
                if (Jo != null) {
                    rgVar.fIY.fDq = com.tencent.mm.plugin.shake.e.c.a(rgVar.fIX.context, Jo);
                    rgVar.fIY.fvC = m.dS(Jo.field_thumburl, "@B");
                    rgVar.fIY.fpW = true;
                    break;
                }
                x.w("MicroMsg.TVOperationListener", "error, xml[%s] can not parse", new Object[]{rgVar.fIX.fIZ});
                rgVar.fIY.fpW = false;
                break;
        }
        return false;
    }
}
