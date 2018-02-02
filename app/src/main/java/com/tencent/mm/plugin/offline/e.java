package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.a.o;
import com.tencent.mm.plugin.offline.i.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public final class e extends a<b> {
    public String oVl = "";
    private a oVm = new 1(this);

    public final void asi() {
        if (this.oVi != null) {
            for (int i = 0; i < this.oVi.size(); i++) {
                WeakReference weakReference = (WeakReference) this.oVi.get(i);
                if (weakReference != null) {
                    b bVar = (b) weakReference.get();
                    if (bVar != null) {
                        bVar.atT();
                    }
                }
            }
        }
    }

    public e() {
        k.bgX();
        if (k.bha() != null) {
            k.bgX();
            k.bha().oVP = this.oVm;
        }
    }

    private static void bgP() {
        k.bgX();
        k.bha().de(1, 1);
    }

    public final String k(int i, int i2, String str) {
        int i3 = 0;
        int bgQ = bgQ();
        if (bgQ > 0) {
            if (bgQ < k.oWe) {
                x.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount < %s", new Object[]{Integer.valueOf(k.oWe)});
                k.bgX();
                k.bha().dd(2, 2);
            }
            k.bgX();
            String un = k.un(196617);
            if (TextUtils.isEmpty(un)) {
                x.e("MicroMsg.OfflineCodesMgr", "generateKey_V3 cn is null, the csr is not exist! cn:" + un);
                return "";
            }
            com.tencent.mm.wallet_core.c.a.cBn();
            un = com.tencent.mm.wallet_core.c.a.getToken(un);
            if (TextUtils.isEmpty(un)) {
                bgP();
                x.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code is null");
                return "";
            }
            if (un != null) {
                x.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code length : %s ext_business_attach %s %s", new Object[]{Integer.valueOf(un.length()), str, un});
            }
            k oVar = new o(bgQ - 1, i, i2, str);
            g.Dk();
            g.Di().gPJ.a(oVar, 0);
            x.i("MicroMsg.OfflineCodesMgr", "doNetSceneShowCode count " + (bgQ - 1));
            LinkedList GW = com.tencent.mm.plugin.offline.c.a.GW(com.tencent.mm.plugin.offline.c.a.bhX());
            if (GW == null || GW.size() == 0) {
                x.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 cardList is null");
                bgP();
                return "";
            } else if (un == null || !com.tencent.mm.plugin.offline.c.a.wP(un)) {
                x.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code is null or is not isNumeric");
                return "";
            } else {
                long longValue = Long.valueOf(un, 10).longValue();
                long j = 0;
                while (i3 < GW.size()) {
                    com.tencent.mm.plugin.offline.c.a.a aVar = (com.tencent.mm.plugin.offline.c.a.a) GW.get(i3);
                    if (!(aVar == null || aVar.oZA == null || !aVar.oZA.equals(this.oVl))) {
                        j = (long) aVar.oZy;
                    }
                    i3++;
                }
                String valueOf = String.valueOf((j << 48) | longValue);
                if (valueOf.length() == 15) {
                    valueOf = "0" + valueOf;
                } else if (valueOf.length() == 14) {
                    valueOf = "00" + valueOf;
                } else if (valueOf.length() == 13) {
                    valueOf = "000" + valueOf;
                } else if (valueOf.length() == 12) {
                    valueOf = "0000" + valueOf;
                }
                if (TextUtils.isEmpty(com.tencent.mm.plugin.offline.c.a.bhZ())) {
                    return "12" + valueOf;
                }
                return com.tencent.mm.plugin.offline.c.a.bhZ() + valueOf;
            }
        }
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(2);
        objArr[1] = Integer.valueOf(com.tencent.mm.plugin.offline.c.a.df(ac.getContext()) ? 0 : 1);
        if (an.isNetworkConnected(ac.getContext())) {
            i3 = 1;
        }
        objArr[2] = Integer.valueOf(i3);
        gVar.h(14163, objArr);
        com.tencent.mm.plugin.report.service.g.pQN.a(135, 29, 1, true);
        if (an.isNetworkConnected(ac.getContext())) {
            com.tencent.mm.plugin.report.service.g.pQN.a(135, 31, 1, true);
        } else {
            com.tencent.mm.plugin.report.service.g.pQN.a(135, 30, 1, true);
        }
        bgP();
        x.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount is 0");
        return "";
    }

    public static int bgQ() {
        k.bgX();
        k.bha();
        return i.bgW();
    }
}
