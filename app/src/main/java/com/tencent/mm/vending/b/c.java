package com.tencent.mm.vending.b;

import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.j.a;
import java.util.Iterator;

public abstract class c<_Callback> extends a<_Callback> {
    public abstract void a(_Callback _Callback, a aVar);

    public c(d dVar) {
        super(dVar);
    }

    public final synchronized void czN() {
        a(null);
    }

    public final synchronized void a(final a aVar) {
        Iterator it = czM().iterator();
        while (it.hasNext()) {
            final b bVar = (b) it.next();
            if (bVar != null) {
                if (bVar.ffh != null) {
                    this.zBL.b(bVar.ffh);
                } else {
                    this.zBL.b(d.czY());
                }
                this.zBL.a(new com.tencent.mm.vending.c.a<Void, Void>(this) {
                    final /* synthetic */ c zBR;

                    public final /* synthetic */ Object call(Object obj) {
                        Void voidR = (Void) obj;
                        this.zBR.a(bVar.zBN, aVar);
                        return voidR;
                    }
                }, com.tencent.mm.vending.c.a.zBS, true);
            }
        }
    }

    public final b<_Callback> aE(_Callback _Callback) {
        return a(new b(_Callback, this));
    }
}
