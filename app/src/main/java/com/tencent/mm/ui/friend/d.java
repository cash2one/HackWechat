package com.tencent.mm.ui.friend;

import android.content.Context;
import com.tencent.mm.ad.d.a;
import com.tencent.mm.modelfriend.ad;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.o;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bo;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

public abstract class d extends o<ad> implements a {
    public d(Context context, ad adVar) {
        super(context, adVar);
    }

    public void a(a aVar) {
    }

    public void CN(String str) {
    }

    public static void ZO(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.QQFriendAdapterBase", "deal add friend failed. username is null.");
            return;
        }
        ad lc = af.OI().lc(str);
        if (lc != null) {
            lc.hwS = 2;
            af.OI().a(lc.hwR, lc);
        }
        ar.Hg();
        com.tencent.mm.l.a WO = c.EY().WO(str);
        if (WO == null) {
            x.w("MicroMsg.QQFriendAdapterBase", "[cpan] dealAddFriend failed. contact is null.");
            return;
        }
        if (bh.ov(WO.field_username)) {
            WO.setUsername(str);
        }
        if (((int) WO.gJd) == 0) {
            ar.Hg();
            c.EY().S(WO);
            if (!bh.ov(WO.field_username)) {
                ar.Hg();
                WO = c.EY().WO(WO.field_username);
            } else {
                return;
            }
        }
        if (((int) WO.gJd) <= 0) {
            x.e("MicroMsg.QQFriendAdapterBase", "addContact : insert contact failed");
            return;
        }
        s.p(WO);
        bo.HS().c(26, new Object[0]);
    }
}
