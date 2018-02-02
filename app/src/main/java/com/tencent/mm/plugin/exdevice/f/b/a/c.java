package com.tencent.mm.plugin.exdevice.f.b.a;

import com.tencent.mm.g.b.bt;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends bt {
    public static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appusername";
        aVar.xjA.put("appusername", "TEXT");
        stringBuilder.append(" appusername TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "rankID";
        aVar.xjA.put("rankID", "TEXT");
        stringBuilder.append(" rankID TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "username";
        aVar.xjA.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "step";
        aVar.xjA.put("step", "INTEGER");
        stringBuilder.append(" step INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "sort";
        aVar.xjA.put("sort", "INTEGER default '0' ");
        stringBuilder.append(" sort INTEGER default '0' ");
        aVar.columns[5] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public final String toString() {
        return ("{" + "username: " + this.field_username + " step: " + this.field_step + " rankId: " + this.field_rankID + " appname: " + this.field_appusername) + "}";
    }
}
