package com.tencent.mm.plugin.chatroom;

import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.ju;
import com.tencent.mm.plugin.chatroom.d.e;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.sdk.b.b;

class d$1 extends c<ju> {
    final /* synthetic */ d kYZ;

    d$1(d dVar) {
        this.kYZ = dVar;
    }

    public final /* bridge */ /* synthetic */ b a(int i, k kVar, b bVar) {
        return (ju) bVar;
    }

    public final /* synthetic */ boolean a(b bVar) {
        ju juVar = (ju) bVar;
        if (juVar.fAH.fAJ) {
            c.k(juVar);
        } else {
            l(juVar);
        }
        return false;
    }

    public final /* synthetic */ k b(b bVar) {
        return new e(((ju) bVar).fAH.fAI);
    }

    public final int axw() {
        return 181;
    }
}
