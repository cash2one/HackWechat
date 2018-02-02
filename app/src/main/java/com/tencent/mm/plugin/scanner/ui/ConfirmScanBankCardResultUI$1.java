package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.oi;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;

class ConfirmScanBankCardResultUI$1 implements OnClickListener {
    final /* synthetic */ ConfirmScanBankCardResultUI pVe;

    ConfirmScanBankCardResultUI$1(ConfirmScanBankCardResultUI confirmScanBankCardResultUI) {
        this.pVe = confirmScanBankCardResultUI;
    }

    public final void onClick(View view) {
        if (ConfirmScanBankCardResultUI.a(this.pVe) != null) {
            String obj = ConfirmScanBankCardResultUI.a(this.pVe).getEditableText().toString();
            if (!bh.ov(obj)) {
                b oiVar = new oi();
                oiVar.fGj.action = 1;
                oiVar.fGj.cardNum = obj;
                a.xef.m(oiVar);
                ConfirmScanBankCardResultUI.b(this.pVe);
            }
        }
    }
}
