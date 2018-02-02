package com.tencent.mm.plugin.fav;

import com.tencent.mm.g.b.em;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.fav.a.j;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.plugin.fav.a.o;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.b.c.a;
import com.tencent.mm.plugin.fav.b.c.d;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.c.uw;
import com.tencent.mm.protocal.c.vh;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.List;

public class PluginFav extends f implements b, c, r {
    private a mnJ;
    private o mnK;
    private j mnL;
    private p mnM;
    private l mnN;
    private k mnO;

    public void execute(g gVar) {
    }

    public void parallelsDependency() {
    }

    public void onAccountInitialized(e.c cVar) {
        this.mnJ = new a();
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().a("uploadfavitem", this.mnJ);
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().a("resendfavitem", this.mnJ);
        this.mnK = new d(em.wf());
        this.mnL = new a(em.wf());
        this.mnM = new com.tencent.mm.plugin.fav.b.c.e(em.wf());
        this.mnN = new com.tencent.mm.plugin.fav.b.c.c(em.wf());
        this.mnO = new com.tencent.mm.plugin.fav.b.c.b(em.wf());
        ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSTaskDaemon().a(-86016, new 1(this));
    }

    public void onAccountRelease() {
        ((m) com.tencent.mm.kernel.g.k(m.class)).unregisterIndexStorage(256);
        ((m) com.tencent.mm.kernel.g.k(m.class)).unregisterNativeLogic(6);
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().b("uploadfavitem", this.mnJ);
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().b("resendfavitem", this.mnJ);
        this.mnJ = null;
    }

    public void checkFavItem(List<uw> list) {
        ag.y(new 2(this, new com.tencent.mm.plugin.fav.b.b.a(list)));
    }

    public void checkFavItem(vh vhVar) {
        ag.y(new 3(this, new com.tencent.mm.plugin.fav.b.b.a(vhVar)));
    }

    public o getFavItemInfoStorage() {
        return this.mnK;
    }

    public j getFavCdnStorage() {
        return this.mnL;
    }

    public k getFavConfigStorage() {
        return this.mnO;
    }

    public l getFavEditInfoStorage() {
        return this.mnN;
    }

    public p getFavSearchStorage() {
        return this.mnM;
    }
}
