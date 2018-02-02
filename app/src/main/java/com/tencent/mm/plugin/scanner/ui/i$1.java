package com.tencent.mm.plugin.scanner.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class i$1 extends af {
    final /* synthetic */ i pXt;

    i$1(i iVar) {
        this.pXt = iVar;
    }

    public final void handleMessage(Message message) {
        if (message != null && message.what == 1 && this.pXt.jCQ != null) {
            this.pXt.jCQ.setVisibility(0);
        }
    }
}
