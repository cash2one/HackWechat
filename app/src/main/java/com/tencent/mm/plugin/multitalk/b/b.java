package com.tencent.mm.plugin.multitalk.b;

import com.tencent.mm.g.b.ch;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class b extends ch {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "memberUuid";
        aVar.xjA.put("memberUuid", "LONG");
        stringBuilder.append(" memberUuid LONG");
        stringBuilder.append(", ");
        aVar.columns[1] = "wxGroupId";
        aVar.xjA.put("wxGroupId", "TEXT");
        stringBuilder.append(" wxGroupId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "userName";
        aVar.xjA.put("userName", "TEXT");
        stringBuilder.append(" userName TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "inviteUserName";
        aVar.xjA.put("inviteUserName", "TEXT");
        stringBuilder.append(" inviteUserName TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "memberId";
        aVar.xjA.put("memberId", "LONG");
        stringBuilder.append(" memberId LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = DownloadInfo.STATUS;
        aVar.xjA.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "createTime";
        aVar.xjA.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        aVar.columns[7] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
