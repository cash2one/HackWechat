package com.tencent.mm.plugin.voip.ui;

import com.tencent.mm.R;

class e$5 implements Runnable {
    final /* synthetic */ e srL;

    e$5(e eVar) {
        this.srL = eVar;
    }

    public final void run() {
        e.l(this.srL).setText(R.l.eVu);
        this.srL.sqh.a(e.m(this.srL), d.sqb);
    }
}
