package com.tencent.mm.plugin.webview.model;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.a;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map.Entry;

public final class aj {
    private static int mYb = 0;
    private static int tsS = 0;
    public m tsF;
    public k tsG;
    public l tsH;
    public j tsI;
    public f tsJ;
    public b tsK;
    public g tsL;
    public d tsM;
    private e tsN;
    private i tsO;
    private h tsP;
    private c tsQ;
    public a tsR;

    public static class c {
        public boolean moK = false;
        public boolean tsW = false;
    }

    public static class h {
        public List<String> ttc;
    }

    public static class i {
        public List<String> ttc;
    }

    public static class j {
        public String appId;
        public String fIG;
        public String gjO;
        long gzo = (System.currentTimeMillis() / 1000);
        public long jIb;
        public String mXh;
        public String rtA;
        public int scene;
        public String title;
        public String ttd;
        public String tte;
        public long ttf;
        public int ttg;
        public String tth;
        public String tti;
        public String ttj;
        public int ttk;
        public long ttl = -1;
        public String username;
    }

    public static /* synthetic */ void a(d dVar, String str, Object[] objArr) {
        if (dVar != null) {
            com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11215, objArr);
            if (str != null && str.startsWith("official_mall")) {
                com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 14919, objArr);
            }
        }
    }

    public static int bQU() {
        switch (an.getNetType(ac.getContext())) {
            case -1:
                return 255;
            case 0:
                return 1;
            case 1:
            case 6:
            case 8:
                return 3;
            case 2:
            case 5:
            case 7:
                return 2;
            case 3:
            case 4:
                return 4;
            case 10:
                return 5;
            default:
                return 6;
        }
    }

    public static String bQV() {
        ConnectivityManager connectivityManager = (ConnectivityManager) ac.getContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return "no";
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return "no";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        x.d("MicroMsg.WebviewReporter", "activeNetInfo extra=%s, type=%d, %s", new Object[]{activeNetworkInfo.getExtraInfo(), Integer.valueOf(activeNetworkInfo.getType()), activeNetworkInfo.getExtraInfo()});
        if (activeNetworkInfo.getExtraInfo() != null) {
            return activeNetworkInfo.getExtraInfo().toLowerCase();
        }
        return "no";
    }

    public final m bQW() {
        if (this.tsF == null) {
            this.tsF = new m(this);
        }
        return this.tsF;
    }

    public final k bQX() {
        if (this.tsG == null) {
            this.tsG = new k(this);
        }
        return this.tsG;
    }

    public final l bQY() {
        if (this.tsH == null) {
            this.tsH = new l(this);
        }
        return this.tsH;
    }

    public final e bQZ() {
        if (this.tsN == null) {
            this.tsN = new e(this);
        }
        return this.tsN;
    }

    public final j bRa() {
        if (this.tsI == null) {
            this.tsI = new j();
        }
        return this.tsI;
    }

    public final f bRb() {
        if (this.tsJ == null) {
            this.tsJ = new f(this);
        }
        return this.tsJ;
    }

    public final b bRc() {
        if (this.tsK == null) {
            this.tsK = new b();
        }
        return this.tsK;
    }

    public final g bRd() {
        if (this.tsL == null) {
            this.tsL = new g();
        }
        return this.tsL;
    }

    public final d bRe() {
        if (this.tsM == null) {
            this.tsM = new d();
        }
        return this.tsM;
    }

    public final i bRf() {
        if (this.tsO == null) {
            this.tsO = new i();
        }
        return this.tsO;
    }

    public final h bRg() {
        if (this.tsP == null) {
            this.tsP = new h();
        }
        return this.tsP;
    }

    public final c bRh() {
        if (this.tsQ == null) {
            this.tsQ = new c();
        }
        return this.tsQ;
    }

    public final void t(String str, Object obj) {
        if (this.tsR != null) {
            try {
                this.tsR.putValue(str, obj);
            } catch (Exception e) {
            }
        }
    }

    public final void Ow(String str) {
        if (this.tsR != null) {
            try {
                a aVar = this.tsR;
                if (aVar.msB.containsKey(str)) {
                    try {
                        aVar.putValue(str, Integer.valueOf(aVar.msB.getInt(str) + 1));
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                aVar.putValue(str, Integer.valueOf(1));
            } catch (Exception e2) {
            }
        }
    }

    public static void H(boolean z, boolean z2) {
        if (z) {
            mYb = 1;
        } else {
            mYb = 0;
        }
        if (z2) {
            tsS = 1;
        } else {
            tsS = 0;
        }
    }

    public final void c(d dVar) {
        l bQY = bQY();
        if (dVar != null) {
            int bQU = bQU();
            for (Entry entry : bQY.ttn.entrySet()) {
                String str = (String) entry.getKey();
                long longValue = ((Long) entry.getValue()).longValue();
                g.pQN.a(32, 0, 1, true);
                if (longValue >= 0 && longValue <= 180000) {
                    String str2 = bQY.ttb;
                    Object[] objArr = new Object[11];
                    objArr[0] = Integer.valueOf(3);
                    objArr[1] = Long.valueOf(longValue);
                    objArr[2] = Integer.valueOf(bQU);
                    objArr[3] = str == null ? str : str.replace(",", "!");
                    objArr[4] = Integer.valueOf(0);
                    objArr[5] = Integer.valueOf(0);
                    objArr[6] = Integer.valueOf(0);
                    objArr[7] = Integer.valueOf(mYb);
                    objArr[8] = Integer.valueOf(tsS);
                    objArr[9] = Integer.valueOf(bQY.fMy);
                    objArr[10] = bQY.ttb;
                    a(dVar, str2, objArr);
                    g.pQN.a(160, 0, 1, false);
                    if (-1 != a.fj(longValue)) {
                        g.pQN.a(160, (long) a.fj(longValue), 1, false);
                    }
                    g.pQN.a(32, 3, 1, true);
                    g.pQN.a(32, 7, longValue, true);
                    if (tsS == 1) {
                        g.pQN.a(32, 16, 1, true);
                        g.pQN.a(32, 17, longValue, true);
                    }
                    x.i("MicroMsg.WebviewReporter", "WebviewOpenUrlReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", new Object[]{str, Long.valueOf(longValue), Integer.valueOf(bQU), Integer.valueOf(mYb), Integer.valueOf(tsS), Integer.valueOf(bQY.fMy), bQY.ttb});
                }
            }
        }
        j bRa = bRa();
        if (!bh.ov(bRa.tte)) {
            x.d("MicroMsg.WebviewReporter", "WebViewVisitReporter report viewID = %s", new Object[]{bRa.tte});
        }
        if (dVar != null) {
            Object obj;
            String str3 = "";
            try {
                Bundle e = dVar.e(23, new Bundle(0));
                if (e != null) {
                    str3 = e.getString("config_info_username");
                }
                obj = str3;
            } catch (RemoteException e2) {
                x.w("MicroMsg.WebviewReporter", "invokeAsResult error, %s", new Object[]{e2});
                str2 = str3;
            }
            PString pString = new PString();
            x.d("MicroMsg.WebviewReporter", "report 10643(%s), username : %s, msgId : %s, msgIndex : %s, scene : %s, enterTime : %s, stayTime : %s, rawUrl : %s, publisher : %s, viewId : %s, publishId : %s,appId : %s, newMsgId : %s, preUsername : %s, curUsername : %s, referUrl : %s, statExtStr:%s(%s), chatType:%d, title:%s, expidstr[chatting_exp]:%s, sourceAppId:%s, allStayTime %d", new Object[]{Integer.valueOf(10643), bRa.username, Long.valueOf(bRa.ttf), Integer.valueOf(bRa.ttg), Integer.valueOf(bRa.scene), Long.valueOf(bRa.gzo), Long.valueOf(bRa.jIb), bRa.fIG, bRa.ttd, bRa.tte, bRa.mXh, bRa.appId, bRa.tth, bRa.tti, obj, bRa.ttj, bRa.rtA, ((com.tencent.mm.plugin.sns.b.i) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.sns.b.i.class)).a(bRa.rtA, pString), Integer.valueOf(bRa.ttk), bRa.title, bRa.gjO, pString.value, Long.valueOf(System.currentTimeMillis() - bRa.gzo)});
            str3 = bRa.title;
            try {
                str3 = URLEncoder.encode(bRa.title, "UTF-8");
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.WebviewReporter", e3, "", new Object[0]);
            }
            Object[] objArr2 = new Object[21];
            objArr2[0] = bRa.username;
            objArr2[1] = Long.valueOf(bRa.ttf);
            objArr2[2] = Integer.valueOf(bRa.ttg);
            objArr2[3] = Integer.valueOf(bRa.scene);
            objArr2[4] = Long.valueOf(bRa.gzo);
            objArr2[5] = Long.valueOf(bRa.jIb);
            objArr2[6] = bRa.fIG == null ? bRa.fIG : bRa.fIG.replace(",", "!");
            objArr2[7] = bRa.ttd;
            objArr2[8] = bRa.tte;
            objArr2[9] = bRa.mXh;
            objArr2[10] = bRa.appId;
            objArr2[11] = bRa.tth;
            objArr2[12] = bRa.tti;
            objArr2[13] = obj;
            objArr2[14] = bRa.ttj == null ? bRa.ttj : bRa.ttj.replace(",", "!");
            objArr2[15] = r7;
            objArr2[16] = Integer.valueOf(bRa.ttk);
            objArr2[17] = str3;
            objArr2[18] = bRa.gjO;
            objArr2[19] = pString.value;
            objArr2[20] = Long.valueOf(System.currentTimeMillis() - bRa.gzo);
            com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 10643, objArr2);
        }
        bQX().c(dVar);
        bQZ().c(dVar);
        b bRc = bRc();
        if (dVar != null) {
            int bQU2 = bQU();
            if (!bRc.tsV) {
                com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11575, new Object[]{bRc.fIG, Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(bQU2)});
            } else if (bRc.tsU) {
                com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11575, new Object[]{bRc.fIG, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(bQU2)});
            } else {
                com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11575, new Object[]{bRc.fIG, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(bQU2)});
            }
        }
    }
}
