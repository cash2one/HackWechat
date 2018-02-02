package com.tencent.mm.plugin.voip.model;

class m$4 implements Runnable {
    final /* synthetic */ String mwr;
    final /* synthetic */ m sni;

    m$4(m mVar, String str) {
        this.sni = mVar;
        this.mwr = str;
    }

    public final void run() {
        if (this.sni.smT != null) {
            j jVar = this.sni.smT;
            String str = this.mwr;
            if (jVar.slM != null) {
                jVar.smq = str;
                jVar.slM.MD(str);
            }
        }
    }
}
