package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.service.o.a;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class n extends a {
    private c lQT = null;

    public n(c cVar) {
        Assert.assertNotNull(cVar);
        this.lQT = cVar;
    }

    public final long aED() {
        x.i("MicroMsg.exdevice.RemoteExDeviceTaskRequest", "getDeviceId : " + this.lQT.kAq);
        return this.lQT.kAq;
    }

    public final byte[] aEE() {
        return this.lQT.aDI();
    }

    public final int aEF() {
        return this.lQT.aDG();
    }

    public final int aEG() {
        return this.lQT.lKa;
    }

    public final int aEH() {
        return this.lQT.aDH();
    }
}
