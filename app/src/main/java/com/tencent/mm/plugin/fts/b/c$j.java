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

class c$j extends f {
    final /* synthetic */ c mNG;

    public c$j(c cVar, g gVar) {
        this.mNG = cVar;
        super(gVar);
    }

    protected final void a(h hVar) {
        Bg("start");
        hVar.mMb = e.a(this.mLN.fDj, false, this.mNG.mNF);
        e an = e.an(this.mLN.mLT, true);
        HashMap hashMap = new HashMap();
        Cursor a = ((a) ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSIndexStorage(3)).a(an, null, c.mKj, c.mKn);
        while (a.moveToNext()) {
            k kVar = new k();
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
        Cursor a2 = this.mNG.mNy.a(hVar.mMb, null, hashMap.keySet());
        HashMap hashMap2 = new HashMap();
        while (a2.moveToNext()) {
            HashMap hashMap3;
            j jVar;
            k f = new k().f(a2);
            f.mMb = hVar.mMb;
            f.userData = Integer.valueOf(1);
            if (hashMap2.containsKey(f.talker)) {
                hashMap3 = (HashMap) hashMap2.get(f.talker);
            } else {
                hashMap3 = new HashMap();
            }
            if (hashMap3.containsKey(f.mLs)) {
                jVar = (j) hashMap3.get(f.mLs);
                int intValue = ((Integer) jVar.userData).intValue() + 1;
                if (jVar.timestamp < f.timestamp) {
                    f.userData = Integer.valueOf(intValue);
                    hashMap3.put(f.mLs, f);
                } else {
                    jVar.userData = Integer.valueOf(intValue);
                    hashMap3.put(jVar.mLs, jVar);
                }
            } else {
                hashMap3.put(f.mLs, f);
            }
            hashMap2.put(f.talker, hashMap3);
        }
        a2.close();
        hVar.mMc = new ArrayList();
        for (j jVar2 : hashMap.values()) {
            if (hashMap2.containsKey(jVar2.mLs)) {
                List arrayList = new ArrayList();
                arrayList.addAll(((HashMap) hashMap2.get(jVar2.mLs)).values());
                Collections.sort(arrayList, this.mLN.mLY);
                jVar2.userData = arrayList;
                jVar2.timestamp = ((j) arrayList.get(0)).timestamp;
                hVar.mMc.add(jVar2);
            }
        }
        Collections.sort(hVar.mMc, this.mLN.mLY);
        Bg("findHitMessage");
    }

    public final String getName() {
        return "SearchTalkerMessageTask";
    }

    public final int getId() {
        return 28;
    }
}
