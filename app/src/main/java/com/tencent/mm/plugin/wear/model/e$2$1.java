package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.plugin.wear.model.e.2;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f.c;
import java.io.UnsupportedEncodingException;

class e$2$1 extends c {
    final /* synthetic */ 2 til;

    e$2$1(2 2) {
        this.til = 2;
    }

    protected final void send() {
        try {
            a.bOt();
            r.a(20007, a.bOt().thH.thZ.tiQ.getBytes("utf8"), false);
        } catch (UnsupportedEncodingException e) {
        }
    }

    public final String getName() {
        return "SendMsgSyncTask";
    }
}
