package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class t extends i<s> implements k {
    public static final String[] gJN = new String[]{i.a(s.gJc, "snsTagInfo2")};
    private e gJP;

    public t(e eVar) {
        super(eVar, s.gJc, "snsTagInfo2", null);
        this.gJP = eVar;
    }

    public final s eT(long j) {
        String stringBuilder = new StringBuilder("select *, rowid from snsTagInfo2 where tagId = ? ").toString();
        Cursor a = this.gJP.a(stringBuilder, new String[]{String.valueOf(j)}, 2);
        s sVar = new s();
        if (a.moveToFirst()) {
            sVar.b(a);
        }
        a.close();
        return sVar;
    }

    public final List<String> eo(long j) {
        s eT = eT(j);
        if (eT.field_memberList == null || eT.field_memberList.equals("")) {
            return new ArrayList();
        }
        return bh.F(eT.field_memberList.split(","));
    }

    public final String ep(long j) {
        return eT(j).field_tagName;
    }

    public final List<Long> byR() {
        Cursor a = this.gJP.a("snsTagInfo2", new String[]{"tagId"}, null, null, null, null, null, 2);
        List<Long> arrayList = new ArrayList();
        while (a.moveToNext()) {
            arrayList.add(Long.valueOf(a.getLong(0)));
        }
        a.close();
        return arrayList;
    }

    public final boolean a(s sVar) {
        if (sVar.field_tagId == 0) {
            return false;
        }
        long j = sVar.field_tagId;
        String stringBuilder = new StringBuilder("select *, rowid from snsTagInfo2 where tagId = ? ").toString();
        Cursor a = this.gJP.a(stringBuilder, new String[]{String.valueOf(j)}, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        if (moveToFirst) {
            super.a(sVar);
        } else {
            super.b(sVar);
        }
        return true;
    }

    public final int eU(long j) {
        return this.gJP.delete("snsTagInfo2", " tagId = ? ", new String[]{String.valueOf(j)});
    }

    public final boolean p(long j, String str) {
        String str2 = "select tagId, tagName, count, rowid from snsTagInfo2 where tagId > 5" + " AND  tagName  =\"" + bh.ot(str) + "\" AND  tagId != " + j;
        x.d("MicroMsg.SnsTagInfoStorage", "isTagNameExist " + str2);
        Cursor a = this.gJP.a(str2, null, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        return moveToFirst;
    }

    public final Cursor getCursor() {
        return this.gJP.rawQuery(new StringBuilder("select *, rowid from snsTagInfo2 where tagId > 5").toString(), null);
    }

    public final boolean Y(String str, long j) {
        s eT = eT(5);
        if (bh.ov(eT.field_memberList)) {
            return false;
        }
        return bh.F(eT.field_memberList.split(",")).contains(str);
    }

    public final boolean bui() {
        if (byR().size() == 0) {
            return false;
        }
        return true;
    }
}
