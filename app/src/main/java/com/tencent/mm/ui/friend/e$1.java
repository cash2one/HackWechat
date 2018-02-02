package com.tencent.mm.ui.friend;

import com.tencent.mm.a.o;
import com.tencent.mm.modelfriend.ad;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.friend.e.a;
import java.util.LinkedList;

class e$1 implements a {
    final /* synthetic */ e zda;

    e$1(e eVar) {
        this.zda = eVar;
    }

    public final void i(int i, String str, int i2) {
        x.d("MicroMsg.QQFriendAdapter", "[cpan] postion:%d qq:%s status:%d", new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)});
        ad adVar = (ad) this.zda.getItem(i);
        if (adVar == null) {
            x.e("MicroMsg.QQFriendAdapter", "[cpan] qq friend is null. qq:%s", new Object[]{str});
        } else if (bh.ov(adVar.getUsername())) {
            x.e("MicroMsg.QQFriendAdapter", "[cpan] qq friend username is null. qq:%s", new Object[]{str});
        } else {
            x.d("MicroMsg.QQFriendAdapter", "qq friend:%s", new Object[]{adVar.toString()});
            if (adVar.hwS == 0) {
                int[] iArr = new int[]{o.bY(adVar.hwR)};
                g gVar = new g(e.a(this.zda), new g.a(this) {
                    final /* synthetic */ e$1 zdb;

                    {
                        this.zdb = r1;
                    }

                    public final void o(boolean z, String str) {
                        ad be = af.OI().be((long) o.bY(str));
                        if (be != null) {
                            be.hlv = 2;
                            x.d("MicroMsg.QQFriendAdapter", "qq friend onSendInviteEmail:%s", new Object[]{be.toString()});
                            af.OI().a(be.hwR, be);
                            this.zdb.zda.Xy();
                            return;
                        }
                        x.w("MicroMsg.QQFriendAdapter", "cpan qq friedn is null. qq:%s", new Object[]{be});
                    }
                }, (byte) 0);
                gVar.q(iArr);
                gVar.vmW = adVar.hwR;
                adVar.hlv = 1;
                af.OI().a(adVar.hwR, adVar);
                this.zda.Xy();
            } else if (adVar.hwS == 1) {
                com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(e.a(this.zda), new 2(this));
                aVar.vmW = adVar.hwR;
                aVar.vmV = false;
                LinkedList linkedList = new LinkedList();
                linkedList.add(Integer.valueOf(12));
                aVar.b(adVar.getUsername(), linkedList, true);
                adVar.hlv = 1;
                af.OI().a(adVar.hwR, adVar);
                this.zda.Xy();
            }
        }
    }
}
