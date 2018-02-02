package com.tencent.mm.plugin.x;

import com.tencent.mm.ae.k;
import com.tencent.mm.aw.b;
import com.tencent.mm.aw.e;
import com.tencent.mm.aw.f;
import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.az;
import com.tencent.mm.z.p;
import java.util.HashMap;

public final class a extends p implements com.tencent.mm.kernel.api.bucket.a, c {
    private static HashMap<Integer, d> gwY;
    private static a oRp;
    private com.tencent.mm.aw.d oRq = null;
    private az oRr = null;
    private com.tencent.mm.aw.c oRs = null;
    private e oRt = new e();
    private final com.tencent.mm.ae.e oRu = new com.tencent.mm.ae.e(this) {
        final /* synthetic */ a oRv;

        {
            this.oRv = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
        }
    };

    private a() {
        super(f.class);
    }

    public static synchronized a bfl() {
        a aVar;
        synchronized (a.class) {
            if (oRp == null) {
                oRp = new a();
            }
            aVar = oRp;
        }
        return aVar;
    }

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("NEWTIPS_TABLE".hashCode()), new 2());
    }

    public final void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        super.onAccountInitialized(cVar);
        ((n) g.k(n.class)).getSysCmdMsgExtension().a("newtips", this.oRt);
        g.CG().a(597, this.oRu);
        bfm();
        com.tencent.mm.aw.d.a(b.hId, 1, b.hIc, "", b.hIk);
        x.i("MicroMsg.NewTipsManager", "dancy register dynamic newtips, tipsId:%s, path:%s", new Object[]{Integer.valueOf(r0), r1});
    }

    public final void onAccountRelease() {
        super.onAccountRelease();
        ((n) g.k(n.class)).getSysCmdMsgExtension().b("newtips", this.oRt);
        g.CG().b(597, this.oRu);
    }

    public static com.tencent.mm.aw.d bfm() {
        g.Dh().Ct();
        if (bfl().oRq == null) {
            bfl().oRq = new com.tencent.mm.aw.d();
        }
        return bfl().oRq;
    }

    public static az bfn() {
        g.Dh().Ct();
        if (bfl().oRr == null) {
            a bfl = bfl();
            g.Dk();
            bfl.oRr = new az(g.Dj().gQj);
        }
        return bfl().oRr;
    }

    public static com.tencent.mm.aw.c bfo() {
        g.Dh().Ct();
        if (bfl().oRs == null) {
            bfl().oRs = new com.tencent.mm.aw.c();
        }
        return bfl().oRs;
    }

    public final HashMap<Integer, d> collectDatabaseFactory() {
        return gwY;
    }
}
