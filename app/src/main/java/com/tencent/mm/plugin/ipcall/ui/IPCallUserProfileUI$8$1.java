package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.8;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.x;

class IPCallUserProfileUI$8$1 implements a {
    final /* synthetic */ 8 nNK;

    IPCallUserProfileUI$8$1(8 8) {
        this.nNK = 8;
    }

    public final void a(boolean z, boolean z2, String str, String str2) {
        x.d("MicroMsg.IPCallUserProfileUI", "canAddContact, ok: %b, hasSentVerify: %b, respUsername: %s, itemID: %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2});
        if (z) {
            this.nNK.nNH.nNz.setVisibility(8);
            this.nNK.nNH.nNy.setVisibility(8);
            IPCallUserProfileUI.b(this.nNK.nNH, str);
        }
    }
}
