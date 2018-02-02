package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.smtt.sdk.WebView;

class p$27 implements Runnable {
    final /* synthetic */ p jEg;
    final /* synthetic */ String jEl;
    final /* synthetic */ String jEq;

    p$27(p pVar, String str, String str2) {
        this.jEg = pVar;
        this.jEq = str;
        this.jEl = str2;
    }

    public final void run() {
        int aK = j.aK(this.jEq, -1);
        r rVar = this.jEg.jDT;
        if ("light".equals(this.jEl)) {
            rVar.jEO.setImageDrawable(r.d(-1, new float[]{0.2f, 0.6f, 0.4f, 0.2f}));
            rVar.jEP.setImageDrawable(r.d(-1, new float[]{0.2f, 0.2f, 0.6f, 0.4f}));
            rVar.jEQ.setImageDrawable(r.d(-1, new float[]{0.2f, 0.4f, 0.2f, 0.6f}));
        } else {
            rVar.jEO.setImageDrawable(r.d(WebView.NIGHT_MODE_COLOR, new float[]{0.1f, 0.4f, 0.2f, 0.1f}));
            rVar.jEP.setImageDrawable(r.d(WebView.NIGHT_MODE_COLOR, new float[]{0.1f, 0.1f, 0.4f, 0.2f}));
            rVar.jEQ.setImageDrawable(r.d(WebView.NIGHT_MODE_COLOR, new float[]{0.1f, 0.2f, 0.1f, 0.4f}));
        }
        rVar.lh(aK);
        rVar.ajm();
        this.jEg.jDM.setBackgroundColor(aK);
    }
}
