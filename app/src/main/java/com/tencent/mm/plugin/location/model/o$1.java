package com.tencent.mm.plugin.location.model;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class o$1 extends af {
    final /* synthetic */ o nRZ;

    o$1(o oVar, Looper looper) {
        this.nRZ = oVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (message != null) {
            o oVar = this.nRZ;
            switch (message.what) {
                case 1:
                    oVar.aVE();
                    return;
                default:
                    return;
            }
        }
    }
}
