package com.tencent.xweb.xwalk;

import com.tencent.xweb.xwalk.XWAppBrandEngine.a;

class XWAppBrandEngine$a$1 implements Runnable {
    final /* synthetic */ a AsN;

    XWAppBrandEngine$a$1(a aVar) {
        this.AsN = aVar;
    }

    public final void run() {
        this.AsN.AsM.notifyRunTimer(this.AsN.AsM.mInstance, this.AsN.bnv);
    }
}
