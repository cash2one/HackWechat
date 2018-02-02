package com.tencent.mm.plugin.translate;

import android.os.Looper;
import com.tencent.mm.by.h.d;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.plugin.translate.a.c;
import com.tencent.mm.plugin.translate.a.c$a;
import com.tencent.mm.plugin.translate.a.c.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import java.util.HashMap;

public final class a implements ap {
    af handler = new af(Looper.getMainLooper());
    c sfR = b.sgf;
    as sfS = new as(5, "ProcessTranslatedMessage", 1, Looper.getMainLooper());
    private c$a sfT = new 1(this);
    private com.tencent.mm.sdk.b.c sfU = new com.tencent.mm.sdk.b.c<rn>(this) {
        final /* synthetic */ a sfW;

        {
            this.sfW = r2;
            this.xen = rn.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            rn rnVar = (rn) bVar;
            x.d("MicroMsg.SubCoreTranslate", "recieve one translate request");
            this.sfW.handler.post(new 1(this, rnVar));
            return true;
        }
    };
    private com.tencent.mm.sdk.b.c sfV = new 3(this);

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        c cVar = this.sfR;
        c$a com_tencent_mm_plugin_translate_a_c_a = this.sfT;
        if (!(com_tencent_mm_plugin_translate_a_c_a == null || cVar.gLv.contains(com_tencent_mm_plugin_translate_a_c_a))) {
            cVar.gLv.add(com_tencent_mm_plugin_translate_a_c_a);
        }
        com.tencent.mm.sdk.b.a.xef.b(this.sfU);
        com.tencent.mm.sdk.b.a.xef.b(this.sfV);
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.xef.c(this.sfU);
        com.tencent.mm.sdk.b.a.xef.c(this.sfV);
        c cVar = this.sfR;
        c$a com_tencent_mm_plugin_translate_a_c_a = this.sfT;
        if (com_tencent_mm_plugin_translate_a_c_a != null && cVar.gLv.contains(com_tencent_mm_plugin_translate_a_c_a)) {
            cVar.gLv.remove(com_tencent_mm_plugin_translate_a_c_a);
        }
        c cVar2 = this.sfR;
        if (cVar2.sgc != null) {
            for (com.tencent.mm.plugin.translate.a.d dVar : cVar2.sgc) {
                if (dVar != null) {
                    ar.CG().b(631, dVar);
                    if (dVar.sgl != null) {
                        dVar.sgn.TG();
                        ar.CG().c(dVar.sgl);
                    }
                    dVar.bFB();
                    dVar.sgj = null;
                }
            }
        }
        cVar2.sge.clear();
        cVar2.sgd.clear();
        cVar2.gLv.clear();
        cVar2.kIS = 0;
    }
}
