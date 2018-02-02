package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.f;
import com.tencent.mm.modelvideo.i;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class aq$10 extends c<f> {
    final /* synthetic */ aq qXH;

    aq$10(aq aqVar) {
        this.qXH = aqVar;
        this.xen = f.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        f fVar = (f) bVar;
        if (fVar.fmS.className.equals("SnsTimeLineUI")) {
            this.qXH.hUG = fVar.fmS.ahf;
            x.d("MicroMsg.SnsVideoService", "set isInSnsTimeline:%b", new Object[]{Boolean.valueOf(this.qXH.hUG)});
            if (this.qXH.hUG || this.qXH.hUF) {
                this.qXH.bwa();
            }
            i TW = o.TW();
            TW.hUG = this.qXH.hUG;
            if (TW.hUG) {
                TW.stopDownload();
            }
        }
        return false;
    }
}
