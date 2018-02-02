package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.a.e.a;
import com.tencent.mm.protocal.c.cba;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class i {
    private static final i jIA = new i(true, e.jHI);
    public String appId;
    public int fIs;
    public String fIt;
    public int fno;
    public String fnp;
    public String fnq;
    public String fqu;
    private final boolean jHW;
    private final e jHY;
    public int jHc;
    public String jIc;
    public int jIh;
    public int scene;

    private i(boolean z, e eVar) {
        this.jHW = z;
        this.jHY = eVar;
    }

    public static i akb() {
        return jIA;
    }

    public static i b(e eVar, String str, e eVar2) {
        i iVar = new i(false, eVar2);
        iVar.fqu = str;
        iVar.appId = eVar.mAppId;
        AppBrandStatObject appBrandStatObject = eVar.iqH;
        iVar.scene = appBrandStatObject.scene;
        iVar.fnp = appBrandStatObject.fnp;
        iVar.fIs = appBrandStatObject.fIs;
        iVar.fIt = appBrandStatObject.fIt;
        iVar.jHc = appBrandStatObject.jHc;
        iVar.fno = eVar.iqx.iOI.iGK + 1;
        return iVar;
    }

    public final void j(p pVar) {
        int i;
        this.fnq = pVar.aeO();
        a h = this.jHY.h(pVar);
        String str = (h == null || h.jHL == null) ? null : h.jHL.path;
        this.jIc = str;
        if (this.jHY.ub(this.fnq)) {
            i = 1;
        } else {
            i = 0;
        }
        this.jIh = i;
        if (!this.jHW) {
            cba com_tencent_mm_protocal_c_cba = new cba();
            com_tencent_mm_protocal_c_cba.ktN = 1;
            com_tencent_mm_protocal_c_cba.ngo = this.appId;
            com_tencent_mm_protocal_c_cba.xai = this.fnq;
            com_tencent_mm_protocal_c_cba.pQj = 0;
            com_tencent_mm_protocal_c_cba.lOD = (int) bh.Wo();
            com_tencent_mm_protocal_c_cba.pQk = 1;
            com_tencent_mm_protocal_c_cba.xaj = "";
            com_tencent_mm_protocal_c_cba.xak = this.fno;
            com_tencent_mm_protocal_c_cba.xal = this.fqu;
            com_tencent_mm_protocal_c_cba.xam = com.tencent.mm.plugin.appbrand.report.a.ce(ac.getContext());
            com_tencent_mm_protocal_c_cba.tlN = this.scene;
            com_tencent_mm_protocal_c_cba.xan = this.jHc;
            com_tencent_mm_protocal_c_cba.xao = this.fnp;
            com_tencent_mm_protocal_c_cba.jIc = this.jIc;
            com_tencent_mm_protocal_c_cba.fIs = this.fIs;
            com_tencent_mm_protocal_c_cba.fIt = this.fIt;
            com_tencent_mm_protocal_c_cba.jIh = this.jIh;
            AppBrandIDKeyBatchReport.a(com_tencent_mm_protocal_c_cba);
            x.i("MicroMsg.AppBrand.Report.kv_14004", "report " + toString());
        }
    }

    public final String toString() {
        return "kv_14004{appId='" + this.appId + '\'' + ", sessionId='" + this.fqu + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.fnp + '\'' + ", preScene=" + this.fIs + ", preSceneNote='" + this.fIt + '\'' + ", pagePath='" + this.fnq + '\'' + ", usedState=" + this.jHc + ", appState=" + this.fno + ", referPagePath='" + this.jIc + '\'' + ", isEntrance=" + this.jIh + '}';
    }
}
