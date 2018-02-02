package com.tencent.c.a;

import com.tencent.c.e.a.b.a;
import com.tencent.c.e.a.b.d;
import com.tencent.c.e.a.c;

class d$1 implements c {
    final /* synthetic */ b zRU;
    final /* synthetic */ com.tencent.c.b.c zRV;

    public d$1(b bVar, com.tencent.c.b.c cVar) {
        this.zRU = bVar;
        this.zRV = cVar;
    }

    public final void Yn() {
        this.zRU.m(-10, new byte[0]);
    }

    public final d a(String str, String str2, a aVar) {
        boolean a = d.a(this.zRV, this.zRU, str, str2, aVar);
        d dVar = new d();
        if (!a) {
            dVar.errorCode = -1;
        }
        return dVar;
    }

    public final com.tencent.c.e.a.b.c b(String str, String str2, a aVar) {
        boolean a = d.a(this.zRV, this.zRU, str, str2, aVar);
        com.tencent.c.e.a.b.c cVar = new com.tencent.c.e.a.b.c();
        if (!a) {
            cVar.errCode = -1;
        }
        return cVar;
    }
}
