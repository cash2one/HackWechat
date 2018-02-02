package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class GetQRCodeInfoUI$2 implements OnCancelListener {
    final /* synthetic */ GetQRCodeInfoUI qgD;

    GetQRCodeInfoUI$2(GetQRCodeInfoUI getQRCodeInfoUI) {
        this.qgD = getQRCodeInfoUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.qgD.finish();
    }
}
