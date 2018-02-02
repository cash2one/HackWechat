package com.tencent.mm.plugin.appbrand.dynamic.g;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.i;
import com.tencent.mm.plugin.appbrand.widget.j;
import com.tencent.mm.protocal.c.aob;
import com.tencent.mm.protocal.c.aoc;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.protocal.c.cbc;
import com.tencent.mm.protocal.c.cbt;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends com.tencent.mm.ae.a<aoc> {
    private int fvM;
    public final b gJQ;
    private int iUf;
    public j iUy;

    protected final /* bridge */ /* synthetic */ void a(int i, int i2, String str, bdf com_tencent_mm_protocal_c_bdf, k kVar) {
        a(i, i2, str, (aoc) com_tencent_mm_protocal_c_bdf);
    }

    public a(String str, boolean z, cbt com_tencent_mm_protocal_c_cbt) {
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_aob = new aob();
        com_tencent_mm_protocal_c_aob.ngo = str;
        com_tencent_mm_protocal_c_aob.wva = com_tencent_mm_protocal_c_cbt;
        com_tencent_mm_protocal_c_aob.wnA = z ? 1 : 2;
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmi = 1181;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxawidget";
        aVar.hmj = com_tencent_mm_protocal_c_aob;
        aVar.hmk = new aoc();
        b JZ = aVar.JZ();
        this.gJQ = JZ;
        this.gJQ = JZ;
        this.iUf = com_tencent_mm_protocal_c_cbt.xaM;
        this.fvM = com.tencent.mm.plugin.appbrand.dynamic.k.a.bD(this.iUf, com_tencent_mm_protocal_c_cbt.wtc);
    }

    private String getAppId() {
        return ((aob) this.gJQ.hmg.hmo).ngo;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int i, int i2, String str, aoc com_tencent_mm_protocal_c_aoc) {
        x.i("MicroMsg.CgiLaunchWxaWidget", "onCgiBack, errType %d, errCode %d, errMsg %s, req appId %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, getAppId()});
        if (i == 0 && i2 == 0 && com_tencent_mm_protocal_c_aoc != null) {
            String appId = getAppId();
            this.iUy = ((com.tencent.mm.plugin.appbrand.widget.a.a) g.h(com.tencent.mm.plugin.appbrand.widget.a.a.class)).Zj().a(appId, this.fvM, this.iUf, com_tencent_mm_protocal_c_aoc);
            if (com_tencent_mm_protocal_c_aoc.wvc != null) {
                String ah = ((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW().ah(appId, this.fvM);
                cbc com_tencent_mm_protocal_c_cbc = new cbc();
                com_tencent_mm_protocal_c_cbc.xat = ah;
                com_tencent_mm_protocal_c_cbc.vNa = com_tencent_mm_protocal_c_aoc.wvc.vNa;
                if (this.fvM == 10102) {
                    com_tencent_mm_protocal_c_cbc.xas = com_tencent_mm_protocal_c_aoc.wvc.wZS;
                    ((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW().a(appId, com_tencent_mm_protocal_c_cbc, this.fvM);
                    return;
                } else if (this.fvM == 10002) {
                    com_tencent_mm_protocal_c_cbc.xas = com_tencent_mm_protocal_c_aoc.wvc.wZR;
                    ((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW().a(appId, com_tencent_mm_protocal_c_cbc, this.fvM);
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        j jVar;
        i Zj = ((com.tencent.mm.plugin.appbrand.widget.a.a) g.h(com.tencent.mm.plugin.appbrand.widget.a.a.class)).Zj();
        String appId2 = getAppId();
        int i3 = this.fvM;
        int i4 = this.iUf;
        if (!bh.ov(appId2)) {
            jVar = new j();
            jVar.field_appIdHash = appId2.hashCode();
            jVar.field_appId = appId2;
            jVar.field_pkgType = i3;
            jVar.field_widgetType = i4;
        }
        jVar = null;
        this.iUy = jVar;
    }
}
