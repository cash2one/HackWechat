package com.tencent.mm.modelfriend;

import com.tencent.mm.modelfriend.a.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements Runnable {
    final /* synthetic */ long hva;
    final /* synthetic */ b hvb;

    a$2(long j, b bVar) {
        this.hva = j;
        this.hvb = bVar;
    }

    public final void run() {
        boolean z = a.No() != null && a.No().isAlive();
        x.i("MicroMsg.AddrBookSyncHelper", "syncAddrBook running:%b setSize:%d call:%d callback:%s", new Object[]{Boolean.valueOf(z), Integer.valueOf(a.huY.size()), Long.valueOf(this.hva), this.hvb});
        a.huY.add(this.hvb);
        if (!z) {
            a.b(e.d(new a$a(), "AddrBookSyncHelper_addrBookRead", 1));
            m.NK();
            a.No().start();
        }
    }
}
