package com.tencent.d.b.d;

import com.tencent.d.a.c.e;
import com.tencent.d.b.f.g;

public final class b {
    int AcI;
    String AcJ;
    boolean AcK;
    boolean AcL;
    private a AcM;
    private boolean AcN;

    static /* synthetic */ void a(b bVar, e eVar) {
        if (!(bVar.AcM == null || bVar.AcN)) {
            if (eVar == null) {
                bVar.AcM.onError(-1, "unknown");
            } else if (eVar.isSuccess()) {
                bVar.AcM.onSuccess();
            } else {
                bVar.AcM.onError(eVar.errCode, eVar.fnL);
            }
        }
        bVar.AcN = true;
    }

    private b(int i, String str, boolean z, boolean z2, a aVar) {
        this.AcI = 0;
        this.AcJ = "";
        this.AcK = false;
        this.AcL = false;
        this.AcM = null;
        this.AcN = false;
        this.AcI = i;
        this.AcJ = str;
        this.AcK = z;
        this.AcL = z2;
        this.AcM = aVar;
    }

    public final void cGd() {
        g.cGk().A(new 1(this));
    }
}
