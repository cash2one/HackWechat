package com.tencent.mm.plugin.card.model;

import com.tencent.mm.g.b.ac;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class i extends ac {
    public static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "card_id";
        aVar.xjA.put("card_id", "TEXT PRIMARY KEY ");
        stringBuilder.append(" card_id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "card_id";
        aVar.columns[1] = "lower_bound";
        aVar.xjA.put("lower_bound", "INTEGER");
        stringBuilder.append(" lower_bound INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "need_insert_show_timestamp";
        aVar.xjA.put("need_insert_show_timestamp", "INTEGER default 'false' ");
        stringBuilder.append(" need_insert_show_timestamp INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "show_timestamp_encrypt_key";
        aVar.xjA.put("show_timestamp_encrypt_key", "TEXT");
        stringBuilder.append(" show_timestamp_encrypt_key TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "expire_time_interval";
        aVar.xjA.put("expire_time_interval", "INTEGER");
        stringBuilder.append(" expire_time_interval INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "show_expire_interval";
        aVar.xjA.put("show_expire_interval", "INTEGER");
        stringBuilder.append(" show_expire_interval INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "fetch_time";
        aVar.xjA.put("fetch_time", "LONG");
        stringBuilder.append(" fetch_time LONG");
        aVar.columns[7] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
