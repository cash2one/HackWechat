package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ac.a.b.a;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.bo;

class p$7 implements a {
    final /* synthetic */ Activity oZ;
    final /* synthetic */ p pYq;

    p$7(p pVar, Activity activity) {
        this.pYq = pVar;
        this.oZ = activity;
    }

    public final void j(String str, String str2, int i, int i2) {
        int i3 = 1;
        l.pST.vE(l.pSR);
        if (this.pYq.pYf != null) {
            this.pYq.pYf.bpv();
        }
        if (this.pYq.iln == null || !this.pYq.iln.isShowing()) {
            this.pYq.pYh = false;
            this.pYq.pYi = false;
            return;
        }
        if (this.pYq.pXp != null) {
            this.pYq.pXp.hG(true);
        }
        this.pYq.iln.dismiss();
        if (bh.ov(str2)) {
            l.pST.aUb();
            h.a(this.oZ, R.l.eBy, R.l.dGO, new 1(this));
            return;
        }
        bo.HS().c(10237, new Object[]{Integer.valueOf(1)});
        this.pYq.pXp.boU();
        if (!(i == 19 || i == 22)) {
            i3 = 2;
        }
        p.a(this.pYq, i3, str2, i, i2);
        this.pYq.pYi = false;
        this.pYq.pYg.set(false);
    }

    public final void HX(String str) {
        l.pST.vE(l.pSR);
        if (this.pYq.pYf != null) {
            this.pYq.pYf.bpv();
        }
        if (this.pYq.iln == null || !this.pYq.iln.isShowing()) {
            this.pYq.pYh = false;
            this.pYq.pYg.set(false);
            this.pYq.pYi = false;
            return;
        }
        if (this.pYq.pXp != null) {
            this.pYq.pXp.hG(true);
        }
        this.pYq.iln.dismiss();
        l.pST.aUb();
        h.a(this.oZ, R.l.eBy, R.l.dGO, new 2(this));
        this.pYq.pYg.set(false);
    }
}
