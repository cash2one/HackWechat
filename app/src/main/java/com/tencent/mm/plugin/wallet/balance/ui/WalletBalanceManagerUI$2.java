package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.z.q;

class WalletBalanceManagerUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ WalletBalanceManagerUI szV;

    WalletBalanceManagerUI$2(WalletBalanceManagerUI walletBalanceManagerUI) {
        this.szV = walletBalanceManagerUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.szV.szU.sLi);
        intent.putExtra("showShare", false);
        intent.putExtra("geta8key_username", q.FS());
        intent.putExtra("KPublisherId", "pay_blance_list");
        intent.putExtra("geta8key_scene", 33);
        d.b(this.szV, "webview", ".ui.tools.WebViewUI", intent);
        e.HF(16);
        return true;
    }
}
