package com.tencent.mm.plugin.address.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;

class QrcodeInvoiceUI$5 implements OnClickListener {
    final /* synthetic */ QrcodeInvoiceUI inP;

    QrcodeInvoiceUI$5(QrcodeInvoiceUI qrcodeInvoiceUI) {
        this.inP = qrcodeInvoiceUI;
    }

    public final void onClick(View view) {
        if (view.getId() == R.h.cqB && QrcodeInvoiceUI.b(this.inP) != null && QrcodeInvoiceUI.b(this.inP).isShowing()) {
            QrcodeInvoiceUI.b(this.inP).dismiss();
        }
    }
}
