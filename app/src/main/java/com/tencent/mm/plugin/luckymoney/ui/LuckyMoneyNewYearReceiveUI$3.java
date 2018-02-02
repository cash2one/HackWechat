package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class LuckyMoneyNewYearReceiveUI$3 implements OnCancelListener {
    final /* synthetic */ LuckyMoneyNewYearReceiveUI oiL;

    LuckyMoneyNewYearReceiveUI$3(LuckyMoneyNewYearReceiveUI luckyMoneyNewYearReceiveUI) {
        this.oiL = luckyMoneyNewYearReceiveUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (LuckyMoneyNewYearReceiveUI.b(this.oiL) != null && LuckyMoneyNewYearReceiveUI.b(this.oiL).isShowing()) {
            LuckyMoneyNewYearReceiveUI.b(this.oiL).dismiss();
        }
        this.oiL.ogp.aXc();
        if (LuckyMoneyNewYearReceiveUI.c(this.oiL).getVisibility() == 8 || LuckyMoneyNewYearReceiveUI.d(this.oiL).getVisibility() == 4) {
            x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "usr cancel, & visibility not visiable, so finish");
            this.oiL.finish();
        }
    }
}
