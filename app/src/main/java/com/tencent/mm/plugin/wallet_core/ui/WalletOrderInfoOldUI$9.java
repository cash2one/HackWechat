package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.ui.base.h.c;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;

class WalletOrderInfoOldUI$9 implements c {
    final /* synthetic */ WalletOrderInfoOldUI sUK;

    WalletOrderInfoOldUI$9(WalletOrderInfoOldUI walletOrderInfoOldUI) {
        this.sUK = walletOrderInfoOldUI;
    }

    public final void jl(int i) {
        switch (i) {
            case 0:
                WalletOrderInfoOldUI.a(this.sUK, false);
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(this.sUK.pbR).toString()));
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                this.sUK.startActivity(intent);
                return;
            default:
                return;
        }
    }
}
