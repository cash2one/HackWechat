package com.tencent.mm.ui.friend;

import com.tencent.mm.modelfriend.ad;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.friend.f.a;
import java.util.LinkedList;

class f$1 implements a {
    final /* synthetic */ f zdh;

    f$1(f fVar) {
        this.zdh = fVar;
    }

    public final void i(int i, String str, int i2) {
        x.d("MicroMsg.QQFriendAdapterCaseB", "[cpan] postion:%d qq:%s status:%d", Integer.valueOf(i), str, Integer.valueOf(i2));
        ad adVar = (ad) this.zdh.getItem(i);
        if (adVar == null) {
            x.e("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend is null. qq:%s", str);
            return;
        }
        x.d("MicroMsg.QQFriendAdapterCaseB", "qq friend:%s", adVar.toString());
        if (adVar.hwS == 1) {
            com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(f.a(this.zdh), new 1(this));
            aVar.vmW = adVar.hwR;
            aVar.vmV = false;
            LinkedList linkedList = new LinkedList();
            linkedList.add(Integer.valueOf(12));
            if (bh.ov(adVar.getUsername())) {
                x.w("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend username is null.");
                return;
            }
            aVar.b(adVar.getUsername(), linkedList, true);
            adVar.hlv = 1;
            af.OI().a(adVar.hwR, adVar);
            this.zdh.Xy();
        }
    }
}
