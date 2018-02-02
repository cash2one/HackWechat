package com.tencent.mm.z;

import android.database.Cursor;
import com.tencent.mm.ae.d.c;
import com.tencent.mm.ae.r;
import com.tencent.mm.ae.v;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.g.a.z;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.modelstat.q;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.s;
import com.tencent.mm.z.c.a;
import junit.framework.Assert;

public final class ar {
    private static ar hfR = null;
    private static final bp hfT = new bp();
    private final c hfI;
    private final ai hfQ;
    private f hfS = null;
    private final int hfU = 1;
    final a hfV;
    private bt hfW = new bt();
    private bl hfX = new bl();
    private e hfY = new e();
    private bw hfZ = new bw();
    private v hga = new v();
    private com.tencent.mm.storage.ar.a hgb = new 4(this);
    private as.a hgc = new 5(this);
    private as.a hgd = new 6(this);
    private f hge = new f();

    static /* synthetic */ void b(ar arVar) {
        c.EY().a(arVar.hgb);
        c.Fd().b(arVar.hgd);
        c.Fd().a(arVar.hgc, null);
        c.a(Integer.valueOf(9999), arVar.hfW);
        c.a(Integer.valueOf(41), arVar.hfX);
        c.a(Integer.valueOf(21), arVar.hfY);
        c.a(Integer.valueOf(35), arVar.hfY);
        c.a(Integer.valueOf(-1879048175), arVar.hfZ);
        c.a(Integer.valueOf(-1879048174), arVar.hga);
        bs sysCmdMsgExtension = ((n) g.k(n.class)).getSysCmdMsgExtension();
        sysCmdMsgExtension.a("addcontact", arVar.hge);
        sysCmdMsgExtension.a("dynacfg", arVar.hge);
        sysCmdMsgExtension.a("dynacfg_split", arVar.hge);
        sysCmdMsgExtension.a("banner", arVar.hge);
        sysCmdMsgExtension.a("midinfo", arVar.hge);
        sysCmdMsgExtension.a("revokemsg", arVar.hge);
        sysCmdMsgExtension.a("clouddelmsg", arVar.hge);
        sysCmdMsgExtension.a("updatepackage", arVar.hge);
        sysCmdMsgExtension.a("deletepackage", arVar.hge);
        sysCmdMsgExtension.a("delchatroommember", arVar.hge);
        sysCmdMsgExtension.a("WakenPush", arVar.hge);
        sysCmdMsgExtension.a("DisasterNotice", arVar.hge);
        sysCmdMsgExtension.a("EmotionKv", arVar.hge);
        sysCmdMsgExtension.a("globalalert", arVar.hge);
        sysCmdMsgExtension.a("yybsigcheck", arVar.hge);
        sysCmdMsgExtension.a("qy_status_notify", arVar.hge);
        sysCmdMsgExtension.a("qy_chat_update", arVar.hge);
        sysCmdMsgExtension.a("bindmobiletip", arVar.hge);
        sysCmdMsgExtension.a("ClientCheckConsistency", arVar.hge);
        sysCmdMsgExtension.a("ClientCheckHook", arVar.hge);
        sysCmdMsgExtension.a("ClientCheckGetAppList", arVar.hge);
        sysCmdMsgExtension.a("ClientCheckGetExtInfo", arVar.hge);
        sysCmdMsgExtension.a("functionmsg", arVar.hge);
        sysCmdMsgExtension.a("paymsg", arVar.hge);
    }

    public static boolean GZ() {
        return hfR == null;
    }

    public static void a(com.tencent.mm.network.n nVar) {
        g.Dk();
        g.Di().a(nVar);
    }

    public static void b(com.tencent.mm.network.n nVar) {
        g.Dk();
        g.Di().b(nVar);
    }

    public static void a(ah ahVar) {
        b.a(ahVar);
    }

    public static void fG(String str) {
        com.tencent.mm.kernel.a.fG(str);
    }

    public static bp Ha() {
        Hd();
        return hfT;
    }

    public static bv Dl() {
        Hd();
        return g.Dl();
    }

    public static boolean Hb() {
        return com.tencent.mm.kernel.a.Cr();
    }

    public static void by(boolean z) {
        com.tencent.mm.kernel.a.bw(z);
    }

    public static byte[] CF() {
        try {
            g.Dk();
            return g.Di().CF();
        } catch (Throwable e) {
            x.w("MicroMsg.MMCore", "get session key error, %s", new Object[]{e.getMessage()});
            x.e("MicroMsg.MMCore", "exception:%s", new Object[]{bh.i(e)});
            return null;
        }
    }

    public static void a(ai aiVar, com.tencent.mm.ae.n.a aVar) {
        hfR = new ar(aiVar, aVar);
        o.bA(ac.getContext());
    }

    public static aj getNotification() {
        return Hd().hfQ.getNotification();
    }

    public static ac ux() {
        return Hd().hfQ.ux();
    }

    private ar(ai aiVar, com.tencent.mm.ae.n.a aVar) {
        this.hfQ = aiVar;
        this.hfV = new a(this) {
            final /* synthetic */ ar hgf;

            {
                this.hgf = r1;
            }

            public final void a(c cVar, boolean z) {
                x.i("MicroMsg.MMCore", "summeranrt2 onAccountPostReset tid:%d stack[%s]", new Object[]{Long.valueOf(Thread.currentThread().getId()), bh.cgy()});
                ar.b(this.hgf);
                long currentTimeMillis = System.currentTimeMillis();
                ar.Hg();
                long dz = c.EV().dz(Thread.currentThread().getId());
                this.hgf.hfI;
                ar.Hc();
                if (z) {
                    c.EY().WU("readerapp");
                    c.CU().set(256, Boolean.valueOf(true));
                    aa.GN();
                    aa.GN();
                    Cursor cip = c.EY().cip();
                    if (cip.moveToFirst()) {
                        do {
                            af xVar = new com.tencent.mm.storage.x();
                            xVar.b(cip);
                            xVar.As();
                            c.EY().a(xVar.field_username, xVar);
                        } while (cip.moveToNext());
                    }
                    cip.close();
                    bc.hV("ver" + d.vAz);
                }
                z zVar = new z(this.hgf.hfI);
                if (z) {
                    z.w(c.EY().WO("filehelper"));
                    String FS = q.FS();
                    if (!bh.ov(FS)) {
                        xVar = c.EY().WO(FS);
                        if (((int) xVar.gJd) == 0) {
                            xVar.setUsername(FS);
                            xVar.Ag();
                            ar.Hg();
                            c.EY().R(xVar);
                        } else if (!com.tencent.mm.l.a.fZ(xVar.field_type)) {
                            xVar.Ag();
                            ar.Hg();
                            c.EY().a(FS, xVar);
                        }
                    }
                    z.a(z, "qqmail", false);
                    z.a(z, "floatbottle", false);
                    z.a(z, "shakeapp", false);
                    z.a(z, "lbsapp", false);
                    z.a(z, "medianote", false);
                    z.a(z, "newsapp", true);
                    c.Fd().WX("blogapp");
                    c.Fa().ED("blogapp");
                    c.EY().WU("blogapp");
                    z.a(z, "facebookapp", true);
                    z.a(z, "qqfriend", false);
                    z.a(z, "masssendapp", true);
                    z.a(z, "feedsapp", true);
                    c.Fd().WX("tmessage");
                    c.EY().WU("tmessage");
                    com.tencent.mm.l.a WO = c.EY().WO("voip");
                    com.tencent.mm.l.a WO2 = c.EY().WO("voipapp");
                    if (WO2 == null) {
                        WO2 = new com.tencent.mm.storage.x();
                    }
                    if (!(WO == null || ((int) WO.gJd) == 0)) {
                        c.EY().WU("voip");
                    }
                    if (((int) WO2.gJd) == 0) {
                        WO2.setUsername("voipapp");
                        WO2.Ag();
                        z.x(WO2);
                        WO2.eC(4);
                        WO2.Ap();
                        c.EY().S(WO2);
                    } else if (z) {
                        WO2.Ap();
                        c.EY().a("voipapp", WO2);
                    }
                    WO2 = c.EY().WO("officialaccounts");
                    if (WO2 == null) {
                        WO2 = new com.tencent.mm.storage.x();
                    }
                    x.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", new Object[]{Boolean.valueOf(z), Integer.valueOf((int) WO2.gJd)});
                    if (((int) WO2.gJd) == 0) {
                        WO2.setUsername("officialaccounts");
                        WO2.Ah();
                        z.x(WO2);
                        WO2.eC(3);
                        c.EY().S(WO2);
                    } else if (z) {
                        x.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
                        WO2.Ah();
                        c.EY().a("officialaccounts", WO2);
                    }
                    WO = c.EY().WO("voipaudio");
                    WO2 = c.EY().WO("voicevoipapp");
                    if (WO2 == null) {
                        WO2 = new com.tencent.mm.storage.x();
                    }
                    if (!(WO == null || ((int) WO.gJd) == 0)) {
                        c.EY().WU("voipaudio");
                    }
                    if (((int) WO2.gJd) == 0) {
                        WO2.setUsername("voicevoipapp");
                        WO2.Ag();
                        z.x(WO2);
                        WO2.eC(4);
                        WO2.Ap();
                        c.EY().S(WO2);
                    } else if (z) {
                        WO2.Ap();
                        c.EY().a("voicevoipapp", WO2);
                    }
                    z.a(z, "voiceinputapp", false);
                    z.a(z, "linkedinplugin", false);
                    WO2 = c.EY().WO("notifymessage");
                    if (WO2 == null) {
                        WO2 = new com.tencent.mm.storage.x();
                    }
                    x.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", new Object[]{Boolean.valueOf(z), Integer.valueOf((int) WO2.gJd)});
                    if (((int) WO2.gJd) == 0) {
                        WO2.setUsername("notifymessage");
                        WO2.Ah();
                        z.x(WO2);
                        WO2.eC(3);
                        c.EY().S(WO2);
                    } else if (z) {
                        x.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
                        WO2.Ah();
                        c.EY().a("notifymessage", WO2);
                    }
                    WO2 = c.EY().WO("appbrandcustomerservicemsg");
                    if (WO2 == null) {
                        WO2 = new com.tencent.mm.storage.x();
                    }
                    x.i("MicroMsg.HardCodeHelper", "hardcodeAppBrandServiceMessage:update[%B], contactID[%d]", new Object[]{Boolean.valueOf(z), Integer.valueOf((int) WO2.gJd)});
                    if (((int) WO2.gJd) == 0) {
                        WO2.setUsername("appbrandcustomerservicemsg");
                        WO2.Ah();
                        z.x(WO2);
                        WO2.setType(0);
                        WO2.eC(3);
                        c.EY().S(WO2);
                    } else if (z) {
                        x.i("MicroMsg.HardCodeHelper", "do update app brand service message accunt");
                        WO2.Ah();
                        c.EY().a("appbrandcustomerservicemsg", WO2);
                    }
                    if (z) {
                        ar.Hg();
                        c.Fd().WX("Weixin");
                        ar.Hg();
                        c.EY().WU("Weixin");
                    }
                }
                ar.Hg();
                c.EV().fS(dz);
                x.i("MicroMsg.MMCore", "summeranrt dkwt set forceManual :%b, tid[%d], take[%s]ms, stack[%s]", new Object[]{Boolean.valueOf(z), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), bh.cgy()});
                this.hgf.hfI;
                c.Fd().a(ar.Hd().hfQ.uw());
            }
        };
        g.Dk();
        g.a(a.class, new a(this));
        g.Dk().gQK.aE(aVar);
        this.hfI = new c();
        com.tencent.mm.plugin.report.service.g.pQN.a(99, 142, 1, false);
        r.a(new 2(this));
        g.Dk();
        b Di = g.Di();
        Di.gPI.aE(new com.tencent.mm.kernel.api.d(this) {
            final /* synthetic */ ar hgf;

            {
                this.hgf = r1;
            }

            public final void b(e eVar) {
                q.e(eVar);
                q.f(eVar);
            }
        });
    }

    public static void Hc() {
    }

    private static ar Hd() {
        Assert.assertNotNull("MMCore not initialized by MMApplication", hfR);
        return hfR;
    }

    public static v Cq() {
        g.Dk();
        return g.Dh().Cq();
    }

    public static s He() {
        g.Dk();
        return g.Dj().gQd;
    }

    public static ag Dm() {
        return g.Dm();
    }

    public static bs getSysCmdMsgExtension() {
        return ((n) g.k(n.class)).getSysCmdMsgExtension();
    }

    public static String CB() {
        return com.tencent.mm.kernel.a.CB();
    }

    public static void CC() {
        com.tencent.mm.kernel.a.CC();
    }

    public static int fH(String str) {
        return com.tencent.mm.kernel.a.fH(str);
    }

    public static void Hf() {
        com.tencent.mm.sdk.b.a.xef.m(new z());
    }

    public static c Hg() {
        c cVar = Hd().hfI;
        Assert.assertTrue("MMCore has not been initialize ?", cVar != null);
        return cVar;
    }

    public static com.tencent.mm.ae.n CG() {
        g.Dk();
        return g.Di().gPJ;
    }

    public static f Hh() {
        return f.xG();
    }

    public static boolean Hi() {
        g.Dh();
        return com.tencent.mm.kernel.a.Cx();
    }

    public static boolean Hj() {
        if (ac.cfw()) {
            return g.Dh().Cy();
        }
        return false;
    }

    public static boolean Cs() {
        return com.tencent.mm.kernel.a.Cs();
    }

    public static void hold() {
        com.tencent.mm.kernel.a.hold();
    }

    public static void unhold() {
        com.tencent.mm.kernel.a.unhold();
    }

    public static String Ci() {
        g.Dk();
        g.Dh();
        return com.tencent.mm.kernel.a.Ci();
    }

    public static f Hk() {
        return Hd().hge;
    }
}
