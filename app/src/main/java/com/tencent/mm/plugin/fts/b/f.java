package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.ae.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.b;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class f extends b {
    l gJk;
    private e hnN = new 2(this);
    c mOd = new 1(this);
    String[] mOe;
    List<String> mOf;

    public final String getName() {
        return "SearchTestLogic";
    }

    protected final boolean onCreate() {
        if (((m) g.k(m.class)).isFTSContextReady()) {
            x.i("MicroMsg.FTS.FTSSearchTestLogic", "Create Success!");
            this.gJk = ((m) g.k(m.class)).getFTSTaskDaemon();
            this.mOd.ceO();
            return true;
        }
        x.i("MicroMsg.FTS.FTSSearchTestLogic", "Create Fail!");
        return false;
    }

    public final a a(com.tencent.mm.plugin.fts.a.a.g gVar) {
        a fVar;
        switch (gVar.mLR) {
            case 65521:
                fVar = new f(this, gVar.mLW);
                break;
            case 65523:
                fVar = new e(this, gVar);
                break;
            case 65524:
                fVar = new d(this, (byte) 0);
                break;
            default:
                fVar = new a(this, (byte) 0);
                break;
        }
        return this.gJk.a(-65536, fVar);
    }

    protected final boolean AZ() {
        g.CG().b(30, this.hnN);
        return false;
    }
}
