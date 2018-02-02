package com.tencent.mm.bg.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class c$1 extends af {
    final /* synthetic */ c hZh;

    c$1(c cVar, Looper looper) {
        this.hZh = cVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message.what == 0 && c.a(this.hZh) != null) {
            c.a(this.hZh).uY();
        }
    }
}
