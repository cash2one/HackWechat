package com.tencent.mm.ui.chatting.b;

class v$5 implements Runnable {
    final /* synthetic */ v yBc;
    final /* synthetic */ String yBg;

    v$5(v vVar, String str) {
        this.yBc = vVar;
        this.yBg = str;
    }

    public final void run() {
        this.yBc.fhr.csB().p(this.yBg, -1, false);
    }
}
