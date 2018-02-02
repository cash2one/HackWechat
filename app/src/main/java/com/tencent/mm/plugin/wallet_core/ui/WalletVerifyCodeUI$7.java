package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.a;

class WalletVerifyCodeUI$7 implements OnClickListener {
    final /* synthetic */ WalletVerifyCodeUI sWR;
    final /* synthetic */ Bankcard syX;

    WalletVerifyCodeUI$7(WalletVerifyCodeUI walletVerifyCodeUI, Bankcard bankcard) {
        this.sWR = walletVerifyCodeUI;
        this.syX = bankcard;
    }

    public final void onClick(View view) {
        boolean z = true;
        x.i("MicroMsg.WalletVertifyCodeUI", "hy: user clicked on the reset info tv and is balance. ");
        x.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess and finish!");
        Bundle bundle = this.sWR.vf;
        bundle.putInt("key_err_code", 417);
        bundle.putBoolean("key_need_show_switch_phone", true);
        this.sWR.vf.putBoolean("key_block_bind_new_card", true);
        String str = "key_isbalance";
        if (!(this.syX == null || this.syX.bKP())) {
            z = false;
        }
        bundle.putBoolean(str, z);
        a.j(this.sWR, bundle);
        this.sWR.finish();
    }
}
