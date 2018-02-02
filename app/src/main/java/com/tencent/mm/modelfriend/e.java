package com.tencent.mm.modelfriend;

import com.tencent.mm.ad.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.a;

public final class e extends com.tencent.mm.z.e {
    protected final au a(bw bwVar, String str, String str2, String str3) {
        String a = n.a(bwVar.vGZ);
        if (a == null || a.length() <= 0) {
            x.e("MicroMsg.CardMsgExtension", "possible friend msg : content is null");
            return null;
        }
        a Xr = a.Xr(a);
        if (bh.ou(Xr.rYX).length() > 0) {
            h hVar = new h();
            hVar.username = Xr.rYX;
            hVar.fWe = 3;
            hVar.bA(true);
            hVar.hly = Xr.xzl;
            hVar.hlx = Xr.xzm;
            hVar.fDt = -1;
            x.d("MicroMsg.CardMsgExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[]{Xr.rYX, hVar.JG(), hVar.JH()});
            com.tencent.mm.ad.n.JQ().a(hVar);
        }
        return super.a(bwVar, str, str2, str3);
    }
}
