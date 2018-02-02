package com.tencent.mm.plugin.address.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class AddInvoiceUI$2 implements OnTouchListener {
    final /* synthetic */ AddInvoiceUI imL;

    AddInvoiceUI$2(AddInvoiceUI addInvoiceUI) {
        this.imL = addInvoiceUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            return true;
        }
        if (motionEvent.getAction() != 1) {
            return false;
        }
        if (!AddInvoiceUI.b(this.imL).isActivated()) {
            AddInvoiceUI.b(this.imL).setActivated(true);
        }
        if (AddInvoiceUI.b(this.imL).isActivated()) {
            AddInvoiceUI.a(this.imL).setActivated(false);
            AddInvoiceUI.c(this.imL).type = "1";
        }
        AddInvoiceUI.d(this.imL);
        return true;
    }
}
