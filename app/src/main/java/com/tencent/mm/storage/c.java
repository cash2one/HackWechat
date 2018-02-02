package com.tencent.mm.storage;

import com.tencent.mm.g.b.d;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bh;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Map;

public final class c extends d implements Serializable {
    protected static a gJc;
    private Map<String, String> xmr = null;

    static {
        a aVar = new a();
        aVar.hSY = new Field[9];
        aVar.columns = new String[10];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "layerId";
        aVar.xjA.put("layerId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" layerId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "layerId";
        aVar.columns[1] = "business";
        aVar.xjA.put("business", "TEXT");
        stringBuilder.append(" business TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "expId";
        aVar.xjA.put("expId", "TEXT");
        stringBuilder.append(" expId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "sequence";
        aVar.xjA.put("sequence", "LONG");
        stringBuilder.append(" sequence LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "prioritylevel";
        aVar.xjA.put("prioritylevel", "INTEGER default '0' ");
        stringBuilder.append(" prioritylevel INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "startTime";
        aVar.xjA.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "endTime";
        aVar.xjA.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        stringBuilder.append(", ");
        aVar.columns[7] = "needReport";
        aVar.xjA.put("needReport", "INTEGER");
        stringBuilder.append(" needReport INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "rawXML";
        aVar.xjA.put("rawXML", "TEXT default '' ");
        stringBuilder.append(" rawXML TEXT default '' ");
        aVar.columns[9] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public final boolean isValid() {
        long Wo = bh.Wo();
        return Wo >= this.field_startTime && Wo <= this.field_endTime;
    }

    public final Map<String, String> chI() {
        if (this.xmr == null) {
            this.xmr = com.tencent.mm.z.c.a.in(this.field_rawXML);
        }
        return this.xmr;
    }
}
