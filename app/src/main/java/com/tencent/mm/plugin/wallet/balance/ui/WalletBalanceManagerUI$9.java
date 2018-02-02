package com.tencent.mm.plugin.wallet.balance.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.w.a;

class WalletBalanceManagerUI$9 implements OnClickListener {
    final /* synthetic */ WalletBalanceManagerUI szV;

    WalletBalanceManagerUI$9(WalletBalanceManagerUI walletBalanceManagerUI) {
        this.szV = walletBalanceManagerUI;
    }

    public final void onClick(View view) {
        g.Dk();
        g.Dj().CU().a(a.USERINFO_LQT_LINK_RED_DOT_INT, Integer.valueOf(-1));
        Bundle bundle = new Bundle();
        bundle.putInt("real_name_verify_mode", 0);
        bundle.putString("realname_verify_process_jump_plugin", "wallet");
        bundle.putString("realname_verify_process_jump_activity", "com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI");
        bundle.putInt("entry_scene", HardCoderJNI.FUNC_RESET_SCREEN_RESOLUTION);
        com.tencent.mm.wallet_core.a.a(this.szV, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle);
    }
}
