package com.tencent.mm.ui.account;

import com.tencent.mm.modelsimple.v;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.applet.SecurityImage$b;
import com.tencent.mm.z.ar;

public final class f extends SecurityImage$b {
    private static f xPu = null;
    public String hNv = null;
    public String xPo = null;
    public String xPp = null;
    public String xPq = null;
    public String xPr = null;
    public byte[] xPs = null;
    public int xPt = 0;

    public final void cnJ() {
        if (bh.ov(this.xPp)) {
            ar.CG().a(new v(this.hNv, this.xPo, this.xWv.xPt, "", "", "", 0, "", false, false), 0);
            return;
        }
        ar.CG().a(new v(this.hNv, this.xPp, this.xWv.xPt, "", "", "", 0, "", false, true), 0);
    }

    public static void a(f fVar) {
        xPu = fVar;
    }

    public static String cnT() {
        if (xPu != null) {
            return xPu.hNv;
        }
        return null;
    }

    public static String cnU() {
        if (xPu != null) {
            return xPu.xPo;
        }
        return null;
    }
}
