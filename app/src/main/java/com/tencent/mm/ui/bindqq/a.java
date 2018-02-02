package com.tencent.mm.ui.bindqq;

import com.tencent.mm.g.a.jt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

public final class a extends c<jt> implements com.tencent.mm.ui.bindqq.b.a {
    private jt ymJ;

    public a() {
        this.xen = jt.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        jt jtVar = (jt) bVar;
        if (jtVar instanceof jt) {
            this.ymJ = jtVar;
            new b(this.ymJ.fAD.fAF, this).cqF();
        }
        return false;
    }

    public final boolean t(int i, int i2, String str) {
        if (this.ymJ == null) {
            return false;
        }
        if (this.ymJ.fAD.fAG == null) {
            this.ymJ = null;
            return false;
        } else if (i == 0 && i2 == 0) {
            this.ymJ.fAE.fpW = true;
            this.ymJ.fAD.fAG.run();
            this.ymJ = null;
            return true;
        } else {
            this.ymJ.fAE.fpW = false;
            this.ymJ.fAD.fAG.run();
            this.ymJ = null;
            return false;
        }
    }

    public final void cqE() {
        if (this.ymJ != null && this.ymJ.fAD.fAG != null) {
            this.ymJ.fAE.fpW = false;
            this.ymJ.fAD.fAG.run();
            this.ymJ = null;
        }
    }
}
