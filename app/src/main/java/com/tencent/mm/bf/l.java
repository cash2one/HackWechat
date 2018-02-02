package com.tencent.mm.bf;

import com.tencent.mm.by.h.d;
import com.tencent.mm.g.a.kk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import java.util.HashMap;
import java.util.List;

public class l implements ap {
    private static HashMap<Integer, d> gwY;
    public static int[] hTh = new int[1000];
    public static int hTi = 0;
    private final int fgq = 0;
    private n hSZ = new n();
    private g hTa;
    private c hTb;
    private d hTc = new d();
    private i hTd;
    private k hTe;
    private final long hTf = 259200000;
    private final int hTg = 2;
    private c hTj = new 6(this);

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("LBSVERIFYMESSAGE_TABLE".hashCode()), new 1());
        gwY.put(Integer.valueOf("SHAKEVERIFYMESSAGE_TABLE".hashCode()), new 2());
        gwY.put(Integer.valueOf("VERIFY_CONTACT_TABLE".hashCode()), new 3());
        gwY.put(Integer.valueOf("FMESSAGE_MSGINFO_TABLE".hashCode()), new 4());
        gwY.put(Integer.valueOf("FMESSAGE_CONVERSATION_TABLE".hashCode()), new 5());
    }

    private static l Tv() {
        ar.Ha();
        l lVar = (l) bp.hY(l.class.getName());
        if (lVar != null) {
            return lVar;
        }
        Object lVar2 = new l();
        ar.Ha().a(l.class.getName(), lVar2);
        return lVar2;
    }

    public static g Tw() {
        g.Dh().Ct();
        if (Tv().hTa == null) {
            l Tv = Tv();
            ar.Hg();
            Tv.hTa = new g(com.tencent.mm.z.c.EV());
            Tv().hTa.a(Tx(), ar.Dm().oAt.getLooper());
        }
        return Tv().hTa;
    }

    public static c Tx() {
        g.Dh().Ct();
        if (Tv().hTb == null) {
            l Tv = Tv();
            ar.Hg();
            Tv.hTb = new c(com.tencent.mm.z.c.EV());
        }
        return Tv().hTb;
    }

    public static i Ty() {
        g.Dh().Ct();
        if (Tv().hTd == null) {
            l Tv = Tv();
            ar.Hg();
            Tv.hTd = new i(com.tencent.mm.z.c.EV());
        }
        return Tv().hTd;
    }

    public static k Tz() {
        g.Dh().Ct();
        if (Tv().hTe == null) {
            l Tv = Tv();
            ar.Hg();
            Tv.hTe = new k(com.tencent.mm.z.c.EV());
        }
        return Tv().hTe;
    }

    public final void onAccountRelease() {
        com.tencent.mm.ae.d.c.b(Integer.valueOf(37), this.hSZ);
        com.tencent.mm.ae.d.c.b(Integer.valueOf(40), this.hTc);
        a.xef.c(this.hTj);
        ar.getNotification().wY();
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        com.tencent.mm.ae.d.c.a(Integer.valueOf(37), this.hSZ);
        com.tencent.mm.ae.d.c.a(Integer.valueOf(40), this.hTc);
        a.xef.b(this.hTj);
        int Tl = Tx().Tl();
        long currentTimeMillis = System.currentTimeMillis();
        ar.Hg();
        if (currentTimeMillis - bh.a((Long) com.tencent.mm.z.c.CU().get(340225, null), 0) > 259200000 && Tl > 0) {
            List Tm = Tx().Tm();
            int size = Tm.size();
            String str = (String) Tm.get(0);
            Tl = 1;
            while (Tl < size) {
                String str2 = str + ", " + ((String) Tm.get(Tl));
                Tl++;
                str = str2;
            }
            b kkVar = new kk();
            kkVar.fBI.userName = null;
            kkVar.fBI.bgo = str;
            kkVar.fBI.type = 0;
            a.xef.m(kkVar);
            ar.Hg();
            com.tencent.mm.z.c.CU().set(340225, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public final void br(boolean z) {
    }
}
