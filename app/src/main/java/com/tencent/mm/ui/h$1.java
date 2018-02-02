package com.tencent.mm.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class h$1 extends af {
    final /* synthetic */ h xFs;

    h$1(h hVar, Looper looper) {
        this.xFs = hVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (h.a(this.xFs) != null) {
                    h.b(this.xFs);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
