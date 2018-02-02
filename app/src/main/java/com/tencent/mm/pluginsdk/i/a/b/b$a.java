package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.i.a.d.g;
import com.tencent.mm.pluginsdk.i.a.d.h;
import com.tencent.mm.pluginsdk.i.a.d.k;
import com.tencent.mm.pluginsdk.i.a.d.m$a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bs.a;

public final class b$a implements g {
    private final a ttH = new 2(this);
    private final c vgH = new 1(this);
    private final h vgI = new h();

    public final void bRs() {
        com.tencent.mm.sdk.b.a.xef.b(this.vgH);
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().a("resourcemgr", this.ttH, true);
        com.tencent.mm.kernel.g.Dm().g(new 3(this), 10000);
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.xef.c(this.vgH);
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().b("resourcemgr", this.ttH, true);
    }

    public final String aab() {
        return "CheckResUpdate";
    }

    public final m$a c(k kVar) {
        if (kVar instanceof c) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "return CheckResUpdateNetworkRequestHandler");
            return new d((c) kVar);
        }
        x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "get mismatch NetworkRequest type, return null");
        return null;
    }

    public final h bRt() {
        return this.vgI;
    }
}
