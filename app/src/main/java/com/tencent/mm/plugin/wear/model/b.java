package com.tencent.mm.plugin.wear.model;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.y;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.g.b.af;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.protocal.c.byj;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.s;

public final class b implements e {
    com.tencent.mm.sdk.e.m.b mMK = new 3(this);
    boolean thR;
    c thS = new 1(this);
    ak thT = new ak(Looper.getMainLooper(), new 4(this), true);

    public b() {
        a.xef.b(this.thS);
        ar.Hg();
        com.tencent.mm.z.c.EY().a(this.mMK);
    }

    public final void connect() {
        byj com_tencent_mm_protocal_c_byj = a.bOt().thH.thY.tiP;
        if (com_tencent_mm_protocal_c_byj == null) {
            x.e("MicroMsg.Wear.WearBizLogic", "get connect wear data error");
        } else if (!bOu()) {
            ar.Hg();
            x.i("MicroMsg.Wear.WearBizLogic", "auto focus biz contact %b", new Object[]{Boolean.valueOf(((Boolean) com.tencent.mm.z.c.CU().get(327825, Boolean.valueOf(false))).booleanValue())});
            if (!((Boolean) com.tencent.mm.z.c.CU().get(327825, Boolean.valueOf(false))).booleanValue()) {
                if (bh.PT()) {
                    x.i("MicroMsg.Wear.WearBizLogic", "oversea user, forbid biz auto focus logic");
                    return;
                }
                a.bOt().thN.a(new a(this, (byte) 0));
                a.bOt().thN.a(new b(this, com_tencent_mm_protocal_c_byj));
            }
        } else if (!NG(com_tencent_mm_protocal_c_byj.wYz)) {
            x.i("MicroMsg.Wear.WearBizLogic", "start to register device %s", new Object[]{com_tencent_mm_protocal_c_byj.wYz});
            a.bOt().thN.a(new b(this, com_tencent_mm_protocal_c_byj));
        } else if (this.thR) {
            if (this.thT.cfK()) {
                x.i("MicroMsg.Wear.WearBizLogic", "start step count timer");
                this.thT.J(3600000, 3600000);
            } else {
                x.i("MicroMsg.Wear.WearBizLogic", "stop timer and restart step count timer");
                this.thT.TG();
                this.thT.J(3600000, 3600000);
            }
            a(com_tencent_mm_protocal_c_byj);
        } else {
            x.i("MicroMsg.Wear.WearBizLogic", "start to auth device %s", new Object[]{com_tencent_mm_protocal_c_byj.wYz});
            String str = com_tencent_mm_protocal_c_byj.wYz;
            String str2 = "gh_43f2581f6fd6";
            if (!this.thR && NG(str)) {
                x.i("MicroMsg.Wear.WearBizLogic", "auth device, deviceId=%s | deviceType=%s", new Object[]{str, str2});
                com.tencent.mm.sdk.b.b tlVar = new tl();
                tlVar.fMa.fpr = 7;
                tlVar.fMa.ffq = str;
                tlVar.fMa.frg = str2;
                a.xef.m(tlVar);
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2;
        if (kVar instanceof com.tencent.mm.plugin.wear.model.d.a) {
            ar.CG().b(1091, this);
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.wear.model.d.a aVar = (com.tencent.mm.plugin.wear.model.d.a) kVar;
                String str3 = aVar.ffq;
                str2 = aVar.frg;
                com.tencent.mm.sdk.b.b tlVar = new tl();
                tlVar.fMa.fpr = 1;
                tlVar.fMa.ffq = str3;
                tlVar.fMa.frg = str2;
                a.xef.m(tlVar);
                return;
            }
            x.e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        } else if (kVar instanceof o) {
            ar.CG().b(30, this);
            if (i == 0 && i2 == 0) {
                str2 = ((o) kVar).bYs();
                x.i("MicroMsg.Wear.WearBizLogic", "bind fitness contact %s success", new Object[]{str2});
                ar.Hg();
                af WO = com.tencent.mm.z.c.EY().WO("gh_43f2581f6fd6");
                if (WO == null || bh.ov(str2)) {
                    x.e("MicroMsg.Wear.WearBizLogic", "respUsername == " + str2 + ", contact = " + WO);
                } else {
                    d dVar = null;
                    if (s.gD(WO.field_username)) {
                        String ou = bh.ou(WO.field_username);
                        dVar = f.jS(ou);
                        if (dVar != null) {
                            dVar.field_username = str2;
                        }
                        y.Mf().jL(ou);
                        WO.di(ou);
                    }
                    WO.setUsername(str2);
                    if (((int) WO.gJd) == 0) {
                        ar.Hg();
                        com.tencent.mm.z.c.EY().S(WO);
                    }
                    if (((int) WO.gJd) <= 0) {
                        x.e("MicroMsg.Wear.WearBizLogic", "addContact : insert contact failed");
                    } else {
                        s.p(WO);
                        ar.Hg();
                        af WO2 = com.tencent.mm.z.c.EY().WO(WO.field_username);
                        if (dVar != null) {
                            y.Mf().d(dVar);
                        } else {
                            dVar = f.jS(WO2.field_username);
                            if (dVar == null || dVar.KY()) {
                                x.d("MicroMsg.Wear.WearBizLogic", "shouldUpdate");
                                com.tencent.mm.z.ak.a.hfL.Q(WO2.field_username, "");
                                com.tencent.mm.ad.b.iX(WO2.field_username);
                            } else if (WO2.cid()) {
                                x.d("MicroMsg.Wear.WearBizLogic", "update contact, last check time=%d", new Object[]{Integer.valueOf(WO2.fWw)});
                                com.tencent.mm.z.ak.a.hfL.Q(WO2.field_username, "");
                                com.tencent.mm.ad.b.iX(WO2.field_username);
                            }
                        }
                    }
                }
                y.Mf().e(y.Mf().jK(WO.field_username));
                ar.Hg();
                com.tencent.mm.z.c.CU().set(327825, Boolean.valueOf(true));
                connect();
                return;
            }
            x.e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (i == 4 && i2 == -24 && !bh.ov(str)) {
                Toast.makeText(ac.getContext(), str, 1).show();
            }
        }
    }

    static boolean NG(String str) {
        com.tencent.mm.sdk.b.b tlVar = new tl();
        tlVar.fMa.fpr = 3;
        tlVar.fMa.ffq = str;
        tlVar.fMa.frg = "gh_43f2581f6fd6";
        a.xef.m(tlVar);
        x.i("MicroMsg.Wear.WearBizLogic", "isRegister: %b", new Object[]{Boolean.valueOf(tlVar.fMa.fsH)});
        return tlVar.fMa.fsH;
    }

    static boolean bOu() {
        ar.Hg();
        return com.tencent.mm.l.a.fZ(com.tencent.mm.z.c.EY().WO("gh_43f2581f6fd6").field_type);
    }

    public static void a(byj com_tencent_mm_protocal_c_byj) {
        if (com_tencent_mm_protocal_c_byj != null) {
            com.tencent.mm.sdk.b.b tlVar = new tl();
            tlVar.fMa.fpr = 6;
            tlVar.fMa.ffq = com_tencent_mm_protocal_c_byj.wYz;
            a.xef.m(tlVar);
            return;
        }
        x.i("MicroMsg.Wear.WearBizLogic", "request is null");
    }
}
