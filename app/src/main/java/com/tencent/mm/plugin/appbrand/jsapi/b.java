package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public abstract class b {
    private String jbF;
    private Integer jbG;

    public b() {
        Assert.assertTrue("Must declare NAME and CTRL_INDEX in subclasses", true);
    }

    public final String getName() {
        if (bh.ov(this.jbF)) {
            try {
                this.jbF = (String) new c(this, "NAME", null).get();
            } catch (Throwable e) {
                x.e("MicroMsg.AppBrand.BaseJsApi", "getName exp = %s", new Object[]{bh.i(e)});
            }
        }
        return this.jbF;
    }

    public final int afq() {
        return bh.a(afr(), -1);
    }

    private Integer afr() {
        if (this.jbG == null) {
            try {
                this.jbG = (Integer) new c(this, "CTRL_INDEX", null).get();
            } catch (Throwable e) {
                x.e("MicroMsg.AppBrand.BaseJsApi", "getCtrlIndex exp = %s", new Object[]{bh.i(e)});
            }
        }
        return this.jbG;
    }
}
