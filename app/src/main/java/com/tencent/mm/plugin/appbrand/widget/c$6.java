package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.mm.plugin.appbrand.widget.c.a;

class c$6 implements Runnable {
    final /* synthetic */ c jUG;

    c$6(c cVar) {
        this.jUG = cVar;
    }

    public final void run() {
        for (int i = 0; i < c.d(this.jUG).size(); i++) {
            c.a(this.jUG, c.b(this.jUG).getChildAt(i), (a) c.d(this.jUG).get(i));
        }
    }
}
