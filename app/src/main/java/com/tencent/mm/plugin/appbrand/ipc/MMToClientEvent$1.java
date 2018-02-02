package com.tencent.mm.plugin.appbrand.ipc;

import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.a;
import java.util.List;

class MMToClientEvent$1 implements Runnable {
    final /* synthetic */ List jbx;
    final /* synthetic */ Object jby;
    final /* synthetic */ MMToClientEvent jbz;

    MMToClientEvent$1(MMToClientEvent mMToClientEvent, List list, Object obj) {
        this.jbz = mMToClientEvent;
        this.jbx = list;
        this.jby = obj;
    }

    public final void run() {
        for (a aY : this.jbx) {
            aY.aY(this.jby);
        }
    }
}
