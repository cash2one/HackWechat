package com.tencent.mm.modelfriend;

import com.tencent.mm.ay.n;
import com.tencent.mm.g.a.af;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

final class d extends c<af> {
    d() {
        this.xen = af.class.getName().hashCode();
    }

    private static boolean a(af afVar) {
        if (afVar.fnY.foa == 0) {
            try {
                int Gd = q.Gd() | Downloads.RECV_BUFFER_SIZE;
                ar.Hg();
                com.tencent.mm.z.c.CU().set(34, Integer.valueOf(Gd));
                ar.Hg();
                com.tencent.mm.z.c.EX().b(new n("", "", "", "", "", "", "", "", Gd, "", ""));
                x.d("MicroMsg.FriendBindQQ.EventListener", "doClearQQFriendHelper succ ");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FriendBindQQ.EventListener", e, "", new Object[0]);
            }
        }
        return false;
    }
}
