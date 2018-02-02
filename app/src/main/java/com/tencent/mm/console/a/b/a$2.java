package com.tencent.mm.console.a.b;

import android.content.Context;

class a$2 implements Runnable {
    final /* synthetic */ a gIQ;
    final /* synthetic */ int gIR;
    final /* synthetic */ Context val$context;

    a$2(a aVar, int i, Context context) {
        this.gIQ = aVar;
        this.gIR = i;
        this.val$context = context;
    }

    public final void run() {
        a.a(this.gIQ, this.gIR);
        a.a(this.gIQ, this.val$context);
    }
}
