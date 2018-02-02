package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.8;
import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class LuckyMoneyPrepareUI$8$1 implements OnClickListener {
    final /* synthetic */ a ojD;
    final /* synthetic */ 8 ojE;

    LuckyMoneyPrepareUI$8$1(8 8, a aVar) {
        this.ojE = 8;
        this.ojD = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.LuckyMoneyPrepareUI", "goto h5: %s", new Object[]{this.ojD.liO});
        e.l(this.ojE.ojC.mController.xIM, this.ojD.liO, false);
        LuckyMoneyPrepareUI.a(this.ojE.ojC, false);
    }
}
