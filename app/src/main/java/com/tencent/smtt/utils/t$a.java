package com.tencent.smtt.utils;

class t$a implements Runnable {
    String AbD = null;
    final /* synthetic */ t AbE;

    t$a(t tVar, String str) {
        this.AbE = tVar;
        this.AbD = str;
    }

    public final void run() {
        if (this.AbE.Qh != null) {
            this.AbE.Qh.append(this.AbD + "\n");
        }
    }
}
