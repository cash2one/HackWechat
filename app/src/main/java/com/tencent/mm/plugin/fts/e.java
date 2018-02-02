package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.storage.x;
import java.util.ArrayList;
import java.util.List;

public final class e implements i {
    public final Cursor h(String str, String[] strArr) {
        g.Dk();
        return g.Dj().gQk.a(str, strArr, 2);
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        g.Dk();
        return g.Dj().gQk.a(str, strArr, 0);
    }

    public final x AW(String str) {
        x WJ = ((h) g.h(h.class)).EY().WJ(str);
        if (WJ == null) {
            WJ = new x();
            Cursor h = h("SELECT ROWID, username, alias, conRemark, nickname, verifyFlag, type, lvbuff, contactLabelIds FROM rcontact WHERE username = ? AND deleteFlag=0;", new String[]{str});
            if (h.moveToNext()) {
                WJ.gJd = h.getLong(0);
                WJ.setUsername(h.getString(1));
                WJ.cZ(h.getString(2));
                WJ.da(h.getString(3));
                WJ.dc(h.getString(4));
                WJ.ez(h.getInt(5));
                WJ.setType(h.getInt(6));
                WJ.z(h.getBlob(7));
                WJ.dj(h.getString(8));
                WJ.eB(0);
            }
            h.close();
        }
        return WJ;
    }

    public final boolean AX(String str) {
        Cursor h = h(String.format("SELECT 1 FROM rconversation WHERE username = ?", new Object[0]), new String[]{str});
        try {
            boolean moveToNext = h.moveToNext();
            return moveToNext;
        } finally {
            if (h != null) {
                h.close();
            }
        }
    }

    public final long AY(String str) {
        Cursor h = h("SELECT conversationTime FROM rconversation WHERE username=?;", new String[]{str});
        long j = 0;
        if (h != null && h.moveToFirst()) {
            j = h.getLong(0);
        }
        if (h != null) {
            h.close();
        }
        return j;
    }

    public final List<String> AZ(String str) {
        List arrayList = new ArrayList();
        if (str.endsWith("\u0000")) {
            str = str.substring(0, str.length() - 1);
        }
        if (str.length() != 0) {
            Cursor h = h(String.format("SELECT labelName FROM ContactLabel WHERE labelID IN (%s);", new Object[]{str}), null);
            while (h.moveToNext()) {
                arrayList.add(h.getString(0));
            }
            h.close();
        }
        return arrayList;
    }
}
