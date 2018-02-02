package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class LuckyMoneyNewYearSendUI$2 implements OnCancelListener {
    final /* synthetic */ LuckyMoneyNewYearSendUI ojc;

    LuckyMoneyNewYearSendUI$2(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        this.ojc = luckyMoneyNewYearSendUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (LuckyMoneyNewYearSendUI.k(this.ojc) != null && LuckyMoneyNewYearSendUI.k(this.ojc).isShowing()) {
            LuckyMoneyNewYearSendUI.k(this.ojc).hide();
        }
        if (LuckyMoneyNewYearSendUI.q(this.ojc).getVisibility() == 8 || LuckyMoneyNewYearSendUI.r(this.ojc).getVisibility() == 4) {
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "usr cancel, & visibility not visiable, so finish");
            this.ojc.finish();
        }
        this.ojc.ogp.aXc();
    }
}
