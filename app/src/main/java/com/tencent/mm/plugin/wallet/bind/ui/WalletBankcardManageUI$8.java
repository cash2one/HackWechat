package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.wallet_core.model.g;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.e;
import java.util.Date;

class WalletBankcardManageUI$8 implements OnClickListener {
    final /* synthetic */ WalletBankcardManageUI sCF;
    final int sCI = 1000;

    WalletBankcardManageUI$8(WalletBankcardManageUI walletBankcardManageUI) {
        this.sCF = walletBankcardManageUI;
    }

    public final void onClick(View view) {
        if (view.getId() == f.uyK) {
            g bKX = g.bKX();
            if (bKX.aHh()) {
                h.b(this.sCF, bKX.oZB, this.sCF.getString(i.dGO), true);
                return;
            }
            e.HF(19);
            this.sCF.bJH();
            com.tencent.mm.plugin.report.service.g.pQN.h(14422, new Object[]{Integer.valueOf(2)});
        } else if (view.getId() == f.uyO) {
            Object tag = view.getTag();
            long time = new Date().getTime();
            view.setTag(Long.valueOf(time));
            if (tag == null || time - ((Long) tag).longValue() >= 1000) {
                r0 = new Intent();
                r0.putExtra("rawUrl", WalletBankcardManageUI.a(this.sCF).field_loan_jump_url);
                d.b(this.sCF, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", r0);
                com.tencent.mm.kernel.g.Dk();
                com.tencent.mm.kernel.g.Dj().CU().a(a.xpV, Integer.valueOf(WalletBankcardManageUI.a(this.sCF).field_red_dot_index));
                e.HF(6);
            }
        } else if (view.getId() == f.ueX) {
            r0 = new Intent();
            r0.putExtra("rawUrl", "https://kf.qq.com/touch/product/weixinpay_app.html?platform=15&ADTAG=veda.weixinpay.wenti");
            d.b(this.sCF, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", r0);
            com.tencent.mm.plugin.report.service.g.pQN.h(14422, new Object[]{Integer.valueOf(3)});
        }
    }
}
