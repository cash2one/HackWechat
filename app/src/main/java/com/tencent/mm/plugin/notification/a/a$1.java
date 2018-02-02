package com.tencent.mm.plugin.notification.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.z.ar;

class a$1 extends af {
    final /* synthetic */ a oTP;

    a$1(a aVar, Looper looper) {
        this.oTP = aVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        ar.Dm().g(new 1(this, message.getData().getString("com.tencent.mm.notification.observer")), 500);
    }
}
