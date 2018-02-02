package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.ar;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class an$3 extends c<ar> {
    final /* synthetic */ an qXu;

    an$3(an anVar) {
        this.qXu = anVar;
        this.xen = ar.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ar arVar = (ar) bVar;
        this.qXu.hUF = arVar.foP.foQ;
        x.i("MicroMsg.SnsPreTimelineService", "set isInChatting:%b", new Object[]{Boolean.valueOf(this.qXu.hUF)});
        return false;
    }
}
