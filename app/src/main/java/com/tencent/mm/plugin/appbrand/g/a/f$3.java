package com.tencent.mm.plugin.appbrand.g.a;

class f$3 implements Runnable {
    final /* synthetic */ String iTQ;
    final /* synthetic */ f jwq;
    final /* synthetic */ f$a jwr = null;

    f$3(f fVar, f$a com_tencent_mm_plugin_appbrand_g_a_f_a, String str) {
        this.jwq = fVar;
        this.iTQ = str;
    }

    public final void run() {
        if (this.jwr != null) {
            f.d(this.jwq).executeScript(this.iTQ).toString();
        } else {
            f.d(this.jwq).executeVoidScript(this.iTQ);
        }
    }
}
