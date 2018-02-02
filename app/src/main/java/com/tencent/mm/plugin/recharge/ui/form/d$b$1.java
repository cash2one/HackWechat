package com.tencent.mm.plugin.recharge.ui.form;

import com.tencent.mm.plugin.recharge.ui.form.d.b;

class d$b$1 implements Runnable {
    final /* synthetic */ b pES;

    d$b$1(b bVar) {
        this.pES = bVar;
    }

    public final void run() {
        d.a(this.pES.pER).dismissDropDown();
    }
}
