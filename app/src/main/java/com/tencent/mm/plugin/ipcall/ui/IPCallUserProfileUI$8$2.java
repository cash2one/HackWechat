package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.8;
import com.tencent.mm.pluginsdk.ui.applet.a.b;

class IPCallUserProfileUI$8$2 implements b {
    final /* synthetic */ 8 nNK;

    IPCallUserProfileUI$8$2(8 8) {
        this.nNK = 8;
    }

    public final boolean aUF() {
        Intent intent = new Intent();
        intent.putExtra("Contact_User", IPCallUserProfileUI.c(this.nNK.nNH));
        intent.putExtra("Contact_Scene", 13);
        d.b(this.nNK.nNH, "profile", ".ui.SayHiWithSnsPermissionUI", intent);
        return true;
    }
}
