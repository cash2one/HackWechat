package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class j$7 implements OnCancelListener {
    final /* synthetic */ Dialog qSc;

    public j$7(Dialog dialog) {
        this.qSc = dialog;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.i("MicroMsg.WalletIdCardTip", "SnsLuckyMoneyNewYearTipsUI onCancel");
        if (this.qSc != null && this.qSc.isShowing()) {
            this.qSc.dismiss();
        }
    }
}
