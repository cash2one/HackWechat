package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.id_verify.model.f;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.s.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.MMActivity;

class WalletOfflineCoinPurseUI$9 implements OnClickListener {
    final /* synthetic */ WalletOfflineCoinPurseUI oYH;
    final /* synthetic */ ImageView oYT;

    WalletOfflineCoinPurseUI$9(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI, ImageView imageView) {
        this.oYH = walletOfflineCoinPurseUI;
        this.oYT = imageView;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "click qr reward");
        g.pQN.h(14021, new Object[]{Integer.valueOf(5), Integer.valueOf(WalletOfflineCoinPurseUI.p(this.oYH))});
        if (c.Bq().b(a.xxh, a.xwg)) {
            c.Bq().c(a.xxh, a.xwg);
            this.oYT.setVisibility(8);
        }
        if (o.bLq().bLM()) {
            d.y(this.oYH.mController.xIM, "collect", ".reward.ui.QrRewardMainUI");
            return;
        }
        WalletOfflineCoinPurseUI.a(this.oYH, com.tencent.mm.wallet_core.ui.g.a(this.oYH.mController.xIM, false, new 1(this)));
        o.bLl();
        MMActivity mMActivity = this.oYH;
        com.tencent.mm.wallet_core.d.c r = WalletOfflineCoinPurseUI.r(this.oYH);
        2 2 = new 2(this);
        if (!o.a(mMActivity, r)) {
            this.oYH.r(new f("reward"));
        }
    }
}
