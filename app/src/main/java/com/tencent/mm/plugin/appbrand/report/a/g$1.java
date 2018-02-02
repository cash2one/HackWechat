package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;

class g$1 implements Runnable {
    final /* synthetic */ Object[] jIj;
    final /* synthetic */ g jIk;

    g$1(g gVar, Object[] objArr) {
        this.jIk = gVar;
        this.jIj = objArr;
    }

    public final void run() {
        try {
            String str = (String) this.jIj[19];
            if (!bh.ov(str)) {
                int indexOf = str.indexOf(63);
                if (indexOf < 0) {
                    str = "";
                } else {
                    str = p.encode(str.substring(indexOf + 1, str.length()));
                }
                this.jIj[19] = str;
            }
        } catch (Exception e) {
            this.jIj[19] = "";
        }
        g.pQN.h(13536, e.h(this.jIj));
        KVCommCrossProcessReceiver.boi();
    }
}
