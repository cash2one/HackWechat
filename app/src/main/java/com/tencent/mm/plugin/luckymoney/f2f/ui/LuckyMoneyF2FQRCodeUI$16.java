package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI;

class LuckyMoneyF2FQRCodeUI$16 implements OnClickListener {
    final /* synthetic */ LuckyMoneyF2FQRCodeUI oar;

    LuckyMoneyF2FQRCodeUI$16(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        this.oar = luckyMoneyF2FQRCodeUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.oar, LuckyMoneyPrepareUI.class);
        intent.putExtra("key_from", 2);
        this.oar.startActivity(intent);
    }
}
