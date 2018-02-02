package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.a.e.a;
import com.tencent.mm.plugin.appbrand.report.a.e.c;
import com.tencent.mm.plugin.appbrand.report.b;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class g {
    private static final g jHX = new g(true, null);
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
    public long jHU;
    private final boolean jHW;
    private final e jHY;
    boolean jHZ = false;
    public int jHc;
    public String jIa;
    public long jIb;
    public String jIc;
    public int jId;
    public String jIe;
    public long jIf;
    public int jIg;
    public int jIh;
    public String jIi;
    public int scene;

    private g(boolean z, e eVar) {
        this.jHW = z;
        this.jHY = eVar;
    }

    public static g aka() {
        return jHX;
    }

    public static g a(e eVar, String str, e eVar2) {
        g gVar = new g(false, eVar2);
        gVar.fqu = str;
        AppBrandStatObject appBrandStatObject = eVar.iqH;
        gVar.scene = appBrandStatObject.scene;
        gVar.fnp = appBrandStatObject.fnp;
        gVar.appId = eVar.mAppId;
        gVar.irP = eVar;
        gVar.fno = eVar.iqx.iOI.iGK + 1;
        gVar.fIm = eVar.iqx.iOI.iGL;
        gVar.jHc = appBrandStatObject.jHc;
        gVar.fIs = appBrandStatObject.fIs;
        gVar.fIt = appBrandStatObject.fIt;
        return gVar;
    }

    final void i(p pVar) {
        long Wp;
        a h;
        c cVar;
        e eVar;
        AppBrandInitConfig appBrandInitConfig;
        AppBrandSysConfig appBrandSysConfig = pVar.irP.iqx;
        if (appBrandSysConfig != null) {
            this.fIm = appBrandSysConfig.iOI.iGL;
            this.jIg = v.ZP().iGL;
        }
        this.jIf = pVar.jEc.jHy;
        this.jHU = Math.max(0, pVar.jEc.jHz);
        b bVar = pVar.jEc;
        long j = bVar.jHw.jHe;
        long j2 = bVar.jHy;
        long j3 = bVar.jHz;
        if (j <= 0) {
            x.i("MicroMsg.AppBrandPageViewStatistics", "foregroundMs invalid(%d), loadStart %d, loadCost %d, [%s/%s]", new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), bVar.mAppId, bVar.jHx});
            if (j2 > 0 && j3 > 0 && j == 0) {
                Wp = bh.Wp() - j2;
                this.jIb = Wp;
                this.fnq = pVar.getURL();
                this.jIi = pVar.aeO();
                this.jIa = com.tencent.mm.plugin.appbrand.report.a.ce(ac.getContext());
                h = this.jHY.h(pVar);
                if (h != null) {
                    x.e("MicroMsg.AppBrand.Report.kv_13536", "visitNode (%s) not found, maybe page switching to quickly", new Object[]{pVar.aeO()});
                    cVar = null;
                } else {
                    cVar = h.jHK;
                }
                this.jId = cVar != null ? 0 : cVar.type;
                this.jIe = cVar != null ? null : cVar.path;
                this.jIh = this.jHY.ub(this.jIi) ? 1 : 0;
                eVar = pVar.irP;
                appBrandInitConfig = eVar != null ? null : eVar.iqw;
                if (appBrandInitConfig == null) {
                    this.apptype = appBrandInitConfig.fnv;
                } else {
                    this.apptype = b.tY(this.appId);
                    x.i("MicroMsg.AppBrand.Report.kv_13536", "prepareCommonFields null = initConfig! apptype:%s", new Object[]{Integer.valueOf(this.apptype)});
                }
                this.apptype += 1000;
            }
        }
        Wp = Math.max(0, j);
        this.jIb = Wp;
        this.fnq = pVar.getURL();
        this.jIi = pVar.aeO();
        this.jIa = com.tencent.mm.plugin.appbrand.report.a.ce(ac.getContext());
        h = this.jHY.h(pVar);
        if (h != null) {
            cVar = h.jHK;
        } else {
            x.e("MicroMsg.AppBrand.Report.kv_13536", "visitNode (%s) not found, maybe page switching to quickly", new Object[]{pVar.aeO()});
            cVar = null;
        }
        if (cVar != null) {
        }
        this.jId = cVar != null ? 0 : cVar.type;
        if (cVar != null) {
        }
        this.jIe = cVar != null ? null : cVar.path;
        if (this.jHY.ub(this.jIi)) {
        }
        this.jIh = this.jHY.ub(this.jIi) ? 1 : 0;
        eVar = pVar.irP;
        if (eVar != null) {
        }
        if (appBrandInitConfig == null) {
            this.apptype = b.tY(this.appId);
            x.i("MicroMsg.AppBrand.Report.kv_13536", "prepareCommonFields null = initConfig! apptype:%s", new Object[]{Integer.valueOf(this.apptype)});
        } else {
            this.apptype = appBrandInitConfig.fnv;
        }
        this.apptype += 1000;
    }

    public final String toString() {
        return "kv_13536{scene=" + this.scene + ", sceneNote='" + this.fnp + '\'' + ", sessionId='" + this.fqu + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.fIm + ", appState=" + this.fno + ", usedState=" + this.jHc + ", pagePath='" + this.fnq + '\'' + ", networkType='" + this.jIa + '\'' + ", costTime=" + this.jHU + ", stayTime=" + this.jIb + ", referPagePath='" + this.jIc + '\'' + ", targetAction=" + this.jId + ", targetPagePath='" + this.jIe + '\'' + ", clickTimestamp=" + this.jIf + ", publicLibVersion=" + this.jIg + ", preScene=" + this.fIs + ", preSceneNote='" + this.fIt + '\'' + ", isEntrance=" + this.jIh + ", apptype=" + this.apptype + '}';
    }

    final void wW() {
        if (!this.jHW) {
            x.i("MicroMsg.AppBrand.Report.kv_13536", "report " + toString());
            Runnable 1 = new 1(this, new Object[]{Integer.valueOf(this.scene), this.fnp, this.fqu, this.appId, Integer.valueOf(this.fIm), Integer.valueOf(this.fno), Integer.valueOf(this.jHc), this.fnq, this.jIa, Long.valueOf(this.jHU), Long.valueOf(this.jIb), this.jIc, Integer.valueOf(this.jId), this.jIe, Long.valueOf(this.jIf), Integer.valueOf(this.jIg), Integer.valueOf(this.fIs), this.fIt, Integer.valueOf(this.jIh), this.jIi, Integer.valueOf(this.apptype)});
            if (this.jHZ) {
                1.run();
                try {
                    KVCommCrossProcessReceiver.boi();
                    return;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AppBrand.Report.kv_13536", e, "sendKV", new Object[0]);
                    return;
                }
            }
            com.tencent.mm.plugin.appbrand.q.c.Dm().F(1);
        }
    }
}
