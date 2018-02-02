package com.tencent.mm.ui.friend;

import com.tencent.mm.a.o;
import com.tencent.mm.modelfriend.ad;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.friend.f.1;

class f$1$1 implements a {
    final /* synthetic */ 1 zdi;

    f$1$1(1 1) {
        this.zdi = 1;
    }

    public final void a(boolean z, boolean z2, String str, String str2) {
        x.i("MicroMsg.QQFriendAdapterCaseB", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2});
        long longValue = new o(o.bY(str2)).longValue();
        ad be = af.OI().be(longValue);
        if (z && be != null) {
            be.username = str;
        }
        if (be != null) {
            be.hlv = 2;
            x.d("MicroMsg.QQFriendAdapterCaseB", "f :%s", new Object[]{be.toString()});
            af.OI().a(longValue, be);
            this.zdi.zdh.Xy();
        } else {
            x.w("MicroMsg.QQFriendAdapterCaseB", "cpan qq friend is null. qq:%s", new Object[]{str2});
        }
        if (z && be != null) {
            f.ZO(str);
        }
    }
}
