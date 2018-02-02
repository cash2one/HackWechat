package com.tencent.mm.plugin.bottle.a;

import android.content.Context;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.e.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.bottle.a.h.a;
import com.tencent.mm.z.ar;
import junit.framework.Assert;

public class h$d extends h implements e {
    public a kAP = null;
    private int kAS = 0;

    public h$d(Context context, a aVar) {
        boolean z = false;
        super(context, false);
        String str = "must call back onFin";
        if (aVar != null) {
            z = true;
        }
        Assert.assertTrue(str, z);
        ar.CG().a((int) JsApiMakeVoIPCall.CTRL_INDEX, (e) this);
        this.kAP = aVar;
    }

    public final boolean vo() {
        String fileName = super.getFileName();
        boolean vo = super.vo();
        super.reset();
        if (!vo) {
            ar.CG().b((int) JsApiMakeVoIPCall.CTRL_INDEX, (e) this);
            this.kAP = null;
            return false;
        } else if (c.ary() > 0) {
            ar.CG().a(new g(fileName, this.flB), 0);
            return true;
        } else {
            ar.CG().b((int) JsApiMakeVoIPCall.CTRL_INDEX, (e) this);
            if (this.kAP == null) {
                return false;
            }
            this.kAP.cd(1, 16);
            return false;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == JsApiMakeVoIPCall.CTRL_INDEX) {
            if (this.kAP != null) {
                this.kAS = ((g) kVar).arE();
                this.kAP.cd(i, i2);
            }
            this.kAP = null;
            ar.CG().b((int) JsApiMakeVoIPCall.CTRL_INDEX, (e) this);
        }
    }
}
