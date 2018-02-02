package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.widget.input.w.a;
import com.tencent.mm.sdk.platformtools.x;

class w$a$1 implements Runnable {
    final /* synthetic */ boolean jZc;
    final /* synthetic */ String jZd;
    final /* synthetic */ int jZe;
    final /* synthetic */ int jZf;
    final /* synthetic */ a jZg;

    w$a$1(a aVar, boolean z, String str, int i, int i2) {
        this.jZg = aVar;
        this.jZc = z;
        this.jZd = str;
        this.jZe = i;
        this.jZf = i2;
    }

    public final void run() {
        if (this.jZc) {
            this.jZg.jZa.r(this.jZd);
        } else {
            this.jZg.jZa.setText(this.jZd);
        }
        try {
            this.jZg.jZa.setSelection(Math.min(this.jZe + this.jZf, this.jZd.length()));
        } catch (Exception e) {
            x.e("MicroMsg.AppBrand.WebEditText", "replace softBank to unicode, setSelection ", e);
        }
    }
}
