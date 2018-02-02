package com.tencent.mm.storage;

import com.tencent.mm.g.b.cj;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class ay extends cj {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[12];
        aVar.columns = new String[13];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "tipId";
        aVar.xjA.put("tipId", "INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(" tipId INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "tipId";
        aVar.columns[1] = "tipVersion";
        aVar.xjA.put("tipVersion", "INTEGER");
        stringBuilder.append(" tipVersion INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "tipkey";
        aVar.xjA.put("tipkey", "TEXT");
        stringBuilder.append(" tipkey TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "tipType";
        aVar.xjA.put("tipType", "INTEGER");
        stringBuilder.append(" tipType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "isExit";
        aVar.xjA.put("isExit", "INTEGER");
        stringBuilder.append(" isExit INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "hadRead";
        aVar.xjA.put("hadRead", "INTEGER");
        stringBuilder.append(" hadRead INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "isReject";
        aVar.xjA.put("isReject", "INTEGER");
        stringBuilder.append(" isReject INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "beginShowTime";
        aVar.xjA.put("beginShowTime", "LONG");
        stringBuilder.append(" beginShowTime LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "disappearTime";
        aVar.xjA.put("disappearTime", "LONG");
        stringBuilder.append(" disappearTime LONG");
        stringBuilder.append(", ");
        aVar.columns[9] = "overdueTime";
        aVar.xjA.put("overdueTime", "LONG");
        stringBuilder.append(" overdueTime LONG");
        stringBuilder.append(", ");
        aVar.columns[10] = "tipsShowInfo";
        aVar.xjA.put("tipsShowInfo", "BLOB");
        stringBuilder.append(" tipsShowInfo BLOB");
        stringBuilder.append(", ");
        aVar.columns[11] = "extInfo";
        aVar.xjA.put("extInfo", "TEXT");
        stringBuilder.append(" extInfo TEXT");
        aVar.columns[12] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
