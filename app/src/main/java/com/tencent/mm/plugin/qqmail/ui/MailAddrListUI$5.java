package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MailAddrListUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ MailAddrListUI psL;

    MailAddrListUI$5(MailAddrListUI mailAddrListUI) {
        this.psL = mailAddrListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.psL.setResult(0);
        this.psL.finish();
        return true;
    }
}
