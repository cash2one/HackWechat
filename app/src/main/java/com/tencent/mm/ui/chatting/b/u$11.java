package com.tencent.mm.ui.chatting.b;

class u$11 implements Runnable {
    final /* synthetic */ int jZe;
    final /* synthetic */ long val$position;
    final /* synthetic */ u yAV;

    public u$11(u uVar, long j, int i) {
        this.yAV = uVar;
        this.val$position = j;
        this.jZe = i;
    }

    public final void run() {
        this.yAV.fhr.csx().postDelayed(new 1(this), 100);
    }
}
