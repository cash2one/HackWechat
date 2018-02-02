package com.tencent.mm.ag.a;

import com.tencent.mm.g.b.w;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bh;
import java.lang.reflect.Field;

public final class j extends w {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[10];
        aVar.columns = new String[11];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "userId";
        aVar.xjA.put("userId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" userId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "userId";
        aVar.columns[1] = "userName";
        aVar.xjA.put("userName", "TEXT default '' ");
        stringBuilder.append(" userName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "userNamePY";
        aVar.xjA.put("userNamePY", "TEXT default '' ");
        stringBuilder.append(" userNamePY TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "brandUserName";
        aVar.xjA.put("brandUserName", "TEXT default '' ");
        stringBuilder.append(" brandUserName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "UserVersion";
        aVar.xjA.put("UserVersion", "INTEGER default '-1' ");
        stringBuilder.append(" UserVersion INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "needToUpdate";
        aVar.xjA.put("needToUpdate", "INTEGER default 'true' ");
        stringBuilder.append(" needToUpdate INTEGER default 'true' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "headImageUrl";
        aVar.xjA.put("headImageUrl", "TEXT");
        stringBuilder.append(" headImageUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "profileUrl";
        aVar.xjA.put("profileUrl", "TEXT");
        stringBuilder.append(" profileUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "bitFlag";
        aVar.xjA.put("bitFlag", "INTEGER default '0' ");
        stringBuilder.append(" bitFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "addMemberUrl";
        aVar.xjA.put("addMemberUrl", "TEXT");
        stringBuilder.append(" addMemberUrl TEXT");
        aVar.columns[10] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public final boolean ho(int i) {
        return (this.field_bitFlag & i) != 0;
    }

    public final boolean Mu() {
        if (this.field_needToUpdate) {
            return true;
        }
        if (bh.ov(this.field_profileUrl) && bh.ov(this.field_headImageUrl)) {
            return true;
        }
        if (!bh.ov(this.field_userNamePY) || bh.ov(this.field_userName)) {
            return false;
        }
        return true;
    }
}
