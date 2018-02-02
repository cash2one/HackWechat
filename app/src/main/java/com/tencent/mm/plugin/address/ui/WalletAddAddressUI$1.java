package com.tencent.mm.plugin.address.ui;

import com.tencent.mm.plugin.address.ui.AddrEditView.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class WalletAddAddressUI$1 implements a {
    final /* synthetic */ WalletAddAddressUI inY;

    WalletAddAddressUI$1(WalletAddAddressUI walletAddAddressUI) {
        this.inY = walletAddAddressUI;
    }

    public final void onClick() {
        x.i("MicroMsg.WalletAddAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this.inY, "android.permission.READ_CONTACTS", 48, null, null)), bh.cgy());
        if (com.tencent.mm.pluginsdk.g.a.a(this.inY, "android.permission.READ_CONTACTS", 48, null, null)) {
            WalletAddAddressUI.a(this.inY);
        }
    }
}
