package com.tencent.mm.plugin.address.ui;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

class QrcodeInvoiceUI$6 implements OnClickListener {
    final /* synthetic */ QrcodeInvoiceUI inP;

    QrcodeInvoiceUI$6(QrcodeInvoiceUI qrcodeInvoiceUI) {
        this.inP = qrcodeInvoiceUI;
    }

    public final void onClick(View view) {
        if (view.getId() == R.h.cqD && QrcodeInvoiceUI.b(this.inP) != null) {
            QrcodeInvoiceUI qrcodeInvoiceUI = this.inP;
            if (!(qrcodeInvoiceUI.inJ == null || qrcodeInvoiceUI.inJ.isShowing())) {
                qrcodeInvoiceUI.inJ.showAtLocation(view.getRootView(), 17, 0, 0);
                qrcodeInvoiceUI.inJ.setFocusable(true);
                qrcodeInvoiceUI.inJ.setTouchable(true);
                qrcodeInvoiceUI.inJ.setBackgroundDrawable(new ColorDrawable(16777215));
                qrcodeInvoiceUI.inJ.setOutsideTouchable(true);
                qrcodeInvoiceUI.inL.setVisibility(0);
                qrcodeInvoiceUI.inK.setOnClickListener(qrcodeInvoiceUI.inN);
                qrcodeInvoiceUI.inK.setImageBitmap(qrcodeInvoiceUI.inI);
                if (qrcodeInvoiceUI.inI != null) {
                    x.e("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp != null");
                } else {
                    x.i("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp == null");
                }
                qrcodeInvoiceUI.inJ.update();
            }
            QrcodeInvoiceUI.d(this.inP);
        }
    }
}
