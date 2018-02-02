package com.tencent.mm.plugin.game.gamewebview.jsapi;

import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public class b {
    private String jbF;
    private Integer mWc;
    private Integer mWd;

    public b() {
        Assert.assertTrue("Must declare NAME and CTRL_BYTE in subclasses", true);
    }

    public final String getName() {
        if (bh.ov(this.jbF)) {
            try {
                this.jbF = (String) new c(this, "NAME", null).get();
            } catch (Throwable e) {
                x.e("MicroMsg.GameBaseJsApii", "getName exp = %s", new Object[]{bh.i(e)});
            }
        }
        return this.jbF;
    }

    public final int aOI() {
        return bh.a(aOJ(), -1);
    }

    private Integer aOJ() {
        if (this.mWc == null) {
            try {
                this.mWc = (Integer) new c(this, "CTRL_BYTE", null).get();
            } catch (Throwable e) {
                x.e("MicroMsg.GameBaseJsApii", "getCtrlByte exp = %s", new Object[]{bh.i(e)});
            }
        }
        return this.mWc;
    }

    public final int aOK() {
        return bh.a(aOL(), 0);
    }

    private Integer aOL() {
        if (this.mWd == null) {
            try {
                this.mWd = (Integer) new c(this, "DO_IN_ENV", null).get();
            } catch (Exception e) {
                this.mWd = null;
            }
        }
        return this.mWd;
    }
}
