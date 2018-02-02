package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.bottle.a.h.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ar;
import junit.framework.Assert;

public class h$c implements e {
    private a kAP = null;
    private int kAS = 0;

    public h$c(String str, a aVar) {
        boolean z;
        Assert.assertTrue("emtpy input text", !bh.ov(str));
        String str2 = "must call back onFin";
        if (aVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(str2, z);
        if (c.ary() > 0) {
            ar.CG().a(JsApiMakeVoIPCall.CTRL_INDEX, this);
            this.kAP = aVar;
            ar.CG().a(new g(str), 0);
        } else if (aVar != null) {
            aVar.cd(1, 16);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == JsApiMakeVoIPCall.CTRL_INDEX) {
            if (this.kAP != null) {
                this.kAS = ((g) kVar).arE();
                this.kAP.cd(i, i2);
            }
            this.kAP = null;
            ar.CG().b(JsApiMakeVoIPCall.CTRL_INDEX, this);
        }
    }
}
