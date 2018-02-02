package com.tencent.mm.plugin.address.ui;

import android.view.View;
import android.view.View.OnClickListener;

class QrcodeInvoiceUI$3 implements OnClickListener {
    final /* synthetic */ QrcodeInvoiceUI inP;

    QrcodeInvoiceUI$3(QrcodeInvoiceUI qrcodeInvoiceUI) {
        this.inP = qrcodeInvoiceUI;
    }

    public final void onClick(View view) {
        if (QrcodeInvoiceUI.b(this.inP) != null && QrcodeInvoiceUI.b(this.inP).isShowing()) {
            QrcodeInvoiceUI.b(this.inP).dismiss();
        }
    }
}
