package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.z.ar;

class MailImageDownloadUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ MailImageDownloadUI ptD;

    MailImageDownloadUI$1(MailImageDownloadUI mailImageDownloadUI) {
        this.ptD = mailImageDownloadUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ar.CG().c(MailImageDownloadUI.a(this.ptD));
        this.ptD.finish();
        return true;
    }
}
