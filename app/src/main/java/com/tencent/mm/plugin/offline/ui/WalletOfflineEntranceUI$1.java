package com.tencent.mm.plugin.offline.ui;

import android.content.Intent;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WalletOfflineEntranceUI$1 extends c<gi> {
    final /* synthetic */ WalletOfflineEntranceUI oZj;

    WalletOfflineEntranceUI$1(WalletOfflineEntranceUI walletOfflineEntranceUI) {
        this.oZj = walletOfflineEntranceUI;
        this.xen = gi.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicroMsg.WalletOfflineEntranceUI", "rcv fuck event: %s", new Object[]{((gi) bVar).fwu.fwv});
        Intent intent = new Intent();
        intent.putExtra("key_callback", r6.fwu.fwv);
        this.oZj.setResult(-1, intent);
        this.oZj.finish();
        return false;
    }
}
