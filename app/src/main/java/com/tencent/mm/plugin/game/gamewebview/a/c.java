package com.tencent.mm.plugin.game.gamewebview.a;

import android.content.Context;
import com.tencent.mm.ae.b;
import com.tencent.mm.plugin.game.model.ao.a;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.protocal.c.wx;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;

public final class c {
    public static void C(Context context, int i) {
        a g = a.g(12909, new Object[]{Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(1), Integer.valueOf(6), Integer.valueOf(0), null, Integer.valueOf(i), Integer.valueOf(0), null, Integer.valueOf(bh.getInt(null, 0)), Integer.valueOf(ap.getNetworkType(context)), null});
        b.a aVar = new b.a();
        aVar.uri = "/cgi-bin/micromsg-bin/gamereportkv";
        aVar.hmi = 427;
        aVar.hml = 0;
        aVar.hmm = 0;
        com.tencent.mm.bq.a wxVar = new wx();
        wxVar.vOf = d.vAt;
        wxVar.vOg = d.vAs;
        wxVar.vOh = d.vAv;
        wxVar.vOi = d.vAw;
        wxVar.vOj = w.cfi();
        wxVar.pQs = g.hQu;
        wxVar.vOk = g.nec;
        aVar.hmj = wxVar;
    }
}
