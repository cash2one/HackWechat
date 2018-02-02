package com.tencent.xweb.xwalk;

class g$4 implements Runnable {
    final /* synthetic */ g Atf;
    final /* synthetic */ String jwu;
    final /* synthetic */ Object zCy;

    g$4(g gVar, Object obj, String str) {
        this.Atf = gVar;
        this.zCy = obj;
        this.jwu = str;
    }

    public final void run() {
        if (this.Atf.Atd != null) {
            this.Atf.Atd.addJavascriptInterface(this.zCy, this.jwu);
        }
    }
}
