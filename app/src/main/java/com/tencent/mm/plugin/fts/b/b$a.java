package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class b$a extends a {
    final /* synthetic */ b mNv;
    private int mNw;
    private int mNx;

    private b$a(b bVar) {
        this.mNv = bVar;
    }

    public final boolean execute() {
        x.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "start to build feature index task");
        com.tencent.mm.plugin.fts.a.a aVar = this.mNv.mNt;
        List arrayList = new ArrayList();
        Cursor rawQuery = aVar.mJR.rawQuery(String.format("SELECT * FROM Feature", new Object[0]), null);
        while (rawQuery.moveToNext()) {
            c cVar = new c();
            cVar.b(rawQuery);
            arrayList.add(cVar);
        }
        rawQuery.close();
        if (arrayList.size() == 0) {
            try {
                arrayList = b.a(this.mNv, b.aNb().getAbsolutePath());
                this.mNv.mNt.aT(arrayList);
            } catch (Exception e) {
            }
        }
        List<com.tencent.mm.plugin.fts.c.b$a> aNk = this.mNv.mNt.aNk();
        HashMap hashMap = new HashMap();
        for (c cVar2 : r0) {
            hashMap.put(Integer.valueOf(cVar2.field_featureId), cVar2);
        }
        if (this.mNv.mNt.mJR.inTransaction()) {
            this.mNv.mNt.commit();
        }
        this.mNv.mNt.beginTransaction();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (com.tencent.mm.plugin.fts.c.b$a com_tencent_mm_plugin_fts_c_b_a : aNk) {
            c cVar3 = (c) hashMap.remove(Integer.valueOf(com_tencent_mm_plugin_fts_c_b_a.mOr));
            if (cVar3 == null) {
                hashSet.add(Integer.valueOf(com_tencent_mm_plugin_fts_c_b_a.mOr));
            } else if (com_tencent_mm_plugin_fts_c_b_a.timestamp != cVar3.field_timestamp) {
                hashSet2.add(cVar3);
                this.mNv.mNt.b(com.tencent.mm.plugin.fts.a.c.mKc, Long.valueOf((long) cVar3.field_featureId).longValue());
                ((PluginFTS) g.k(PluginFTS.class)).getTopHitsLogic().c(com.tencent.mm.plugin.fts.a.c.mKc, String.valueOf(cVar3.field_featureId));
            }
        }
        hashSet2.addAll(hashMap.values());
        this.mNv.mNt.commit();
        this.mNv.mNt.beginTransaction();
        this.mNw = hashSet.size();
        this.mNx = hashSet2.size();
        Iterator it = hashSet2.iterator();
        while (it.hasNext()) {
            c cVar4 = (c) it.next();
            b bVar = this.mNv;
            bVar.mNt.a(262144, 1, (long) cVar4.field_featureId, String.valueOf(cVar4.field_featureId), cVar4.field_timestamp, cVar4.field_title);
            String am = d.am(cVar4.field_title, false);
            if (!bh.ov(am)) {
                bVar.mNt.a(262144, 2, (long) cVar4.field_featureId, String.valueOf(cVar4.field_featureId), cVar4.field_timestamp, am);
            }
            am = d.am(cVar4.field_title, true);
            if (!bh.ov(am)) {
                bVar.mNt.a(262144, 3, (long) cVar4.field_featureId, String.valueOf(cVar4.field_featureId), cVar4.field_timestamp, am);
            }
            bVar.mNt.a(262144, 4, (long) cVar4.field_featureId, String.valueOf(cVar4.field_featureId), cVar4.field_timestamp, cVar4.field_tag);
            ((PluginFTS) g.k(PluginFTS.class)).getTopHitsLogic().Bm(String.valueOf(cVar4.field_featureId));
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            this.mNv.mNt.b(com.tencent.mm.plugin.fts.a.c.mKc, Long.valueOf((long) ((Integer) it2.next()).intValue()).longValue());
        }
        this.mNv.mNt.commit();
        return true;
    }

    public final String ado() {
        return String.format("{remove: %d add: %d}", new Object[]{Integer.valueOf(this.mNw), Integer.valueOf(this.mNx)});
    }

    public final String getName() {
        return "BuildFeatureIndexTask";
    }

    public final int getId() {
        return 5;
    }
}
