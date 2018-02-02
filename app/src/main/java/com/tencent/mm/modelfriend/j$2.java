package com.tencent.mm.modelfriend;

import com.tencent.mm.protocal.c.aou;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.applet.b$b;

class j$2 implements b$b {
    final /* synthetic */ j hvW;

    j$2(j jVar) {
        this.hvW = jVar;
    }

    public final String hC(int i) {
        if (i < 0 || i >= this.hvW.getCount()) {
            x.e("MicroMsg.FriendAdapter", "pos is invalid");
            return null;
        }
        aou hB = this.hvW.hB(i);
        if (hB != null) {
            return hB.ksU;
        }
        return null;
    }

    public final int NJ() {
        return this.hvW.getCount();
    }
}
