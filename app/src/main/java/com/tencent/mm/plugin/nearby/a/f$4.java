package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.jz;
import com.tencent.mm.g.a.jz$b;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.protocal.c.aok;
import com.tencent.mm.protocal.c.aom;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.z.ar;
import java.util.Iterator;
import java.util.LinkedList;

class f$4 extends c<jz> {
    final /* synthetic */ f oOg;

    f$4(f fVar) {
        this.oOg = fVar;
    }

    public final /* synthetic */ b a(int i, k kVar, b bVar) {
        jz jzVar = (jz) bVar;
        e eVar = (e) kVar;
        jzVar.fBl.fzQ = ((aom) eVar.gJQ.hmh.hmo).kZx;
        jz$b com_tencent_mm_g_a_jz_b = jzVar.fBl;
        LinkedList linkedList = ((aom) eVar.gJQ.hmh.hmo).vGF;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                aok com_tencent_mm_protocal_c_aok = (aok) it.next();
                ar.Hg();
                com.tencent.mm.z.c.FI().fB(com_tencent_mm_protocal_c_aok.ksU, com_tencent_mm_protocal_c_aok.whR);
            }
        }
        com_tencent_mm_g_a_jz_b.fAX = linkedList;
        return jzVar;
    }

    public final /* synthetic */ boolean a(b bVar) {
        jz jzVar = (jz) bVar;
        if (jzVar.fBk.fAJ) {
            c.k(jzVar);
        } else {
            l(jzVar);
        }
        return false;
    }

    public final /* synthetic */ k b(b bVar) {
        return new e(((jz) bVar).fBk.fzn);
    }

    public final int axw() {
        return 377;
    }
}
