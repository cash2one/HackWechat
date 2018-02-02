package com.tencent.mm.plugin.card.sharecard.a;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.s;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.plugin.card.sharecard.model.i;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.plugin.card.sharecard.model.m;
import com.tencent.mm.plugin.card.sharecard.model.p;
import com.tencent.mm.plugin.card.sharecard.ui.b.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class b {
    private static boolean hjs = false;
    public static boolean kMY = false;
    public a kMX = null;
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
        kMY = false;
    }

    public final void init() {
        if (((l) am.auF().getValue("key_share_card_layout_data")) == null) {
            x.e("MicroMsg.ShareCardDataMgr", "initShareCardLayoutData, data cache is empty!, load data from db!");
            Object axi = com.tencent.mm.plugin.card.b.l.axi();
            if (TextUtils.isEmpty(axi)) {
                x.e("MicroMsg.ShareCardDataMgr", "initShareCardLayoutData, json is empty");
                return;
            }
            l wY = s.wY(axi);
            if (wY != null) {
                x.i("MicroMsg.ShareCardDataMgr", "load share card layout data success!");
                am.auF().putValue("key_share_card_layout_data", wY);
                a(wY, true);
                return;
            }
            x.e("MicroMsg.ShareCardDataMgr", "load share card layout data fail!");
            return;
        }
        x.i("MicroMsg.ShareCardDataMgr", "the share card layout cache is valid!");
    }

    public static int auS() {
        int i = 0;
        c auA = am.auA();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where (status=0 OR ").append("status=5) AND ").append("card_type=10");
        Cursor a = auA.gJP.a("select count(*) from UserCardInfo" + stringBuilder.toString(), null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        return i;
    }

    public final void aa(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.ShareCardDataMgr", "updateGetShareLayoutData json is empty");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        l wY = s.wY(str);
        l lVar = (l) am.auF().getValue("key_share_card_layout_data");
        if (wY == null) {
            x.e("MicroMsg.ShareCardDataMgr", "updateGetShareLayoutData data == null");
            a(wY, lVar, z);
            am.auF().putValue("key_share_card_layout_data", wY);
            return;
        }
        if (z) {
            com.tencent.mm.plugin.card.b.l.wQ(str);
        }
        a(wY, z);
        a(wY, lVar, z);
        am.auF().putValue("key_share_card_layout_data", wY);
        int i = 0;
        if (wY.kNm != null && wY.kNm.size() > 0) {
            i = wY.kNm.size();
        }
        if (wY.kNn != null && wY.kNn.size() > 0) {
            i += wY.kNn.size();
        }
        if (i > 0) {
            int currentTimeMillis2 = (int) (System.currentTimeMillis() - currentTimeMillis);
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(281);
            iDKey.SetKey(10);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(281);
            iDKey2.SetKey(11);
            iDKey2.SetValue((long) currentTimeMillis2);
            IDKey iDKey3 = new IDKey();
            iDKey3.SetID(281);
            iDKey3.SetKey(12);
            iDKey3.SetValue((long) i);
            IDKey iDKey4 = new IDKey();
            iDKey4.SetID(281);
            iDKey4.SetKey(14);
            iDKey4.SetValue((long) (currentTimeMillis2 / i));
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            arrayList.add(iDKey3);
            arrayList.add(iDKey4);
            g.pQN.a(arrayList, true);
        }
    }

    private void a(l lVar, boolean z) {
        int i = 0;
        if (lVar == null) {
            x.e("MicroMsg.ShareCardDataMgr", "don't parserShareCardListData, data is null");
            return;
        }
        Map hashMap;
        Map hashMap2;
        Map hashMap3;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        m mVar;
        x.i("MicroMsg.ShareCardDataMgr", "parserShareCardListData()");
        Map map = (Map) am.auF().getValue("key_share_card_annoucement_map");
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = map;
        }
        map = (Map) am.auF().getValue("key_share_card_count_map");
        if (map == null) {
            hashMap2 = new HashMap();
        } else {
            hashMap2 = map;
        }
        map = (Map) am.auF().getValue("key_share_card_username_map");
        if (map == null) {
            hashMap3 = new HashMap();
        } else {
            hashMap3 = map;
        }
        ArrayList arrayList4 = (ArrayList) am.auF().getValue("key_share_card_local_city_ids");
        if (arrayList4 == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = arrayList4;
        }
        arrayList4 = (ArrayList) am.auF().getValue("key_share_card_other_city_ids");
        if (arrayList4 == null) {
            arrayList2 = new ArrayList();
        } else {
            arrayList2 = arrayList4;
        }
        arrayList4 = (ArrayList) am.auF().getValue("key_share_card_other_city_top_info_list");
        if (arrayList4 == null) {
            arrayList3 = new ArrayList();
        } else {
            arrayList3 = arrayList4;
        }
        if (z) {
            arrayList.clear();
            arrayList2.clear();
            arrayList3.clear();
        }
        ArrayList arrayList5 = new ArrayList();
        if (lVar.kNm != null && lVar.kNm.size() > 0) {
            for (int i2 = 0; i2 < lVar.kNm.size(); i2++) {
                mVar = (m) lVar.kNm.get(i2);
                if (!TextUtils.isEmpty(mVar.kNu)) {
                    hashMap.put(mVar.kJN, mVar.kNu);
                }
                hashMap2.put(mVar.kJN, Integer.valueOf(am.auI().ws(mVar.kJN)));
                hashMap3.put(mVar.kJN, l(am.auI().wr(mVar.kJN)));
                if (!arrayList5.contains(mVar.kJN)) {
                    CharSequence wt = am.auI().wt(mVar.kJN);
                    if (!TextUtils.isEmpty(wt) && !arrayList.contains(wt)) {
                        arrayList.add(wt);
                    } else if (!arrayList.contains(mVar.fGU)) {
                        arrayList.add(mVar.fGU);
                    }
                    arrayList5.add(mVar.kJN);
                    p pVar = new p();
                    pVar.kJN = mVar.kJN;
                    pVar.top = mVar.top;
                    arrayList3.add(pVar);
                }
            }
        }
        arrayList5.clear();
        if (lVar.kNn != null && lVar.kNn.size() > 0) {
            while (i < lVar.kNn.size()) {
                mVar = (m) lVar.kNn.get(i);
                if (!TextUtils.isEmpty(mVar.kNu)) {
                    hashMap.put(mVar.kJN, mVar.kNu);
                }
                hashMap2.put(mVar.kJN, Integer.valueOf(am.auI().ws(mVar.kJN)));
                hashMap3.put(mVar.kJN, l(am.auI().wr(mVar.kJN)));
                if (!arrayList5.contains(mVar.kJN)) {
                    CharSequence wt2 = am.auI().wt(mVar.kJN);
                    if (!TextUtils.isEmpty(wt2) && !arrayList2.contains(wt2)) {
                        arrayList2.add(wt2);
                    } else if (!arrayList2.contains(mVar.fGU)) {
                        arrayList2.add(mVar.fGU);
                    }
                    arrayList5.add(mVar.kJN);
                    p pVar2 = new p();
                    pVar2.kJN = mVar.kJN;
                    pVar2.top = mVar.top;
                    arrayList3.add(pVar2);
                }
                i++;
            }
        }
        am.auF().putValue("key_share_card_annoucement_map", hashMap);
        am.auF().putValue("key_share_card_count_map", hashMap2);
        am.auF().putValue("key_share_card_username_map", hashMap3);
        am.auF().putValue("key_share_card_local_city", lVar.kNo);
        am.auF().putValue("key_share_card_local_city_ids", arrayList);
        am.auF().putValue("key_share_card_other_city_ids", arrayList2);
        am.auF().putValue("key_share_card_other_city_top_info_list", arrayList3);
    }

    private static void a(l lVar, l lVar2, boolean z) {
        if (lVar == null && lVar2 == null) {
            x.e("MicroMsg.ShareCardDataMgr", "don't updateCategoryType(), newData == null && oldData == null");
        } else if (lVar != null && lVar.kNn == null && lVar.kNm == null && lVar2 != null && lVar2.kNn == null && lVar2.kNm == null) {
            x.e("MicroMsg.ShareCardDataMgr", "don't updateCategoryType(), newData.local_city_list == null && oldData.local_city_list == null");
        } else {
            ArrayList arrayList;
            ArrayList arrayList2;
            int i;
            m mVar;
            x.i("MicroMsg.ShareCardDataMgr", "updateCategoryType()");
            ArrayList arrayList3 = (ArrayList) am.auF().getValue("key_share_card_local_city_category_info_list");
            if (arrayList3 == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = arrayList3;
            }
            arrayList3 = (ArrayList) am.auF().getValue("key_share_card_other_city_category_info_list");
            if (arrayList3 == null) {
                arrayList2 = new ArrayList();
            } else {
                arrayList2 = arrayList3;
            }
            int i2 = 0;
            if (z) {
                am.auI().nM(10);
                arrayList.clear();
                am.auI().nM(0);
                arrayList2.clear();
                i = 0;
                i2 = 0;
            } else {
                if (!(lVar2 == null || lVar2.kNm == null || lVar2.kNm.size() < 0)) {
                    i2 = lVar2.kNm.size();
                }
                if (lVar2 == null || lVar2.kNn == null || lVar2.kNn.size() < 0) {
                    i = i2;
                    i2 = 0;
                } else {
                    i = i2;
                    i2 = lVar2.kNn.size();
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            ar.Hg();
            long dz = com.tencent.mm.z.c.EV().dz(Thread.currentThread().getId());
            if (lVar != null && lVar.kNm != null && lVar.kNm.size() > 0) {
                for (int i3 = 0; i3 < lVar.kNm.size(); i3++) {
                    mVar = (m) lVar.kNm.get(i3);
                    am.auI().B(mVar.kJN, 10, i3 + i);
                    i iVar = new i();
                    iVar.kJN = mVar.kJN;
                    iVar.kNh = i3 + i;
                    arrayList.add(iVar);
                }
                if (!(z || lVar2 == null || lVar2.kNm == null)) {
                    lVar.kNm.addAll(lVar2.kNm);
                }
            } else if (!(lVar == null || z || lVar2 == null || lVar2.kNm == null)) {
                lVar.kNm = lVar2.kNm;
            }
            am.auF().putValue("key_share_card_local_city_category_info_list", arrayList);
            if (lVar != null && lVar.kNn != null && lVar.kNn.size() > 0) {
                for (int i4 = 0; i4 < lVar.kNn.size(); i4++) {
                    mVar = (m) lVar.kNn.get(i4);
                    am.auI().B(mVar.kJN, 0, i4 + i2);
                    i iVar2 = new i();
                    iVar2.kJN = mVar.kJN;
                    iVar2.kNh = i4 + i2;
                    arrayList2.add(iVar2);
                }
                if (!(z || lVar2 == null || lVar2.kNn == null)) {
                    lVar.kNn.addAll(lVar2.kNn);
                }
            } else if (!(lVar == null || z || lVar2 == null || lVar2.kNn == null)) {
                lVar.kNn = lVar2.kNn;
            }
            am.auF().putValue("key_share_card_other_city_category_info_list", arrayList2);
            ar.Hg();
            com.tencent.mm.z.c.EV().fS(dz);
            x.d("MicroMsg.ShareCardDataMgr", "updateCategoryType  >> updateCategoryInfo use time %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        }
    }

    public static void auT() {
        ArrayList arrayList;
        ArrayList arrayList2;
        long currentTimeMillis = System.currentTimeMillis();
        ar.Hg();
        long dz = com.tencent.mm.z.c.EV().dz(Thread.currentThread().getId());
        x.i("MicroMsg.ShareCardDataMgr", "updateShareCardCategory()");
        ArrayList arrayList3 = (ArrayList) am.auF().getValue("key_share_card_local_city_category_info_list");
        if (arrayList3 == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = arrayList3;
        }
        arrayList3 = (ArrayList) am.auF().getValue("key_share_card_other_city_category_info_list");
        if (arrayList3 == null) {
            arrayList2 = new ArrayList();
        } else {
            arrayList2 = arrayList3;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            i iVar = (i) arrayList.get(i);
            am.auI().B(iVar.kJN, 10, iVar.kNh);
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            iVar = (i) arrayList2.get(i2);
            am.auI().B(iVar.kJN, 0, iVar.kNh);
        }
        ar.Hg();
        com.tencent.mm.z.c.EV().fS(dz);
        x.i("MicroMsg.ShareCardDataMgr", "updateShareCardCategory  >> updateCategoryInfo use time %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    private String l(ArrayList<String> arrayList) {
        return a(this.mContext, (ArrayList) arrayList);
    }

    private static String a(Context context, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            x.e("MicroMsg.ShareCardDataMgr", "getShareUserName， username_list == null || username_list.size() == 0");
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < arrayList.size() && i < 2) {
            if (i != 0) {
                stringBuilder.append("、");
            }
            Object gv = r.gv((String) arrayList.get(i));
            String gu = r.gu((String) arrayList.get(i));
            if (TextUtils.isEmpty(gv)) {
                stringBuilder.append(gu);
            } else {
                stringBuilder.append(gv);
            }
            i++;
        }
        if (context == null) {
            x.e("MicroMsg.ShareCardDataMgr", "context == null");
            return "";
        } else if (arrayList.size() == 1 || arrayList.size() == 2) {
            return context.getString(R.l.dPq, new Object[]{stringBuilder.toString()});
        } else {
            return context.getString(R.l.dPc, new Object[]{stringBuilder.toString(), Integer.valueOf(arrayList.size())});
        }
    }

    public static void wl(String str) {
        x.i("MicroMsg.ShareCardDataMgr", "updateShareUserInfo()");
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.ShareCardDataMgr", "updateShareUserInfo(), card_tp_id is empty");
        } else {
            e.post(new 1(str, new af(Looper.getMainLooper())), "updateShareUserInfo_thread");
        }
    }

    public static ArrayList<String> nI(int i) {
        ArrayList<String> arrayList;
        if (i == 1) {
            arrayList = (ArrayList) am.auF().getValue("key_share_card_local_city_ids");
            if (arrayList != null && arrayList.size() != 0) {
                return arrayList;
            }
            x.e("MicroMsg.ShareCardDataMgr", "getCardIds() ids == null || ids.size() == 0 for showType == " + i);
            return nJ(i);
        } else if (i != 2) {
            return null;
        } else {
            arrayList = (ArrayList) am.auF().getValue("key_share_card_other_city_ids");
            if (arrayList != null && arrayList.size() != 0) {
                return arrayList;
            }
            x.e("MicroMsg.ShareCardDataMgr", "getCardIds() ids == null || ids.size() == 0 for showType == " + i);
            return nJ(i);
        }
    }

    private static ArrayList<String> nJ(int i) {
        l lVar = (l) am.auF().getValue("key_share_card_layout_data");
        if (lVar == null) {
            x.e("MicroMsg.ShareCardDataMgr", "getCardIdsByType() data == null for showType = " + i);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i2;
        m mVar;
        CharSequence wt;
        if (i == 1) {
            if (lVar.kNm != null && lVar.kNm.size() > 0) {
                for (i2 = 0; i2 < lVar.kNm.size(); i2++) {
                    mVar = (m) lVar.kNm.get(i2);
                    if (!arrayList2.contains(mVar.kJN)) {
                        wt = am.auI().wt(mVar.kJN);
                        if (!TextUtils.isEmpty(wt) && !arrayList.contains(wt)) {
                            arrayList.add(wt);
                        } else if (!arrayList.contains(mVar.fGU)) {
                            arrayList.add(mVar.fGU);
                        }
                        arrayList2.add(mVar.kJN);
                    }
                }
                am.auF().putValue("key_share_card_local_city_ids", arrayList);
            }
            return arrayList;
        } else if (i != 2) {
            return null;
        } else {
            if (lVar.kNn != null && lVar.kNn.size() > 0) {
                for (i2 = 0; i2 < lVar.kNn.size(); i2++) {
                    mVar = (m) lVar.kNn.get(i2);
                    if (!arrayList2.contains(mVar.kJN)) {
                        wt = am.auI().wt(mVar.kJN);
                        if (!TextUtils.isEmpty(wt) && !arrayList.contains(wt)) {
                            arrayList.add(wt);
                        } else if (!arrayList.contains(mVar.fGU)) {
                            arrayList.add(mVar.fGU);
                        }
                        arrayList2.add(mVar.kJN);
                    }
                }
                am.auF().putValue("key_share_card_other_city_ids", arrayList);
            }
            return arrayList;
        }
    }

    public static void bQ(String str, String str2) {
        if (hjs) {
            x.i("MicroMsg.ShareCardDataMgr", "is isUpdating data, don't do updateCardIdsListByCardId");
            return;
        }
        CharSequence bT;
        x.i("MicroMsg.ShareCardDataMgr", "do updateCardIdsListByCardId");
        hjs = true;
        ArrayList nI = nI(1);
        if (nI != null && nI.contains(str)) {
            nI.remove(str);
            bT = am.auI().bT(str, str2);
            if (!TextUtils.isEmpty(bT)) {
                nI.add(bT);
            }
            am.auF().putValue("key_share_card_local_city_ids", nI);
        }
        nI = nI(2);
        if (nI != null && nI.contains(str)) {
            nI.remove(str);
            bT = am.auI().bT(str, str2);
            if (!TextUtils.isEmpty(bT)) {
                nI.add(bT);
            }
            am.auF().putValue("key_share_card_other_city_ids", nI);
        }
        hjs = false;
    }

    public static void bR(String str, String str2) {
        x.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId card_id:" + str + ", card_tp_id:" + str2);
        ArrayList nI = nI(1);
        if (nI == null || !nI.contains(str)) {
            ArrayList nI2 = nI(2);
            if (nI2 == null || !nI2.contains(str)) {
                l lVar = (l) am.auF().getValue("key_share_card_layout_data");
                if (lVar == null) {
                    x.e("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId data == null");
                    return;
                }
                int ws = am.auI().ws(str2);
                int wn = wn(str2);
                x.e("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId realCount:" + ws + " cacheCount:" + wn);
                if (lVar.kNm == null || lVar.kNm.size() <= 0 || (wn > 0 && ws != 1)) {
                    x.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId, not add for local_ids");
                } else {
                    int i = 0;
                    while (i < lVar.kNm.size()) {
                        m mVar = (m) lVar.kNm.get(i);
                        if (str2 == null || !str2.contains(mVar.kJN)) {
                            i++;
                        } else {
                            nI.add(str);
                            am.auF().putValue("key_share_card_local_city_ids", nI);
                            x.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId add for local ids, card id is " + str);
                            return;
                        }
                    }
                }
                if (nI2 == null || (wn > 0 && ws != 1)) {
                    x.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId, not add for other_ids");
                    return;
                }
                nI2.add(str);
                am.auF().putValue("key_share_card_other_city_ids", nI2);
                x.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId add for other ids, card id is " + str);
            }
        }
    }

    public static int auU() {
        if (auW()) {
            return 1;
        }
        if (!auV()) {
            return 0;
        }
        if (kMY) {
            return 3;
        }
        return 4;
    }

    public static boolean auV() {
        ArrayList arrayList = (ArrayList) am.auF().getValue("key_share_card_other_city_ids");
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return true;
    }

    public static boolean auW() {
        ArrayList arrayList = (ArrayList) am.auF().getValue("key_share_card_local_city_ids");
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return true;
    }

    public static String wm(String str) {
        Map map = (Map) am.auF().getValue("key_share_card_annoucement_map");
        if (map == null) {
            return "";
        }
        return (String) map.get(str);
    }

    public static int wn(String str) {
        Map map = (Map) am.auF().getValue("key_share_card_count_map");
        if (map == null) {
            return 0;
        }
        Integer num = (Integer) map.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static String ko(String str) {
        Map map = (Map) am.auF().getValue("key_share_card_username_map");
        if (map == null) {
            return "";
        }
        return (String) map.get(str);
    }

    public static ArrayList<com.tencent.mm.plugin.card.sharecard.model.r> wo(String str) {
        Map map = (Map) am.auF().getValue("key_share_user_info_map");
        if (map == null) {
            map = new HashMap();
        }
        ArrayList<com.tencent.mm.plugin.card.sharecard.model.r> arrayList = (ArrayList) map.get(str);
        if (arrayList == null) {
            return new ArrayList();
        }
        return arrayList;
    }

    private static void E(String str, String str2, String str3) {
        Map hashMap;
        ArrayList arrayList;
        Map map = (Map) am.auF().getValue("key_share_user_info_map");
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = map;
        }
        ArrayList arrayList2 = (ArrayList) hashMap.get(str2);
        if (arrayList2 == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = arrayList2;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            com.tencent.mm.plugin.card.sharecard.model.r rVar = (com.tencent.mm.plugin.card.sharecard.model.r) arrayList.get(i);
            if (str3 != null && str3.equals(rVar.kNz)) {
                rVar.kNB = false;
                rVar.cNH--;
                rVar.kNA.remove(str);
                arrayList.set(i, rVar);
            }
        }
        hashMap.put(str2, arrayList);
        am.auF().putValue("key_share_user_info_map", hashMap);
    }

    public static void auX() {
        x.i("MicroMsg.ShareCardDataMgr", "delelteAllIllegalStatusCard()");
        e.post(new 2(), "delelteAllIllegalStatusCard");
    }

    public static void R(Context context, String str) {
        Map hashMap;
        x.i("MicroMsg.ShareCardDataMgr", "updateCardCountbyCardTpId() card_tp_id:" + str);
        Map map = (Map) am.auF().getValue("key_share_card_count_map");
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = map;
        }
        map = (Map) am.auF().getValue("key_share_card_username_map");
        if (map == null) {
            map = new HashMap();
        }
        hashMap.put(str, Integer.valueOf(am.auI().ws(str)));
        map.put(str, a(context, am.auI().wr(str)));
        am.auF().putValue("key_share_card_count_map", hashMap);
        am.auF().putValue("key_share_card_username_map", map);
    }

    public static boolean nK(int i) {
        Integer num = (Integer) am.auF().getValue("key_share_card_show_type");
        if (num == null) {
            return false;
        }
        if (num.intValue() == 0) {
            return false;
        }
        ArrayList arrayList;
        if (i == 0) {
            arrayList = (ArrayList) am.auF().getValue("key_share_card_other_city_ids");
            if (arrayList == null || arrayList.size() == 0) {
                return false;
            }
            return true;
        } else if (i != 10) {
            return false;
        } else {
            arrayList = (ArrayList) am.auF().getValue("key_share_card_local_city_ids");
            if (arrayList == null || arrayList.size() == 0) {
                return false;
            }
            return true;
        }
    }

    public static boolean wp(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ArrayList arrayList = (ArrayList) am.auF().getValue("key_share_card_other_city_top_info_list");
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            if (pVar != null && str.equals(pVar.kJN) && pVar.top == 1) {
                return true;
            }
        }
        return false;
    }

    public static void wq(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList;
            ArrayList arrayList2 = (ArrayList) am.auF().getValue("key_share_card_other_city_top_info_list");
            if (arrayList2 == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = arrayList2;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                p pVar = (p) arrayList.get(i);
                if (pVar != null && str.equals(pVar.kJN) && pVar.top == 1) {
                    pVar.kNy = true;
                    arrayList.set(i, pVar);
                    am.auF().putValue("key_share_card_other_city_top_info_list", arrayList);
                    return;
                }
            }
        }
    }

    public static String bS(String str, String str2) {
        x.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId()");
        if (str2 != null) {
            ArrayList wo = wo(str2);
            if (wo == null || wo.size() <= 0) {
                x.e("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), shareUserInfoList is null");
                return str;
            }
            com.tencent.mm.plugin.card.sharecard.model.r rVar = (com.tencent.mm.plugin.card.sharecard.model.r) wo.get(0);
            if (rVar == null || rVar.kNA == null || rVar.kNA.size() <= 0 || str.equals(rVar.kNA.get(0))) {
                x.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), mCardId is first!");
                return str;
            }
            String str3 = (String) rVar.kNA.get(0);
            x.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), mCardId is not first!, reset it");
            return str3;
        }
        x.e("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), card_tp_id is null");
        return str;
    }

    public static boolean auY() {
        l lVar = (l) am.auF().getValue("key_share_card_layout_data");
        if (lVar == null) {
            return true;
        }
        return lVar.kNp;
    }

    public static boolean auZ() {
        l lVar = (l) am.auF().getValue("key_share_card_layout_data");
        if (lVar == null) {
            return true;
        }
        return lVar.kNq;
    }

    public static void a(Context context, com.tencent.mm.plugin.card.base.b bVar) {
        x.i("MicroMsg.ShareCardDataMgr", "updateShareCardData()");
        x.i("MicroMsg.ShareCardDataMgr", "card id:" + bVar.atF() + " cardtpid:" + bVar.atG());
        bQ(bVar.atF(), bVar.atG());
        if (context != null) {
            R(context, bVar.atG());
        }
        E(bVar.atF(), bVar.atG(), bVar.atH());
        wl(bVar.atG());
    }
}
