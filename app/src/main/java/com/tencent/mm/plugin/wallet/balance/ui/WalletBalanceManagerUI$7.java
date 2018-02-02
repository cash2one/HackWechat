package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.z.q;

class WalletBalanceManagerUI$7 implements OnClickListener {
    final /* synthetic */ WalletBalanceManagerUI szV;

    WalletBalanceManagerUI$7(WalletBalanceManagerUI walletBalanceManagerUI) {
        this.szV = walletBalanceManagerUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", "https://kf.qq.com/touch/scene_product.html?scene_id=kf4");
        intent.putExtra("showShare", false);
        intent.putExtra("geta8key_username", q.FS());
        d.b(this.szV, "webview", ".ui.tools.WebViewUI", intent);
        e.HF(17);
    }
}
