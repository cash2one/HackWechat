package com.tencent.d.b.f;

import com.tencent.d.a.c.c;
import com.tencent.d.a.c.h;
import com.tencent.d.b.d.a;
import com.tencent.d.b.e.e;

class k$2 implements a {
    final /* synthetic */ k AdU;

    k$2(k kVar) {
        this.AdU = kVar;
    }

    public final void onError(int i, String str) {
        c.w("Soter.TaskPrepareAuthKey", "soter: auth key %s generate failed. errcode: %d, errmsg: %s", new Object[]{this.AdU.AcJ, Integer.valueOf(i), str});
        k.dI(this.AdU.AcJ, 0);
        this.AdU.b(new com.tencent.d.b.a.c(i, str));
    }

    public final void onSuccess() {
        c.i("Soter.TaskPrepareAuthKey", "soter: auth key generate successfully. start upload", new Object[0]);
        if (this.AdU.AdR != null) {
            k.dI(this.AdU.AcJ, 2);
        } else {
            k.dI(this.AdU.AcJ, 0);
        }
        k kVar = this.AdU;
        h abv = com.tencent.d.a.a.abv(kVar.AcJ);
        if (abv == null) {
            c.e("Soter.TaskPrepareAuthKey", "soter: auth key model is null even after generation. fatal error", new Object[0]);
            com.tencent.d.a.a.bs(kVar.AcJ, false);
            kVar.b(new com.tencent.d.b.a.c(12, "auth key model is null even after generation."));
        } else if (kVar.AdR != null) {
            kVar.AdR.bq(new e.a(abv.signature, abv.Acr));
            kVar.AdR.a(new k$3(kVar, abv));
            kVar.AdR.execute();
        } else {
            c.d("Soter.TaskPrepareAuthKey", "soter: not provide network wrapper instance. please check if it is what you want. we treat it as normal", new Object[0]);
            kVar.b(new com.tencent.d.b.a.c("treat as normal because you do not provide the net wrapper", abv));
        }
    }
}
