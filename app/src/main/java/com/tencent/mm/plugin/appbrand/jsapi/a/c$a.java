package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.os.CountDownTimer;
import com.tencent.mm.plugin.appbrand.q.j;

class c$a extends CountDownTimer {
    final /* synthetic */ c jgI;

    public c$a(c cVar) {
        this.jgI = cVar;
        super(60000, 1000);
    }

    public final void onTick(long j) {
        this.jgI.jgA.setText(this.jgI.jgr.getContentView().getResources().getString(j.izl, new Object[]{(j / 1000)}));
    }

    public final void onFinish() {
        this.jgI.afJ();
    }
}
