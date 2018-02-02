package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.s.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;

class WalletOfflineCoinPurseUI$7 implements OnClickListener {
    final /* synthetic */ WalletOfflineCoinPurseUI oYH;
    final /* synthetic */ ImageView oYR;

    WalletOfflineCoinPurseUI$7(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI, ImageView imageView) {
        this.oYH = walletOfflineCoinPurseUI;
        this.oYR = imageView;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "click aa");
        g.pQN.h(14021, new Object[]{Integer.valueOf(3), Integer.valueOf(WalletOfflineCoinPurseUI.p(this.oYH))});
        d.y(this.oYH.mController.xIM, "aa", ".ui.AAEntranceUI");
        if (c.Bq().b(a.xxe, a.xwg)) {
            c.Bq().c(a.xxe, a.xwg);
            this.oYR.setVisibility(8);
            g.pQN.h(14396, new Object[]{Integer.valueOf(4)});
        }
    }
}
