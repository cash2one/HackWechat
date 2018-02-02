package com.tencent.mm.wallet_core.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class f$2 implements OnClickListener {
    final /* synthetic */ WalletBaseUI sEm;

    f$2(WalletBaseUI walletBaseUI) {
        this.sEm = walletBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", "https://www.payu.co.za/wechat/contact-us/");
        d.b(this.sEm, "webview", ".ui.tools.WebViewUI", intent);
        if (this.sEm.aYf() || this.sEm.mController.contentView.getVisibility() != 0) {
            this.sEm.finish();
        }
    }
}
