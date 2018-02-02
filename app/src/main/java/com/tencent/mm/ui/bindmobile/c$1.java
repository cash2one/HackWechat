package com.tencent.mm.ui.bindmobile;

import com.tencent.mm.pluginsdk.ui.applet.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.bindmobile.a.b;
import java.util.LinkedList;

class c$1 implements b {
    final /* synthetic */ c ymx;

    c$1(c cVar) {
        this.ymx = cVar;
    }

    public final void h(int i, String str, int i2) {
        x.i("MicroMsg.MobileFriendAdapter", "[cpan] postion:%d md5:%s status:%d", Integer.valueOf(i), str, Integer.valueOf(i2));
        com.tencent.mm.modelfriend.b bVar = (com.tencent.mm.modelfriend.b) this.ymx.getItem(i);
        if (bVar == null) {
            x.e("MicroMsg.MobileFriendAdapter", "[cpan] mobile Friend is null. mobile:%s", str);
            return;
        }
        x.d("MicroMsg.MobileFriendAdapter", "mobile friend:%s", bVar.toString());
        if (bVar.status == 1) {
            a aVar = new a(c.a(this.ymx), new 1(this));
            aVar.vmO = new 2(this, bVar);
            if (c.c(this.ymx) instanceof MobileFriendUI) {
                ((MobileFriendUI) c.e(this.ymx)).jwN = new 3(this, bVar);
            }
            aVar.vmW = bVar.Nr();
            aVar.vmV = false;
            LinkedList linkedList = new LinkedList();
            linkedList.add(Integer.valueOf(13));
            aVar.b(bVar.getUsername(), linkedList, false);
        }
    }
}
