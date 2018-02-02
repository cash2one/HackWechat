package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.25;
import com.tencent.mm.sdk.platformtools.x;

class LuckyMoneyPrepareUI$25$1 implements OnCancelListener {
    final /* synthetic */ 25 ojK;

    LuckyMoneyPrepareUI$25$1(25 25) {
        this.ojK = 25;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (LuckyMoneyPrepareUI.m(this.ojK.ojC) != null && LuckyMoneyPrepareUI.m(this.ojK.ojC).isShowing()) {
            LuckyMoneyPrepareUI.m(this.ojK.ojC).dismiss();
        }
        if (LuckyMoneyPrepareUI.n(this.ojK.ojC).getVisibility() == 8 || LuckyMoneyPrepareUI.o(this.ojK.ojC).getVisibility() == 4) {
            x.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
            this.ojK.ojC.finish();
        }
        this.ojK.ojC.ogp.aXc();
    }
}
