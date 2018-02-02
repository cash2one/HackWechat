package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.by.g;
import com.tencent.mm.by.g.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ae;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class r extends i<q> implements a, ae {
    public static final String[] fMK = new String[]{"CREATE INDEX IF NOT EXISTS serverChatRoomUserIndex ON chatroom ( chatroomname )"};
    public static final String[] gJN = new String[]{i.a(q.gJc, "chatroom")};
    private e gJP;

    public final /* synthetic */ boolean a(c cVar) {
        q qVar = (q) cVar;
        if (super.a(qVar)) {
            Wc(qVar.field_chatroomname);
            return true;
        }
        x.w("MicroMsg.ChatroomStorage", "replace error");
        return false;
    }

    public r(e eVar) {
        super(eVar, q.gJc, "chatroom", fMK);
        this.gJP = eVar;
    }

    public final q hD(String str) {
        c qVar = new q();
        qVar.field_chatroomname = str;
        return super.b(qVar, "chatroomname") ? qVar : null;
    }

    public final q hE(String str) {
        c qVar = new q();
        qVar.field_chatroomname = str;
        return super.b(qVar, "chatroomname") ? qVar : qVar;
    }

    public final void l(String str, long j) {
        this.gJP.fx("chatroom", "update chatroom set modifytime = " + j + " where chatroomname = '" + bh.ot(str) + "'");
    }

    public final String hF(String str) {
        Assert.assertTrue(str.length() > 0);
        Cursor a = this.gJP.a("select roomowner from chatroom where chatroomname='" + bh.ot(str) + "'", null, 2);
        if (a == null) {
            x.e("MicroMsg.ChatroomStorage", "getChatroomOwner fail, cursor is null");
            return null;
        }
        q qVar;
        if (a.moveToFirst()) {
            qVar = new q();
            qVar.b(a);
        } else {
            qVar = null;
        }
        a.close();
        if (qVar != null) {
            return qVar.field_roomowner;
        }
        return null;
    }

    public final String hG(String str) {
        q qVar;
        Assert.assertTrue(str.length() > 0);
        Cursor a = this.gJP.a("select memberlist from chatroom where chatroomname='" + bh.ot(str) + "'", null, 2);
        if (a.moveToFirst()) {
            qVar = new q();
            qVar.b(a);
        } else {
            qVar = null;
        }
        a.close();
        if (qVar == null) {
            return null;
        }
        return qVar.field_memberlist;
    }

    public final String gu(String str) {
        q qVar;
        Assert.assertTrue(str.length() > 0);
        Cursor a = this.gJP.a("select displayname from chatroom where chatroomname='" + bh.ot(str) + "'", null, 2);
        if (a.moveToFirst()) {
            qVar = new q();
            qVar.b(a);
        } else {
            qVar = null;
        }
        a.close();
        if (qVar == null) {
            return null;
        }
        return qVar.field_displayname;
    }

    public final List<String> hH(String str) {
        String hG = hG(str);
        if (hG == null) {
            return null;
        }
        List<String> linkedList = new LinkedList();
        if (!hG.equals("")) {
            String[] split = hG.split(";");
            for (Object add : split) {
                linkedList.add(add);
            }
        }
        return linkedList;
    }

    public final boolean hI(String str) {
        q qVar = null;
        Cursor a = this.gJP.a("select * from chatroom where chatroomname='" + bh.ot(str) + "'", null, 2);
        if (a.moveToFirst()) {
            qVar = new q();
            qVar.b(a);
        }
        a.close();
        return qVar != null && (qVar.field_roomflag & 1) == 0;
    }

    public final boolean hJ(String str) {
        Assert.assertTrue(str.length() > 0);
        if (this.gJP.delete("chatroom", "chatroomname=?", new String[]{str}) == 0) {
            return false;
        }
        Wc(str);
        return true;
    }

    public final int a(g gVar) {
        return 0;
    }
}
