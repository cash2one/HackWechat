package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.sns.model.aa.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class aa$1 extends af {
    final /* synthetic */ aa qUY;

    aa$1(aa aaVar, Looper looper) {
        this.qUY = aaVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (aa.a(this.qUY) >= 5 || System.currentTimeMillis() - aa.b(this.qUY) > 300000) {
            x.d("MicroMsg.RemoveSnsTask", "cleanCount: " + aa.a(this.qUY));
            aa.nSI = false;
        } else if (!aa.c(this.qUY) && aa.nSI) {
            new a(this.qUY).m(new String[]{""});
        }
    }
}
