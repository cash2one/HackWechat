package com.tencent.mm.plugin.address.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class InvoiceListUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ InvoiceListUI ins;

    InvoiceListUI$4(InvoiceListUI invoiceListUI) {
        this.ins = invoiceListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ins.setResult(0);
        this.ins.finish();
        return true;
    }
}
