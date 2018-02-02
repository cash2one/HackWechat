package com.tencent.d.b.f;

import com.tencent.d.a.c.c;
import com.tencent.d.a.c.d;
import com.tencent.d.a.c.h;
import com.tencent.d.b.d.a;
import com.tencent.d.b.e.e;

class j$1 implements a {
    final /* synthetic */ j AdP;

    j$1(j jVar) {
        this.AdP = jVar;
    }

    public final void onError(int i, String str) {
        c.w("Soter.TaskPrepareAppSecureKey", "soter: app secure key generate failed. errcode: %d, errmsg: %s", new Object[]{Integer.valueOf(i), str});
        j.dI(d.cFS().Acm, 0);
        this.AdP.b(new com.tencent.d.b.a.c(i, str));
    }

    public final void onSuccess() {
        c.i("Soter.TaskPrepareAppSecureKey", "soter: app secure key generate successfully. start upload ask", new Object[0]);
        if (this.AdP.AdN != null) {
            j.dI(d.cFS().Acm, 2);
        } else {
            j.dI(d.cFS().Acm, 0);
        }
        j jVar = this.AdP;
        h cFN = com.tencent.d.a.a.cFN();
        if (cFN == null) {
            c.e("Soter.TaskPrepareAppSecureKey", "soter: ask model is null even after generation. fatal error", new Object[0]);
            com.tencent.d.a.a.cFK();
            jVar.b(new com.tencent.d.b.a.c(3, "ask model is null even after generation."));
        } else if (jVar.AdN != null) {
            jVar.AdN.bq(new e.a(cFN.signature, cFN.Acr));
            jVar.AdN.a(new j$2(jVar, cFN));
            jVar.AdN.execute();
        } else {
            c.d("Soter.TaskPrepareAppSecureKey", "soter: not provide network wrapper instance. please check if it is what you want. we treat it as normal", new Object[0]);
            jVar.b(new com.tencent.d.b.a.c("treat as normal because you do not provide the net wrapper", cFN));
        }
    }
}
