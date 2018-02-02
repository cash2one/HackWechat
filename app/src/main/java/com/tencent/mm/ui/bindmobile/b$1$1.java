package com.tencent.mm.ui.bindmobile;

import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.pluginsdk.ui.applet.a$a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.bindmobile.b.1;
import com.tencent.mm.z.bo;

class b$1$1 implements a$a {
    final /* synthetic */ 1 ymr;

    b$1$1(1 1) {
        this.ymr = 1;
    }

    public final void a(boolean z, boolean z2, String str, String str2) {
        x.i("MicroMsg.MobileFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2});
        b kS = af.OD().kS(str2);
        if (kS == null) {
            x.w("MicroMsg.MobileFriendAdapter", "cpan qq friend is null. qq:%s", new Object[]{str2});
        } else if (z) {
            kS.username = str;
            kS.status = 2;
            kS.hlv = 2;
            x.d("MicroMsg.MobileFriendAdapter", "f :%s", new Object[]{kS.toString()});
            af.OD().a(str2, kS);
            this.ymr.ymq.Xy();
            bo.HS().c(26, new Object[0]);
        }
    }
}
