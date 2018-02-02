package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class i$1 extends af {
    final /* synthetic */ i ouL;

    i$1(i iVar) {
        this.ouL = iVar;
    }

    public final void handleMessage(Message message) {
        if (this.ouL.oux != null) {
            this.ouL.oux.bat();
            this.ouL.oux = null;
        }
    }
}
