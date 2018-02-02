package com.tencent.mm.modelmulti;

import com.tencent.mm.ad.d;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.h;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.y;
import com.tencent.mm.g.a.lz;
import com.tencent.mm.g.a.ob;
import com.tencent.mm.g.a.rf;
import com.tencent.mm.g.a.rx;
import com.tencent.mm.g.b.af;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.alm;
import com.tencent.mm.protocal.c.arh;
import com.tencent.mm.protocal.c.ark;
import com.tencent.mm.protocal.c.arp;
import com.tencent.mm.protocal.c.arz;
import com.tencent.mm.protocal.c.asi;
import com.tencent.mm.protocal.c.asz;
import com.tencent.mm.protocal.c.aza;
import com.tencent.mm.protocal.c.bmz;
import com.tencent.mm.protocal.c.brm;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.protocal.c.pq;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.Map;
import junit.framework.Assert;
import org.xwalk.core.R$styleable;

public final class a implements p {
    public final void a(ol olVar, byte[] bArr, boolean z, r rVar) {
        String a;
        af WO;
        b lzVar;
        h hVar;
        String FS;
        int i;
        switch (olVar.vXp) {
            case 13:
                arz com_tencent_mm_protocal_c_arz = (arz) new arz().aF(bArr);
                if (1 == com_tencent_mm_protocal_c_arz.wzH) {
                    ar.Hg();
                    c.Fg().c(n.a(com_tencent_mm_protocal_c_arz.vYI), com_tencent_mm_protocal_c_arz.wzr == 1, com_tencent_mm_protocal_c_arz.wzI == 1);
                    return;
                }
                x.e("MicroMsg.BigBallOfMudSyncExtension", "unknown micro blog type:" + com_tencent_mm_protocal_c_arz.wzH);
                return;
            case 15:
                ark com_tencent_mm_protocal_c_ark = (ark) new ark().aF(bArr);
                if (com_tencent_mm_protocal_c_ark != null) {
                    x.d("MicroMsg.BigBallOfMudSyncExtension", "processModChatRoomMember username:" + com_tencent_mm_protocal_c_ark.vYI + " nickname:" + com_tencent_mm_protocal_c_ark.wsB);
                    a = n.a(com_tencent_mm_protocal_c_ark.vYI);
                    ar.Hg();
                    af WO2 = c.EY().WO(a);
                    WO2.setUsername(a);
                    WO2.dc(n.a(com_tencent_mm_protocal_c_ark.wsB));
                    WO2.dd(n.a(com_tencent_mm_protocal_c_ark.vYw));
                    WO2.de(n.a(com_tencent_mm_protocal_c_ark.vYx));
                    WO2.eD(com_tencent_mm_protocal_c_ark.hvt);
                    WO2.da(n.a(com_tencent_mm_protocal_c_ark.wyH));
                    WO2.dg(n.a(com_tencent_mm_protocal_c_ark.wyJ));
                    WO2.dh(n.a(com_tencent_mm_protocal_c_ark.wyI));
                    WO2.eG(com_tencent_mm_protocal_c_ark.vXS);
                    h hVar2 = new h();
                    hVar2.fDt = -1;
                    hVar2.username = WO2.field_username;
                    hVar2.hlx = com_tencent_mm_protocal_c_ark.vUV;
                    hVar2.hly = com_tencent_mm_protocal_c_ark.vUU;
                    x.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl chatmember %s b[%s] s[%s]", new Object[]{hVar2.getUsername(), hVar2.JG(), hVar2.JH()});
                    hVar2.bA(true);
                    if (com_tencent_mm_protocal_c_ark.wyY == 3 || com_tencent_mm_protocal_c_ark.wyY == 4) {
                        WO2.eC(com_tencent_mm_protocal_c_ark.wyY);
                        hVar2.fWe = com_tencent_mm_protocal_c_ark.wyY;
                    } else if (com_tencent_mm_protocal_c_ark.wyY == 2) {
                        WO2.eC(3);
                        hVar2.fWe = 3;
                        WO2.eC(3);
                        if (!q.FS().equals(WO2.field_username)) {
                            com.tencent.mm.ad.n.Jz();
                            d.y(WO2.field_username, false);
                            com.tencent.mm.ad.n.Jz();
                            d.y(WO2.field_username, true);
                            com.tencent.mm.ad.n.JS().iY(WO2.field_username);
                        }
                    }
                    com.tencent.mm.ad.n.JQ().a(hVar2);
                    ar.Hg();
                    c.EY().Q(WO2);
                    com.tencent.mm.ag.d jK = y.Mf().jK(WO2.field_username);
                    jK.field_username = WO2.field_username;
                    jK.field_brandList = com_tencent_mm_protocal_c_ark.hvD;
                    pq pqVar = com_tencent_mm_protocal_c_ark.wvm;
                    if (pqVar != null) {
                        jK.field_brandFlag = pqVar.hvH;
                        jK.field_brandInfo = pqVar.hvJ;
                        jK.field_brandIconURL = pqVar.hvK;
                        jK.field_extInfo = pqVar.hvI;
                    }
                    if (!y.Mf().e(jK)) {
                        y.Mf().d(jK);
                        return;
                    }
                    return;
                }
                return;
            case 22:
                alm com_tencent_mm_protocal_c_alm = (alm) new alm().aF(bArr);
                com.tencent.mm.modelfriend.q qVar = new com.tencent.mm.modelfriend.q();
                qVar.username = com_tencent_mm_protocal_c_alm.ksU;
                qVar.hwn = com_tencent_mm_protocal_c_alm.wsC;
                qVar.hpd = (int) bh.Wo();
                com.tencent.mm.modelfriend.af.OH().a(qVar);
                return;
            case 23:
                wl wlVar = (wl) new wl().aF(bArr);
                switch (wlVar.wgL) {
                    case 1:
                        ar.Hg();
                        c.CU().set(17, Integer.valueOf(wlVar.wgM));
                        return;
                    case 4:
                        return;
                    default:
                        x.e("MicroMsg.BigBallOfMudSyncExtension", "unknown function switch id:" + wlVar.wgL);
                        return;
                }
            case 24:
                aza com_tencent_mm_protocal_c_aza = (aza) new aza().aF(bArr);
                Assert.assertTrue(com_tencent_mm_protocal_c_aza != null);
                Assert.assertTrue(bh.ou(com_tencent_mm_protocal_c_aza.ksU).length() > 0);
                if (com.tencent.mm.storage.x.Wz(com_tencent_mm_protocal_c_aza.ksU)) {
                    ar.Hg();
                    WO = c.EY().WO(com_tencent_mm_protocal_c_aza.ksU);
                    if (WO == null || ((int) WO.gJd) == 0) {
                        WO = new com.tencent.mm.storage.x(com_tencent_mm_protocal_c_aza.ksU);
                        WO.Am();
                        WO.dc(com_tencent_mm_protocal_c_aza.vUT);
                        WO.da(com_tencent_mm_protocal_c_aza.vUT);
                        WO.eG(4);
                        ar.Hg();
                        if (c.EY().S(WO) == -1) {
                            x.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: insert contact failed");
                            return;
                        }
                        com.tencent.mm.ad.b.iU(WO.field_username);
                    } else if (!bh.ou(com_tencent_mm_protocal_c_aza.vUT).equals(bh.ou(WO.field_username))) {
                        WO.dc(com_tencent_mm_protocal_c_aza.vUT);
                        WO.da(com_tencent_mm_protocal_c_aza.vUT);
                        ar.Hg();
                        if (c.EY().a(WO.field_username, WO) == -1) {
                            x.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: update contact failed");
                        }
                    }
                    lzVar = new lz();
                    lzVar.fDy.opType = 1;
                    lzVar.fDy.fDC = com_tencent_mm_protocal_c_aza.ksU;
                    lzVar.fDy.fDD = com_tencent_mm_protocal_c_aza.wGa;
                    lzVar.fDy.fDE = com_tencent_mm_protocal_c_aza.vXZ;
                    com.tencent.mm.sdk.b.a.xef.m(lzVar);
                    return;
                }
                x.w("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: qcontact should ends with @t.qq.com");
                return;
            case 25:
                bmz com_tencent_mm_protocal_c_bmz = (bmz) new bmz().aF(bArr);
                Assert.assertTrue(com_tencent_mm_protocal_c_bmz != null);
                Assert.assertTrue(bh.ou(com_tencent_mm_protocal_c_bmz.ksU).length() > 0);
                if (com.tencent.mm.storage.x.Wx(com_tencent_mm_protocal_c_bmz.ksU)) {
                    ar.Hg();
                    WO = c.EY().WO(com_tencent_mm_protocal_c_bmz.ksU);
                    if (WO == null || ((int) WO.gJd) == 0) {
                        WO = new com.tencent.mm.storage.x(com_tencent_mm_protocal_c_bmz.ksU);
                        WO.da(com_tencent_mm_protocal_c_bmz.vUT);
                        WO.eG(1);
                        WO.Am();
                        ar.Hg();
                        if (c.EY().S(WO) == -1) {
                            x.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: insert contact failed");
                            return;
                        }
                        a = WO.field_username;
                        if (a == null) {
                            x.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
                        } else if (a.endsWith("@t.qq.com")) {
                            hVar = new h();
                            hVar.username = a;
                            hVar.fWe = 3;
                            hVar.fDt = 3;
                            com.tencent.mm.ad.n.JQ().a(hVar);
                        } else {
                            x.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
                        }
                    } else if (!bh.ou(com_tencent_mm_protocal_c_bmz.vUT).equals(bh.ou(WO.field_username))) {
                        WO.da(com_tencent_mm_protocal_c_bmz.vUT);
                        ar.Hg();
                        if (c.EY().a(WO.field_username, WO) == -1) {
                            x.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: update contact failed");
                        }
                    }
                    lzVar = new rf();
                    lzVar.fIV.opType = 1;
                    lzVar.fIV.fDC = com_tencent_mm_protocal_c_bmz.ksU;
                    lzVar.fIV.fDD = com_tencent_mm_protocal_c_bmz.wGa;
                    lzVar.fIV.fDE = com_tencent_mm_protocal_c_bmz.vXZ;
                    com.tencent.mm.sdk.b.a.xef.m(lzVar);
                    return;
                }
                x.w("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: tcontact should ends with @t.qq.com");
                return;
            case 33:
                arh com_tencent_mm_protocal_c_arh = (arh) new arh().aF(bArr);
                Assert.assertTrue(com_tencent_mm_protocal_c_arh != null);
                Assert.assertTrue(bh.ou(com_tencent_mm_protocal_c_arh.ksU).length() > 0);
                com.tencent.mm.storage.x xVar = new com.tencent.mm.storage.x();
                xVar.setUsername(com_tencent_mm_protocal_c_arh.ksU);
                xVar.setType(com_tencent_mm_protocal_c_arh.ktN);
                xVar.eD(com_tencent_mm_protocal_c_arh.hvt);
                xVar.dv(RegionCodeDecoder.ah(com_tencent_mm_protocal_c_arh.hvC, com_tencent_mm_protocal_c_arh.hvu, com_tencent_mm_protocal_c_arh.hvv));
                xVar.dp(com_tencent_mm_protocal_c_arh.hvw);
                h hVar3 = new h();
                hVar3.fDt = -1;
                hVar3.username = com_tencent_mm_protocal_c_arh.ksU;
                hVar3.hlx = com_tencent_mm_protocal_c_arh.vUV;
                hVar3.hly = com_tencent_mm_protocal_c_arh.vUU;
                x.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl bottle %s b[%s] s[%s]", new Object[]{hVar3.getUsername(), hVar3.JG(), hVar3.JH()});
                x.d("MicroMsg.BigBallOfMudSyncExtension", "bottlecontact imgflag:" + com_tencent_mm_protocal_c_arh.wyY + " hd:" + com_tencent_mm_protocal_c_arh.wyZ);
                hVar3.bA(com_tencent_mm_protocal_c_arh.wyZ != 0);
                if (com_tencent_mm_protocal_c_arh.wyY == 3 || com_tencent_mm_protocal_c_arh.wyY == 4) {
                    xVar.eC(com_tencent_mm_protocal_c_arh.wyY);
                    hVar3.fWe = com_tencent_mm_protocal_c_arh.wyY;
                } else if (com_tencent_mm_protocal_c_arh.wyY == 2) {
                    xVar.eC(3);
                    hVar3.fWe = 3;
                    com.tencent.mm.ad.n.Jz();
                    d.y(com_tencent_mm_protocal_c_arh.ksU, false);
                    com.tencent.mm.ad.n.Jz();
                    d.y(com_tencent_mm_protocal_c_arh.ksU, true);
                    com.tencent.mm.ad.n.JS().iY(com_tencent_mm_protocal_c_arh.ksU);
                } else {
                    xVar.eC(3);
                    hVar3.fWe = 3;
                }
                com.tencent.mm.ad.n.JQ().a(hVar3);
                ar.Hg();
                c.EY().P(xVar);
                return;
            case 35:
                String str;
                asi com_tencent_mm_protocal_c_asi = (asi) new asi().aF(bArr);
                Assert.assertTrue(com_tencent_mm_protocal_c_asi != null);
                FS = q.FS();
                i = com_tencent_mm_protocal_c_asi.vOc;
                if (i == 2) {
                    FS = com.tencent.mm.storage.x.WD(FS);
                    ar.Hg();
                    str = FS;
                    FS = (String) c.CU().get(12553, null);
                } else {
                    ar.Hg();
                    str = FS;
                    FS = (String) c.CU().get(12297, null);
                }
                boolean z2 = false;
                if (FS == null || !FS.equals(com_tencent_mm_protocal_c_asi.wzR)) {
                    com.tencent.mm.ad.n.Jz();
                    d.y(str, true);
                    ar.Hg();
                    c.CU().set(i == 2 ? 12553 : 12297, com_tencent_mm_protocal_c_asi.wzR);
                    z2 = true;
                }
                x.d("MicroMsg.BigBallOfMudSyncExtension", "ModUserImg beRemove:%b imgtype:%d md5:%s big:%s sm:%s", new Object[]{Boolean.valueOf(z2), Integer.valueOf(i), com_tencent_mm_protocal_c_asi.wzR, com_tencent_mm_protocal_c_asi.vUU, com_tencent_mm_protocal_c_asi.vUV});
                hVar = new h();
                hVar.username = str;
                hVar.hly = com_tencent_mm_protocal_c_asi.vUU;
                hVar.hlx = com_tencent_mm_protocal_c_asi.vUV;
                if (!bh.ov(hVar.JH())) {
                    if (i == 1) {
                        ar.Hg();
                        c.CU().set(59, Boolean.valueOf(true));
                    } else {
                        ar.Hg();
                        c.CU().set(60, Boolean.valueOf(true));
                    }
                }
                hVar.bA(false);
                hVar.fDt = 56;
                if (!bh.ov(com_tencent_mm_protocal_c_asi.wzR)) {
                    hVar.bA(true);
                }
                com.tencent.mm.ad.n.JQ().a(hVar);
                if (z2) {
                    new e().a(str, new 2(this));
                    return;
                }
                return;
            case R$styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                brm com_tencent_mm_protocal_c_brm = (brm) new brm().aF(bArr);
                x.d("MicroMsg.BigBallOfMudSyncExtension", "snsExtFlag " + com_tencent_mm_protocal_c_brm.wvl.hvE);
                ar.Hg();
                a = (String) c.CU().get(2, null);
                if (a != null && a.length() > 0) {
                    if (com.tencent.mm.plugin.sns.b.n.qQz != null) {
                        com.tencent.mm.plugin.sns.b.n.qQz.a(a, com_tencent_mm_protocal_c_brm.wvl);
                    }
                    com.tencent.mm.ag.d jS = f.jS(q.FS());
                    if (jS == null) {
                        jS = new com.tencent.mm.ag.d();
                    }
                    jS.field_username = a;
                    jS.field_brandList = com_tencent_mm_protocal_c_brm.hvD;
                    if (!(!jS.Lf() || jS.bI(false) == null || jS.bI(false).LG() == null || bh.ov(jS.Lm()))) {
                        jS.field_enterpriseFather = jS.Lm();
                        x.d("MicroMsg.BigBallOfMudSyncExtension", "processModUserInfoExt, %s set enterpriseFather %s", new Object[]{a, jS.field_enterpriseFather});
                    }
                    if (!y.Mf().e(jS)) {
                        y.Mf().d(jS);
                    }
                    int i2 = com_tencent_mm_protocal_c_brm.wSV;
                    int i3 = com_tencent_mm_protocal_c_brm.wSW;
                    i = com_tencent_mm_protocal_c_brm.wSX;
                    x.d("MicroMsg.BigBallOfMudSyncExtension", "roomSize :" + i2 + " rommquota: " + i3 + " invite: " + i);
                    ar.Hg();
                    c.CU().set(135175, Integer.valueOf(i2));
                    ar.Hg();
                    c.CU().set(135176, Integer.valueOf(i3));
                    ar.Hg();
                    c.CU().set(135177, Integer.valueOf(i));
                    ar.Hg();
                    c.CU().set(144385, Integer.valueOf(com_tencent_mm_protocal_c_brm.wTb));
                    ar.Hg();
                    c.CU().a(com.tencent.mm.storage.w.a.xrD, Integer.valueOf(com_tencent_mm_protocal_c_brm.whI));
                    ar.Hg();
                    c.CU().set(339975, Integer.valueOf(com_tencent_mm_protocal_c_brm.wTj));
                    x.i("MicroMsg.BigBallOfMudSyncExtension", "hy: sync do cmd pay wallet type: %d %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_brm.wTj), Integer.valueOf(com_tencent_mm_protocal_c_brm.whI)});
                    ar.Hg();
                    c.CU().a(com.tencent.mm.storage.w.a.xpK, bh.az(com_tencent_mm_protocal_c_brm.fWD, ""));
                    x.d("MicroMsg.BigBallOfMudSyncExtension", "weidianinfo:%s", new Object[]{com_tencent_mm_protocal_c_brm.fWD});
                    ar.Hg();
                    c.CU().set(147457, Long.valueOf(com_tencent_mm_protocal_c_brm.wTk));
                    ar.Hg();
                    c.CU().a(com.tencent.mm.storage.w.a.xtD, com_tencent_mm_protocal_c_brm.wTl);
                    hVar = new h();
                    hVar.fDt = -1;
                    hVar.username = a;
                    hVar.hly = com_tencent_mm_protocal_c_brm.vUU;
                    hVar.hlx = com_tencent_mm_protocal_c_brm.vUV;
                    hVar.bA(true);
                    hVar.fWe = 3;
                    x.d("MicroMsg.BigBallOfMudSyncExtension", "dkavatar user:[%s] big:[%s] sm:[%s]", new Object[]{hVar.getUsername(), hVar.JG(), hVar.JH()});
                    com.tencent.mm.ad.n.JQ().a(hVar);
                    a = com_tencent_mm_protocal_c_brm.wzj;
                    FS = com_tencent_mm_protocal_c_brm.wzk;
                    ar.Hg();
                    c.CU().set(274433, FS);
                    ar.Hg();
                    c.CU().set(274434, a);
                    if (com_tencent_mm_protocal_c_brm.vHl != null) {
                        ar.Hg();
                        c.CU().set(286721, com_tencent_mm_protocal_c_brm.vHl.vLU);
                        ar.Hg();
                        c.CU().set(286722, com_tencent_mm_protocal_c_brm.vHl.vLV);
                        ar.Hg();
                        c.CU().set(286723, com_tencent_mm_protocal_c_brm.vHl.vLW);
                    }
                    if (com_tencent_mm_protocal_c_brm.wTh != null && com_tencent_mm_protocal_c_brm.wTh.wDe != null && com_tencent_mm_protocal_c_brm.wTh.wDe.wJB > 0) {
                        x.i("MicroMsg.BigBallOfMudSyncExtension", "tomgest PatternLockInfo %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_brm.wTh.wDe.wJB)});
                        lzVar = new rx();
                        lzVar.fJG.fJH = com_tencent_mm_protocal_c_brm.wTh;
                        com.tencent.mm.sdk.b.a.xef.m(lzVar);
                        return;
                    }
                    return;
                }
                return;
            case 53:
                asz com_tencent_mm_protocal_c_asz = (asz) new asz().aF(bArr);
                x.d("MicroMsg.BigBallOfMudSyncExtension", "rollback, msgtype is %d, msgid is %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_asz.ngq), Long.valueOf(com_tencent_mm_protocal_c_asz.vHe)});
                if (s.gV(com_tencent_mm_protocal_c_asz.nkp)) {
                    lzVar = new ob();
                    lzVar.fFX.fqm = com_tencent_mm_protocal_c_asz.vHe;
                    com.tencent.mm.sdk.b.a.xef.m(lzVar);
                    return;
                }
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX /*204*/:
                a((bx) new bx().aF(bArr), rVar);
                return;
            case 999999:
                try {
                    int p = com.tencent.mm.a.n.p(bArr, 0);
                    x.d("MicroMsg.BigBallOfMudSyncExtension", "local test synccmd, sleep %d", new Object[]{Integer.valueOf(p)});
                    if (p > 0) {
                        Thread.sleep((long) p);
                        return;
                    }
                    return;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", e, "", new Object[0]);
                    return;
                }
            default:
                x.e("MicroMsg.BigBallOfMudSyncExtension", "doCmd: no processing method, cmd id=" + olVar.vXp);
                return;
        }
    }

    public static boolean a(com.tencent.mm.storage.x xVar) {
        if (xVar == null || bh.ov(xVar.field_username)) {
            String str;
            String str2 = "MicroMsg.BigBallOfMudSyncExtension";
            String str3 = "dealModContactExtInfo username:%s ";
            Object[] objArr = new Object[1];
            if (xVar == null) {
                str = "-1";
            } else {
                str = xVar.field_username;
            }
            objArr[0] = str;
            x.w(str2, str3, objArr);
            return false;
        }
        ar.Hg();
        byte[] WS = c.EY().WS(xVar.field_username);
        if (bh.bw(WS)) {
            str2 = "MicroMsg.BigBallOfMudSyncExtension";
            str3 = "dealModContactExtInfo username:%s  buf:%d";
            objArr = new Object[2];
            objArr[0] = xVar.field_username;
            objArr[1] = Integer.valueOf(WS == null ? -1 : WS.length);
            x.w(str2, str3, objArr);
            return false;
        }
        arp com_tencent_mm_protocal_c_arp;
        try {
            com_tencent_mm_protocal_c_arp = (arp) new arp().aF(WS);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", e, "", new Object[0]);
            com_tencent_mm_protocal_c_arp = null;
        }
        ar.Hg();
        c.EY().WT(xVar.field_username);
        if (com_tencent_mm_protocal_c_arp != null) {
            return com.tencent.mm.plugin.bbom.c.a(xVar, com_tencent_mm_protocal_c_arp, false);
        }
        x.e("MicroMsg.BigBallOfMudSyncExtension", "dkinit dealModContactExtInfo failed parse buf failed.");
        return false;
    }

    public final void a(bx bxVar, r rVar) {
        aj ajVar;
        Object obj;
        long ET;
        String a = n.a(bxVar.vHg);
        long j = bxVar.vHe;
        int i = bxVar.pbl;
        int i2 = bxVar.vHj;
        int i3 = bxVar.vHf;
        int i4 = bxVar.ngq;
        int i5 = bxVar.vHh;
        String a2 = n.a(bxVar.vHi);
        x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList chatRoomId[%s], newMsgId[%d], createTime[%d], isActed[%d], msgseq[%d], msgType[%d], unDeliverCount[%d], content[%s]", new Object[]{a, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), bh.VT(a2)});
        if (bh.ov(a)) {
            x.e("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList chatRoomId is null and ret");
        }
        if (i5 == 0) {
            com.tencent.mm.plugin.report.d.pPH.a(403, 24, 1, false);
            if (bh.az(ba.hP(a2), "").equals(q.FS())) {
                ar.Hg();
                cf F = c.Fa().F(a, j);
                if (F.field_msgId > 0 && F.field_isSend == 1) {
                    x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList self send msg[%d] createtime[%d, %d] svrid[%d, %d] seq[%d, %d]", new Object[]{Long.valueOf(F.field_msgId), Long.valueOf(F.field_createTime), Integer.valueOf(i), Long.valueOf(F.field_msgSvrId), Long.valueOf(j), Long.valueOf(F.field_msgSeq), Integer.valueOf(i3)});
                    if (F.field_msgSeq == 0) {
                        com.tencent.mm.plugin.report.d.pPH.a(403, 25, 1, false);
                        F.as((long) i3);
                        ar.Hg();
                        c.Fa().a(F.field_msgId, F);
                        return;
                    }
                    return;
                }
            }
        }
        ar.Hg();
        aj WY = c.Fd().WY(a);
        if (WY == null) {
            com.tencent.mm.plugin.report.d.pPH.a(403, 22, 1, false);
            aj aeVar = new ae(a);
            aeVar.aj(((long) i) * 1000);
            aeVar.al((long) i3);
            aeVar.eO(i5);
            aeVar.eW(i5);
            if (i5 < 2) {
                aeVar.am((long) i3);
                ajVar = aeVar;
                obj = 1;
            } else {
                ar.Hg();
                aeVar.am(c.FJ().Er(a));
                x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList new conv lastDeleteSeq(FirstUnDeliverSeq)[%d], msgSeq[%d]", new Object[]{Long.valueOf(r6), Integer.valueOf(i3)});
                ajVar = aeVar;
                int i6 = 1;
            }
        } else {
            int i7 = (int) WY.field_lastSeq;
            com.tencent.mm.plugin.report.d.pPH.a(403, 23, 1, false);
            if (i5 < WY.field_UnDeliverCount) {
                com.tencent.mm.plugin.report.d.pPH.a(403, 26, (long) WY.field_UnDeliverCount, false);
            }
            if (i3 > i7) {
                WY.al((long) i3);
                WY.eW(i5);
                WY.aj(ba.n(a, (long) i));
                if (i5 > WY.field_unReadCount) {
                    WY.eO(i5);
                }
                x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList  msgSeq[%d], firstSeq[%d], lastseq[%d]", new Object[]{Integer.valueOf(i3), Long.valueOf(WY.field_firstUnDeliverSeq), Integer.valueOf(i7)});
                if (WY.field_firstUnDeliverSeq > 0) {
                    ar.Hg();
                    if (c.Fa().G(a, (long) i7).field_msgId <= 0) {
                        com.tencent.mm.plugin.report.d.pPH.a(403, 29, 1, false);
                        x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList unDeliverCount:%d lastSeq:%d not existed", new Object[]{Integer.valueOf(i5), Integer.valueOf(i7)});
                        ajVar = WY;
                        obj = null;
                    } else if (i5 != 1) {
                        x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList unDeliverCount:%d keep firstSeq:%d", new Object[]{Integer.valueOf(i5), Long.valueOf(ET)});
                        com.tencent.mm.plugin.report.d.pPH.a(403, 27, 1, false);
                        ajVar = WY;
                        obj = null;
                    } else {
                        WY.am((long) i3);
                        com.tencent.mm.plugin.report.d.pPH.a(403, 28, 1, false);
                        ajVar = WY;
                        obj = null;
                    }
                } else {
                    ar.Hg();
                    j = c.FJ().Er(a);
                    if (j > 0) {
                        com.tencent.mm.plugin.report.d.pPH.a(403, 30, 1, false);
                        if (i5 == 0 && ((long) i3) == j) {
                            x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList[%d, %d] deleted ret", new Object[]{Integer.valueOf(i3), Long.valueOf(j)});
                            return;
                        }
                        WY.am((long) i3);
                        ajVar = WY;
                        obj = null;
                    } else {
                        ar.Hg();
                        ET = c.Fa().ET(a);
                        if (ET > 0) {
                            WY.am(ET);
                            com.tencent.mm.plugin.report.d.pPH.a(403, 31, 1, false);
                            ajVar = WY;
                            obj = null;
                        } else {
                            com.tencent.mm.plugin.report.d.pPH.a(403, 32, 1, false);
                            ajVar = WY;
                            obj = null;
                        }
                    }
                }
            } else {
                if (i3 == i7 && i5 == 0 && WY.field_unReadCount > 0) {
                    com.tencent.mm.plugin.report.d.pPH.a(403, 33, 1, false);
                    WY.eO(0);
                }
                x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList msgSeq <= lastSeq, do nothing [%d, %d]", new Object[]{Integer.valueOf(i3), Integer.valueOf(i7)});
                return;
            }
        }
        if (i2 > 0) {
            ajVar.eU(ajVar.field_atCount + i2);
        }
        cf auVar = new au();
        auVar.eR(0);
        auVar.dS(a);
        auVar.setType(i4);
        auVar.setContent(a2);
        if (i4 == 49) {
            com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(j.fe(a, a2));
            auVar.setType(l.d(fT));
            if (auVar.ciV()) {
                a2 = fT.content;
            }
            auVar.setContent(a2);
        } else if (i4 == 10002) {
            ar.getSysCmdMsgExtension();
            if (auVar.getType() == 10002 && !bh.ov(a2)) {
                if (bh.ov(a2)) {
                    x.e("MicroMsg.SysCmdMsgExtension", "null msg content");
                } else {
                    Map Vo;
                    if (a2.startsWith("~SEMI_XML~")) {
                        Vo = ax.Vo(a2);
                        if (Vo == null) {
                            x.e("MicroMsg.SysCmdMsgExtension", "SemiXml values is null, msgContent %s", new Object[]{a2});
                        } else {
                            a2 = "brand_service";
                        }
                    } else {
                        int indexOf = a2.indexOf("<sysmsg");
                        if (indexOf == -1) {
                            x.e("MicroMsg.SysCmdMsgExtension", "msgContent not start with <sysmsg");
                        } else {
                            Vo = bi.y(a2.substring(indexOf), "sysmsg");
                            if (Vo == null) {
                                x.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", new Object[]{a2});
                            } else {
                                a2 = (String) Vo.get(".sysmsg.$type");
                            }
                        }
                    }
                    if (a2 != null && a2.equals("revokemsg")) {
                        x.i("MicroMsg.SysCmdMsgExtension", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
                        Vo.get(".sysmsg.revokemsg.session");
                        a2 = (String) Vo.get(".sysmsg.revokemsg.newmsgid");
                        x.i("MicroMsg.SysCmdMsgExtension", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", new Object[]{a2, (String) Vo.get(".sysmsg.revokemsg.replacemsg")});
                        auVar.setContent(r4);
                        auVar.setType(10000);
                    }
                }
            }
        }
        ajVar.eR(0);
        ajVar.setContent(auVar.field_content);
        ajVar.dE(Integer.toString(auVar.getType()));
        ar.Hg();
        as.b uw = c.Fd().uw();
        if (uw != null) {
            PString pString = new PString();
            PString pString2 = new PString();
            PInt pInt = new PInt();
            uw.a(auVar, pString, pString2, pInt, false);
            ajVar.dF(pString.value);
            ajVar.dG(pString2.value);
            ajVar.eS(pInt.value);
            if (auVar.getType() == 49) {
                a2 = (String) bi.y(ajVar.field_content, "msg").get(".msg.appmsg.title");
                ajVar.dF(bh.ou(ajVar.field_digest).concat(bh.ov(a2) ? "" : " " + bh.ou(a2)));
            }
        } else {
            ajVar.dF(ajVar.field_content);
        }
        if (obj != null) {
            ar.Hg();
            ET = c.Fd().d(ajVar);
            x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr, processAddMsgDigestList insert username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", new Object[]{a, Long.valueOf(ET), Long.valueOf(ajVar.field_firstUnDeliverSeq), Long.valueOf(ajVar.field_lastSeq), Integer.valueOf(ajVar.field_UnDeliverCount)});
        } else {
            ajVar.eT(ajVar.field_attrflag & -1048577);
            ar.Hg();
            ET = (long) c.Fd().a(ajVar, a, true);
            x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr, processAddMsgDigestList update username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", new Object[]{a, Long.valueOf(ET), Long.valueOf(ajVar.field_firstUnDeliverSeq), Long.valueOf(ajVar.field_lastSeq), Integer.valueOf(ajVar.field_UnDeliverCount)});
        }
        ar.Hg();
        com.tencent.mm.storage.q hE = c.Fh().hE(a);
        ar.Hg();
        com.tencent.mm.l.a WO = c.EY().WO(a);
        if (WO == null || ((int) WO.gJd) <= 0) {
            x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList chatRoomId[%s], contact is null need get", new Object[]{a});
            com.tencent.mm.z.ak.a.hfL.a(a, null, new 1(this, hE, a));
        }
        if (com.tencent.mm.sdk.a.b.foreground && i4 != 10002 && i5 > 0) {
            bw bwVar = new bw();
            bwVar.vGX = bxVar.vHg;
            bwVar.vGY = n.os(q.FS());
            bwVar.pbl = bxVar.pbl;
            bwVar.vGZ = bxVar.vHi;
            bwVar.ngq = bxVar.ngq;
            bwVar.vHe = bxVar.vHe;
            bwVar.vHf = bxVar.vHf;
            if (rVar != null) {
                rVar.a(auVar, bwVar);
            }
        }
    }
}
