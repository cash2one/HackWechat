package com.tencent.mm.plugin.i;

import com.tencent.mm.plugin.i.b.10;
import com.tencent.mm.plugin.i.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.Iterator;

class b$10$1 implements Runnable {
    final /* synthetic */ c kHX;
    final /* synthetic */ 10 kHY;

    b$10$1(10 10, c cVar) {
        this.kHY = 10;
        this.kHX = cVar;
    }

    public final void run() {
        x.d("MicroMsg.CalcWxService", "on notify change [%s] [%d]", new Object[]{this.kHX.ooU, Integer.valueOf(this.kHX.ooV.size())});
        if (!"delete".equals(this.kHX.ooU)) {
            int i = "delete".equals(this.kHX.ooU) ? 2 : 1;
            Iterator it = this.kHX.ooV.iterator();
            while (it.hasNext()) {
                au auVar = (au) it.next();
                if (auVar != null) {
                    boolean contains;
                    b bVar = this.kHY.kHR;
                    long j = auVar.field_msgId;
                    if (bVar.kHG) {
                        contains = bVar.kHF.contains(Long.valueOf(j));
                    } else {
                        contains = false;
                    }
                    if (contains) {
                        x.d("MicroMsg.CalcWxService", "it locked now [%d]", new Object[]{Long.valueOf(auVar.field_msgId)});
                    } else {
                        b.d(this.kHY.kHR).F(new a(auVar, i));
                    }
                }
            }
        }
    }
}
