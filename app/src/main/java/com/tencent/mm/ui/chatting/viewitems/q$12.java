package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ChattingUI.b;

class q$12 implements b {
    final /* synthetic */ q yLH;

    q$12(q qVar) {
        this.yLH = qVar;
    }

    public final void csY() {
    }

    public final void csZ() {
    }

    public final void cta() {
        x.i("MicroMsg.ChattingItemDyeingTemplate", "onChattingExit, then remove AppBrandTmplMsgReceivingSwitchListener.");
        a.xef.c(q.e(this.yLH));
        if (q.c(this.yLH) != null) {
            q.c(this.yLH).b(this);
        }
    }
}
