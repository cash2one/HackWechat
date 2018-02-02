package com.tencent.mm.plugin.card.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.hy;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.plugin.card.b.g;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.ar;

public final class o extends c<hy> implements e {
    private long fpG;

    public o() {
        this.fpG = 0;
        this.xen = hy.class.getName().hashCode();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof af) {
            String str2 = ((af) kVar).fGV;
            ar.Hg();
            cf dH = com.tencent.mm.z.c.Fa().dH(this.fpG);
            if (i == 0 && i2 == 0) {
                dH.eQ(2);
            } else {
                dH.eQ(5);
            }
            a fT = a.fT(dH.field_content);
            d wJ = g.wJ(dH.field_content);
            wJ.fGV = str2;
            fT.hcj = g.a(wJ);
            fT.fys = a.a(fT, null, null);
            dH.setContent(a.a(fT, null, null));
            ar.Hg();
            com.tencent.mm.z.c.Fa().a(this.fpG, dH);
            ar.CG().b(652, this);
        }
    }

    private boolean a(hy hyVar) {
        if (!(hyVar instanceof hy)) {
            return false;
        }
        String str = hyVar.fyr.fys;
        this.fpG = hyVar.fyr.fpG;
        String str2 = hyVar.fyr.fyt;
        d wJ = g.wJ(str);
        ar.Hg();
        cf dH = com.tencent.mm.z.c.Fa().dH(this.fpG);
        dH.eQ(1);
        ar.Hg();
        com.tencent.mm.z.c.Fa().a(this.fpG, dH);
        if (wJ == null) {
            wJ = g.wJ(dH.field_content);
        }
        if (wJ == null) {
            return true;
        }
        ar.CG().a(652, this);
        ar.CG().a(new af(wJ.fGU, str2, 17), 0);
        return true;
    }
}
