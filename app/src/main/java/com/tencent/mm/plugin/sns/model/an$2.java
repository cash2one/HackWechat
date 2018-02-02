package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class an$2 extends c<f> {
    final /* synthetic */ an qXu;

    an$2(an anVar) {
        this.qXu = anVar;
        this.xen = f.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        f fVar = (f) bVar;
        if (fVar.fmS.className.equals("SnsTimeLineUI")) {
            this.qXu.hUG = fVar.fmS.ahf;
            x.i("MicroMsg.SnsPreTimelineService", "set isInSnsTimeline:%b", new Object[]{Boolean.valueOf(this.qXu.hUG)});
        }
        return false;
    }
}
