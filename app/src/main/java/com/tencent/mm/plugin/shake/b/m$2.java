package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.as.a;
import com.tencent.mm.z.s;

class m$2 implements a {
    final /* synthetic */ m qoh;

    m$2(m mVar) {
        this.qoh = mVar;
    }

    public final void a(ae aeVar, as asVar) {
        if (aeVar != null && s.hh(aeVar.field_username)) {
            aeVar.setUsername("");
        }
    }
}
