package com.tencent.mm.plugin.qqmail.stub;

import com.tencent.mm.g.b.cf;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class ReadMailProxy$6 implements Runnable {
    final /* synthetic */ long fhh;
    final /* synthetic */ String jqG;
    final /* synthetic */ ReadMailProxy pqi;

    ReadMailProxy$6(ReadMailProxy readMailProxy, long j, String str) {
        this.pqi = readMailProxy;
        this.fhh = j;
        this.jqG = str;
    }

    public final void run() {
        ar.Hg();
        cf dH = c.Fa().dH(this.fhh);
        dH.setContent(dH.field_content.replaceFirst("<digest>.*</digest>", "<digest>" + this.jqG + "</digest>"));
        ar.Hg();
        c.Fa().a(this.fhh, dH);
    }
}
