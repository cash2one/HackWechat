package com.tencent.mm.plugin.facedetect.d;

import com.tencent.mm.plugin.facedetect.e.a;
import com.tencent.mm.plugin.facedetect.e.a.2;

class d$6 implements Runnable {
    final /* synthetic */ d mii;

    d$6(d dVar) {
        this.mii = dVar;
    }

    public final void run() {
        if (a.aHt().mkZ) {
            this.mii.mhN.a(a.aHt().aHu());
            a aHt = a.aHt();
            aHt.mkR.F(new 2(aHt));
        }
    }
}
