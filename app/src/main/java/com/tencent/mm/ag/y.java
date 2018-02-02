package com.tencent.mm.ag;

import com.tencent.mm.ae.d.c;
import com.tencent.mm.ag.a.b;
import com.tencent.mm.ag.a.g;
import com.tencent.mm.ag.a.h;
import com.tencent.mm.ag.a.i;
import com.tencent.mm.ag.a.k;
import com.tencent.mm.ag.m.a;
import com.tencent.mm.by.h.d;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.bs;
import com.tencent.mm.z.e;
import com.tencent.mm.z.p;
import java.util.HashMap;

public class y implements ap {
    private static HashMap<Integer, d> gwY;
    private static long hqh = 0;
    private e hfY = new e();
    private e hqi;
    private a hqj = null;
    private k hqk = null;
    private i hql;
    private h hqm = null;
    private com.tencent.mm.ag.a.d hqn = null;
    private b hqo = null;
    private k hqp = null;
    private g hqq = null;
    private i hqr = null;
    private h hqs = null;
    private c hqt = null;
    private a hqu;
    private bs.a hqv = new 9(this);
    private as.a hqw = new 10(this);
    private e.a hqx = new 2(this);

    static /* synthetic */ void h(d dVar) {
        if (dVar.Lf() && !dVar.Lg() && dVar.bI(false) != null && dVar.bI(false).LG() != null && !bh.ov(dVar.Lm())) {
            if (((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fd().WY(dVar.Lm()) == null) {
                x.d("MicroMsg.SubCoreBiz", "father conv is null");
            }
            if (((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fd().WY(dVar.field_username) == null) {
                x.v("MicroMsg.SubCoreBiz", "add empty conv for enterprise child %s", dVar.field_username);
                ae aeVar = new ae(dVar.field_username);
                if (!dVar.Lg()) {
                    x.i("MicroMsg.SubCoreBiz", "Enterprise belong %s, userName: %s", dVar.Lm(), dVar.field_username);
                    aeVar.dH(bh.ou(dVar.Lm()));
                    aeVar.ciy();
                    ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fd().d(aeVar);
                }
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("BIZINFO_TABLE".hashCode()), new 1());
        gwY.put(Integer.valueOf("BIZKF_TABLE".hashCode()), new 3());
        gwY.put(Integer.valueOf("BIZCHAT_TABLE".hashCode()), new 4());
        gwY.put(Integer.valueOf("BIZCHATUSER_TABLE".hashCode()), new 5());
        gwY.put(Integer.valueOf("BIZCONVERSATION_TABLE".hashCode()), new 6());
        gwY.put(Integer.valueOf("BIZCHAMYUSERINFO_TABLE".hashCode()), new 7());
        gwY.put(Integer.valueOf("BIZENTERPRISE_TABLE".hashCode()), new 8());
    }

    private static synchronized y Md() {
        y yVar;
        synchronized (y.class) {
            yVar = (y) p.s(y.class);
        }
        return yVar;
    }

    public static i Me() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (Md().hql == null) {
            Md().hql = new i(com.tencent.mm.kernel.g.Dj().gQj);
        }
        return Md().hql;
    }

    public static e Mf() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (Md().hqi == null) {
            Md().hqi = new e(com.tencent.mm.kernel.g.Dj().gQj);
        }
        return Md().hqi;
    }

    public static h Mg() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (Md().hqm == null) {
            Md().hqm = new h();
            com.tencent.mm.ae.e eVar = Md().hqm;
            com.tencent.mm.kernel.g.Di().gPJ.a(675, eVar);
            com.tencent.mm.kernel.g.Di().gPJ.a(672, eVar);
            com.tencent.mm.kernel.g.Di().gPJ.a(674, eVar);
            synchronized (eVar.hpF) {
                eVar.hpH.clear();
            }
        }
        return Md().hqm;
    }

    public static com.tencent.mm.ag.a.d Mh() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (Md().hqn == null) {
            Md().hqn = new com.tencent.mm.ag.a.d(com.tencent.mm.kernel.g.Dj().gQj);
        }
        return Md().hqn;
    }

    public static b Mi() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (Md().hqo == null) {
            Md().hqo = new b(com.tencent.mm.kernel.g.Dj().gQj);
        }
        return Md().hqo;
    }

    public static k Mj() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (Md().hqp == null) {
            Md().hqp = new k(com.tencent.mm.kernel.g.Dj().gQj);
        }
        return Md().hqp;
    }

    public static g Mk() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (Md().hqq == null) {
            Md().hqq = new g(com.tencent.mm.kernel.g.Dj().gQj);
        }
        return Md().hqq;
    }

    public static h Ml() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (Md().hqs == null) {
            Md().hqs = new h();
        }
        return Md().hqs;
    }

    public static c Mm() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (Md().hqt == null) {
            Md().hqt = new c(com.tencent.mm.kernel.g.Dj().gQj);
        }
        return Md().hqt;
    }

    public static a Mn() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (Md().hqj == null) {
            Md().hqj = new a();
        }
        return Md().hqj;
    }

    public static k Mo() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (Md().hqk == null) {
            Md().hqk = new k();
        }
        return Md().hqk;
    }

    public static a Mp() {
        if (Md().hqu == null) {
            Md().hqu = new a();
        }
        return Md().hqu;
    }

    public static i Mq() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (Md().hqr == null) {
            Md().hqr = new i();
        }
        return Md().hqr;
    }

    public static long Mr() {
        if (hqh == 0) {
            Object obj = com.tencent.mm.kernel.g.Dj().CU().get(w.a.USERINFO_NEED_TO_UPDATE_CONVERSATION_TIME_DIVIDER_LONG, null);
            if (obj != null && (obj instanceof Long)) {
                hqh = ((Long) obj).longValue();
                x.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime : %d.(get from ConfigStorage)", Long.valueOf(hqh));
            }
        }
        if (hqh == 0) {
            hqh = System.currentTimeMillis();
            com.tencent.mm.kernel.g.Dj().CU().a(w.a.USERINFO_NEED_TO_UPDATE_CONVERSATION_TIME_DIVIDER_LONG, Long.valueOf(hqh));
            x.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime is 0, so get current time : %d.", Long.valueOf(hqh));
        }
        return hqh;
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        c.a(Integer.valueOf(55), this.hfY);
        c.a(Integer.valueOf(57), this.hfY);
        ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fd().b(this.hqw);
        Mf().a(this.hqx, null);
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().a("mmbizattrappsvr_BizAttrSync", this.hqv, true);
    }

    public final void onAccountRelease() {
        c.b(Integer.valueOf(55), this.hfY);
        c.b(Integer.valueOf(57), this.hfY);
        if (Md().hqm != null) {
            com.tencent.mm.ae.e eVar = Md().hqm;
            com.tencent.mm.kernel.g.Di().gPJ.b(675, eVar);
            com.tencent.mm.kernel.g.Di().gPJ.b(672, eVar);
            com.tencent.mm.kernel.g.Di().gPJ.b(674, eVar);
            synchronized (eVar.hpF) {
                eVar.hpH.clear();
            }
            eVar.hpG.clear();
        }
        if (com.tencent.mm.kernel.g.Dh().Cy()) {
            ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fd().c(this.hqw);
            Mf().a(this.hqx);
        }
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().b("mmbizattrappsvr_BizAttrSync", this.hqv, true);
    }

    public final void br(boolean z) {
    }
}
