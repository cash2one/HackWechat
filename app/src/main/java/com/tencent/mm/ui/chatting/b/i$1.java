package com.tencent.mm.ui.chatting.b;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class i$1 extends af {
    final /* synthetic */ i yzL;

    i$1(i iVar) {
        this.yzL = iVar;
    }

    public final void handleMessage(Message message) {
        if (!this.yzL.fhr.csq().isFinishing() && this.yzL.yzK) {
            this.yzL.yzK = false;
            this.yzL.fhr.cqY();
            this.yzL.fhr.cpl();
        }
    }
}
