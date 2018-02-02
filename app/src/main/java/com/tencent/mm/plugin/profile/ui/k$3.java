package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ak.b.a;

class k$3 implements a {
    final /* synthetic */ k pjC;

    k$3(k kVar) {
        this.pjC = kVar;
    }

    public final void v(String str, boolean z) {
        x.i("MicroMsg.ContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[]{str, this.pjC.lbf, Boolean.valueOf(z)});
        this.pjC.pjB.dead();
    }
}
