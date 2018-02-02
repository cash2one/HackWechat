package com.tencent.mm.plugin.chatroom;

import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.jx;
import com.tencent.mm.plugin.chatroom.d.i;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.sdk.b.b;

class d$2 extends c<jx> {
    final /* synthetic */ d kYZ;

    d$2(d dVar) {
        this.kYZ = dVar;
    }

    public final /* bridge */ /* synthetic */ b a(int i, k kVar, b bVar) {
        return (jx) bVar;
    }

    public final /* synthetic */ boolean a(b bVar) {
        jx jxVar = (jx) bVar;
        if (jxVar.fAY.fAJ) {
            c.k(jxVar);
        } else {
            l(jxVar);
        }
        return false;
    }

    public final /* synthetic */ k b(b bVar) {
        jx jxVar = (jx) bVar;
        return new i(jxVar.fAY.chatroomName, jxVar.fAY.fAZ);
    }

    public final int axw() {
        return 551;
    }
}
