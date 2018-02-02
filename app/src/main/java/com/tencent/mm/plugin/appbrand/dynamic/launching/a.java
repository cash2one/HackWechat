package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.util.Base64;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.dynamic.g.a.1;
import com.tencent.mm.plugin.appbrand.i.c;
import com.tencent.mm.plugin.appbrand.widget.i;
import com.tencent.mm.plugin.appbrand.widget.j;
import com.tencent.mm.protocal.c.aoc;
import com.tencent.mm.protocal.c.cbc;
import com.tencent.mm.protocal.c.cbt;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.Callable;

public final class a implements Callable<j> {
    final String appId;
    final int fIm;
    final int fvM;
    final int iUf;
    final String iUg;
    final int scene;

    public final /* synthetic */ Object call() {
        return acZ();
    }

    public a(String str, int i, int i2, int i3, int i4, String str2) {
        this.appId = str;
        this.fvM = i;
        this.fIm = i2;
        this.scene = i3;
        this.iUf = i4;
        this.iUg = str2;
    }

    public final j acZ() {
        j jVar = new j();
        jVar.field_appId = this.appId;
        i Zj = ((com.tencent.mm.plugin.appbrand.widget.a.a) g.h(com.tencent.mm.plugin.appbrand.widget.a.a.class)).Zj();
        if (Zj == null) {
            return null;
        }
        cbt com_tencent_mm_protocal_c_cbt = new cbt();
        com_tencent_mm_protocal_c_cbt.wtc = com.tencent.mm.plugin.appbrand.dynamic.k.a.jX(this.fvM);
        com_tencent_mm_protocal_c_cbt.vNa = this.fIm;
        com_tencent_mm_protocal_c_cbt.xaM = this.iUf;
        com_tencent_mm_protocal_c_cbt.rYW = this.scene;
        com_tencent_mm_protocal_c_cbt.xaN = 0;
        if (Zj.a(jVar, new String[]{"appId", "pkgType", "widgetType"})) {
            if ((jVar.field_jsApiInfo != null) && jVar.field_launchAction != null && 1 == jVar.field_launchAction.vEe && jVar.field_versionInfo != null && jVar.field_versionInfo.vNa >= this.fIm) {
                com.tencent.mm.plugin.appbrand.dynamic.i.a.a.rB(this.appId);
                com.tencent.mm.bz.a.post(new 1(new com.tencent.mm.plugin.appbrand.dynamic.g.a(this.appId, false, com_tencent_mm_protocal_c_cbt)));
                return jVar;
            }
        }
        if (this.iUg != null && this.iUg.length() > 0) {
            try {
                aoc com_tencent_mm_protocal_c_aoc = new aoc();
                com_tencent_mm_protocal_c_aoc.aF(Base64.decode(this.iUg, 0));
                jVar = ((com.tencent.mm.plugin.appbrand.widget.a.a) g.h(com.tencent.mm.plugin.appbrand.widget.a.a.class)).Zj().a(this.appId, this.fvM, this.iUf, com_tencent_mm_protocal_c_aoc);
                if (com_tencent_mm_protocal_c_aoc.wvc != null) {
                    String ah = ((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW().ah(this.appId, this.fvM);
                    cbc com_tencent_mm_protocal_c_cbc = new cbc();
                    com_tencent_mm_protocal_c_cbc.xat = ah;
                    com_tencent_mm_protocal_c_cbc.vNa = com_tencent_mm_protocal_c_aoc.wvc.vNa;
                    if (this.fvM == 10102) {
                        com_tencent_mm_protocal_c_cbc.xas = com_tencent_mm_protocal_c_aoc.wvc.wZS;
                        ((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW().a(this.appId, com_tencent_mm_protocal_c_cbc, this.fvM);
                    } else if (this.fvM == 10002) {
                        com_tencent_mm_protocal_c_cbc.xas = com_tencent_mm_protocal_c_aoc.wvc.wZR;
                        ((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW().a(this.appId, com_tencent_mm_protocal_c_cbc, this.fvM);
                    }
                }
                return jVar;
            } catch (Exception e) {
                x.e("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "preload launch data parse fail[%s]", new Object[]{this.iUg});
            }
        }
        com.tencent.mm.plugin.appbrand.dynamic.i.a.a.rA(this.appId);
        com.tencent.mm.plugin.appbrand.dynamic.i.a.a.rx(this.appId);
        com.tencent.mm.plugin.appbrand.dynamic.g.a aVar = new com.tencent.mm.plugin.appbrand.dynamic.g.a(this.appId, true, com_tencent_mm_protocal_c_cbt);
        com.tencent.mm.ae.a.a c = c.c(aVar.gJQ);
        aVar.a(c.errType, c.errCode, c.fnL, (aoc) c.fJJ);
        com.tencent.mm.plugin.appbrand.dynamic.i.a.a.ry(this.appId);
        return aVar.iUy;
    }
}
