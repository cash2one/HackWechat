package com.tencent.mm.z;

import com.tencent.mm.ae.d;
import com.tencent.mm.ae.d.a;
import com.tencent.mm.ae.d.b;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import junit.framework.Assert;

public final class bl implements d {
    public final b b(a aVar) {
        boolean z = true;
        bw bwVar = aVar.hmq;
        Assert.assertTrue(bwVar != null);
        if (bwVar.vGZ == null) {
            z = false;
        }
        Assert.assertTrue(z);
        String str = (String) bi.y(n.a(bwVar.vGZ), "tips").get(".tips.tip.url");
        x.v("MicroMsg.SoftwareMsgExtension", "url:" + str);
        ar.Hg();
        c.CU().set(12308, str);
        return null;
    }

    public final void h(au auVar) {
    }
}
