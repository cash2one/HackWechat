package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.plugin.profile.ui.k.5.1;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ak.b.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class k$5$1$1 implements a {
    final /* synthetic */ String pjG;
    final /* synthetic */ 1 pjH;

    k$5$1$1(1 1, String str) {
        this.pjH = 1;
        this.pjG = str;
    }

    public final void v(String str, boolean z) {
        x.i("MicroMsg.ContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[]{str, this.pjH.pjF.pjC.lbf, Boolean.valueOf(z)});
        if (z) {
            ar.Hg();
            this.pjH.pjF.pjC.dH(this.pjG, c.EY().WO(str).AP());
        }
    }
}
