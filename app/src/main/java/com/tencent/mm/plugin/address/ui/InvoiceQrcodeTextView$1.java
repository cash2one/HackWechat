package com.tencent.mm.plugin.address.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bh;

class InvoiceQrcodeTextView$1 implements OnClickListener {
    final /* synthetic */ InvoiceQrcodeTextView inz;

    InvoiceQrcodeTextView$1(InvoiceQrcodeTextView invoiceQrcodeTextView) {
        this.inz = invoiceQrcodeTextView;
    }

    public final void onClick(View view) {
        if (InvoiceQrcodeTextView.a(this.inz).getVisibility() == 0 && this.inz.imW && InvoiceQrcodeTextView.b(this.inz) != 2 && !bh.ov(this.inz.getText())) {
            this.inz.iny.setText("");
            InvoiceQrcodeTextView.a(this.inz, InvoiceQrcodeTextView.c(this.inz).isFocused());
        }
    }
}
