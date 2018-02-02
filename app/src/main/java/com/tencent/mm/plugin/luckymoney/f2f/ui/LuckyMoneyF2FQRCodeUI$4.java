package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.widget.g;

class LuckyMoneyF2FQRCodeUI$4 implements OnClickListener {
    final /* synthetic */ LuckyMoneyF2FQRCodeUI oar;

    LuckyMoneyF2FQRCodeUI$4(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        this.oar = luckyMoneyF2FQRCodeUI;
    }

    public final void onClick(View view) {
        LuckyMoneyF2FQRCodeUI.a(this.oar, new g(this.oar, g.ztp, false));
        LuckyMoneyF2FQRCodeUI.y(this.oar).rKC = LuckyMoneyF2FQRCodeUI.x(this.oar);
        LuckyMoneyF2FQRCodeUI.y(this.oar).rKD = LuckyMoneyF2FQRCodeUI.z(this.oar);
        LuckyMoneyF2FQRCodeUI.y(this.oar).bUk();
    }
}
