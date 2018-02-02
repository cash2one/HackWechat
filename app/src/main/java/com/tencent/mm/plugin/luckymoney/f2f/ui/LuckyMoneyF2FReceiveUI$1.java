package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.view.View;
import android.view.View.OnClickListener;

class LuckyMoneyF2FReceiveUI$1 implements OnClickListener {
    final /* synthetic */ LuckyMoneyF2FReceiveUI oaJ;

    LuckyMoneyF2FReceiveUI$1(LuckyMoneyF2FReceiveUI luckyMoneyF2FReceiveUI) {
        this.oaJ = luckyMoneyF2FReceiveUI;
    }

    public final void onClick(View view) {
        LuckyMoneyF2FReceiveUI.a(this.oaJ).cancel();
        this.oaJ.finish();
    }
}
