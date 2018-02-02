package com.tencent.mm.plugin.shake.b;

import android.database.Cursor;
import com.tencent.mm.g.a.jr;
import com.tencent.mm.plugin.shake.d.a.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import java.util.ArrayList;

class m$6 extends c<jr> {
    final /* synthetic */ m qoh;

    m$6(m mVar) {
        this.qoh = mVar;
        this.xen = jr.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        jr jrVar = (jr) bVar;
        if (jrVar instanceof jr) {
            switch (jrVar.fAt.action) {
                case -4:
                    Cursor brr = m.brC().brr();
                    jrVar.fAu.fvF = new ArrayList();
                    while (brr != null && brr.moveToNext()) {
                        d dVar = new d();
                        dVar.b(brr);
                        jrVar.fAu.fvF.add(i.c(dVar.field_lvbuffer, 0));
                    }
                    if (brr != null) {
                        brr.close();
                        break;
                    }
                    break;
            }
        }
        return false;
    }
}
