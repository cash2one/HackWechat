package com.tencent.mm.plugin.exdevice.f.b.a;

import com.tencent.mm.g.b.bu;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class d extends bu {
    public static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "rankID";
        aVar.xjA.put("rankID", "TEXT");
        stringBuilder.append(" rankID TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "appusername";
        aVar.xjA.put("appusername", "TEXT");
        stringBuilder.append(" appusername TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "username";
        aVar.xjA.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "ranknum";
        aVar.xjA.put("ranknum", "INTEGER");
        stringBuilder.append(" ranknum INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "score";
        aVar.xjA.put("score", "INTEGER");
        stringBuilder.append(" score INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "likecount";
        aVar.xjA.put("likecount", "INTEGER default '0' ");
        stringBuilder.append(" likecount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "selfLikeState";
        aVar.xjA.put("selfLikeState", "INTEGER default '3' ");
        stringBuilder.append(" selfLikeState INTEGER default '3' ");
        aVar.columns[7] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public final String toString() {
        return (("{" + "username: " + this.field_username + " ranknum: " + this.field_ranknum + " score: " + this.field_score) + " likeCount:" + this.field_likecount + " selfLikeState:" + this.field_selfLikeState) + "}";
    }
}
