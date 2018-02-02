package com.tencent.d.b.f;

import com.tencent.d.a.a;
import com.tencent.d.a.c.c;
import com.tencent.d.a.c.h;
import com.tencent.d.b.e.b;
import com.tencent.d.b.e.e$b;

class k$3 implements b<e$b> {
    final /* synthetic */ k AdU;
    final /* synthetic */ h AdV;

    k$3(k kVar, h hVar) {
        this.AdU = kVar;
        this.AdV = hVar;
    }

    public final /* synthetic */ void cx(Object obj) {
        e$b com_tencent_d_b_e_e_b = (e$b) obj;
        k.dI(this.AdU.AcJ, 0);
        c.i("Soter.TaskPrepareAuthKey", "soter: auth key upload result: %b", new Object[]{Boolean.valueOf(com_tencent_d_b_e_e_b.AcS)});
        if (com_tencent_d_b_e_e_b.AcS) {
            this.AdU.b(new com.tencent.d.b.a.c(this.AdV));
            return;
        }
        a.bs(this.AdU.AcJ, false);
        this.AdU.b(new com.tencent.d.b.a.c(10, String.format("upload auth key: %s failed", new Object[]{this.AdU.AcJ})));
    }
}
