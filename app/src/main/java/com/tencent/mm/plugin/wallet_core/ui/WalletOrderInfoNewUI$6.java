package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.ui.base.h.c;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;

class WalletOrderInfoNewUI$6 implements c {
    final /* synthetic */ WalletOrderInfoNewUI sUp;

    WalletOrderInfoNewUI$6(WalletOrderInfoNewUI walletOrderInfoNewUI) {
        this.sUp = walletOrderInfoNewUI;
    }

    public final void jl(int i) {
        switch (i) {
            case 0:
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(WalletOrderInfoNewUI.t(this.sUp)).toString()));
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                this.sUp.startActivity(intent);
                return;
            default:
                return;
        }
    }
}
