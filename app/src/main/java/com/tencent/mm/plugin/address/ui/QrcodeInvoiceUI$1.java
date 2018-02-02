package com.tencent.mm.plugin.address.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class QrcodeInvoiceUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ QrcodeInvoiceUI inP;

    QrcodeInvoiceUI$1(QrcodeInvoiceUI qrcodeInvoiceUI) {
        this.inP = qrcodeInvoiceUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.inP.setResult(0);
        this.inP.finish();
        return true;
    }
}
