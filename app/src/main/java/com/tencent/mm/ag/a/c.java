package com.tencent.mm.ag.a;

import com.tencent.mm.api.g;
import com.tencent.mm.g.b.u;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c extends u {
    protected static a gJc;
    private Map<String, j> hqH = new HashMap();
    private List<String> hqI;

    static {
        a aVar = new a();
        aVar.hSY = new Field[14];
        aVar.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "bizChatLocalId";
        aVar.xjA.put("bizChatLocalId", "LONG PRIMARY KEY ");
        stringBuilder.append(" bizChatLocalId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "bizChatLocalId";
        aVar.columns[1] = "bizChatServId";
        aVar.xjA.put("bizChatServId", "TEXT");
        stringBuilder.append(" bizChatServId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "brandUserName";
        aVar.xjA.put("brandUserName", "TEXT default '' ");
        stringBuilder.append(" brandUserName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "chatType";
        aVar.xjA.put("chatType", "INTEGER");
        stringBuilder.append(" chatType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "headImageUrl";
        aVar.xjA.put("headImageUrl", "TEXT");
        stringBuilder.append(" headImageUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "chatName";
        aVar.xjA.put("chatName", "TEXT default '' ");
        stringBuilder.append(" chatName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "chatNamePY";
        aVar.xjA.put("chatNamePY", "TEXT default '' ");
        stringBuilder.append(" chatNamePY TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "chatVersion";
        aVar.xjA.put("chatVersion", "INTEGER default '-1' ");
        stringBuilder.append(" chatVersion INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "needToUpdate";
        aVar.xjA.put("needToUpdate", "INTEGER default 'true' ");
        stringBuilder.append(" needToUpdate INTEGER default 'true' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "bitFlag";
        aVar.xjA.put("bitFlag", "INTEGER default '0' ");
        stringBuilder.append(" bitFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "maxMemberCnt";
        aVar.xjA.put("maxMemberCnt", "INTEGER default '0' ");
        stringBuilder.append(" maxMemberCnt INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "ownerUserId";
        aVar.xjA.put("ownerUserId", "TEXT");
        stringBuilder.append(" ownerUserId TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "userList";
        aVar.xjA.put("userList", "TEXT");
        stringBuilder.append(" userList TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "addMemberUrl";
        aVar.xjA.put("addMemberUrl", "TEXT");
        stringBuilder.append(" addMemberUrl TEXT");
        aVar.columns[14] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public final boolean ho(int i) {
        return (this.field_bitFlag & i) != 0;
    }

    public final List<String> Ms() {
        if (this.hqI != null) {
            return this.hqI;
        }
        String str = this.field_userList;
        if (bh.ov(str)) {
            return new LinkedList();
        }
        this.hqI = bh.F(str.split(";"));
        return this.hqI;
    }

    public final String gu(String str) {
        j kk = kk(str);
        if (kk == null) {
            return "";
        }
        return bh.az(kk.field_userName, "");
    }

    public final j kk(String str) {
        if (!this.hqH.containsKey(str) || this.hqH.get(str) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            j ca = ((g) com.tencent.mm.kernel.g.h(g.class)).ca(str);
            if (ca != null) {
                this.hqH.put(ca.field_userId, ca);
            }
            x.d("MicroMsg.BaseBizChatInfo", "willen get userInfo use time:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        }
        if (this.hqH.containsKey(str)) {
            return (j) this.hqH.get(str);
        }
        return null;
    }

    public final boolean Mt() {
        if (this.field_bizChatServId == null) {
            return false;
        }
        return this.field_bizChatServId.endsWith("@qy_g");
    }

    public final boolean Mu() {
        if (this.field_needToUpdate) {
            return true;
        }
        if (Mt() && bh.ov(this.field_userList)) {
            return true;
        }
        if (!bh.ov(this.field_chatNamePY) || bh.ov(this.field_chatName)) {
            return false;
        }
        return true;
    }
}
