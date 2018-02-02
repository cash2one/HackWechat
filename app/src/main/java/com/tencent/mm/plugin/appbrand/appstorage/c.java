package com.tencent.mm.plugin.appbrand.appstorage;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;

public final class c extends i<b> {
    public static final String[] gJN = new String[]{i.a(b.gJc, "AppBrandKVData"), "DROP TABLE IF EXISTS AppBrandStorageKVData;"};
    private e iHy;

    public enum a {
        NONE,
        UNKNOWN,
        MISSING_PARAMS,
        NO_SUCH_KEY,
        QUOTA_REACHED
    }

    public c(e eVar) {
        super(eVar, b.gJc, "AppBrandKVData", null);
        this.iHy = eVar;
    }

    public final Object[] aL(String str, String str2) {
        if (bh.ov(str) || bh.ov(str2)) {
            return new Object[]{a.MISSING_PARAMS};
        }
        com.tencent.mm.sdk.e.c bVar = new b();
        bVar.field_key = w(str, str2, "__");
        if (super.b(bVar, new String[0])) {
            return new Object[]{a.NONE, bVar.field_data, bVar.field_dataType};
        }
        return new Object[]{a.NO_SUCH_KEY};
    }

    public final a f(String str, String str2, String str3, String str4) {
        Object obj = null;
        if (bh.ov(str) || bh.ov(str2)) {
            return a.MISSING_PARAMS;
        }
        String w = w(str, str2, "__");
        int length = (str3 == null ? 0 : str3.length()) + (str2 == null ? 0 : str2.length());
        int pT = length - pT(w);
        if (pS(str) + pT >= com.tencent.mm.plugin.appbrand.config.i.qI(str)) {
            obj = 1;
        }
        if (obj != null) {
            return a.QUOTA_REACHED;
        }
        com.tencent.mm.sdk.e.c bVar = new b();
        bVar.field_key = w;
        bVar.field_data = str3;
        bVar.field_dataType = str4;
        bVar.field_size = length;
        if (!super.a(bVar)) {
            return a.UNKNOWN;
        }
        al(str, pT);
        return a.NONE;
    }

    public final a aM(String str, String str2) {
        if (bh.ov(str) || bh.ov(str2)) {
            return a.MISSING_PARAMS;
        }
        String w = w(str, str2, "__");
        al(str, -pT(w));
        com.tencent.mm.sdk.e.c bVar = new b();
        bVar.field_key = w;
        super.a(bVar, new String[0]);
        return a.NONE;
    }

    public final void clear(String str) {
        super.fx("AppBrandKVData", String.format("delete from %s where %s like '%s%%'", new Object[]{"AppBrandKVData", "key", str}));
    }

    public final Object[] pR(String str) {
        Cursor a = this.iHy.a("AppBrandKVData", new String[]{"key"}, "key like ? escape ?", new String[]{(str + "__").replace("_", "\\_") + "%", "\\"}, null, null, null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            arrayList.add(a.getString(0).replace(r9, ""));
        }
        a.close();
        int pS = pS(str);
        int qI = com.tencent.mm.plugin.appbrand.config.i.qI(str);
        return new Object[]{arrayList, Integer.valueOf(pS), Integer.valueOf(qI)};
    }

    private int pS(String str) {
        com.tencent.mm.sdk.e.c bVar = new b();
        bVar.field_key = w(str, "@@@TOTAL@DATA@SIZE@@@", "++");
        if (super.b(bVar, new String[0])) {
            return bh.getInt(bVar.field_data, 0);
        }
        return 0;
    }

    private int al(String str, int i) {
        int max = Math.max(0, pS(str) + i);
        com.tencent.mm.sdk.e.c bVar = new b();
        bVar.field_key = w(str, "@@@TOTAL@DATA@SIZE@@@", "++");
        bVar.field_data = String.valueOf(max);
        super.a(bVar);
        return max;
    }

    private int pT(String str) {
        Cursor a = this.iHy.a("AppBrandKVData", new String[]{"size"}, "key = ?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            int i = a.getInt(0);
            a.close();
            return i;
        }
        a.close();
        return 0;
    }

    private static String w(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str3);
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }
}
