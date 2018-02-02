package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class IPCallMyGiftCardUI$3 implements OnCancelListener {
    final /* synthetic */ IPCallMyGiftCardUI nKQ;

    IPCallMyGiftCardUI$3(IPCallMyGiftCardUI iPCallMyGiftCardUI) {
        this.nKQ = iPCallMyGiftCardUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        try {
            if (IPCallMyGiftCardUI.a(this.nKQ) != null) {
                ar.CG().c(IPCallMyGiftCardUI.a(this.nKQ));
            }
            this.nKQ.finish();
        } catch (Exception e) {
            x.e("MicroMsg.IPCallMyGiftCardUI", "cancel getProductListScene error: %s", new Object[]{e.getMessage()});
        }
    }
}
