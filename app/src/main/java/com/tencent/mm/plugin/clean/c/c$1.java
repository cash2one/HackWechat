package com.tencent.mm.plugin.clean.c;

import java.util.ArrayList;

class c$1 implements Runnable {
    final /* synthetic */ ArrayList lft;
    final /* synthetic */ c lfu;

    c$1(c cVar, ArrayList arrayList) {
        this.lfu = cVar;
        this.lft = arrayList;
    }

    public final void run() {
        c.f(this.lfu).a(c.a(this.lfu), c.b(this.lfu), c.c(this.lfu), this.lft, c.d(this.lfu), c.e(this.lfu));
    }
}
