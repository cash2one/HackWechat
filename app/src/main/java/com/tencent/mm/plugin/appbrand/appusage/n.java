package com.tencent.mm.plugin.appbrand.appusage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class n extends j {
    public static final String[] iEK = new String[]{i.a(a.iGc, "AppBrandLauncherLayoutItem")};
    final h iGs;
    final b iKa;
    public final c iKb = new c();

    public final class c {
        public final /* synthetic */ n iKc;

        private c(n nVar) {
            this.iKc = nVar;
        }

        public final ArrayList<i> abd() {
            return e(Long.MAX_VALUE, 30);
        }

        public final ArrayList<i> e(long j, int i) {
            return n.c(this.iKc.iGs.a("AppBrandLauncherLayoutItem", null, String.format(Locale.US, "%s=? and %s<? ", new Object[]{"scene", "updateTime"}), new String[]{"2", String.valueOf(j)}, null, null, String.format(Locale.US, "%s desc limit %d offset 0 ", new Object[]{"updateTime", Integer.valueOf(30)}), 2));
        }
    }

    public n(h hVar) {
        this.iGs = hVar;
        this.iKa = new b(hVar);
    }

    public final void c(a aVar) {
        a(aVar, com.tencent.mm.plugin.appbrand.q.c.Dm().oAt.getLooper());
    }

    public final boolean ao(String str, int i) {
        boolean z = true;
        if (bh.ov(str)) {
            return false;
        }
        Cursor a = this.iGs.a(String.format(Locale.US, "select count(*) from %s where %s=? and %s=? and %s=?", new Object[]{"AppBrandLauncherLayoutItem", "brandId", "versionType", "scene"}), new String[]{str, String.valueOf(i), "2"}, 0);
        if (a == null) {
            return false;
        }
        if (!a.moveToFirst()) {
            z = false;
        } else if (a.getInt(0) <= 0) {
            z = false;
        }
        a.close();
        return z;
    }

    final Cursor a(String[] strArr, int i, int i2) {
        return this.iGs.query("AppBrandLauncherLayoutItem", strArr, String.format(Locale.US, "%s=? order by %s desc limit %d offset %d", new Object[]{"scene", "updateTime", Integer.valueOf(i), Integer.valueOf(i2)}), new String[]{"2"}, null, null, null);
    }

    private static ArrayList<i> c(Cursor cursor) {
        if (cursor == null) {
            return new ArrayList();
        }
        ArrayList<i> arrayList;
        if (cursor.moveToFirst()) {
            Collection linkedList = new LinkedList();
            a aVar = new a();
            do {
                aVar.b(cursor);
                if (!bh.ov(aVar.field_brandId)) {
                    linkedList.add(q.a(String.valueOf(aVar.field_recordId), aVar.field_brandId, aVar.field_versionType, aVar.field_updateTime));
                }
            } while (cursor.moveToNext());
            arrayList = new ArrayList(linkedList.size());
            arrayList.addAll(linkedList);
        } else {
            arrayList = new ArrayList();
        }
        cursor.close();
        return arrayList;
    }

    public final ArrayList<i> abb() {
        return c(a(null, 200, 0));
    }

    public final i qc(String str) {
        i iVar = null;
        if (!bh.ov(str)) {
            Cursor query = this.iGs.query("AppBrandLauncherLayoutItem", null, String.format(Locale.US, "%s=? and %s=?", new Object[]{"scene", "recordId"}), new String[]{"2", str}, null, null, null);
            if (query != null) {
                if (query.moveToFirst()) {
                    a aVar = new a();
                    aVar.b(query);
                    if (!bh.ov(aVar.field_brandId)) {
                        iVar = q.a(String.valueOf(aVar.field_recordId), aVar.field_brandId, aVar.field_versionType, aVar.field_updateTime);
                    }
                }
                query.close();
            }
        }
        return iVar;
    }

    public final List<String> qd(String str) {
        List<String> linkedList = new LinkedList();
        if (!bh.ov(str)) {
            Cursor query = this.iGs.query("AppBrandLauncherLayoutItem", new String[]{"recordId"}, String.format(Locale.US, "%s=? and %s=?", new Object[]{"scene", "brandId"}), new String[]{"2", str}, null, null, null);
            if (query == null) {
                return null;
            }
            if (query.moveToFirst()) {
                do {
                    linkedList.add(String.valueOf(query.getInt(query.getColumnIndex("recordId"))));
                } while (query.moveToNext());
            }
            query.close();
        }
        return linkedList;
    }

    private boolean a(String str, int i, boolean z, boolean z2, int i2, int i3, String str2) {
        if (bh.ov(str) || 999 == i) {
            return false;
        }
        long j;
        boolean z3;
        boolean z4;
        Cursor a = this.iGs.a(String.format(Locale.US, "select max(%s) from %s where %s=?", new Object[]{"updateTime", "AppBrandLauncherLayoutItem", "scene"}), new String[]{"2"}, 0);
        if (a == null) {
            j = 0;
        } else {
            j = 0;
            if (a.moveToFirst()) {
                j = a.getLong(0);
            }
            a.close();
        }
        long max = Math.max(j + 1, bh.Wo());
        int t = t(str, i, 2);
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("updateTime", Long.valueOf(max));
        Object obj = this.iGs.update("AppBrandLauncherLayoutItem", contentValues, String.format(Locale.US, "%s=?", new Object[]{"recordId"}), new String[]{String.valueOf(t)}) > 0 ? 1 : null;
        if (obj != null) {
            b("single", 3, String.valueOf(t));
        }
        if (obj == null) {
            a aVar = new a();
            aVar.field_updateTime = max;
            aVar.field_scene = 2;
            aVar.field_brandId = str;
            aVar.field_versionType = i;
            boolean a2 = a(aVar);
            if (a2) {
                b("single", 2, String.valueOf(t));
            }
            z3 = a2;
            z4 = a2;
        } else {
            z4 = true;
            z3 = false;
        }
        if (z4 && z) {
            new q(i2, z2, i, 2, 1, str, i3, str2).JV();
        }
        if (z4) {
            com.tencent.mm.plugin.appbrand.appcache.n.ae(str, i);
        }
        if (z3) {
            abc();
        }
        if (z4 && i2 != 1086) {
            ((e) f.u(e.class)).a(str, i, e$a.USAGE_LIST);
        }
        return z4;
    }

    private void abc() {
        int i;
        int i2 = 0;
        Cursor a = this.iGs.a(String.format(Locale.US, "select count(*) from %s where %s=?", new Object[]{"AppBrandLauncherLayoutItem", "scene"}), new String[]{"2"}, 0);
        if (a == null) {
            i = 0;
        } else {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            } else {
                i = 0;
            }
            a.close();
        }
        if (i > 200) {
            a = a(new String[]{"recordId", "brandId", "versionType"}, Integer.MAX_VALUE, 200);
            if (a != null) {
                List<String> linkedList = new LinkedList();
                List arrayList = new ArrayList(i - 200);
                List arrayList2 = new ArrayList(i - 200);
                if (a.moveToFirst()) {
                    do {
                        linkedList.add(String.valueOf(a.getInt(0)));
                        arrayList.add(a.getString(1));
                        arrayList2.add(Integer.valueOf(a.getInt(2)));
                    } while (a.moveToNext());
                }
                a.close();
                if (!bh.cA(linkedList)) {
                    String qQ;
                    long dz = this.iGs.dz(Thread.currentThread().getId());
                    for (String qQ2 : linkedList) {
                        this.iGs.delete("AppBrandLauncherLayoutItem", String.format(Locale.US, "%s=?", new Object[]{"recordId"}), new String[]{qQ2});
                    }
                    this.iGs.fS(dz);
                    List arrayList3 = new ArrayList(arrayList.size());
                    List arrayList4 = new ArrayList(arrayList.size());
                    while (i2 < arrayList.size()) {
                        qQ2 = q.qQ((String) arrayList.get(i2));
                        if (!bh.ov(qQ2)) {
                            arrayList3.add(qQ2);
                            arrayList4.add(arrayList2.get(i2));
                        }
                        i2++;
                    }
                    if (f.Zo() != null) {
                        f.Zo().d(arrayList3, arrayList4);
                    }
                    b("batch", 5, linkedList);
                }
            }
        }
    }

    public final boolean a(String str, int i, boolean z, int i2, int i3, String str2) {
        boolean a = a(str, i, true, z, i2, i3, str2);
        if (a) {
            a.pZ(str2);
        }
        return a;
    }

    public final void s(String str, int i, int i2) {
        a(str, i, false, false, i2, 0, null);
    }

    final boolean a(a aVar) {
        if (bh.ov(aVar.field_brandId)) {
            return false;
        }
        long insert = this.iGs.insert("AppBrandLauncherLayoutItem", "", aVar.vI());
        if (insert > 0 || insert == ((long) aVar.field_recordId)) {
            return true;
        }
        return false;
    }

    static int t(String str, int i, int i2) {
        return String.format(Locale.US, "%s|%d|%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)}).hashCode();
    }
}
