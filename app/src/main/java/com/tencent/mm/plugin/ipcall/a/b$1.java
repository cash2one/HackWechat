package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.g.a.ij;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.f.e;

class b$1 extends c<ij> {
    b$1() {
        this.xen = ij.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (((ij) bVar) instanceof ij) {
            e.post(new 1(this), "IPCall_SyncAddressBook");
        }
        return false;
    }
}
