package com.tencent.mm.plugin.card.model;

import android.os.Looper;
import com.tencent.mm.by.h.d;
import com.tencent.mm.g.a.nw;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.a.j;
import com.tencent.mm.plugin.card.a.l;
import com.tencent.mm.plugin.card.a.m;
import com.tencent.mm.plugin.card.a.o;
import com.tencent.mm.plugin.card.a.p;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.ui.b;
import com.tencent.mm.pluginsdk.q$a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import com.tencent.mm.z.bs;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

public final class am implements ap {
    private static HashMap<Integer, d> gwY;
    private com.tencent.mm.plugin.card.a.d kMA = null;
    private j kMB = null;
    private c kMC;
    private g kMD;
    private l kME;
    private j kMF;
    private com.tencent.mm.sdk.b.c kMG = new o();
    private com.tencent.mm.sdk.b.c kMH = new p();
    private com.tencent.mm.sdk.b.c kMI = new a();
    private b kMJ = new b();
    private com.tencent.mm.sdk.b.c kMK = new 1(this);
    private com.tencent.mm.sdk.b.c kML = new com.tencent.mm.sdk.b.c<nw>(this) {
        final /* synthetic */ am kMO;

        {
            this.kMO = r2;
            this.xen = nw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            x.i("MicroMsg.SubCoreCard.ResetCardRetryCounter", "deal with reset card retry counter event");
            al auB = am.auB();
            x.d("MicroMsg.PendingCardIdInfoStorage", "resetRetryCounter");
            auB.gJP.fx("PendingCardId", "update PendingCardId set retryCount = 0 where retryCount >= 10");
            return false;
        }
    };
    private bs.a kMM = new 5(this);
    private bs.a kMN = new bs.a(this) {
        final /* synthetic */ am kMO;

        {
            this.kMO = r1;
        }

        public final void a(com.tencent.mm.ae.d.a aVar) {
            String a = n.a(aVar.hmq.vGZ);
            if (a == null || a.length() == 0) {
                x.e("MicroMsg.SubCoreCard.notifyShareCardListener", "onReceiveMsg, msgContent is null");
            } else {
                this.kMO.mHandler.post(new 1(this, a, aVar));
            }
        }
    };
    private com.tencent.mm.plugin.card.a.b kMo;
    private c kMp;
    private al kMq;
    private h kMr;
    private com.tencent.mm.plugin.card.a.n kMs;
    private com.tencent.mm.plugin.card.sharecard.a.a kMt;
    private k kMu;
    private com.tencent.mm.plugin.card.sharecard.model.o kMv;
    private com.tencent.mm.plugin.card.sharecard.a.c kMw;
    private l kMx = null;
    private e kMy = null;
    private m kMz = null;
    private af mHandler = new af(Looper.getMainLooper());

    public am() {
        File file = new File(m.kLD);
        if (!file.exists()) {
            file.mkdir();
        }
        file = new File(m.kLE);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    private static am auy() {
        ar.Ha();
        am amVar = (am) bp.hY("plugin.card");
        if (amVar != null) {
            return amVar;
        }
        Object amVar2 = new am();
        ar.Ha().a("plugin.card", amVar2);
        return amVar2;
    }

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("USERCARDINFO_TABLE".hashCode()), new d() {
            public final String[] wg() {
                return c.gJN;
            }
        });
        gwY.put(Integer.valueOf("PENDINGCARDIDINFO_TABLE".hashCode()), new d() {
            public final String[] wg() {
                return al.gJN;
            }
        });
        gwY.put(Integer.valueOf("CARDMSGINFO_TABLE".hashCode()), new d() {
            public final String[] wg() {
                return h.gJN;
            }
        });
        gwY.put(Integer.valueOf("SHARECARDINFO_TABLE".hashCode()), new 10());
        gwY.put(Integer.valueOf("SHARECARDSYNCITEMINFO_TABLE".hashCode()), new d() {
            public final String[] wg() {
                return com.tencent.mm.plugin.card.sharecard.model.o.gJN;
            }
        });
        gwY.put(Integer.valueOf("CARDQRCODECONFI_TABLE".hashCode()), new 2());
        gwY.put(Integer.valueOf("CARDQRCODEDATAINFO_TABLE".hashCode()), new 3());
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        x.i("MicroMsg.SubCoreCard", "onAccountPostReset, updated = %b", new Object[]{Boolean.valueOf(z)});
        com.tencent.mm.sdk.b.a.xef.b(this.kMK);
        com.tencent.mm.sdk.b.a.xef.b(this.kML);
        com.tencent.mm.sdk.b.a.xef.b(this.kMG);
        com.tencent.mm.sdk.b.a.xef.b(this.kMH);
        com.tencent.mm.sdk.b.a.xef.b(this.kMI);
        ar.getSysCmdMsgExtension().a("carditemmsg", this.kMM, true);
        ar.getSysCmdMsgExtension().a("notifysharecard", this.kMN, true);
        this.kMx = null;
        if (this.kMy != null) {
            this.kMy.kIN.clear();
            this.kMy = null;
        }
        if (this.kMs != null) {
            com.tencent.mm.plugin.card.a.n nVar = this.kMs;
            synchronized (nVar.kJH) {
                nVar.kJH.clear();
            }
            synchronized (nVar.kJI) {
                nVar.kJI.clear();
            }
            ar.CG().b(563, nVar);
            com.tencent.mm.modelgeo.a OP = com.tencent.mm.modelgeo.c.OP();
            if (OP != null) {
                OP.c(nVar);
            }
            if (nVar.kJK != null) {
                ar.CG().c(nVar.kJK);
            }
            this.kMs = null;
        }
        if (this.kMo != null) {
            this.kMo.detach();
            this.kMo = null;
        }
        if (this.kMt != null) {
            com.tencent.mm.ae.e eVar = this.kMt;
            synchronized (eVar.gSF) {
                eVar.kIs.clear();
                eVar.kIt.clear();
            }
            if (eVar.kMT != null) {
                ar.CG().c(eVar.kMT);
            }
            ar.CG().b(903, eVar);
            this.kMt = null;
        }
        if (this.kMA != null) {
            this.kMA.release();
            com.tencent.mm.plugin.card.a.d dVar = this.kMA;
            dVar.kIv.clear();
            dVar.kIH.clear();
            dVar.kII.clear();
            dVar.kIJ.clear();
            dVar.kIL = false;
            this.kMA = null;
        }
        if (this.kMB != null) {
            j jVar = this.kMB;
            ar.CG().b(907, jVar);
            Iterator it = jVar.kJt.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Runnable runnable = (Runnable) jVar.kJv.get(str);
                jVar.kJv.remove(str);
                jVar.kJu.removeCallbacks(runnable);
            }
            jVar.kJs.clear();
            jVar.kJt.clear();
            jVar.kJv.clear();
            this.kMB = null;
        }
        if (this.kMC != null) {
            this.kMC.release();
            this.kMC = null;
        }
        if (this.kMD != null) {
            this.kMD.release();
            this.kMD = null;
        }
        this.kMz = null;
        q$a.vct = new com.tencent.mm.plugin.card.a.k();
        b.akB().registerActivityLifecycleCallbacks(this.kMJ);
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        if (auy().kMo != null) {
            auy().kMo.detach();
        }
        com.tencent.mm.sdk.b.a.xef.c(this.kMK);
        com.tencent.mm.sdk.b.a.xef.c(this.kML);
        com.tencent.mm.sdk.b.a.xef.c(this.kMG);
        com.tencent.mm.sdk.b.a.xef.c(this.kMH);
        com.tencent.mm.sdk.b.a.xef.c(this.kMI);
        ar.getSysCmdMsgExtension().b("carditemmsg", this.kMM, true);
        ar.getSysCmdMsgExtension().b("notifysharecard", this.kMN, true);
        q$a.vct = null;
        b.akB().unregisterActivityLifecycleCallbacks(this.kMJ);
    }

    public static com.tencent.mm.plugin.card.a.b auz() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (auy().kMo == null) {
            auy().kMo = new com.tencent.mm.plugin.card.a.b();
        }
        return auy().kMo;
    }

    public static c auA() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (auy().kMp == null) {
            am auy = auy();
            ar.Hg();
            auy.kMp = new c(com.tencent.mm.z.c.EV());
        }
        return auy().kMp;
    }

    public static al auB() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (auy().kMq == null) {
            am auy = auy();
            ar.Hg();
            auy.kMq = new al(com.tencent.mm.z.c.EV());
        }
        return auy().kMq;
    }

    public static h auC() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (auy().kMr == null) {
            am auy = auy();
            ar.Hg();
            auy.kMr = new h(com.tencent.mm.z.c.EV());
        }
        return auy().kMr;
    }

    public static com.tencent.mm.plugin.card.a.n auD() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (auy().kMs == null) {
            auy().kMs = new com.tencent.mm.plugin.card.a.n();
        }
        return auy().kMs;
    }

    public static l auE() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (auy().kMx == null) {
            auy().kMx = new l();
        }
        return auy().kMx;
    }

    public static e auF() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (auy().kMy == null) {
            auy().kMy = new e();
        }
        return auy().kMy;
    }

    public static m auG() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (auy().kMz == null) {
            auy().kMz = new m();
        }
        return auy().kMz;
    }

    public static com.tencent.mm.plugin.card.sharecard.a.a auH() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (auy().kMt == null) {
            auy().kMt = new com.tencent.mm.plugin.card.sharecard.a.a();
        }
        return auy().kMt;
    }

    public static k auI() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (auy().kMu == null) {
            am auy = auy();
            ar.Hg();
            auy.kMu = new k(com.tencent.mm.z.c.EV());
        }
        return auy().kMu;
    }

    public static com.tencent.mm.plugin.card.sharecard.model.o auJ() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (auy().kMv == null) {
            am auy = auy();
            ar.Hg();
            auy.kMv = new com.tencent.mm.plugin.card.sharecard.model.o(com.tencent.mm.z.c.EV());
        }
        return auy().kMv;
    }

    public static com.tencent.mm.plugin.card.sharecard.a.c auK() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (auy().kMw == null) {
            auy().kMw = new com.tencent.mm.plugin.card.sharecard.a.c();
        }
        return auy().kMw;
    }

    public static com.tencent.mm.plugin.card.a.d auL() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (auy().kMA == null) {
            auy().kMA = new com.tencent.mm.plugin.card.a.d();
        }
        return auy().kMA;
    }

    public static j auM() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (auy().kMB == null) {
            auy().kMB = new j();
        }
        return auy().kMB;
    }

    public static c auN() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (auy().kMC == null) {
            auy().kMC = new c();
        }
        return auy().kMC;
    }

    public static l auO() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (auy().kME == null) {
            am auy = auy();
            ar.Hg();
            auy.kME = new l(com.tencent.mm.z.c.EV());
        }
        return auy().kME;
    }

    public static j auP() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (auy().kMF == null) {
            am auy = auy();
            ar.Hg();
            auy.kMF = new j(com.tencent.mm.z.c.EV());
        }
        return auy().kMF;
    }

    public static g auQ() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (auy().kMD == null) {
            auy().kMD = new g();
        }
        return auy().kMD;
    }
}
