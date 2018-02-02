package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.os.Looper;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bd;

public final class c implements e {
    private static long ptR = 0;
    private Activity fAF;
    private a ptS;

    static /* synthetic */ void a(c cVar) {
        if (System.currentTimeMillis() - ptR > 600000) {
            if (ar.Hj()) {
                ar.CG().a(new bd(new 2(cVar)), 0);
            }
        } else if (cVar.ptS != null) {
            cVar.ptS.bkw();
        }
    }

    public c(Activity activity) {
        ar.CG().a(138, (e) this);
        this.fAF = activity;
    }

    public final void a(a aVar) {
        this.ptS = aVar;
        b jtVar = new jt();
        jtVar.fAD.fAF = this.fAF;
        jtVar.fAD.fAG = new 1(this, jtVar);
        a.xef.a(jtVar, Looper.myLooper());
    }

    public final void release() {
        ar.CG().b(138, (e) this);
    }

    protected final void finalize() {
        release();
        super.finalize();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (this.ptS != null) {
                this.ptS.bkv();
                this.ptS = null;
            }
        } else if (this.ptS != null) {
            this.ptS.bkw();
            this.ptS = null;
        }
        ptR = System.currentTimeMillis();
    }
}
