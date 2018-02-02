package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.internal.a;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.c.ae;
import com.google.android.gms.c.ag;
import com.google.android.gms.c.h;

public class c extends ag<c> {
    public final q aHf;
    public boolean aIn;

    public c(q qVar) {
        super(qVar.mT(), qVar.aFD);
        this.aHf = qVar;
    }

    protected final void a(ae aeVar) {
        h hVar = (h) aeVar.b(h.class);
        if (TextUtils.isEmpty(hVar.aGm)) {
            hVar.aGm = this.aHf.mX().nq();
        }
        if (this.aIn && TextUtils.isEmpty(hVar.aWq)) {
            q qVar = this.aHf;
            q.a(qVar.aGf);
            a aVar = qVar.aGf;
            hVar.aWq = aVar.mh();
            hVar.aWr = aVar.mg();
        }
    }

    public final ae nK() {
        ae pN = pO().pN();
        q qVar = this.aHf;
        q.a(qVar.aGg);
        pN.b(qVar.aGg.nh());
        pN.b(this.aHf.aGh.nH());
        pQ();
        return pN;
    }
}
