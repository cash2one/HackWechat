package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bm.d;

class f$2 implements OnClickListener {
    final /* synthetic */ WalletBaseUI zJn;
    final /* synthetic */ String zJo;

    f$2(WalletBaseUI walletBaseUI, String str) {
        this.zJn = walletBaseUI;
        this.zJo = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        f.c(this.zJn);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.zJo);
        d.b(this.zJn.mController.xIM, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        e.HF(3);
    }
}
