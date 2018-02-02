package com.tencent.mm.ui.conversation;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class m$9 implements Runnable {
    final /* synthetic */ m zab;

    m$9(m mVar) {
        this.zab = mVar;
    }

    public final void run() {
        h.a(this.zab.fAF, this.zab.fAF.getString(R.l.eyT), "", this.zab.fAF.getString(R.l.eyU), this.zab.fAF.getString(R.l.dEn), new 1(this), new 2(this));
    }
}
