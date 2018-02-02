package com.tencent.mm.ca;

import android.os.Message;
import com.tencent.mm.ca.d.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class d$2 extends af {
    d$2() {
    }

    public final void handleMessage(Message message) {
        x.i("MicroMsg.TraceDebugManager", "TRACE handle msg :%d ", new Object[]{Integer.valueOf(message.what)});
        if (message.what == 0) {
            d.xDc.b((a) message.obj);
        } else if (message.what != 1) {
            d.a(d.xDc, (a) message.obj);
        } else if (d.c(d.xDc) != null) {
            d$b com_tencent_mm_ca_d_b = (d$b) d.c(d.xDc).get();
            if (com_tencent_mm_ca_d_b != null) {
                com_tencent_mm_ca_d_b.cls();
            }
        }
        super.handleMessage(message);
    }
}
