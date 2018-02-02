package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.network.e;
import com.tencent.mm.z.bd.a;

class i$4 implements a {
    final /* synthetic */ i yzL;

    i$4(i iVar) {
        this.yzL = iVar;
    }

    public final void a(e eVar) {
        if (eVar != null) {
            eVar.stopSignalling();
        }
    }
}
