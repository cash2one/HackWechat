package com.tencent.mm.plugin.appbrand.widget;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.g.b.an;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class g extends an {
    public static a iGc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = SlookAirButtonFrequentContactAdapter.ID;
        aVar.xjA.put(SlookAirButtonFrequentContactAdapter.ID, "TEXT");
        stringBuilder.append(" id TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "cacheKey";
        aVar.xjA.put("cacheKey", "TEXT");
        stringBuilder.append(" cacheKey TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "appId";
        aVar.xjA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = SlookAirButtonFrequentContactAdapter.DATA;
        aVar.xjA.put(SlookAirButtonFrequentContactAdapter.DATA, "TEXT");
        stringBuilder.append(" data TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "interval";
        aVar.xjA.put("interval", "INTEGER");
        stringBuilder.append(" interval INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "updateTime";
        aVar.xjA.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        aVar.columns[6] = "rowid";
        aVar.xjB = stringBuilder.toString();
        iGc = aVar;
    }

    protected final a Ac() {
        return iGc;
    }
}
