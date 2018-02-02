package com.tencent.mm.plugin.facedetect.d;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class d$1 extends af {
    final /* synthetic */ d mii;

    d$1(d dVar, Looper looper) {
        this.mii = dVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 0:
                x.i("MicroMsg.NumberFaceMotion", "hy: refresh number");
                this.mii.aHc();
                return;
            default:
                return;
        }
    }
}
