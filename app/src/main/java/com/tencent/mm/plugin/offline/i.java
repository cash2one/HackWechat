package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.a.f;
import com.tencent.mm.plugin.offline.a.h;
import com.tencent.mm.plugin.offline.a.l;
import com.tencent.mm.plugin.offline.a.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class i implements e {
    public af mHandler = new af();
    private boolean oVK = false;
    private boolean oVL = false;
    private int oVM = 10;
    private int oVN = 0;
    private String oVO = "";
    a oVP;
    private m oVQ;
    public b oVR = new b(this, (byte) 0);
    int oVS = 14400000;
    ak oVT = new ak(new a(this) {
        final /* synthetic */ i oVU;

        {
            this.oVU = r1;
        }

        public final boolean uF() {
            if (g.Dh().Cy()) {
                long j;
                this.oVU.dc(5, 5);
                ak akVar = this.oVU.oVT;
                i iVar = this.oVU;
                long bid = (long) com.tencent.mm.plugin.offline.c.a.bid();
                if (bid <= 0) {
                    j = (long) iVar.oVS;
                } else {
                    x.i("MicroMsg.OfflineTokensMgr", "OfflineTokensMgr updateInterval:" + bid);
                    j = 1000 * bid;
                }
                akVar.J(j, j);
            } else {
                long j2 = (long) this.oVU.oVS;
                this.oVU.oVT.J(j2, j2);
            }
            return false;
        }
    }, false);

    public i() {
        long j = 1;
        try {
            com.tencent.mm.wallet_core.c.a.cBn();
            com.tencent.mm.wallet_core.c.a.init(ac.getContext());
        } catch (Exception e) {
            x.e("MicroMsg.OfflineTokensMgr", "NO MPERMISSION for READ_PHONE_STATE:%s.", new Object[]{e});
        }
        g.Dk();
        g.Di().gPJ.a(385, this);
        k.bgX();
        String un = k.un(196649);
        if (TextUtils.isEmpty(un) || !com.tencent.mm.plugin.offline.c.a.wP(un)) {
            x.i("MicroMsg.OfflineTokensMgr", "genInitInterval: update_interval is empty or is not number,update token");
        } else {
            Object bhP = com.tencent.mm.plugin.offline.c.a.bhP();
            x.i("MicroMsg.OfflineTokensMgr", "genInitInterval: token is not over update interval,lastUpdate is " + bhP);
            long longValue = Long.valueOf(un).longValue();
            if (TextUtils.isEmpty(bhP)) {
                x.i("MicroMsg.OfflineTokensMgr", "genInitInterval lastUpdate is empty, update token");
            } else {
                j = Long.valueOf(bhP).longValue();
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                x.i("MicroMsg.OfflineTokensMgr", "genInitInterval token is not over update interval,curTime = " + currentTimeMillis + ";");
                j = longValue - (currentTimeMillis - j);
            }
        }
        x.i("MicroMsg.OfflineTokensMgr", "autoPusher startTimer interval=" + j);
        j *= 1000;
        this.oVT.J(j, j);
    }

    public static int bgW() {
        k.bgX();
        String un = k.un(196617);
        com.tencent.mm.wallet_core.c.a.cBn();
        int aau = com.tencent.mm.wallet_core.c.a.aau(un);
        x.i("MicroMsg.OfflineTokensMgr", "offline tokens count:" + aau);
        return aau;
    }

    public final void dc(int i, int i2) {
        if (an.isNetworkConnected(ac.getContext()) && com.tencent.mm.plugin.offline.c.a.bhH()) {
            x.i("MicroMsg.OfflineTokensMgr", "onNotify return false, token is invalid, do doNetSceneToken");
            de(i, i2);
        }
    }

    public final boolean hd(boolean z) {
        if (!com.tencent.mm.plugin.offline.c.a.bhH()) {
            x.e("MicroMsg.OfflineTokensMgr", "offline is not create!");
            return false;
        } else if (bgW() < k.oWe) {
            x.i("MicroMsg.OfflineTokensMgr", "getTokenCount < %s, do doNetSceneToken", new Object[]{Integer.valueOf(k.oWe)});
            com.tencent.mm.wallet_core.c.a.cBn();
            int lastError = com.tencent.mm.wallet_core.c.a.getLastError();
            if (lastError != 0) {
                x.e("MicroMsg.OfflineTokensMgr", "getTokenCount occurs error, the error is " + lastError + ", don't  doNetSceneToken");
                return false;
            }
            x.i("MicroMsg.OfflineTokensMgr", "getTokenCount is success! do doNetSceneToken");
            if (z) {
                dd(2, 9);
            } else {
                dd(2, 2);
            }
            return true;
        } else if (com.tencent.mm.plugin.offline.c.a.bie()) {
            x.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isTokenOverUpdateInterval() return false, token is over update_interval, do doNetSceneToken");
            if (z) {
                de(5, 9);
            } else {
                de(5, 5);
            }
            return true;
        } else if (com.tencent.mm.plugin.offline.c.a.bib()) {
            return false;
        } else {
            x.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, bindserial is change, do doNetSceneToken");
            if (z) {
                de(3, 9);
            } else {
                de(3, 3);
            }
            return true;
        }
    }

    public final void dd(int i, int i2) {
        if (bgW() > 2) {
            this.mHandler.postDelayed(new 2(this, 2, i2), 3000);
        } else {
            de(2, i2);
        }
    }

    public final void de(int i, int i2) {
        int i3 = 0;
        if (!this.oVK) {
            this.oVK = true;
            k mVar = new m((System.currentTimeMillis() / 1000), i, i2);
            g.Dk();
            g.Di().gPJ.a(mVar, 0);
            boolean df = com.tencent.mm.plugin.offline.c.a.df(ac.getContext());
            boolean isNetworkConnected = an.isNetworkConnected(ac.getContext());
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(4);
            objArr[1] = Integer.valueOf(df ? 0 : 1);
            objArr[2] = Integer.valueOf(isNetworkConnected ? 1 : 0);
            objArr[3] = Integer.valueOf(0);
            objArr[4] = Integer.valueOf(i);
            if (k.oWd) {
                i3 = 1;
            }
            objArr[5] = Integer.valueOf(i3);
            gVar.h(14163, objArr);
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX);
            iDKey.SetValue(1);
            iDKey.SetKey(isNetworkConnected ? 36 : 37);
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX);
            iDKey.SetValue(1);
            iDKey.SetKey(df ? 38 : 39);
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX);
            iDKey.SetValue(1);
            iDKey.SetKey(k.oWd ? 40 : 41);
            arrayList.add(iDKey);
            IDKey iDKey2;
            if (i == 2) {
                iDKey = new IDKey();
                iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX);
                iDKey.SetValue(1);
                iDKey.SetKey(k.oWd ? 42 : 43);
                arrayList.add(iDKey);
                iDKey = new IDKey();
                iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX);
                iDKey.SetValue(1);
                iDKey.SetKey(df ? 44 : 45);
                arrayList.add(iDKey);
                iDKey2 = new IDKey();
                iDKey2.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX);
                iDKey2.SetValue(1);
                iDKey2.SetKey(isNetworkConnected ? 46 : 47);
                arrayList.add(iDKey2);
            } else if (i == 6) {
                iDKey = new IDKey();
                iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX);
                iDKey.SetValue(1);
                iDKey.SetKey(k.oWd ? 48 : 49);
                arrayList.add(iDKey);
                iDKey = new IDKey();
                iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX);
                iDKey.SetValue(1);
                iDKey.SetKey(df ? 50 : 51);
                arrayList.add(iDKey);
                iDKey2 = new IDKey();
                iDKey2.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX);
                iDKey2.SetValue(1);
                iDKey2.SetKey(isNetworkConnected ? 52 : 53);
                arrayList.add(iDKey2);
            } else if (i == 6) {
                IDKey iDKey3 = new IDKey();
                iDKey3.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX);
                iDKey3.SetValue(1);
                iDKey3.SetKey(df ? 54 : 55);
                arrayList.add(iDKey3);
            }
            com.tencent.mm.plugin.report.service.g.pQN.a(arrayList, true);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 6;
        if ((kVar instanceof h) || (kVar instanceof f)) {
            ArrayList arrayList = new ArrayList();
            if (kVar instanceof m) {
                IDKey iDKey = new IDKey();
                iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX);
                iDKey.SetValue(1);
                iDKey.SetKey(2);
                arrayList.add(iDKey);
                if (!(i == 0 && i2 == 0)) {
                    iDKey = new IDKey();
                    iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX);
                    iDKey.SetValue(1);
                    iDKey.SetKey(3);
                    arrayList.add(iDKey);
                }
                com.tencent.mm.plugin.report.service.g.pQN.a(arrayList, true);
            }
            if ((kVar instanceof f) && ((i == 0 && i2 == 0) || i != 0)) {
                x.i("MicroMsg.OfflineTokensMgr", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                if (this.oVQ != null) {
                    boolean bhe = this.oVQ.bhe();
                    this.oVQ = null;
                    if (bhe && this.oVP != null) {
                        this.oVP.bgR();
                    }
                }
            }
            if (i == 0 && i2 == 0) {
                if (kVar instanceof m) {
                    this.oVN = 0;
                    this.oVK = false;
                    this.mHandler.removeCallbacks(this.oVR);
                    this.oVQ = (m) kVar;
                    String str2 = this.oVQ.oWQ;
                    k.bgX();
                    k fVar = new f(str2, k.un(196617));
                    g.Dk();
                    g.Di().gPJ.a(fVar, 0);
                } else if (kVar instanceof l) {
                    this.oVL = false;
                    this.oVO = ((l) kVar).oVO;
                    if (this.oVP != null) {
                        this.oVP.bgR();
                    }
                } else if (!(kVar instanceof f)) {
                }
            } else if (kVar instanceof m) {
                x.e("MicroMsg.OfflineTokensMgr", "gettoken is failed!");
                this.oVN++;
                this.oVK = false;
                if (i2 == 411) {
                    x.i("MicroMsg.OfflineTokensMgr", "errcode is  411, do clearAllOfflineData");
                    com.tencent.mm.plugin.offline.c.a.bhS();
                } else if (this.oVN < this.oVM) {
                    this.mHandler.removeCallbacks(this.oVR);
                    int i4 = this.oVN - 1;
                    if (i4 <= 6) {
                        i3 = i4;
                    }
                    this.mHandler.postDelayed(this.oVR, (long) ((((int) Math.pow(2.0d, (double) i3)) * 60) * 1000));
                }
            } else if (kVar instanceof l) {
                this.oVL = false;
            } else if (kVar instanceof f) {
                this.oVQ = null;
            }
        }
    }
}
