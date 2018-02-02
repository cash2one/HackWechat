package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import com.tencent.mm.plugin.wenote.b.c;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.h;
import java.util.Iterator;

class c$3 implements Runnable {
    final /* synthetic */ c tSK;

    c$3(c cVar) {
        this.tSK = cVar;
    }

    public final void run() {
        synchronized (this) {
            if (c.d(this.tSK) == null) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            Iterator it = c.d(this.tSK).iterator();
            int i = 0;
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar.getType() != 1) {
                    i++;
                } else {
                    stringBuilder.append(((h) bVar).content);
                }
            }
            c.a(this.tSK, c.QV(stringBuilder.toString()));
            c.b(this.tSK, i);
        }
    }
}
