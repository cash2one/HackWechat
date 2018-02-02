package com.tencent.mm.plugin.chatroom;

import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.plugin.chatroom.d.l;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.sdk.b.b;

class d$4 extends c<kb> {
    final /* synthetic */ d kYZ;

    d$4(d dVar) {
        this.kYZ = dVar;
    }

    public final /* bridge */ /* synthetic */ b a(int i, k kVar, b bVar) {
        kb kbVar = (kb) bVar;
        kbVar.fBp.errCode = i;
        return kbVar;
    }

    public final /* synthetic */ boolean a(b bVar) {
        kb kbVar = (kb) bVar;
        if (kbVar.fBo.fAJ) {
            c.k(kbVar);
        } else {
            l(kbVar);
        }
        return false;
    }

    public final /* synthetic */ k b(b bVar) {
        kb kbVar = (kb) bVar;
        return new l(kbVar.fBo.fBq, kbVar.fBo.chatroomName);
    }

    public final int axw() {
        return 700;
    }
}
