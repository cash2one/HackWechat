package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.qf;
import com.tencent.mm.plugin.sns.g.i;
import com.tencent.mm.plugin.sns.lucky.a.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import java.io.IOException;
import java.nio.charset.Charset;

class ae$28 extends c<qf> {
    final /* synthetic */ ae qWL;

    ae$28(ae aeVar) {
        this.qWL = aeVar;
        this.xen = qf.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        return bvL();
    }

    private static boolean bvL() {
        g.buo();
        a aVar = a.xqH;
        i iVar = new i();
        try {
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Dj().CU().a(aVar, new String(iVar.toByteArray(), Charset.forName("ISO-8859-1")));
        } catch (IOException e) {
            x.w("MicroMsg.RedDotUtil", "mardRedotList save exception:" + e.getLocalizedMessage());
        }
        return false;
    }
}
