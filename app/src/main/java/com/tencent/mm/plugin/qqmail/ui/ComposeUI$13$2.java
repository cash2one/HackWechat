package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.plugin.qqmail.ui.ComposeUI.13;
import com.tencent.mm.plugin.qqmail.ui.b.b;
import com.tencent.mm.pluginsdk.ui.tools.s;

class ComposeUI$13$2 implements b {
    final /* synthetic */ 13 prx;

    ComposeUI$13$2(13 13) {
        this.prx = 13;
    }

    public final void bkI() {
    }

    public final void onComplete() {
        this.prx.prr.pqR.dismiss();
        s.a(this.prx.prr.pqN, this.prx.prr.pre, this.prx.prr.pqY);
        this.prx.prr.prh = true;
    }
}
