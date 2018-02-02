package com.tencent.mm.ui.chatting;

import com.tencent.mm.g.a.nz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class d$1 extends c<nz> {
    final /* synthetic */ d yqB;

    d$1(d dVar) {
        this.yqB = dVar;
        this.xen = nz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        long j = ((nz) bVar).fFS.fqm;
        x.d("MicroMsg.AutoPlay", "playingVoiceId: %s", new Object[]{this.yqB.yqm});
        x.d("MicroMsg.AutoPlay", "msg id is: %s", new Object[]{r11.fFS.fqm});
        if (this.yqB.yqm == j) {
            ag.y(new 1(this));
        }
        return false;
    }
}
