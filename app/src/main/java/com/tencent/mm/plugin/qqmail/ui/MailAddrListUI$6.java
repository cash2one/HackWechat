package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;

class MailAddrListUI$6 implements OnClickListener {
    final /* synthetic */ MailAddrListUI psL;

    MailAddrListUI$6(MailAddrListUI mailAddrListUI) {
        this.psL = mailAddrListUI;
    }

    public final void onClick(View view) {
        c.a(MailAddrListUI.g(this.psL));
    }
}
