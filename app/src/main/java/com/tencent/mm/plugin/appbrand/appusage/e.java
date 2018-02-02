package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.k.a;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class e extends i<d> implements r {
    public static final String[] iEK = new String[]{i.a(d.iEJ, "AppBrandLocalUsageRecord")};
    private final com.tencent.mm.sdk.e.e iHy;

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, d.iEJ, "AppBrandLocalUsageRecord", d.fMK);
        this.iHy = eVar;
    }

    public final List<LocalUsageInfo> jE(int i) {
        return v(12, true);
    }

    public final List<LocalUsageInfo> v(int i, boolean z) {
        List<LocalUsageInfo> list = null;
        Cursor rawQuery = this.iHy.rawQuery("select AppBrandLocalUsageRecord.username,AppBrandLocalUsageRecord.versionType,WxaAttributesTable.nickname,WxaAttributesTable.brandIconURL,WxaAttributesTable.appId from AppBrandLocalUsageRecord left outer join WxaAttributesTable on AppBrandLocalUsageRecord.username=WxaAttributesTable.username order by AppBrandLocalUsageRecord.updateTime desc limit " + Math.max(i, 1) + " offset 0", null);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                Collection linkedList = new LinkedList();
                do {
                    String string = rawQuery.getString(0);
                    if (!bh.ov(string)) {
                        linkedList.add(new LocalUsageInfo(string, rawQuery.getString(4), rawQuery.getInt(1), rawQuery.getString(2), rawQuery.getString(3)));
                    }
                } while (rawQuery.moveToNext());
                rawQuery.close();
                list = new ArrayList(linkedList.size());
                list.addAll(linkedList);
                if (z) {
                    Y(list);
                }
            } else {
                rawQuery.close();
            }
        }
        return list;
    }

    private static void Y(List<LocalUsageInfo> list) {
        c fn = com.tencent.mm.z.c.c.IF().fn("100361");
        if (fn.isValid() && bh.getInt((String) fn.chI().get("isOpenBatchAttrSync"), 0) > 0) {
            Collection hashSet = new HashSet(list.size());
            for (LocalUsageInfo localUsageInfo : list) {
                hashSet.add(localUsageInfo.username);
            }
            List arrayList = new ArrayList(hashSet.size());
            arrayList.addAll(hashSet);
            r.a(arrayList, a.iOQ);
        }
    }

    public final boolean am(String str, int i) {
        return b(str, i, a.iJd);
    }

    public final boolean a(String str, int i, a aVar) {
        boolean z = false;
        x.i("MicroMsg.AppBrandLocalUsageStorage", "addUsage, username %s, type %d, scene %s", new Object[]{str, Integer.valueOf(i), aVar});
        if (!bh.ov(str)) {
            com.tencent.mm.sdk.e.c dVar = new d();
            dVar.field_username = str;
            dVar.field_versionType = i;
            if (super.b(dVar, d.iEI)) {
                dVar.field_updateTime = bh.Wo();
                z = super.a(dVar.xjy, dVar, false);
                if (z) {
                    b("single", 3, null);
                }
            } else {
                dVar.field_updateTime = bh.Wo();
                super.a(dVar, false);
                z = super.b(dVar, d.iEI);
                if (z) {
                    this.iHy.fx("AppBrandLocalUsageRecord", "delete from AppBrandLocalUsageRecord where rowid not in ( select rowid from AppBrandLocalUsageRecord order by updateTime desc  limit " + AppBrandGlobalSystemConfig.abS().iNx + " offset 0)");
                    b("single", 2, null);
                }
            }
        }
        return z;
    }

    final boolean b(String str, int i, a aVar) {
        boolean z = false;
        x.i("MicroMsg.AppBrandLocalUsageStorage", "removeUsage, username %s, type %d, scene %s", new Object[]{str, Integer.valueOf(i), aVar});
        if (!bh.ov(str)) {
            d dVar = new d();
            dVar.field_username = str;
            dVar.field_versionType = i;
            z = a(dVar, false, d.iEI);
            if (z) {
                b("single", 5, null);
            }
            if (z && a.iJd == aVar) {
                d.aJ(q.qQ(str), i);
            }
        }
        return z;
    }

    private boolean a(d dVar, boolean z, String... strArr) {
        if (z) {
            return super.a(dVar, z, strArr);
        }
        if (!b(dVar, strArr)) {
            return false;
        }
        super.a(dVar, z, strArr);
        if (b(dVar, strArr)) {
            return false;
        }
        return true;
    }
}
