package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.id_verify.model.f;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.s.c;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.MMActivity;

class WalletOfflineCoinPurseUI$6 implements OnClickListener {
    final /* synthetic */ WalletOfflineCoinPurseUI oYH;
    final /* synthetic */ ImageView oYN;
    final /* synthetic */ TextView oYO;
    final /* synthetic */ ImageView oYP;

    WalletOfflineCoinPurseUI$6(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI, ImageView imageView, TextView textView, ImageView imageView2) {
        this.oYH = walletOfflineCoinPurseUI;
        this.oYN = imageView;
        this.oYO = textView;
        this.oYP = imageView2;
    }

    public final void onClick(View view) {
        if (c.Bq().b(a.xxf, a.xwg)) {
            c.Bq().c(a.xxf, a.xwg);
            this.oYN.setVisibility(8);
            this.oYO.setVisibility(8);
            this.oYP.setVisibility(8);
            g.Dk();
            g.Dj().CU().a(a.xww, "");
            com.tencent.mm.plugin.report.service.g.pQN.h(14396, new Object[]{Integer.valueOf(3)});
        }
        if (o.bLq().bLM()) {
            WalletOfflineCoinPurseUI.l(this.oYH);
            return;
        }
        WalletOfflineCoinPurseUI.a(this.oYH, com.tencent.mm.wallet_core.ui.g.a(this.oYH.mController.xIM, false, new 1(this)));
        o.bLl();
        MMActivity mMActivity = this.oYH;
        com.tencent.mm.wallet_core.d.c n = WalletOfflineCoinPurseUI.n(this.oYH);
        2 2 = new 2(this);
        if (!o.a(mMActivity, n)) {
            this.oYH.r(new f("collect"));
        }
    }
}
