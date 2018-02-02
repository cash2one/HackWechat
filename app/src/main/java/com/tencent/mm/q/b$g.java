package com.tencent.mm.q;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class b$g extends f {
    private int[] gJD;
    private int[] gJE;
    final /* synthetic */ b gJn;

    public b$g(b bVar, g gVar) {
        this.gJn = bVar;
        super(gVar);
        this.gJD = gVar.mLU;
        this.gJE = gVar.mLV;
    }

    protected final void a(h hVar) {
        String str;
        super.a(hVar);
        a aVar = this.gJn.gJl;
        String[] strArr = hVar.mMb.mLC;
        int[] iArr = this.gJD;
        int[] iArr2 = this.gJE;
        String u = d.u(strArr);
        String format = String.format(", MMHighlight(%s, %d, type, subtype)", new Object[]{aVar.aMS(), Integer.valueOf(strArr.length)});
        String str2 = "";
        String str3 = (iArr2 == null || iArr2.length <= 0) ? "" : " AND subtype IN " + d.i(iArr2);
        if (iArr == null || iArr.length <= 0) {
            str = "";
        } else {
            str = " AND type IN " + d.i(iArr);
        }
        Cursor a = aVar.mJR.a(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content" + format + " FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + str + str2 + " AND status >= 0" + str3 + ";", new Object[]{aVar.aMR(), aVar.aMR(), aVar.aMS(), aVar.aMR(), aVar.aMS(), aVar.aMS(), u}), null, null);
        HashMap hashMap = new HashMap();
        while (a.moveToNext()) {
            k h = new k().h(a);
            if (!this.mLN.mLX.contains(h.mLs)) {
                j jVar = (j) hashMap.get(Long.valueOf(h.mMf));
                if (jVar == null || d.c(c.mKt, h.mLr, jVar.mLr) < 0) {
                    h.aMY();
                    hashMap.put(Long.valueOf(h.mMf), h);
                }
            }
        }
        a.close();
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        hVar.mMc = new ArrayList();
        hVar.mMc.addAll(hashMap.values());
        if (this.mLN.mLY != null) {
            Collections.sort(hVar.mMc, this.mLN.mLY);
        }
    }

    public final String getName() {
        return "FTS5SearchFriendLogic.NormalSearchTask";
    }
}
