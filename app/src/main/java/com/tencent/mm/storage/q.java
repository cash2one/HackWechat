package com.tencent.mm.storage;

import com.tencent.mm.g.b.ae;
import com.tencent.mm.i.a.a.b;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class q extends ae {
    protected static a gJc;
    public Map<String, b> hqH = new HashMap();
    private com.tencent.mm.i.a.a.a xmx = new com.tencent.mm.i.a.a.a();
    public com.tencent.mm.i.a.a.a xmy = this.xmx;
    private List<String> xmz = new LinkedList();

    static {
        a aVar = new a();
        aVar.hSY = new Field[18];
        aVar.columns = new String[19];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "chatroomname";
        aVar.xjA.put("chatroomname", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" chatroomname TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "chatroomname";
        aVar.columns[1] = "addtime";
        aVar.xjA.put("addtime", "LONG");
        stringBuilder.append(" addtime LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "memberlist";
        aVar.xjA.put("memberlist", "TEXT");
        stringBuilder.append(" memberlist TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "displayname";
        aVar.xjA.put("displayname", "TEXT");
        stringBuilder.append(" displayname TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "chatroomnick";
        aVar.xjA.put("chatroomnick", "TEXT");
        stringBuilder.append(" chatroomnick TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "roomflag";
        aVar.xjA.put("roomflag", "INTEGER");
        stringBuilder.append(" roomflag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "roomowner";
        aVar.xjA.put("roomowner", "TEXT");
        stringBuilder.append(" roomowner TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "roomdata";
        aVar.xjA.put("roomdata", "BLOB");
        stringBuilder.append(" roomdata BLOB");
        stringBuilder.append(", ");
        aVar.columns[8] = "isShowname";
        aVar.xjA.put("isShowname", "INTEGER");
        stringBuilder.append(" isShowname INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "selfDisplayName";
        aVar.xjA.put("selfDisplayName", "TEXT");
        stringBuilder.append(" selfDisplayName TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "style";
        aVar.xjA.put("style", "INTEGER");
        stringBuilder.append(" style INTEGER");
        stringBuilder.append(", ");
        aVar.columns[11] = "chatroomdataflag";
        aVar.xjA.put("chatroomdataflag", "INTEGER");
        stringBuilder.append(" chatroomdataflag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "modifytime";
        aVar.xjA.put("modifytime", "LONG");
        stringBuilder.append(" modifytime LONG");
        stringBuilder.append(", ");
        aVar.columns[13] = "chatroomnotice";
        aVar.xjA.put("chatroomnotice", "TEXT");
        stringBuilder.append(" chatroomnotice TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "chatroomVersion";
        aVar.xjA.put("chatroomVersion", "INTEGER");
        stringBuilder.append(" chatroomVersion INTEGER");
        stringBuilder.append(", ");
        aVar.columns[15] = "chatroomnoticeEditor";
        aVar.xjA.put("chatroomnoticeEditor", "TEXT");
        stringBuilder.append(" chatroomnoticeEditor TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "chatroomnoticePublishTime";
        aVar.xjA.put("chatroomnoticePublishTime", "LONG");
        stringBuilder.append(" chatroomnoticePublishTime LONG");
        stringBuilder.append(", ");
        aVar.columns[17] = "chatroomLocalVersion";
        aVar.xjA.put("chatroomLocalVersion", "LONG");
        stringBuilder.append(" chatroomLocalVersion LONG");
        aVar.columns[18] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public final List<String> Ms() {
        if (this.xmz == null || this.xmz.size() == 0) {
            this.xmz = Ww(this.field_memberlist);
        }
        return this.xmz;
    }

    private void a(com.tencent.mm.i.a.a.a aVar) {
        if (this.field_roomdata == null) {
            aVar = new com.tencent.mm.i.a.a.a();
        }
        Iterator it = aVar.gBH.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            this.hqH.put(bVar.userName, bVar);
        }
    }

    public final void chP() {
        if (!bh.bw(this.field_roomdata)) {
            try {
                this.xmy = (com.tencent.mm.i.a.a.a) new com.tencent.mm.i.a.a.a().aF(this.field_roomdata);
            } catch (Exception e) {
                this.xmy = new com.tencent.mm.i.a.a.a();
            }
            a(this.xmy);
        }
    }

    public final boolean b(com.tencent.mm.i.a.a.a aVar) {
        return this.xmx.bke() == aVar.bke();
    }

    public final b Wu(String str) {
        if (this.hqH.size() <= 0) {
            chP();
        }
        if (this.hqH.containsKey(str)) {
            return (b) this.hqH.get(str);
        }
        return null;
    }

    public final int chQ() {
        if (b(this.xmy)) {
            chP();
        }
        return this.xmy.fAZ;
    }

    public final boolean chR() {
        if (b(this.xmy)) {
            chP();
        }
        return this.xmy.fAZ < this.xmy.gBK;
    }

    public static boolean chS() {
        return false;
    }

    public final void ga(int i) {
        this.field_chatroomdataflag = (this.xmy.fDt & -3) | (i & 2);
    }

    public final int chT() {
        if (b(this.xmy)) {
            chP();
        }
        return this.xmy.type;
    }

    public final int chU() {
        if (b(this.xmy)) {
            chP();
        }
        return this.xmy.gBI;
    }

    public final String gu(String str) {
        b Wu = Wu(str);
        if (Wu == null) {
            return "";
        }
        return bh.az(Wu.gBL, "");
    }

    public final q lG(boolean z) {
        this.field_isShowname = z ? 1 : 0;
        return this;
    }

    public final boolean chV() {
        return this.field_isShowname > 0;
    }

    private static int KP(String str) {
        int i = 0;
        try {
            i = bh.getInt(str, 0);
        } catch (Exception e) {
            if (str != null) {
                x.e("MicroMsg.ChatRoomMember", "parserInt error " + str);
            }
        }
        return i;
    }

    private static com.tencent.mm.i.a.a.a Wv(String str) {
        com.tencent.mm.i.a.a.a aVar = new com.tencent.mm.i.a.a.a();
        if (bh.ov(str)) {
            return aVar;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        Map y = bi.y(str, "RoomData");
        if (y == null) {
            x.e("MicroMsg.ChatRoomMember", "parse RoomData failed");
            return null;
        }
        int i = 0;
        while (true) {
            try {
                Object obj;
                Object obj2;
                Object obj3;
                String str2;
                b bVar = new b();
                if (i == 0) {
                    obj = ".RoomData.Member.$UserName";
                    obj2 = ".RoomData.Member.DisplayName";
                    obj3 = ".RoomData.Member.Flag";
                } else if (i != 0) {
                    String str3 = ".RoomData.Member" + i + ".$UserName";
                    String str4 = ".RoomData.Member" + i + ".DisplayName";
                    String str5 = ".RoomData.Member" + i + ".Flag";
                    str2 = str3;
                    str3 = str4;
                    str4 = str5;
                } else {
                    obj3 = null;
                    obj2 = null;
                    obj = null;
                }
                str2 = bh.az((String) y.get(obj), "");
                if (bh.ov(str2)) {
                    aVar.type = KP((String) y.get(".RoomData.Type"));
                    aVar.status = KP((String) y.get(".RoomData.Status"));
                    aVar.gBI = KP((String) y.get(".RoomData.MaxCount"));
                    aVar.gBJ = bh.az((String) y.get(".RoomData.ExtInfo.Upgrader"), "");
                    return aVar;
                }
                bVar.userName = str2;
                bVar.gBL = bh.az((String) y.get(obj2), "");
                bVar.gBM = KP((String) y.get(obj3));
                aVar.gBH.add(bVar);
                i++;
            } catch (Exception e) {
                return aVar;
            }
        }
    }

    public static List<String> Ww(String str) {
        List<String> linkedList = new LinkedList();
        if (bh.ov(str)) {
            return linkedList;
        }
        String[] split = str.split(";");
        for (Object add : split) {
            linkedList.add(add);
        }
        return linkedList;
    }

    public final q cD(List<String> list) {
        String str;
        if (list == null || list.size() == 0) {
            str = "";
        } else {
            str = "";
            for (int i = 0; i < list.size(); i++) {
                str = str + ((String) list.get(i));
                if (i < list.size() - 1) {
                    str = str + ";";
                }
            }
        }
        this.field_memberlist = str;
        return this;
    }

    public final q fC(String str, String str2) {
        return a(str, Wv(str2), false);
    }

    public final q a(String str, com.tencent.mm.i.a.a.a aVar, boolean z) {
        this.field_modifytime = System.currentTimeMillis();
        if (!z) {
            int i;
            b bVar = null;
            Iterator it = aVar.gBH.iterator();
            while (it.hasNext()) {
                b bVar2 = (b) it.next();
                if (bVar2.userName == null || !bVar2.userName.equals(str)) {
                    bVar2 = bVar;
                }
                bVar = bVar2;
            }
            if (bVar != null) {
                this.field_selfDisplayName = bVar.gBL;
                this.field_isShowname = bVar.gBM & 1;
                i = bVar.gBM;
            } else {
                i = 0;
            }
            x.d("MicroMsg.ChatRoomMember", "displayName[%s] roomFlag[%d] flag[%d]", this.field_selfDisplayName, Integer.valueOf(this.field_chatroomdataflag), Integer.valueOf(i));
            aVar.fDt = (i & 2) | (aVar.fDt & -3);
            this.field_chatroomdataflag = aVar.fDt;
        }
        try {
            this.field_roomdata = aVar.toByteArray();
            this.xmy = aVar;
        } catch (Throwable e) {
            x.e("MicroMsg.ChatRoomMember", "exception:%s", bh.i(e));
        }
        a(aVar);
        return this;
    }

    public final com.tencent.mm.i.a.a.a chW() {
        if (b(this.xmy)) {
            chP();
        }
        return this.xmy;
    }
}
