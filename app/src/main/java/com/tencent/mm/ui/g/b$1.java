package com.tencent.mm.ui.g;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class b$1 extends af {
    final /* synthetic */ b zfr;

    b$1(b bVar) {
        this.zfr = bVar;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 256:
                this.zfr.dismiss();
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
