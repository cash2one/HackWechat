package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.plugin.backup.e.h.a;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.protocal.c.er;
import com.tencent.mm.storage.au;
import java.util.HashMap;
import java.util.LinkedList;

public final class e implements l {
    public final int a(er erVar, boolean z, au auVar, String str, LinkedList<u> linkedList, HashMap<Long, a> hashMap, boolean z2, long j) {
        return auVar.field_content == null ? 0 : auVar.field_content.getBytes().length;
    }

    public final int a(String str, er erVar, au auVar) {
        String str2 = new String(erVar.vGZ.wJF);
        c Fa = d.aqe().aqf().Fa();
        auVar.setContent(str2);
        switch (erVar.ktN) {
            case 50:
                auVar.eQ(6);
                break;
        }
        if (auVar.field_msgId == 0) {
            com.tencent.mm.plugin.backup.g.c.i(auVar);
        } else {
            Fa.b(erVar.vHe, auVar);
        }
        return 0;
    }
}
