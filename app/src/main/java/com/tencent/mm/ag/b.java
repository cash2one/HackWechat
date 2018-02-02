package com.tencent.mm.ag;

import com.tencent.mm.g.b.x;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends x {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[13];
        aVar.columns = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "userName";
        aVar.xjA.put("userName", "TEXT PRIMARY KEY ");
        stringBuilder.append(" userName TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "userName";
        aVar.columns[1] = "qyUin";
        aVar.xjA.put("qyUin", "INTEGER");
        stringBuilder.append(" qyUin INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "userUin";
        aVar.xjA.put("userUin", "INTEGER");
        stringBuilder.append(" userUin INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "userFlag";
        aVar.xjA.put("userFlag", "INTEGER");
        stringBuilder.append(" userFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "wwExposeTimes";
        aVar.xjA.put("wwExposeTimes", "INTEGER");
        stringBuilder.append(" wwExposeTimes INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "wwMaxExposeTimes";
        aVar.xjA.put("wwMaxExposeTimes", "INTEGER");
        stringBuilder.append(" wwMaxExposeTimes INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "wwCorpId";
        aVar.xjA.put("wwCorpId", "LONG");
        stringBuilder.append(" wwCorpId LONG");
        stringBuilder.append(", ");
        aVar.columns[7] = "wwUserVid";
        aVar.xjA.put("wwUserVid", "LONG");
        stringBuilder.append(" wwUserVid LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "userType";
        aVar.xjA.put("userType", "INTEGER");
        stringBuilder.append(" userType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "chatOpen";
        aVar.xjA.put("chatOpen", "INTEGER");
        stringBuilder.append(" chatOpen INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "wwUnreadCnt";
        aVar.xjA.put("wwUnreadCnt", "INTEGER default '0' ");
        stringBuilder.append(" wwUnreadCnt INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "show_confirm";
        aVar.xjA.put("show_confirm", "INTEGER");
        stringBuilder.append(" show_confirm INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "use_preset_banner_tips";
        aVar.xjA.put("use_preset_banner_tips", "INTEGER");
        stringBuilder.append(" use_preset_banner_tips INTEGER");
        aVar.columns[13] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
