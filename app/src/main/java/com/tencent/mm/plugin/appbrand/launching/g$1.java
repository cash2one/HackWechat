package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.r.b;
import com.tencent.mm.plugin.appbrand.jsapi.version.a;
import com.tencent.mm.sdk.platformtools.x;

class g$1 implements b<WxaAttributes> {
    final /* synthetic */ g jxL;

    g$1(g gVar) {
        this.jxL = gVar;
    }

    public final /* synthetic */ void d(int i, Object obj) {
        WxaAttributes wxaAttributes = (WxaAttributes) obj;
        WxaAttributes wxaAttributes2 = this.jxL.jxJ;
        if (wxaAttributes.acb().iPF != 0) {
            this.jxL.jxK.b(a.jrL);
        } else if (wxaAttributes2.acb().fIm >= wxaAttributes.acb().fIm) {
            this.jxL.jxK.b(a.jrL);
        } else {
            WxaPkgWrappingInfo ada;
            this.jxL.jxK.b(a.jrK);
            try {
                ada = new aa(wxaAttributes.field_appId, 0, "", this.jxL.iOd, wxaAttributes.acb()).ada();
            } catch (Exception e) {
                x.e("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", "%s, prepare pkg exp = %s", new Object[]{wxaAttributes.field_appId, e});
                ada = null;
            }
            this.jxL.jxK.b(ada == null ? a.jrN : a.jrM);
        }
    }
}
