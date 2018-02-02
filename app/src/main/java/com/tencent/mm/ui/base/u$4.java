package com.tencent.mm.ui.base;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class u$4 extends af {
    final /* synthetic */ q yek;

    u$4(q qVar) {
        this.yek = qVar;
    }

    public final void handleMessage(Message message) {
        this.yek.dismiss();
        super.handleMessage(message);
    }
}
