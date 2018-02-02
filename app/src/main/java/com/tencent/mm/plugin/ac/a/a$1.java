package com.tencent.mm.plugin.ac.a;

import com.tencent.mm.plugin.ac.a.a.b;

class a$1 implements Runnable {
    final /* synthetic */ String gIL;
    final /* synthetic */ a puT;

    a$1(a aVar, String str) {
        this.puT = aVar;
        this.gIL = str;
    }

    public final void run() {
        new b(this.puT).execute(new String[]{this.gIL});
    }
}
