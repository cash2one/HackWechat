package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MailAddrProfileUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ MailAddrProfileUI psT;

    MailAddrProfileUI$1(MailAddrProfileUI mailAddrProfileUI) {
        this.psT = mailAddrProfileUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.psT.aWs();
        this.psT.finish();
        return true;
    }
}
