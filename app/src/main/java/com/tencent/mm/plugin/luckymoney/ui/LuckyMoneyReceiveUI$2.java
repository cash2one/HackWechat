package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class LuckyMoneyReceiveUI$2 implements OnCancelListener {
    final /* synthetic */ LuckyMoneyReceiveUI ojZ;

    LuckyMoneyReceiveUI$2(LuckyMoneyReceiveUI luckyMoneyReceiveUI) {
        this.ojZ = luckyMoneyReceiveUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (LuckyMoneyReceiveUI.a(this.ojZ) != null && LuckyMoneyReceiveUI.a(this.ojZ).isShowing()) {
            LuckyMoneyReceiveUI.a(this.ojZ).dismiss();
        }
        this.ojZ.ogp.aXc();
        if (LuckyMoneyReceiveUI.b(this.ojZ).getVisibility() == 8 || LuckyMoneyReceiveUI.c(this.ojZ).getVisibility() == 4) {
            x.i("MicroMsg.LuckyMoneyReceiveUI", "user cancel & finish");
            this.ojZ.finish();
        }
    }
}
