package com.tencent.mm.plugin.shake.b;

import android.os.Looper;
import com.tencent.mm.bf.l;
import com.tencent.mm.by.h.d;
import com.tencent.mm.g.a.pc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.shake.c.a.f;
import com.tencent.mm.plugin.shake.d.a.o;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as.a;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.bp;
import com.tencent.mm.z.bs;
import java.util.HashMap;

public final class m implements ap {
    private static HashMap<Integer, d> gwY;
    private a hgd = new 2(this);
    private c kYX = new 7(this);
    private af mHandler = new af(Looper.getMainLooper());
    private c oKc = new 6(this);
    private ar.a oOf = new 14(this);
    private e qnW;
    private g qnX;
    private f qnY;
    private com.tencent.mm.plugin.shake.c.a.d qnZ;
    private o qoa;
    private n qob = new n();
    com.tencent.mm.pluginsdk.d.d qoc = new com.tencent.mm.pluginsdk.d.d(this) {
        final /* synthetic */ m qoh;

        {
            this.qoh = r1;
        }

        public final b Cc(String str) {
            b pcVar = new pc();
            pcVar.fGX.fok = str;
            return pcVar;
        }

        public final j aRl() {
            return m.brD();
        }
    };
    private bs.a qod = new 13(this);
    private c qoe = new 3(this);
    private bs.a qof = new 4(this);
    private bs.a qog = new bs.a(this) {
        final /* synthetic */ m qoh;

        {
            this.qoh = r1;
        }

        public final void a(com.tencent.mm.ae.d.a aVar) {
            String a = n.a(aVar.hmq.vGZ);
            if (a == null || a.length() == 0) {
                x.e("MicroMsg.SubCoreShake", "onReceiveMsg, ShakeCardRedDotMsg msgContent is null");
            } else {
                this.qoh.mHandler.post(new 1(this, a, aVar));
            }
        }
    };

    private static m brB() {
        com.tencent.mm.z.ar.Ha();
        m mVar = (m) bp.hY("plugin.shake");
        if (mVar != null) {
            return mVar;
        }
        Object mVar2 = new m();
        com.tencent.mm.z.ar.Ha().a("plugin.shake", mVar2);
        return mVar2;
    }

    public static e brC() {
        g.Dh().Ct();
        if (brB().qnW == null) {
            m brB = brB();
            com.tencent.mm.z.ar.Hg();
            brB.qnW = new e(com.tencent.mm.z.c.EV());
        }
        return brB().qnW;
    }

    public static g brD() {
        g.Dh().Ct();
        if (brB().qnX == null) {
            m brB = brB();
            com.tencent.mm.z.ar.Hg();
            brB.qnX = new g(com.tencent.mm.z.c.EV());
        }
        return brB().qnX;
    }

    public static o brE() {
        g.Dh().Ct();
        if (brB().qoa == null) {
            m brB = brB();
            com.tencent.mm.z.ar.Hg();
            brB.qoa = new o(com.tencent.mm.z.c.EV());
        }
        return brB().qoa;
    }

    public final void onAccountRelease() {
        com.tencent.mm.z.ar.Hg();
        com.tencent.mm.z.c.Fd().c(this.hgd);
        com.tencent.mm.sdk.b.a.xef.c(this.kYX);
        com.tencent.mm.sdk.b.a.xef.c(this.qoe);
        com.tencent.mm.sdk.b.a.xef.c(this.qob);
        com.tencent.mm.sdk.b.a.xef.c(this.oKc);
        com.tencent.mm.z.ar.Hg();
        com.tencent.mm.z.c.EY().b(this.oOf);
        com.tencent.mm.z.ar.getSysCmdMsgExtension().b("shake", this.qod, true);
        com.tencent.mm.z.ar.getSysCmdMsgExtension().b("ShakeCardEntrance", this.qof, true);
        com.tencent.mm.z.ar.getSysCmdMsgExtension().b("ShakeCardRedDot", this.qog, true);
        q.a.vcs = null;
    }

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("SHAKEITEM_TABLE".hashCode()), new 8());
        gwY.put(Integer.valueOf("SHAKEMSG_TABLE".hashCode()), new 9());
        gwY.put(Integer.valueOf("SHAKETVHISTORY_TABLE".hashCode()), new 10());
        gwY.put(Integer.valueOf("SHAKENEWYEARFRIENDINFO_TABLE".hashCode()), new d() {
            public final String[] wg() {
                return k.gJN;
            }
        });
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public final void gd(int i) {
    }

    public static void brF() {
        brC().brt();
        l.Tz().Tt();
    }

    public final void bq(boolean z) {
        q.a.vcs = new h();
        com.tencent.mm.z.ar.Hg();
        com.tencent.mm.z.c.Fd().b(this.hgd);
        com.tencent.mm.sdk.b.a.xef.b(this.kYX);
        com.tencent.mm.sdk.b.a.xef.b(this.qoe);
        com.tencent.mm.sdk.b.a.xef.b(this.qob);
        com.tencent.mm.sdk.b.a.xef.b(this.oKc);
        com.tencent.mm.z.ar.Hg();
        com.tencent.mm.z.c.EY().a(this.oOf);
        com.tencent.mm.z.ar.Dm().F(new 12(this));
        com.tencent.mm.z.ar.getSysCmdMsgExtension().a("shake", this.qod, true);
        com.tencent.mm.z.ar.getSysCmdMsgExtension().a("ShakeCardEntrance", this.qof, true);
        com.tencent.mm.z.ar.getSysCmdMsgExtension().a("ShakeCardRedDot", this.qog, true);
        this.qnY = null;
        this.qnZ = null;
    }

    public final void br(boolean z) {
    }

    public static int brG() {
        g.Dh().Ct();
        return i.qnL;
    }

    public static String lu(String str) {
        if (!com.tencent.mm.z.ar.Hj()) {
            return "";
        }
        r1 = new Object[2];
        com.tencent.mm.z.ar.Hg();
        r1[0] = com.tencent.mm.z.c.Fr();
        r1[1] = com.tencent.mm.a.g.s(str.getBytes());
        return String.format("%s/Sk_%s", r1);
    }

    public static String dS(String str, String str2) {
        if (!com.tencent.mm.z.ar.Hj() || bh.ov(str)) {
            return "";
        }
        r1 = new Object[3];
        com.tencent.mm.z.ar.Hg();
        r1[0] = com.tencent.mm.z.c.Fr();
        r1[1] = str2;
        r1[2] = com.tencent.mm.a.g.s(str.getBytes());
        return String.format("%s/Sk%s_%s", r1);
    }

    public static f brH() {
        g.Dh().Ct();
        if (brB().qnY == null) {
            brB().qnY = new f();
        }
        return brB().qnY;
    }

    public static com.tencent.mm.plugin.shake.c.a.d brI() {
        g.Dh().Ct();
        if (brB().qnZ == null) {
            brB().qnZ = new com.tencent.mm.plugin.shake.c.a.d();
        }
        return brB().qnZ;
    }
}
