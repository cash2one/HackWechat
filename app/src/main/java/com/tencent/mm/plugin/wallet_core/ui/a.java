package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.bq.b;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.wallet.a.e;
import com.tencent.mm.plugin.wallet.a.f;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class a {
    public f sQU = null;
    Map<String, q> sQV = null;
    Map<String, h> sQW = null;

    public a(f fVar) {
        Assert.assertNotNull(fVar);
        this.sQU = fVar;
        WT();
    }

    private void WT() {
        int i = 0;
        this.sQV = new HashMap();
        List list = this.sQU.sDr;
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                q qVar = (q) list.get(i2);
                this.sQV.put(qVar.sDk, qVar);
            }
        } else {
            x.w("MicroMsg.FavorLogicHelper", "func[initData] favorList null");
        }
        this.sQW = new HashMap();
        if (this.sQU.sDs == null || this.sQU.sDs.sDC == null) {
            x.w("MicroMsg.FavorLogicHelper", "func[initData] favorComposeList null");
            return;
        }
        List list2 = this.sQU.sDs.sDC;
        while (i < list2.size()) {
            h hVar = (h) list2.get(i);
            this.sQW.put(hVar.sDE, hVar);
            i++;
        }
    }

    public final Map<String, a> Ng(String str) {
        return aL(str, false);
    }

    public final h aK(String str, boolean z) {
        if (!"0".equals(str) && this.sQW.containsKey(str)) {
            return (h) this.sQW.get(str);
        }
        for (String str2 : this.sQW.keySet()) {
            h hVar = (h) this.sQW.get(str2);
            if (!(hVar.sDG == null || hVar.sDG.size() == 0)) {
                int size = hVar.sDG.size();
                Iterator it = hVar.sDG.iterator();
                int i = 0;
                while (it.hasNext()) {
                    e eVar = (e) it.next();
                    if (!this.sQV.containsKey(eVar.sDk)) {
                        break;
                    }
                    int i2;
                    q qVar = (q) this.sQV.get(eVar.sDk);
                    if (qVar.sEi.equals("") && qVar.sEk.size() == 0 && (!z || qVar.sEh == 0)) {
                        i2 = i + 1;
                    } else {
                        i2 = i;
                    }
                    i = i2;
                }
                if (i > 0 && i == size) {
                    return hVar;
                }
            }
        }
        return null;
    }

    public final Map<String, a> aL(String str, boolean z) {
        Map<String, a> hashMap = new HashMap();
        if (this.sQU.sDs == null || this.sQU.sDs.sDC == null) {
            x.w("MicroMsg.FavorLogicHelper", "favorComposeList null or favorComposeList.favorComposeInfo null");
        } else {
            double d;
            List list = this.sQU.sDs.sDC;
            if (this.sQW.containsKey(str)) {
                d = ((h) this.sQW.get(str)).sDF;
            } else {
                d = 0.0d;
            }
            for (int i = 0; i < list.size(); i++) {
                h hVar = (h) list.get(i);
                String str2 = null;
                if (str.equals("0") && !hVar.equals("0")) {
                    str2 = hVar.sDE;
                } else if (hVar.sDE.startsWith(str) && !str.equals(hVar.sDE)) {
                    str2 = hVar.sDE.replace(str + "-", "");
                }
                String[] Nj = Nj(str2);
                if (Nj != null && Nj.length > 0) {
                    q qVar = (q) this.sQV.get(Nj[0]);
                    if (qVar != null) {
                        if ((qVar.sEh != 0 ? 1 : null) != null && !bh.ov(qVar.sEi) && qVar.sEk.size() <= 0 && (z || !qVar.sEi.equalsIgnoreCase("CFT"))) {
                            a aVar = (a) hashMap.get(qVar.sEi);
                            if (aVar == null || hVar.sDF > aVar.sQX.sDF) {
                                aVar = new a();
                                aVar.sQX = hVar;
                                aVar.pax = qVar.pax;
                                aVar.sQY = hVar.sDF - d;
                                aVar.sQZ = qVar.sEi;
                                hashMap.put(qVar.sEi, aVar);
                            }
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    public final List<q> Nh(String str) {
        List<q> linkedList = new LinkedList();
        if (this.sQU.sDr != null) {
            Map Ng = Ng(str);
            for (int i = 0; i < this.sQU.sDr.size(); i++) {
                q qVar = (q) this.sQU.sDr.get(i);
                if (qVar != null) {
                    Object obj;
                    if (qVar.sEh != 0) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null && Ng.containsKey(qVar.sEi)) {
                        linkedList.add(qVar);
                    }
                }
            }
        } else {
            x.w("MicroMsg.FavorLogicHelper", "fucn[getBankFavorListWithSelectedCompId] mFavorInfo.tradeFavList null");
        }
        return linkedList;
    }

    public final h Ni(String str) {
        return (h) this.sQW.get(str);
    }

    public static String[] Nj(String str) {
        if (bh.ov(str)) {
            return null;
        }
        return str.split("-");
    }

    public final String Nk(String str) {
        return aM(str, false);
    }

    public final String aM(String str, boolean z) {
        String[] Nj = Nj(str);
        if (Nj == null) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Nj.length; i++) {
            q qVar = (q) this.sQV.get(Nj[i]);
            if (qVar != null) {
                Object obj;
                if (qVar.sEh != 0) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null || (bh.ov(qVar.sEi) && !z)) {
                    stringBuilder.append(Nj[i]);
                    stringBuilder.append("-");
                }
            }
        }
        if (stringBuilder.length() == 0) {
            return "0";
        }
        return stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length()).toString();
    }

    public final FavorPayInfo Nl(String str) {
        FavorPayInfo favorPayInfo = new FavorPayInfo();
        if (this.sQW.get(str) == null) {
            favorPayInfo.sMT = "0";
            if (this.sQU != null) {
                favorPayInfo.sMW = this.sQU.sDq;
            }
            favorPayInfo.sMU = 0;
            return favorPayInfo;
        }
        favorPayInfo.sMT = str;
        if (this.sQU != null) {
            favorPayInfo.sMW = this.sQU.sDq;
        }
        favorPayInfo.sMU = 0;
        String[] Nj = Nj(str);
        if (Nj == null) {
            return favorPayInfo;
        }
        for (int length = Nj.length - 1; length >= 0; length--) {
            q qVar = (q) this.sQV.get(Nj[length]);
            if (qVar != null) {
                if ((qVar.sEh != 0 ? 1 : 0) == 0) {
                    break;
                }
                favorPayInfo.sMU = 1;
                if (qVar.sEk != null && qVar.sEk.size() > 0) {
                    favorPayInfo.sMY = new LinkedList();
                    Iterator it = qVar.sEk.iterator();
                    while (it.hasNext()) {
                        favorPayInfo.sMY.add(n.a((b) it.next()));
                    }
                }
                if (!bh.ov(qVar.sEi)) {
                    favorPayInfo.sMV = qVar.sEi;
                    break;
                }
            }
        }
        return favorPayInfo;
    }

    public static boolean a(FavorPayInfo favorPayInfo, Bankcard bankcard) {
        if (bankcard == null) {
            x.w("MicroMsg.FavorLogicHelper", "curBankcard null");
            return true;
        }
        if (!(favorPayInfo == null || bh.ov(favorPayInfo.sMT))) {
            boolean z;
            if (favorPayInfo.sMU != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z && !bh.ov(favorPayInfo.sMV) && favorPayInfo.sMY != null && favorPayInfo.sMY.contains(bankcard.field_bindSerial)) {
                return false;
            }
        }
        if (favorPayInfo.sMU != 0) {
            if (!bh.ov(favorPayInfo.sMV) && bankcard.field_bankcardType != null && !bankcard.field_bankcardType.equals(favorPayInfo.sMV)) {
                return true;
            }
            if (bh.ov(favorPayInfo.sMV) && bankcard.field_bankcardType.equals("CFT")) {
                return true;
            }
        }
        return false;
    }

    private static String ch(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(((String) list.get(i)));
            if (i < list.size() - 1) {
                stringBuilder.append("-");
            }
        }
        return stringBuilder.toString();
    }

    public final String Nm(String str) {
        ArrayList jB = o.bLq().jB(true);
        Map hashMap = new HashMap();
        List arrayList = new ArrayList();
        for (int i = 0; i < jB.size(); i++) {
            hashMap.put(((Bankcard) jB.get(i)).field_bankcardType, Integer.valueOf(0));
        }
        String[] Nj = Nj(str);
        if (Nj != null) {
            for (Object obj : Nj) {
                q qVar = (q) this.sQV.get(obj);
                if (qVar != null) {
                    boolean z;
                    if (qVar.sEh != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (hashMap.containsKey(qVar.sEi) || bh.ov(qVar.sEi)) {
                            arrayList.add(obj);
                        } else {
                        }
                    }
                }
                arrayList.add(obj);
            }
        }
        if (arrayList.size() == 0) {
            return "0";
        }
        return ch(arrayList);
    }

    public final List<q> bMo() {
        int i;
        ArrayList jB = o.bLq().jB(true);
        Map hashMap = new HashMap();
        for (i = 0; i < jB.size(); i++) {
            hashMap.put(((Bankcard) jB.get(i)).field_bankcardType, Integer.valueOf(0));
        }
        List<q> linkedList = new LinkedList();
        List list = this.sQU.sDr;
        if (list != null) {
            for (i = 0; i < list.size(); i++) {
                q qVar = (q) list.get(i);
                if (qVar != null) {
                    boolean z;
                    if (qVar.sEh != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (hashMap.containsKey(qVar.sEi) || bh.ov(qVar.sEi)) {
                            linkedList.add(qVar);
                        } else {
                        }
                    }
                }
                linkedList.add(qVar);
            }
        }
        return linkedList;
    }
}
