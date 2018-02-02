package com.tencent.mm.plugin.setting.a;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class a$3 implements k {
    final /* synthetic */ long gyu;
    final /* synthetic */ a qgt;
    final /* synthetic */ HashSet qgv;
    final /* synthetic */ long qgw;

    a$3(a aVar, HashSet hashSet, long j, long j2) {
        this.qgt = aVar;
        this.qgv = hashSet;
        this.qgw = j;
        this.gyu = j2;
    }

    public final void b(h hVar) {
        List<j> list = hVar.mMc;
        if (list != null) {
            for (j jVar : list) {
                this.qgv.remove(jVar.mLs);
                this.qgt.qgo.add(jVar.mLs);
            }
        }
        Iterator it = this.qgv.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            ar.Hg();
            if (c.Fa().l(str, this.qgw, System.currentTimeMillis()) > 0) {
                x.i("MicroMsg.UnfamiliarContactEngine", "[getHalfYearNotChatInfo] talker:%s voipCount:%s", new Object[]{str, Integer.valueOf(c.Fa().l(str, this.qgw, System.currentTimeMillis()))});
            } else {
                ar.Hg();
                Cursor a = c.Fa().a(str, this.qgw, System.currentTimeMillis(), true);
                if (a.getCount() > 0) {
                    ar.Hg();
                    Cursor a2 = c.Fa().a(str, this.qgw, System.currentTimeMillis(), false);
                    if (a2.getCount() <= 0) {
                        this.qgt.qgo.add(str);
                    }
                    a2.close();
                } else {
                    this.qgt.qgo.add(str);
                }
                a.close();
            }
        }
        x.i("MicroMsg.UnfamiliarContactEngine", "[getHalfYearNotChatInfo] query:%s cost:%sms", new Object[]{Long.valueOf(this.qgw), Long.valueOf(System.currentTimeMillis() - this.gyu)});
        this.qgt.qgm.countDown();
    }
}
