package com.tencent.mm.plugin.location.model;

import com.tencent.mm.g.a.iv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

final class l$b extends c<iv> {
    private l$b() {
        this.xen = iv.class.getName().hashCode();
    }

    /* synthetic */ l$b(byte b) {
        this();
        this.xen = iv.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        iv ivVar = (iv) bVar;
        if (!(ivVar instanceof iv)) {
            return false;
        }
        x.d("MicroMsg.SubCoreLocation", "e.data.eventType : " + ivVar.fzp.fzr);
        switch (ivVar.fzp.fzr) {
            case 0:
                ivVar.fzq.path = e.a(ivVar.fzp.fzs, ivVar.fzp.filename, ivVar.fzp.view);
                break;
            case 1:
                com.tencent.mm.pluginsdk.location.b bVar2 = new com.tencent.mm.pluginsdk.location.b(-1, ivVar.fzp.fzt, ivVar.fzp.fzu, ivVar.fzp.fzv, 1);
                ivVar.fzq.path = k.b(bVar2);
                break;
            case 2:
                ar.CG().a(new g(ivVar.fzp.fzt, ivVar.fzp.fzu, ivVar.fzp.fzv, ivVar.fzp.width, ivVar.fzp.height, ivVar.fzp.filename, w.cfi()), 0);
                break;
            case 3:
                g gVar = (g) ivVar.fzp.frb;
                ivVar.fzq.path = gVar.nQL;
                break;
        }
        return true;
    }
}
