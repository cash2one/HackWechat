package com.tencent.mm.modelcdntran;

import android.net.wifi.WifiInfo;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnInfoParams;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.jo;
import com.tencent.mm.protocal.c.zv;
import com.tencent.mm.protocal.c.zw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class e extends k implements com.tencent.mm.network.k {
    public static long hsR = 0;
    private static Map<String, a> hsS = new HashMap();
    private final b gJQ;
    private com.tencent.mm.ae.e gJT;
    private String hsT = "";
    int scene = 0;
    public long startTime = 0;

    static class a {
        boolean hsU = false;
        long hsV = 0;
        long hsW = 0;
        long hsX = 0;

        a() {
        }

        public final String toString() {
            return String.format("LastGetResult(%x){isTimeOut=%b, lastGetCDNDns_TenSecond=%d, lastTime_Hour=%d, lastCount_Hour=%d}", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(this.hsU), Long.valueOf(this.hsV), Long.valueOf(this.hsW), Long.valueOf(this.hsX)});
        }
    }

    protected e(int i) {
        x.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn init Scene:%d  [%s]", new Object[]{Integer.valueOf(i), bh.cgy()});
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new zv();
        aVar.hmk = new zw();
        aVar.uri = "/cgi-bin/micromsg-bin/getcdndns";
        aVar.hmi = 379;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.scene = i;
        ((zv) this.gJQ.hmg.hmo).wjq = "";
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        g.Dh();
        int Cg = com.tencent.mm.kernel.a.Cg();
        if (Cg == 0) {
            x.e("MicroMsg.NetSceneGetCDNDns", "has not set uin.");
            return -1;
        }
        if (hsR != ((long) Cg)) {
            hsR = (long) Cg;
            hsS.clear();
        }
        long Wo = bh.Wo();
        a aVar;
        if (this.scene == 0) {
            this.hsT = bh.az(MF(), "");
            aVar = (a) hsS.get(this.hsT);
            if (aVar == null) {
                aVar = new a();
                hsS.put(this.hsT, aVar);
                x.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn doScene NEW lastGetResult[%s] path[%s]", new Object[]{aVar, this.hsT});
            }
            if (aVar.hsU) {
                aVar.hsV = Wo;
                aVar.hsW = Wo;
                aVar.hsX = 0;
            }
            x.d("MicroMsg.NetSceneGetCDNDns", "cdntra doscene Sec:%d Hour[%d,%d]", new Object[]{Long.valueOf(Wo - aVar.hsV), Long.valueOf(Wo - aVar.hsW), Long.valueOf(aVar.hsX)});
            if (Wo > aVar.hsV && Wo - aVar.hsV < 10) {
                x.w("MicroMsg.NetSceneGetCDNDns", "Last get dns at %d ago . ignore!, lastGetResult[%s]", new Object[]{Long.valueOf(Wo - aVar.hsV), aVar});
                return -1;
            } else if (Wo <= aVar.hsW || Wo - aVar.hsW >= 3600 || aVar.hsX < 90) {
                aVar.hsV = Wo;
                if (Wo < aVar.hsW || Wo - aVar.hsX > 3600) {
                    aVar.hsW = Wo;
                    aVar.hsX = 0;
                } else {
                    aVar.hsX++;
                }
            } else {
                x.w("MicroMsg.NetSceneGetCDNDns", "in 1 hour , get dns more than 90  (%d). ignore!, lastGetResult[%s]", new Object[]{Long.valueOf(Wo - aVar.hsW), aVar});
                return -1;
            }
        }
        this.hsT = "";
        Iterator it = hsS.values().iterator();
        if (it != null) {
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar != null) {
                    aVar.hsV = Wo;
                    if (Wo < aVar.hsW || Wo - aVar.hsX > 3600) {
                        aVar.hsW = Wo;
                        aVar.hsX = 0;
                    } else {
                        aVar.hsX++;
                    }
                }
            }
        }
        this.startTime = Wo;
        com.tencent.mm.plugin.report.service.g.pQN.a(546, this.scene == 0 ? 0 : 1, 1, true);
        return a(eVar, this.gJQ, this);
    }

    private static String MF() {
        if (!an.isConnected(ac.getContext())) {
            return null;
        }
        String str;
        if (an.isWifi(ac.getContext())) {
            WifiInfo wifiInfo = an.getWifiInfo(ac.getContext());
            if (wifiInfo == null) {
                return null;
            }
            str = "wifi_" + wifiInfo.getSSID();
        } else {
            str = "mobile_" + an.getNetTypeString(ac.getContext()) + "_" + an.getISPCode(ac.getContext());
        }
        x.d("MicroMsg.NetSceneGetCDNDns", "cdntra getCurCacheFullPath file:%s", new Object[]{str});
        if (str == null || str.length() < 2) {
            return null;
        }
        str = String.format("%x", new Object[]{Integer.valueOf(str.hashCode())});
        StringBuilder stringBuilder = new StringBuilder();
        g.MG();
        return stringBuilder.append(g.MH()).append(str).toString();
    }

    private static CdnInfoParams a(jo joVar) {
        CdnInfoParams cdnInfoParams = new CdnInfoParams();
        cdnInfoParams.c2CretryIntervalMs = joVar.vPV;
        cdnInfoParams.c2CrwtimeoutMs = joVar.vPX;
        cdnInfoParams.c2CshowErrorDelayMs = joVar.vPT;
        cdnInfoParams.snsretryIntervalMs = joVar.vPW;
        cdnInfoParams.snsrwtimeoutMs = joVar.vPY;
        cdnInfoParams.snsshowErrorDelayMs = joVar.vPU;
        return cdnInfoParams;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd errtype:" + i2 + " errcode:" + i3);
        zw zwVar = (zw) ((b) qVar).hmh.hmo;
        if (i2 == 0 && i3 == 0 && zwVar.vSD != null) {
            String MF = MF();
            if (!(bh.ov(MF) || bh.ov(this.hsT) || MF.equals(this.hsT))) {
                x.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd revised cacheFullPath[%s] to [%s]", new Object[]{MF, this.hsT});
                com.tencent.mm.plugin.report.service.g.pQN.a(546, 6, 1, true);
            }
            hsS.clear();
            byte[] bArr2 = null;
            if (zwVar.vSG != null && zwVar.vSG.wJB > 0) {
                x.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd cdnrule:%d", new Object[]{Integer.valueOf(zwVar.vSG.wJB)});
                bArr2 = n.a(zwVar.vSG);
            }
            byte[] bArr3 = null;
            if (zwVar.vSH != null && zwVar.vSH.wJB > 0) {
                x.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd safecdnrule:%d", new Object[]{Integer.valueOf(zwVar.vSH.wJB)});
                bArr3 = n.a(zwVar.vSH);
            }
            x.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo:%s", new Object[]{zwVar.vSI});
            if (zwVar.vSI != null) {
                x.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo FakeUin:%d NewAuthKey:%s", new Object[]{Integer.valueOf(zwVar.vSI.lOd), zwVar.vSI.vQf});
            }
            if (g.MK().a(zwVar.vSD, zwVar.vSE, zwVar.vSF, bArr2, bArr3, zwVar.vSI)) {
                x.i("MicroMsg.NetSceneGetCDNDns", "getcdndns defaultcfg %s, disastercfg %s, getcdninterval %d", new Object[]{zwVar.vSK, zwVar.vSL, Integer.valueOf(zwVar.vSJ)});
                if (!(zwVar.vSK == null || zwVar.vSL == null)) {
                    CdnLogic.setCdnInfoParams(a(zwVar.vSK), a(zwVar.vSL), zwVar.vSJ);
                }
                this.gJT.a(i2, i3, str, this);
                return;
            }
            x.e("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd setCDNDnsInfo failed ");
            this.gJT.a(i2, i3, str, this);
            return;
        }
        com.tencent.mm.plugin.report.service.g.pQN.h(10769, new Object[]{Integer.valueOf(d.hsQ), Integer.valueOf(0), Long.valueOf(this.startTime)});
        String str2 = "MicroMsg.NetSceneGetCDNDns";
        String str3 = "onGYNetEnd: [%d ,%d]  info is null :%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Boolean.valueOf(zwVar.vSD == null);
        x.w(str2, str3, objArr);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 379;
    }
}
