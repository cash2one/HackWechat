package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class LuckyMoneyMyRecordUI$6 implements OnClickListener {
    final /* synthetic */ LuckyMoneyMyRecordUI oiq;

    LuckyMoneyMyRecordUI$6(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI) {
        this.oiq = luckyMoneyMyRecordUI;
    }

    public final void onClick(View view) {
        if (bh.ov(this.oiq.odq)) {
            x.w("MicroMsg.LuckyMoneyMyRecordUI", "hy: no avatar jump h5");
        } else {
            e.l(this.oiq, this.oiq.odq, true);
        }
    }
}
