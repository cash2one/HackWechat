package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.g.b.de;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends i<i> implements d {
    public static final String[] gJN = new String[]{i.a(i.gJc, "SnsComment")};
    public h hhp;

    public j(h hVar) {
        super(hVar, i.gJc, "SnsComment", de.fMK);
        this.hhp = hVar;
    }

    public static String bya() {
        return "select *, rowid from SnsComment";
    }

    public final int Tq() {
        int i = 0;
        Cursor a = this.hhp.a(" select count(*) from SnsComment where isRead = ? and isSilence != ? ", new String[]{"0", "1"}, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        return i;
    }

    public final Cursor byb() {
        String stringBuilder = new StringBuilder("select *, rowid from SnsComment where isRead = ?  and isSilence != ?  order by createTime desc").toString();
        return this.hhp.a(stringBuilder, new String[]{"0", "1"}, 0);
    }

    public final boolean a(long j, String str, int i, String str2) {
        String str3;
        if (bh.ov(str2)) {
            str3 = "select count(*) from SnsComment where snsID = " + j + " and createTime = " + i + " and talker = '" + str + "'";
        } else {
            str3 = "select count(*) from SnsComment where snsID = " + j + " and clientId = '" + str2 + "'";
        }
        Cursor rawQuery = rawQuery(str3, new String[0]);
        if (rawQuery == null) {
            return false;
        }
        rawQuery.moveToFirst();
        int i2 = rawQuery.getInt(0);
        rawQuery.close();
        if (i2 > 0) {
            return true;
        }
        return false;
    }

    public final int byc() {
        Cursor rawQuery = rawQuery(new StringBuilder("select count(*) from SnsComment where isSend = 0").toString(), new String[0]);
        if (rawQuery == null) {
            return 0;
        }
        rawQuery.moveToFirst();
        int i = rawQuery.getInt(0);
        rawQuery.close();
        return i;
    }

    public final i c(long j, long j2, int i) {
        int i2;
        if (i == 9) {
            i2 = 2;
        } else {
            i2 = i;
        }
        if (i2 == 10) {
            i2 = 8;
        }
        Cursor rawQuery = rawQuery("select *, rowid from SnsComment where snsID = " + j + " and commentSvrID = " + j2 + " and type = " + i2, new String[0]);
        if (rawQuery == null) {
            return null;
        }
        i iVar;
        if (rawQuery.moveToFirst()) {
            iVar = new i();
            iVar.b(rawQuery);
        } else {
            iVar = null;
        }
        rawQuery.close();
        return iVar;
    }

    public final boolean eM(long j) {
        return this.hhp.fx("SnsComment", "delete from SnsComment where snsID = " + j);
    }

    public final boolean d(long j, long j2, int i) {
        int i2;
        if (i == 9) {
            i2 = 2;
        } else {
            i2 = i;
        }
        if (i2 == 10) {
            i2 = 8;
        }
        return this.hhp.fx("SnsComment", "delete from SnsComment where snsID = " + j + " and commentSvrID = " + j2 + " and type = " + i2);
    }

    public final boolean auv() {
        return this.hhp.fx("SnsComment", " update SnsComment set isRead = 1 where isRead = 0");
    }

    public final boolean q(long j, boolean z) {
        int i = z ? 1 : 0;
        String str = " update SnsComment set isSilence = " + i + " where isSilence != " + i + " and  snsID = " + j;
        x.i("MicroMsg.SnsCommentStorage", "updateIsSilence " + str);
        return this.hhp.fx("SnsComment", str);
    }

    public final void byd() {
        this.hhp.Yi("SnsComment");
    }
}
