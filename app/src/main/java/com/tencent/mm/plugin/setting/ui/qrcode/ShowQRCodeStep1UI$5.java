package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ba.a;
import com.tencent.mm.z.ar;

class ShowQRCodeStep1UI$5 implements OnCancelListener {
    final /* synthetic */ ShowQRCodeStep1UI qgN;
    final /* synthetic */ a qgO;

    ShowQRCodeStep1UI$5(ShowQRCodeStep1UI showQRCodeStep1UI, a aVar) {
        this.qgN = showQRCodeStep1UI;
        this.qgO = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.qgO);
    }
}
