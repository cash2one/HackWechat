package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class GetQRCodeInfoUI$3 implements OnClickListener {
    final /* synthetic */ GetQRCodeInfoUI qgD;

    GetQRCodeInfoUI$3(GetQRCodeInfoUI getQRCodeInfoUI) {
        this.qgD = getQRCodeInfoUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.qgD.finish();
    }
}
