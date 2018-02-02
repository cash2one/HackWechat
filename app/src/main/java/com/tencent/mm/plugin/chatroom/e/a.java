package com.tencent.mm.plugin.chatroom.e;

import com.tencent.mm.g.b.cf;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;

public final class a implements com.tencent.mm.z.bs.a {
    public final void a(com.tencent.mm.ae.d.a aVar) {
        int i = 1;
        bw bwVar = aVar.hmq;
        if (bwVar.ngq == 10002) {
            String a = n.a(bwVar.vGZ);
            if (bh.ov(a)) {
                x.w("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "msg content is null");
                return;
            }
            String a2 = n.a(bwVar.vGX);
            ar.Hg();
            cf F = c.Fa().F(a2, bwVar.vHe);
            if (F.field_msgId <= 0) {
                i = 0;
            }
            F.ap(bwVar.vHe);
            F.aq(ba.n(a2, (long) bwVar.pbl));
            F.setType(10002);
            F.setContent(a);
            F.eR(0);
            F.dS(a2);
            F.dY(bwVar.vHc);
            F.fb(F.gjE & -769);
            ba.a(F, aVar);
            if (i == 0) {
                ba.i(F);
                return;
            }
            ar.Hg();
            c.Fa().b(bwVar.vHe, F);
            return;
        }
        x.i("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "not new xml type:%d ", new Object[]{Integer.valueOf(bwVar.ngq)});
    }
}
