package com.tencent.d.b.f;

import com.tencent.d.a.a;
import com.tencent.d.a.c.c;
import com.tencent.d.a.c.d;
import com.tencent.d.a.c.h;
import com.tencent.d.b.e.b;
import com.tencent.d.b.e.e$b;

class j$2 implements b<e$b> {
    final /* synthetic */ j AdP;
    final /* synthetic */ h AdQ;

    j$2(j jVar, h hVar) {
        this.AdP = jVar;
        this.AdQ = hVar;
    }

    public final /* synthetic */ void cx(Object obj) {
        e$b com_tencent_d_b_e_e_b = (e$b) obj;
        j.dI(d.cFS().Acm, 0);
        c.i("Soter.TaskPrepareAppSecureKey", "soter: ask upload result: %b", new Object[]{Boolean.valueOf(com_tencent_d_b_e_e_b.AcS)});
        if (com_tencent_d_b_e_e_b.AcS) {
            this.AdP.b(new com.tencent.d.b.a.c(this.AdQ));
            return;
        }
        a.cFK();
        this.AdP.b(new com.tencent.d.b.a.c(9, "upload app secure key failed"));
    }
}
