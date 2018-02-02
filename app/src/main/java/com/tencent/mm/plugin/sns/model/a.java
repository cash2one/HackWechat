package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import android.util.Base64;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bbj;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.biz;
import com.tencent.mm.protocal.c.bjc;
import com.tencent.mm.protocal.c.bje;
import com.tencent.mm.protocal.c.bjf;
import com.tencent.mm.protocal.c.bjk;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.bkj;
import com.tencent.mm.protocal.c.blt;
import com.tencent.mm.protocal.c.blu;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.protocal.c.cc;
import com.tencent.mm.protocal.c.z;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.StreamCorruptedException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a {
    private static final String qSr;
    private static LinkedHashMap<Long, Integer> qSs;
    private static Comparator<bjk> qSt = new 1();

    static {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dk();
        qSr = stringBuilder.append(g.Dj().cachePath).append("sns_recvd_ad").toString();
    }

    public static void a(biz com_tencent_mm_protocal_c_biz, bdn com_tencent_mm_protocal_c_bdn) {
        if (com_tencent_mm_protocal_c_biz == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else if (com_tencent_mm_protocal_c_biz.wMm == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else {
            e b = b(com_tencent_mm_protocal_c_biz);
            if (b != null) {
                b.Lj(a(b.field_adinfo, com_tencent_mm_protocal_c_bdn));
                if (ae.bvy().eL(com_tencent_mm_protocal_c_biz.wMm.vPO)) {
                    x.i("MicroMsg.AdSnsInfoStorageLogic", "ind this adobj and update" + com_tencent_mm_protocal_c_biz.wMm.vPO);
                    ae.bvy().b(com_tencent_mm_protocal_c_biz.wMm.vPO, b);
                    return;
                }
                x.i("MicroMsg.AdSnsInfoStorageLogic", "local can not find this adobj " + com_tencent_mm_protocal_c_biz.wMm.vPO);
            }
        }
    }

    public static void a(bkj com_tencent_mm_protocal_c_bkj) {
        a(b(com_tencent_mm_protocal_c_bkj));
    }

    public static void a(biz com_tencent_mm_protocal_c_biz) {
        if (com_tencent_mm_protocal_c_biz == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else if (com_tencent_mm_protocal_c_biz.wMm == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else {
            ae.bvy().a(com_tencent_mm_protocal_c_biz.wMm.vPO, b(com_tencent_mm_protocal_c_biz));
        }
    }

    private static e b(biz com_tencent_mm_protocal_c_biz) {
        e eVar;
        e eK = ae.bvy().eK(com_tencent_mm_protocal_c_biz.wMm.vPO);
        bjv com_tencent_mm_protocal_c_bjv = com_tencent_mm_protocal_c_biz.wMm;
        String str = null;
        if (eK == null) {
            eVar = new e();
        } else {
            str = eK.bxV().rtA;
            eVar = eK;
        }
        String b = n.b(com_tencent_mm_protocal_c_bjv.wMW);
        if (bh.ov(b)) {
            return null;
        }
        if (!eVar.Lk(b)) {
            return null;
        }
        bnp bxV;
        Iterator it;
        if (!bh.ov(str)) {
            bxV = eVar.bxV();
            bxV.rtA = str;
            eVar.c(bxV);
        }
        com_tencent_mm_protocal_c_bjv.wNn = ai.b(com_tencent_mm_protocal_c_bjv.wNn, eVar.field_attrBuf);
        x.d("MicroMsg.AdSnsInfoStorageLogic", "from server xml ok %d", new Object[]{Long.valueOf(com_tencent_mm_protocal_c_bjv.vPO)});
        com_tencent_mm_protocal_c_bjv.wMW.bj(new byte[0]);
        eVar.field_userName = com_tencent_mm_protocal_c_bjv.vIy;
        if (com_tencent_mm_protocal_c_biz.wMn != null) {
            str = n.a(com_tencent_mm_protocal_c_biz.wMn);
            if (!bh.ov(str)) {
                eVar.field_recxml = str;
            }
            str = eVar.field_recxml;
            if (!(bh.ov(str) || str.equals(eVar.field_adxml))) {
                x.i("MicroMsg.AdSnsInfoStorageLogic", "update field adxml " + str);
                eVar.field_adxml = str;
            }
        }
        eVar.field_likeFlag = com_tencent_mm_protocal_c_bjv.wMX;
        long j = com_tencent_mm_protocal_c_bjv.vPO;
        eVar.field_snsId = j;
        if (j != 0) {
            eVar.field_stringSeq = i.eq(j);
            eVar.field_stringSeq = i.JN(eVar.field_stringSeq);
            x.d("MicroMsg.AdSnsInfo", j + " stringSeq " + eVar.field_stringSeq);
        }
        eVar.xj(2);
        eVar.xj(32);
        try {
            bjv com_tencent_mm_protocal_c_bjv2;
            List<bjk> linkedList;
            Iterator it2;
            bjk com_tencent_mm_protocal_c_bjk;
            Iterator it3;
            bjk com_tencent_mm_protocal_c_bjk2;
            af WO;
            if (eVar.field_attrBuf == null) {
                com_tencent_mm_protocal_c_bjv2 = new bjv();
            } else {
                com_tencent_mm_protocal_c_bjv2 = (bjv) new bjv().aF(eVar.field_attrBuf);
            }
            if (!(com_tencent_mm_protocal_c_bjv2 == null || com_tencent_mm_protocal_c_bjv2.wNd == null)) {
                linkedList = new LinkedList();
                it2 = com_tencent_mm_protocal_c_bjv.wNd.iterator();
                while (it2.hasNext()) {
                    com_tencent_mm_protocal_c_bjk = (bjk) it2.next();
                    if (com_tencent_mm_protocal_c_bjk.wzr > 0) {
                        linkedList.add(com_tencent_mm_protocal_c_bjk);
                        it3 = com_tencent_mm_protocal_c_bjv2.wNd.iterator();
                        while (it3.hasNext()) {
                            com_tencent_mm_protocal_c_bjk2 = (bjk) it3.next();
                            if (com_tencent_mm_protocal_c_bjk2.wMz == com_tencent_mm_protocal_c_bjk.wMz) {
                                com_tencent_mm_protocal_c_bjv2.wNd.remove(com_tencent_mm_protocal_c_bjk2);
                                break;
                            }
                        }
                    }
                }
                for (bjk com_tencent_mm_protocal_c_bjk3 : linkedList) {
                    com_tencent_mm_protocal_c_bjv.wNd.remove(com_tencent_mm_protocal_c_bjk3);
                }
                linkedList.clear();
                Iterator it4 = com_tencent_mm_protocal_c_bjv2.wNd.iterator();
                while (it4.hasNext()) {
                    com_tencent_mm_protocal_c_bjk3 = (bjk) it4.next();
                    if (!(b(com_tencent_mm_protocal_c_bjk3, com_tencent_mm_protocal_c_bjv.wNd) || com_tencent_mm_protocal_c_bjk3.wMz == 0)) {
                        g.Dk();
                        WO = ((h) g.h(h.class)).EY().WO(com_tencent_mm_protocal_c_bjk3.vIy);
                        if (WO == null || !com.tencent.mm.l.a.fZ(WO.field_type) || WO.AF()) {
                            x.i("MicroMsg.AdSnsInfoStorageLogic", "not in ommentlist not mycontact " + com_tencent_mm_protocal_c_bjk3.vIy);
                        } else {
                            com_tencent_mm_protocal_c_bjv.wNd.add(com_tencent_mm_protocal_c_bjk3);
                            com_tencent_mm_protocal_c_bjv.wNc = com_tencent_mm_protocal_c_bjv.wNd.size();
                        }
                    }
                }
            }
            Collections.sort(com_tencent_mm_protocal_c_bjv.wNd, qSt);
            if (com_tencent_mm_protocal_c_bjv.wNa != null) {
                linkedList = new LinkedList();
                it2 = com_tencent_mm_protocal_c_bjv.wNa.iterator();
                while (it2.hasNext()) {
                    com_tencent_mm_protocal_c_bjk3 = (bjk) it2.next();
                    if (com_tencent_mm_protocal_c_bjk3.wzr > 0) {
                        linkedList.add(com_tencent_mm_protocal_c_bjk3);
                        it3 = com_tencent_mm_protocal_c_bjv2.wNa.iterator();
                        while (it3.hasNext()) {
                            com_tencent_mm_protocal_c_bjk2 = (bjk) it3.next();
                            if (!bh.ov(com_tencent_mm_protocal_c_bjk2.vIy)) {
                                if (com_tencent_mm_protocal_c_bjk2.vIy.equals(com_tencent_mm_protocal_c_bjk3.vIy)) {
                                }
                            }
                            com_tencent_mm_protocal_c_bjv2.wNa.remove(com_tencent_mm_protocal_c_bjk2);
                        }
                    }
                }
                for (bjk com_tencent_mm_protocal_c_bjk32 : linkedList) {
                    com_tencent_mm_protocal_c_bjv.wNa.remove(com_tencent_mm_protocal_c_bjk32);
                }
                linkedList.clear();
                if (!(com_tencent_mm_protocal_c_bjv2 == null || com_tencent_mm_protocal_c_bjv2.wNa == null)) {
                    it = com_tencent_mm_protocal_c_bjv2.wNa.iterator();
                    while (it.hasNext()) {
                        com_tencent_mm_protocal_c_bjk32 = (bjk) it.next();
                        if (!a(com_tencent_mm_protocal_c_bjk32, com_tencent_mm_protocal_c_bjv.wNa)) {
                            g.Dk();
                            WO = ((h) g.h(h.class)).EY().WO(com_tencent_mm_protocal_c_bjk32.vIy);
                            if (WO == null || !com.tencent.mm.l.a.fZ(WO.field_type) || WO.AF()) {
                                x.i("MicroMsg.AdSnsInfoStorageLogic", "not in likelist not mycontact " + com_tencent_mm_protocal_c_bjk32.vIy);
                            } else {
                                com_tencent_mm_protocal_c_bjv.wNa.add(com_tencent_mm_protocal_c_bjk32);
                                com_tencent_mm_protocal_c_bjv.wMZ = com_tencent_mm_protocal_c_bjv.wNa.size();
                            }
                        }
                    }
                }
                Collections.sort(com_tencent_mm_protocal_c_bjv.wNa, qSt);
            }
        } catch (Throwable e) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "error " + e.getMessage());
            x.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e, "", new Object[0]);
        }
        try {
            eVar.aJ(com_tencent_mm_protocal_c_bjv.toByteArray());
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e2, "", new Object[0]);
        }
        bxV = eVar.bxV();
        bxV.ksU = com_tencent_mm_protocal_c_bjv.vIy;
        eVar.field_pravited = bxV.wxG;
        x.d("MicroMsg.AdSnsInfoStorageLogic", "ext flag " + com_tencent_mm_protocal_c_bjv.wzw + " " + com_tencent_mm_protocal_c_bjv.wNd.size() + " " + com_tencent_mm_protocal_c_bjv.wNa.size());
        it = bxV.wQo.vYd.iterator();
        while (it.hasNext()) {
            ((aqr) it.next()).qQH = true;
        }
        eVar.c(bxV);
        eVar.field_type = bxV.wQo.vYc;
        eVar.field_subType = bxV.wQo.vYe;
        return eVar;
    }

    private static boolean a(bjk com_tencent_mm_protocal_c_bjk, List<bjk> list) {
        for (bjk com_tencent_mm_protocal_c_bjk2 : list) {
            if (!bh.ov(com_tencent_mm_protocal_c_bjk.vIy) && com_tencent_mm_protocal_c_bjk.vIy.equals(com_tencent_mm_protocal_c_bjk2.vIy)) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(bjk com_tencent_mm_protocal_c_bjk, List<bjk> list) {
        for (bjk com_tencent_mm_protocal_c_bjk2 : list) {
            if (com_tencent_mm_protocal_c_bjk.wMz == com_tencent_mm_protocal_c_bjk2.wMz && com_tencent_mm_protocal_c_bjk2.wMz != 0) {
                return true;
            }
        }
        return false;
    }

    private static void a(cc ccVar, int i, int i2, com.tencent.mm.plugin.sns.storage.a aVar) {
        if (ccVar == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else if (ccVar.vHo == null || ccVar.vHo.wMm == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else {
            String a;
            bjv com_tencent_mm_protocal_c_bjv = ccVar.vHo.wMm;
            e b = b(ccVar.vHo);
            bnp bxV = b.bxV();
            blt com_tencent_mm_protocal_c_blt = new blt();
            com_tencent_mm_protocal_c_blt.wPl = new blu();
            com_tencent_mm_protocal_c_blt.wPl.wPp = aVar.qZM;
            com_tencent_mm_protocal_c_blt.wPl.wPo = bxV.nGJ;
            com_tencent_mm_protocal_c_blt.wPl.cOY = b.getSource();
            com_tencent_mm_protocal_c_blt.wPl.rou = p.a(com_tencent_mm_protocal_c_blt.wPl);
            if (bxV.wQo.vYc == 1) {
                com_tencent_mm_protocal_c_blt.wPl.hOz = 1;
            } else if (bxV.wQo.vYc == 15) {
                com_tencent_mm_protocal_c_blt.wPl.hOz = 2;
            } else {
                com_tencent_mm_protocal_c_blt.wPl.hOz = 0;
            }
            blu com_tencent_mm_protocal_c_blu = com_tencent_mm_protocal_c_blt.wPl;
            b bxS = b.bxS();
            com_tencent_mm_protocal_c_blu.wPq = bxS == null ? 0 : bxS.reR;
            try {
                x.i("MicroMsg.AdSnsInfoStorageLogic", "replace newly add snsId:%s, statExtStr:%s(id=%s,uxInfo=%s)", new Object[]{bxV.nGJ, Base64.encodeToString(com_tencent_mm_protocal_c_blt.toByteArray(), 0).replace("\n", ""), com_tencent_mm_protocal_c_blt.wPl.wPo, com_tencent_mm_protocal_c_blt.wPl.wPp});
                bxV.rtA = a;
                b.c(bxV);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e, "", new Object[0]);
            }
            if (b != null) {
                b.field_createTime = i;
                b.field_exposureTime = 0;
                b.field_createAdTime = i2;
                a = n.a(ccVar.vHo.wMn);
                if (!bh.ov(a)) {
                    b.field_recxml = a;
                }
                b.field_adinfo = n.a(ccVar.vHp);
                b.field_adxml = b.field_recxml;
                ae.bvy().a(com_tencent_mm_protocal_c_bjv.vPO, b);
            }
        }
    }

    private static biz b(bkj com_tencent_mm_protocal_c_bkj) {
        if (com_tencent_mm_protocal_c_bkj == null) {
            return null;
        }
        biz com_tencent_mm_protocal_c_biz = new biz();
        com_tencent_mm_protocal_c_biz.wMn = com_tencent_mm_protocal_c_bkj.wNP;
        if (com_tencent_mm_protocal_c_biz.wMn == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "recommendObj.RecommendXml is null");
        }
        com_tencent_mm_protocal_c_biz.wMm = com_tencent_mm_protocal_c_bkj.wMm;
        return com_tencent_mm_protocal_c_biz;
    }

    private static cc a(bbj com_tencent_mm_protocal_c_bbj) {
        if (com_tencent_mm_protocal_c_bbj == null) {
            return null;
        }
        cc ccVar = new cc();
        ccVar.vHp = com_tencent_mm_protocal_c_bbj.wHM;
        if (ccVar.vHp == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "recObject.RecommendInfo is null");
            return null;
        }
        ccVar.vHo = b(com_tencent_mm_protocal_c_bbj.wHL);
        return ccVar;
    }

    public static void b(bbj com_tencent_mm_protocal_c_bbj) {
        cc a = a(com_tencent_mm_protocal_c_bbj);
        if (a != null) {
            com.tencent.mm.plugin.sns.storage.a aVar = new com.tencent.mm.plugin.sns.storage.a(n.a(a.vHp));
            int i = aVar.rdJ;
            int i2 = i <= 0 ? 1 : i + 1;
            int Lz = ae.bvv().Lz("");
            x.i("MicroMsg.AdSnsInfoStorageLogic", "ad.pos = %d, dbLimit = %d, createTime.limit = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(Lz)});
            com.tencent.mm.plugin.sns.storage.n bvv = ae.bvv();
            String str = "";
            String str2 = (com.tencent.mm.plugin.sns.storage.n.roY + " from SnsInfo where ") + com.tencent.mm.plugin.sns.storage.n.byG();
            if (com.tencent.mm.plugin.sns.storage.n.Lu(str)) {
                str2 = str2 + " AND " + bvv.Lv(str);
            }
            String str3 = ((((str2 + " AND createTime >= " + Lz) + " UNION ") + com.tencent.mm.plugin.sns.storage.n.roY + " from AdSnsInfo where createTime" + " > " + Lz) + com.tencent.mm.plugin.sns.storage.n.roZ) + " limit " + i2;
            x.d("MicroMsg.SnsInfoStorage", "getAdCursorForTimeLine " + str3 + " limtiSeq: " + str);
            Cursor rawQuery = bvv.gJP.rawQuery(str3, null);
            if (rawQuery == null || rawQuery.getCount() <= 0) {
                x.i("MicroMsg.AdSnsInfoStorageLogic", "db return nothing");
                i2 = (int) bh.Wo();
            } else {
                x.i("MicroMsg.AdSnsInfoStorageLogic", "db return %d feeds", new Object[]{Integer.valueOf(rawQuery.getCount())});
                m mVar = new m();
                if (i < 0) {
                    i2 = 0;
                } else {
                    i2 = i;
                }
                if (rawQuery.moveToPosition(i2)) {
                    mVar.b(rawQuery);
                } else {
                    rawQuery.moveToLast();
                    mVar.b(rawQuery);
                }
                i2 = mVar.field_createTime + 1;
            }
            rawQuery.close();
            x.i("MicroMsg.AdSnsInfoStorageLogic", "inserting snsid  " + a.vHo.wMm.vPO + " ,createTime " + i2);
            a(a, i2, (int) bh.Wo(), aVar);
            a(a);
            a(a.vHo.wMm.vPO, aVar);
        }
    }

    public static void d(LinkedList<bbj> linkedList, LinkedList<bjv> linkedList2) {
        if (linkedList != null) {
            LinkedList ad = ad(linkedList);
            x.i("MicroMsg.AdSnsInfoStorageLogic", "convert " + ad.size() + " recObj to AdvertiseObj");
            Iterator it = ad.iterator();
            while (it.hasNext()) {
                cc ccVar = (cc) it.next();
                if (es(ccVar.vHo.wMm.vPO)) {
                    x.w("MicroMsg.AdSnsInfoStorageLogic", "ignore recvd ad filter by snsId " + ccVar.vHo.wMm.vPO);
                    it.remove();
                }
            }
            a(ad, linkedList2, true);
        }
    }

    public static void e(LinkedList<cc> linkedList, LinkedList<bjv> linkedList2) {
        a(linkedList, linkedList2, false);
    }

    private static LinkedList<cc> ad(LinkedList<bbj> linkedList) {
        LinkedList<cc> linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            cc a = a((bbj) it.next());
            if (a != null) {
                linkedList2.add(a);
            }
        }
        return linkedList2;
    }

    private static void a(LinkedList<cc> linkedList, LinkedList<bjv> linkedList2, boolean z) {
        if (linkedList != null && linkedList2 != null && linkedList2.size() != 0) {
            int a = a((bjv) linkedList2.get(linkedList2.size() - 1));
            for (int i = 0; i < linkedList.size(); i++) {
                cc ccVar = (cc) linkedList.get(i);
                if (ccVar == null) {
                    x.i("MicroMsg.AdSnsInfoStorageLogic", "ad is null");
                } else if (ccVar.vHo == null) {
                    x.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject is null");
                } else if (ccVar.vHo.wMm == null) {
                    x.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject.SnsObject is null");
                } else if (z && ae.bvy().eL(ccVar.vHo.wMm.vPO)) {
                    x.i("MicroMsg.AdSnsInfoStorageLogic", "snsId %d already exist, ignore ", new Object[]{Long.valueOf(ccVar.vHo.wMm.vPO)});
                } else {
                    String a2 = n.a(ccVar.vHp);
                    String a3 = n.a(ccVar.vHo.wMn);
                    String b = n.b(ccVar.vHo.wMm.wMW);
                    com.tencent.mm.plugin.sns.storage.a aVar = new com.tencent.mm.plugin.sns.storage.a(a2);
                    x.i("MicroMsg.AdSnsInfoStorageLogic", "skXml " + a2);
                    x.i("MicroMsg.AdSnsInfoStorageLogic", "adXml " + a3);
                    x.i("MicroMsg.AdSnsInfoStorageLogic", "snsXml " + b + "\r\n");
                    b bVar = new b(a3);
                    if (bVar.reS == 0 || !es(bVar.reS)) {
                        int i2 = a + 1;
                        if (aVar.rdJ >= linkedList2.size() || aVar.rdJ < 0) {
                            x.w("MicroMsg.AdSnsInfoStorageLogic", "invalid ad.pos " + aVar.rdJ);
                        } else {
                            i2 = a((bjv) linkedList2.get(aVar.rdJ)) + 1;
                            x.i("MicroMsg.AdSnsInfoStorageLogic", "create adinfo time  " + i2 + " pos " + aVar.rdJ);
                        }
                        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                        x.i("MicroMsg.AdSnsInfoStorageLogic", "gettime " + currentTimeMillis);
                        a(ccVar, i2, currentTimeMillis, aVar);
                        et(ccVar.vHo.wMm.vPO);
                        et(bVar.reS);
                        a(ccVar.vHo.wMm.vPO, aVar);
                    } else {
                        x.w("MicroMsg.AdSnsInfoStorageLogic", "ignore recvd ad filter by originSnsId " + bVar.reS);
                    }
                }
            }
        }
    }

    private static void a(long j, com.tencent.mm.plugin.sns.storage.a aVar) {
        if (aVar.rel && !bh.ov(aVar.rek)) {
            k lVar = new l(j, 1, aVar.rek);
            g.Dk();
            g.Di().gPJ.a(lVar, 0);
        }
    }

    public static void ae(LinkedList<bbj> linkedList) {
        if (linkedList != null && !linkedList.isEmpty()) {
            LinkedList ad = ad(linkedList);
            x.i("MicroMsg.AdSnsInfoStorageLogic", "convert " + ad.size() + " recObj to AdvertiseObj");
            af(ad);
        }
    }

    public static void af(LinkedList<cc> linkedList) {
        if (linkedList != null) {
            for (int i = 0; i < linkedList.size(); i++) {
                a((cc) linkedList.get(i));
            }
        }
    }

    private static void a(cc ccVar) {
        String a = n.a(ccVar.vHo.wMn);
        if (!bh.ov(a) && new b(a).bwt()) {
            f.bxO().d("adId", a, "adxml", 0);
        }
    }

    public static void ag(LinkedList<bjv> linkedList) {
        if (linkedList != null) {
            com.tencent.mm.plugin.sns.storage.n bvv = ae.bvv();
            for (int i = 0; i < linkedList.size(); i++) {
                bjv com_tencent_mm_protocal_c_bjv = (bjv) linkedList.get(i);
                if (com_tencent_mm_protocal_c_bjv != null) {
                    m eR = bvv.eR(com_tencent_mm_protocal_c_bjv.vPO);
                    if (eR != null) {
                        bnp bxV = eR.bxV();
                        if (!(bxV == null || bh.ov(bxV.rLO))) {
                            f.bxO().d("adId", bxV.rLO, "adxml", 0);
                        }
                    }
                }
            }
        }
    }

    public static void JV(String str) {
        if (!bh.ov(str)) {
            f.bxO().d("adId", str, "adxml", 1);
        }
    }

    private static int a(bjv com_tencent_mm_protocal_c_bjv) {
        m eR = ae.bvv().eR(com_tencent_mm_protocal_c_bjv.vPO);
        return eR == null ? com_tencent_mm_protocal_c_bjv.pbl : eR.field_createTime;
    }

    public static boolean a(long j, bjf com_tencent_mm_protocal_c_bjf, int i, int i2, int i3, boolean z) {
        if (com_tencent_mm_protocal_c_bjf != null) {
            bje com_tencent_mm_protocal_c_bje = com_tencent_mm_protocal_c_bjf.wMD;
            if (!(com_tencent_mm_protocal_c_bje.ktN == 7 || com_tencent_mm_protocal_c_bje.ktN == 8)) {
                return false;
            }
        }
        String FS = q.FS();
        if (com_tencent_mm_protocal_c_bjf != null && com_tencent_mm_protocal_c_bjf.wME != null && com_tencent_mm_protocal_c_bjf.wME.wFM != null && com_tencent_mm_protocal_c_bjf.wME.wFM.equals(FS)) {
            return true;
        }
        e eK = ae.bvy().eK(j);
        try {
            m Ll;
            com.tencent.mm.plugin.sns.storage.a bxT;
            c cVar;
            bjk com_tencent_mm_protocal_c_bjk;
            int i4;
            bjv com_tencent_mm_protocal_c_bjv = (bjv) new bjv().aF(eK.field_attrBuf);
            com_tencent_mm_protocal_c_bjv.vPO = j;
            int i5 = eK.field_firstControlTime;
            bje com_tencent_mm_protocal_c_bje2 = com_tencent_mm_protocal_c_bjf.wMD;
            int source;
            Object[] objArr;
            if (com_tencent_mm_protocal_c_bje2.ktN == 7) {
                if (i2 > 0 && i5 + i2 < com_tencent_mm_protocal_c_bje2.pbl) {
                    if (z) {
                        Ll = ae.bvv().Ll(eK.bxW());
                        if (Ll != null) {
                            bxT = Ll.bxT();
                            if (bxT != null) {
                                cVar = (c) g.h(c.class);
                                source = eK.getSource();
                                objArr = new Object[7];
                                objArr[0] = Long.valueOf(u.LF(eK.bxW()));
                                objArr[1] = bxT.iTh;
                                objArr[2] = Integer.valueOf(2);
                                objArr[3] = Integer.valueOf(1);
                                objArr[4] = Integer.valueOf(com_tencent_mm_protocal_c_bjv.wNa != null ? com_tencent_mm_protocal_c_bjv.wNa.size() : 0);
                                objArr[5] = Integer.valueOf(com_tencent_mm_protocal_c_bjv.wNd != null ? com_tencent_mm_protocal_c_bjv.wNd.size() : 0);
                                objArr[6] = Integer.valueOf((int) (System.currentTimeMillis() / 1000));
                                cVar.a(13182, source, objArr);
                            } else {
                                x.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
                            }
                        } else {
                            x.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
                        }
                    }
                    x.i("MicroMsg.AdSnsInfoStorageLogic", "snsid " + j + " firstCreateTime " + i5 + " actionLikeTimeLimit: " + i2 + " curAction.createTime: " + com_tencent_mm_protocal_c_bje2.pbl + "is over the time limit!");
                    return false;
                }
            } else if (com_tencent_mm_protocal_c_bje2.ktN == 8 && i3 > 0 && i5 + i3 < com_tencent_mm_protocal_c_bje2.pbl) {
                if (z) {
                    Ll = ae.bvv().Ll(eK.bxW());
                    if (Ll != null) {
                        bxT = Ll.bxT();
                        if (bxT != null) {
                            cVar = (c) g.h(c.class);
                            source = eK.getSource();
                            objArr = new Object[7];
                            objArr[0] = Long.valueOf(u.LF(eK.bxW()));
                            objArr[1] = bxT.iTh;
                            objArr[2] = Integer.valueOf(2);
                            objArr[3] = Integer.valueOf(2);
                            objArr[4] = Integer.valueOf(com_tencent_mm_protocal_c_bjv.wNa != null ? com_tencent_mm_protocal_c_bjv.wNa.size() : 0);
                            objArr[5] = Integer.valueOf(com_tencent_mm_protocal_c_bjv.wNd != null ? com_tencent_mm_protocal_c_bjv.wNd.size() : 0);
                            objArr[6] = Integer.valueOf((int) (System.currentTimeMillis() / 1000));
                            cVar.a(13182, source, objArr);
                        } else {
                            x.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
                        }
                    } else {
                        x.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
                    }
                }
                x.i("MicroMsg.AdSnsInfoStorageLogic", "snsid " + j + " firstCreateTime " + i5 + " actionCommentTimeLimit: " + i3 + " curAction.createTime: " + com_tencent_mm_protocal_c_bje2.pbl + "is over the time limit!");
                return false;
            }
            int i6 = 0;
            Iterator it = com_tencent_mm_protocal_c_bjv.wNa.iterator();
            while (it.hasNext()) {
                com_tencent_mm_protocal_c_bjk = (bjk) it.next();
                if (com_tencent_mm_protocal_c_bjk.pbl <= i5 || !(com_tencent_mm_protocal_c_bjk == null || com_tencent_mm_protocal_c_bjk.vIy == null || !com_tencent_mm_protocal_c_bjk.vIy.equals(FS))) {
                    i4 = i6;
                } else {
                    i4 = i6 + 1;
                }
                i6 = i4;
            }
            int i7 = i6 + 0;
            i6 = 0;
            Iterator it2 = com_tencent_mm_protocal_c_bjv.wNd.iterator();
            while (it2.hasNext()) {
                com_tencent_mm_protocal_c_bjk = (bjk) it2.next();
                if (com_tencent_mm_protocal_c_bjk.pbl <= i5 || !(com_tencent_mm_protocal_c_bjk == null || com_tencent_mm_protocal_c_bjk.vIy == null || !com_tencent_mm_protocal_c_bjk.vIy.equals(FS))) {
                    i4 = i6;
                } else {
                    i4 = i6 + 1;
                }
                i6 = i4;
            }
            i4 = i7 + i6;
            x.i("MicroMsg.AdSnsInfoStorageLogic", "totalsize " + i4 + " firstCreateTime " + i5 + " actionLimit: " + i + " actionLikeTimeLimit: " + i2 + " actionCommentTimeLimit: " + i3);
            if (i4 >= i) {
                if (z) {
                    Ll = ae.bvv().Ll(eK.bxW());
                    if (Ll != null) {
                        bxT = Ll.bxT();
                        if (bxT != null) {
                            cVar = (c) g.h(c.class);
                            i5 = eK.getSource();
                            Object[] objArr2 = new Object[7];
                            objArr2[0] = Long.valueOf(u.LF(eK.bxW()));
                            objArr2[1] = bxT.iTh;
                            objArr2[2] = Integer.valueOf(1);
                            objArr2[3] = Integer.valueOf(2);
                            objArr2[4] = Integer.valueOf(com_tencent_mm_protocal_c_bjv.wNa != null ? com_tencent_mm_protocal_c_bjv.wNa.size() : 0);
                            objArr2[5] = Integer.valueOf(com_tencent_mm_protocal_c_bjv.wNd != null ? com_tencent_mm_protocal_c_bjv.wNd.size() : 0);
                            objArr2[6] = Integer.valueOf((int) (System.currentTimeMillis() / 1000));
                            cVar.a(13182, i5, objArr2);
                        } else {
                            x.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
                        }
                    } else {
                        x.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
                    }
                }
                return false;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e, "", new Object[0]);
        }
        return true;
    }

    public static boolean a(long j, bjf com_tencent_mm_protocal_c_bjf) {
        bje com_tencent_mm_protocal_c_bje = com_tencent_mm_protocal_c_bjf.wMD;
        if (com_tencent_mm_protocal_c_bje.ktN != 7 && com_tencent_mm_protocal_c_bje.ktN != 8) {
            return false;
        }
        e eK = ae.bvy().eK(j);
        if (eK == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "pass the action because the snsinfo is null " + j);
            return false;
        }
        try {
            bjv com_tencent_mm_protocal_c_bjv = (bjv) new bjv().aF(eK.field_attrBuf);
            com_tencent_mm_protocal_c_bjv.vPO = j;
            Iterator it;
            bjk com_tencent_mm_protocal_c_bjk;
            if (com_tencent_mm_protocal_c_bje.ktN == 7) {
                it = com_tencent_mm_protocal_c_bjv.wNa.iterator();
                while (it.hasNext()) {
                    com_tencent_mm_protocal_c_bjk = (bjk) it.next();
                    if (com_tencent_mm_protocal_c_bjk.pbl == com_tencent_mm_protocal_c_bje.pbl && com_tencent_mm_protocal_c_bjk.vIy.equals(com_tencent_mm_protocal_c_bje.wFM)) {
                        x.i("MicroMsg.AdSnsInfoStorageLogic", "like create time " + com_tencent_mm_protocal_c_bjk.pbl + " ");
                        return false;
                    }
                }
                com_tencent_mm_protocal_c_bjv.wNa.add(ac.a(com_tencent_mm_protocal_c_bjf));
            } else if (com_tencent_mm_protocal_c_bje.ktN == 8) {
                it = com_tencent_mm_protocal_c_bjv.wNd.iterator();
                while (it.hasNext()) {
                    com_tencent_mm_protocal_c_bjk = (bjk) it.next();
                    if (com_tencent_mm_protocal_c_bjk.pbl == com_tencent_mm_protocal_c_bje.pbl && com_tencent_mm_protocal_c_bjk.vIy.equals(com_tencent_mm_protocal_c_bje.wFM)) {
                        x.i("MicroMsg.AdSnsInfoStorageLogic", "like create time " + com_tencent_mm_protocal_c_bjk.pbl + " ");
                        return false;
                    }
                }
                com_tencent_mm_protocal_c_bjv.wNd.add(ac.a(com_tencent_mm_protocal_c_bjf));
            }
            eK.aJ(com_tencent_mm_protocal_c_bjv.toByteArray());
            ae.bvy().a(com_tencent_mm_protocal_c_bjv.vPO, eK);
        } catch (Throwable e) {
            x.e("MicroMsg.AdSnsInfoStorageLogic", "e " + e.getMessage());
            x.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e, "", new Object[0]);
        }
        return true;
    }

    private static boolean es(long j) {
        bux();
        return qSs.get(Long.valueOf(j)) != null;
    }

    private static void bux() {
        ObjectInput objectInputStream;
        Throwable e;
        if (qSs == null) {
            byte[] RZ = com.tencent.mm.pluginsdk.i.a.e.a.RZ(qSr);
            if (RZ != null) {
                try {
                    objectInputStream = new ObjectInputStream(new ByteArrayInputStream(RZ));
                    try {
                        qSs = (LinkedHashMap) objectInputStream.readObject();
                        try {
                            objectInputStream.close();
                        } catch (IOException e2) {
                        }
                    } catch (StreamCorruptedException e3) {
                        e = e3;
                        try {
                            x.e("MicroMsg.AdSnsInfoStorageLogic", bh.i(e));
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (IOException e4) {
                                }
                            }
                            if (qSs != null) {
                                qSs = new 2(((int) Math.ceil(666.6666870117188d)) + 1);
                            }
                        } catch (Throwable th) {
                            e = th;
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (IOException e5) {
                                }
                            }
                            throw e;
                        }
                    } catch (IOException e6) {
                        e = e6;
                        x.e("MicroMsg.AdSnsInfoStorageLogic", bh.i(e));
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e7) {
                            }
                        }
                        if (qSs != null) {
                            qSs = new 2(((int) Math.ceil(666.6666870117188d)) + 1);
                        }
                    } catch (ClassNotFoundException e8) {
                        e = e8;
                        x.e("MicroMsg.AdSnsInfoStorageLogic", bh.i(e));
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e9) {
                            }
                        }
                        if (qSs != null) {
                            qSs = new 2(((int) Math.ceil(666.6666870117188d)) + 1);
                        }
                    }
                } catch (StreamCorruptedException e10) {
                    e = e10;
                    objectInputStream = null;
                    x.e("MicroMsg.AdSnsInfoStorageLogic", bh.i(e));
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    if (qSs != null) {
                        qSs = new 2(((int) Math.ceil(666.6666870117188d)) + 1);
                    }
                } catch (IOException e11) {
                    e = e11;
                    objectInputStream = null;
                    x.e("MicroMsg.AdSnsInfoStorageLogic", bh.i(e));
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    if (qSs != null) {
                        qSs = new 2(((int) Math.ceil(666.6666870117188d)) + 1);
                    }
                } catch (ClassNotFoundException e12) {
                    e = e12;
                    objectInputStream = null;
                    x.e("MicroMsg.AdSnsInfoStorageLogic", bh.i(e));
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    if (qSs != null) {
                        qSs = new 2(((int) Math.ceil(666.6666870117188d)) + 1);
                    }
                } catch (Throwable th2) {
                    e = th2;
                    objectInputStream = null;
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    throw e;
                }
            }
            if (qSs != null) {
                qSs = new 2(((int) Math.ceil(666.6666870117188d)) + 1);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void et(long j) {
        if (j != 0) {
            if (qSs == null) {
                bux();
            }
            qSs.put(Long.valueOf(j), Integer.valueOf(0));
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ObjectOutput objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(qSs);
                objectOutputStream.flush();
                com.tencent.mm.pluginsdk.i.a.e.a.u(qSr, byteArrayOutputStream.toByteArray());
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                }
            } catch (Throwable e2) {
                x.e("MicroMsg.AdSnsInfoStorageLogic", bh.i(e2));
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                }
            }
        }
    }

    private static String a(String str, bdn com_tencent_mm_protocal_c_bdn) {
        if (com_tencent_mm_protocal_c_bdn == null || str == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "update with empty dynamic data");
            return str;
        }
        String str2;
        try {
            z zVar = new z();
            zVar.aF(com_tencent_mm_protocal_c_bdn.wJD.oz);
            if (zVar.vDS != null) {
                String str3 = "<(([a-zA-Z0-9\\-_]+)([^>]+)dynamicKey=[\"']%s[\"']([^>]*))";
                String str4 = "";
                Iterator it = zVar.vDS.iterator();
                str2 = str;
                while (it.hasNext()) {
                    try {
                        String str5;
                        bjc com_tencent_mm_protocal_c_bjc = (bjc) it.next();
                        if (com_tencent_mm_protocal_c_bjc.aAM != null) {
                            String format = String.format(str3, new Object[]{com_tencent_mm_protocal_c_bjc.aAM});
                            Matcher matcher = Pattern.compile(format).matcher(str2);
                            if (matcher.find()) {
                                String group = matcher.group(2);
                                if (group != null && group.length() > 0) {
                                    str2 = str2.replaceAll(format + String.format("((>[\\s\\S]*</%s>)|(/([^>]*)>))", new Object[]{group}), String.format("<$1>%s</%s>", new Object[]{com_tencent_mm_protocal_c_bjc.value, group}));
                                    str5 = str4 + com_tencent_mm_protocal_c_bjc.aAM + ":" + com_tencent_mm_protocal_c_bjc.value + ";";
                                    str4 = str2;
                                    str2 = str4;
                                    str4 = str5;
                                }
                            }
                        }
                        str5 = str4;
                        str4 = str2;
                        str2 = str4;
                        str4 = str5;
                    } catch (Exception e) {
                    }
                }
                x.i("MicroMsg.AdSnsInfoStorageLogic", "DynamicData is: [%s]", new Object[]{str4});
                if (bi.y(str, "ADInfo") == null) {
                    x.w("MicroMsg.AdSnsInfoStorageLogic", "DynamicData xml format error!");
                    return str;
                }
            }
            str2 = str;
        } catch (Exception e2) {
            str2 = str;
            x.w("MicroMsg.AdSnsInfoStorageLogic", "replace error occurs!");
            return str2;
        }
        return str2;
    }
}
