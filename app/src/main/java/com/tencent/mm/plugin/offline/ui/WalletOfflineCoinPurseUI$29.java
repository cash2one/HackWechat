package com.tencent.mm.plugin.offline.ui;

import android.text.TextUtils;
import android.view.MenuItem;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.widget.g;
import java.util.List;

class WalletOfflineCoinPurseUI$29 implements d {
    final /* synthetic */ g nal;
    final /* synthetic */ WalletOfflineCoinPurseUI oYH;
    final /* synthetic */ List oYY;

    WalletOfflineCoinPurseUI$29(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI, g gVar, List list) {
        this.oYH = walletOfflineCoinPurseUI;
        this.nal = gVar;
        this.oYY = list;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (this.nal != null) {
            this.nal.bxh();
            Bankcard bankcard = (Bankcard) this.oYY.get(i);
            com.tencent.mm.plugin.report.service.g.pQN.h(14515, new Object[]{Integer.valueOf(3)});
            if (!(bh.ov(bankcard.field_forbid_title) && bh.ov(bankcard.field_forbidWord) && bankcard.field_support_micropay)) {
                com.tencent.mm.plugin.report.service.g.pQN.h(14515, new Object[]{Integer.valueOf(4)});
            }
            String str = bankcard.field_bindSerial;
            if (!TextUtils.isEmpty(str) && !str.equals(WalletOfflineCoinPurseUI.D(this.oYH))) {
                WalletOfflineCoinPurseUI.a(this.oYH, str);
                a.GU(WalletOfflineCoinPurseUI.D(this.oYH));
                k.bgX();
                k.bgZ().oVl = WalletOfflineCoinPurseUI.D(this.oYH);
                this.oYH.bhx();
                WalletOfflineCoinPurseUI.E(this.oYH);
                WalletOfflineCoinPurseUI.F(this.oYH);
            }
        }
    }
}
