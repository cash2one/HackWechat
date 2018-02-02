package com.tencent.mm.plugin.appbrand.ui.recents;

import android.database.Cursor;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.appbrand.appusage.j;
import com.tencent.mm.plugin.appbrand.appusage.j.1;
import com.tencent.mm.plugin.appbrand.appusage.j.a;
import com.tencent.mm.plugin.appbrand.appusage.q;
import com.tencent.mm.plugin.appbrand.ui.recents.a.d;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

class a$d$2 implements Runnable {
    final /* synthetic */ d jPE;
    final /* synthetic */ i jPF;

    a$d$2(d dVar, i iVar) {
        this.jPE = dVar;
        this.jPF = iVar;
    }

    public final void run() {
        int i;
        if (this.jPF.iJL) {
            f.Zn().h(this.jPF.fnl, this.jPF.iGA, true);
            f.Zm().a(this.jPF.fnl, this.jPF.iGA, false, 0, 2, null);
            i = 2;
        } else {
            j Zn = f.Zn();
            String str = this.jPF.fnl;
            int i2 = this.jPF.iGA;
            if (!bh.ov(str)) {
                Object obj = null;
                long Wo = bh.Wo();
                if (Zn.an(str, i2)) {
                    obj = 1;
                } else {
                    c aVar = new a();
                    aVar.field_username = str;
                    aVar.field_versionType = i2;
                    aVar.field_updateTime = Wo;
                    Zn.iJM.a(aVar, false);
                    if (Zn.an(str, i2)) {
                        Zn.b("single", 2, aVar);
                        obj = 1;
                    }
                }
                if (obj != null) {
                    Cursor query = Zn.iGs.query("AppBrandStarApp", new String[]{"rowid"}, null, null, null, null, String.format(Locale.US, "%s desc limit %d offset %d", new Object[]{"updateTime", Long.valueOf(Long.MAX_VALUE), Integer.valueOf(Zn.iJN)}));
                    if (query != null) {
                        Object obj2;
                        if (query.moveToFirst()) {
                            LinkedList linkedList = new LinkedList();
                            do {
                                linkedList.add(String.valueOf(query.getLong(0)));
                            } while (query.moveToNext());
                            obj2 = linkedList;
                        } else {
                            obj2 = null;
                        }
                        query.close();
                        if (!bh.cA(obj2)) {
                            String[] strArr = new String[1];
                            long dz = Zn.iGs.dz(Thread.currentThread().getId());
                            Iterator it = obj2.iterator();
                            while (it.hasNext()) {
                                strArr[0] = (String) it.next();
                                Zn.iGs.delete("AppBrandStarApp", "rowid=?", strArr);
                            }
                            Zn.iGs.fS(dz);
                            Zn.b("batch", 5, obj2);
                        }
                    }
                    q qVar = new q(1003, false, i2, 1, 1, str, 1, null);
                    qVar.iKl = new 1(Zn, str, i2, Wo);
                    qVar.JV();
                }
            }
            i = 1;
        }
        com.tencent.mm.plugin.appbrand.report.a.a(this.jPF.appId, this.jPF.iGA + 1, i, 1, a.t(this.jPE.jPj));
    }
}
