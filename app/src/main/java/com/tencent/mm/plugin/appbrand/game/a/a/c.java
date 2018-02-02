package com.tencent.mm.plugin.appbrand.game.a.a;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class c extends i<b> {
    public static final String[] iEK = new String[]{i.a(b.gJc, "WxagGameInfo")};
    private final boolean iYd;

    public c(e eVar) {
        super(eVar, b.gJc, "WxagGameInfo", null);
        this.iYd = eVar != null;
        if (!this.iYd) {
            x.e("MicroMsg.MiniGameInfoStorage", "storage can not work!!!");
        }
    }

    public final List<b> aeb() {
        List<b> list = null;
        if (this.iYd) {
            Cursor rawQuery = rawQuery(String.format("select * from %s", new Object[]{"WxagGameInfo"}), new String[0]);
            x.i("MicroMsg.MiniGameInfoStorage", "getMiniGameList queryStr:%s", new Object[]{r1});
            if (rawQuery == null) {
                x.i("MicroMsg.MiniGameInfoStorage", "cursor is null");
            } else if (rawQuery.moveToFirst()) {
                list = new ArrayList();
                do {
                    b bVar = new b();
                    bVar.b(rawQuery);
                    list.add(bVar);
                } while (rawQuery.moveToNext());
                rawQuery.close();
                x.i("MicroMsg.MiniGameInfoStorage", "record list size:%s", new Object[]{Integer.valueOf(list.size())});
            } else {
                rawQuery.close();
                x.i("MicroMsg.MiniGameInfoStorage", "no record");
            }
        }
        return list;
    }

    public final b rH(String str) {
        if (!this.iYd || bh.ov(str)) {
            return null;
        }
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=?", new Object[]{"WxagGameInfo", "RecordId"}), new String[]{str});
        if (rawQuery.moveToFirst()) {
            b bVar = new b();
            bVar.b(rawQuery);
            rawQuery.close();
            return bVar;
        }
        x.i("MicroMsg.MiniGameInfoStorage", "getMiniGame recordId:%s, no record in DB", new Object[]{str});
        rawQuery.close();
        return null;
    }

    public final void c(a aVar) {
        a(aVar, com.tencent.mm.plugin.appbrand.q.c.Dm().oAt.getLooper());
    }

    public final boolean d(List<a> list, boolean z) {
        if (!this.iYd || bh.cA(list)) {
            return false;
        }
        List arrayList = new ArrayList();
        for (a aVar : list) {
            a(aVar, false, false);
            arrayList.add(aVar.gHg);
        }
        if (z) {
            b("batch", 2, arrayList);
        }
        x.i("MicroMsg.MiniGameInfoStorage", "insert miniGame size:%d,   isSync:%b", new Object[]{Integer.valueOf(list.size()), Boolean.valueOf(false)});
        return true;
    }

    public final boolean S(String str, boolean z) {
        boolean z2 = false;
        if (this.iYd && !bh.ov(str)) {
            com.tencent.mm.sdk.e.c bVar = new b();
            bVar.field_RecordId = str;
            z2 = super.a(bVar, new String[0]);
            if (z2 && z) {
                b("single", 5, str);
            }
        }
        return z2;
    }

    public final boolean ab(List<String> list) {
        if (!this.iYd || bh.cA(list)) {
            return false;
        }
        for (String S : list) {
            S(S, false);
        }
        b("batch", 5, list);
        return true;
    }

    public final boolean a(a aVar, boolean z, boolean z2) {
        boolean z3 = false;
        if (this.iYd && aVar != null) {
            com.tencent.mm.sdk.e.c bVar;
            com.tencent.mm.sdk.e.c cVar;
            boolean z4;
            String str = aVar.ngo;
            int i = aVar.iGA;
            if (this.iYd) {
                Cursor rawQuery = rawQuery(String.format("select * from %s where %s=? and %s=?", new Object[]{"WxagGameInfo", "AppId", "debugType"}), new String[]{str, String.valueOf(i)});
                if (rawQuery.moveToFirst()) {
                    bVar = new b();
                    bVar.b(rawQuery);
                    rawQuery.close();
                    cVar = bVar;
                } else {
                    rawQuery.close();
                    cVar = null;
                }
            } else {
                cVar = null;
            }
            if (cVar == null || !cVar.field_isSync) {
                z4 = true;
            } else {
                z4 = false;
            }
            x.i("MicroMsg.MiniGameInfoStorage", "needUpdate:%b", new Object[]{Boolean.valueOf(z4)});
            if (z4) {
                if (this.iYd && cVar != null) {
                    super.a(cVar, new String[0]);
                }
                bVar = new b();
                if (bh.ov(aVar.gHg)) {
                    str = aVar.ksU;
                    i = aVar.iGA;
                    aVar.gHg = String.valueOf(String.format(Locale.US, "%s|%d", new Object[]{str, Integer.valueOf(i)}).hashCode());
                }
                bVar.field_RecordId = aVar.gHg;
                bVar.field_AppId = aVar.ngo;
                bVar.field_AppName = aVar.niZ;
                bVar.field_UserName = aVar.ksU;
                bVar.field_IconUrl = aVar.nfT;
                bVar.field_BriefIntro = aVar.ngC;
                bVar.field_isSync = false;
                bVar.field_createTime = System.currentTimeMillis();
                z3 = b(bVar);
                if (z3 && z2) {
                    b("single", 2, bVar.field_RecordId);
                }
            }
        }
        return z3;
    }
}
