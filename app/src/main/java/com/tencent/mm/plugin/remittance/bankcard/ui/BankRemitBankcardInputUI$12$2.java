package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.12;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.wallet_core.ui.e;

class BankRemitBankcardInputUI$12$2 implements p$d {
    final /* synthetic */ 12 pIt;

    BankRemitBankcardInputUI$12$2(12 12) {
        this.pIt = 12;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                if (bh.ov(BankRemitBankcardInputUI.b(this.pIt.pIo))) {
                    x.w("MicroMsg.BankRemitBankcardInputUI", "paylist url is null");
                } else {
                    e.l(this.pIt.pIo.mController.xIM, BankRemitBankcardInputUI.b(this.pIt.pIo), false);
                }
                g.pQN.h(14673, new Object[]{Integer.valueOf(6)});
                return;
            case 1:
                e.l(this.pIt.pIo.mController.xIM, "https://kf.qq.com/touch/scene_product.html?scene_id=kf4568", true);
                return;
            default:
                return;
        }
    }
}
