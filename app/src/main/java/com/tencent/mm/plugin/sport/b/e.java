package com.tencent.mm.plugin.sport.b;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.g.b.dj;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class e extends dj implements Comparable<e> {
    public static a gJc;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        e eVar = (e) obj;
        if (this.field_timestamp > eVar.field_timestamp) {
            return 1;
        }
        return this.field_timestamp < eVar.field_timestamp ? -1 : 0;
    }

    static {
        a aVar = new a();
        aVar.hSY = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = SlookAirButtonFrequentContactAdapter.ID;
        aVar.xjA.put(SlookAirButtonFrequentContactAdapter.ID, "INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(" id INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = SlookAirButtonFrequentContactAdapter.ID;
        aVar.columns[1] = FFmpegMetadataRetriever.METADATA_KEY_DATE;
        aVar.xjA.put(FFmpegMetadataRetriever.METADATA_KEY_DATE, "TEXT");
        stringBuilder.append(" date TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "step";
        aVar.xjA.put("step", "INTEGER");
        stringBuilder.append(" step INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "timestamp";
        aVar.xjA.put("timestamp", "LONG");
        stringBuilder.append(" timestamp LONG");
        aVar.columns[4] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
