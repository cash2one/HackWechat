package com.tencent.mm.z;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.x;

public final class k {
    public static int FO() {
        if (g.Dh().Cy()) {
            int i;
            Cursor ciJ = ((h) g.h(h.class)).Fd().ciJ();
            if (ciJ == null || ciJ.getCount() <= 0) {
                i = 0;
            } else {
                ciJ.moveToFirst();
                i = ciJ.getInt(0);
            }
            if (ciJ == null) {
                return i;
            }
            ciJ.close();
            return i;
        }
        x.w("MicroMsg.BottleConversationLogic", "get Bottle Total Conversation Unread, but has not set uin");
        return 0;
    }
}
