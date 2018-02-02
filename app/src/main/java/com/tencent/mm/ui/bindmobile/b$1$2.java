package com.tencent.mm.ui.bindmobile;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.ui.bindmobile.b.1;

class b$1$2 implements b {
    final /* synthetic */ 1 ymr;
    final /* synthetic */ com.tencent.mm.modelfriend.b yms;

    b$1$2(1 1, com.tencent.mm.modelfriend.b bVar) {
        this.ymr = 1;
        this.yms = bVar;
    }

    public final boolean aUF() {
        Intent intent = new Intent();
        intent.putExtra("Contact_User", this.yms.getUsername());
        intent.putExtra("Contact_Nick", this.yms.Nw());
        intent.putExtra("Contact_Scene", 13);
        intent.putExtra("sayhi_with_sns_perm_send_verify", true);
        intent.putExtra("sayhi_with_sns_perm_add_remark", true);
        intent.putExtra("sayhi_with_jump_to_profile", true);
        d.b(b.b(this.ymr.ymq), "profile", ".ui.SayHiWithSnsPermissionUI", intent, 1);
        return true;
    }
}
