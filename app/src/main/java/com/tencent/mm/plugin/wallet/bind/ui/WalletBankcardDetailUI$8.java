package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h.c;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;

class WalletBankcardDetailUI$8 implements c {
    final /* synthetic */ WalletBankcardDetailUI sCq;

    WalletBankcardDetailUI$8(WalletBankcardDetailUI walletBankcardDetailUI) {
        this.sCq = walletBankcardDetailUI;
    }

    public final void jl(int i) {
        switch (i) {
            case 0:
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(this.sCq.getString(i.uPF)).toString()));
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                this.sCq.startActivity(intent);
                return;
            default:
                return;
        }
    }
}
