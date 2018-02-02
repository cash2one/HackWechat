package com.tencent.mm.plugin.exdevice.model;

import android.content.SharedPreferences;
import com.tencent.mm.aq.a.a.c$a;
import com.tencent.mm.aq.o;
import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.exdevice.b.k;
import com.tencent.mm.plugin.exdevice.f.b.b.a;
import com.tencent.mm.plugin.exdevice.f.b.b.b;
import com.tencent.mm.plugin.exdevice.f.b.b.e;
import com.tencent.mm.plugin.exdevice.h.c;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import com.tencent.mm.z.bs;
import java.util.HashMap;
import java.util.Map.Entry;

public final class ad implements ap {
    private static HashMap<Integer, d> gwY;
    private ab lNG = new ab();
    private b lNH;
    private c lNI;
    private com.tencent.mm.plugin.exdevice.f.b.b.d lNJ;
    private a lNK;
    private b lNL;
    private e lNM;
    private e lNN;
    private d lNO;
    private com.tencent.mm.plugin.exdevice.f.b.c lNP;
    private com.tencent.mm.plugin.exdevice.f.b.a lNQ;
    private com.tencent.mm.plugin.exdevice.f.a.c lNR;
    private com.tencent.mm.aq.a.a lNS = null;
    private com.tencent.mm.aq.a.a.c lNT = null;
    private af lNU;
    private h lNV;
    private bs.a lNW = new 8(this);
    m.b lNX = new 9(this);

    static /* synthetic */ void a(ad adVar) {
        try {
            ag.h(new 2(adVar), 30000);
        } catch (Throwable e) {
            x.e("MicroMsg.exdevice.SubCoreExDevice", "[hakon][step] exception in deviceFeaturesKVStat, %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.exdevice.SubCoreExDevice", e, "", new Object[0]);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("HARDDEVICEINFO_TABLE".hashCode()), new 1());
        gwY.put(Integer.valueOf("HARDDEVICERANKINFO_TABLE".hashCode()), new d() {
            public final String[] wg() {
                return com.tencent.mm.plugin.exdevice.f.b.b.d.gJN;
            }
        });
        gwY.put(Integer.valueOf("HARDDEVICERANKFOLLOWINFO_TABLE".hashCode()), new d() {
            public final String[] wg() {
                return a.gJN;
            }
        });
        gwY.put(Integer.valueOf("HARDDEVICELIKEINFO_TABLE".hashCode()), new d() {
            public final String[] wg() {
                return e.gJN;
            }
        });
        gwY.put(Integer.valueOf("HARDDEVICECHAMPIONINFO_TABLE".hashCode()), new d() {
            public final String[] wg() {
                return b.gJN;
            }
        });
        gwY.put(Integer.valueOf("HARDDEVICERANKDETAILINFO_TABLE".hashCode()), new 7());
    }

    public ad() {
        if (this.lNO == null) {
            this.lNO = new d();
        }
        if (this.lNN == null) {
            this.lNN = new e();
        }
        x.i("MicroMsg.exdevice.SubCoreExDevice", "create SubCoreExDevice.");
        com.tencent.mm.sdk.b.a.xef.b(this.lNN.lLx);
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    private static ad aEj() {
        ar.Ha();
        ad adVar = (ad) bp.hY("plugin.exdevice");
        if (adVar != null) {
            return adVar;
        }
        x.w("MicroMsg.exdevice.SubCoreExDevice", "not found in MMCore, new one");
        Object adVar2 = new ad();
        ar.Ha().a("plugin.exdevice", adVar2);
        return adVar2;
    }

    public static c aEk() {
        g.Dh().Ct();
        if (aEj().lNI == null) {
            ad aEj = aEj();
            ar.Hg();
            aEj.lNI = new c(com.tencent.mm.z.c.EV());
        }
        return aEj().lNI;
    }

    public static com.tencent.mm.plugin.exdevice.f.b.b.d aEl() {
        g.Dh().Ct();
        if (aEj().lNJ == null) {
            ad aEj = aEj();
            ar.Hg();
            aEj.lNJ = new com.tencent.mm.plugin.exdevice.f.b.b.d(com.tencent.mm.z.c.EV());
        }
        return aEj().lNJ;
    }

    public static a aEm() {
        g.Dh().Ct();
        if (aEj().lNK == null) {
            ad aEj = aEj();
            ar.Hg();
            aEj.lNK = new a(com.tencent.mm.z.c.EV());
        }
        return aEj().lNK;
    }

    public static com.tencent.mm.aq.a.a aEn() {
        if (aEj().lNS == null) {
            aEj().lNS = o.PA();
        }
        return aEj().lNS;
    }

    public static com.tencent.mm.aq.a.a.c yV(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.exdevice.SubCoreExDevice", "newImageOptions failed, url is null or nil, return default.");
            ad aEj = aEj();
            if (aEj.lNT == null) {
                c$a com_tencent_mm_aq_a_a_c_a = new c$a();
                o.PB();
                com_tencent_mm_aq_a_a_c_a.hDW = null;
                com_tencent_mm_aq_a_a_c_a.hDH = 640;
                com_tencent_mm_aq_a_a_c_a.hDG = 640;
                com_tencent_mm_aq_a_a_c_a.hDy = false;
                com_tencent_mm_aq_a_a_c_a.hDA = true;
                aEj.lNT = com_tencent_mm_aq_a_a_c_a.PK();
            }
            return aEj().lNT;
        }
        c$a com_tencent_mm_aq_a_a_c_a2 = new c$a();
        com_tencent_mm_aq_a_a_c_a2.hDH = 640;
        com_tencent_mm_aq_a_a_c_a2.hDG = 640;
        com_tencent_mm_aq_a_a_c_a2.hDy = false;
        com_tencent_mm_aq_a_a_c_a2.hDz = true;
        ar.Hg();
        com_tencent_mm_aq_a_a_c_a2.hDD = com.tencent.mm.z.c.Fi();
        return com_tencent_mm_aq_a_a_c_a2.PK();
    }

    public static b aEo() {
        g.Dh().Ct();
        if (aEj().lNL == null) {
            ad aEj = aEj();
            ar.Hg();
            aEj.lNL = new b(com.tencent.mm.z.c.EV());
        }
        return aEj().lNL;
    }

    public static e aEp() {
        g.Dh().Ct();
        if (aEj().lNM == null) {
            ad aEj = aEj();
            ar.Hg();
            aEj.lNM = new e(com.tencent.mm.z.c.EV());
        }
        return aEj().lNM;
    }

    public static b aEq() {
        g.Dh().Ct();
        if (aEj().lNH == null) {
            aEj().lNH = new b();
        }
        return aEj().lNH;
    }

    public static d aEr() {
        if (aEj().lNO == null) {
            aEj().lNO = new d();
        }
        return aEj().lNO;
    }

    public static com.tencent.mm.plugin.exdevice.f.b.c aEs() {
        if (aEj().lNP == null) {
            aEj().lNP = new com.tencent.mm.plugin.exdevice.f.b.c();
        }
        return aEj().lNP;
    }

    public static com.tencent.mm.plugin.exdevice.f.b.a aEt() {
        if (aEj().lNQ == null) {
            aEj().lNQ = new com.tencent.mm.plugin.exdevice.f.b.a();
        }
        return aEj().lNQ;
    }

    public static com.tencent.mm.plugin.exdevice.f.a.c aEu() {
        if (aEj().lNR == null) {
            aEj().lNR = new com.tencent.mm.plugin.exdevice.f.a.c();
        }
        return aEj().lNR;
    }

    public static e aEv() {
        if (aEj().lNN == null) {
            aEj().lNN = new e();
        }
        return aEj().lNN;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        ar.Hg();
        com.tencent.mm.z.c.EY().a(this.lNX);
        ar.CG().a(538, k.aDL());
        this.lNU = new af();
        com.tencent.mm.sdk.b.a.xef.b(this.lNG);
        ar.getSysCmdMsgExtension().a("wcdevicemsg", this.lNW, true);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lKY);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lKZ);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLa);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLt);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lKX);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lKW);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLb);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLc);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLd);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLu);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLe);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLf);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLg);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLi);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLh);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLm);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLk);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLl);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLn);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLv);
        com.tencent.mm.sdk.b.a.xef.b(aEv().kuw);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLj);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLo);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLp);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLq);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLr);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLE);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLF);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLG);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLI);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLH);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLy);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLz);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLA);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLB);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLC);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLD);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLw);
        com.tencent.mm.sdk.b.a.xef.b(aEv().lLx);
        com.tencent.mm.ae.e eVar = i.lMM;
        x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "addSceneEndListener");
        ar.CG().a(539, eVar);
        com.tencent.mm.compatible.a.a.a(19, new com.tencent.mm.compatible.a.a.a(this) {
            final /* synthetic */ ad lNY;

            {
                this.lNY = r1;
            }

            public final void run() {
                ad.a(this.lNY);
            }
        });
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        ar.Hg();
        com.tencent.mm.z.c.EY().b(this.lNX);
        com.tencent.mm.sdk.b.a.xef.c(aEv().lKY);
        com.tencent.mm.sdk.b.a.xef.c(aEv().lKZ);
        com.tencent.mm.sdk.b.a.xef.c(aEv().lLa);
        com.tencent.mm.sdk.b.a.xef.c(aEv().lLt);
        com.tencent.mm.sdk.b.a.xef.c(aEv().lLv);
        com.tencent.mm.sdk.b.a.xef.c(aEv().lKX);
        com.tencent.mm.sdk.b.a.xef.c(aEv().lKW);
        com.tencent.mm.sdk.b.a.xef.c(aEv().lLb);
        com.tencent.mm.sdk.b.a.xef.c(aEv().lLc);
        com.tencent.mm.sdk.b.a.xef.c(aEv().lLd);
        com.tencent.mm.sdk.b.a.xef.c(aEv().lLu);
        com.tencent.mm.sdk.b.a.xef.c(aEv().lLE);
        com.tencent.mm.sdk.b.a.xef.c(aEv().lLF);
        com.tencent.mm.sdk.b.a.xef.c(aEv().lLG);
        com.tencent.mm.sdk.b.a.xef.c(aEv().lLI);
        com.tencent.mm.sdk.b.a.xef.c(aEv().lLH);
        com.tencent.mm.sdk.b.a.xef.c(aEv().lLy);
        com.tencent.mm.sdk.b.a.xef.c(aEv().lLz);
        com.tencent.mm.sdk.b.a.xef.c(aEv().lLA);
        com.tencent.mm.sdk.b.a.xef.c(aEv().lLB);
        com.tencent.mm.sdk.b.a.xef.c(aEv().lLC);
        com.tencent.mm.sdk.b.a.xef.c(aEv().lLD);
        com.tencent.mm.sdk.b.a.xef.c(aEv().lLf);
        com.tencent.mm.sdk.b.a.xef.c(aEv().lLw);
        com.tencent.mm.sdk.b.a.xef.c(aEv().lLx);
        x.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "releaseAllSharePreferences");
        SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("exdevice_pref", 0);
        if (sharedPreferences == null) {
            x.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
        } else if (!sharedPreferences.edit().clear().commit()) {
            x.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().clear().commit() Failed!!!");
        }
        f aEL = u.aEL();
        x.i("MicroMsg.exdevice.ExdeviceInfoManager", "delAllDeviceAuthFlag");
        if (aEL.lQi == null) {
            x.e("MicroMsg.exdevice.ExdeviceInfoManager", "null == exdeviceInfoList");
        } else {
            for (Entry entry : aEL.lQi.entrySet()) {
                f.a aVar = (f.a) entry.getValue();
                aVar.lQm = false;
                entry.setValue(aVar);
            }
        }
        ar.CG().b(538, k.aDL());
        k.lKh = null;
        com.tencent.mm.sdk.b.a.xef.c(this.lNG);
        ar.getSysCmdMsgExtension().b("wcdevicemsg", this.lNW, true);
        com.tencent.mm.sdk.b.a.xef.c(aEv().lLe);
        if (aEj().lNH != null) {
            aEj();
        }
        com.tencent.mm.ae.e eVar = i.lMM;
        x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "removeSceneEndListener");
        ar.CG().b(539, eVar);
        d dVar = aEj().lNO;
        if (!(dVar.lKD == null || dVar.lKD.isEmpty())) {
            for (Entry entry2 : dVar.lKD.entrySet()) {
                ((ak) entry2.getValue()).TG();
            }
            dVar.lKD.clear();
        }
        if (aEj().lNP != null) {
            eVar = aEj().lNP;
            ar.CG().b(1042, eVar);
            ar.CG().b(1041, eVar);
            ar.CG().b(1043, eVar);
            ar.CG().b(1040, eVar);
        }
        if (aEj().lNS != null) {
            aEj().lNS.detach();
        }
        com.tencent.mm.sdk.b.a.xef.c(this.lNU.gyH);
    }

    public static h aEw() {
        if (aEj().lNV == null) {
            aEj().lNV = new h();
        }
        return aEj().lNV;
    }
}
