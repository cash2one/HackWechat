package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.chatting.b.u.11;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class u$11$1 implements Runnable {
    final /* synthetic */ 11 yAZ;

    u$11$1(11 11) {
        this.yAZ = 11;
    }

    public final void run() {
        x.i("MicroMsg.ChattingUI.SearchImp", "if (isShowSearchChatResult || isFromGlobalSearch) on set position %d, set selection %d", new Object[]{Long.valueOf(this.yAZ.val$position), Integer.valueOf(this.yAZ.jZe)});
        t.a(this.yAZ.yAV.fhr.csx(), this.yAZ.jZe, false);
        if (this.yAZ.yAV.yAT && !this.yAZ.yAV.yAJ) {
            u.a(this.yAZ.yAV, this.yAZ.jZe, this.yAZ.val$position);
            ar.Hg();
            c.CU().a(a.xqy, Boolean.valueOf(false));
        }
    }
}
