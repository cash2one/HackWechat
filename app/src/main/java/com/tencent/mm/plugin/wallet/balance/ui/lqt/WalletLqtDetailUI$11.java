package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.wallet_core.ui.e;

class WalletLqtDetailUI$11 implements OnClickListener {
    final /* synthetic */ WalletLqtDetailUI sAM;

    WalletLqtDetailUI$11(WalletLqtDetailUI walletLqtDetailUI) {
        this.sAM = walletLqtDetailUI;
    }

    public final void onClick(View view) {
        String str = null;
        boolean z = true;
        if (r.iep) {
            Intent intent = new Intent(this.sAM, WalletLqtSaveFetchUI.class);
            String str2 = "lqt_save_fund_code";
            if (WalletLqtDetailUI.c(this.sAM) != null) {
                str = WalletLqtDetailUI.c(this.sAM).wFU;
            }
            intent.putExtra(str2, str);
            intent.putExtra("lqt_save_fetch_mode", 1);
            intent.putExtra("lqt_is_show_protocol", WalletLqtDetailUI.c(this.sAM).fKV == 1);
            str = "lqt_is_agree_protocol";
            if (WalletLqtDetailUI.c(this.sAM).wGG != 1) {
                z = false;
            }
            intent.putExtra(str, z);
            intent.putStringArrayListExtra("lqt_protocol_list", WalletLqtDetailUI.e(this.sAM));
            intent.putExtra("lqt_profile_wording", WalletLqtDetailUI.c(this.sAM).wGA);
            this.sAM.startActivity(intent);
            return;
        }
        g.cp(Integer.valueOf(WalletLqtDetailUI.c(this.sAM).vXn)).b(WalletLqtDetailUI.f(this.sAM).syB);
        if (bh.ov(WalletLqtDetailUI.c(this.sAM).wGM)) {
            intent = new Intent(this.sAM, WalletLqtSaveFetchUI.class);
            str2 = "lqt_save_fund_code";
            if (WalletLqtDetailUI.c(this.sAM) != null) {
                str = WalletLqtDetailUI.c(this.sAM).wFU;
            }
            intent.putExtra(str2, str);
            intent.putExtra("lqt_save_fetch_mode", 1);
            intent.putExtra("lqt_is_show_protocol", WalletLqtDetailUI.c(this.sAM).fKV == 1);
            str = "lqt_is_agree_protocol";
            if (WalletLqtDetailUI.c(this.sAM).wGG != 1) {
                z = false;
            }
            intent.putExtra(str, z);
            intent.putStringArrayListExtra("lqt_protocol_list", WalletLqtDetailUI.e(this.sAM));
            intent.putExtra("lqt_profile_wording", WalletLqtDetailUI.c(this.sAM).wGA);
            intent.putExtra("lqt_account_type", WalletLqtDetailUI.c(this.sAM).vXn);
            this.sAM.startActivity(intent);
            return;
        }
        x.i("MicroMsg.WalletLqtDetailUI", "click save button, go to block url: %s", new Object[]{WalletLqtDetailUI.c(this.sAM).wGM});
        e.l(this.sAM, WalletLqtDetailUI.c(this.sAM).wGM, false);
    }
}
