package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.g.b.di;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.List;

public final class s extends di {
    protected static a gJc;
    public int rpu;

    static {
        a aVar = new a();
        aVar.hSY = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "tagId";
        aVar.xjA.put("tagId", "LONG default '0' ");
        stringBuilder.append(" tagId LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "tagName";
        aVar.xjA.put("tagName", "TEXT default '' ");
        stringBuilder.append(" tagName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "count";
        aVar.xjA.put("count", "INTEGER default '0' ");
        stringBuilder.append(" count INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "memberList";
        aVar.xjA.put("memberList", "TEXT default '' ");
        stringBuilder.append(" memberList TEXT default '' ");
        aVar.columns[4] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public final void bS(List<bdo> list) {
        this.field_memberList = "";
        for (bdo com_tencent_mm_protocal_c_bdo : list) {
            this.field_memberList += com_tencent_mm_protocal_c_bdo.wJF + ",";
        }
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
        this.rpu = (int) this.xjy;
    }
}
