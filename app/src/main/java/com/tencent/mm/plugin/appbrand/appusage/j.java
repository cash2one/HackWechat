package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Locale;

public final class j extends com.tencent.mm.sdk.e.j {
    public static final String[] iEK = new String[]{i.a(a.iGc, "AppBrandStarApp")};
    public final h iGs;
    public final c iJM;
    public volatile int iJN = 10;

    public j(h hVar) {
        this.iGs = hVar;
        this.iJM = new c(hVar);
    }

    public final void c(a aVar) {
        a(aVar, c.Dm().oAt.getLooper());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final b<ArrayList> jF(int i) {
        b<ArrayList> bVar = null;
        if (i == 0) {
            i = b.iJS;
        }
        Cursor query = this.iGs.query("AppBrandStarApp", new String[]{"username", "versionType"}, null, null, null, null, String.format(Locale.US, "%s desc limit %d offset 0", new Object[]{"updateTime", Integer.valueOf(this.iJN)}));
        if (query != null) {
            if (b.iJT != i) {
                if (query.moveToFirst()) {
                }
                query.close();
            }
            Collection linkedList = new LinkedList();
            a aVar = new a();
            while (true) {
                aVar.b(query);
                linkedList.add(q.a(String.format(Locale.US, "$%s$%d@starapp", new Object[]{aVar.field_username, Integer.valueOf(aVar.field_versionType)}), aVar.field_username, aVar.field_versionType, -1));
                if (b.iJT == i) {
                    if (!query.moveToPrevious()) {
                        break;
                    }
                } else if (!query.moveToNext()) {
                    break;
                }
            }
            bVar = new ArrayList(linkedList.size());
            bVar.addAll(linkedList);
            query.close();
        }
        return bVar;
    }

    public final boolean an(String str, int i) {
        Cursor cursor = null;
        if (!bh.ov(str)) {
            cursor = this.iGs.query("AppBrandStarApp", null, String.format(Locale.US, "%s=? and %s=?", new Object[]{"username", "versionType"}), new String[]{str, String.valueOf(i)}, null, null, null);
        }
        if (cursor == null) {
            return false;
        }
        boolean moveToFirst = cursor.moveToFirst();
        cursor.close();
        return moveToFirst;
    }

    public final boolean h(String str, int i, boolean z) {
        if (bh.ov(str)) {
            return false;
        }
        boolean z2;
        q qVar;
        com.tencent.mm.sdk.e.c aVar = new a();
        aVar.field_username = str;
        aVar.field_versionType = i;
        if (this.iJM.b(aVar, new String[]{"versionType", "username"})) {
            this.iJM.a(aVar, false, a.iEI);
            if (an(str, i)) {
                z2 = false;
                if (z2 && z) {
                    qVar = new q(1003, false, i, 1, 2, str, 1, null);
                    qVar.iKl = new 2(this, aVar, str, i);
                    qVar.JV();
                }
                return z2;
            }
            b("single", 5, aVar);
        }
        z2 = true;
        qVar = new q(1003, false, i, 1, 2, str, 1, null);
        qVar.iKl = new 2(this, aVar, str, i);
        qVar.JV();
        return z2;
    }
}
