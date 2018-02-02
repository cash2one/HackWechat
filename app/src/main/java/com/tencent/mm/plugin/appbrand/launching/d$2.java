package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.config.WxaAttributes$d;

class d$2 extends aa {
    final /* synthetic */ d jxE;

    d$2(d dVar, String str, int i, String str2, int i2, WxaAttributes$d wxaAttributes$d) {
        this.jxE = dVar;
        super(str, i, str2, i2, wxaAttributes$d);
    }

    public final void ahO() {
        d.a(this.jxE);
    }

    public final void ahQ() {
        d.b(this.jxE);
    }

    public final void kO(int i) {
        if (this.jxE.jxx != null) {
            this.jxE.jxx.kO(i);
        }
    }
}
