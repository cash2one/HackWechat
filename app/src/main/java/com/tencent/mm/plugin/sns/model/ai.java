package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.mm.a.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.a;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.aji;
import com.tencent.mm.protocal.c.aox;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.aqs;
import com.tencent.mm.protocal.c.aqu;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bje;
import com.tencent.mm.protocal.c.bjf;
import com.tencent.mm.protocal.c.bjk;
import com.tencent.mm.protocal.c.bjr;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.bkd;
import com.tencent.mm.protocal.c.bkk;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.protocal.c.cf;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ai {
    private static Map<String, bjv> qWY = new ConcurrentHashMap();

    public static List<m> a(String str, boolean z, String str2, boolean z2) {
        Cursor a;
        if (z2) {
            a = ae.bvv().a(false, str, 10, z, str2);
        } else {
            a = ae.bvv().a(false, str, 0, z, str2);
        }
        List<m> arrayList = new ArrayList();
        if (a.getCount() == 0) {
            a.close();
            return arrayList;
        }
        if (a.moveToFirst()) {
            do {
                m mVar = new m();
                mVar.b(a);
                arrayList.add(mVar);
            } while (a.moveToNext());
        }
        a.close();
        return arrayList;
    }

    public static m Kl(String str) {
        Cursor a = ae.bvv().a(true, str, 1, false, "");
        if (a.getCount() == 0) {
            a.close();
            return null;
        }
        a.moveToFirst();
        m mVar = new m();
        mVar.b(a);
        if (a.isClosed()) {
            return mVar;
        }
        a.close();
        return mVar;
    }

    public static void bvO() {
        if (qWY != null) {
            qWY.clear();
        }
    }

    public static bjv m(m mVar) {
        try {
            bjv c = ae.bvu().c((bjv) new bjv().aF(mVar.field_attrBuf));
            qWY.clear();
            return c;
        } catch (Throwable e) {
            x.e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
            x.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
            return new bjv();
        }
    }

    public static bjv n(m mVar) {
        try {
            bjv com_tencent_mm_protocal_c_bjv;
            if (mVar.roI == null) {
                mVar.roI = g.s(mVar.field_content) + g.s(mVar.field_attrBuf);
            }
            if (qWY.containsKey(mVar.roI)) {
                com_tencent_mm_protocal_c_bjv = (bjv) qWY.get(mVar.roI);
                if (com_tencent_mm_protocal_c_bjv != null) {
                    ae.bvu().c(com_tencent_mm_protocal_c_bjv);
                    return com_tencent_mm_protocal_c_bjv;
                }
            }
            com_tencent_mm_protocal_c_bjv = (bjv) new bjv().aF(mVar.field_attrBuf);
            qWY.put(mVar.roI, com_tencent_mm_protocal_c_bjv);
            ae.bvu().c(com_tencent_mm_protocal_c_bjv);
            return com_tencent_mm_protocal_c_bjv;
        } catch (Throwable e) {
            x.e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
            x.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
            return new bjv();
        }
    }

    public static void b(long j, bjf com_tencent_mm_protocal_c_bjf) {
        bje com_tencent_mm_protocal_c_bje = com_tencent_mm_protocal_c_bjf.wMD;
        if (com_tencent_mm_protocal_c_bje.ktN == 9) {
            m eR = ae.bvv().eR(j);
            if (eR != null) {
                try {
                    bjv com_tencent_mm_protocal_c_bjv = (bjv) new bjv().aF(eR.field_attrBuf);
                    com_tencent_mm_protocal_c_bjv.vPO = j;
                    Iterator it = com_tencent_mm_protocal_c_bjv.wNd.iterator();
                    while (it.hasNext()) {
                        bjk com_tencent_mm_protocal_c_bjk = (bjk) it.next();
                        if (com_tencent_mm_protocal_c_bjk.wMw == com_tencent_mm_protocal_c_bje.wMw && !bh.ov(com_tencent_mm_protocal_c_bjk.vIy) && com_tencent_mm_protocal_c_bjk.vIy.equals(com_tencent_mm_protocal_c_bje.wFM)) {
                            com_tencent_mm_protocal_c_bjv.wNd.remove(com_tencent_mm_protocal_c_bjk);
                            break;
                        }
                    }
                    eR.aJ(com_tencent_mm_protocal_c_bjv.toByteArray());
                    ae.bvv().a(com_tencent_mm_protocal_c_bjv.vPO, eR);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
                }
            }
        }
    }

    public static void c(long j, bjf com_tencent_mm_protocal_c_bjf) {
        bje com_tencent_mm_protocal_c_bje = com_tencent_mm_protocal_c_bjf.wMD;
        if (com_tencent_mm_protocal_c_bje.ktN == 13) {
            m eR = ae.bvv().eR(j);
            if (eR != null) {
                try {
                    bjv com_tencent_mm_protocal_c_bjv = (bjv) new bjv().aF(eR.field_attrBuf);
                    com_tencent_mm_protocal_c_bjv.vPO = j;
                    if (com_tencent_mm_protocal_c_bjv.wNo == null) {
                        com_tencent_mm_protocal_c_bjv.wNo = new bkk();
                    }
                    if (com_tencent_mm_protocal_c_bje.ktN == 13) {
                        Iterator it = com_tencent_mm_protocal_c_bjv.wNo.wNR.iterator();
                        while (it.hasNext()) {
                            if (((bjr) it.next()).vIy.equals(com_tencent_mm_protocal_c_bje.wFM)) {
                                return;
                            }
                        }
                        bjr com_tencent_mm_protocal_c_bjr = new bjr();
                        com_tencent_mm_protocal_c_bjr.wMA = com_tencent_mm_protocal_c_bje.wMA;
                        com_tencent_mm_protocal_c_bjr.pbl = com_tencent_mm_protocal_c_bje.pbl;
                        com_tencent_mm_protocal_c_bjr.vIy = com_tencent_mm_protocal_c_bje.wFM;
                        com_tencent_mm_protocal_c_bjv.wNo.wNR.add(com_tencent_mm_protocal_c_bjr);
                        com_tencent_mm_protocal_c_bjv.wNo.wNQ = com_tencent_mm_protocal_c_bjv.wNo.wNR.size();
                    }
                    eR.aJ(com_tencent_mm_protocal_c_bjv.toByteArray());
                    ae.bvv().a(com_tencent_mm_protocal_c_bjv.vPO, eR);
                } catch (Throwable e) {
                    x.e("MicroMsg.SnsInfoStorageLogic", "error for update hbaction " + e.getMessage());
                    x.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
                }
            }
        }
    }

    public static boolean a(long j, bjf com_tencent_mm_protocal_c_bjf) {
        bje com_tencent_mm_protocal_c_bje = com_tencent_mm_protocal_c_bjf.wMD;
        if (com_tencent_mm_protocal_c_bje.ktN != 1 && com_tencent_mm_protocal_c_bje.ktN != 2) {
            return true;
        }
        m eR = ae.bvv().eR(j);
        if (eR == null) {
            return true;
        }
        if (eR.field_type != 21 || com.tencent.mm.plugin.sns.lucky.a.g.bup()) {
            try {
                bjv com_tencent_mm_protocal_c_bjv = (bjv) new bjv().aF(eR.field_attrBuf);
                com_tencent_mm_protocal_c_bjv.vPO = j;
                Iterator it;
                bjk com_tencent_mm_protocal_c_bjk;
                if (com_tencent_mm_protocal_c_bje.ktN == 1) {
                    it = com_tencent_mm_protocal_c_bjv.wNa.iterator();
                    while (it.hasNext()) {
                        com_tencent_mm_protocal_c_bjk = (bjk) it.next();
                        if (com_tencent_mm_protocal_c_bjk.pbl == com_tencent_mm_protocal_c_bje.pbl && com_tencent_mm_protocal_c_bjk.vIy.equals(com_tencent_mm_protocal_c_bje.wFM)) {
                            return true;
                        }
                    }
                    com_tencent_mm_protocal_c_bjv.wNa.add(ac.a(com_tencent_mm_protocal_c_bjf));
                } else if (com_tencent_mm_protocal_c_bje.ktN == 2) {
                    it = com_tencent_mm_protocal_c_bjv.wNd.iterator();
                    while (it.hasNext()) {
                        com_tencent_mm_protocal_c_bjk = (bjk) it.next();
                        if (com_tencent_mm_protocal_c_bjk.pbl == com_tencent_mm_protocal_c_bje.pbl && com_tencent_mm_protocal_c_bjk.vIy.equals(com_tencent_mm_protocal_c_bje.wFM)) {
                            return true;
                        }
                    }
                    com_tencent_mm_protocal_c_bjv.wNd.add(ac.a(com_tencent_mm_protocal_c_bjf));
                }
                eR.aJ(com_tencent_mm_protocal_c_bjv.toByteArray());
                ae.bvv().a(com_tencent_mm_protocal_c_bjv.vPO, eR);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
            }
            return true;
        }
        x.i("MicroMsg.SnsInfoStorageLogic", "passed because close lucky");
        return false;
    }

    public static long d(bjv com_tencent_mm_protocal_c_bjv) {
        String str = "";
        m eR = ae.bvv().eR(com_tencent_mm_protocal_c_bjv.vPO);
        if (eR == null) {
            eR = new m();
        }
        return a(eR, com_tencent_mm_protocal_c_bjv, str, 0);
    }

    private static long a(m mVar, bjv com_tencent_mm_protocal_c_bjv, String str, int i) {
        int i2 = 1;
        if (mVar == null) {
            mVar = new m();
        }
        if (!ae.bvu().eC(mVar.field_snsId)) {
            return com_tencent_mm_protocal_c_bjv.vPO;
        }
        if (com_tencent_mm_protocal_c_bjv.wNh != 0) {
            x.i("MicroMsg.SnsInfoStorageLogic", "hit the filter id:" + com_tencent_mm_protocal_c_bjv.vPO + "  " + i.eq(com_tencent_mm_protocal_c_bjv.vPO));
            if (mVar.xl(i)) {
                i2 = 0;
            } else {
                mVar.xj(i);
            }
            if (i2 != 0) {
                ae.bvv().a(com_tencent_mm_protocal_c_bjv.vPO, mVar);
            }
            return com_tencent_mm_protocal_c_bjv.vPO;
        }
        LinkedList linkedList = com_tencent_mm_protocal_c_bjv.wNd;
        x.i("MicroMsg.SnsInfoStorageLogic", "hasChange id:  %s listSize %s Stringid %s", new Object[]{Long.valueOf(com_tencent_mm_protocal_c_bjv.vPO), Integer.valueOf(linkedList.size()), i.eq(com_tencent_mm_protocal_c_bjv.vPO)});
        if (com_tencent_mm_protocal_c_bjv.wMW == null || com_tencent_mm_protocal_c_bjv.wMW.wJD == null) {
            x.i("MicroMsg.SnsInfoStorageLogic", "object desc is null");
            return com_tencent_mm_protocal_c_bjv.vPO;
        }
        String str2 = new String(com_tencent_mm_protocal_c_bjv.wMW.wJD.toByteArray());
        x.d("MicroMsg.SnsInfoStorageLogic", "from server %d ", new Object[]{Long.valueOf(com_tencent_mm_protocal_c_bjv.vPO)});
        if (bh.ov(str2)) {
            return com_tencent_mm_protocal_c_bjv.vPO;
        }
        if (!mVar.Lk(str2)) {
            return com_tencent_mm_protocal_c_bjv.vPO;
        }
        int i3;
        com_tencent_mm_protocal_c_bjv.wNn = b(com_tencent_mm_protocal_c_bjv.wNn, mVar.field_attrBuf);
        x.d("MicroMsg.SnsInfoStorageLogic", "from server xml ok %d", new Object[]{Long.valueOf(com_tencent_mm_protocal_c_bjv.vPO)});
        com_tencent_mm_protocal_c_bjv.wMW.bj(new byte[0]);
        mVar.field_userName = com_tencent_mm_protocal_c_bjv.vIy;
        mVar.hK(com_tencent_mm_protocal_c_bjv.pbl);
        mVar.field_likeFlag = com_tencent_mm_protocal_c_bjv.wMX;
        mVar.eN(com_tencent_mm_protocal_c_bjv.vPO);
        mVar.eP(com_tencent_mm_protocal_c_bjv.vPO);
        mVar.xj(i);
        try {
            long Wq = bh.Wq();
            try {
                if (mVar.field_type == 15) {
                    bjv com_tencent_mm_protocal_c_bjv2 = (bjv) new bjv().aF(mVar.field_attrBuf);
                    if (!(com_tencent_mm_protocal_c_bjv2 == null || com_tencent_mm_protocal_c_bjv2.wNp == null || com_tencent_mm_protocal_c_bjv2.wNp.wEL <= 0)) {
                        com_tencent_mm_protocal_c_bjv.wNp = com_tencent_mm_protocal_c_bjv2.wNp;
                        x.i("MicroMsg.SnsInfoStorageLogic", "mergePreloadInfo predownload info [%d %d %s] cost[%d]", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bjv.wNp.wEL), Integer.valueOf(com_tencent_mm_protocal_c_bjv.wNp.wEM), com_tencent_mm_protocal_c_bjv.wNp.wEN, Long.valueOf(bh.bA(Wq))});
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.SnsInfoStorageLogic", "mergePreloadInfo error %s", new Object[]{e.toString()});
            }
            mVar.aJ(com_tencent_mm_protocal_c_bjv.toByteArray());
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e2, "", new Object[0]);
        }
        bnp bxV = mVar.bxV();
        bxV.ksU = com_tencent_mm_protocal_c_bjv.vIy;
        int i4 = bxV.wxG;
        mVar.field_pravited = i4;
        x.i("MicroMsg.SnsInfoStorageLogic", "ext flag %s  extflag %s", new Object[]{Long.valueOf(com_tencent_mm_protocal_c_bjv.vPO), Integer.valueOf(com_tencent_mm_protocal_c_bjv.wzw)});
        if ((com_tencent_mm_protocal_c_bjv.wzw & 1) > 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            mVar.byn();
        } else {
            mVar.byo();
        }
        if (i4 != 1 || i == 4) {
            if (i4 == 1 || (!str.equals(com_tencent_mm_protocal_c_bjv.vIy) && i == 4)) {
                mVar.byk();
            }
            mVar.c(bxV);
            mVar.field_type = bxV.wQo.vYc;
            mVar.field_subType = bxV.wQo.vYe;
            ae.bvv().a(com_tencent_mm_protocal_c_bjv.vPO, mVar);
            return com_tencent_mm_protocal_c_bjv.vPO;
        }
        x.e("MicroMsg.SnsInfoStorageLogic", "svr error push me the private pic in timelnie or others");
        return 0;
    }

    public static bdn b(bdn com_tencent_mm_protocal_c_bdn, byte[] bArr) {
        if (bArr != null) {
            try {
                bdn com_tencent_mm_protocal_c_bdn2 = ((bjv) new bjv().aF(bArr)).wNn;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
                return null;
            }
        }
        com_tencent_mm_protocal_c_bdn2 = null;
        if (com_tencent_mm_protocal_c_bdn == null) {
            return com_tencent_mm_protocal_c_bdn2;
        }
        bkd com_tencent_mm_protocal_c_bkd = new bkd();
        if (com_tencent_mm_protocal_c_bdn2 != null) {
            com_tencent_mm_protocal_c_bkd = (bkd) com_tencent_mm_protocal_c_bkd.aF(com_tencent_mm_protocal_c_bdn2.wJD.oz);
        }
        bkd com_tencent_mm_protocal_c_bkd2 = (bkd) new bkd().aF(com_tencent_mm_protocal_c_bdn.wJD.oz);
        if (com_tencent_mm_protocal_c_bkd2.wNC == null) {
            com_tencent_mm_protocal_c_bkd2.wNC = com_tencent_mm_protocal_c_bkd.wNC;
        }
        if (com_tencent_mm_protocal_c_bkd.wNB == null) {
            com_tencent_mm_protocal_c_bkd2.wNB = null;
        } else if (com_tencent_mm_protocal_c_bkd2.wNB == null) {
            com_tencent_mm_protocal_c_bkd2.wNB = com_tencent_mm_protocal_c_bkd.wNB;
        }
        return new bdn().bj(com_tencent_mm_protocal_c_bkd2.toByteArray());
    }

    private static String bK(List<String> list) {
        String str = "";
        for (String str2 : list) {
            if (str.length() == 0) {
                str = str2;
            } else {
                str = str + "," + str2;
            }
        }
        return str;
    }

    public static void a(String str, int i, LinkedList<bjv> linkedList, String str2) {
        if (linkedList != null && !linkedList.isEmpty()) {
            String str3;
            String str4;
            Cursor rawQuery;
            n bvv = ae.bvv();
            List arrayList = new ArrayList();
            List linkedList2 = new LinkedList();
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                bjv com_tencent_mm_protocal_c_bjv = (bjv) linkedList.get(i2);
                m eR = bvv.eR(com_tencent_mm_protocal_c_bjv.vPO);
                if (eR == null) {
                    eR = new m();
                }
                if (a(eR, com_tencent_mm_protocal_c_bjv, str, i) != 0) {
                    if (linkedList2.size() < 3 && (eR.field_type == 1 || eR.field_type == 15)) {
                        linkedList2.add(i.eq(eR.field_snsId));
                    }
                    arrayList.add(Long.valueOf(com_tencent_mm_protocal_c_bjv.vPO));
                }
            }
            if ((i == 4 || i == 8) && str2.equals("")) {
                k Lq = ae.bvz().Lq(str);
                List F = bh.F(bh.az(Lq != null ? Lq.field_newerIds : "", "").split(","));
                x.d("MicroMsg.SnsInfoStorageLogic", "newerIds " + bK(linkedList2));
                while (linkedList2.size() < 3 && F.size() > 0) {
                    str3 = (String) F.remove(0);
                    if (str3 != null) {
                        int i3 = 0;
                        while (i3 < linkedList2.size()) {
                            str4 = (String) linkedList2.get(i3);
                            if (str3.compareTo(str4) == 0) {
                                break;
                            } else if (str3.compareTo(str4) > 0) {
                                linkedList2.add(0, str3);
                                break;
                            } else {
                                i3++;
                            }
                        }
                        if (!linkedList2.contains(str3)) {
                            linkedList2.add(str3);
                        }
                    }
                }
                x.i("MicroMsg.SnsInfoStorageLogic", "merge newerIds " + bK(linkedList2));
                ae.bvz().em(str, bK(linkedList2));
            }
            str3 = i.JN(i.eq(((bjv) linkedList.getLast()).vPO));
            x.d("MicroMsg.SnsInfoStorageLogic", "FIlTER SEQ :: " + str2 + "  -  " + str3);
            n bvv2;
            if (i == 2) {
                bvv2 = ae.bvv();
                str4 = n.byI();
                if (str2 == null || !str2.equals("")) {
                    str4 = str4 + " AND " + bvv2.Ly(str2);
                }
                if (n.Lu(str3)) {
                    str4 = str4 + " AND " + bvv2.Lv(str3);
                }
                x.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq " + str4);
                rawQuery = bvv2.gJP.rawQuery(str4, null);
            } else {
                bvv2 = ae.bvv();
                str4 = n.d(true, str, i == 4);
                if (n.Lu(str2)) {
                    str4 = str4 + " AND " + bvv2.Ly(str2);
                }
                if (n.Lu(str3)) {
                    str4 = str4 + " AND " + bvv2.Lv(str3);
                }
                x.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq " + str4);
                rawQuery = bvv2.gJP.rawQuery(str4, null);
            }
            if (rawQuery == null) {
                return;
            }
            if (rawQuery.moveToFirst()) {
                do {
                    m mVar = new m();
                    mVar.b(rawQuery);
                    long j = mVar.field_snsId;
                    if (mVar.byr()) {
                        x.d("MicroMsg.SnsInfoStorageLogic", "uploading one ");
                    } else if (mVar.bys()) {
                        x.d("MicroMsg.SnsInfoStorageLogic", "die one ");
                    } else if (!arrayList.contains(Long.valueOf(j))) {
                        mVar.xm(i);
                        ae.bvv().b(j, mVar);
                        x.i("MicroMsg.SnsInfoStorageLogic", "removeSourceFlag sns Id " + j + " source " + i);
                    }
                } while (rawQuery.moveToNext());
                rawQuery.close();
                return;
            }
            rawQuery.close();
        }
    }

    public static boolean J(int i, boolean z) {
        if (!z || i <= 0) {
            return false;
        }
        return true;
    }

    public static boolean wH(int i) {
        aqs com_tencent_mm_protocal_c_aqs;
        Throwable th;
        int i2;
        q eS;
        aqu com_tencent_mm_protocal_c_aqu;
        x.d("MicroMsg.SnsInfoStorageLogic", "retryPostItem localId　" + i);
        m xo = ae.bvv().xo(i);
        if (xo == null) {
            return false;
        }
        int i3;
        xo.byt();
        xo.hK((int) (System.currentTimeMillis() / 1000));
        aqs com_tencent_mm_protocal_c_aqs2 = null;
        try {
            aqs com_tencent_mm_protocal_c_aqs3 = (aqs) new aqs().aF(xo.field_postBuf);
            try {
                com_tencent_mm_protocal_c_aqs3.hkU = 0;
                com_tencent_mm_protocal_c_aqs3.wyf = System.currentTimeMillis();
                xo.field_postBuf = com_tencent_mm_protocal_c_aqs3.toByteArray();
                com_tencent_mm_protocal_c_aqs = com_tencent_mm_protocal_c_aqs3;
            } catch (Throwable e) {
                Throwable th2 = e;
                com_tencent_mm_protocal_c_aqs2 = com_tencent_mm_protocal_c_aqs3;
                th = th2;
                x.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", th, "", new Object[0]);
                com_tencent_mm_protocal_c_aqs = com_tencent_mm_protocal_c_aqs2;
                if (com_tencent_mm_protocal_c_aqs != null) {
                    return false;
                }
                ae.bvv().b(i, xo);
                for (i2 = 0; i2 < com_tencent_mm_protocal_c_aqs.wyc.size(); i2++) {
                    i3 = ((aox) com_tencent_mm_protocal_c_aqs.wyc.get(i2)).wvG;
                    eS = ae.bvk().eS((long) i3);
                    if (eS == null) {
                        eS.offset = 0;
                        try {
                            com_tencent_mm_protocal_c_aqu = (aqu) new aqu().aF(eS.rpt);
                            if (com_tencent_mm_protocal_c_aqu.wyA == 0) {
                                com_tencent_mm_protocal_c_aqu.wyA = 2;
                                com_tencent_mm_protocal_c_aqu.wyB = "";
                                eS.rpt = com_tencent_mm_protocal_c_aqu.toByteArray();
                                ae.bvk().a(i3, eS);
                            } else {
                                continue;
                            }
                        } catch (Exception e2) {
                            x.e("MicroMsg.SnsInfoStorageLogic", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
                            return false;
                        }
                    }
                }
                return true;
            }
        } catch (Exception e3) {
            th = e3;
            x.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", th, "", new Object[0]);
            com_tencent_mm_protocal_c_aqs = com_tencent_mm_protocal_c_aqs2;
            if (com_tencent_mm_protocal_c_aqs != null) {
                return false;
            }
            ae.bvv().b(i, xo);
            for (i2 = 0; i2 < com_tencent_mm_protocal_c_aqs.wyc.size(); i2++) {
                i3 = ((aox) com_tencent_mm_protocal_c_aqs.wyc.get(i2)).wvG;
                eS = ae.bvk().eS((long) i3);
                if (eS == null) {
                    eS.offset = 0;
                    com_tencent_mm_protocal_c_aqu = (aqu) new aqu().aF(eS.rpt);
                    if (com_tencent_mm_protocal_c_aqu.wyA == 0) {
                        continue;
                    } else {
                        com_tencent_mm_protocal_c_aqu.wyA = 2;
                        com_tencent_mm_protocal_c_aqu.wyB = "";
                        eS.rpt = com_tencent_mm_protocal_c_aqu.toByteArray();
                        ae.bvk().a(i3, eS);
                    }
                }
            }
            return true;
        }
        if (com_tencent_mm_protocal_c_aqs != null) {
            return false;
        }
        ae.bvv().b(i, xo);
        for (i2 = 0; i2 < com_tencent_mm_protocal_c_aqs.wyc.size(); i2++) {
            i3 = ((aox) com_tencent_mm_protocal_c_aqs.wyc.get(i2)).wvG;
            eS = ae.bvk().eS((long) i3);
            if (eS == null) {
                eS.offset = 0;
                com_tencent_mm_protocal_c_aqu = (aqu) new aqu().aF(eS.rpt);
                if (com_tencent_mm_protocal_c_aqu.wyA == 0) {
                    continue;
                } else {
                    com_tencent_mm_protocal_c_aqu.wyA = 2;
                    com_tencent_mm_protocal_c_aqu.wyB = "";
                    eS.rpt = com_tencent_mm_protocal_c_aqu.toByteArray();
                    ae.bvk().a(i3, eS);
                }
            }
        }
        return true;
    }

    public static boolean Km(String str) {
        return com.tencent.mm.z.q.FS().equals(str.trim());
    }

    public static List<m> bvP() {
        List arrayList = new ArrayList();
        n bvv = ae.bvv();
        Cursor rawQuery = bvv.gJP.rawQuery(n.byJ() + " AND " + n.rpf + " AND  (snsId = 0  ) ", null);
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
        } else {
            rawQuery.moveToFirst();
            do {
                m mVar = new m();
                mVar.b(rawQuery);
                arrayList.add(mVar);
            } while (rawQuery.moveToNext());
            rawQuery.close();
        }
        return arrayList;
    }

    public static String Kn(String str) {
        int i = 1;
        List linkedList = new LinkedList();
        Cursor cursor = ae.bvB().getCursor();
        if (cursor.moveToFirst()) {
            do {
                s sVar = new s();
                sVar.b(cursor);
                linkedList.add(bh.az(sVar.field_tagName, ""));
            } while (cursor.moveToNext());
        }
        cursor.close();
        String str2 = str;
        while (linkedList.contains(str2)) {
            StringBuilder append = new StringBuilder().append(str);
            int i2 = i + 1;
            str2 = append.append(i).toString();
            i = i2;
        }
        return str2;
    }

    public static m wI(int i) {
        m mVar = new m();
        n bvv = ae.bvv();
        x.i("MicroMsg.SnsInfoStorage", "getTimelineByCreateTime sql %s", new Object[]{((n.byK() + " and createTime < " + i) + n.roZ) + " LIMIT 1"});
        Cursor rawQuery = bvv.gJP.rawQuery(r3, null);
        if (rawQuery == null) {
            rawQuery = null;
        }
        if (rawQuery == null) {
            return null;
        }
        if (rawQuery.moveToFirst()) {
            mVar.b(rawQuery);
            rawQuery.close();
            return mVar;
        }
        rawQuery.close();
        return null;
    }

    public static List<b> ea(String str, String str2) {
        int i = 0;
        List<b> arrayList = new ArrayList();
        cf cfVar = null;
        try {
            String str3 = str2 + str + "_ARTISTF.mm";
            String str4 = str2 + str + "_ARTIST.mm";
            if (FileOp.bO(str3)) {
                cfVar = (cf) new cf().aF(FileOp.d(str3, 0, (int) FileOp.me(str3)));
            }
            if (cfVar == null) {
                FileOp.deleteFile(str3);
                cfVar = a.KQ(new String(FileOp.d(str4, 0, (int) FileOp.me(str4))));
                FileOp.b(str3, cfVar.toByteArray(), -1);
            }
            Iterator it = cfVar.vHz.iterator();
            while (it.hasNext()) {
                aji com_tencent_mm_protocal_c_aji = (aji) it.next();
                str4 = com_tencent_mm_protocal_c_aji.nfp;
                Iterator it2 = com_tencent_mm_protocal_c_aji.vYd.iterator();
                while (it2.hasNext()) {
                    aqr com_tencent_mm_protocal_c_aqr = (aqr) it2.next();
                    com_tencent_mm_protocal_c_aqr.nfe = str4;
                    b bVar = new b();
                    bVar.fHC = com_tencent_mm_protocal_c_aqr;
                    bVar.raG = "";
                    int i2 = i + 1;
                    bVar.raH = i;
                    arrayList.add(bVar);
                    i = i2;
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.SnsInfoStorageLogic", "error initDataArtist");
        }
        return arrayList;
    }

    public static aqr a(m mVar, int i) {
        if (ae.bve() || mVar == null) {
            return null;
        }
        bnp bxV = mVar.bxV();
        if (bxV.wQo == null || bxV.wQo.vYd.size() == 0 || bxV.wQo.vYd.size() <= i) {
            return null;
        }
        return (aqr) bxV.wQo.vYd.get(i);
    }

    public static aqr a(m mVar, String str) {
        bnp bxV = mVar.bxV();
        if (bxV.wQo == null || bxV.wQo.vYd.size() == 0) {
            return null;
        }
        Iterator it = bxV.wQo.vYd.iterator();
        while (it.hasNext()) {
            aqr com_tencent_mm_protocal_c_aqr = (aqr) it.next();
            if (com_tencent_mm_protocal_c_aqr.nGJ.equals(str)) {
                return com_tencent_mm_protocal_c_aqr;
            }
        }
        return null;
    }

    public static List<b> Ko(String str) {
        List<b> arrayList = new ArrayList();
        if (ae.bve()) {
            return arrayList;
        }
        m Lm = h.Lm(str);
        if (Lm == null) {
            return arrayList;
        }
        bnp bxV = Lm.bxV();
        if (bxV.wQo == null || bxV.wQo.vYd.size() == 0) {
            return arrayList;
        }
        arrayList.clear();
        Iterator it = bxV.wQo.vYd.iterator();
        int i = 0;
        while (it.hasNext()) {
            aqr com_tencent_mm_protocal_c_aqr = (aqr) it.next();
            b bVar = new b();
            bVar.fHC = com_tencent_mm_protocal_c_aqr;
            bVar.raG = str;
            bVar.hzW = bxV.pbl;
            int i2 = i + 1;
            bVar.raH = i;
            arrayList.add(bVar);
            i = i2;
        }
        return arrayList;
    }

    public static List<b> bL(List<String> list) {
        List<b> arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        arrayList.clear();
        int i = 0;
        for (String str : list) {
            b bVar = new b();
            aqr com_tencent_mm_protocal_c_aqr = new aqr();
            com_tencent_mm_protocal_c_aqr.nGJ = "pre_temp_extend_pic" + str;
            bVar.fHC = com_tencent_mm_protocal_c_aqr;
            bVar.raG = "";
            int i2 = i + 1;
            bVar.raH = i;
            arrayList.add(bVar);
            i = i2;
        }
        return arrayList;
    }

    public static void wJ(int i) {
        x.d("MicroMsg.SnsInfoStorageLogic", "unsetOmitResendFlag localId　" + i);
        m xo = ae.bvv().xo(i);
        if (xo != null) {
            if (((xo.field_localFlag & 64) > 0 ? 1 : null) != null) {
                xo.field_localFlag &= -65;
            }
            ae.bvv().b(i, xo);
        }
    }

    public static void bvQ() {
        Cursor cg = ae.bvv().cg("", 0);
        if (cg != null) {
            x.i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId begin");
            while (cg.moveToNext()) {
                m mVar = new m();
                mVar.b(cg);
                x.i("MicroMsg.SnsInfoStorageLogic", mVar.bxW());
            }
            x.i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId end");
            cg.close();
        }
    }
}
