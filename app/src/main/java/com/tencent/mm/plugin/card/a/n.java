package com.tencent.mm.plugin.card.a;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.card.model.v;
import com.tencent.mm.protocal.c.kj;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class n implements e, a {
    private af handler;
    public Map<String, Set<a>> kJH = new HashMap();
    public HashMap<String, String> kJI = new HashMap();
    private String kJJ;
    public v kJK;

    public n() {
        ar.CG().a(563, this);
        this.handler = new af(Looper.getMainLooper());
    }

    public final void a(String str, a aVar) {
        synchronized (this.kJH) {
            try {
                if (this.kJH.get(str) != null) {
                    ((Set) this.kJH.get(str)).remove(aVar);
                }
            } catch (Exception e) {
            }
        }
        synchronized (this.kJI) {
            this.kJI.remove(str);
        }
    }

    private void a(final String str, final boolean z, final ArrayList<kj> arrayList) {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ n kJM;

            public final void run() {
                synchronized (this.kJM.kJH) {
                    Set set = (Set) this.kJM.kJH.get(str);
                }
                if (set != null && set.size() > 0) {
                    Set<a> hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (a aVar : hashSet) {
                        if (aVar != null) {
                            aVar.a(z, arrayList);
                        }
                    }
                }
            }
        });
    }

    public final boolean a(String str, String str2, a aVar) {
        int i;
        x.d("MicroMsg.CardShopLBSManager", "getShopList, cardTpId = %s, card_id = %s", new Object[]{str, str2});
        this.kJJ = str;
        synchronized (this.kJH) {
            if (!this.kJH.containsKey(str)) {
                this.kJH.put(str, new HashSet());
            }
            if (!((Set) this.kJH.get(str)).contains(aVar)) {
                ((Set) this.kJH.get(str)).add(aVar);
            }
        }
        synchronized (this.kJI) {
            if (!TextUtils.isEmpty(str2)) {
                this.kJI.put(str, str2);
            }
        }
        com.tencent.mm.modelgeo.a OP = c.OP();
        if (OP == null) {
            x.e("MicroMsg.CardShopLBSManager", "getShopList fail, get IGetLocation fail, plugin no loaded?");
            i = 0;
        } else {
            OP.b(this);
            i = 1;
        }
        if (i == 0) {
            x.e("MicroMsg.CardShopLBSManager", "getShopList fail, get IGetLocation fail, plugin no loaded?");
            return false;
        }
        if (this.kJK != null) {
            ar.CG().c(this.kJK);
        }
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        this.kJK = null;
        String str2 = ((v) kVar).kLV;
        x.i("MicroMsg.CardShopLBSManager", "onSceneEnd, reqCardTpId = %s, errType = %d, errCode = %d", new Object[]{str2, Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            ArrayList arrayList = ((v) kVar).kLW;
            String str3 = "MicroMsg.CardShopLBSManager";
            String str4 = "onSceneEnd, respShopList size = %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
            x.d(str3, str4, objArr);
            a(str2, true, arrayList);
            return;
        }
        x.e("MicroMsg.CardShopLBSManager", "onSceneEnd, cardshoplbs fail");
        a(str2, false, null);
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return true;
        }
        com.tencent.mm.modelgeo.a OP = c.OP();
        if (OP != null) {
            OP.c(this);
        }
        x.d("MicroMsg.CardShopLBSManager", "onGetLocation, fLongitude = %f, fLatitude = %f, locType = %d, speed = %f, accuracy = %f", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2)});
        synchronized (this.kJH) {
            Set set = (Set) this.kJH.get(this.kJJ);
        }
        if (set == null || set.size() == 0) {
            x.e("MicroMsg.CardShopLBSManager", "onGetLocation, already cancelled, no need to doScene");
            return false;
        }
        String str;
        synchronized (this.kJI) {
            str = (String) this.kJI.get(this.kJJ);
        }
        k vVar = new v(this.kJJ, f, f2, str);
        if (ar.CG().a(vVar, 0)) {
            this.kJK = vVar;
        } else {
            x.e("MicroMsg.CardShopLBSManager", "doScene fail, callback immediate");
            a(this.kJJ, false, null);
        }
        return true;
    }
}
