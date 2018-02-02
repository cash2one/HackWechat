package com.tencent.mm.modelmulti;

import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.b.1;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import java.util.HashMap;

public class q implements ap {
    private b hHg;

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void br(boolean z) {
    }

    public final void bq(boolean z) {
        Object obj = Qe().hHg;
        if (obj != null) {
            ar.Hg().FK().a(obj, ar.Dm().oAt.getLooper());
            ar.Dm().F(new 1(obj));
        }
    }

    public static r Qc() {
        return ((b) g.h(b.class)).Qc();
    }

    public static b Qd() {
        g.Dh().Ct();
        if (Qe().hHg == null) {
            Qe().hHg = new b();
        }
        return Qe().hHg;
    }

    private static q Qe() {
        ar.Ha();
        q qVar = (q) bp.hY(q.class.getName());
        if (qVar != null) {
            return qVar;
        }
        Object qVar2 = new q();
        ar.Ha().a(q.class.getName(), qVar2);
        return qVar2;
    }

    public final void onAccountRelease() {
        a aVar = Qe().hHg;
        if (aVar != null) {
            x.i("MicroMsg.GetChatRoomMsgService", "clear clearList.size:%d needGetInfosMap.size:%d respList.size:%d, currentListener:%s", Integer.valueOf(aVar.hEC.size()), Integer.valueOf(aVar.hEB.size()), Integer.valueOf(aVar.hyz.size()), aVar.hED);
            aVar.hyD.TG();
            aVar.hyE.TG();
            aVar.hEC.clear();
            aVar.hEB.clear();
            aVar.hyz.clear();
            aVar.hED = null;
            aVar.hkG = false;
            ar.Hg().FK().j(aVar);
        }
    }
}
