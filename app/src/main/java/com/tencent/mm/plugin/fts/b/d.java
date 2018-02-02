package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class d extends com.tencent.mm.plugin.fts.a.b {
    private l gJk;
    com.tencent.mm.plugin.fts.c.d mNU;

    public class b extends a {
        final /* synthetic */ d mNW;

        public b(d dVar) {
            this.mNW = dVar;
        }

        public final boolean execute() {
            this.mNW.mNU.mJR.execSQL(String.format("DELETE FROM %s ;", new Object[]{com.tencent.mm.plugin.fts.c.d.aMR()}));
            return true;
        }

        public final String getName() {
            return "DeleteSOSHistoryTask";
        }
    }

    public class d extends f {
        final /* synthetic */ d mNW;

        public d(d dVar, g gVar) {
            this.mNW = dVar;
            super(gVar);
        }

        protected final void a(h hVar) {
            Cursor rawQuery;
            super.a(hVar);
            hVar.mMc = new ArrayList();
            com.tencent.mm.plugin.fts.c.d dVar = this.mNW.mNU;
            String str = this.mLN.fDj;
            int i = this.mLN.mLW;
            if (str.trim().length() > 0) {
                str = com.tencent.mm.plugin.fts.a.d.u(new String[]{str});
                rawQuery = dVar.mJR.rawQuery(String.format("SELECT history FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' ORDER BY timestamp desc LIMIT " + i, new Object[]{com.tencent.mm.plugin.fts.c.d.aMR(), com.tencent.mm.plugin.fts.c.d.aMS(), com.tencent.mm.plugin.fts.c.d.aMR(), com.tencent.mm.plugin.fts.c.d.aMS(), com.tencent.mm.plugin.fts.c.d.aMS(), str}), null);
            } else {
                rawQuery = dVar.mJR.rawQuery(String.format("SELECT history FROM %s ORDER BY timestamp desc LIMIT " + i, new Object[]{com.tencent.mm.plugin.fts.c.d.aMR()}), null);
            }
            while (rawQuery != null && rawQuery.moveToNext()) {
                str = rawQuery.getString(0);
                j kVar = new k();
                kVar.content = str;
                hVar.mMc.add(kVar);
            }
            rawQuery.close();
        }

        public final String getName() {
            return "SearchSOSHistoryTask";
        }
    }

    public final String getName() {
        return "FTS5SearchSOSHistoryLogic";
    }

    protected final boolean onCreate() {
        if (((m) com.tencent.mm.kernel.g.k(m.class)).isFTSContextReady()) {
            x.i("MicroMsg.FTS.FTS5SearchSOSHistoryLogic", "Create Success!");
            this.mNU = (com.tencent.mm.plugin.fts.c.d) ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSIndexStorage(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            this.gJk = ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSTaskDaemon();
            return true;
        }
        x.i("MicroMsg.FTS.FTS5SearchSOSHistoryLogic", "Create Fail!");
        return false;
    }

    public final void addSOSHistory(String str) {
        a aVar = new a(this);
        aVar.mNV = str;
        this.gJk.a(132072, aVar);
    }

    public final void deleteSOSHistory() {
        this.gJk.a(132072, new b(this));
    }

    public final void deleteSOSHistory(String str) {
        a cVar = new c(this);
        cVar.mNV = str;
        this.gJk.a(132072, cVar);
    }

    public final a a(g gVar) {
        a dVar = new d(this, gVar);
        this.gJk.a(-65536, dVar);
        return dVar;
    }

    protected final boolean AZ() {
        this.mNU = null;
        this.gJk = null;
        return true;
    }
}
