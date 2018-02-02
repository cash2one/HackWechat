package com.tencent.mm.plugin.address.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class AddInvoiceUI$5 implements OnClickListener {
    final /* synthetic */ AddInvoiceUI imL;

    AddInvoiceUI$5(AddInvoiceUI addInvoiceUI) {
        this.imL = addInvoiceUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.imL.setResult(0);
        this.imL.finish();
    }
}
