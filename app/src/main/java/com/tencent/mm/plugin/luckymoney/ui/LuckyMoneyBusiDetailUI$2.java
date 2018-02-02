package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class LuckyMoneyBusiDetailUI$2 implements OnClickListener {
    final /* synthetic */ LuckyMoneyBusiDetailUI ogR;

    LuckyMoneyBusiDetailUI$2(LuckyMoneyBusiDetailUI luckyMoneyBusiDetailUI) {
        this.ogR = luckyMoneyBusiDetailUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.LuckyMoneyDetailUI", "RealnameGuideHelper dialog click cancel");
    }
}
