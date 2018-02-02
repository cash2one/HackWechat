package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.ad.n;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ag.a.h;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.y;
import com.tencent.mm.bf.j;
import com.tencent.mm.bf.l;
import com.tencent.mm.g.a.ep;
import com.tencent.mm.g.a.ha;
import com.tencent.mm.g.a.is;
import com.tencent.mm.g.a.jm;
import com.tencent.mm.g.a.jx;
import com.tencent.mm.g.a.rh;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.g.a.rm;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.g.b.ca;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.l.a;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.plugin.messenger.foundation.a.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.arp;
import com.tencent.mm.protocal.c.arq;
import com.tencent.mm.protocal.c.asc;
import com.tencent.mm.protocal.c.awz;
import com.tencent.mm.protocal.c.axa;
import com.tencent.mm.protocal.c.bla;
import com.tencent.mm.protocal.c.mf;
import com.tencent.mm.protocal.c.pq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.m;
import com.tencent.mm.z.s;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class c implements e, b {
    public final void a(x xVar, x xVar2, arp com_tencent_mm_protocal_c_arp, byte[] bArr, boolean z) {
        Object obj;
        String str;
        String str2 = xVar.field_username;
        String str3 = xVar.field_encryptUsername;
        if (!(xVar2 == null || bh.ou(xVar2.fWz).equals(bh.ou(com_tencent_mm_protocal_c_arp.wzs)))) {
            com.tencent.mm.bb.c.QL();
            com.tencent.mm.bb.c.lQ(str2);
        }
        if (bh.bw(bArr)) {
            a(xVar, com_tencent_mm_protocal_c_arp, true);
        } else if (x.Dn(xVar.field_verifyFlag)) {
            a(com_tencent_mm_protocal_c_arp, str2, xVar, true);
        }
        if (xVar2 == null || a.fZ(xVar2.field_type) || !a.fZ(xVar.field_type)) {
            obj = null;
        } else {
            obj = 1;
        }
        String str4 = "MicroMsg.BigBallContactAssemblerImpl";
        String str5 = "username:%s PhoneNumList size:%s";
        Object[] objArr = new Object[2];
        objArr[0] = xVar.field_username;
        if (com_tencent_mm_protocal_c_arp.wzt == null) {
            str = "";
        } else {
            str = Integer.valueOf(bh.e(Integer.valueOf(com_tencent_mm_protocal_c_arp.wzt.wEp.size())));
        }
        objArr[1] = str;
        com.tencent.mm.sdk.platformtools.x.i(str4, str5, objArr);
        StringBuffer stringBuffer = new StringBuffer();
        if (!(com_tencent_mm_protocal_c_arp.wzt == null || com_tencent_mm_protocal_c_arp.wzt.wEp == null)) {
            Iterator it = com_tencent_mm_protocal_c_arp.wzt.wEp.iterator();
            while (it.hasNext()) {
                awz com_tencent_mm_protocal_c_awz = (awz) it.next();
                if (com_tencent_mm_protocal_c_awz.wEo != null) {
                    stringBuffer.append(com_tencent_mm_protocal_c_awz.wEo + ",");
                }
            }
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", new Object[]{xVar.field_username, stringBuffer.toString()});
        str = null;
        if (xVar2 != null) {
            str = xVar2.fWE;
        }
        if (str == null || str.equals("")) {
            ar.Hg();
            bf EZ = com.tencent.mm.z.c.EZ().EZ(str3);
            if (EZ != null) {
                str = EZ.field_conPhone;
            }
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, oldPhoneList %s", new Object[]{xVar.field_username, bh.ou(str)});
        if (!bh.ov(str)) {
            int i;
            Object obj2 = null;
            Object obj3 = null;
            for (String str6 : str.split(",")) {
                if (!bh.ov(stringBuffer.toString())) {
                    String[] split = stringBuffer.toString().split(",");
                    int length = split.length;
                    int i2 = 0;
                    while (i2 < length) {
                        if (str6.equals(split[i2])) {
                            obj2 = null;
                            break;
                        } else {
                            i2++;
                            i = 1;
                        }
                    }
                    if (obj2 != null) {
                        stringBuffer.append(str6);
                        obj3 = 1;
                    }
                }
            }
            if (obj3 != null) {
                com.tencent.mm.bq.a com_tencent_mm_protocal_c_asc = new asc();
                com_tencent_mm_protocal_c_asc.wzx = xVar.field_username;
                axa com_tencent_mm_protocal_c_axa = new axa();
                if (!bh.ov(stringBuffer.toString())) {
                    String[] split2 = stringBuffer.toString().split(",");
                    com_tencent_mm_protocal_c_axa.ksO = split2.length;
                    com_tencent_mm_protocal_c_axa.wEp = new LinkedList();
                    for (String str7 : split2) {
                        awz com_tencent_mm_protocal_c_awz2 = new awz();
                        com_tencent_mm_protocal_c_awz2.wEo = str7;
                        com_tencent_mm_protocal_c_axa.wEp.add(com_tencent_mm_protocal_c_awz2);
                    }
                    com_tencent_mm_protocal_c_asc.wzt = com_tencent_mm_protocal_c_axa;
                    ar.Hg();
                    com.tencent.mm.z.c.EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(60, com_tencent_mm_protocal_c_asc));
                }
            }
            if (!(obj == null || 15 != com_tencent_mm_protocal_c_arp.vHW || bh.ov(xVar.field_username))) {
                com.tencent.mm.modelfriend.b kR = af.OD().kR(xVar.field_username);
                if (kR != null) {
                    g gVar = g.pQN;
                    Object[] objArr2 = new Object[4];
                    objArr2[0] = xVar.field_username;
                    objArr2[1] = Integer.valueOf(3);
                    objArr2[2] = Integer.valueOf(bh.ov(kR.Nr()) ? 0 : 1);
                    if (stringBuffer.toString().split(",").length >= 5) {
                        i = 5;
                    } else {
                        i = stringBuffer.toString().split(",").length;
                    }
                    objArr2[3] = Integer.valueOf(i);
                    gVar.h(12040, objArr2);
                }
            }
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", new Object[]{xVar.field_username, stringBuffer.toString()});
        str = stringBuffer.toString();
        if (!bh.ov(str)) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BigBallContactAssemblerImpl", str);
            xVar.dC(str);
        }
        if (!(s.eV(str2) || com_tencent_mm_protocal_c_arp.wjV == null)) {
            m.a(str2, com_tencent_mm_protocal_c_arp.wjV);
        }
        boolean z2 = false;
        ar.Hg();
        bf EZ2 = com.tencent.mm.z.c.EZ().EZ(xVar.field_username);
        if (bh.ov(xVar.field_conRemark)) {
            if ((EZ2 == null || bh.ov(EZ2.field_encryptUsername)) && !bh.ov(str3)) {
                ar.Hg();
                EZ2 = com.tencent.mm.z.c.EZ().EZ(str3);
            }
            if (!(EZ2 == null || bh.ov(EZ2.field_encryptUsername))) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BigBallContactAssemblerImpl", "mod stranger remark : " + EZ2.field_encryptUsername);
                xVar.da(EZ2.field_conRemark);
                xVar.dg(com.tencent.mm.platformtools.c.ol(EZ2.field_conRemark));
                xVar.dh(com.tencent.mm.platformtools.c.om(EZ2.field_conRemark));
                z2 = a(xVar, EZ2);
            }
            switch (xVar.getSource()) {
                case 10:
                case 11:
                case 13:
                    com.tencent.mm.modelfriend.b bVar = null;
                    if (com_tencent_mm_protocal_c_arp != null && !bh.ov(com_tencent_mm_protocal_c_arp.wzl)) {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BigBallContactAssemblerImpl", "MobileHash[%s],MobileFullHash[%s]", new Object[]{com_tencent_mm_protocal_c_arp.wzl, com_tencent_mm_protocal_c_arp.wzm});
                        com.tencent.mm.modelfriend.c OD = af.OD();
                        String str8 = com_tencent_mm_protocal_c_arp.wzl;
                        str5 = com_tencent_mm_protocal_c_arp.wzm;
                        bVar = OD.kS(str8);
                        if (bVar == null) {
                            bVar = OD.kS(str5);
                        }
                    } else if (!bh.ov(str3)) {
                        bVar = af.OD().kR(str3);
                    }
                    if (bVar == null) {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BigBallContactAssemblerImpl", "dealWithRemark-> addr == null");
                    } else {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], needSetRemark[%s]", new Object[]{bh.ou(bVar.Nt()), bh.ou(bVar.getUsername()), Boolean.valueOf(bVar.NC())});
                    }
                    if (!(bVar == null || bh.ov(bVar.Nt()) || !bVar.NC())) {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], remarkChange[%s]", new Object[]{bVar.Nt(), bVar.getUsername(), Boolean.valueOf(z2)});
                        bVar.username = xVar.field_username;
                        bVar.status = 2;
                        bVar.NB();
                        if (!z2) {
                            xVar.da(bVar.Nt());
                            xVar.dg(com.tencent.mm.platformtools.c.ol(bVar.Nt()));
                            xVar.dh(com.tencent.mm.platformtools.c.om(bVar.Nt()));
                            z2 = true;
                        }
                        if (a.fZ(xVar.field_type)) {
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BigBallContactAssemblerImpl", "updateAddrUp RealName[%s], User[%s], remarkChange[%s]", new Object[]{bVar.Nt(), bVar.getUsername(), Boolean.valueOf(z2)});
                            af.OD().a(bVar.Nr(), bVar);
                            break;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        if (!(EZ2 == null || bh.ov(xVar.fWy) || xVar.fWy.equals(EZ2.field_conDescription))) {
            a(xVar, EZ2);
        }
        z2 = false;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s needModContact %s encryptUser:%s", new Object[]{xVar.field_username, Boolean.valueOf(z2), str3});
        if (z2) {
            s.u(xVar);
        }
        str = null;
        ar.Hg();
        com.tencent.mm.sdk.e.c EZ3 = com.tencent.mm.z.c.EZ().EZ(xVar.field_encryptUsername);
        if (EZ3 != null) {
            str = EZ3.field_contactLabels;
        }
        if (bh.ov(str)) {
            ar.Hg();
            EZ3 = com.tencent.mm.z.c.EZ().EZ(xVar.field_username);
            if (EZ3 != null) {
                str = EZ3.field_contactLabels;
            }
        }
        if (!bh.ov(str)) {
            com.tencent.mm.plugin.label.a.a.aUX().db(xVar.field_username, str);
            EZ3.field_contactLabels = "";
            ar.Hg();
            com.tencent.mm.z.c.EZ().a(EZ3);
        }
    }

    public final void b(x xVar, x xVar2, arp com_tencent_mm_protocal_c_arp, byte[] bArr, boolean z) {
        Object obj;
        com.tencent.mm.sdk.b.b rmVar;
        int i;
        Object obj2;
        d jK;
        String str;
        long currentTimeMillis;
        aj WY;
        aj WY2;
        cf Ex;
        String str2 = xVar.field_username;
        String str3 = xVar.field_encryptUsername;
        if (s.eV(str2)) {
            String aVB;
            if (com_tencent_mm_protocal_c_arp.wjV != null) {
                Iterator it;
                mf mfVar;
                LinkedList linkedList = com_tencent_mm_protocal_c_arp.wjV.vUQ;
                if (q.a.vcv == null) {
                    obj = null;
                } else {
                    aVB = q.a.vcv.aVB();
                    if (!bh.ov(aVB) && aVB.equals(str2) && s.eV(str2)) {
                        if (linkedList != null) {
                            it = linkedList.iterator();
                            while (it.hasNext()) {
                                mfVar = (mf) it.next();
                                if (!bh.ov(mfVar.ksU) && mfVar.ksU.equals(com.tencent.mm.z.q.FS())) {
                                    obj = null;
                                    break;
                                }
                            }
                        }
                        if (q.a.vcw != null) {
                            if (q.a.vcw.de(str2, com.tencent.mm.z.q.FS())) {
                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BigBallContactAssemblerImpl", "kicked self shareing");
                                rmVar = new rm();
                                rmVar.fJo.userName = str2;
                                com.tencent.mm.sdk.b.a.xef.m(rmVar);
                            }
                            q.a.vcw.a(str2, null, 0.0d, 0.0d, "", "", "");
                        }
                        if (!(q.a.vcv == null || bh.ov(q.a.vcw.aVL()))) {
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BigBallContactAssemblerImpl", "sync remove chatroom end track %s", new Object[]{q.a.vcv.aVB()});
                            rmVar = new ep();
                            rmVar.ftg.username = q.a.vcv.aVB();
                            com.tencent.mm.sdk.b.a.xef.m(rmVar);
                        }
                        obj = 1;
                    } else {
                        obj = null;
                    }
                }
                if (obj == null) {
                    linkedList = com_tencent_mm_protocal_c_arp.wjV.vUQ;
                    com.tencent.mm.sdk.b.b riVar = new ri();
                    riVar.fJc.fJe = true;
                    com.tencent.mm.sdk.b.a.xef.m(riVar);
                    if (!bh.ov(str2) && s.eV(str2) && !bh.ov(riVar.fJd.fJg) && str2.equals(riVar.fJd.fJg)) {
                        if (linkedList != null) {
                            it = linkedList.iterator();
                            while (it.hasNext()) {
                                mfVar = (mf) it.next();
                                if (!bh.ov(mfVar.ksU)) {
                                    if (mfVar.ksU.equals(com.tencent.mm.z.q.FS())) {
                                        break;
                                    }
                                }
                            }
                        }
                        if (q.a.vcp != null) {
                            q.a.vcp.a(str2, null, "", "", 0);
                        }
                        rmVar = new ri();
                        rmVar.fJc.fJf = true;
                        com.tencent.mm.sdk.b.a.xef.m(rmVar);
                        rmVar = new rh();
                        rmVar.fJa.fJb = true;
                        com.tencent.mm.sdk.b.a.xef.m(rmVar);
                    }
                }
                linkedList = com_tencent_mm_protocal_c_arp.wjV.vUQ;
                if (q.a.vcx != null && linkedList != null) {
                    it = linkedList.iterator();
                    while (it.hasNext()) {
                        mfVar = (mf) it.next();
                        if (bh.ov(mfVar.ksU) || !mfVar.ksU.equals(com.tencent.mm.z.q.FS())) {
                        }
                    }
                    obj = 1;
                    if (!(obj == null || q.a.vcx == null)) {
                        q.a.vcx.Fr(str2);
                    }
                }
                obj = null;
                q.a.vcx.Fr(str2);
            }
            aVB = "MicroMsg.BigBallContactAssemblerImpl";
            String str4 = "processModContact chatroom:%s count:%d ChatRoomData:%s owner:%s type:%d max:%d upgrader:%s ver:%d infomask:%d ";
            Object[] objArr = new Object[9];
            objArr[0] = str2;
            objArr[1] = Integer.valueOf(com_tencent_mm_protocal_c_arp.wjV == null ? 0 : com_tencent_mm_protocal_c_arp.wjV.kZx);
            objArr[2] = com_tencent_mm_protocal_c_arp.wzg;
            objArr[3] = com_tencent_mm_protocal_c_arp.wzf;
            objArr[4] = Integer.valueOf(com_tencent_mm_protocal_c_arp.wzq);
            objArr[5] = Integer.valueOf(com_tencent_mm_protocal_c_arp.wzp);
            objArr[6] = com_tencent_mm_protocal_c_arp.nkB;
            objArr[7] = Integer.valueOf(com_tencent_mm_protocal_c_arp.wzo);
            if (com_tencent_mm_protocal_c_arp.wjV == null) {
                i = -1;
            } else {
                i = com_tencent_mm_protocal_c_arp.wjV.vUR;
            }
            objArr[8] = Integer.valueOf(i);
            com.tencent.mm.sdk.platformtools.x.i(aVB, str4, objArr);
            if (!(com_tencent_mm_protocal_c_arp.wjV == null || com_tencent_mm_protocal_c_arp.wjV.kZx == 0)) {
                com.tencent.mm.i.a.a.a aVar = new com.tencent.mm.i.a.a.a();
                aVar.type = com_tencent_mm_protocal_c_arp.wzq;
                aVar.gBI = com_tencent_mm_protocal_c_arp.wzp;
                aVar.gBJ = com_tencent_mm_protocal_c_arp.nkB;
                aVar.gBK = com_tencent_mm_protocal_c_arp.wzo;
                if (com_tencent_mm_protocal_c_arp.wjV.vUR == 0) {
                    aVar.fAZ = com_tencent_mm_protocal_c_arp.wzo;
                }
                if (m.E(str2, com_tencent_mm_protocal_c_arp.wzo)) {
                    com.tencent.mm.sdk.b.a.xef.m(new ha());
                    m.F(str2, com_tencent_mm_protocal_c_arp.wzq);
                }
                com.tencent.mm.sdk.b.b jxVar = new jx();
                jxVar.fAY.chatroomName = str2;
                jxVar.fAY.fAZ = aVar.fAZ;
                m.a(str2, com_tencent_mm_protocal_c_arp.wzf, com_tencent_mm_protocal_c_arp.wjV, com.tencent.mm.z.q.FS(), aVar, jxVar);
            }
        }
        if (!(a.fZ(xVar.field_type) || xVar.AD() || x.gy(xVar.field_username) || s.eV(xVar.field_username))) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.BigBallContactAssemblerImpl", "processModContact delChatContact now user:%s ,type:%d", new Object[]{xVar.field_username, Integer.valueOf(xVar.field_type)});
            ar.Hg();
            com.tencent.mm.z.c.Fd().WX(xVar.field_username);
        }
        if ((xVar.field_type & 2048) != 0) {
            if (xVar2 == null || (xVar2.field_type & 2048) != (xVar.field_type & 2048)) {
                if (f.jW(xVar.field_username) && !f.eE(xVar.field_username)) {
                    z(xVar);
                } else if (xVar.cia() && f.jU(xVar.field_username) && xVar != null && xVar.cia() && f.jU(xVar.field_username)) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BigBallContactAssemblerImpl", "dealPlaceSubscribeBizToTop uct : " + xVar.field_username);
                    ar.Hg();
                    ae WY3 = com.tencent.mm.z.c.Fd().WY(xVar.field_username);
                    y.Mf().jK(xVar.field_username);
                    if (WY3 == null) {
                        ar.Hg();
                        if (com.tencent.mm.z.c.Fd().WY("officialaccounts") == null) {
                            WY3 = new ae("officialaccounts");
                            WY3.ciy();
                            ar.Hg();
                            com.tencent.mm.z.c.Fd().d(WY3);
                        }
                        WY3 = new ae(xVar.field_username);
                        WY3.dH("officialaccounts");
                        ar.Hg();
                        com.tencent.mm.z.c.Fd().d(WY3);
                    }
                }
            }
        } else if ((xVar2 == null || (xVar2.field_type & 2048) != (xVar.field_type & 2048)) && f.jW(xVar.field_username) && !f.eE(xVar.field_username)) {
            z(xVar);
        }
        if (xVar2 == null || a.fZ(xVar2.field_type) || !a.fZ(xVar.field_type)) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        if (a.fZ(xVar.field_type)) {
            ar.Hg();
            bf EZ = com.tencent.mm.z.c.EZ().EZ(str2);
            if ((EZ == null || bh.ov(EZ.field_encryptUsername)) && !bh.ov(str3)) {
                ar.Hg();
                EZ = com.tencent.mm.z.c.EZ().EZ(str3);
            }
            if (!(EZ == null || bh.ov(EZ.field_encryptUsername))) {
                ar.Hg();
                com.tencent.mm.z.c.EZ().Fa(EZ.field_encryptUsername);
            }
        }
        if (f.jV(xVar.field_username)) {
            y.Mm();
            com.tencent.mm.ag.c.a(xVar.field_username, null);
            if (obj2 != null && f.jW(xVar.field_username)) {
                if (f.eE(xVar.field_username)) {
                    y.Ml();
                    h.a(xVar.field_username, null);
                } else if (f.jZ(xVar.field_username)) {
                    ar.Hg();
                    if (com.tencent.mm.z.c.Fd().WY(xVar.field_username) == null) {
                        jK = y.Mf().jK(xVar.field_username);
                        ae aeVar = new ae(xVar.field_username);
                        if (jK.Lg()) {
                            aeVar.dH(null);
                        } else {
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", new Object[]{jK.Lm(), xVar.field_username});
                            aeVar.dH(bh.ou(jK.Lm()));
                        }
                        aeVar.ciy();
                        ar.Hg();
                        com.tencent.mm.z.c.Fd().d(aeVar);
                    }
                }
            }
        }
        jK = f.jS(xVar.field_username);
        if (jK != null) {
            d.b bI = jK.bI(false);
            if (bI != null) {
                i = 0;
                if (bI.hou != null) {
                    i = bI.hou.optInt("WXAppType", 0);
                }
                if (i != 0) {
                    obj = 1;
                    if (obj != null) {
                        y.Mp();
                        str = xVar.field_username;
                        if (!bh.ov(str)) {
                            jK = y.Mf().jK(str);
                            jK.field_attrSyncVersion = null;
                            jK.field_incrementUpdateTime = 0;
                            y.Mf().e(jK);
                        }
                    }
                    if ((xVar.field_type & 8) == 0) {
                        if (xVar2 == null || (xVar2.field_type & 8) != (xVar.field_type & 8)) {
                            ar.Hg();
                            com.tencent.mm.z.c.Fd().d(new String[]{xVar.field_username}, "@blacklist");
                        }
                    } else if (xVar2 == null || (xVar2.field_type & 8) != (xVar.field_type & 8)) {
                        ar.Hg();
                        com.tencent.mm.z.c.Fd().d(new String[]{xVar.field_username}, "");
                    }
                    if (!z) {
                        if (xVar != null && xVar.cia() && a.fZ(xVar.field_type)) {
                            currentTimeMillis = System.currentTimeMillis();
                            ar.Hg();
                            WY = com.tencent.mm.z.c.Fd().WY(xVar.field_username);
                            if (WY != null && WY.gc(4194304)) {
                                ar.Hg();
                                boolean a = com.tencent.mm.z.c.Fd().a(xVar.field_username, 4194304, false, WY.field_attrflag);
                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BigBallContactAssemblerImpl", "Reset temp session attr flag.(talker %s, updateSucc %s, cost %s)", new Object[]{xVar.field_username, Boolean.valueOf(a), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                            }
                        }
                        if (xVar2 != null && ((int) xVar2.gJd) > 0 && xVar2.fWw != 0 && xVar2.fWx == 0 && xVar.fWx == 1) {
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BigBallContactAssemblerImpl", "hakon removeParentRefAndUnread user = %s", new Object[]{xVar.field_username});
                            ar.Hg();
                            com.tencent.mm.z.c.Fd().Xm(xVar.field_username);
                            ar.Hg();
                            WY2 = com.tencent.mm.z.c.Fd().WY("officialaccounts");
                            if (WY2 != null) {
                                ar.Hg();
                                WY2.eO(com.tencent.mm.z.c.Fd().ciH());
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BigBallContactAssemblerImpl", "unread count is %d", new Object[]{Integer.valueOf(WY2.field_unReadCount)});
                                ar.Hg();
                                str = com.tencent.mm.z.c.Fd().Xj("officialaccounts");
                                ar.Hg();
                                Ex = com.tencent.mm.z.c.Fa().Ex(str);
                                if (Ex != null || Ex.field_msgId <= 0) {
                                    WY2.ciy();
                                } else {
                                    WY2.ac(Ex);
                                    WY2.setContent(Ex.field_talker + ":" + Ex.field_content);
                                    WY2.dE(Integer.toString(Ex.getType()));
                                    ar.Hg();
                                    as.b uw = com.tencent.mm.z.c.Fd().uw();
                                    if (uw != null) {
                                        PString pString = new PString();
                                        PString pString2 = new PString();
                                        PInt pInt = new PInt();
                                        Ex.dS("officialaccounts");
                                        Ex.setContent(WY2.field_content);
                                        uw.a(Ex, pString, pString2, pInt, true);
                                        WY2.dF(pString.value);
                                        WY2.dG(pString2.value);
                                        WY2.eS(pInt.value);
                                    }
                                }
                                ar.Hg();
                                com.tencent.mm.z.c.Fd().a(WY2, WY2.field_username);
                            }
                        }
                    }
                    if (obj2 != null) {
                        rmVar = new jm();
                        rmVar.fAe.username = xVar.field_username;
                        rmVar.fAe.fAf = xVar.fAf;
                        com.tencent.mm.sdk.b.a.xef.m(rmVar);
                    }
                    if (obj2 != null && com_tencent_mm_protocal_c_arp.vHW == 18) {
                        rmVar = new is();
                        rmVar.fzh.fzi = xVar.field_encryptUsername;
                        rmVar.fzh.type = 2;
                        l.Ty().mZ(rmVar.fzh.fzi);
                        com.tencent.mm.sdk.b.a.xef.m(rmVar);
                    }
                    if (obj2 != null) {
                        aT(xVar.field_username, com_tencent_mm_protocal_c_arp.vHW);
                    }
                    com.tencent.mm.plugin.label.a.a.aUX().aUR();
                }
            }
        }
        obj = null;
        if (obj != null) {
            y.Mp();
            str = xVar.field_username;
            if (bh.ov(str)) {
                jK = y.Mf().jK(str);
                jK.field_attrSyncVersion = null;
                jK.field_incrementUpdateTime = 0;
                y.Mf().e(jK);
            }
        }
        if ((xVar.field_type & 8) == 0) {
            ar.Hg();
            com.tencent.mm.z.c.Fd().d(new String[]{xVar.field_username}, "");
        } else {
            ar.Hg();
            com.tencent.mm.z.c.Fd().d(new String[]{xVar.field_username}, "@blacklist");
        }
        if (z) {
            currentTimeMillis = System.currentTimeMillis();
            ar.Hg();
            WY = com.tencent.mm.z.c.Fd().WY(xVar.field_username);
            ar.Hg();
            boolean a2 = com.tencent.mm.z.c.Fd().a(xVar.field_username, 4194304, false, WY.field_attrflag);
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BigBallContactAssemblerImpl", "Reset temp session attr flag.(talker %s, updateSucc %s, cost %s)", new Object[]{xVar.field_username, Boolean.valueOf(a2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BigBallContactAssemblerImpl", "hakon removeParentRefAndUnread user = %s", new Object[]{xVar.field_username});
            ar.Hg();
            com.tencent.mm.z.c.Fd().Xm(xVar.field_username);
            ar.Hg();
            WY2 = com.tencent.mm.z.c.Fd().WY("officialaccounts");
            if (WY2 != null) {
                ar.Hg();
                WY2.eO(com.tencent.mm.z.c.Fd().ciH());
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BigBallContactAssemblerImpl", "unread count is %d", new Object[]{Integer.valueOf(WY2.field_unReadCount)});
                ar.Hg();
                str = com.tencent.mm.z.c.Fd().Xj("officialaccounts");
                ar.Hg();
                Ex = com.tencent.mm.z.c.Fa().Ex(str);
                if (Ex != null) {
                }
                WY2.ciy();
                ar.Hg();
                com.tencent.mm.z.c.Fd().a(WY2, WY2.field_username);
            }
        }
        if (obj2 != null) {
            rmVar = new jm();
            rmVar.fAe.username = xVar.field_username;
            rmVar.fAe.fAf = xVar.fAf;
            com.tencent.mm.sdk.b.a.xef.m(rmVar);
        }
        rmVar = new is();
        rmVar.fzh.fzi = xVar.field_encryptUsername;
        rmVar.fzh.type = 2;
        l.Ty().mZ(rmVar.fzh.fzi);
        com.tencent.mm.sdk.b.a.xef.m(rmVar);
        if (obj2 != null) {
            aT(xVar.field_username, com_tencent_mm_protocal_c_arp.vHW);
        }
        com.tencent.mm.plugin.label.a.a.aUX().aUR();
    }

    private static void a(arp com_tencent_mm_protocal_c_arp, String str, x xVar, boolean z) {
        String FS = com.tencent.mm.z.q.FS();
        if (FS != null && !FS.equals(str)) {
            d jK = y.Mf().jK(str);
            jK.field_username = str;
            jK.field_brandList = com_tencent_mm_protocal_c_arp.hvD;
            pq pqVar = com_tencent_mm_protocal_c_arp.wvm;
            if (pqVar != null) {
                jK.field_brandFlag = pqVar.hvH;
                jK.field_brandInfo = pqVar.hvJ;
                jK.field_brandIconURL = pqVar.hvK;
                jK.field_extInfo = pqVar.hvI;
                if (z) {
                    jK.field_attrSyncVersion = null;
                    jK.field_incrementUpdateTime = 0;
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BigBallContactAssemblerImpl", "Reset biz(%s) Attribute syncVersion and incUpdateTime.", new Object[]{str});
                }
                if (!bh.ov(jK.field_extInfo)) {
                    jK.bI(true);
                }
            }
            if (!(jK.bI(false) == null || jK.bI(false).LC() != 3 || jK.bI(false).LG() == null || bh.ov(jK.Lm()))) {
                jK.field_enterpriseFather = jK.Lm();
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BigBallContactAssemblerImpl", "saveBizInfo, %s set enterpriseFather %s", new Object[]{str, jK.field_enterpriseFather});
            }
            if (!y.Mf().e(jK)) {
                y.Mf().d(jK);
            }
            xVar.eL(jK.field_type);
        }
    }

    public static boolean a(x xVar, arp com_tencent_mm_protocal_c_arp, boolean z) {
        if (xVar == null || bh.ov(xVar.field_username)) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BigBallContactAssemblerImpl", "dkinit dealModContactExtInfo failed invalid contact");
            return false;
        }
        String str = xVar.field_username;
        String str2 = xVar.field_encryptUsername;
        n.JQ().a(com.tencent.mm.ad.b.a(str, com_tencent_mm_protocal_c_arp));
        bla com_tencent_mm_protocal_c_bla = com_tencent_mm_protocal_c_arp.wvl;
        if (!(xVar.field_username.endsWith("@chatroom") || com_tencent_mm_protocal_c_bla == null)) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BigBallContactAssemblerImpl", "SnsFlag modcontact " + com_tencent_mm_protocal_c_bla.hvE + " " + com_tencent_mm_protocal_c_arp.vYI);
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBg modcontact " + com_tencent_mm_protocal_c_bla.hvF);
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + com_tencent_mm_protocal_c_bla.hvG);
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + com_tencent_mm_protocal_c_bla.wOs);
            if (com.tencent.mm.plugin.sns.b.n.qQz != null) {
                com.tencent.mm.plugin.sns.b.n.qQz.a(xVar.field_username, com_tencent_mm_protocal_c_bla);
            }
        }
        if (a.fZ(xVar.field_type)) {
            boolean T = l.Tx().T(str, 1);
            if (T) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, user = " + str);
            } else {
                T = l.Tx().T(str2, 1);
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, encryptUser = " + str2);
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact, update state(ADDED) FMessageConversation, ret = " + T);
        }
        if (a.fZ(xVar.field_type) && (xVar.getSource() == 10 || xVar.getSource() == 13)) {
            Context context = ac.getContext();
            str2 = xVar.field_username;
            String str3 = xVar.field_encryptUsername;
            if (com.tencent.mm.modelsimple.d.bt(context)) {
                com.tencent.mm.sdk.f.e.b(new com.tencent.mm.modelsimple.b(context, com.tencent.mm.modelsimple.d.bv(context), str2, str3), "MMAccountManager_updateSpecifiedContact").start();
            } else {
                com.tencent.mm.modelsimple.d.B(context, null);
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.MMAccountManager", "no account added or not current account");
            }
            com.tencent.mm.modelfriend.b kR = af.OD().kR(xVar.field_encryptUsername);
            if (!(kR == null || bh.ov(kR.hvs))) {
                kR.username = xVar.field_username;
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BigBallContactAssemblerImpl", "account sync: update addr " + af.OD().a(kR.hvs, kR));
            }
        }
        a(com_tencent_mm_protocal_c_arp, str, xVar, z);
        return true;
    }

    private static boolean a(x xVar, bf bfVar) {
        boolean z = false;
        if (!bh.ov(bfVar.field_conDescription)) {
            xVar.dw(bfVar.field_conDescription);
        }
        if (!s.gD(xVar.field_username) && a.fZ(xVar.field_type)) {
            z = true;
            if (!bh.ov(bfVar.field_conDescription)) {
                com.tencent.mm.bq.a com_tencent_mm_protocal_c_arq = new arq();
                com_tencent_mm_protocal_c_arq.wzx = xVar.field_username;
                com_tencent_mm_protocal_c_arq.nfe = bfVar.field_conDescription;
                ar.Hg();
                com.tencent.mm.z.c.EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(54, com_tencent_mm_protocal_c_arq));
            }
        }
        return z;
    }

    private static void z(x xVar) {
        if (xVar != null && f.jW(xVar.field_username) && !f.eE(xVar.field_username)) {
            ar.Hg();
            ae WY = com.tencent.mm.z.c.Fd().WY(xVar.field_username);
            d jK = y.Mf().jK(xVar.field_username);
            if (f.jZ(jK.field_username) && WY == null) {
                WY = new ae(jK.field_username);
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", new Object[]{jK.Lm(), jK.field_username});
                WY.dH(bh.ou(jK.Lm()));
                WY.ciy();
                ar.Hg();
                com.tencent.mm.z.c.Fd().d(WY);
            }
        }
    }

    private static void aT(String str, int i) {
        com.tencent.mm.bf.f[] fVarArr;
        com.tencent.mm.bf.h[] hVarArr;
        com.tencent.mm.pluginsdk.ui.preference.b[] a;
        j[] jVarArr;
        if (i == 26 || i == 27 || i == 28 || i == 29) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is shake");
            j[] nf = l.Tz().nf(str);
            fVarArr = null;
            hVarArr = null;
            a = com.tencent.mm.pluginsdk.ui.preference.b.a(ac.getContext(), nf);
            jVarArr = nf;
        } else if (i == 18) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is lbs");
            ca[] na = l.Ty().na(str);
            fVarArr = null;
            ca[] caVarArr = na;
            a = com.tencent.mm.pluginsdk.ui.preference.b.a(ac.getContext(), na);
            jVarArr = null;
        } else {
            com.tencent.mm.bf.f[] mV = l.Tw().mV(str);
            fVarArr = mV;
            hVarArr = null;
            a = com.tencent.mm.pluginsdk.ui.preference.b.a(ac.getContext(), mV);
            jVarArr = null;
        }
        if (a != null) {
            int i2 = 0;
            int length = a.length;
            int i3 = 0;
            while (i3 < length) {
                int i4;
                com.tencent.mm.pluginsdk.ui.preference.b bVar = a[i3];
                au auVar = new au();
                auVar.setContent(bVar.hef);
                int hp = s.hp(bVar.username);
                if (fVarArr != null) {
                    i4 = i2 + 1;
                    auVar.aq(fVarArr[i2].field_createTime);
                } else if (hVarArr != null) {
                    i4 = i2 + 1;
                    auVar.aq(hVarArr[i2].field_createtime * 1000);
                } else if (jVarArr != null) {
                    i4 = i2 + 1;
                    auVar.aq(jVarArr[i2].field_createtime * 1000);
                } else {
                    i4 = i2;
                }
                auVar.dS(bVar.username);
                auVar.setType(hp);
                if (bVar.fLH) {
                    auVar.eQ(2);
                    auVar.eR(1);
                } else {
                    auVar.eQ(6);
                    auVar.eR(0);
                }
                ar.Hg();
                long Q = com.tencent.mm.z.c.Fa().Q(auVar);
                Assert.assertTrue(Q != -1);
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BigBallContactAssemblerImpl", "new msg inserted to db , local id = " + Q);
                i3++;
                i2 = i4;
            }
            au auVar2 = new au();
            if (fVarArr != null) {
                auVar2.aq(fVarArr[fVarArr.length - 1].field_createTime + 1);
            } else if (hVarArr != null) {
                auVar2.aq((hVarArr[hVarArr.length - 1].field_createtime * 1000) + 1);
            } else if (jVarArr != null) {
                auVar2.aq((jVarArr[jVarArr.length - 1].field_createtime * 1000) + 1);
            }
            auVar2.dS(str);
            auVar2.setContent(ac.getContext().getString(R.l.eRx));
            auVar2.setType(10000);
            auVar2.eQ(6);
            auVar2.eR(0);
            ar.Hg();
            com.tencent.mm.z.c.Fa().Q(auVar2);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BigBallContactAssemblerImpl", "onsceneEnd errType:%d,errCode:%d,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar.getType() != 681 || i != 0 || i2 != 0) {
            return;
        }
        if (com.tencent.mm.kernel.g.Dh().gPy) {
            List<com.tencent.mm.plugin.messenger.foundation.a.a.e.b> list = ((com.tencent.mm.ay.a) kVar).hIK;
            Set<String> hashSet = new HashSet();
            try {
                for (com.tencent.mm.plugin.messenger.foundation.a.a.e.b bVar : list) {
                    if (bVar.getCmdId() == 2) {
                        hashSet.add(com.tencent.mm.platformtools.n.a(((arp) new arp().aF(bVar.getBuffer())).vYI));
                    } else if (bVar.getCmdId() == 54) {
                        hashSet.add(((arq) new arq().aF(bVar.getBuffer())).wzx);
                    } else if (bVar.getCmdId() == 60) {
                        hashSet.add(((asc) new asc().aF(bVar.getBuffer())).wzx);
                    }
                }
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.BigBallContactAssemblerImpl", e, "BaseProtoBuf parseFrom error!", new Object[0]);
            }
            for (String str2 : hashSet) {
                if (!bh.ov(str2)) {
                    ak.a.hfL.a(str2, null, null);
                }
            }
            return;
        }
        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.BigBallContactAssemblerImpl", "initialize notify is not done.");
    }
}
