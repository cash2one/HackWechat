package com.tencent.mm.plugin.talkroom.model;

import java.util.Iterator;

class i$11 implements Runnable {
    final /* synthetic */ String lbm;
    final /* synthetic */ i scj;

    i$11(i iVar, String str) {
        this.scj = iVar;
        this.lbm = str;
    }

    public final void run() {
        synchronized (this.scj.gxL) {
            Iterator it = this.scj.gxL.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }
}
