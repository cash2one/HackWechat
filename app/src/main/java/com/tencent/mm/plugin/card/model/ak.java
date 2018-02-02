package com.tencent.mm.plugin.card.model;

import com.tencent.mm.g.b.cn;
import com.tencent.mm.protocal.c.kq;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class ak extends cn {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "cardUserId";
        aVar.xjA.put("cardUserId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" cardUserId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "cardUserId";
        aVar.columns[1] = "retryCount";
        aVar.xjA.put("retryCount", "INTEGER");
        stringBuilder.append(" retryCount INTEGER");
        aVar.columns[2] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ak)) {
            return false;
        }
        if (this.field_cardUserId == ((ak) obj).field_cardUserId) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.field_cardUserId == null ? 0 : this.field_cardUserId.hashCode();
    }

    public static ak a(kq kqVar) {
        ak akVar = new ak();
        akVar.field_cardUserId = kqVar.vSu;
        return akVar;
    }
}
