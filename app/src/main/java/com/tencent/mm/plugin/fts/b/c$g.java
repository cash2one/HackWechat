package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

class c$g extends f {
    final /* synthetic */ c mNG;

    public c$g(c cVar, g gVar) {
        this.mNG = cVar;
        super(gVar);
    }

    protected final void a(h hVar) {
        Bg("start");
        hVar.mMb = e.a(this.mLN.fDj, false, this.mNG.mNF);
        e an = e.an(this.mLN.mLT, true);
        HashMap hashMap = new HashMap();
        Cursor a = ((a) ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSIndexStorage(3)).a(an, this.mLN.talker, c.mKj, c.mKn);
        while (a.moveToNext()) {
            j kVar = new k();
            kVar.mLs = a.getString(0);
            kVar.type = a.getInt(1);
            kVar.mLr = a.getInt(2);
            kVar.mMb = an;
            if (!hashMap.containsKey(kVar.mLs)) {
                hashMap.put(kVar.mLs, kVar);
            }
            if (hashMap.size() > 100) {
                break;
            }
        }
        a.close();
        Bg("findHitContact");
        Cursor a2 = this.mNG.mNy.a(hVar.mMb, this.mLN.mLS, hashMap.keySet());
        HashMap hashMap2 = new HashMap();
        while (a2.moveToNext()) {
            List list;
            k f = new k().f(a2);
            f.mMb = hVar.mMb;
            if (hashMap2.containsKey(f.talker)) {
                list = (List) hashMap2.get(f.talker);
            } else {
                list = new ArrayList();
            }
            list.add(f);
            hashMap2.put(f.talker, list);
        }
        a2.close();
        hVar.mMc = new ArrayList();
        for (Entry entry : hashMap2.entrySet()) {
            kVar = (j) hashMap.get(entry.getKey());
            if (kVar != null) {
                Collections.sort((List) entry.getValue(), this.mLN.mLY);
                kVar.userData = entry.getValue();
                kVar.timestamp = ((j) ((List) entry.getValue()).get(0)).timestamp;
                hVar.mMc.add(kVar);
            }
        }
        Collections.sort(hVar.mMc, this.mLN.mLY);
        Bg("findHitMessage");
    }

    public final String getName() {
        return "SearchConvTalkerMessageTask";
    }

    public final int getId() {
        return 29;
    }
}
