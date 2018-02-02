package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.as.a;
import com.tencent.mm.storage.x;

class i$2 implements a {
    final /* synthetic */ i kAU;

    i$2(i iVar) {
        this.kAU = iVar;
    }

    public final void a(ae aeVar, as asVar) {
        if (aeVar != null) {
            if ("_USER_FOR_THROWBOTTLE_".equals(aeVar.field_username)) {
                aeVar.setUsername("");
            } else if (1 != aeVar.field_isSend && x.gy(aeVar.field_username) && !asVar.AX(aeVar.field_username)) {
                c.vO(aeVar.field_username);
            }
        }
    }
}
