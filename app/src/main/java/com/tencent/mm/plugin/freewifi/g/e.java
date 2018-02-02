package com.tencent.mm.plugin.freewifi.g;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.g.b.bh;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class e extends bh {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = SlookAirButtonFrequentContactAdapter.ID;
        aVar.xjA.put(SlookAirButtonFrequentContactAdapter.ID, "TEXT PRIMARY KEY ");
        stringBuilder.append(" id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = SlookAirButtonFrequentContactAdapter.ID;
        aVar.columns[1] = "protocolNumber";
        aVar.xjA.put("protocolNumber", "INTEGER");
        stringBuilder.append(" protocolNumber INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "logContent";
        aVar.xjA.put("logContent", "TEXT");
        stringBuilder.append(" logContent TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "createTime";
        aVar.xjA.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        aVar.columns[4] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
