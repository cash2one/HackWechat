package com.tencent.mm.plugin.appbrand.appstorage;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.g.b.i;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends i {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "key";
        aVar.xjA.put("key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "key";
        aVar.columns[1] = SlookAirButtonFrequentContactAdapter.DATA;
        aVar.xjA.put(SlookAirButtonFrequentContactAdapter.DATA, "TEXT");
        stringBuilder.append(" data TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "dataType";
        aVar.xjA.put("dataType", "TEXT");
        stringBuilder.append(" dataType TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "size";
        aVar.xjA.put("size", "INTEGER");
        stringBuilder.append(" size INTEGER");
        aVar.columns[4] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
