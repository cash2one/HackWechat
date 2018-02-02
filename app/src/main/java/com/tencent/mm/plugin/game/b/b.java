package com.tencent.mm.plugin.game.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class b extends com.tencent.mm.plugin.fts.a.b {
    l gJk;
    private a iVR = new 1(this);
    a mVJ;

    class b extends com.tencent.mm.plugin.fts.a.a.a {
        private String appId;
        final /* synthetic */ b mVK;
        private String name;

        public b(b bVar, String str) {
            this.mVK = bVar;
            this.appId = str;
        }

        public final boolean execute() {
            f RF = com.tencent.mm.plugin.y.a.a.a.bis().biq().RF(this.appId);
            if (RF != null && RF.Yz()) {
                this.mVK.mVJ.beginTransaction();
                this.mVK.mVJ.a(c.mKd, this.appId);
                this.mVK.mVJ.a(327680, 1, 0, RF.field_appId, System.currentTimeMillis(), RF.field_appName);
                this.mVK.mVJ.commit();
                this.name = RF.field_appName;
            }
            return true;
        }

        public final String ado() {
            return String.format("{name: %s appId: %s}", new Object[]{this.name, this.appId});
        }

        public final String getName() {
            return "InsertGameTask";
        }
    }

    class d extends com.tencent.mm.plugin.fts.a.a.a {
        private int iVT;
        final /* synthetic */ b mVK;

        d(b bVar) {
            this.mVK = bVar;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean execute() {
            LinkedList linkedList = new LinkedList();
            Cursor bYJ = com.tencent.mm.plugin.y.a.a.a.bis().biq().bYJ();
            if (bYJ == null) {
                x.i("MicroMsg.FTS.FTS5SearchGameLogic", "Game cursor is null!");
            } else {
                if (bYJ.moveToFirst()) {
                    do {
                        f fVar = new f();
                        fVar.b(bYJ);
                        linkedList.add(fVar);
                    } while (bYJ.moveToNext());
                }
                if (bYJ != null) {
                    bYJ.close();
                }
                this.mVK.mVJ.beginTransaction();
                this.mVK.mVJ.h(c.mKd);
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    f fVar2 = (f) it.next();
                    this.mVK.mVJ.a(327680, 1, 0, fVar2.field_appId, System.currentTimeMillis(), fVar2.field_appName);
                }
                this.mVK.mVJ.commit();
                this.iVT = linkedList.size();
            }
            return true;
        }

        public final String ado() {
            return String.format("{updateSize: %d}", new Object[]{Integer.valueOf(this.iVT)});
        }

        public final String getName() {
            return "UpdateGameIndexTask";
        }

        public final int getId() {
            return 7;
        }
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(g gVar) {
        return this.gJk.a(-65536, new c(this, gVar));
    }

    protected final boolean onCreate() {
        if (((m) com.tencent.mm.kernel.g.k(m.class)).isFTSContextReady()) {
            x.i("MicroMsg.FTS.FTS5SearchGameLogic", "Create Success!");
            this.mVJ = (a) ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSIndexStorage(16);
            this.gJk = ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSTaskDaemon();
            this.gJk.a(65606, new d(this));
            com.tencent.mm.plugin.y.a.a.a.bis().biq().c(this.iVR);
            return true;
        }
        x.i("MicroMsg.FTS.FTS5SearchGameLogic", "Create Fail!");
        return false;
    }

    protected final boolean AZ() {
        com.tencent.mm.plugin.y.a.a.a.bis().biq().j(this.iVR);
        this.mVJ = null;
        this.gJk = null;
        return true;
    }

    public final String getName() {
        return "FTS5SearchGameLogic";
    }
}
