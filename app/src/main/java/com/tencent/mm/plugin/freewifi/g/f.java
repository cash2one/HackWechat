package com.tencent.mm.plugin.freewifi.g;

import android.database.Cursor;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class f extends i<e> {
    public static final String[] gJN = new String[]{i.a(e.gJc, "FreeWifiLog"), "CREATE INDEX IF NOT EXISTS idx_FreeWifiLog_key  on FreeWifiLog  (  id )"};
    public static LinkedHashMap<String, Class> mGh = new 1();

    public f(e eVar) {
        super(eVar, e.gJc, "FreeWifiLog", null);
    }

    public final LinkedList<we> aMr() {
        Cursor rawQuery = rawQuery("select id, protocolNumber, logContent, createTime from FreeWifiLog", new String[0]);
        LinkedList<we> linkedList = new LinkedList();
        while (rawQuery != null && rawQuery.moveToNext()) {
            we weVar = new we();
            weVar.id = rawQuery.getString(0);
            weVar.mFb = rawQuery.getInt(1);
            weVar.wgC = rawQuery.getString(2);
            weVar.wgD = rawQuery.getLong(3);
            linkedList.add(weVar);
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        return linkedList;
    }

    public final boolean a(String str, int i, String str2, long j) {
        x.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "save. id=%s, protocolNumber=%d, logContent=%s, createTime=%d", new Object[]{str, Integer.valueOf(i), str2, Long.valueOf(j)});
        if (m.AA(str)) {
            return false;
        }
        Cursor rawQuery = rawQuery("select * from FreeWifiLog where id = '" + str + "'", new String[0]);
        boolean b;
        try {
            c eVar = new e();
            eVar.field_id = str;
            eVar.field_protocolNumber = i;
            eVar.field_logContent = str2;
            eVar.field_createTime = j;
            if (rawQuery.getCount() == 0) {
                b = b(eVar);
                x.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "insert ret" + b);
                return b;
            }
            b = c(eVar, new String[0]);
            x.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "update ret" + b);
            rawQuery.close();
            return b;
        } catch (Exception e) {
            b = e;
            b = m.f(b);
            x.e("MicroMsg.FreeWifi.FreeWifiLogStorage", b);
            return false;
        } finally {
            rawQuery.close();
        }
    }
}
