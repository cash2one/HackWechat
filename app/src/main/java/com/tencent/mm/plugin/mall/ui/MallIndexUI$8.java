package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.z.q;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

class MallIndexUI$8 implements OnClickListener {
    final /* synthetic */ MallIndexUI omF;
    final /* synthetic */ View omI;

    MallIndexUI$8(MallIndexUI mallIndexUI, View view) {
        this.omF = mallIndexUI;
        this.omI = view;
    }

    public final void onClick(View view) {
        g.Dk();
        g.Dj().CU().a(a.xvS, Integer.valueOf(-1));
        this.omI.findViewById(f.ueT).setVisibility(8);
        Intent intent;
        if (q.Gf()) {
            intent = new Intent();
            intent.putExtra("key_scene_balance_manager", 2);
            d.b(this.omF, "wallet_payu", ".balance.ui.WalletPayUBalanceManagerUI", intent);
        } else {
            intent = new Intent();
            intent.putExtra("key_scene_balance_manager", 2);
            if (TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(MallIndexUI.b(this.omF)) && MallIndexUI.c(this.omF)) {
                x.i("MicorMsg.MallIndexUI", "set quota info");
                intent.putExtra("key_inc_bal_amt_flag", MallIndexUI.b(this.omF));
                intent.putExtra("key_ecard_info", MallIndexUI.d(this.omF));
            }
            d.b(this.omF, "wallet", ".balance.ui.WalletBalanceManagerUI", intent);
        }
        e.HF(11);
        com.tencent.mm.plugin.report.service.g.pQN.h(14419, new Object[]{this.omF.ned, Integer.valueOf(2)});
    }
}
