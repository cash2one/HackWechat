package com.tencent.mm.plugin.wear.model;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f.c;

class a$1 extends c {
    final /* synthetic */ a thQ;

    a$1(a aVar) {
        this.thQ = aVar;
    }

    protected final void send() {
        r.a(CdnLogic.kMediaTypeBackupFile, null, false);
        r.a(20008, null, false);
    }

    public final String getName() {
        return "PhoneStartTask";
    }
}
