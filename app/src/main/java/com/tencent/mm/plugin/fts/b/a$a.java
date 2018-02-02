package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;

class a$a extends a {
    final /* synthetic */ a mMS;
    private int mos;
    private int mot;

    private a$a(a aVar) {
        this.mMS = aVar;
        this.mos = 0;
        this.mot = 0;
    }

    public final boolean execute() {
        x.i("MicroMsg.FTS.FTS5SearchContactLogic", "Start building chatroom index.");
        HashSet hashSet = new HashSet();
        Cursor rawQuery = a.a(this.mMS).mJR.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers;", null);
        while (rawQuery.moveToNext()) {
            hashSet.add(rawQuery.getString(0));
        }
        rawQuery.close();
        Cursor h = a.d(this.mMS).h("SELECT chatroomname, memberlist FROM chatroom;", null);
        int i = 5;
        while (h.moveToNext()) {
            if (Thread.interrupted()) {
                h.close();
                a.a(this.mMS).commit();
                throw new InterruptedException();
            }
            String string = h.getString(0);
            Object split = c.a.mKw.split(h.getString(1));
            a.f(this.mMS).put(string, split);
            if (!hashSet.remove(string)) {
                if (i >= 5) {
                    a.a(this.mMS).commit();
                    a.a(this.mMS).beginTransaction();
                    i = 0;
                }
                a.a(this.mMS).j(string, split);
                i++;
                this.mos++;
            }
        }
        h.close();
        a.a(this.mMS).commit();
        Iterator it = hashSet.iterator();
        int i2 = 5;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (i2 >= 5) {
                a.a(this.mMS).commit();
                a.a(this.mMS).beginTransaction();
                i2 = 0;
            }
            a.a(this.mMS).Bp(str);
            i = i2 + 1;
            this.mot++;
            i2 = i;
        }
        a.a(this.mMS).commit();
        return true;
    }

    public final String getName() {
        return "BuildChatroomIndexTask";
    }

    public final String ado() {
        return String.format("{new: %d removed: %d}", new Object[]{Integer.valueOf(this.mos), Integer.valueOf(this.mot)});
    }

    public final int getId() {
        return 3;
    }
}
