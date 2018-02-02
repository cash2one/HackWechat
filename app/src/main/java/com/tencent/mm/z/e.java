package com.tencent.mm.z;

import com.tencent.mm.ae.d;
import com.tencent.mm.ae.d.b;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;

public class e implements d {
    private static final a heP = new a((byte) 0);

    public static void a(a aVar) {
        heP.aE(aVar);
    }

    public b b(d.a aVar) {
        bw bwVar = aVar.hmq;
        String str = (String) g.Dj().CU().get(2, "");
        if (str.length() <= 0) {
            return null;
        }
        String a = n.a(bwVar.vGX);
        String a2 = n.a(bwVar.vGY);
        if (bh.ou(a).length() <= 0 || bh.ou(a2).length() <= 0) {
            x.e("MicroMsg.BaseMsgExtension", "neither from-user nor to-user can be empty");
            return null;
        }
        cf a3 = a(bwVar, a, a2, str);
        if (a3 == null) {
            return null;
        }
        int i;
        au auVar;
        boolean z = ((h) g.h(h.class)).Fg().has(a) || str.equals(a);
        if (z) {
            a3.eR(1);
            a3.dS(a2);
            i = bwVar.ktm;
            auVar = a3;
        } else {
            a3.eR(0);
            a3.dS(a);
            cf cfVar;
            if (bwVar.ktm > 3) {
                i = bwVar.ktm;
                cfVar = a3;
            } else {
                i = 3;
                cfVar = a3;
            }
        }
        auVar.eQ(i);
        if (bwVar.ngq == 10000) {
            a3.eQ(4);
        }
        a3.dY(bwVar.vHc);
        if (a3.Xq(q.FS())) {
            ae WY = ((h) g.h(h.class)).Fd().WY(a3.field_talker);
            if (WY != null) {
                WY.AU();
                ((h) g.h(h.class)).Fd().a(WY, a3.field_talker);
            }
        }
        heP.a(aVar, a3, a, a2, z);
        if (a3.field_msgId == 0) {
            ba.a(a3, aVar);
            a3.ao(ba.i(a3));
            return new b(a3, true);
        }
        ((h) g.h(h.class)).aZi().b(bwVar.vHe, a3);
        return new b(a3, false);
    }

    public au a(bw bwVar, String str, String str2, String str3) {
        String str4 = str3.equals(str) ? str2 : str;
        au F = ((h) g.h(h.class)).aZi().F(str4, bwVar.vHe);
        x.i("MicroMsg.BaseMsgExtension", "summerbadcr dkmsgid prepareMsgInfo svrid:%d localid:%d  from:%s to:%s talker:%s", new Object[]{Long.valueOf(bwVar.vHe), Long.valueOf(F.field_msgId), str, str2, str4});
        if (F.field_msgId != 0 && F.field_createTime + 604800000 < ba.n(str4, (long) bwVar.pbl)) {
            x.w("MicroMsg.BaseMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[]{Long.valueOf(bwVar.vHe), Long.valueOf(F.field_msgId)});
            ba.aK(F.field_msgId);
            F.ao(0);
        }
        if (F.field_msgId != 0) {
            return F;
        }
        F = new au();
        F.ap(bwVar.vHe);
        F.aq(ba.n(str4, (long) bwVar.pbl));
        F.setType(bwVar.ngq);
        F.setContent(bh.VY(bh.ou(n.a(bwVar.vGZ))));
        return F;
    }

    public void h(au auVar) {
    }
}
