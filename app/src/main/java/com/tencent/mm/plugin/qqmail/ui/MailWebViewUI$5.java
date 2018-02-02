package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MailWebViewUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ MailWebViewUI ptN;

    MailWebViewUI$5(MailWebViewUI mailWebViewUI) {
        this.ptN = mailWebViewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ptN.finish();
        return true;
    }
}
