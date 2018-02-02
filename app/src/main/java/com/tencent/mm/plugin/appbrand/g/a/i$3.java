package com.tencent.mm.plugin.appbrand.g.a;

import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;

class i$3 implements Runnable {
    final /* synthetic */ String gIt;
    final /* synthetic */ f jwE;
    final /* synthetic */ i jwF;

    public i$3(i iVar, f fVar, String str) {
        this.jwF = iVar;
        this.jwE = fVar;
        this.gIt = str;
    }

    public final void run() {
        f fVar = this.jwE;
        String str = this.gIt;
        if (fVar.jwm.getType("onmessage") == 7) {
            V8Function v8Function = (V8Function) fVar.jwm.get("onmessage");
            V8Array v8Array = new V8Array(fVar.jwm);
            v8Array.push(str);
            v8Function.call(null, v8Array);
            v8Function.release();
            v8Array.release();
        }
    }
}
