package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.plugin.qqmail.b.j.a;

class ComposeUI$17 extends a {
    final /* synthetic */ ComposeUI prr;

    ComposeUI$17(ComposeUI composeUI) {
        this.prr = composeUI;
    }

    public final void onComplete() {
        MailAddrsViewControl$b mailAddrsViewControl$b = new MailAddrsViewControl$b(this.prr, ComposeUI.d(this.prr).HJ(null));
        this.prr.pqx.a(mailAddrsViewControl$b);
        ComposeUI.e(this.prr).a(mailAddrsViewControl$b);
        ComposeUI.f(this.prr).a(mailAddrsViewControl$b);
    }
}
