package com.tencent.mm.bf;

import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.g.a.fl;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class l$6 extends c<fl> {
    final /* synthetic */ l hTk;

    l$6(l lVar) {
        this.hTk = lVar;
        this.xen = fl.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        fl flVar = (fl) bVar;
        int i = flVar.fuJ.fuL;
        String str = flVar.fuJ.talker;
        int i2 = flVar.fuJ.state;
        if (i == 1) {
            c Tx = l.Tx();
            b bVar2 = new b();
            bVar2.field_state = -1;
            Cursor a = Tx.gJP.a(String.format("select %s from %s where %s = %s", new Object[]{"state", "fmessage_conversation", "talker", h.fe(str)}), null, 2);
            if (a.moveToFirst()) {
                bVar2.b(a);
            }
            a.close();
            i2 = bVar2.field_state;
        } else if (i == 0) {
            if (i2 == 2) {
                l.Tx().T(str, 2);
            } else if (i2 == 1) {
                l.Tx().T(str, 1);
            } else {
                l.Tx().T(str, 0);
            }
        }
        flVar.fuK.state = i2;
        return false;
    }
}
