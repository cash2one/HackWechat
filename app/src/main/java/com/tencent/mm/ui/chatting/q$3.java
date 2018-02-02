package com.tencent.mm.ui.chatting;

import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.a;

class q$3 implements a {
    final /* synthetic */ q ytD;

    q$3(q qVar) {
        this.ytD = qVar;
    }

    public final void a(c cVar, c.c cVar2) {
        if (cVar != null && cVar2 != null && cVar2.talker != null && this.ytD.talker != null && cVar2.talker.equals(this.ytD.talker)) {
            this.ytD.crL();
        }
    }
}
