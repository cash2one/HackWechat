package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.t;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.6;

class AppBrandProfileUI$6$1 implements Runnable {
    final /* synthetic */ long jLC;
    final /* synthetic */ 6 jLD;
    final /* synthetic */ t jLz;

    AppBrandProfileUI$6$1(6 6, t tVar, long j) {
        this.jLD = 6;
        this.jLz = tVar;
        this.jLC = j;
    }

    public final void run() {
        AppBrandProfileUI.a(this.jLD.jLy, this.jLz, this.jLC);
        if (this.jLD.jLB && !this.jLD.jLy.isFinishing() && !this.jLD.jLy.xIq) {
            q.abY().a(this.jLD.jLy, c.Dm().oAt.getLooper());
        }
    }
}
