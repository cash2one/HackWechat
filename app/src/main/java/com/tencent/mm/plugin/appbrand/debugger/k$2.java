package com.tencent.mm.plugin.appbrand.debugger;

import java.util.LinkedList;

class k$2 implements Runnable {
    final /* synthetic */ k iQV;

    k$2(k kVar) {
        this.iQV = kVar;
    }

    public final void run() {
        LinkedList linkedList = new LinkedList();
        synchronized (this.iQV.iQx.mLock) {
            linkedList.addAll(this.iQV.iQR);
            this.iQV.iQR.clear();
            this.iQV.iQP = false;
        }
        this.iQV.a(linkedList, true);
    }
}
