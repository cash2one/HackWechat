package com.tencent.xweb.xwalk;

class b$3 implements Runnable {
    final /* synthetic */ b AsS;

    b$3(b bVar) {
        this.AsS = bVar;
    }

    public final void run() {
        if (this.AsS.AsO != null) {
            XWAppBrandEngine xWAppBrandEngine = this.AsS.AsO;
            xWAppBrandEngine.nativeFinalize(xWAppBrandEngine.mInstance);
            this.AsS.AsO = null;
            this.AsS.AsP.getLooper().quit();
            this.AsS.AsP = null;
        }
    }
}
