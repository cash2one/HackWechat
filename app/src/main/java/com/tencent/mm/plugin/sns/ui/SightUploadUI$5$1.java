package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.ui.SightUploadUI.5;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.a.c.a;

class SightUploadUI$5$1 implements a {
    final /* synthetic */ int rxd;
    final /* synthetic */ 5 rxe;

    SightUploadUI$5$1(5 5, int i) {
        this.rxe = 5;
        this.rxd = i;
    }

    public final void uY(String str) {
        PInt pInt = new PInt();
        SightUploadUI.j(this.rxe.rxb).a(SightUploadUI.c(this.rxe.rxb), 0, null, SightUploadUI.d(this.rxe.rxb), null, SightUploadUI.e(this.rxe.rxb).rGC.bzA(), this.rxd, SightUploadUI.f(this.rxe.rxb), SightUploadUI.g(this.rxe.rxb), pInt, "", SightUploadUI.h(this.rxe.rxb), SightUploadUI.i(this.rxe.rxb));
        g gVar = g.pQN;
        Object[] objArr = new Object[4];
        objArr[0] = Long.valueOf(SightUploadUI.k(this.rxe.rxb));
        objArr[1] = Long.valueOf(bh.Wo());
        objArr[2] = Integer.valueOf(SightUploadUI.l(this.rxe.rxb) ? 0 : 1);
        objArr[3] = Integer.valueOf(pInt.value);
        gVar.h(13303, objArr);
        String str2 = "MicroMsg.SightUploadUI";
        String str3 = "reprot timelinePostAction(13303), %d, %d, %d, %d";
        objArr = new Object[4];
        objArr[0] = Long.valueOf(SightUploadUI.k(this.rxe.rxb));
        objArr[1] = Long.valueOf(bh.Wo());
        objArr[2] = Integer.valueOf(SightUploadUI.l(this.rxe.rxb) ? 0 : 1);
        objArr[3] = Integer.valueOf(pInt.value);
        x.d(str2, str3, objArr);
    }

    public final void amI() {
    }

    public final void aem() {
        h.h(this.rxe.rxb, j.qMH, j.qMI);
    }
}
