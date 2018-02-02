package com.tencent.mm.plugin.luckymoney.sns;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.b.w;
import com.tencent.mm.wallet_core.ui.e;

class SnsLuckyMoneyPrepareUI$6 implements OnClickListener {
    final /* synthetic */ SnsLuckyMoneyPrepareUI ofF;
    final /* synthetic */ w ofG;

    SnsLuckyMoneyPrepareUI$6(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI, w wVar) {
        this.ofF = snsLuckyMoneyPrepareUI;
        this.ofG = wVar;
    }

    public final void onClick(View view) {
        e.l(this.ofF.mController.xIM, this.ofG.odh, false);
    }
}
