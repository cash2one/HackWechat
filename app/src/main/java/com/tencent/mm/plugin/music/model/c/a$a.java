package com.tencent.mm.plugin.music.model.c;

class a$a implements Runnable {
    int action;
    final /* synthetic */ a oLt;

    public final void run() {
        if (this.oLt.oLs != null) {
            this.oLt.oLs.tC(this.action);
        }
    }

    a$a(a aVar, int i) {
        this.oLt = aVar;
        this.action = i;
    }
}
