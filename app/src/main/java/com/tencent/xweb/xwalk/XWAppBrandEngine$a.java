package com.tencent.xweb.xwalk;

import java.util.TimerTask;

public class XWAppBrandEngine$a extends TimerTask {
    public boolean AsL;
    final /* synthetic */ XWAppBrandEngine AsM;
    public int bnv;

    public XWAppBrandEngine$a(XWAppBrandEngine xWAppBrandEngine, int i, boolean z) {
        this.AsM = xWAppBrandEngine;
        this.bnv = i;
        this.AsL = z;
    }

    public final void run() {
        if (!XWAppBrandEngine.a(this.AsM)) {
            XWAppBrandEngine.c(this.AsM).post(new 2(this));
        } else if (!this.AsL) {
            synchronized (this.AsM.AsK) {
                this.AsM.AsK.add(new 1(this));
            }
        }
    }
}
