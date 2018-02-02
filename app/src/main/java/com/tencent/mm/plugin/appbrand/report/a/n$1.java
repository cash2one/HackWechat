package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;

class n$1 implements Runnable {
    final /* synthetic */ n jIY;
    final /* synthetic */ Object[] jIj;

    n$1(n nVar, Object[] objArr) {
        this.jIY = nVar;
        this.jIj = objArr;
    }

    public final void run() {
        try {
            String str = (String) this.jIj[18];
            if (!bh.ov(str)) {
                int indexOf = str.indexOf(63);
                if (indexOf < 0) {
                    str = "";
                } else {
                    str = p.encode(str.substring(indexOf + 1, str.length()));
                }
                this.jIj[18] = str;
            }
        } catch (Exception e) {
            this.jIj[18] = "";
        }
        g.pQN.h(14992, e.h(this.jIj));
        KVCommCrossProcessReceiver.boi();
    }
}
