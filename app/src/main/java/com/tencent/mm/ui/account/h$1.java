package com.tencent.mm.ui.account;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class h$1 extends af {
    final /* synthetic */ h xPS;

    h$1(h hVar) {
        this.xPS = hVar;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (this.xPS.xPR != null) {
                    this.xPS.xPR.onError(message.arg1, (String) message.obj);
                    return;
                }
                return;
            case 2:
                if (this.xPS.xPR != null) {
                    this.xPS.xPR.k(message.getData());
                    return;
                }
                return;
            default:
                return;
        }
    }
}
