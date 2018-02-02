package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.c$c;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.n.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.b;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class n {
    private static final n jIT = new n(true);
    public String appId;
    public int apptype;
    public int fIm;
    public int fIs;
    public String fIt;
    public int fno;
    public String fnp;
    public String fnq;
    public String fqu;
    public e irP;
    private final boolean jHW;
    boolean jHZ = false;
    public int jHc;
    String jIU = "";
    public final LinkedList<String> jIV = new LinkedList();
    public String jIW;
    public boolean jIX = true;
    public String jIa;
    public String jIc;
    public int jId;
    public String jIe;
    public long jIf;
    public int jIg;
    public int jIh;
    public String jIi;
    public int scene;

    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] iHw = new int[c$c.values().length];

        static {
            try {
                iHw[c$c.CLOSE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iHw[c$c.HANG.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iHw[c$c.LAUNCH_MINI_PROGRAM.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private n(boolean z) {
        this.jHW = z;
    }

    public static n akd() {
        return jIT;
    }

    public static n a(e eVar, String str, LinkedList<String> linkedList) {
        n nVar = new n(false);
        nVar.fqu = str;
        AppBrandStatObject appBrandStatObject = eVar.iqH;
        nVar.scene = appBrandStatObject.scene;
        nVar.fnp = appBrandStatObject.fnp;
        nVar.appId = eVar.mAppId;
        nVar.irP = eVar;
        nVar.fno = eVar.iqx.iOI.iGK + 1;
        nVar.fIm = eVar.iqx.iOI.iGL;
        nVar.jHc = appBrandStatObject.jHc;
        nVar.fIs = appBrandStatObject.fIs;
        nVar.fIt = appBrandStatObject.fIt;
        nVar.jIV.addAll(linkedList);
        return nVar;
    }

    public final void b(p pVar, boolean z) {
        this.jId = z ? 1 : 7;
        String str = (String) this.jIV.pollFirst();
        this.jIe = str;
        this.jIc = str;
        if (!z) {
            this.jIe = this.jIU;
        }
        k(pVar);
    }

    public final void k(p pVar) {
        a ajb = pVar.ajb();
        if (ajb != null) {
            int i;
            AppBrandSysConfig appBrandSysConfig = pVar.irP.iqx;
            if (appBrandSysConfig != null) {
                this.fIm = appBrandSysConfig.iOI.iGL;
                this.jIg = v.ZP().iGL;
            }
            this.jIf = System.currentTimeMillis();
            String url = ajb.juE.getUrl();
            if (url == null) {
                url = "";
            }
            this.jIW = com.tencent.mm.compatible.util.p.encode(url);
            this.fnq = pVar.getURL();
            this.jIi = pVar.aeO();
            this.jIa = com.tencent.mm.plugin.appbrand.report.a.ce(ac.getContext());
            if (this.jIX) {
                i = 1;
            } else {
                i = 0;
            }
            this.jIh = i;
            this.jIX = false;
            e eVar = pVar.irP;
            AppBrandInitConfig appBrandInitConfig = eVar == null ? null : eVar.iqw;
            if (appBrandInitConfig != null) {
                this.apptype = appBrandInitConfig.fnv;
            } else {
                this.apptype = b.tY(this.appId);
                x.i("MicroMsg.AppBrand.Report.kv_14992", "prepareCommonFields null = initConfig! apptype:%s", new Object[]{Integer.valueOf(this.apptype)});
            }
            this.apptype += 1000;
            if (!this.jHW) {
                x.i("MicroMsg.AppBrand.Report.kv_14992", "report " + toString());
                Runnable 1 = new 1(this, new Object[]{Integer.valueOf(this.scene), this.fnp, this.fqu, this.appId, Integer.valueOf(this.fIm), Integer.valueOf(this.fno), Integer.valueOf(this.jHc), this.fnq, this.jIW, this.jIa, this.jIc, Integer.valueOf(this.jId), this.jIe, Long.valueOf(this.jIf), Integer.valueOf(this.jIg), Integer.valueOf(this.fIs), this.fIt, Integer.valueOf(this.jIh), this.jIi, Integer.valueOf(this.apptype)});
                if (this.jHZ) {
                    1.run();
                    try {
                        KVCommCrossProcessReceiver.boi();
                        return;
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.AppBrand.Report.kv_14992", e, "sendKV", new Object[0]);
                        return;
                    }
                }
                c.Dm().F(1);
            }
        }
    }

    public final String toString() {
        return "kv_4992{scene=" + this.scene + ", sceneNote='" + this.fnp + '\'' + ", sessionId='" + this.fqu + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.fIm + ", appState=" + this.fno + ", usedState=" + this.jHc + ", pagePath='" + this.fnq + '\'' + ", currentUrl='" + this.jIW + '\'' + ", networkType='" + this.jIa + '\'' + ", referPagePath='" + this.jIc + '\'' + ", targetAction=" + this.jId + ", targetPagePath='" + this.jIe + '\'' + ", clickTimestamp=" + this.jIf + ", publicLibVersion=" + this.jIg + ", preScene=" + this.fIs + ", preSceneNote='" + this.fIt + '\'' + ", isEntrance=" + this.jIh + ", apptype=" + this.apptype + '}';
    }
}
