package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.ui.ComposeUI.11;
import com.tencent.mm.plugin.qqmail.ui.b.b;

class ComposeUI$11$2 implements b {
    final /* synthetic */ 11 prw;

    ComposeUI$11$2(11 11) {
        this.prw = 11;
    }

    public final void bkI() {
        ComposeUI.G(this.prw.prr).setMessage(this.prw.prr.getString(R.l.eAh));
    }

    public final void onComplete() {
        ComposeUI.a(this.prw.prr, ComposeUI.H(this.prw.prr));
    }
}
