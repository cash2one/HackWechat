package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.service.l;
import com.tencent.mm.plugin.exdevice.service.o;
import com.tencent.mm.plugin.exdevice.service.p.a;
import junit.framework.Assert;

public final class m extends a {
    private n lRp = null;
    l lRq = null;

    public m(c cVar, c cVar2) {
        Assert.assertNotNull(cVar);
        Assert.assertNotNull(cVar2);
        this.lRp = new n(cVar);
        this.lRq = new l(cVar2);
    }

    public final o aEI() {
        Assert.assertNotNull(this.lRp);
        return this.lRp;
    }

    public final l aEJ() {
        Assert.assertNotNull(this.lRq);
        return this.lRq;
    }
}
