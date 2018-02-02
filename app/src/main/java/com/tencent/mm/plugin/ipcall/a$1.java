package com.tencent.mm.plugin.ipcall;

import com.tencent.mm.g.a.hn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements Runnable {
    final /* synthetic */ a nBX;

    a$1(a aVar) {
        this.nBX = aVar;
    }

    public final void run() {
        x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "start GetMFriend");
        b hnVar = new hn();
        hnVar.fxQ.scene = 2;
        a.xef.m(hnVar);
        a.a(this.nBX, System.currentTimeMillis());
    }
}
