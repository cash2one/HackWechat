package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class c$i extends f {
    final /* synthetic */ c mNG;

    private class a {
        int mLr;
        String mLs;
        long mMf;
        final /* synthetic */ c$i mNR;
        long timestamp;
        int type;

        private a(c$i com_tencent_mm_plugin_fts_b_c_i) {
            this.mNR = com_tencent_mm_plugin_fts_b_c_i;
        }
    }

    public c$i(c cVar, g gVar) {
        this.mNG = cVar;
        super(gVar);
    }

    protected final void a(h hVar) {
        Bg("start");
        hVar.mMb = e.a(this.mLN.fDj, false, this.mNG.mNF);
        com.tencent.mm.plugin.fts.a.a aVar = this.mNG.mNy;
        String aMX = hVar.mMb.aMX();
        Cursor rawQuery = aVar.mJR.rawQuery(String.format("SELECT type, subtype, entity_id, aux_index, timestamp FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 ORDER BY timestamp desc;", new Object[]{aVar.aMR(), aVar.aMS(), aVar.aMR(), aVar.aMS(), aVar.aMS(), aMX}), null);
        List<a> arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        List arrayList2 = new ArrayList();
        while (rawQuery.moveToNext()) {
            String string = rawQuery.getString(3);
            if (hashSet.add(string)) {
                a aVar2 = new a();
                aVar2.type = rawQuery.getInt(0);
                aVar2.mLr = rawQuery.getInt(1);
                aVar2.mMf = rawQuery.getLong(2);
                aVar2.mLs = rawQuery.getString(3);
                aVar2.timestamp = rawQuery.getLong(4);
                arrayList.add(aVar2);
                arrayList2.add(string);
            }
            if (arrayList.size() > this.mLN.mLW) {
                break;
            }
        }
        rawQuery.close();
        hVar.mMc = new LinkedList();
        Bg("findUsername");
        if (arrayList2.size() > 0) {
            Cursor a = this.mNG.mNy.a(hVar.mMb, arrayList2);
            HashMap hashMap = new HashMap();
            if (a.moveToNext()) {
                String[] split = a.getString(0).split(" ");
                for (int i = 0; i < split.length; i += 2) {
                    hashMap.put(split[i], Integer.valueOf(split[i + 1]));
                }
            }
            a.close();
            for (a aVar3 : arrayList) {
                j jVar = new j();
                jVar.type = aVar3.type;
                jVar.mLr = aVar3.mLr;
                jVar.mMf = aVar3.mMf;
                jVar.mLs = aVar3.mLs;
                jVar.timestamp = aVar3.timestamp;
                if (hashMap.containsKey(jVar.mLs)) {
                    jVar.userData = hashMap.get(jVar.mLs);
                } else {
                    jVar.userData = Integer.valueOf(1);
                }
                hVar.mMc.add(jVar);
            }
            Bg("findCount");
        }
        if (hVar.mMb.mLD.length > 1 && hVar.mMc.size() <= 3) {
            rawQuery = ((com.tencent.mm.plugin.fts.c.a) ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSIndexStorage(3)).a(e.an(hVar.mMb.mLD[0], true), null, c.mKj, c.mKn);
            if (rawQuery.moveToNext()) {
                j jVar2 = new j();
                jVar2.mLs = "create_talker_message​";
                hVar.mMc.add(jVar2);
            }
            rawQuery.close();
            Bg("findTalkerConversation");
        }
    }

    public final String getName() {
        return "SearchLimitGroupMessage";
    }

    public final int getId() {
        return 24;
    }
}
