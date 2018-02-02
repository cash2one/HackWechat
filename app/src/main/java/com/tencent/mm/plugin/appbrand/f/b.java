package com.tencent.mm.plugin.appbrand.f;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends com.tencent.mm.plugin.fts.a.b {
    l gJk;
    c iVQ;
    private a iVR = new 1(this);

    public final com.tencent.mm.plugin.fts.a.a.a a(g gVar) {
        return this.gJk.a(-65536, new c(this, gVar));
    }

    protected final boolean onCreate() {
        if (((m) com.tencent.mm.kernel.g.k(m.class)).isFTSContextReady()) {
            x.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "Create Success!");
            this.iVQ = (c) ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSIndexStorage(WXMediaMessage.TITLE_LENGTH_LIMIT);
            this.gJk = ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSTaskDaemon();
            this.gJk.a(65616, new d(this));
            i.onCreate();
            i.d(this.iVR);
            return true;
        }
        x.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "Create Fail!");
        return false;
    }

    protected final boolean AZ() {
        i.onDestroy();
        i.e(this.iVR);
        this.iVQ = null;
        this.gJk = null;
        return true;
    }

    public final String getName() {
        return "FTS5SearchWeAppLogic";
    }
}
