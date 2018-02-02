package com.d.a.a;

import com.d.a.a.n.a;
import com.d.a.a.t.b;
import com.d.a.a.t.c;
import com.d.a.a.t.d;

class t$a implements m {
    private t$a() {
    }

    public final void a(p pVar) {
        switch (pVar.what) {
            case 8901:
                if (t.ss() != null && ((c) t.ss().get()) != null) {
                    return;
                }
                return;
            case 8902:
                if (t.ss() != null) {
                    t.ss().get();
                    return;
                }
                return;
            case 9901:
                if (t.sq() != null) {
                    b bVar = (b) t.sq().get();
                    if (bVar != null) {
                        a aVar = (a) pVar;
                        bVar.a(aVar.lat, aVar.lng, aVar.bji, aVar.bjj, aVar.bjk);
                        return;
                    }
                    return;
                }
                return;
            case 9902:
                if (t.sr() != null) {
                    d dVar = (d) t.sr().get();
                    if (dVar != null) {
                        n.b bVar2 = (n.b) pVar;
                        dVar.onMessage(bVar2.code, bVar2.message);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }
}
