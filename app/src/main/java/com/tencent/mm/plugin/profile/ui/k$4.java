package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ak.b.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class k$4 implements a {
    final /* synthetic */ k pjC;

    k$4(k kVar) {
        this.pjC = kVar;
    }

    public final void v(String str, boolean z) {
        x.i("MicroMsg.ContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[]{str, this.pjC.lbf, Boolean.valueOf(z)});
        if (z) {
            ar.Hg();
            this.pjC.dH(this.pjC.foI, c.EY().WO(str).AP());
        }
    }
}
