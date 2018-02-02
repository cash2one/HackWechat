package com.tencent.mm.plugin.b;

import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.z.a.d;
import com.tencent.mm.z.a.g;
import com.tencent.mm.z.p;

public final class a extends p implements c {
    private static a iky;
    private com.tencent.mm.z.a.a ikA = new com.tencent.mm.z.a.a();
    private d ikz = new d();

    private a() {
        super(g.class);
    }

    public static synchronized a Xl() {
        a aVar;
        synchronized (a.class) {
            if (iky == null) {
                iky = new a();
            }
            aVar = iky;
        }
        return aVar;
    }

    public final void onAccountInitialized(e.c cVar) {
        super.onAccountInitialized(cVar);
        com.tencent.mm.ae.d.c.a(Integer.valueOf(-1879048184), this.ikz);
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().a("abtest", this.ikA);
    }

    public final void onAccountRelease() {
        super.onAccountRelease();
        com.tencent.mm.ae.d.c.a(Integer.valueOf(-1879048184), this.ikz);
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().b("abtest", this.ikA);
    }
}
