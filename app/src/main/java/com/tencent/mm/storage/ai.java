package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.a.f;
import com.tencent.mm.by.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class ai extends j implements b {
    public static final String[] gJN = new String[]{"CREATE TABLE IF NOT EXISTS DeletedConversationInfo ( userName TEXT  PRIMARY KEY , lastSeq LONG  , reserved1 INT  , reserved2 LONG  , reserved3 TEXT  ) ", "CREATE INDEX IF NOT EXISTS createTimeIndex  ON DeletedConversationInfo ( reserved2 )"};
    private final f<String, Long> hdO = new f(50);
    private h hhp;

    public ai(h hVar) {
        this.hhp = hVar;
    }

    public final boolean C(String str, long j) {
        if (bh.ov(str)) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", str);
        contentValues.put("lastSeq", Long.valueOf(j));
        if (((int) this.hhp.replace("DeletedConversationInfo", "userName", contentValues)) == -1) {
            return false;
        }
        Wc(str);
        return true;
    }

    public final long Er(String str) {
        if (bh.ov(str)) {
            return 0;
        }
        Cursor a = this.hhp.a("select lastSeq from DeletedConversationInfo where userName = \"" + bh.ot(str) + "\"", null, 2);
        if (a == null) {
            x.i("MicroMsg.DeletedConversationInfoStorage", "getLastSeq failed " + str);
            return 0;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            a.close();
            return j;
        } else {
            a.close();
            return 0;
        }
    }

    public final boolean D(String str, long j) {
        if (bh.ov(str)) {
            return false;
        }
        this.hdO.l(str, Long.valueOf(j));
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", str);
        contentValues.put("reserved2", Long.valueOf(j));
        if (((int) this.hhp.replace("DeletedConversationInfo", "userName", contentValues)) == -1) {
            return false;
        }
        Wc(str);
        return true;
    }

    public final List<String> aZk() {
        List arrayList = new ArrayList();
        Cursor a = this.hhp.a("select userName,reserved2 from DeletedConversationInfo where reserved2 > 0", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                do {
                    String string = a.getString(0);
                    this.hdO.l(string, Long.valueOf(a.getLong(1)));
                    arrayList.add(string);
                } while (a.moveToNext());
            }
            a.close();
        }
        return arrayList;
    }

    public final long Es(String str) {
        if (bh.ov(str)) {
            return 0;
        }
        Long l = (Long) this.hdO.get(str);
        if (l != null) {
            return l.longValue();
        }
        Cursor a = this.hhp.a("select reserved2 from DeletedConversationInfo where userName = \"" + bh.ot(str) + "\"", null, 2);
        if (a == null) {
            x.i("MicroMsg.DeletedConversationInfoStorage", "getCreateTime failed " + str);
            this.hdO.l(str, Long.valueOf(0));
            return 0;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            this.hdO.l(str, Long.valueOf(j));
            a.close();
            return j;
        } else {
            a.close();
            return 0;
        }
    }
}
