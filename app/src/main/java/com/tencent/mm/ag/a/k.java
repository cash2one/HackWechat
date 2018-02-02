package com.tencent.mm.ag.a;

import com.tencent.mm.ag.y;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class k extends i<j> {
    public static final String[] gJN = new String[]{i.a(j.gJc, "BizChatUserInfo")};
    public e gJP;
    final com.tencent.mm.sdk.e.k<a, b> hod = new 1(this);
    Map<String, String> hqH = new HashMap();

    public interface a {
    }

    public final /* synthetic */ boolean b(c cVar) {
        return a((j) cVar);
    }

    public k(e eVar) {
        super(eVar, j.gJc, "BizChatUserInfo", null);
        this.gJP = eVar;
        eVar.fx("BizChatUserInfo", "CREATE INDEX IF NOT EXISTS bizUserIdIndex ON BizChatUserInfo ( userId )");
        this.hqH.clear();
    }

    public final j ca(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.BizChatUserInfoStorage", "get  wrong argument");
            return null;
        }
        c jVar = new j();
        jVar.field_userId = str;
        super.b(jVar, new String[0]);
        return jVar;
    }

    public final boolean a(j jVar) {
        x.d("MicroMsg.BizChatUserInfoStorage", "BizChatUserInfo insert");
        if (jVar == null) {
            x.w("MicroMsg.BizChatUserInfoStorage", "insert wrong argument");
            return false;
        }
        boolean b = super.b((c) jVar);
        if (!b) {
            return b;
        }
        b bVar = new b();
        bVar.userId = jVar.field_userId;
        bVar.hrr = a.hrn;
        bVar.hrs = jVar;
        this.hod.ca(bVar);
        this.hod.doNotify();
        return b;
    }

    public final boolean b(j jVar) {
        x.d("MicroMsg.BizChatUserInfoStorage", "BizChatUserInfo update");
        if (jVar == null) {
            x.w("MicroMsg.BizChatUserInfoStorage", "update wrong argument");
            return false;
        }
        if (jVar == null || bh.ov(jVar.field_userName)) {
            x.i("MicroMsg.BizChatUserInfoStorage", "dealWithChatNamePY null");
        } else {
            jVar.field_userNamePY = com.tencent.mm.platformtools.c.ol(jVar.field_userName);
        }
        boolean a = super.a(jVar);
        if (!a) {
            return a;
        }
        b bVar = new b();
        bVar.userId = jVar.field_userId;
        bVar.hrr = a.hrp;
        bVar.hrs = jVar;
        this.hod.ca(bVar);
        this.hod.doNotify();
        return a;
    }

    public final j kx(String str) {
        if (str == null) {
            x.i("MicroMsg.BizChatUserInfoStorage", "getMyUserInfo brandUserName is null");
            return null;
        }
        String cb = cb(str);
        if (cb != null) {
            return ca(cb);
        }
        x.i("MicroMsg.BizChatUserInfoStorage", "getMyUserInfo myUserIdString is null");
        return null;
    }

    public final String cb(String str) {
        if (str == null) {
            x.i("MicroMsg.BizChatUserInfoStorage", "getMyUserId brandUserName is null");
            return null;
        }
        x.i("MicroMsg.BizChatUserInfoStorage", "getMyUserId:%s", str);
        if (this.hqH.containsKey(str) && this.hqH.get(str) != null) {
            return (String) this.hqH.get(str);
        }
        f kv = y.Mk().kv(str);
        if (kv != null) {
            x.d("MicroMsg.BizChatUserInfoStorage", "getMyUserId bizChatMyUserInfo brandUserName:%s,%s", str, kv.field_userId);
            this.hqH.put(str, kv.field_userId);
            return kv.field_userId;
        }
        x.w("MicroMsg.BizChatUserInfoStorage", "getMyUserId bizChatMyUserInfo == null brandUserName:%s", str);
        return null;
    }

    public final void c(j jVar) {
        x.i("MicroMsg.BizChatUserInfoStorage", "updateUserName");
        j ca = ca(jVar.field_userId);
        if (ca == null) {
            a(jVar);
        } else if (!bh.ov(jVar.field_userName) && !jVar.field_userName.equals(ca.field_userName)) {
            ca.field_userName = jVar.field_userName;
            b(ca);
        }
    }

    public static String a(String[] strArr, List<String> list) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(" 1=1 ");
        String str = "";
        if (list != null && list.size() > 0) {
            String str2 = str;
            for (String str3 : list) {
                str2 = str2 + " and userId != '" + str3 + "'";
            }
            str3 = str2;
        }
        stringBuilder.append(str3);
        stringBuilder.append(" and ");
        stringBuilder.append("userId in(");
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                stringBuilder.append(" , ");
            }
            stringBuilder.append(" '").append(strArr[i]).append("' ");
        }
        stringBuilder.append(" )");
        return stringBuilder.toString();
    }
}
