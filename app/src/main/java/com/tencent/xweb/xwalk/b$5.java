package com.tencent.xweb.xwalk;

class b$5 implements Runnable {
    final /* synthetic */ b AsS;
    final /* synthetic */ String jwu;
    final /* synthetic */ Object zCy;

    b$5(b bVar, Object obj, String str) {
        this.AsS = bVar;
        this.zCy = obj;
        this.jwu = str;
    }

    public final void run() {
        if (this.AsS.AsO != null) {
            XWAppBrandEngine xWAppBrandEngine = this.AsS.AsO;
            xWAppBrandEngine.addJsInterface(xWAppBrandEngine.mInstance, this.zCy, this.jwu);
        }
    }
}
