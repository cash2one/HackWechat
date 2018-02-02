package com.tencent.mm.plugin.address.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class QrcodeInvoiceUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ QrcodeInvoiceUI inP;

    QrcodeInvoiceUI$2(QrcodeInvoiceUI qrcodeInvoiceUI) {
        this.inP = qrcodeInvoiceUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        intent.setClass(this.inP, AddInvoiceUI.class);
        intent.putExtra("invoice_id", QrcodeInvoiceUI.a(this.inP));
        this.inP.startActivity(intent);
        return true;
    }
}
