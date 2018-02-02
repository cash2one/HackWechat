package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.g.a.pg;
import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class LuckyMoneyPrepareUI$8 extends c<pg> {
    final /* synthetic */ LuckyMoneyPrepareUI ojC;

    LuckyMoneyPrepareUI$8(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        this.ojC = luckyMoneyPrepareUI;
        this.xen = pg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        a aVar = ((pg) bVar).fHf.fHg;
        if (aVar != null && aVar.bKN()) {
            x.i("MicroMsg.LuckyMoneyPrepareUI", "show 261 alert item");
            LuckyMoneyPrepareUI.a(this.ojC, true);
            h.a(this.ojC.mController.xIM, aVar.fyY, "", aVar.odx, aVar.odw, new 1(this, aVar), new OnClickListener(this) {
                final /* synthetic */ LuckyMoneyPrepareUI$8 ojE;

                {
                    this.ojE = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    LuckyMoneyPrepareUI.a(this.ojE.ojC, false);
                }
            });
        }
        return false;
    }
}
