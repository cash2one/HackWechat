package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.ui.base.u;

class ComposeUI$12 implements a {
    final /* synthetic */ ComposeUI prr;

    ComposeUI$12(ComposeUI composeUI) {
        this.prr = composeUI;
    }

    public final boolean uF() {
        if (this.prr.pqU && ComposeUI.a(this.prr, false) && ComposeUI.a(this.prr) == 5) {
            ComposeUI.b(this.prr);
            if (ComposeUI.c(this.prr) != null) {
                ComposeUI.c(this.prr).dismiss();
            }
            ComposeUI.a(this.prr, u.a(this.prr, this.prr.getString(R.l.eAt), 2000));
        }
        return true;
    }
}
