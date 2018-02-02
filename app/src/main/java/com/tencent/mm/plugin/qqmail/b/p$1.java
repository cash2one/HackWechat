package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.plugin.qqmail.b.p.b;
import com.tencent.mm.plugin.qqmail.b.p.d;

class p$1 implements Runnable {
    final /* synthetic */ d ppe;
    final /* synthetic */ p ppf;

    p$1(p pVar, d dVar) {
        this.ppf = pVar;
        this.ppe = dVar;
    }

    public final void run() {
        b bVar = new b(this.ppf, (byte) 0);
        p.a(this.ppf).put(Long.valueOf(this.ppe.id), this.ppe);
        p.b(this.ppf).put(Long.valueOf(this.ppe.id), bVar);
        bVar.a(this.ppe);
    }
}
