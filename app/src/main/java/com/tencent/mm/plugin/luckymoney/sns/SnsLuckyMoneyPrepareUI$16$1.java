package com.tencent.mm.plugin.luckymoney.sns;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.16;
import com.tencent.mm.sdk.platformtools.x;

class SnsLuckyMoneyPrepareUI$16$1 implements OnCancelListener {
    final /* synthetic */ 16 ofL;

    SnsLuckyMoneyPrepareUI$16$1(16 16) {
        this.ofL = 16;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.ofL.ofF.ilS != null && this.ofL.ofF.ilS.isShowing()) {
            this.ofL.ofF.ilS.hide();
        }
        if (SnsLuckyMoneyPrepareUI.g(this.ofL.ofF).getVisibility() == 8 || SnsLuckyMoneyPrepareUI.h(this.ofL.ofF).getVisibility() == 4) {
            x.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
            this.ofL.ofF.finish();
        }
        this.ofL.ofF.ogp.aXc();
    }
}
