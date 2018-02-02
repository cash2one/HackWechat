package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.g.b.bv;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.ArrayList;

public final class c extends bv {
    public static a gJc;
    public ArrayList<String> nGH;

    static {
        a aVar = new a();
        aVar.hSY = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "wechatUsername";
        aVar.xjA.put("wechatUsername", "TEXT");
        stringBuilder.append(" wechatUsername TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "systemAddressBookUsername";
        aVar.xjA.put("systemAddressBookUsername", "TEXT");
        stringBuilder.append(" systemAddressBookUsername TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "contactId";
        aVar.xjA.put("contactId", "TEXT");
        stringBuilder.append(" contactId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "sortKey";
        aVar.xjA.put("sortKey", "TEXT");
        stringBuilder.append(" sortKey TEXT");
        aVar.columns[4] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public static boolean cV(String str, String str2) {
        if (str == null && str2 != null) {
            return false;
        }
        if (str == null || str.equals(str2)) {
            return true;
        }
        return false;
    }
}
