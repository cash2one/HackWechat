package com.tencent.mm.plugin.radar.b;

import android.os.Message;
import b.c.b.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.radar.b.e.b;
import com.tencent.mm.sdk.platformtools.af;

public final class e$g extends af {
    e$g() {
    }

    public final void handleMessage(Message message) {
        e.i(message, "msg");
        int i = message.what;
        b bVar = e.pxt;
        if (i == e.blw()) {
            g.CG().d(new b());
        }
    }
}
