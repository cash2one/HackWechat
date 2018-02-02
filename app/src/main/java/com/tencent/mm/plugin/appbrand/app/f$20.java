package com.tencent.mm.plugin.appbrand.app;

import com.tencent.mm.g.a.bq;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;

class f$20 extends c<bq> {
    final /* synthetic */ f iDI;

    f$20(f fVar) {
        this.iDI = fVar;
        this.xen = bq.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bq bqVar = (bq) bVar;
        if (!bh.ov(bqVar.fpJ.username)) {
            WxaAttributes e = f.Zh().e(bqVar.fpJ.username, new String[]{"roundedSquareIconURL", "bigHeadURL", "appId", "nickname"});
            if (e != null) {
                String[] strArr = new String[]{e.field_roundedSquareIconURL, e.field_bigHeadURL};
                bqVar.fpK.fpM = strArr;
                bqVar.fpK.appId = e.field_appId;
                bqVar.fpK.fpL = e.field_nickname;
            }
        }
        return true;
    }
}
