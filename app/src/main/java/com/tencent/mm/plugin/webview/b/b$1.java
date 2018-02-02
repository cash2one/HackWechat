package com.tencent.mm.plugin.webview.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

class b$1 implements Runnable {
    final /* synthetic */ String fgU;
    final /* synthetic */ String gIn;
    final /* synthetic */ String iaA;
    final /* synthetic */ long tkZ;
    final /* synthetic */ long tla;
    final /* synthetic */ String tlb;
    final /* synthetic */ String tlc;
    final /* synthetic */ b tld;

    b$1(b bVar, long j, String str, long j2, String str2, String str3, String str4, String str5) {
        this.tld = bVar;
        this.tkZ = j;
        this.fgU = str;
        this.tla = j2;
        this.gIn = str2;
        this.iaA = str3;
        this.tlb = str4;
        this.tlc = str5;
    }

    public final void run() {
        long j;
        if (this.tkZ > 0) {
            c bPb = this.tld.bPb();
            String str = this.fgU;
            long j2 = this.tkZ;
            str = String.format("select * from %s where appId='%s' order by weight,timeStamp", new Object[]{"WebViewData", str});
            x.d("MicroMsg.WebViewDataStorage", "deleteSize querySql: " + str);
            Cursor rawQuery = bPb.rawQuery(str, new String[0]);
            if (rawQuery == null) {
                j = 0;
            } else {
                List<String> linkedList = new LinkedList();
                long j3 = j2;
                while (rawQuery.moveToFirst() && j3 > 0) {
                    str = rawQuery.getString(1);
                    long j4 = rawQuery.getLong(6);
                    linkedList.add(str);
                    j3 -= j4;
                }
                rawQuery.close();
                if (linkedList.size() > 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("(");
                    for (String str2 : linkedList) {
                        stringBuilder.append("\"" + str2 + "\",");
                    }
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    stringBuilder.append(")");
                    str2 = String.format("delete from %s where %s in %s", new Object[]{"WebViewData", "appIdKey", stringBuilder.toString()});
                    x.d("MicroMsg.WebViewDataStorage", "deleteSize deleteSql: " + str2);
                    x.d("MicroMsg.WebViewDataStorage", "deleteSize: " + bPb.fx("WebViewData", str2));
                }
                j = j2 - j3;
            }
            b.a(this.tld).put(this.fgU, Long.valueOf(this.tla - j));
        } else {
            b.a(this.tld).put(this.fgU, Long.valueOf(this.tla));
        }
        c bPb2 = this.tld.bPb();
        String str3 = this.fgU;
        String str4 = this.gIn;
        String str5 = this.iaA;
        String az = bh.az(this.tlb, "1");
        long NW = b.NW(this.tlc);
        c aVar = new a();
        aVar.field_appId = str3;
        aVar.field_appIdKey = c.eI(str3, str4);
        aVar.field_value = str5;
        aVar.field_weight = az;
        aVar.field_expireTime = NW + (System.currentTimeMillis() / 1000);
        aVar.field_size = (long) (str4.getBytes().length + str5.getBytes().length);
        aVar.field_timeStamp = System.currentTimeMillis() / 1000;
        x.d("MicroMsg.WebViewDataStorage", "setData: " + bPb2.a(aVar));
        c bPb3 = this.tld.bPb();
        str5 = this.fgU;
        j = b.a(this.tld).get(this.fgU) == null ? 0 : ((Long) b.a(this.tld).get(this.fgU)).longValue();
        c aVar2 = new a();
        aVar2.field_appId = str5;
        aVar2.field_appIdKey = c.aa(str5, "###@@@@TOTAL@@@###SIZE####", "_");
        aVar2.field_expireTime = Long.MAX_VALUE;
        aVar2.field_size = j;
        boolean a = bPb3.a(aVar2);
        x.d("MicroMsg.WebViewDataStorage", "setAppIdSize: %b, size: %d", Boolean.valueOf(a), Long.valueOf(j));
        b.b(this.tld);
    }
}
