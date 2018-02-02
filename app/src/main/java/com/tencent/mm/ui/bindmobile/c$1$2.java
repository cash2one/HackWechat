package com.tencent.mm.ui.bindmobile;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.pluginsdk.ui.applet.a$b;
import com.tencent.mm.ui.bindmobile.c.1;

class c$1$2 implements a$b {
    final /* synthetic */ b yms;
    final /* synthetic */ 1 ymy;

    c$1$2(1 1, b bVar) {
        this.ymy = 1;
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
        d.b(c.b(this.ymy.ymx), "profile", ".ui.SayHiWithSnsPermissionUI", intent, 1);
        return true;
    }
}
