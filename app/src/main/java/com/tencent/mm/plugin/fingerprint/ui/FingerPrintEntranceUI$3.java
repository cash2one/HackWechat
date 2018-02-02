package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.x;

class FingerPrintEntranceUI$3 implements OnClickListener {
    final /* synthetic */ FingerPrintEntranceUI mAi;

    FingerPrintEntranceUI$3(FingerPrintEntranceUI fingerPrintEntranceUI) {
        this.mAi = fingerPrintEntranceUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.FingerPrintEntranceUI", "user click the button to open fingerprint pay");
        d.y(this.mAi, "wallet", ".pwd.ui.WalletPasswordSettingUI");
        this.mAi.finish();
    }
}
