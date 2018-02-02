package com.tencent.mm.plugin.appbrand.appusage;

import android.content.ContentValues;
import com.tencent.mm.g.b.j;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

final class n$a extends j {
    static final String[] iEI = new String[]{"brandId", "versionType", "scene"};
    static final a iGc;

    n$a() {
    }

    protected final a Ac() {
        return iGc;
    }

    public final ContentValues vI() {
        this.xjy = 0;
        ContentValues vI = super.vI();
        int u = n.u(this.field_brandId, this.field_versionType, this.field_scene);
        this.field_recordId = u;
        vI.put("recordId", Integer.valueOf(u));
        return vI;
    }

    static {
        a aVar = new a();
        aVar.hSY = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "recordId";
        aVar.xjA.put("recordId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" recordId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "recordId";
        aVar.columns[1] = "brandId";
        aVar.xjA.put("brandId", "TEXT");
        stringBuilder.append(" brandId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "versionType";
        aVar.xjA.put("versionType", "INTEGER");
        stringBuilder.append(" versionType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "updateTime";
        aVar.xjA.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "scene";
        aVar.xjA.put("scene", "INTEGER");
        stringBuilder.append(" scene INTEGER");
        aVar.columns[5] = "rowid";
        aVar.xjB = stringBuilder.toString();
        iGc = aVar;
    }
}
